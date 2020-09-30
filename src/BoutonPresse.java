//package battleShipSteeve;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class BoutonPresse implements ActionListener{
	static public int leBateauActuelAplacer=0;
	private int ligneSelectionne=0;
	private int colonneSelectionne=0;
	JButton [][]lesBoutons;
	JButton leBoutonSelectionne;
	static private int[][]lesPositionsDesBateauxJoueurs=new int[10][10];
	static private int[][]positionsBateauxEnnemies=new int[10][10];
	
	static PaletteDeCombat surfaceDeCombat;
	
	public BoutonPresse(int laLigne, int laColonne) {
		ligneSelectionne=laLigne;
		colonneSelectionne=laColonne;
		lesBoutons=PaletteJeu.getInstance().getMesBoutons();
		leBoutonSelectionne=lesBoutons[laLigne][laColonne];
		
	}

	public static int[][] getLesPositionsDesBateauxJoueurs() {
		return lesPositionsDesBateauxJoueurs;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		boolean test=estLibre(PaletteJeu.getInstance().getDirectionActive(), PaletteJeu.getInstance().getLeCombat().getLeBateauActuelle());
		char direction=PaletteJeu.getInstance().getDirectionActive();
		//active les boutons
		try {
			if (test==true)
				switch (direction) {
				case 'v':
					for (int i=0; i<PaletteJeu.getInstance().getLeCombat().getLeBateauActuelle(); i++) {
						lesBoutons[ligneSelectionne+i][colonneSelectionne].setEnabled(false);
						lesBoutons[ligneSelectionne+i][colonneSelectionne].setBackground(Color.gray);
						//pour enregistrer la position des bateaux du joueur
						lesPositionsDesBateauxJoueurs[ligneSelectionne+i][colonneSelectionne]=1;
						
						//l'ennemi positionne ces bateaux
						if (colonneSelectionne+1<10)
							positionsBateauxEnnemies[ligneSelectionne+i][colonneSelectionne+1]=1;
						else
							positionsBateauxEnnemies[ligneSelectionne+i][colonneSelectionne-1]=1;
					}
					break;
				
				case 'h':
					for (int i=0; i<PaletteJeu.getInstance().getLeCombat().getLeBateauActuelle(); i++) {
						lesBoutons[ligneSelectionne][colonneSelectionne+i].setEnabled(false);
						lesBoutons[ligneSelectionne][colonneSelectionne+i].setBackground(Color.gray);
						//pour enregistrer la position des bateaux du joueur
						lesPositionsDesBateauxJoueurs[ligneSelectionne+i][colonneSelectionne]=1;
						
						//l'ennemi positionne ces bateaux
						positionsBateauxEnnemies[ligneSelectionne+1][colonneSelectionne+i]=1;
					}
					break;
					
				}
		
			
		
		if (leBateauActuelAplacer<4) {
			PaletteJeu.getInstance().getLeCombat().setLeBateauActuelle(PaletteJeu.getInstance().getLeCombat().getTousLesBateaux()[leBateauActuelAplacer]);
			leBateauActuelAplacer++;
		
		}else 
			if(JOptionPane.showConfirmDialog(leBoutonSelectionne, "Etes vous prêt pour le combat ?", "Bataille navale", 0)==JOptionPane.OK_OPTION) {
				System.out.println("le frame de combat");
				surfaceDeCombat=PaletteDeCombat.getInstance();
				
				PaletteJeu.getInstance().setEnabled(false);
			}
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("hors limite");
			
		}	
				
	}

	public static int getnbrDeBateauxJoueur() {
		int cpt=0;
		for (int i = 0; i < 10; i++) 
			for (int j = 0; j < 10; j++) 
				if(lesPositionsDesBateauxJoueurs[i][j]==1) 
					cpt++;
					
		return cpt;
	
	}
		
	public static int getnbrDeBateauxEnnemies() {
		int cpt=0;
		for (int i = 0; i < 10; i++) 
			for (int j = 0; j < 10; j++) 
				if(positionsBateauxEnnemies[i][j]==1) 
					cpt++;
					
		return cpt;
	
	}
	
	public static int[][] getPositionsBateauxEnnemies() {
		return positionsBateauxEnnemies;
	}

	
	//verifie les boutons vides
	private Boolean estLibre(char direction, int distance) {
		int nbrEspaceLibre=0; 
		boolean esLibre=false;
		
			try {
				
				if (direction=='v')
					for (int i=0; i<distance; i++)
						if (lesBoutons[ligneSelectionne+i][colonneSelectionne].isEnabled()!=false) 
							nbrEspaceLibre++;
				
				if (direction=='h')
					for (int i=0; i<distance; i++)
						if (lesBoutons[ligneSelectionne][colonneSelectionne+i].isEnabled()!=false) 
							nbrEspaceLibre++;
				
			} catch (ArrayIndexOutOfBoundsException e2) {
				System.out.println("hors de la grille");
			}
			
		if (nbrEspaceLibre==distance)
			esLibre=true;
		
		
		return esLibre;
	}
	
	
	
	
	
}
