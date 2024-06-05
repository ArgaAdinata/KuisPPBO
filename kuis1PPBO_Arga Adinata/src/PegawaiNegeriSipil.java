import java.util.ArrayList;
public class PegawaiNegeriSipil extends PegawaiNegara{
    private int golongan;
    private ArrayList<RakyatJelata> daftarRakyat = new ArrayList<RakyatJelata>();

    public PegawaiNegeriSipil(String nama, String NIP, int gajiPokok, String daerahKekuasaan, int golongan){
        super(nama, NIP, gajiPokok, daerahKekuasaan);
        this.golongan = golongan;
    }


    public void tambahRakyat(RakyatJelata rakyat) {
        if (!rakyat.getAlamat().equals(this.daerahKekuasaan)) {
            System.out.println("Error: Alamat " + rakyat.getNama() + " tidak sesuai dengan daerah kekuasaan");
        } else {
            daftarRakyat.add(rakyat);
        }
    }

    public void salurkanBantuan(){
        for (RakyatJelata rakyat : daftarRakyat) {
            if (rakyat.getJumlahKekayaan() < 100000000) {
                rakyat.setJumlahKekayaan(rakyat.getJumlahKekayaan() + APBN.getAPBN(1000000));
            }
        }
    }

    public double getTunjangan() {
        return gajiPokok + (golongan * 100000);
    }

    public void bayarPajak(double pajak) {
        APBN.addAPBN(pajak);
    }


}
