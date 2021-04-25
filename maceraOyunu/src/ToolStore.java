
public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Ma�aza");

	}

	public boolean getLocation() {
		System.out.println("Para : " + player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Z�rhlar");
		System.out.println("3. ��k��");
		System.out.print("Se�iminiz : ");
		int selTool = scan.nextInt();
		int selItemID;
		switch (selTool) {
		case 1:
            selItemID = weaponMenu();
            buyWeapon(selItemID);
			break;
		
		case 2:
			selItemID=armorMenu();
			buyArmor(selItemID);
			break;
		
			
		default:
			break;
		}
		return true;
	}
	
	public int armorMenu() {
		System.out.println("1. Hafif\t < Para:15 Engelleme:1 >");
		System.out.println("2. Orta \t < Para:25 Engelleme:3 >");
		System.out.println("3. A��r \t < Para:40 Engelleme:5 >");
		System.out.println("4. ��k�� Yap");
		System.out.print("L�tfen Bir Z�rh Se�iniz : ");
		int selArmorID=scan.nextInt();
		return selArmorID;
	}
	
	public void buyArmor(int itemID) {
		int armor=0;
		int price=0;
		String aName=null;
		switch (itemID) {
		case 1:
			armor=1;
			aName="Hafif";
			price=15;
			break;
		case 2:
			armor=3;
			aName="Orta";
			price=25;
			break;
		case 3:
			armor=5;
			aName="A��r";
			price=40;
			break;
		case 4:
			System.out.println("��k�� Yap�ld�");
			break;

		default:
			System.out.println("Ge�ersiz ��lem");
			break;
			}
		if(price>0) {
			if(player.getMoney()>=price) {
				player.inv.setArmor(armor);
				player.inv.setaName(aName);
				player.setMoney(player.getMoney()-price);
				System.out.println(aName +" Z�rh�n�n Al�m� Ger�ekle�ti. Engellenen Hasar :"+player.inv.getArmor());
				System.out.println(player.getMoney());
				}else {
					System.out.println("Yetersiz Bakiye");
				}
		}
	}
	
	
	
	
	public int weaponMenu() {
		System.out.println("1. Tabanca\t < Para:25 Hasar:2 >");
		System.out.println("2. K�l��\t < Para:35 Hasar:3 >");
		System.out.println("3. T�fek\t < Para:45 Hasar:7 >");
		System.out.println("4. ��k�� Yap");
		System.out.print("L�tfen Bir Silah Se�iniz : ");
		int selWeaponID =scan.nextInt();
		return selWeaponID;
		
	}
	
	public void buyWeapon(int itemID) {
		int damage=0;
		int price=0;
		String wName=null;
		switch (itemID) {
		case 1:
			damage=2;
			wName="Tabanca";
			price=25;
			break;
		case 2:
			damage=3;
			wName="K�l��";
			price=35;
			break;
		case 3:
			damage=7;
			wName="T�fek";
			price=45;
			break;
		case 4:
			System.out.println("��k�� Yap�ld�");
			break;

		default:
			System.out.println("Ge�ersiz ��lem");
			break;	
	}
		if(price>0) {
			if(player.getMoney()>price) {
				player.inv.setDamage(damage);
				player.inv.setwName(wName);
				player.setMoney(player.getMoney()-price);
				System.out.println(wName +" Silah�n�n Al�m� Ger�ekle�ti. �nceki Hasar :"+player.getDamage()
				+"  Yeni Hasar:"+ player.getTotalDamage());
				}else {
					System.out.println("Yetersiz Bakiye");
				}
		}
		
	}
}


	






















