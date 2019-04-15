package com.player;
import java.lang.String;
public class Player{
    private int water;
    private int money;
    private int x,y;
    private LinkedList<Product> bag;
    private static final int MAXWATER=25;
    private static final int MAXBAG=25;
    public Player(){
        setMoney(0);
        setWater(0);
        setX(0);
        setY(0);
        delProductAll();
    }
    public int getWater() //mengambil atribut water
    {
        return water;
    }
    public int getMoney()//mengambil atribut money
    {
        return money;
    }
    public int getX()//mengambil atribut x (posisi Absis player)
    {
        return x;
    }
    public int getY()//mengambil atribut y (posisi Ordinat player)
    {
        return y;
    }
    public product getBag(int idx)////mengambil Product yang ada dalam LinkedList Bag pada indeks idx
    {
        return bag.get(idx);
    }
    public int getSizeBag() //Menghitung ukuran tas
    {
        return bag.size();
    }
    //setter
    public void setWater(int water) //mengubah nilai atribut water
    {
        this.water=water;
    }
    public void setMoney(int money) //mengubah nilai atribut money
    {
        this.money=money;
    }
    public void setX(int x) //mengubah nilai atribut x (posisi Absis player)
    {
        this.x=x;
    }
    public void setY(int y)//mengubah nilai atribut y (posisi Ordinat player)
    {
        this.y=y;
    }

    public void setBag(int idx, Product prod) //menghapus produk pada indeks i lalu menambahkan produk prod
    {
        this.delProduct(bag.get(idx).getNama());
        this.addProduct(prod);
    }
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
    public void delProduct(String NamaProduct) //Menghapus product dari bag dengan parameter input NamaProduct
    {
        Product cari;
        cari.setNama(NamaProduct);
        cari.setHarga(-1);
        bag.remove(cari);
    }
    public void delProductAll() //Mengosongkan Bag
    {
        int harga=0;
        while(!bag.isEmpty()){
            harga+=bag.get(1).getHarga();
            bag.remove(bag.get(1));
        }
        this.addMoney(harga);

    }
    public void reduceWater() //Mengkurangi atribut water yang ada didalam gebor (Alat penyiraman)
    {
        water-=1;
    }
    public void addProduct(Product Prod) //Menambahkan Product Prod ke Bag dan ditaruh di paling belakang
    {
        if (this.getSizeBag()<MAXBAG){
        bag.add(Prod);
    }else{
        System.out.println("Tas Penuh");
    }
    }
    public void addProduct(String Prod) //Menambahkan Nama Product Prod ke Bag dan ditaruh di paling belakang
    {
        int idxResep;
        if (Prod=="ButtermilkChicken"){
            //periksa apakah ButtermilChicken bisa dibuat
            if(this.isAvailable(Prod)){
                ButtermilkChicken X;
                idxResep = 0;
                while(idxResep < X.getNResep()){ //hapus bahan dari inventori
                    this.delProduct(X.getResep(idxResep));
                    idxResep++;
                }

                this.addProduct(X);
            } else {
                System.out.println("Tidak cukup bahan");
            }

        } else if (Prod=="Omellete"){
            if(this.isAvailable(Prod)){
                Omellete X;
                idxResep = 0;
                while(idxResep < X.getNResep()){ //hapus bahan dari inventori
                    this.delProduct(X.getResep(idxResep));
                    idxResep++;
                }

                this.addProduct(X);
            } else {
                System.out.println("Tidak cukup bahan");
            }
        } else if (Prod=="Meatball"){
            if(this.isAvailable(Prod)){
                Meatball X;
                idxResep = 0;
                while(idxResep < X.getNResep()){ //hapus bahan dari inventori
                    this.delProduct(X.getResep(idxResep));
                    idxResep++;
                }

                this.addProduct(X);
            } else {
                System.out.println("Tidak cukup bahan");
            }
        } else if (Prod=="ChickenEgg"){
            ChickenEgg X;
            this.addProduct(X);
        } else if (Prod=="ChickenMeat"){
            ChickenMeat X;
            this.addProduct(X);
        } else if (Prod=="CowMeat"){
            CowMeat X;
            this.addProduct(X);
        } else if (Prod=="CowMilk"){
            CowMilk X;
            this.addProduct(X);
        } else if (Prod=="DuckEgg"){
            DuckEgg X;
            this.addProduct(X);
        } else if (Prod=="HorseMilk"){
            HorseMilk X;
            this.addProduct(X);
        } else if (Prod=="RabbitMeat"){
            RabbitMeat X;
            this.addProduct(X);
        };
    }
    public void addWater() //Mengisi gebor dengan air secara maksimal (sesuai kapasitas) dengan mengubah atribut water
    {
        water=MAXWATER;
    }
    public void addMoney(int harga) //Menambah atribut money sesuai dengan harga
    {
        money+=harga;
    }
    public boolean isValid(int x,int y) //Mengecek Posisi tersebut ditempati player atau tidak mengembalikan true jika posisi tersebut ditempati player
    {
        return (this.getX()==x&&this.getY()==y);
    }

    public boolean isAvailable(String productname) //mengembalikan true jika SideProduct dengan nama productname bisa dibuat dengan inventori sekarang, false jika tidak
    {
        if(productname == "ButtermilkChicken"){
            ButtermilkChicken bmc;
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
            Omellete om;
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
            Meatball mb;
            int idxResep = 0;
            int idxbag;
            // int count = 0; //hitung jumlah bahan resep yang sudah ditemukan
            boolean found; //flag yang bernilai true jika bahan ditemukan
            while(idxResep < mb.getNResep() && !found){
                idxbag = 1;
                found = false;//inisialisasi
                while(idxbag <= this.getSizeBag()){
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


    public void print() //menulis inventori
    {
        System.out.print("Money	: ");
        System.out.println(this.getMoney());
        System.out.print("Water	: ");
        System.out.print(this.getWater());
        System.out.print("bag	: ");
        for(int i=1;i<=this.getSizeBag();i++){
        System.out.println(this.getBag(i).getNama());
        if(i!=this.getSizeBag()){
            System.out.print(", ");
        }else{
            System.out.println();
        }
    }
    }
}
