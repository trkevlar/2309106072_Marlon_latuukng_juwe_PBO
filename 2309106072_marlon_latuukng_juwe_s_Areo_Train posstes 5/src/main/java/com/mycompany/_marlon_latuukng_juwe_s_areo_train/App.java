package com.mycompany._marlon_latuukng_juwe_s_areo_train;

import java.util.Scanner;

/**
 *
 * @author MSi-GAMING
 */
public class App {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            AdminService adminService = new AdminService();
            JadwalService jadwalService = new JadwalService();
            
            System.out.println("=====================================");
            System.out.println("  SISTEM MANAJEMEN KERETA API (AeroTrain)  ");
            System.out.println("=====================================");
            
            
            boolean loggedIn = false;
            while (!loggedIn) {
                System.out.print("Username admin: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                
                loggedIn = adminService.login(username, password);
                
                if (loggedIn) {
                    System.out.println(" Login berhasil! Selamat datang, Admin.");
                } else {
                    System.out.println(" Login gagal! Coba lagi.");
                }
            }
            
            //MENU UTAMA
            boolean running = true;
            while (running) {
                tampilkanMenu();
                System.out.print("Pilih menu (1-6): ");
                String input = scanner.nextLine().trim();
                
                switch (input) {
                    case "1" -> jadwalService.tambahJadwal(scanner);
                    case "2" -> jadwalService.tampilkanSemuaJadwal();
                    case "3" -> jadwalService.cariJadwal(scanner);
                    case "4" -> jadwalService.updateJadwal(scanner);
                    case "5" -> jadwalService.hapusJadwal(scanner);
                    case "6" -> {
                        System.out.println("Terima kasih telah menggunakan sistem AeroTrain. Sampai jumpa!");
                        running = false;
                    }
                    default -> System.out.println(" Menu tidak valid! Silahkan pilih 1-6.");
                }
            }
            scanner.close();
        }
    }

    //MENU
    private static void tampilkanMenu() {    
        System.out.println("=====================================");
        System.out.println("        MENU UTAMA - ADMIN PANEL       ");
        System.out.println("=====================================");
        System.out.println("  1. Tambah Jadwal Kereta");
        System.out.println("  2. Lihat Semua Jadwal");
        System.out.println("  3. Cari Jadwal");
        System.out.println("  4. Update Jadwal");
        System.out.println("  5. Hapus Jadwal");
        System.out.println("  6. Keluar");
        System.out.println("=====================================");
    }
    //overidding ini nanti perbaiki dan perbanyak cek buku dan material salah mulu 
    public class User {
    protected String username;
    protected String password;
    protected String namaLengkap;
  
    public User(String username, String password, String namaLengkap) {
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
    }

    public boolean Verifikasi(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    public String getUsername() { return username; }
    public String getnamaLengkap() { return namaLengkap; }
    public void tampilkanInfo(){
        System.out.println("Username     : " + username);
        System.out.println("Nama Lengkap : " + namaLengkap);
    }
    }
}
