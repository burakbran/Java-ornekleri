
public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
		
	}
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("Saðlýk Doldu");
		System.out.println("Þuan Güvenli Evdesiniz");
		
	
		
		return true;
	}

  }


