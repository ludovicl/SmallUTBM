package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import scheduler.Moteur;
import ihm.MessageBox;
import ihm.InitFrame;
//import ihm.Victoire;
import environnement.CG;
import environnement.CS;
import environnement.Langue;
import environnement.Stage;
import environnement.TM;
import environnement.TypeUv;

public class Plan {

	private JFrame frame;
	
	/* Cadre du Joueur*/
	private static JLabel NomJoueur;// = new JLabel("Joueur");
	private static JLabel photoJoueur =  new JLabel("Photo");
	
	//private JButton //tabB[]= new JButton[20];
	
	private MessageBox tabM[] = new MessageBox[20];
	
	
	
	private JTextField info;
	
	/* Cr�ation des UVs */
	private static TypeUv tabUv[]= new TypeUv[20];
	

	/* Stage */
	/*
		private TypeUv stage1 = new Stage("ST40",1);
		//TypeUv stage2 = new Stage("st50",21);
		private		TypeUv stage2 = new Stage("ST50",2);//car bug avec 21 en number

		//3 CG
		//TypeUv cg1 = new CG("DR02",6);
		private TypeUv cg1 = new CG("DR02",6);//car bug avec 6 en number
		private TypeUv cg2 = new CG("AR03",10);
		private	TypeUv cg3 = new CG ("GE01",4);
		//4 Langues
		private		TypeUv langue1 = new Langue("BULATS",8);
		private		TypeUv langue2 = new Langue("LG02",3);
		private		TypeUv langue3 = new Langue("LS02",19);
		private		TypeUv langue4 = new Langue("LC00",20);
		//6 CS 
		private		TypeUv cs1 = new CS("MT42",21);
		private		TypeUv cs2 = new CS("MT45",5);
		private		TypeUv cs3 = new CS("BD40",7);
		private		TypeUv cs4 = new CS("LO43",14);
		private		TypeUv cs5 = new CS("LO45",18);
		private		TypeUv cs6 = new CS("RE43",9);
		//6 TM
		private		TypeUv tm1 = new TM("LO54",11);
		private		TypeUv tm2 = new TM("TW52",12);
		private		TypeUv tm3 = new TM("TX52",13);
		private		TypeUv tm4 = new TM("TO52",15);
		private		TypeUv tm5 = new TM("VI50",16);
		private		TypeUv tm6 = new TM("IA54",17);
		 
*/
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Map window = new Map();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	
	

	/**
	 * Create the application.
	 */
	public Plan(TypeUv pTabUv[]) {
		
		for(int i=0; i<pTabUv.length; i++)
		{
			tabUv[i]=pTabUv[i];
		}
			
		//tableau();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
/*	private void tableau() {
		tabUv[0]=stage1;
		tabUv[1]=stage2;
		tabUv[2]=langue2;
		tabUv[3]=cg3;
		tabUv[4]=cs2;
		tabUv[5]=cg1;
		tabUv[6]=cs3;
		tabUv[7]=langue1;
		tabUv[8]=cs6;
		tabUv[9]=cg2;
		tabUv[10]=tm1;
		tabUv[11]=tm2;
		tabUv[12]=tm3;
		tabUv[13]=cs4;
		tabUv[14]=tm4;
		tabUv[15]=tm5;
		tabUv[16]=tm6;
		tabUv[17]=cs5;
		tabUv[18]=langue3;
		tabUv[19]=langue4;
		//tabUv[20]=cs1;
	}*/
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1034, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton uv1 = new JButton(new ImageIcon("Images//uvjaune.jpg"));
		//tabB[0] = uv1;
		uv1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageBox Prise1 = new MessageBox();
				tabM[0] = Prise1;
				Prise1.getF().setVisible(true); 
				
				tabM[0].setNomUV(tabUv[0].getNomUv());
			}
		});
		uv1.setBounds(222, 112, 41, 31);
		frame.getContentPane().add(uv1);
		
		
		JButton uv2 = new JButton(new ImageIcon("Images//uvjaune.jpg"));
		uv2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise2 = new MessageBox();
				tabM[1] = Prise2;
				Prise2.getF().setVisible(true); 
				Prise2.setNomUV("rien");
				tabM[1].setNomUV(tabUv[1].getNomUv());
			}
		});
		uv2.setBounds(263, 112, 53, 31);
		frame.getContentPane().add(uv2);
		//tabB[1] = uv2;
		
		JButton uv3 = new JButton(new ImageIcon("Images//uvorange.jpg"));
		uv3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				MessageBox Prise3 = new MessageBox();
				tabM[2] = Prise3;
				Prise3.getF().setVisible(true); 
				tabM[2].setNomUV(tabUv[2].getNomUv());
			}
		});
		uv3.setBounds(414, 91, 67, 32);
		frame.getContentPane().add(uv3);
		uv3.setBorderPainted(false);
		//tabB[2] = uv3;
		
		JButton uv4 = new JButton(new ImageIcon("Images//uvrouge.jpg"));
		uv4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[3] = Prise;
				Prise.getF().setVisible(true); 
				tabM[3].setNomUV(tabUv[3].getNomUv());
			}
		});
		uv4.setBounds(467, 128, 30, 50);
		frame.getContentPane().add(uv4);
		uv4.setBorderPainted(false);
		//tabB[3] = uv4;
		
		JButton uv5 = new JButton(new ImageIcon("Images//jaune2.jpg"));
		uv5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[4] = Prise;
				Prise.getF().setVisible(true); 
				tabM[4].setNomUV(tabUv[4].getNomUv());
			}
		});
		uv5.setBounds(382, 140, 30, 33);
		frame.getContentPane().add(uv5);
		uv5.setBorderPainted(false);
		//tabB[4] = uv5;
		
		JButton uv6 = new JButton(new ImageIcon("Images//mauve1.jpg"));
		uv6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[5] = Prise;
				Prise.getF().setVisible(true); 
				tabM[5].setNomUV(tabUv[5].getNomUv());
			}
		});
		uv6.setBounds(410, 156, 43, 43);
		frame.getContentPane().add(uv6);
		uv6.setBorderPainted(false);
		//tabB[5] = uv6;
		
		JButton uv7 = new JButton(new ImageIcon("Images//mauveclair.jpg"));
		uv7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[6] = Prise;
				Prise.getF().setVisible(true); 
				tabM[6].setNomUV(tabUv[6].getNomUv());
			}
		});
		uv7.setBounds(364, 170, 46, 44);
		frame.getContentPane().add(uv7);
		uv7.setBorderPainted(false);
		//tabB[6] = uv7;
		
		JButton uv8 = new JButton(new ImageIcon("Images//mauve2.jpg"));
		uv8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[7] = Prise;
				Prise.getF().setVisible(true); 
				tabM[7].setNomUV(tabUv[7].getNomUv());
			}
		});
		uv8.setBounds(406, 198, 43, 43);
		frame.getContentPane().add(uv8);
		uv8.setBorderPainted(false);
		//tabB[7] = uv8;
		
		JButton uv9 = new JButton(new ImageIcon("Images//rouge4.jpg"));
		uv9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[8] = Prise;
				Prise.getF().setVisible(true); 
				tabM[8].setNomUV(tabUv[8].getNomUv());
			}
		});
		uv9.setBounds(374, 213, 31, 39);
		frame.getContentPane().add(uv9);
		uv9.setBorderPainted(false);
		//tabB[8] = uv9;
		
		JButton uv10 =new JButton(new ImageIcon("Images//mauve3.jpg"));
		uv10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[9] = Prise;
				Prise.getF().setVisible(true); 
				tabM[9].setNomUV(tabUv[9].getNomUv());
			}
		});
		uv10.setBounds(402, 238, 44, 33);
		frame.getContentPane().add(uv10);
		uv10.setBorderPainted(false);
		//tabB[9] = uv10;
		
		JButton uv11 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MessageBox Prise = new MessageBox();
				tabM[10] = Prise;
				Prise.getF().setVisible(true); 
				tabM[10].setNomUV(tabUv[10].getNomUv());
			}
		});
		uv11.setBounds(92, 203, 38, 29);
		frame.getContentPane().add(uv11);
		//tabB[10] = uv11;
		
		JButton uv12 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				MessageBox Prise = new MessageBox();
				tabM[11] = Prise;
				Prise.getF().setVisible(true); 
				tabM[11].setNomUV(tabUv[11].getNomUv());
			}
		});
		uv12.setBounds(130, 203, 41, 29);
		frame.getContentPane().add(uv12);
		//tabB[11] = uv12;
		
		JButton uv13 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				MessageBox Prise = new MessageBox();
				tabM[12] = Prise;
				Prise.getF().setVisible(true); 
				tabM[12].setNomUV(tabUv[12].getNomUv());
			}
		});
		uv13.setBounds(171, 203, 45, 29);
		frame.getContentPane().add(uv13);
		//tabB[12] = uv13;
		
		JButton uv14 = new JButton(new ImageIcon("Images//uvbleu2.jpg"));
		uv14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				MessageBox Prise = new MessageBox();
				tabM[13] = Prise;
				Prise.getF().setVisible(true); 
				tabM[13].setNomUV(tabUv[13].getNomUv());
			}
		});
		uv14.setBorderPainted(false);
		uv14.setBounds(215, 203, 67, 29);
		frame.getContentPane().add(uv14);
		//tabB[13] = uv14;
		
		JButton uv15 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				MessageBox Prise = new MessageBox();
				tabM[14] = Prise;
				Prise.getF().setVisible(true); 
				tabM[14].setNomUV(tabUv[14].getNomUv());
			}
		});
		uv15.setBounds(92, 232, 38, 29);
		frame.getContentPane().add(uv15);
		//tabB[14] = uv15;
		
		JButton uv16 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				MessageBox Prise = new MessageBox();
				tabM[15] = Prise;
				Prise.getF().setVisible(true); 
				tabM[15].setNomUV(tabUv[15].getNomUv());
			}
		});
		uv16.setBounds(130, 232, 41, 29);
		frame.getContentPane().add(uv16);
		//tabB[15] = uv16;
		
		JButton uv17 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				MessageBox Prise = new MessageBox();
				tabM[16] = Prise;
				Prise.getF().setVisible(true); 
				tabM[16].setNomUV(tabUv[16].getNomUv());
			}
		});
		uv17.setBounds(171, 232, 45, 29);
		frame.getContentPane().add(uv17);
		//tabB[16] = uv17;
		
		JButton uv18 = new JButton(new ImageIcon("Images//uvbleu3.jpg"));
		uv18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				MessageBox Prise = new MessageBox();
				tabM[17] = Prise;
				Prise.getF().setVisible(true); 
				tabM[17].setNomUV(tabUv[17].getNomUv());
			}
		});
		uv18.setBorderPainted(false);
		uv18.setBounds(215, 233, 67, 29);
		frame.getContentPane().add(uv18);
		//tabB[17] = uv18;
		
		JButton uv20 = new JButton(new ImageIcon("Images//vert2.jpg"));
		uv20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[19] = Prise;
				Prise.getF().setVisible(true); 
				tabM[19].setNomUV(tabUv[19].getNomUv());
			}
		});
		uv20.setBounds(395, 311, 58, 24);
		uv20.setBorderPainted(false);
		frame.getContentPane().add(uv20);
		//tabB[19] = uv20;
		
		JButton uv19 = new JButton(new ImageIcon("Images//vert1.jpg"));
		uv19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[18] = Prise;
				Prise.getF().setVisible(true); 
				tabM[18].setNomUV(tabUv[18].getNomUv());
			}
		});
		uv19.setBounds(397, 282, 67, 30);
		frame.getContentPane().add(uv19);
		uv19.setBorderPainted(false);
		//tabB[18] = uv19;
		
		JButton uv21 = new JButton(new ImageIcon("Images//orange2.jpg"));
		uv21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				/*tabM[20] = Prise;*/
				Prise.getF().setVisible(true); 
				/*tabM[20].setNomUV(tabUv[20].getNomUv());*/
			}
		});
		uv21.setBounds(407, 376, 59, 37);
		uv21.setBorderPainted(false);
		frame.getContentPane().add(uv21);
		
		
		JLabel map = new JLabel( new ImageIcon("Images//map.gif"));
		map.setForeground(Color.BLUE);
		map.setBounds(10, 0, 540, 464);
		frame.getContentPane().add(map);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 493, 1000, 23);
		frame.getContentPane().add(separator);
		
		
		NomJoueur.setForeground(Color.BLUE);
		NomJoueur.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		NomJoueur.setBounds(593, 10, 128, 46);
		frame.getContentPane().add(NomJoueur);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(575, -31, 22, 523);
		frame.getContentPane().add(separator_1);
		
		
		photoJoueur.setIcon(new ImageIcon("Images//Geek.jpg"));
		photoJoueur.setBounds(726, 0, 294, 171);
		frame.getContentPane().add(photoJoueur);
		
		JLabel lblDut = new JLabel("DUT");
		lblDut.setForeground(Color.ORANGE);
		lblDut.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		lblDut.setBounds(711, 182, 104, 23);
		frame.getContentPane().add(lblDut);
		
		JLabel lblGeek = new JLabel("Geek");
		lblGeek.setForeground(Color.ORANGE);
		lblGeek.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		lblGeek.setBounds(825, 182, 100, 23);
		frame.getContentPane().add(lblGeek);
		
		JButton ChangerEtudiant = new JButton("Changer d'�tudiant");
		ChangerEtudiant.setBounds(696, 305, 218, 36);
		frame.getContentPane().add(ChangerEtudiant);
		
		JButton FinDePartie = new JButton("Fin de Partie");
		FinDePartie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
		});
		FinDePartie.setBounds(696, 440, 218, 36);
		frame.getContentPane().add(FinDePartie);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 530, 170, 14);
		frame.getContentPane().add(progressBar);
		
		JLabel Tours = new JLabel("Tours :");
		Tours.setBounds(10, 513, 70, 15);
		frame.getContentPane().add(Tours);
		
		JLabel HeuresDeTravail = new JLabel("Heures de travail restantes : ");
		HeuresDeTravail.setFont(new Font("Dialog", Font.BOLD, 17));
		HeuresDeTravail.setBounds(645, 240, 273, 29);
		frame.getContentPane().add(HeuresDeTravail);
		
		JLabel lblScoreJoueur = new JLabel("Score :                    Joueur 1 :  25                     Joueur : 31");
		lblScoreJoueur.setFont(new Font("Dialog", Font.BOLD, 20));
		lblScoreJoueur.setBounds(255, 503, 745, 60);
		frame.getContentPane().add(lblScoreJoueur);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(577, 280, 443, 14);
		frame.getContentPane().add(separator_2);
		
		JButton FinTour = new JButton("Fin de Tour");
	/*	FinTour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
					Moteur.TourPlus();
					if(Moteur.getTour() < 18)
					{	
						if(Moteur.setTour() == 1)
						{
							Map.setPhoto(1);
							System.out.println("image 1");
							setNomJoueur(InitFrame.getTextField(1));
						}
						else if(Moteur.setTour() == 2)
						{
							System.out.println("image 2");
							Map.setPhoto(2);
							setNomJoueur(InitFrame.getTextField(2));
						}
					}
					else
					{
						System.out.println("Fin de partie");
						Victoire Fin = new Victoire();
						Fin.getF().setVisible(true);
						
					}
			}
		});*/
		FinTour.setBounds(696, 394, 218, 36);
		frame.getContentPane().add(FinTour);
		
		JLabel label = new JLabel("8");
		label.setFont(new Font("Dialog", Font.BOLD, 17));
		label.setBounds(962, 240, 38, 29);
		frame.getContentPane().add(label);
		
		JLabel imagebosse = new JLabel( new ImageIcon("Images//heures.jpg"));
		imagebosse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		imagebosse.setBounds(590, 219, 50, 50);
		frame.getContentPane().add(imagebosse);
		
		info = new JTextField();
		info.setBounds(581, 68, 135, 103);
		frame.getContentPane().add(info);
		info.setColumns(10);
		
		JButton btnRorganiserSesHeures = new JButton("R�organiser ses heures");
		btnRorganiserSesHeures.setBounds(696, 352, 218, 36);
		frame.getContentPane().add(btnRorganiserSesHeures);
	}
	
	public JFrame getF(){
		
		return frame;
	}

	public static void setNomJoueur(String a){
		NomJoueur.setText(a);
	}
	
	public static String getNomJoueur(){
		return NomJoueur.getText();
	}
	
	public static void setPhoto(int J) {
		if(J == 1){
		photoJoueur.setIcon(new ImageIcon("Images//Geek.jpg"));
		}
		else if (J == 2){
		photoJoueur.setIcon(new ImageIcon("Images//voiture.jpg"));
		}
	
	}

	
	
	
	
}
