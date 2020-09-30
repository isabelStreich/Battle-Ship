import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Menu extends JFrame{

	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;

	public static Object regles;
	public static Menu monMenu=null;
		
	
	public Menu() {
		
		setTitle("Bataille Navale");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.CYAN);
		//this.pack();
		setLayout(new GridLayout(5,1));
		
		
		JPanel jpanel = new JPanel ();
		jpanel.setLayout(new FlowLayout());
		JPanel jpanel2 = new JPanel ();
		jpanel2.setLayout(new FlowLayout());
		JPanel jpanel3 = new JPanel ();
		jpanel3.setLayout(new FlowLayout());
		JPanel jpanel4 = new JPanel ();
		jpanel4.setLayout(new FlowLayout());
		JPanel jpanel5 = new JPanel ();
		jpanel5.setLayout(new FlowLayout());
		
		JLabel label = new JLabel ("Bataille Navale! ");
		JLabel label2 = new JLabel ("Allons jouer!");
		label.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,50));
		label2.setFont(new Font("Bahnschrift SemiBold",Font.BOLD,18));
		jpanel.add(label);
		jpanel2.add(label2);
		
		
		JButton aProposDe = new JButton ("A propos de...");
		aProposDe.addActionListener(new MenuListener (1));
		aProposDe.setFont(new Font ("Bahnschrift SemiBold",Font.BOLD,12));
		aProposDe.setPreferredSize(new Dimension(160,50));
		
		
		jpanel3.setLayout(new FlowLayout());
		jpanel3.add(aProposDe);
		
		JButton regles = new JButton ("Regles...");
		regles.addActionListener(new MenuListener (2));
		regles.setFont(new Font ("Bahnschrift SemiBold",Font.BOLD,12));
		regles.setPreferredSize(new Dimension(160,50));
				
		jpanel4.setLayout(new FlowLayout());
		jpanel4.add(regles);
		
		JButton jouer = new JButton ("Jouer");
		jouer.addActionListener(new MenuListener (3));
		jouer.setFont(new Font ("Bahnschrift SemiBold",Font.BOLD,12));
		jouer.setPreferredSize(new Dimension(160,50));
				
		jpanel5.setLayout(new FlowLayout());
		jpanel5.add(jouer);
		
		add(jpanel);
		add(jpanel2);
		add(jpanel3);
		add(jpanel4);
		add(jpanel5);
		jpanel.setBackground(Color.CYAN);
		jpanel2.setBackground(Color.CYAN);
		jpanel3.setBackground(Color.CYAN);
		//jpanel3.setBorder(new LineBorder(Color.LIGHT_GRAY, 10));
		jpanel4.setBackground(Color.CYAN);
		//jpanel4.setBorder(new LineBorder(Color.LIGHT_GRAY, 10));
		jpanel5.setBackground(Color.CYAN);
		//jpanel5.setBorder(new LineBorder(Color.LIGHT_GRAY, 10));
		
		
		
		
		setVisible(true);
		
	}

	/*public static void main(String[] args) {
		Menu menuPrincipal = new Menu ();
		//new Regles ();
		//new AProposDe ();

	}*/

	public static Menu getInstance() {
		if (monMenu==null)
			monMenu=new Menu();
		
		return monMenu;
	}
	
}


/*
public class Menu {

	public Menu() {
		// TODO Auto-generated constructor stub
	}

}
*/