
public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "G�venli Ev");
		
	}
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("Sa�l�k Doldu");
		System.out.println("�uan G�venli Evdesiniz");
		
	
		
		return true;
	}

  }


