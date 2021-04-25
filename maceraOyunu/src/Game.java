import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	
	public void login() {
		System.out.println("Macera Oyununa Hoþgeldiniz");
		System.out.print("Oyuna baþlamadan önce isminizi giriniz : ");
		String playerName = scan.next();
		player = new Player(playerName);
		player.selectCha();
		start();
		}
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("==========================================================");
			System.out.println();
			System.out.println("Eylem Gerçekleþtirmek Ýçin Bir Yer Seçiniz");
			System.out.println("1. Güvenli Ev --> Size ait güvenli bir mekan, düþman yok");
			System.out.println("2.   Maðara   --> Karþýnýza Zombi Çýkabilir");
			System.out.println("3.    Orman   --> Karþýnýza Vampir Çýkabilir ");
			System.out.println("4.    Nehir   --> Karþýnýza Ayý Çýkabilir");
			System.out.println("5.   Maðaza   --> Silah veya Zýrh Alabilirsiniz ");
			System.out.print("SEÇÝMÝNÝZ : ");
			int selLoc = scan.nextInt();
			System.out.println();
			while(selLoc<1 || selLoc>5) {
				System.out.print("Geçersiz Yer Seçildi. Lütfen Geçerli Bir Yer Seçiniz : ");
				selLoc = scan.nextInt();
			}
			
			switch(selLoc) {
			case 1 : 
				location = new SafeHouse(player) ;
				break;
			case 2 : 
				location = new Cave(player) ;
				break;
			case 3 : 
				location = new Forest(player) ;
				break;
			case 4 : 
				location = new River(player) ;
				break;
			case 5 : 
				location = new ToolStore(player) ;
				break;
			default : 
				location = new SafeHouse(player);
			}
			if(location.getClass().getName().equals("SafeHouse")) {
				if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Tebrikler Oyunu Baþarýyla Bitirdiniz");
					break;
				}
			}
			 if(!location.getLocation()) {
			System.out.println("Oyun Bitti");
				break;
				
			}
		}
	}
	

}






























