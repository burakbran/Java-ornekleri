

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;

	public BattleLoc(Player player, String name, Obstacle obstacle,String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award=award;

	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("�uan Buradas�n�z : " + this.getName());
		System.out.println("Dikkatli Ol ! Burada " + obsCount + " Tane " + obstacle.getName() + " Ya��yor.");
		System.out.print("<S>ava� veya <K>a� : ");
		String selCase = scan.next();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " B�lgesindeki T�m D��manlar� Temizlediniz");
				if(this.award.equals("Yemek")&& player.getInv().isFood()==false) {
					System.out.println(this.award+" Kazand�n�z");
					player.getInv().setFood(true);
				}else if(this.award.equals("Odun")&& player.getInv().isFirewood()==false) {
					System.out.println(this.award+" Kazand�n�z");
					player.getInv().setFirewood(true);
				}else if(this.award.equals("Su")&& player.getInv().isWater()== false) {
					System.out.println(this.award+" Kazand�n�z");
					player.getInv().setWater(true);
				}
				return true;
			} if(player.getHealthy()<=0) {
				System.out.println("�ld�n�z");
				return false;
			}
		}
		return true;
	}
     
	public boolean combat(int obsCount) {
		for(int i=0;i<obsCount;i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while(player.getHealthy()>0 && obstacle.getHealth()>0) {
				System.out.print("<V>ur veya <K>a� : ");
				String selCase = scan.next();
				selCase = selCase.toUpperCase();
				if(selCase.equals("V")) {
					System.out.println("Vuru� Yapt�n�z");
					obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
					afterHit();
					if(obstacle.getHealth()>0) {
					System.out.println();
					System.out.println(obstacle.getName()+" size vurdu");
					player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.inv.getArmor()));
					afterHit();
					}
					}else {
						return false;
					}
				
			}
			if(obstacle.getHealth()<=0 && player.getHealthy()>0) {
				System.out.println("D��man� �ld�rd�n�z");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("G�ncel Paran�z : "+player.getMoney());
				obstacle.setHealth(defObsHealth);
				System.out.println("-----------------------------");
			}else {
				return false;
			}
		}

		return true;
	}
	
	public void playerStats() {
		System.out.println("\nOyuncu De�erleri\n------------------------- ");
		System.out.println("Can : "+player.getHealthy());
		System.out.println("Hasar : "+player.getTotalDamage());
		System.out.println("Para : "+player.getMoney());
		if(player.getInv().getDamage()>0) {
			System.out.println("Silah : "+player.getInv().getwName());
		}
		if(player.getInv().getArmor()>0) {
			System.out.println("Z�rh : "+player.getInv().getaName());
		}
	}
	
	public void enemyStats() {
		System.out.println("\n"+obstacle.getName()+" De�erleri\n------------------------- ");
		System.out.println("Can : "+obstacle.getHealth());
		System.out.println("Hasar : "+obstacle.getDamage());
		System.out.println("�d�l : "+obstacle.getAward());
		
	}
	
	public void afterHit() {
		System.out.println("Oyuncu Can� : "+player.getHealthy());
		System.out.println(obstacle.getName()+" Can� : "+obstacle.getHealth());
		System.out.println();
	}

}
