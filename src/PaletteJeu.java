//package battleShipSteeve;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class PaletteJeu extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel lesComposants = new JPanel();
	JPanel grilleDeBoutons;
	JPanel panneauDeDirection;
	JPanel tailleBateau;
	JPanel lesComposantsBoutonDeMenuMain;

	GridBagConstraints gbc;

	private JLabel infoTailleBateau;

   //cree une matrice 10*10
	private JButton mesBoutons[][] = new JButton[10][10];
	
	
	private static JRadioButton vertical1;
	private static JRadioButton horizontal1;
	
	
	private int tailleGrille;
	
	static private PaletteJeu instance;
	
	

	private  CombatNaval leCombat=new CombatNaval();
	


	public PaletteJeu(int tailleGrille, int height, int width) {
		this.tailleGrille = 10;

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(width, height));
		//setVisible(true);
		setTitle("Bataille navale");
		

		lesComposants = new JPanel();
		lesComposants.setLayout(new GridBagLayout()); 

		grilleDeBoutons = new JPanel();
		grilleDeBoutons.setLayout(new GridLayout(10, 10));
		
		//cree les boutons pour l'espace de jeu
		

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

       //position que doit prendre les bateaux
		panneauDeDirection = new JPanel();
		panneauDeDirection.setLayout(new GridLayout());

		JLabel etiketteDirection = new JLabel("Direction du bateau à placer: ");
		panneauDeDirection.add(etiketteDirection);

       //valeur de direction
		horizontal1=new JRadioButton();
		horizontal1.setText("Horizontal");
		horizontal1.setActionCommand("HORIZONTAL");
		
	
		
		vertical1=new JRadioButton();
		vertical1.setText("Verticale");
		vertical1.setSelected(true);
		vertical1.setActionCommand("VERTICALE");
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(horizontal1);
		group.add(vertical1);
		panneauDeDirection.add(horizontal1);
		panneauDeDirection.add(vertical1);
		
		lesComposants.add(panneauDeDirection, gbc);

		gbc.weighty = 0.20;
		gbc.gridy = 2;

		tailleBateau = new JPanel();
		tailleBateau.setLayout(new GridLayout());

		JLabel infoPosition = new JLabel("Taille du bateau à placer: ");
		tailleBateau.add(infoPosition);

		infoTailleBateau = new JLabel(leCombat.getLeNomDuBateau(leCombat.getLeBateauActuelle()));
		tailleBateau.add(infoTailleBateau);

		lesComposants.add(tailleBateau, gbc);

		gbc.weighty = 0.10;
		gbc.gridy = 3;

       
		lesComposantsBoutonDeMenuMain = new JPanel();
		lesComposantsBoutonDeMenuMain.setLayout(new GridLayout());

		/*mainMenu = new JButton("Main Menu");
		mainMenu.addActionListener(new gameMenuListener());
		mainMenu.setPreferredSize(new Dimension(30, 50));
		lesComposantsBoutonDeMenuMain.add(mainMenu);
		instructions = new JButton("Instructions");
		
		//allows user to interact with the in-game instructions built by the original authors
		instructions.addActionListener(new gameMenuListener()); 
		instructions.setPreferredSize(new Dimension(30, 50));
		lesComposantsBoutonDeMenuMain.add(instructions);*/

		lesComposants.add(lesComposantsBoutonDeMenuMain, gbc);

		setContentPane(lesComposants);
		pack();
		
	}
	
	static public PaletteJeu getInstance() {
		if (instance==null)
			instance=new PaletteJeu(10, 600, 600);
		
		return instance;
	}

	static public PaletteJeu getNouvelleInstance() {
		if (instance!=null)
			instance.dispose();
		instance = new PaletteJeu(10, 600, 600);
		
		return instance;
	}

	
	public  JButton[][] getMesBoutons() {
		return mesBoutons;
	}

	
	public  CombatNaval getLeCombat() {
		return leCombat;
	}

	public void setMesBoutons() {
		for (int i = 0; i < tailleGrille; i++) {
			for (int j = 0; j < tailleGrille; j++) {
				mesBoutons[i][j] = new JButton();
				mesBoutons[i][j].setBackground(Color.ORANGE); 
				mesBoutons[i][j].setPreferredSize(new Dimension(100, 100));
				mesBoutons[i][j].addActionListener(new BoutonPresse(i, j));
				grilleDeBoutons.add(mesBoutons[i][j]);
			}
		}
	}


	public char getDirectionActive() {
		if (vertical1.isSelected()==true)
			return 'v';
		else 
			return 'h';
	}
	
	}
