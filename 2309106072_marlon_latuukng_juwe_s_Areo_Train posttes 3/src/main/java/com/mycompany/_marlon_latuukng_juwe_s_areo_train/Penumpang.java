/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._marlon_latuukng_juwe_s_areo_train;

/**
 *
 * @author MSi-GAMING
 */
public class Penumpang extends User {
private String noKTP;
    private String email;

    public Penumpang(String username, String password, String namaLengkap, 
                     String noKTP, String email) {
        super(username, password, namaLengkap);
        this.noKTP = noKTP;
        this.email = email;
    }

    public String getNoKTP() { return noKTP; }
    public String getEmail() { return email; }

    public void tampilkanInfoPenumpang() {
        System.out.println("Penumpang: " + getnamaLengkap() 
                         + " | KTP: " + noKTP + " | Email: " + email);
    }
}
