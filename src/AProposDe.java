import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AProposDe  extends JFrame{

	
	private static final long serialVersionUID = 1L;

	public AProposDe() {
		// TODO Auto-generated constructor stub
		
		JFrame about = new JFrame();
		about.setTitle("A Propos De");
		about.setPreferredSize(new Dimension(700,200));
		about.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel aboutPanel = new JPanel();
		
		JTextArea text = new JTextArea ("La bataille navale, appelée aussi touché-coulé, est un jeu de société dans lequel deux joueurs doivent placer des « navires » sur une grille tenue secrète \r\n" + 
				"et tenter de « toucher » les navires adverses. Le gagnant est celui qui parvient à couler tous les navires de l'adversaire avant que tous les siens ne le \r\n" + 
				"soient. On dit qu'un navire est coulé si chacune de ses cases a été touchées par un coup de l'adversaire.\r\n" + 
				"\r\n" + 
				"Le principe du jeu de bataille navale semble trouver son origine dans le jeu français L'Attaque1 lors de la Première Guerre mondiale. \r\n" + 
				"On a aussi trouvé des liens de parenté avec le jeu de E. I. Horseman en 1890 (Baslinda2) et on dit que des officiers russes \r\n" + 
				"y auraient joué antérieurement à la première guerre3. La première version commerciale du jeu fut publiée en 1931 par la Starex Novelty Co.\r\n" + 
				" sous le nom de Salvo4. Ce jeu est devenu populaire lors de son apparition en 1943 dans les publications américaines de divertissement \r\n" + 
				" de la Milton Bradley Company qui l'exploita sous la forme papier jusqu'en 1967, où elle sortit un jeu de plateau5, puis en réalisa une version \r\n" + 
				" électronique en 1977.");
		text.setRows(10);
		text.setColumns(10);
		
		aboutPanel.add(text);
		//aboutPanel.setBorder(new LineBorder(Color.GRAY, 50));
		about.add(aboutPanel,"Center");
	    
		about.add(aboutPanel);
		about.setResizable(true);
		about.setVisible(true);
		about.pack();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AProposDe ();

	}

}
