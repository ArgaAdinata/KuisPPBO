import java.util.ArrayList;

public class Gubernur extends PegawaiNegara{
    private ArrayList<PegawaiNegeriSipil> daftarPNS = new ArrayList<PegawaiNegeriSipil>();

    public Gubernur(String nama, String NIP, int gajiPokok, String daerahKekuasaan){
        super(nama, NIP, gajiPokok, daerahKekuasaan);
    }

    public void tambahPNS(PegawaiNegeriSipil pns) {
        if (!pns.getDaerahKekuasaan().equals(this.daerahKekuasaan)) {
            System.out.println("Error: Daerah kekuasaan "+ pns.getNama() + " tidak sesuai dengan daerah kekuasaan Gubernur");
        } else {
            daftarPNS.add(pns);
        }
    }

    public void tambahDanaAPBN(double dana){
        APBN.addAPBN(dana);
    }

    public double getTunjangan(){
        return gajiPokok + (100000 * daftarPNS.size());
    }


    public void bayarPajak(double pajak) {
        APBN.addAPBN(pajak);
    }
}
