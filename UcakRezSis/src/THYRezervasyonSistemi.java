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
		System.out.println("THY Rezervasyon Sistemine Hoþgeldiniz!");
		if (ucakDoluMu() == true) {
			System.out.println("Maalesef uçak dolu, rezervasyon alamýyoruz.");
			return;
		}
		
		System.out.println("Business class uçmak için 0'a basýnýz, ekonomi class uçmak için 1'e basýnýz : ");
		int i = scan.nextInt();
		switch (i) {
		case 0:
			BusinessTHY();
			break;

		case 1:
			EkonomiTHY();
			break;

		default:
			System.out.println("Hatalý giriþ yaptýnýz!");
			break;

		  }
		}

	
     public void BusinessTHY() {
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



    public void EkonomiTHY() {
    	 if (ekonomiDoluMu() == true) {
  			System.out.println("Maalesef business koltuklarýmýz dolu! Rezervasyon alamýyoruz");
  			return;
  		}
    	 System.out.println("Aþaðýdaki boþ koltuklardan birini seçiniz");
    	 for (int j = 5; j < koltuklar.length; j++) {
 			if (koltuklar[j] == false) {
 				System.out.print(j+1+" ");
 			}
 		}
    	 
    	 System.out.println();	
         int i = scan.nextInt();
         while(i<6 || i>koltuklar.length || koltuklar[i-1]==true) {
      	   System.out.println("Yanlýþ koltuk numarasý girildi, tekrar giriniz : ");
      	   i=scan.nextInt();
         }
         System.out.println("Koltuk no: "+i+" adýnýza rezerve edildi!");
         System.out.println("Ýyi uçuþlar!");
         koltuklar[i-1]=true;
    	 
    }

}
