import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Jouer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Jouer() {
		// TODO Auto-generated constructor stub
		

		JFrame jouer1 = new JFrame();
		jouer1.setTitle("Jouer");
		jouer1.setPreferredSize(new Dimension(360,250));
		jouer1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel jouerPanel = new JPanel();
		PaletteJeu test=PaletteJeu.getInstance();
		test.setMesBoutons();
		test.setVisible(true);
		test.setEnabled(false);
		
		jouerPanel.add(test);
		//aboutPanel.setBorder(new LineBorder(Color.GRAY, 50));
		jouer1.add(jouerPanel,"Center");
	    
		jouer1.add(jouerPanel);
		jouer1.setResizable(true);
		jouer1.setVisible(true);
		jouer1.pack();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
