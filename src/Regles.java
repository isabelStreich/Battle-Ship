import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Regles extends JFrame {

	private static final long serialVersionUID = 1L;
	

	public Regles() {
		// TODO Auto-generated constructor stub
		
		JFrame reglesJoue = new JFrame();
		reglesJoue.setTitle("Regles");
		reglesJoue.setPreferredSize(new Dimension(700,200));
		reglesJoue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel reglesPanel = new JPanel();
		
		JTextArea text = new JTextArea ("La bataille navale oppose deux joueurs qui s'affrontent. Chacun a une flotte composée de 4 bateaux, qui sont les suivants :\r\n" + 
				"un porte avion (4 cases),"
				+ " un destroyer (3 cases),"
				+ " un sous-marin (3 cases) et "
				+ "un bateau patrouille (2 cases).\r\n" + 
				"Les bateaux ne doivent pas être collés entre eux. Au début du jeu, chaque joueur place ses bateaux sur sa grille. \r\n" + 
				"Un à un, les joueurs vont \"tirer\" sur une case de l'adversaire.Le but est donc de couler les bateaux adverses.\r\n" + 
				"Une partie de bataille navale se termine lorsque l’un des joueurs n’a plus de navires.\r\n" + 
				"Pour gagner plus rapidement, vous pouvez jouer vos tirs en croix.");
		text.setRows(10);
		text.setColumns(10);
		
		reglesPanel.add(text);
		//reglesPanel.add(reglesPanel);
		//reglesPanel.setBorder(new LineBorder(Color.GRAY, 50));
		reglesJoue.add(reglesPanel,"Center");
	    
		reglesJoue.add(reglesPanel);
		reglesJoue.setResizable(true);
		reglesJoue.setVisible(true);
		reglesJoue.pack();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Regles ();

	}

}
