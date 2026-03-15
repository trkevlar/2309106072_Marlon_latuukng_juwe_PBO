/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marlon_2309106072;

/**
 *
 * @author MSi-GAMING
 */
public class Admin {

    Admin(String admin, String admin123, String administrator_Utama, String super_admin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean verifikasi(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public class admin {
    private final String username;
    private final String password;
    private final String namaLengkap;
    private final String role;

    public admin(String username, String password, String namaLengkap, String role) {
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
        this.role = role;
    }

    public String getusername() { return username; }
    public String getpassword() { return password; }
    public String getnamaLengkap() { return namaLengkap; }
    public String getrole() { return role; }

    public boolean verifikasi(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
    }

}
