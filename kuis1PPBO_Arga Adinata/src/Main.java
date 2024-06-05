public class Main {
    public static void main(String[] args) {
        PegawaiNegeriSipil pns1 = new PegawaiNegeriSipil("Asep","PNS123", 3000000, "Jakarta", 3);
        PegawaiNegeriSipil pns2 = new PegawaiNegeriSipil("Asup","PNS321", 6000000, "Jakarta", 4);

        RakyatJelata rakyat1 = new RakyatJelata("Bobi","Jakarta", 50000000);
        RakyatJelata rakyat2 = new RakyatJelata("Boba","Jakarta", 500000000);
        RakyatJelata rakyat3 = new RakyatJelata("Bolu","Bandung", 5000000);

        Gubernur gubernur1 = new Gubernur("Cica","GUB123", 10000000, "Jakarta");
        Gubernur gubernur2 = new Gubernur("Ciku","GUB321", 12000000, "Bandung");

        DPRD dprd1 = new DPRD("Dori","DPRD123", 50000000, "Jakarta");

        pns1.bayarPajak(1000000);
        pns1.tambahRakyat(rakyat1);
        pns1.tambahRakyat(rakyat2);
        pns1.tambahRakyat(rakyat3);
        pns1.salurkanBantuan();

        pns2.tambahRakyat(rakyat1);
        pns2.tambahRakyat(rakyat2);
        pns2.tambahRakyat(rakyat3);
        pns2.bayarPajak(2000000);

        gubernur1.tambahPNS(pns1);
        gubernur1.tambahPNS(pns2);
        gubernur2.tambahPNS(pns1);
        gubernur2.tambahPNS(pns2);

        dprd1.aspirasiRakyat(rakyat1, "Jalan rusak");
        dprd1.aspirasiRakyat(rakyat2, "Banjir");
        dprd1.aspirasiRakyat(rakyat3, "Pembangunan jalan");
        dprd1.tampilkanAspirasi();
    }
}