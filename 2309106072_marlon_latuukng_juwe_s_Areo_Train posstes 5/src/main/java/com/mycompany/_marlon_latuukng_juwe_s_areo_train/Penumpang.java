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

    /**
     *
     */
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Username     : " + username);
        System.out.println("Nama Lengkap : " + namaLengkap);
        System.out.println("No KTP       : " + noKTP);
        System.out.println("Email        : " + email);
        System.out.println("Tipe         : PENUMPANG");
    }
    public void tampilkanInfo(boolean detail) {
        tampilkanInfo(); 
        if (detail) {
            System.out.println("--- Detail Penumpang ---");
            System.out.println("Username login : " + username);
        }
    }
    public void tampilkanInfoPenumpang() {
        tampilkanInfo(); 
    }
    public void tampilkanInfoSingkat() {
        System.out.println("[PENUMPANG] " + namaLengkap + " | Email: " + email + " | KTP: " + noKTP);
    }
    public String getTipeUser() {
        return "PENUMPANG";
    }
 
}