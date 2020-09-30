//package battleShipSteeve;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class battle implements ActionListener{
	private int lignCible;
	private int cologneCible;
	
	static private int[][]lesPositionsDesBateauxEnnemies=new int[10][10];
	
	JButton boutonAppuye;
	Random rnd =new Random();
	static private int leScoreJoueur=BoutonPresse.getnbrDeBateauxJoueur();
	static private int leScoreEnnemies=BoutonPresse.getnbrDeBateauxEnnemies();
	
	public battle(int ligne, int colonne) {
		lignCible=ligne;
		cologneCible=colonne;
		//lesPositionsDesBateauxJoueurs=BoutonPresse.getLesPositionsDesBateauxJoueurs();
		lesPositionsDesBateauxEnnemies=BoutonPresse.getPositionsBateauxEnnemies();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		boutonAppuye=(JButton)e.getSource();
		boutonAppuye.setBackground(Color.LIGHT_GRAY);
		boutonAppuye.setEnabled(false);
		
				if(lesPositionsDesBateauxEnnemies[lignCible][cologneCible]==1) {
					System.out.println("ligne "+lignCible+"\n colon "+cologneCible);
					JOptionPane.showMessageDialog(null, "Touche");
					PaletteDeCombat.getInstance().getLesBoutons()[lignCible][cologneCible].setEnabled(false);
					PaletteDeCombat.getInstance().getLesBoutons()[lignCible][cologneCible].setBackground(Color.blue);
					PaletteDeCombat.getInstance().getLesBoutons()[lignCible][cologneCible].setText("X");
					leScoreEnnemies--;
					System.out.println("le score Joueur: " +leScoreEnnemies);
					PaletteDeCombat.getInstance().setScoreJoueur(String.valueOf(leScoreEnnemies));
					
					
		}
				if (leScoreEnnemies==0) {
					
					JOptionPane.showMessageDialog(null, "<html><h1><b>Bravo !!!!</b>"+ "<br><i>Felicitation vous avez GAGNE;</i></h1></html>");
					if (JOptionPane.showConfirmDialog(boutonAppuye, "Voulez vous recommencer ?")==JOptionPane.YES_OPTION){
						PaletteJeu.getNouvelleInstance();
						PaletteJeu.getInstance().setVisible(true);
						PaletteDeCombat.getNouvelleInstance();
						
					}
					System.exit(0);
				}
			IA(boutonAppuye);
		
		
		
	}
	
	public void IA(JButton leBouton) {
		
		lignCible=rnd.nextInt(9);
		cologneCible=rnd.nextInt(9);
		PaletteJeu.getInstance().getMesBoutons()[lignCible][cologneCible].setBackground(Color.LIGHT_GRAY);
		
		System.out.println("X: "+lignCible+"\nY: "+cologneCible);
		System.out.println("IA a joué");
		if (PaletteJeu.getInstance().getMesBoutons()[lignCible][cologneCible].isEnabled()==false) {
			PaletteJeu.getInstance().getMesBoutons()[lignCible][cologneCible].setText("X");
			PaletteJeu.getInstance().getMesBoutons()[lignCible][cologneCible].setBackground(Color.red);
			System.out.println(" colore: X: "+(lignCible)+"\nY: "+(cologneCible));
			JOptionPane.showMessageDialog(null, "Machine: \n Je t'ai touche");
			leScoreJoueur--;
			System.out.println("le score IA: " +leScoreJoueur);
			PaletteDeCombat.getInstance().setScoreIA(String.valueOf(leScoreJoueur));
			
		}
			
		
	}

}
