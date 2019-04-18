package com.map;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Map{

    // Atribut

    private Vector<Vector<Cell>> map;

    // Konstruktor

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

    // Getter

    public int getMaxRow()
    {
        return this.map.size();
    }


    public int getMaxCol()
    {
        return this.map.get(0).size();
    }


    public Cell getCell(int row, int col)
    {
        assert(row >= 0 && row < this.map.size() && col >= 0 && col < this.map.get(0).size());
        return this.map.get(row).get(col);
    }

    // Fungsi lain

    public void print(){
        for(int i = 0;i < this.map.size();i++){
            for(int j = 0;j < this.map.get(i).size();j++){
                this.map.get(i).get(j).print();
            }
            System.out.println();
        }
    }


    public boolean isValidPos(int row, int col)
    {
        if (row >= 0 && row < this.map.size() && col >= 0 && col < this.map.get(0).size())
        {
            String temp = this.map.get(row).get(col).getLegend();
            return (temp != "Truck" && temp != "Mixer" && temp != "Well");
        }
        else
        {
            return false;
        }
    }


    public boolean isWithinArea(int row, int col)
    {
        return (row >= 0 && row < this.getMaxRow() && col >= 0 && col < this.getMaxCol());
    }


    public boolean isNear(int row, int col, String _legend)
    {
        if (isWithinArea(row, (col + 1)) && this.map.get(row).get(col + 1).getLegend() == _legend)
        {
            return true;
        }
        else if (isWithinArea((row + 1), col) && this.map.get(row + 1).get(col).getLegend() == _legend)
        {
            return true;
        }
        else if (isWithinArea((row - 1), col) && this.map.get(row - 1).get(col).getLegend() == _legend)
        {
            return true;
        }
        else if (isWithinArea(row, (col - 1)) && this.map.get(row).get(col - 1).getLegend() == _legend)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
