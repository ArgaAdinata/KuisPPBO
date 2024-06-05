public abstract class PegawaiNegara {
    protected String nama;
    protected String NIP;
    protected int gajiPokok;
    protected String daerahKekuasaan;

    public PegawaiNegara(String nama, String NIP, int gajiPokok, String daerahKekuasaan){
        this.nama = nama;
        this.NIP = NIP;
        this.gajiPokok = gajiPokok;
        this.daerahKekuasaan = daerahKekuasaan;
    }

    public String getNIP() {
        return NIP;
    }

    public int getGajiPokok() {
        return gajiPokok;
    }

    public String getDaerahKekuasaan() {
        return daerahKekuasaan;
    }

    public String getNama() {
        return nama;
    }
}
