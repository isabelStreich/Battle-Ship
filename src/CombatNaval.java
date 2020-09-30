//package battleShipSteeve;

public class CombatNaval {
	
	 private int porteAvion=4;
	 private int destroyer=3;
	 private int sousMarin=3;
	 private int bateauDePatrouille=2;
	 private int leBateauActuelle;
	 
	 private int[] tousLesBateaux = { porteAvion, destroyer, sousMarin, bateauDePatrouille};
	
	public int getLeBateauActuelle() {
		return leBateauActuelle;
	}


	public int[] getTousLesBateaux() {
		return tousLesBateaux;
	}


	public void setLeBateauActuelle(int bateauActuelle) {
		leBateauActuelle = bateauActuelle;
	}


	public int getBateauDePatrouille() {
		return bateauDePatrouille;
	}

	public CombatNaval() {
		leBateauActuelle=porteAvion;
	}
	
	public String getLeNomDuBateau(int type) {
		String leNom = null;
		switch (type) {
		case 4:
			leNom="Porte Avion";
			break;
			
		case 3:
			leNom="Destroyer";
			break;
			
		case 2:
			leNom="Patrouille";
			break;
			
		}
		
		return leNom;
	}
}
