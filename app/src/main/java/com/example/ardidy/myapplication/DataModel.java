package com.example.ardidy.myapplication;

/**
 * Created by ardidy on 8/3/2017.
 */

public class DataModel {

    String nomor;
    String namaBarang;
    String jumlahBarang;

    public DataModel(){
        
    }

    public DataModel(String nomor, String namaBarang, String jumlahBarang) {
        this.nomor = nomor;
        this.namaBarang = namaBarang;
        this.jumlahBarang = jumlahBarang;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
}
