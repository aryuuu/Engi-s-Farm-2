package com.map;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Map{

    private Vector<Vector<Cell>> map;

    public Map(Vector<Vector<Cell>> map) {
        this.map = map;
    }

    public Map(String namafile) {
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File(namafile));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        map = new Vector<Vector<Cell>>();
        int line = 0;

        while (inFile.hasNextLine()) {
            String s = inFile.nextLine();


            map.add(new Vector<Cell>());

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'o') {
                    map.get(line).add(new Land(i, line, false, "Coop"));
                } else if (s.charAt(i) == 'x') {
                    map.get(line).add(new Land(i, line, false, "Barn"));
                } else if (s.charAt(i) == '-') {
                    map.get(line).add(new Land(i, line, false, "Grassland"));
                } else if (s.charAt(i) == '*') {
                    map.get(line).add(new Land(i, line, true, "Coop"));
                } else if (s.charAt(i) == '@') {
                    map.get(line).add(new Land(i, line, true, "Barn"));
                } else if (s.charAt(i) == '#') {
                    map.get(line).add(new Land(i, line, true, "Grassland"));
                } else if (s.charAt(i) == 'T') {
                    map.get(line).add(new Truck(i, line));
                } else if (s.charAt(i) == 'W') {
                    map.get(line).add(new Well(i, line));
                } else if (s.charAt(i) == 'M') {
                    map.get(line).add(new Mixer(i, line));
                } else {
                    System.out.println("Error Reading");
                }

                System.out.print(s.charAt(i));
            }
            System.out.println();
            line++;
        }
    }

        public void print(){
            for(int i = 0;i < this.map.size();i++){
                for(int j = 0;j < this.map.get(i).size();j++){
                    this.map.get(i).get(j).print();
                }
                System.out.println();
            }
        }

    }
