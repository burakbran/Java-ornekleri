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
		System.out.println("Pegasus Rezervasyon Sistemine Ho�geldiniz!");
		if (ucakDoluMu() == true) {
			System.out.println("Maalesef u�ak dolu, rezervasyon alam�yoruz.");
			return;
		}

		System.out.println("Business class u�mak i�in 0'a bas�n�z, ekonomi class u�mak i�in 1'e bas�n�z : ");
		int i = scan.nextInt();
		switch (i) {
		case 0:
			BusinessPegasus();
			break;

		case 1:
			EkonomiPegasus();
			break;

		default:
			System.out.println("Hatal� giri� yapt�n�z!");
			break;

		}
     }
	public void BusinessPegasus() {
		if (businessDoluMu() == true) {
			System.out.println("Maalesef business koltuklar�m�z dolu! Rezervasyon alam�yoruz");
			return;
		}
		
		System.out.println("A�a��daki bo� koltuklardan birini se�iniz");
		for (int i = 0; i < 5; i++) {
			if (koltuklar[i] == false) {
				System.out.print(i+1+" ");
			}
		}
	   System.out.println();	
       int j = scan.nextInt();
       while(j<1 || j>5 || koltuklar[j-1]==true) {
    	   System.out.println("Yanl�� koltuk numaras� girildi, tekrar giriniz : ");
    	   j=scan.nextInt();
       }
      
       
       System.out.println("Koltuk no: "+j+" ad�n�za rezerve edildi!");
       System.out.println("�yi u�u�lar!");
       koltuklar[j-1]=true;

       }
	
	public void EkonomiPegasus() {
		if (ekonomiDoluMu() == true) {
			System.out.println("Maalesef ekonomi koltuklar�m�z dolu! Rezervasyon alam�yoruz");
			return;
	      }
		
		
		int i = random.nextInt(koltuklar.length+1);
		while(i<6 || i>koltuklar.length || koltuklar[i-1]==true) {
			i = random.nextInt(koltuklar.length+1);
		}
		System.out.println("Koltuk no: "+i+" ad�n�za rezerve edildi!");
	       System.out.println("�yi u�u�lar!");
	       koltuklar[i-1]=true;
	}
	
}
