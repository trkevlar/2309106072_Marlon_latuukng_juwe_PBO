package marlon_2309106072;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;
import marlon_2309106072.AdminService;
import marlon_2309106072.JadwalService;
/**
 *
 * @author MSi-GAMING
 */
public class Main {
            public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
         AdminService adminService = new AdminService();
         JadwalService jadwalService = new JadwalService();
         System.out.println("══════════════════════════════════════════");
         System.out.println("  SISTEM MANAJEMEN KERETA API      ");
         System.out.println("══════════════════════════════════════════");
         
         //Admin insert data 
         boolean loggedIn = false;
         while (!loggedIn){
             System.out.print("Username admin: ");
             String username = scanner.nextLine();
             System.out.print("password: ");
             String password = scanner.nextLine();
             loggedIn = adminService.login(username, password);
             if (!loggedIn){
                 System.out.println("login gagal! coba lagi.");
             }
             System.out.println("login berhasil selamat datang admin");
         }
         boolean running = true;
         while (running){
             tampilkanMenu();
             System.out.print("pilih menu");
             String input = scanner.nextLine().trim();
             
             switch (input){
                 case"1" -> jadwalService.tambahJadwal(scanner);
                 case"2" -> jadwalService.tampilkanSemuaJadwal();
                 case"3" -> jadwalService.cariJadwal(scanner);
                 case"4" -> jadwalService.updateJadwal(scanner);
                 case"5" -> jadwalService.hapusJadwal(scanner);
                 case"6" -> {
                     System.out.println("Terima kasih telah menggunakan sistem AeroTrain.sampai jumpa!");
                     running = false;
                 }
                 default -> System.out.println("menu tidak valid! silahkan pilih 1-6");
             }
                 scanner.close();
                 
             }
         }
    }private static void tampilkanMenu(){
        System.out.println("══════════════════════════════════════");
        System.out.println("        MENU UTAMA - ADMIN PANEL       ");
        System.out.println("══════════════════════════════════════");
        System.out.println("  1. Tambah Jadwal Kereta              ");
        System.out.println("  2. Lihat Semua Jadwal                ");
        System.out.println("  3. Cari Jadwal                       ");
        System.out.println("  4. Update Jadwal                     ");
        System.out.println("  5. Hapus Jadwal                      ");
        System.out.println("  6. Keluar                            ");
        System.out.println("══════════════════════════════════════");


}
