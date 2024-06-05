public class APBN {
    private static double totalPendapatan;

    public static void addAPBN(double pendapatan){
        totalPendapatan += pendapatan;
    }

    public static int getAPBN(int pengeluaran){
        if (totalPendapatan - pengeluaran < 0){
            System.out.println("Pengeluaran melebihi uang APBN saat ini");
            return 0;
        }
        totalPendapatan -= pengeluaran;
        return pengeluaran;
    }
}
