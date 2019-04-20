import com.Gameplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Render extends JPanel implements KeyListener, ActionListener {

    private  boolean play = false;
    private Gameplay game = new Gameplay("map.txt","farmAnimals.txt");

    private  Timer time;
    private  int delay = 1000;

    private int cellWidth = 32;
    private  int cellHeight = 32;

    private String log = "";

    public Render(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay,this);
        time.start();
    }

    public void paint(Graphics g){

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1360,1000);

        BufferedImage img = null;

        for(int i = 0;i < game.getFarmMap().getMaxRow();i++){
            for(int j = 0;j < game.getFarmMap().getMaxCol();j++){



                if(game.getFarmMap().getCell(i,j).getLegend() != "Land"){
                    g.setColor(Color.GREEN);
                    g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);

                    try
                    {
                        img = ImageIO.read( new File(game.getFarmMap().getCell(i,j).getLegend()+".png" ));
                        g.drawImage( img, j * cellWidth + 10, i * cellHeight + 10,this);

                    }
                    catch ( IOException exc )
                    {
                        //TODO: Handle exception.
                    }

                }else{
                    if(game.getFarmMap().getCell(i,j).getCategory() == "Coop"){
                        if(game.getFarmMap().getCell(i,j).isGrass()){
                            g.setColor(Color.LIGHT_GRAY);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);

                            g.setColor(Color.BLACK);
                            g.setFont(new Font("serif",Font.BOLD,10));
                            g.drawString("W",j * cellWidth + cellWidth/2,i * cellHeight +cellHeight );
                        }else{
                            g.setColor(Color.LIGHT_GRAY);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);
                        }
                    } else if(game.getFarmMap().getCell(i,j).getCategory() == "Barn"){
                        if(game.getFarmMap().getCell(i,j).isGrass()){
                            g.setColor(Color.YELLOW);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);

                            g.setColor(Color.BLACK);
                            g.setFont(new Font("serif",Font.BOLD,10));
                            g.drawString("W",j * cellWidth + cellWidth/2,i * cellHeight +cellHeight );
                        }else{
                            g.setColor(Color.YELLOW);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);
                        }
                    }else if(game.getFarmMap().getCell(i,j).getCategory() == "Grassland"){
                        if(game.getFarmMap().getCell(i,j).isGrass()){
                            g.setColor(Color.GREEN);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);

                            g.setColor(Color.BLACK);
                            g.setFont(new Font("serif",Font.BOLD,10));
                            g.drawString("W",j * cellWidth + cellWidth/2,i * cellHeight +cellHeight );
                        }else{
                            g.setColor(Color.GREEN);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);
                        }
                    }
                }



                if (game.getPlayer().getX() == i && game.getPlayer().getY() == j)
                {
                    try
                    {



                        img = ImageIO.read( new File("Player.png" ));
                        g.drawImage( img, j * cellWidth + 10, i * cellHeight + 10,this);

                    }
                    catch ( IOException exc )
                    {
                        //TODO: Handle exception.
                    }



                }
                else if (game.getFarmAnimals().animalOn(i, j) != -1)
                {
                    int x = game.getFarmAnimals().animalOn(i, j);
                    String type = game.getFarmAnimals().getAnimal(x).animalType();
                    try
                    {
                        if(game.getFarmAnimals().getAnimal(x).getHungry()){
                            g.setColor(Color.RED);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);
                        }

                        img = ImageIO.read( new File(type + ".png" ));
                        g.drawImage( img, j * cellWidth + 10, i * cellHeight + 10,this);

                    }
                    catch ( IOException exc )
                    {
                        //TODO: Handle exception.
                    }



                }






            }
        }

        g.setColor(Color.BLACK );
        g.setFont(new Font("sans serif",Font.BOLD,40));
        g.drawString("PLAYER",1000,50);

        g.setFont(new Font("sans serif",Font.BOLD,30));
        g.drawString("Money : " + game.getPlayer().getMoney(),1000,100);

        g.setFont(new Font("sans serif",Font.BOLD,30));
        g.drawString("Water : " + game.getPlayer().getWater(),1000,150);

        g.setFont(new Font("sans serif",Font.BOLD,30));
        g.drawString("Bag : ",1000,200);

        for(int i=1;i<=game.getPlayer().getSizeBag();i++){
            System.out.print(game.getPlayer().getBag(i).getNama());

            g.setFont(new Font("sans serif",Font.BOLD,20));
            g.drawString(game.getPlayer().getBag(i).getNama(),1000,200 + i * 30);

        }

        g.setFont(new Font("sans serif",Font.BOLD,20));
        g.drawString(log,300,900);

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        time.start();
        game.everyTurn();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            game.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            game.moveLeft();
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            game.moveRight();
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            game.moveDown();
        }

        if(e.getKeyCode() == KeyEvent.VK_G){
            game.grow();
        }

        if(e.getKeyCode() == KeyEvent.VK_T){
            game.talk();
        }

        if(e.getKeyCode() == KeyEvent.VK_I){
            game.interact();
        }

        if(e.getKeyCode() == KeyEvent.VK_K){
            game.kill();
        }

        if(e.getKeyCode() == KeyEvent.VK_M){
            game.mix();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
