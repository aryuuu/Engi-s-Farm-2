package com.player;
import java.lang.String;
/**
 * file Player.java
 * <p>
 *     Kelas Player merepresentasikan Pemain
 * </p>
 *
 * @author Marsa Thoriq Ahmada / 13517071
 *
 * @version 1.0
 *`
 * @since 2019-04-20
 */
public class Player{
    // Atribut
    /**
     *  Atribut yang merupakan banyaknya air yang bisa digunakan untuk menyiram
     */
    private int water;
    /**
     *  Atribut yang merupakan banyaknya uang
     */
    private int money;
    /**
     *  Atribut yang merupakan posisi dari player dalam map
     */
    private int x,y;
    /**
     *  Atribut yang merupakan gambaran tas dari pemain
     */
    private Linkedlist<Product> bag = new Linkedlist<Product>();
    /**
     *  Konstanta maksimal air dalam gembor
     */
    private static final int MAXWATER=25;
    /**
     *  Konstanta maksimal isi tas dari pemain
     */
    private static final int MAXBAG=10;

    /**
     * Konstruktor dari class Player
     */

    public Player(){
        setMoney(0);
        setWater(0);
        setX(0);
        setY(0);
        delProductAll();
    }

    // Getter

    /**
     * getter dari water
     * @return water yang merupakan banyaknya air yang bisa digunakan untuk menyiram
     */
    public int getWater() //mengambil atribut water
    {
        return water;

    }

    /**
     * getter dari uang
     * @return money yang merupakan uang dari pemain
     */
    public int getMoney()//mengambil atribut money
    {
        return money;
    }
    /**
     * getter dari x
     * @return x merupakan posisi baris dari pemain
     */
    public int getX()//mengambil atribut x (posisi Absis player)
    {
        return x;
    }
    /**
     * getter dari y
     * @return y merupakan posisi kolom dari pemain
     */
    public int getY()//mengambil atribut y (posisi Ordinat player)
    {
        return y;
    }

    /**
     * getter dari bag
     * @param idx yang merupakan indeks posisi tas
     * @return bag.get(idx) Product pada posisi idx dalam tas
     */
    public Product getBag(int idx)////mengambil Product yang ada dalam LinkedList Bag pada indeks idx
    {
        return bag.get(idx);
    }

    /**
     * getter dari ukuran tas
     * @return bag.size() yang merupakan ukuran tas
     */
    public int getSizeBag() //Menghitung ukuran tas
    {
        return bag.size();
    }

    //setter

    /**
     * setter dari Water
     * @param water yang merupakan banyaknya air yang diset
     */
    public void setWater(int water) //mengubah nilai atribut water
    {
        this.water=water;
    }
    /**
     * setter dari Money
     * @param money yang merupakan uang dari pemain
     */
    public void setMoney(int money) //mengubah nilai atribut money
    {
        this.money=money;
    }
    /**
     * setter dari X
     * @param x yang merupakan posisi baris
     */
    public void setX(int x) //mengubah nilai atribut x (posisi Absis player)
    {
        this.x=x;
    }

    /**
     * setter dari Y
     * @param y yang meerupakan posisi kolom
     */
    public void setY(int y)//mengubah nilai atribut y (posisi Ordinat player)
    {
        this.y=y;
    }

    /**
     * method pergerakan pemain
     * @param move merupakan karakter pergerakan pemain
     */
    public void playerMove(char move) //Memindahkan posisi player ke atas / kanan / bawah / kiri dengan parameter input charr u/r/d/l dan posisi harus valid (harus divalidasi dulu)
    {
        if(move=='l'){
            y-=1;
        }else if(move=='r'){
            y+=1;
        }else if(move=='u'){
            x-=1;
        }else{
            x+=1;
        }
    }
    /**
     * Method untuk menghapus semua isi tas dan menambahkan uang
     */
    public void delProductAll() //Mengosongkan Bag
    {
        int harga=0;
        while(!bag.isEmpty()){
            harga+=bag.get(1).getHarga();
            bag.remove(1);
        }
        this.addMoney(harga);
    }

    /**
     * Method untuk mengurangi jumlah air dalam gembor sebanyak 1
     */
    public void reduceWater() //Mengkurangi atribut water yang ada didalam gebor (Alat penyiraman)
    {
        water-=1;
    }

    /**
     * Method untuk Menambahkan produk Prod
     * @param Prod merupakan produk yang ditambahkan
     */
    public void addProduct(Product Prod) //Menambahkan Product Prod ke Bag dan ditaruh di paling belakang
    {
        if (this.getSizeBag()<MAXBAG){
            bag.add(Prod);
        }else{
            System.out.println("Tas Penuh");
        }
    }

    /**
     * Method untuk menambahkan produk benama prod
     * @param Prod merupakan nama produk yang ditambahkan
     */
    public void addProduct(String Prod) //Menambahkan Nama Product Prod ke Bag dan ditaruh di paling belakang
    {
        int idxResep;
        if (Prod.equals("ButtermilkChicken")){
            //periksa apakah ButtermilChicken bisa dibuat
            if(this.isAvailable(Prod)){
                ButtermilkChicken X = new ButtermilkChicken();
                idxResep = 0;
                while(idxResep < X.getNResep()){ //hapus bahan dari inventori
                    for (int i = 1; i <= getSizeBag(); i++)
                    {
                        if (getBag(i).getNama().equals(X.getResep(idxResep)))
                        {
                            bag.remove(i);
                            break;
                        }
                    }
                    idxResep++;
                }

                this.addProduct(X);
            } else {
                System.out.println("Tidak cukup bahan");
            }

        } else if (Prod.equals("Omellete")){
            if(this.isAvailable(Prod)){
                Omellete X = new Omellete();
                idxResep = 0;
                while(idxResep < X.getNResep()){ //hapus bahan dari inventori
                    for (int i = 1; i <= getSizeBag(); i++)
                    {
                        if (getBag(i).getNama().equals(X.getResep(idxResep)))
                        {
                            bag.remove(i);
                            break;
                        }
                    }
                    idxResep++;
                    //System.out.println(idxResep);
                }
                this.addProduct(X);
            } else {
                System.out.println("Tidak cukup bahan");
            }
        } else if (Prod.equals("Meatball")){
            if(this.isAvailable(Prod)){
                Meatball X = new Meatball();
                idxResep = 0;
                while(idxResep < X.getNResep()){ //hapus bahan dari inventori
                    for (int i = 1; i <= getSizeBag(); i++)
                    {
                        if (getBag(i).getNama().equals(X.getResep(idxResep)))
                        {
                            bag.remove(i);
                            break;
                        }
                    }
                    idxResep++;
                }

                this.addProduct(X);
            } else {
                System.out.println("Tidak cukup bahan");
            }
        } else if (Prod.equals("ChickenEgg")){
            ChickenEgg X = new ChickenEgg();
            this.addProduct(X);
        } else if (Prod.equals("ChickenMeat")){
            ChickenMeat X = new ChickenMeat();
            this.addProduct(X);
        } else if (Prod.equals("CowMeat")){
            CowMeat X = new CowMeat();
            this.addProduct(X);
        } else if (Prod.equals("CowMilk")){
            CowMilk X = new CowMilk();
            this.addProduct(X);
        } else if (Prod.equals("DuckEgg")){
            DuckEgg X = new DuckEgg();
            this.addProduct(X);
        } else if (Prod.equals("HorseMilk")){
            HorseMilk X = new HorseMilk();
            this.addProduct(X);
        } else if (Prod.equals("RabbitMeat")){
            RabbitMeat X = new RabbitMeat();
            this.addProduct(X);
        };
    }

    /**
     * Method untuk mengisi air maksimal dalam gembor
     */
    public void addWater() //Mengisi gebor dengan air secara maksimal (sesuai kapasitas) dengan mengubah atribut water
    {
        water=MAXWATER;
    }

    /**
     * Method untuk menambah uang sebanyak harga
     * @param harga merupakan uang yang ditambahakan
     */
    public void addMoney(int harga) //Menambah atribut money sesuai dengan harga
    {
        money+=harga;
    }

    /**
     * Method megecek posisi
     * @param x posisi kolom
     * @param y posisi baris
     * @return boolean True jika posisi tersebut merupakan tempat player
     */
    public boolean isValid(int x,int y) //Mengecek Posisi tersebut ditempati player atau tidak mengembalikan true jika posisi tersebut ditempati player
    {
        return (this.getX()==x&&this.getY()==y);
    }

    /**
     * Method untuk mengecek apakah bisa membuat product
     * @param productname yang merupakan nama produk
     * @return boolean True jika productname bisa dibuat False jika tidak
     */
    public boolean isAvailable(String productname) //mengembalikan true jika SideProduct dengan nama productname bisa dibuat dengan inventori sekarang, false jika tidak
    {
        if(productname == "ButtermilkChicken"){
            ButtermilkChicken bmc = new ButtermilkChicken();
            int idxResep = 0;
            int idxbag;
            // int count = 0; //hitung jumlah bahan resep yang sudah ditemukan
            boolean found; //flag yang bernilai true jika bahan ditemukan
            while(idxResep < bmc.getNResep()){
                idxbag = 1; //index pointer ke bag
                found = false;
                while(idxbag <= this.getSizeBag() && !found){
                    if(this.getBag(idxbag).getNama() == bmc.getResep(idxResep)){//jika produk ditemukan
                        //idxbag = this.getSizeBag(); //skip loop
                        // count++; //tambah jumlah bahan yang sudah ditemukan
                        found = true;
                    } else { //jika belum
                        idxbag++; //maju satu index
                    }
                }
                if(found){ //jika produk ke-idxResep ditemukan
                    idxResep++; //maju
                } else { //jika tidak
                    return false;
                }
            }
            return true;

        } else if(productname == "Omellete"){
            Omellete om= new Omellete();
            int idxResep = 0;
            int idxbag;
            // int count = 0; //hitung jumlah bahan resep yang sudah ditemukan
            boolean found ; //flag yang bernilai true jika produk ditemukan
            while(idxResep < om.getNResep()){
                idxbag = 1;
                found = false;
                while(idxbag <= this.getSizeBag() && !found){
                    if(this.getBag(idxbag).getNama() == om.getResep(idxResep)){//jika produk ditemukan
//					idxbag = this.getSizeBag() ; //skip loop
                        // count++;
                        found = true;
                    } else { //jika belum
                        idxbag++; //maju satu index
                    }
                }
                if(found){
                    idxResep++;
                } else {
                    return false;
                }
            }
            return true;

        } else if(productname == "Meatball"){
            Meatball mb = new Meatball();
            int idxResep = 0;
            int idxbag;
            // int count = 0; //hitung jumlah bahan resep yang sudah ditemukan
            boolean found = false; //flag yang bernilai true jika bahan ditemukan
            while(idxResep < mb.getNResep()){
                idxbag = 1;
                found = false;//inisialisasi
                while(idxbag <= this.getSizeBag() && !found){
                    if(this.getBag(idxbag).getNama() == mb.getResep(idxResep)){//jika produk ditemukan
                        //		idxbag = this.getSizeBag(); //skip loop
                        // count++;
                        found = true;
                    } else { //jika belum
                        idxbag++; //maju satu index
                    }
                }
                if(found){
                    idxResep++;
                } else {
                    return false;
                }
            }
            return true;

        } else {
            return false;
        }
    }

    /**
     * Method untuk menulis inventori
     */
    public void print() //menulis inventori
    {
        System.out.print("Money	: ");
        System.out.println(this.getMoney());
        System.out.print("Water	: ");
        System.out.println(this.getWater());
        System.out.print("bag	    : ");

        for(int i=1;i<=this.getSizeBag();i++){
            System.out.print(this.getBag(i).getNama());
            if(i!=this.getSizeBag()){
                System.out.print(", ");
            }else{
                System.out.println();
            }
        }
    }
}
