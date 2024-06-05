import java.util.ArrayList;
import java.util.List;

public class DPRD extends PegawaiNegara{
    private int jumlahKunjungan;
    private ArrayList<List> aspirasiRakyat = new ArrayList<List>();

    public DPRD(String nama, String NIP, int gajiPokok, String daerahKekuasaan){
        super(nama, NIP, gajiPokok, daerahKekuasaan);
    }

    public void aspirasiRakyat(RakyatJelata rakyat, String aspirasi){
        List<String> temp = new ArrayList<String>();
        temp.add(rakyat.getNama());
        temp.add(aspirasi);
        aspirasiRakyat.add(temp);
    }

    public void tampilkanAspirasi(){
        for (List<String> temp : aspirasiRakyat) {

            System.out.println("Aspirasi " + temp.get(0) + ": " + temp.get(1));
        }
    }

    public void kunjunganKerja(){
        jumlahKunjungan++;
    }

    public double getTunjangan(){
        return gajiPokok + (jumlahKunjungan * 1000000);
    }

    public void bayarPajak(double pajak) {
        APBN.addAPBN(pajak);
    }
}
