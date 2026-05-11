/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._marlon_latuukng_juwe_s_areo_train;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author MSi-GAMING
 */
public class JadwalService {
private final ArrayList<Jadwal> DaftarJadwal;

    public JadwalService() {
        DaftarJadwal = new ArrayList<>();
        inisialisasiDataAwal();
    }

    private void inisialisasiDataAwal() {
        DaftarJadwal.add(new Jadwal("Argo Bromo Anggrek", "ABR-001", "Jakarta Gambir", "Surabaya Pasarturi", "08:00", "17:30", 400, "Jalur 1"));
        DaftarJadwal.add(new Jadwal("Gajayana", "GJY-002", "Jakarta Gambir", "Malang", "09:00", "20:00", 350, "Jalur 2"));
        DaftarJadwal.add(new Jadwal("Taksaka", "TKS-003", "Jakarta Gambir", "Yogyakarta", "10:00", "18:00", 380, "Jalur 3"));
    }

    public void tambahJadwal(Scanner scanner) {
        System.out.println("=====================================");
        System.out.println("         TAMBAH JADWAL BARU            ");
        System.out.println("=====================================");

        System.out.print("Nama Kereta       : ");
        String nama = scanner.nextLine();
        System.out.print("Kode Kereta       : ");
        String kode = scanner.nextLine();
        System.out.print("Stasiun Asal      : ");
        String asal = scanner.nextLine();
        System.out.print("Stasiun Tujuan    : ");
        String tujuan = scanner.nextLine();
        System.out.print("Waktu Berangkat   : ");
        String berangkat = scanner.nextLine();
        System.out.print("Waktu Tiba        : ");
        String tiba = scanner.nextLine();

        int kapasitas = 0;
        while (true) {
            System.out.print("Kapasitas Seat    : ");
            try {
                kapasitas = Integer.parseInt(scanner.nextLine().trim());
                if (kapasitas <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka positif!");
            }
        }
        System.out.print("Jalur keberangkatan: ");
        String jalur = scanner.nextLine();

        Jadwal jadwalBaru = new Jadwal(nama, kode, asal, tujuan, berangkat, tiba, kapasitas, jalur);
        DaftarJadwal.add(jadwalBaru);

        System.out.println("Jadwal berhasil ditambahkan!");
        System.out.println(jadwalBaru);
    }

    public void tampilkanSemuaJadwal() {
        System.out.println("=====================================");
        System.out.println("         DAFTAR SEMUA JADWAL      ");
        System.out.println("=====================================");

        if (DaftarJadwal.isEmpty()) {
            System.out.println("Belum ada jadwal yang terdaftar.");
            return;
        }

        System.out.println("Total jadwal: " + DaftarJadwal.size() + "\n");
        for (Jadwal j : DaftarJadwal) {
            System.out.println(j);
            System.out.println();
        }
    }

    public void cariJadwal(Scanner scanner) {
        System.out.println("=====================================");
        System.out.println("           CARI JADWAL           ");
        System.out.println("=====================================");
        System.out.println("Cari berdasarkan:");
        System.out.println("  1. ID Jadwal");
        System.out.println("  2. Nama/Kode Kereta");
        System.out.println("  3. Stasiun Asal/Tujuan");
        System.out.print("Pilih: ");
        String pilih = scanner.nextLine().trim();

        ArrayList<Jadwal> hasil = new ArrayList<>();

        switch (pilih) {
            case "1" -> {
                System.out.print("Masukkan ID:");
                try {
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    for (Jadwal j : DaftarJadwal) {
                        if (j.getId() == id) hasil.add(j);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID tidak valid.");
                    return;
                }
            }
            case "2", "3" -> {
                System.out.print(pilih.equals("2") ? "Nama/Kode Kereta: " : "Stasiun (asal/tujuan): ");
                String kata = scanner.nextLine().toLowerCase();
                for (Jadwal j : DaftarJadwal) {
                    if ((pilih.equals("2") && (j.getnamaKereta().toLowerCase().contains(kata) || j.getkodeKereta().toLowerCase().contains(kata)))
                            || (pilih.equals("3") && (j.getstasiunAsal().toLowerCase().contains(kata) || j.getstasiunTujuan().toLowerCase().contains(kata)))) {
                        hasil.add(j);
                    }
                }
            }
            default -> {
                System.out.println("Pilihan tidak valid.");
                return;
            }
        }

        if (hasil.isEmpty()) {
            System.out.println("Jadwal tidak ditemukan.");
        } else {
            System.out.println("Ditemukan " + hasil.size() + " jadwal:");
            for (Jadwal j : hasil) {
                System.out.println(j);
                System.out.println();
            }
        }
    }

    public void updateJadwal(Scanner scanner) {
        System.out.println("=====================================");
        System.out.println("           UPDATE JADWAL         ");
        System.out.println("=====================================");
        tampilkanSemuaJadwal();

        System.out.print("Masukkan ID jadwal yang ingin diupdate: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        Jadwal target = cariById(id);
        if (target == null) {
            System.out.println("Jadwal dengan ID " + id + " tidak ditemukan.");
            return;
        }


        System.out.println("Field yang bisa diupdate:");
        System.out.println("1. Nama Kereta      [" + target.getnamaKereta() + "]");
        System.out.println("Update selesai (untuk sementara).");
        System.out.println(target);
    }

    public void hapusJadwal(Scanner scanner) {
        System.out.println("=====================================");
        System.out.println("           HAPUS JADWAL          ");
        System.out.println("=====================================");
        tampilkanSemuaJadwal();

        System.out.print("Masukkan ID jadwal yang ingin dihapus: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        Jadwal target = cariById(id);
        if (target == null) {
            System.out.println("Jadwal dengan ID " + id + " tidak ditemukan.");
            return;
        }

        System.out.println("Anda akan menghapus:");
        System.out.println(target);
        System.out.print("Konfirmasi hapus? (y/n): ");
        String konfirmasi = scanner.nextLine().trim().toLowerCase();

        if (konfirmasi.equals("y")) {
            DaftarJadwal.remove(target);
            System.out.println("Jadwal berhasil dihapus.");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    private Jadwal cariById(int id) {
        for (Jadwal j : DaftarJadwal) {
            if (j.getId() == id) return j;
        }
        return null;
    }
}