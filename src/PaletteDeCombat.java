//package battleShipSteeve;

//Model

import java.awt.Color;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//import sun.tools.jconsole.BorderedComponent;
//import javax.swing.JRadioButton;





 
public class PaletteDeCombat extends JFrame{

		
		private JButton lesBoutons[][] = new JButton[10][10];
		private JTextField scoreIA;
		static private PaletteDeCombat instance;
		private JTextField scoreJoueur;


		public JButton[][] getLesBoutons() {
			return lesBoutons;
		}
		
		
		static public PaletteDeCombat getNouvelleInstance() {
			if (instance!=null)
				instance.dispose();
			instance = new PaletteDeCombat();
			
			return instance;
		}
		
		public static PaletteDeCombat getInstance() {
			if (instance==null)
				instance=new PaletteDeCombat();
			
			return instance;
		}
		

		JPanel lesComposants = new JPanel();
		JPanel grilleDeBoutons;
		JPanel lesComposantsBoutonDeMenuMain;

		 int ligne;
		 int colonnes;
		 int tailleGrille=10;

		 GridBagConstraints gbc;
		public PaletteDeCombat() {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setPreferredSize(new Dimension(600, 600));
			
			setTitle("Bataille navale");
			setLocationRelativeTo(null);

			lesComposants = new JPanel();
			lesComposants.setLayout(new GridBagLayout()); 

			grilleDeBoutons = new JPanel();
			grilleDeBoutons.setLayout(new GridLayout(10, 10));
			
			//cree les boutons pour l'espace de jeu
			for (ligne = 0; ligne < tailleGrille; ligne++) {
				for (colonnes = 0; colonnes < tailleGrille; colonnes++) {
					lesBoutons[ligne][colonnes] = new JButton();
					lesBoutons[ligne][colonnes].setBackground(Color.ORANGE); 
					lesBoutons[ligne][colonnes].setPreferredSize(new Dimension(100, 100));
					lesBoutons[ligne][colonnes].addActionListener(new battle(ligne, colonnes));
					grilleDeBoutons.add(lesBoutons[ligne][colonnes]);
				}
			}

	       //contraint le layout à le positionner de facon specifique
			gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.weighty = 0.65;
			lesComposants.add(grilleDeBoutons, gbc);

			gbc.weighty = 0.05;
			gbc.gridy = 1;

	      	lesComposantsBoutonDeMenuMain = new JPanel();
			lesComposantsBoutonDeMenuMain.setLayout(new GridLayout());
			
			
			JButton monMenu = new JButton("MenuPrincipal");
			monMenu.addActionListener(new MenuListener(4));
			monMenu.setPreferredSize(new Dimension(30, 50));
			lesComposantsBoutonDeMenuMain.add(monMenu);
			
			JButton instructions = new JButton("Recommencer");
			instructions.addActionListener(new MenuListener(5)); 
			instructions.setPreferredSize(new Dimension(30, 50));
			lesComposantsBoutonDeMenuMain.add(instructions);

			
			lesComposants.add(lesComposantsBoutonDeMenuMain, gbc);
			JPanel etatDesScores = new JPanel();
			etatDesScores.setLayout(new GridLayout());

			JLabel etiketteDirection = new JLabel("Points IAS: ");
			etatDesScores.add(etiketteDirection);
			
			//Border bdFactory=new Border() 
	       //tableau de score
			scoreIA = new JTextField("ScoreIA");
			scoreIA.setBackground(Color.DARK_GRAY);
			scoreIA.setEnabled(false);
			etatDesScores.add(scoreIA);
			
			
			JLabel etiketteDirectionJ = new JLabel("Points Joueur: ");
			etatDesScores.add(etiketteDirectionJ);
			scoreJoueur = new JTextField("Points Joueur");
			scoreJoueur.setBackground(Color.DARK_GRAY);
			scoreJoueur.setEnabled(false);
			
			
			
			etatDesScores.add(scoreJoueur);
			
			gbc.weighty = 0.05;
			gbc.gridy = 2;
			lesComposants.add(etatDesScores,gbc);
			
			setContentPane(lesComposants);
			pack();
			setVisible(true);
		}

		public void setScoreIA(String scoreIA) {
			this.scoreIA.setText(scoreIA);
		}


		public void setScoreJoueur(String scoreJoueur) {
			this.scoreJoueur.setText(scoreJoueur);
		}
		
		
		
		

}
