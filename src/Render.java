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
    private  int delay = 8;

    private int cellWidth = 32;
    private  int cellHeight = 32;

    public Render(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay,this);
        time.start();
    }

    public void paint(Graphics g){

        BufferedImage img = null;

        for(int i = 0;i < game.getFarmMap().getMaxRow();i++){
            for(int j = 0;j < game.getFarmMap().getMaxCol();j++){



                if(game.getFarmMap().getCell(i,j).getLegend() != "Land"){
                    g.setColor(Color.GREEN);
                    g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);

                }else{
                    if(game.getFarmMap().getCell(i,j).getCategory() == "Coop"){
                        if(game.getFarmMap().getCell(i,j).isGrass()){
                            g.setColor(Color.GREEN);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);
                        }else{
                            g.setColor(Color.GREEN);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);
                        }
                    } else if(game.getFarmMap().getCell(i,j).getCategory() == "Barn"){
                        if(game.getFarmMap().getCell(i,j).isGrass()){
                            g.setColor(Color.GREEN);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);

                            g.setColor(Color.BLACK);
                            g.setFont(new Font("serif",Font.BOLD,10));
                            g.drawString("W",j * cellWidth + 20,i * cellHeight + 20);
                        }else{
                            g.setColor(Color.GREEN);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);
                        }
                    }else if(game.getFarmMap().getCell(i,j).getCategory() == "Grassland"){
                        if(game.getFarmMap().getCell(i,j).isGrass()){
                            g.setColor(Color.GREEN);
                            g.fillRect(j * cellWidth + 10, i * cellHeight + 10, cellWidth,cellHeight);
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
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
