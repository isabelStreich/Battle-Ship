import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

	private int numeroBouton;
	private PaletteJeu test;
	public MenuListener(int numeroBouton) {
		this.numeroBouton = numeroBouton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (numeroBouton == 1) {
			
			new AProposDe ();
		}
		if (numeroBouton == 2) {

		new Regles();
		}
		if (numeroBouton == 3) {

			//new Jouer();
			test=PaletteJeu.getInstance();
			test.setMesBoutons();
			test.setVisible(true);
			
			}
			if (numeroBouton==4) {
				System.out.println("Menu principal");
				
				PaletteJeu.getNouvelleInstance();
				//PaletteDeCombat.getNouvelleInstance();
			}
		
			if (numeroBouton==5) {
				//PaletteDeCombat.getInstance().dispose();
				
				System.out.println("je recommence");
			}
	}

	public int getNumeroBouton() {
		return numeroBouton;
	}

	public void setNumeroBouton(int numeroBouton) {
		this.numeroBouton = numeroBouton;
	}

}

