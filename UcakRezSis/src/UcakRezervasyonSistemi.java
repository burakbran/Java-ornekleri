
public abstract class UcakRezervasyonSistemi {

	private int koltukSayisi;
	public boolean koltuklar[];

	public UcakRezervasyonSistemi(int koltukSayisi) {
		if (koltukSayisi < 10) {
			System.out.println("Koltuk sayýsý hatalý. Otomatik olarak 10 yapýldý.");
			this.koltukSayisi = 10;
		} else {
			this.koltukSayisi = koltukSayisi;
		}
		
		this.koltuklar = new boolean[this.koltukSayisi];
		
	}

	public abstract void rezervasyonAl();

	public boolean businessDoluMu() {
		for (int i = 0; i < 5; i++) {
			if (koltuklar[i] == false) {
				return false;
			}
		}
		return true;
	}
	public boolean ekonomiDoluMu() {
		for (int j = 5; j < koltuklar.length; j++) {
			if (koltuklar[j] == false) {
				return false;
			}
		}
		return true;
	}

	public boolean ucakDoluMu() {
		if (businessDoluMu() == true && ekonomiDoluMu() == true) {
			return true;
		}
		return false;
	}
	

	public int getKoltukSayisi() {
		return koltukSayisi;
	}

	public void setKoltukSayisi(int koltukSayisi) {
		this.koltukSayisi = koltukSayisi;
	}
	
	
}
