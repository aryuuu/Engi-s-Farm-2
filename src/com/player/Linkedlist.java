package com.player;
import java.util.*;
/**
 * file Linkedlist.java
 * <p>
 *     Kelas Linkedlist merepresentasikan Linkedlist yang digunakan di player
 * </p>
 *
 * @author Marsa Thoriq Ahmada / 13517071
 *
 * @version 1.0
 *`
 * @since 2019-04-20
 */
public class Linkedlist<T> {
    /**
     * Atribut object yang merupakan penyimpanan LinkedList
     */
    private LinkedList<T> object = new LinkedList<T>();;

    /**
     * Konstruktor Linkedlist
     */
    public Linkedlist() /* ctor */
    {
        LinkedList<T> object = new LinkedList<T>();
    }

    /**
     * Method dari ukuran Linkedlist
     * @return ukuran Linkedlist
     */
    public int size() /*Mengembalikan indeks dimana elemen ditemukan, -1 jika tidak ada*/
    {
        return object.size();
    }

    /**
     * Method pengecekan isi Linkedlist
     * @return boolean True jika Linkedlist kosong False jika tidak
     */
    public boolean isEmpty() /*Mengembalikan True jika linked list kosong*/
    {
        return object.isEmpty();
    }

    /**
     * Method Penambahan element pada Linkedlist
     * @param element
     */
    public void add(T element) /*Menambahkan elemen sebagai elemen paling akhir*/
    {
        object.add(element);
    }

    /**
     * Method untuk menghapus elemen pada idx dalam Linkedlist
     * @param idx
     */
    public void remove(int idx) /*Membuang elemen dari linked list*/
    {
        object.remove(idx - 1);
    }

    /**
     * Method untuk mengambil elemen pada posisi indeks
     * @param indeks
     * @return element T
     */
    public T get(int indeks) /*Mengembalikan elemen pada indeks*/
    {
        return object.get(indeks-1);
    }
}
