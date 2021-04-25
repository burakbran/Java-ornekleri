import java.util.Random;
import java.util.Scanner;

public class PegasusRezervasyonSistemi extends UcakRezervasyonSistemi {

	
	public PegasusRezervasyonSistemi(int koltukSayisi) {
		super(koltukSayisi);
	}

	Scanner scan = new Scanner(System.in);
	Random random = new Random();

	public void rezervasyonAl() {
		System.out.println();
		System.out.println("Pegasus Rezervasyon Sistemine Hoþgeldiniz!");
		if (ucakDoluMu() == true) {
			System.out.println("Maalesef uçak dolu, rezervasyon alamýyoruz.");
			return;
		}

		System.out.println("Business class uçmak için 0'a basýnýz, ekonomi class uçmak için 1'e basýnýz : ");
		int i = scan.nextInt();
		switch (i) {
		case 0:
			BusinessPegasus();
			break;

		case 1:
			EkonomiPegasus();
			break;

		default:
			System.out.println("Hatalý giriþ yaptýnýz!");
			break;

		}
     }
	public void BusinessPegasus() {
		if (businessDoluMu() == true) {
			System.out.println("Maalesef business koltuklarýmýz dolu! Rezervasyon alamýyoruz");
			return;
		}
		
		System.out.println("Aþaðýdaki boþ koltuklardan birini seçiniz");
		for (int i = 0; i < 5; i++) {
			if (koltuklar[i] == false) {
				System.out.print(i+1+" ");
			}
		}
	   System.out.println();	
       int j = scan.nextInt();
       while(j<1 || j>5 || koltuklar[j-1]==true) {
    	   System.out.println("Yanlýþ koltuk numarasý girildi, tekrar giriniz : ");
    	   j=scan.nextInt();
       }
      
       
       System.out.println("Koltuk no: "+j+" adýnýza rezerve edildi!");
       System.out.println("Ýyi uçuþlar!");
       koltuklar[j-1]=true;

       }
	
	public void EkonomiPegasus() {
		if (ekonomiDoluMu() == true) {
			System.out.println("Maalesef ekonomi koltuklarýmýz dolu! Rezervasyon alamýyoruz");
			return;
	      }
		
		
		int i = random.nextInt(koltuklar.length+1);
		while(i<6 || i>koltuklar.length || koltuklar[i-1]==true) {
			i = random.nextInt(koltuklar.length+1);
		}
		System.out.println("Koltuk no: "+i+" adýnýza rezerve edildi!");
	       System.out.println("Ýyi uçuþlar!");
	       koltuklar[i-1]=true;
	}
	
}
