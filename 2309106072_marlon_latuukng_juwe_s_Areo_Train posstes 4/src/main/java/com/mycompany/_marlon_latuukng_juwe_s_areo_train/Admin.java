/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._marlon_latuukng_juwe_s_areo_train;

/**
 *
 * @author MSi-GAMING
 */

public class Admin extends User {

    private String role;

    public Admin(String username, String password, String namaLengkap, String role) {
        super(username, password, namaLengkap); 
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    /**
     *
     */
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Role         : " + role);
        System.out.println("Tipe         : ADMIN");
    }


    public void tampilkanInfo(boolean detail) {
        tampilkanInfo(); // panggil versi override
        if (detail) {
            System.out.println("--- Detail Admin ---");
            System.out.println("Username login : " + username);
            System.out.println("Password (hidden) : ********");
        }
    }
}