import java.util.*;

public class tugasAkhirE {

    public static void main(String[] args) {
        int count = 0;
        System.out.println("======================================================");
        System.out.printf("%32s","USER LOGIN");
        System.out.println("\n======================================================");
        login(count);
    }
    static void login(int count) {
        Scanner log = new Scanner(System.in);
        System.out.printf("\n%28s","username : ");
        String user = log.next().toLowerCase();
        System.out.printf("%28s","password : ");
        String pass = log.next().toLowerCase();

        if (pass.equals("filkomub")) {
            System.out.println("\n======================================================");
            System.out.printf("%38s\n","!!AKUN TERKONFIRMASI!!");
            System.out.println("======================================================");
            utama();
        } else {
            System.out.printf("\n%39s\n", "!!AKUN TIDAK DITEMUKAN!!");
            count++;
            if (count==3) {
                System.out.printf("\n%47s","Anda sudah gagal login sebanyak 3 kali.");
                System.out.printf("\n%39s\n","Harap coba lagi nanti...");
                System.exit(0);
            }
            login(count);
        }

    }
    static void utama() {
        System.out.printf("\n%43s","BIAYA PENDIDIKAN MAHASISWA BARU");
        System.out.printf("\n%47s","TEKNIK INFORMATIKA UNIVERSITAS BRAWIJAYA");
        System.out.printf("\n%30s","2021");

        int[] arrGol = new int[6];
        int[] arrUkt = {500000, 1000000, 4500000, 7500000, 8500000, 9500000};
        int[] arrIpi = {0, 0, 0, 40000000, 47500000, 55000000};

        System.out.println("\n======================================================");
        System.out.printf("%-26s %-13s %s\n","Daftar Golongan","UKT","IPI (MANDIRI)");
        System.out.println("======================================================");

        for (int i=0; i<arrGol.length; i++) {
            System.out.printf(" %s%d ","Golongan ke-",(i+1));
            System.out.printf("%10s %7d ","Rp.",arrUkt[i]);
            System.out.printf("%10s %8d\n","Rp.",arrIpi[i]);
        }
        System.out.println("======================================================\n");

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan NMS  : ");
        String nim = sc.next();

        System.out.println("\n======================================================");
        System.out.printf("%43s\n","!!DATA MAHASISWA TERKONFIRMASI!!");
        System.out.println("======================================================");

        System.out.println("\nSeleksi Jalur Masuk : 1. SNMPTN");
        System.out.printf("%31s\n","2. SBMPTN");
        System.out.printf("%32s\n","3. MANDIRI");

        jalur(arrUkt, arrIpi);
    }
    static void jalur(int[] arrUkt, int[] arrIpi) {
        System.out.print("\nDiterima melalui jalur masuk : ");
        Scanner sc = new Scanner(System.in);
        int jlr = sc.nextInt();

        if (jlr>=1 && jlr<=3) {
            System.out.println("\n======================================================\n");
            System.out.print("Penghasilan orang tua per tahun = Rp. ");
            int hsl = sc.nextInt();
            System.out.print("Pengeluaran keluarga per tahun  = Rp. ");
            int png = sc.nextInt();

            int sub = (hsl-png)/2;

            System.out.println("\n======================================================\n");

            kartu(arrIpi, arrUkt, sub, jlr);

        } else {
            System.out.printf("\n%41s\n","!!INPUT JALUR MASUK SALAH!!");
            jalur(arrUkt, arrIpi);
        }
    }
    static void kartu(int[] arrIpi, int[] arrUkt, int sub, int jlr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Apakah penerima KIP-K? (Y/N) : ");
        String kipk = sc.next();

        if (kipk.equalsIgnoreCase("Y")) {
            System.out.println("\n======================================================");
            System.out.printf("\n%s%22s","Total UKT","= Rp.0,-");
            System.out.printf("\n%s%22s","Total IPI","= Rp.0,-");
            jumlah(arrIpi, arrUkt, sub, jlr, kipk);
        } else if (kipk.equalsIgnoreCase("N")) {
            switch (jlr) {
                case 1 :

                case 2 :

                case 3 :
                    System.out.println("\n======================================================");
                    System.out.printf("\n%s%19s","Total UKT","= Rp.");
                    System.out.printf("%9d%s ",pangkal(arrUkt,sub,jlr),",-");
                    System.out.print("(golongan "+golongan(arrUkt, sub, jlr)+")");
                    System.out.printf("\n%s%19s","Total IPI","= Rp.");
                    System.out.printf("%9d%s",bangun(arrIpi,arrUkt,sub,jlr),",-\n");
                    jumlah(arrIpi, arrUkt, sub, jlr, kipk);
                    break;

                default :
                    System.out.printf("%30s","!!INPUT SALAH!!");
            }
        } else {
            System.out.printf("\n%38s\n\n","!!INPUT KIP-K SALAH!!");
            kartu(arrIpi, arrUkt, sub, jlr);
        }
    }
    static void jumlah(int[] arrIpi, int[] arrUkt, int sub, int jlr, String kipk) {
        int ukt = pangkal(arrUkt,sub,jlr);
        int ipi = bangun(arrIpi,arrUkt,sub,jlr);
        int total = ukt+ipi;

        if (kipk.equalsIgnoreCase("Y"))
            System.out.print("\nTotal Biaya Pendidikan = Rp.0,-");
        else {
            System.out.print("Total Biaya Pendidikan = Rp.");
            System.out.printf("%9d%s",total,",-");
        }
        System.out.println("\n\n======================================================");
    }
    static int pangkal(int[] arrUkt, int sub, int jlr) {
        if (jlr==1 || jlr==2) {
            if (sub>=arrUkt[5])
                return arrUkt[5];
            else if (sub>=arrUkt[4])
                return arrUkt[4];
            else if (sub>=arrUkt[3])
                return arrUkt[3];
            else if (sub>=arrUkt[2])
                return arrUkt[2];
            else if (sub>=arrUkt[1])
                return arrUkt[1];
            else
                return arrUkt[0];
        } else {
            if (sub>=arrUkt[5])
                return arrUkt[5];
            else if (sub>=arrUkt[4])
                return arrUkt[4];
            else
                return arrUkt[3];
        }
    }
    static int bangun(int[] arrIpi, int[] arrUkt, int sub, int jlr) {
        if (jlr==3) {
            if (sub>=arrUkt[5])
                return arrIpi[5];
            else if (sub>=arrUkt[4])
                return arrIpi[4];
            else
                return arrIpi[3];
        } else {
            return arrIpi[0];
        }
    }
    static int golongan (int[] arrUkt, int sub, int jlr) {
        if (jlr == 1 || jlr == 2) {
            if (sub >= arrUkt[5])
                return 6;
            else if (sub >= arrUkt[4])
                return 5;
            else if (sub >= arrUkt[3])
                return 4;
            else if (sub >= arrUkt[2])
                return 3;
            else if (sub >= arrUkt[1])
                return 2;
            else
                return 1;
        } else {
            if (sub >= arrUkt[5])
                return 6;
            else if (sub >= arrUkt[4])
                return 5;
            else
                return 4;
        }
    }
}
