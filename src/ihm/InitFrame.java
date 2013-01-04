package ihm;

import scheduler.*;
import interaction.*;
import ihm.Plan;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;	
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import environnement.*;


public class InitFrame {

	private JFrame frame;
	public JLabel Image = new JLabel( new ImageIcon("Images//Belfort.jpg"));
	private static JTextField nomJ1;
	private static JTextField nomJ2;
 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public InitFrame(TypeUv tabUv[]) {
		initialize(tabUv);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
		
	
	private void initialize(final TypeUv tabUv[]) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 	 
		
		JButton btnLancerLaPartie = new JButton("Lancer la partie");
		btnLancerLaPartie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			    
				frame.setVisible(false);
				
				/*Choix fen = new Choix();
				fen.getF().setVisible(true);
				fen.NomJoueur(nomJ1.getText());*/
		
				Plan carte = new Plan(tabUv);
				carte.getF().setVisible(true); 
				carte.setNomJoueur(nomJ1.getText());
				carte.setPhoto(1);
			
				
			}
		});
		
		 
		btnLancerLaPartie.setBounds(410, 497, 164, 31);
		frame.getContentPane().add(btnLancerLaPartie);
		
		JComboBox choixCarte = new JComboBox();
		choixCarte.setToolTipText(" ");
		choixCarte.setBounds(410, 195, 152, 24);
		choixCarte.addItem("Belfort");
		choixCarte.addItem("Montbeliard");
		choixCarte.addItem("Sevenans");
		frame.getContentPane().add(choixCarte);
		choixCarte.addItemListener(new ItemState());
		 
		
		
		JLabel lblChoixDeLa = new JLabel("Choix de la Carte :");
		lblChoixDeLa.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		lblChoixDeLa.setBounds(87, 177, 280, 53);
		frame.getContentPane().add(lblChoixDeLa);
		

		Image.setBounds(657, 161, 329, 196);
		frame.getContentPane().add(Image); 
		Image.setIcon(new ImageIcon("Images//Belfort.jpg"));
		
		JLabel ban = new JLabel( new ImageIcon("Images//icon.jpg"));
		ban.setText("Banniere");
		ban.setBounds(266, 12, 477, 102);
		frame.getContentPane().add(ban);
		
		JLabel lblNewLabel_1 = new JLabel("Aper\u00E7u");
		lblNewLabel_1.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		lblNewLabel_1.setBounds(694, 131, 141, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblJoueurs = new JLabel("Joueurs");
		lblJoueurs.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		lblJoueurs.setBounds(410, 251, 124, 53);
		frame.getContentPane().add(lblJoueurs);
		
		nomJ1 = new JTextField();
		nomJ1.setText("Joueur 1");
		nomJ1.setBounds(410, 322, 174, 31);
		frame.getContentPane().add(nomJ1);
		nomJ1.setColumns(10);
		
		nomJ2 = new JTextField();
		nomJ2.setText("Joueur 2");
		nomJ2.setBounds(410, 364, 174, 31);
		frame.getContentPane().add(nomJ2);
		nomJ2.setColumns(10);
	}
	 
		/* Impl?mentation de l'aper?u  */
	
	 class ItemState implements ItemListener{
		    public void itemStateChanged(ItemEvent e) {
		      System.out.println("Evenement d?clench? sur : " + e.getItem());
		      
		      if(e.getItem() == "Montbeliard")
		      {
		    	  Image.setIcon(new ImageIcon("Images//Mont.jpg"));	 
		      }
		      else if(e.getItem() == "Belfort")
		      {
		    	  Image.setIcon(new ImageIcon("Images//Belfort.jpg"));
		      }
		      else if(e.getItem() == "Sevenans")
		      {
		    	  Image.setIcon(new ImageIcon("Images//Sevenans.jpg"));
		      }
		    }
	 }
	 
	 
	 /* Accesseurs */
	 
	 public void visible () {
		 frame.setVisible(true);
	 }
	 
	 public static String getTextField(int a){
		 if(a == 1)
		 {
			 return nomJ1.getText();
		 }
		 else 
		 {
			 return nomJ2.getText();
		 }
		
	 }
}
