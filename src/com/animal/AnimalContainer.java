package com.animal;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;;

/**
 * file AnimalContainer.java
 * <p>
 *     Kelas yang menggambarkan penampung yang menyimpan setiap binatang farm yang masih hidup
 * </p>
 *
 * @author Jan Meyer Saragih / 13517131
 *
 * @version 1.0
 *`
 * @since 2019-04-14
 */
public class AnimalContainer
{
    // Atribut
    /**
     * Menggunakan Java Collections ArrayList untuk menyimpan semua animal dalam farm
     */
    private ArrayList<Animal> animals;

    // Method

    // Konstruktor

    /**
     * Konstruktor dari kelas AnimalContainer
     * 
     * <p>
     *    Membuat ArrayList of animal baru yang menyimpan data setiap animal yang masih hidup dalam sebuah farm
     * </p>
     */
    public AnimalContainer()
    {
        animals = new ArrayList<Animal>();
    }

    /**
     * Konstruktor berparameter dari kelas AnimalContainer
     * 
     * <p>
     *    Membuat ArrayList of animal baru yang menyimpan data setiap animal yang masih hidup dalam sebuah farm
     * </p>
     *
     * @param filename - nama file yang mengandung semua animal di animalContainer
     */
    public AnimalContainer(String filename)
    {
        animals = new ArrayList<Animal>();

        try {
            File file = new File (filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                String[] linePart = line.split(" ");
                
                if (linePart[0].equals("Chicken"))
                {
                    int x = Integer.parseInt(linePart[1]);
                    int y = Integer.parseInt(linePart[2]);
                    Chicken a = new Chicken(x, y);
                    animals.add(a);
                }
                else if (linePart[0].equals("Cow"))
                {
                    int x = Integer.parseInt(linePart[1]);
                    int y = Integer.parseInt(linePart[2]);
                    Cow a = new Cow(x, y);
                    animals.add(a);
                }
                else if (linePart[0].equals("Duck"))
                {
                    int x = Integer.parseInt(linePart[1]);
                    int y = Integer.parseInt(linePart[2]);
                    Duck a = new Duck(x, y);
                    animals.add(a);
                }
                else if (linePart[0].equals("Goat"))
                {
                    int x = Integer.parseInt(linePart[1]);
                    int y = Integer.parseInt(linePart[2]);
                    Goat a = new Goat(x, y);
                    animals.add(a);
                }
                else if (linePart[0].equals("Horse"))
                {
                    int x = Integer.parseInt(linePart[1]);
                    int y = Integer.parseInt(linePart[2]);
                    Horse a = new Horse(x, y);
                    animals.add(a);
                }
                else if (linePart[0].equals("Rabbit"))
                {
                    int x = Integer.parseInt(linePart[1]);
                    int y = Integer.parseInt(linePart[2]);
                    Rabbit a = new Rabbit(x, y);
                    animals.add(a);
                }
                else {
                    System.out.println("Animal tidak terdaftar -> nama dari file: " + linePart[0]);
                }
            }
            
            fileReader.close();
                     

        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Isi file tidak berguna");
            e.printStackTrace();
        }

        
    }

    // Getter-setter

    /**
     * Getter sebuah dari AnimalContainer, mendapatkan indeks ke-i
     * @param i - indeks animal, syarat: minimal 0 dan kurang dari jumlah animal
     * @return - animal pada indeks ke-i
     */
    public Animal getAnimal(int i)
    {
        assert (i >= 0 && i < animals.size()): "Indeks tidak valid";
        return this.animals.get(i);
    }

    /**
     * Getter jumlah animal dalam AnimalContainer
     * @return = jumlah animal yang terdapat dalam AnimalContainer
     */
    public int getNumAnimal()
    {
        return this.animals.size();
    }

    /**
     * Setter dari sebuah AnimalContainer
     * @param i - indeks animal yang ingin diganti, syarat: minimal 0 dan kurang dari jumlah animal
     * @param ani - animal yang ingin diganti
     */
    public void setAnimal(int i, Animal ani)
    {
        assert (i >= 0 && i < animals.size()): "Indeks tidak valid";
        this.animals.set(i, ani);
    }

    // Method lain

    /**
     * Menambahkan animal baru ke dalam AnimalContainer
     * @param ani - Animal baru yang ingin ditambahkan
     */
    public void addAnimal(Animal ani)
    {
        this.animals.add(ani);
    }

    /**
     * Menghapus sebuah Animal dari dalam AnimalContainer
     * @param ani - animal yang ingin dihapus dari Animal Container
     */
    public void removeAnimal(Animal ani)
    {
        this.animals.remove(ani);
    }

    /**
     * Mengecek animal jika terdapat dalam posisi tersebut
     * @param x - Baris yang ingin dicek
     * @param y - Kolom yang ingin dicek
     * @return - Indeks dari animal di posisi tersebut, -1 jika tidak ada
     */
    public int animalOn(int x, int y)
    {
        Position pos = new Position(x, y);
        boolean found = false;
        int i = 0;
        while (i < animals.size() && !found)
        {
            if (animals.get(i).isPosition(pos.getRow(), pos.getColumn()))
            {
                found = true;
            }
            else
            {
                i++;
            }
        }

        if (!found)
        {
            i = -1;
        }
        return i;
    }

    /**
     * Mengecek animal jika terdapat dekat dengan posisi tersebut (atas, bawah, kiri, atau kanan)
     * @param x - Baris yang ingin dicek
     * @param y - Kolom yang ingin dicek
     * @return - Indeks dari animal di posisi tersebut, -1 jika tidak ada
     */
    public int animalNear(int x, int y)
    {
        Position pos = new Position(x, y);

        boolean found = false;
        int i = 0;
        while (i < animals.size() && !found)
        {
            if (animals.get(i).isNear(pos.getRow(), pos.getColumn()))
            {
                found = true;
            }
            else
            {
                i++;
            }
        }

        if (!found)
        {
            i = -1;
        }
        return i;
    }

    /**
     * Menaikkan counter kelaparan animal sebesar 1
     */
    public void allAnimalHungrier()
    {
        for (int i = 0; i < animals.size(); i++)
        {
            animals.get(i).hungrier();
            if (animals.get(i).getHungerCounter() >= 30)
            {
                animals.get(i).setHungry(true);
            }
        }
    }

    /**
     * Membunuh setiap animal yang layak mati (hungerCounter bernilai lebih atau sama dengan deadCounter)
     */
    public void killDeads()
    {
        int i = 0;
        while (i < animals.size())
        {
            if (animals.get(i).isDead())
            {
                animals.remove(i);
            }
            else
            {
                i++;
            }
        }
    }

    // Hanya untuk testing...
    // Jangan ditiru, nanti dihapus
    public void printAnimals()
    {
        for (int i = 0; i < animals.size(); i++)
        {
            System.out.println("Animal[" + (i + 1) + "]: " + animals.get(i).animalType() + "; (" + animals.get(i).getLocation().getRow() + "," + animals.get(i).getLocation().getColumn() + ")");
        }
    }
}