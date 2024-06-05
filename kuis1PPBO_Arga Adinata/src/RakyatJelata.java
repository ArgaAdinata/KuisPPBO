public class RakyatJelata {
    private String nama;
    private String alamat;
    private int jumlahKekayaan;

    public RakyatJelata(String nama, String alamat, int jumlahKekayaan){
        this.nama = nama;
        this.alamat = alamat;
        this.jumlahKekayaan = jumlahKekayaan;
    }

    public void bayarPajak(double pajak) {
        APBN.addAPBN(pajak);
    }

    public String getNama(){
        return nama;
    }
    public String getAlamat() {
        return alamat;
    }

    public int getJumlahKekayaan() {
        return jumlahKekayaan;
    }

    public void setJumlahKekayaan(int jumlahKekayaan) {
        this.jumlahKekayaan = jumlahKekayaan;
    }
}
