/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marlon_2309106072;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author MSi-GAMING
 */
public class JadwalService {
     private final ArrayList<Jadwal> daftarJadwal;

    public JadwalService() {
        daftarJadwal = new ArrayList<>();
        // Data awal / seed data
        inisialisasiDataAwal();
    }
    private void inisialisasiDataAwal() {
        daftarJadwal.add(new Jadwal("Argo Bromo Anggrek", "ABR-001",
                "Jakarta Gambir", "Surabaya Pasarturi", "08:00", "17:30", 400, "Jalur 1"));
        daftarJadwal.add(new Jadwal("Gajayana", "GJY-002",
                "Jakarta Gambir", "Malang", "09:00", "20:00", 350, "Jalur 2"));
        daftarJadwal.add(new Jadwal("Taksaka", "TKS-003",
                "Jakarta Gambir", "Yogyakarta", "10:00", "18:00", 380, "Jalur 3"));
    }
    public void tambahJadwal(Scanner scanner) {
         System.out.println("══════════════════════════════════════");
        System.out.println("         TAMBAH JADWAL BARU            ");
        System.out.println("══════════════════════════════════════");

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
        while (true){
             System.out.print("Kapasitas Seat    : ");
             try {
                  kapasitas = Integer.parseInt(scanner.nextLine().trim());
                if (kapasitas <= 0) throw new NumberFormatException();
                break;
             } catch (NumberFormatException e){
                 System.out.println("masukkan angka positif!");
             }
        }
        System.out.print("jalur keberangkatan");
     String jalur = scanner.nextLine();

        Jadwal jadwalBaru = new Jadwal(nama, kode, asal, tujuan, berangkat, tiba, kapasitas, jalur);
        daftarJadwal.add(jadwalBaru);

        System.out.println("\n✅ Jadwal berhasil ditambahkan!");
        System.out.println(jadwalBaru);
    }
    public void tampilkanSemuaJadwal() {
        System.out.println("══════════════════════════════════════");
        System.out.println("         DAFTAR SEMUA JADWAL      ");
        System.out.println("══════════════════════════════════════");

        if (daftarJadwal.isEmpty()) {
            System.out.println("️  Belum ada jadwal yang terdaftar.");
            return;
        }

        System.out.println("Total jadwal: " + daftarJadwal.size() + "\n");
        for (Jadwal j : daftarJadwal) {
            System.out.println(j);
            System.out.println();
        }
    }
    public void cariJadwal(Scanner scanner) {
        System.out.println("══════════════════════════════════════");
        System.out.println("           CARI JADWAL           ");
        System.out.println("══════════════════════════════════════");
        System.out.println("Cari berdasarkan:");
        System.out.println("  1. ID Jadwal");
        System.out.println("  2. Nama/Kode Kereta");
        System.out.println("  3. Stasiun Asal/Tujuan");
        System.out.print("Pilih: ");
        String pilih = scanner.nextLine().trim();

        ArrayList<Jadwal> hasil = new ArrayList<>();

        switch (pilih) {
            case "1" -> {
                System.out.print("Masukkan ID: ");
                try {
                    int id = Integer.parseInt(scanner.nextLine().trim());
                    for (Jadwal j : daftarJadwal) {
                        if (j.getId() == id) hasil.add(j);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("️ID tidak valid.");
                    return;
                }
            }
            case "2" -> {
                System.out.print("Nama/Kode Kereta: ");
                String kata = scanner.nextLine().toLowerCase();
                for (Jadwal j : daftarJadwal) {
                    if (j.getnamaKereta().toLowerCase().contains(kata) ||
                        j.getkodeKereta().toLowerCase().contains(kata)) {
                        hasil.add(j);
                    }
                }
            }
            case "3" -> {
                System.out.print("Stasiun (asal/tujuan): ");
                String kata = scanner.nextLine().toLowerCase();
                for (Jadwal j : daftarJadwal) {
                    if (j.getstasiunAsal().toLowerCase().contains(kata) ||
                        j.getstasiunTujuan().toLowerCase().contains(kata)) {
                        hasil.add(j);
                    }
                }
            }
            default -> {
                System.out.println("️Pilihan tidak valid.");
                return;
            }
        }

        if (hasil.isEmpty()) {
            System.out.println(" Jadwal tidak ditemukan.");
        } else {
            System.out.println(" Ditemukan " + hasil.size() + " jadwal:");
            for (Jadwal j : hasil) {
                System.out.println(j);
                System.out.println();
            }
        }
    }
     public void updateJadwal(Scanner scanner) {
        System.out.println("══════════════════════════════════════");
        System.out.println("           UPDATE JADWAL         ");
        System.out.println("══════════════════════════════════════");
        tampilkanSemuaJadwal();

        System.out.print("Masukkan ID jadwal yang ingin diupdate: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("️ID tidak valid.");
            return;
        }

        Jadwal target = cariById(id);
        if (target == null) {
            System.out.println(" Jadwal dengan ID " + id + " tidak ditemukan.");
            return;
        }

        System.out.println("\nField yang bisa diupdate:");
        System.out.println("  1. Nama Kereta      [" + target.getnamaKereta() + "]");
        System.out.println("  2. Kode Kereta      [" + target.getkodeKereta() + "]");
        System.out.println("  3. Stasiun Asal     [" + target.getstasiunAsal() + "]");
        System.out.println("  4. Stasiun Tujuan   [" + target.getstasiunTujuan() + "]");
        System.out.println("  5. Waktu Berangkat  [" + target.getwaktuBerangkat() + "]");
        System.out.println("  6. Waktu Tiba       [" + target.getwaktuTiba() + "]");
        System.out.println("  7. Status           [" + target.getstatus() + "]");
        System.out.println("  8. Kapasitas Seat   [" + target.getkapasitasSeat() + "]");
        System.out.println("  9. Jalur            [" + target.getjalur() + "]");
        System.out.print("Pilih field (1-9): ");

        String pilih = scanner.nextLine().trim();

        switch (pilih) {
            case "1" -> { System.out.print("Nama baru: "); target.setnamaKereta(scanner.nextLine()); }
            case "2" -> { System.out.print("Kode baru: "); target.setkodeKereta(scanner.nextLine()); }
            case "3" -> { System.out.print("Stasiun asal baru: "); target.setstasiunAsal(scanner.nextLine()); }
            case "4" -> { System.out.print("Stasiun tujuan baru: "); target.setstasiunTujuan(scanner.nextLine()); }
            case "5" -> { System.out.print("Waktu berangkat baru (HH:mm): "); target.setwaktuBerangkat(scanner.nextLine()); }
            case "6" -> { System.out.print("Waktu tiba baru (HH:mm): "); target.setwaktuTiba(scanner.nextLine()); }
            case "7" -> {
                System.out.println("Status: 1. TEPAT WAKTU  2. TERLAMBAT  3. DIBATALKAN");
                System.out.print("Pilih: ");
                String s = scanner.nextLine().trim();
                String[] statuses = {"TEPAT WAKTU", "TERLAMBAT", "DIBATALKAN"};
                try {
                    int idx = Integer.parseInt(s) - 1;
                    if (idx >= 0 && idx < statuses.length) {
                        target.setstatus(statuses[idx]);
                    } else throw new Exception();
                } catch (Exception e) {
                    System.out.println("️  Pilihan status tidak valid.");
                    return;
                }
            }
            case "8" -> {
                System.out.print("Kapasitas baru: ");
                try {
                    int kap = Integer.parseInt(scanner.nextLine().trim());
                    target.setkapasitasSeat(kap);
                    target.setseatTersedia(kap);
                } catch (NumberFormatException e) {
                    System.out.println("️  Angka tidak valid.");
                    return;
                }
            }
            case "9" -> { System.out.print("Jalur baru: "); target.setjalur(scanner.nextLine()); }
            default  -> { System.out.println("️  Pilihan tidak valid."); return; }
        }

        System.out.println(" Jadwal berhasil diperbarui!");
        System.out.println(target);
    }
      public void hapusJadwal(Scanner scanner) {
        System.out.println("══════════════════════════════════════");
        System.out.println("           HAPUS JADWAL          ");
        System.out.println("══════════════════════════════════════");
        tampilkanSemuaJadwal();

        System.out.print("Masukkan ID jadwal yang ingin dihapus: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("  ID tidak valid.");
            return;
        }

        Jadwal target = cariById(id);
        if (target == null) {
            System.out.println(" Jadwal dengan ID " + id + " tidak ditemukan.");
            return;
        }

        System.out.println("Anda akan menghapus jadwal:");
        System.out.println(target);
        System.out.print("Konfirmasi hapus? (y/n): ");
        String konfirmasi = scanner.nextLine().trim().toLowerCase();

        if (konfirmasi.equals("y")) {
            daftarJadwal.remove(target);
            System.out.println(" Jadwal [" + target.getnamaKereta() + "] berhasil dihapus.");
        } else {
            System.out.println("ℹ️  Penghapusan dibatalkan.");
        }
    }
      private Jadwal cariById(int id) {
        for (Jadwal j : daftarJadwal) {
            if (j.getId() == id) return j;
        }
        return null;
    }
}
