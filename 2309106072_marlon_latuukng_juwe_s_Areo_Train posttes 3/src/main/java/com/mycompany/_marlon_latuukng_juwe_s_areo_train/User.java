/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._marlon_latuukng_juwe_s_areo_train;

/**
 *
 * @author MSi-GAMING
 */
public class User {
  protected String username;
  protected String password;
  protected String namaLengkap;
  
  public User (String username, String password, String namaLengkap){
      this.username = username;
      this.password= password;
      this.namaLengkap= namaLengkap;
  }
    public boolean Verifikasi(String inputUsername, String inputPassword){
        return this.username.equals(inputUsername)&&this.password.equals(inputPassword);
    }
    public String getUsername() {return username;}
    public String getnamaLengkap(){return namaLengkap;}
}
