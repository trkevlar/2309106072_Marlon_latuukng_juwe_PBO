/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marlon_2309106072;

import java.util.ArrayList;

/**
 *
 * @author MSi-GAMING
 */
public class AdminService {
        private final  ArrayList<Admin> daftarAdmin;
    public AdminService() {
        daftarAdmin = new ArrayList<>();
        // Data admin default
        daftarAdmin.add(new Admin("admin", "admin123", "Administrator Utama", "SUPER_ADMIN"));
        daftarAdmin.add(new Admin("operator1", "op1234", "Budi Santoso", "OPERATOR"));
    }
    public boolean login(String username, String password){
        for(Admin admin : daftarAdmin){
            if(admin.verifikasi(username,password)){
                return true;
            }
        }
        return false;
    }
}
