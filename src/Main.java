import com.map.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Hello World!");
//        Map m = new Map("map.txt");
//        m.print();

        JFrame obj= new JFrame();
        Render render = new Render();
        obj.setBounds(10,10,1360,1000);
        obj.setTitle("Engis Farm");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(render);

    }
}