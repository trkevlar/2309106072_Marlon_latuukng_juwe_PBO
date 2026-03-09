/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marlon_2309106072;

/**
 *
 * @author MSi-GAMING
 */
public class Jadwal {
    private static int counter = 1;
    
    private final int id;
    private String namaKereta;
    private String kodeKereta;
    private String stasiunAsal;
    private String stasiunTujuan;
    private String waktuBerangkat;
    private String waktuTiba;
    private String status; 
    private int kapasitasSeat;
    private int seatTersedia;
    private String jalur;
    
    public Jadwal(String namaKereta, String kodeKereta, String stasiunAsal, String stasiunTujuan, String waktuBerangkat, String waktuTiba, int kapasitasSeat, String jalur){
        this.id = counter++;
        this.namaKereta = namaKereta;
        this.kodeKereta = kodeKereta;
        this.stasiunAsal = stasiunAsal;
        this.stasiunTujuan = stasiunTujuan;
        this.waktuBerangkat = waktuBerangkat;
        this.waktuTiba = waktuTiba;
        this.kapasitasSeat = kapasitasSeat;
        this.seatTersedia = kapasitasSeat;
        this.jalur = jalur;
        this.status = "TEPAT WAKTU"; 
        
    }
    //laporan (ini akan muncul di layar pembeli/biasanya admin akan menggunakan speaker untuk menyambut pembeli/peumpang
    
    public int getId() { return id; }
    public String getnamaKereta() { return namaKereta; }
    public String getkodeKereta() { return kodeKereta; }
    public String getstasiunAsal() { return stasiunAsal; }
    public String getstasiunTujuan() { return stasiunTujuan; }
    public String getwaktuBerangkat() { return waktuBerangkat; }
    public String getwaktuTiba() { return waktuTiba; }
    public String getstatus() { return status; }
    public int getkapasitasSeat() { return kapasitasSeat; }
    public int getseatTersedia() { return seatTersedia; }
    public String getjalur() { return jalur; }
    
    //penummpang
    
    public void setnamaKereta(String namaKereta) { this.namaKereta = namaKereta; }
    public void setkodeKereta(String kodeKereta) { this.kodeKereta = kodeKereta; }
    public void setstasiunAsal(String stasiunAsal) { this.stasiunAsal = stasiunAsal; }
    public void setstasiunTujuan(String stasiunTujuan) { this.stasiunTujuan = stasiunTujuan; }
    public void setwaktuBerangkat(String waktuBerangkat) { this.waktuBerangkat = waktuBerangkat; }
    public void setwaktuTiba(String waktuTiba) { this.waktuTiba = waktuTiba; }
    public void setstatus(String status) { this.status = status; }
    public void setkapasitasSeat(int kapasitasSeat) { this.kapasitasSeat = kapasitasSeat; }
    public void setseatTersedia(int seatTersedia) { this.seatTersedia = seatTersedia; }
    public void setjalur(String jalur) { this.jalur = jalur; }

   public static void resetCounter() { counter = 1; }
   
   @Override
   public String toString(){
       String statusIcon = switch (status){
           case "tepatwaktu" -> "Ontime";
           case "terlambat" -> "late";
           case "dibatalkan" -> "cancel";
           default  -> "wait";
       };
        return String.format(
            "========================================" +
            " ID       : %-33d│\n" +
            " Nama     : %-33s│\n" +
            " Kode     : %-33s│\n" +
            " Asal     : %-33s│\n" +
            " Tujuan   : %-33s│\n" +
            " Berangkat: %-33s│\n" +
            " Tiba     : %-33s│\n" +
            " Jalur    : %-33s│\n" +
            " Seat     : %d/%d tersedia%-21s│\n" +
            " Status   : %s %-31s│\n" +
            "========================================",
            id, namaKereta, kodeKereta, stasiunAsal, stasiunTujuan,
            waktuBerangkat, waktuTiba, jalur,
            seatTersedia, kapasitasSeat, "",
            statusIcon, status);
   }
}
