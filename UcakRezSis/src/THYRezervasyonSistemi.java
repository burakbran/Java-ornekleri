import java.util.Random;
import java.util.Scanner;

public class THYRezervasyonSistemi extends UcakRezervasyonSistemi {
	
	public THYRezervasyonSistemi(int koltukSayisi) {
		super(koltukSayisi);
	}

	Scanner scan = new Scanner(System.in);
	Random random = new Random();

	public void rezervasyonAl() {
		System.out.println();
		System.out.println("THY Rezervasyon Sistemine Ho�geldiniz!");
		if (ucakDoluMu() == true) {
			System.out.println("Maalesef u�ak dolu, rezervasyon alam�yoruz.");
			return;
		}
		
		System.out.println("Business class u�mak i�in 0'a bas�n�z, ekonomi class u�mak i�in 1'e bas�n�z : ");
		int i = scan.nextInt();
		switch (i) {
		case 0:
			BusinessTHY();
			break;

		case 1:
			EkonomiTHY();
			break;

		default:
			System.out.println("Hatal� giri� yapt�n�z!");
			break;

		  }
		}

	
     public void BusinessTHY() {
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



    public void EkonomiTHY() {
    	 if (ekonomiDoluMu() == true) {
  			System.out.println("Maalesef business koltuklar�m�z dolu! Rezervasyon alam�yoruz");
  			return;
  		}
    	 System.out.println("A�a��daki bo� koltuklardan birini se�iniz");
    	 for (int j = 5; j < koltuklar.length; j++) {
 			if (koltuklar[j] == false) {
 				System.out.print(j+1+" ");
 			}
 		}
    	 
    	 System.out.println();	
         int i = scan.nextInt();
         while(i<6 || i>koltuklar.length || koltuklar[i-1]==true) {
      	   System.out.println("Yanl�� koltuk numaras� girildi, tekrar giriniz : ");
      	   i=scan.nextInt();
         }
         System.out.println("Koltuk no: "+i+" ad�n�za rezerve edildi!");
         System.out.println("�yi u�u�lar!");
         koltuklar[i-1]=true;
    	 
    }

}
