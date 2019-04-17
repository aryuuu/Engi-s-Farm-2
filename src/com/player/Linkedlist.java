package com.player;
import java.util.*;
public class Linkedlist<T> {
    private LinkedList<T> object;
    public Linkedlist() /* ctor */
    {
        LinkedList<T> object = new LinkedList<T>();
    }
    public int size() /*Mengembalikan indeks dimana elemen ditemukan, -1 jika tidak ada*/
    {
        return object.size();
    }
    public int find(T element) /*Mengembalikan indeks dimana elemen ditemukan, -1 jika tidak ada*/
    {
        return object.indexOf(element);
        /*Iterator<T> itr=object.iterator();
        boolean found = false;
        int posisi=1;
        while(itr.hasNext() && (!found)){
            if (itr.samaDengan(element)){
                found = true;
            }else{
                itr=itr.next();
                posisi++;
            }
        }
        if (posisi>this.size()){
            posisi=-1;
        }
        return posisi;*/
    }
    public boolean isEmpty() /*Mengembalikan True jika linked list kosong*/
    {
        return object.isEmpty();
    }
    public void add(T element) /*Menambahkan elemen sebagai elemen paling akhir*/
    {
        object.add(element);
    }
    public void remove(T element) /*Membuang elemen dari linked list*/
    {
        object.remove(element);
    }
    public T get(int indeks) /*Mengembalikan elemen pada indeks*/
    {
        return object.get(indeks);
    }
}
