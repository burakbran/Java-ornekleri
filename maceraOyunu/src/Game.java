import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	
	public void login() {
		System.out.println("Macera Oyununa Ho�geldiniz");
		System.out.print("Oyuna ba�lamadan �nce isminizi giriniz : ");
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
			System.out.println("Eylem Ger�ekle�tirmek ��in Bir Yer Se�iniz");
			System.out.println("1. G�venli Ev --> Size ait g�venli bir mekan, d��man yok");
			System.out.println("2.   Ma�ara   --> Kar��n�za Zombi ��kabilir");
			System.out.println("3.    Orman   --> Kar��n�za Vampir ��kabilir ");
			System.out.println("4.    Nehir   --> Kar��n�za Ay� ��kabilir");
			System.out.println("5.   Ma�aza   --> Silah veya Z�rh Alabilirsiniz ");
			System.out.print("SE��M�N�Z : ");
			int selLoc = scan.nextInt();
			System.out.println();
			while(selLoc<1 || selLoc>5) {
				System.out.print("Ge�ersiz Yer Se�ildi. L�tfen Ge�erli Bir Yer Se�iniz : ");
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
					System.out.println("Tebrikler Oyunu Ba�ar�yla Bitirdiniz");
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






























