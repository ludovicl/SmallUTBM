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

import scheduler.Motor;
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

	// Cadre du Joueur
	private static JLabel NomJoueur = new JLabel("Joueur");
	private static JLabel photoJoueur =  new JLabel("Photo");
	private static JLabel HeuresRestantes = new JLabel("5");
	private static JLabel diplome = new JLabel("DUT");
	private static JLabel caracteristique = new JLabel("Geek");


	private MessageBox tabM[] = new MessageBox[20];

	// Attributs indiquant les informations de timing au main
	private boolean prise;
	private static boolean fini;
	private int indice;

	private JTextField info;
	private JLabel lblScoreJoueur = new JLabel("Score :                    Joueur 1 :  25                     Joueur : 31");

	// Compteur graphique de tours
	private static JProgressBar progressBar = new JProgressBar();

	/* Cr�ation des UVs */
	private static TypeUv tabUv[]= new TypeUv[20];









	/**
	 * Create the application.
	 */
	public Plan(TypeUv pTabUv[], MessageBox Prise) {

		for(int i=0; i<pTabUv.length; i++)
		{
			tabUv[i]=pTabUv[i];
		}

		//tableau();
		initialize(Prise);
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

	private void initialize( final MessageBox Prise) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1034, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);													// Empêcher la redimension de la fenêtre pour ne pas abîmer l'interface

		/* Creation d'un bouton "ub" par UV de la carte */
		JButton uv1 = new JButton(new ImageIcon("Images//uvjaune.jpg"));			// Afficher l'image qui camoufle le bouton sur l'image de fond
		uv1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabM[0] = Prise;													// Indiquer quelle MessageBox lancer
				Prise.getF().setVisible(true); 										// Afficher l'interface de Prise d'UV
				prise = true;														// Indiquer au main que le processus de prise est lancé
				tabM[0].setNomUV(tabUv[0].getNomUv());								// Indiquer à quel UV correspond ce bouto,n
				indice = 0;

			}
		});
		uv1.setBounds(222, 112, 41, 31);
		frame.getContentPane().add(uv1);



		JButton uv2 = new JButton(new ImageIcon("Images//uvjaune.jpg"));
		uv2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabM[1] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[1].setNomUV(tabUv[1].getNomUv());
				indice = 1;


			}
		});
		uv2.setBounds(263, 112, 53, 31);
		frame.getContentPane().add(uv2);





		JButton uv3 = new JButton(new ImageIcon("Images//uvorange.jpg"));
		uv3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tabM[2] = Prise;
				Prise.getF().setVisible(true); 
				prise= true;
				tabM[2].setNomUV(tabUv[2].getNomUv());
				indice = 2;
			}
		});
		uv3.setBounds(414, 91, 67, 32);
		frame.getContentPane().add(uv3);
		uv3.setBorderPainted(false);


		JButton uv4 = new JButton(new ImageIcon("Images//uvrouge.jpg"));
		uv4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabM[3] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[3].setNomUV(tabUv[3].getNomUv());
				indice = 3;
			}
		});
		uv4.setBounds(467, 128, 30, 50);
		frame.getContentPane().add(uv4);
		uv4.setBorderPainted(false);


		JButton uv5 = new JButton(new ImageIcon("Images//jaune2.jpg"));
		uv5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		 
				tabM[4] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[4].setNomUV(tabUv[4].getNomUv());
				indice = 4 ;
			}
		});
		uv5.setBounds(382, 140, 30, 33);
		frame.getContentPane().add(uv5);
		uv5.setBorderPainted(false);


		JButton uv6 = new JButton(new ImageIcon("Images//mauve1.jpg"));
		uv6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabM[5] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[5].setNomUV(tabUv[5].getNomUv());
				indice = 5;
			}
		});
		uv6.setBounds(410, 156, 43, 43);
		frame.getContentPane().add(uv6);
		uv6.setBorderPainted(false);


		JButton uv7 = new JButton(new ImageIcon("Images//mauveclair.jpg"));
		uv7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabM[6] = Prise;
				Prise.getF().setVisible(true); 
				prise =true;
				tabM[6].setNomUV(tabUv[6].getNomUv());
				indice = 6;
			}
		});
		uv7.setBounds(364, 170, 46, 44);
		frame.getContentPane().add(uv7);
		uv7.setBorderPainted(false);



		JButton uv8 = new JButton(new ImageIcon("Images//mauve2.jpg"));
		uv8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabM[7] = Prise;
				Prise.getF().setVisible(true); 
				prise =true;
				tabM[7].setNomUV(tabUv[7].getNomUv());
				indice = 7;
			}
		});
		uv8.setBounds(406, 198, 43, 43);
		frame.getContentPane().add(uv8);
		uv8.setBorderPainted(false);


		JButton uv9 = new JButton(new ImageIcon("Images//rouge4.jpg"));
		uv9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabM[8] = Prise;
				Prise.getF().setVisible(true);
				prise = true;
				tabM[8].setNomUV(tabUv[8].getNomUv());
				indice = 8;
			}
		});
		uv9.setBounds(374, 213, 31, 39);
		frame.getContentPane().add(uv9);
		uv9.setBorderPainted(false);


		JButton uv10 =new JButton(new ImageIcon("Images//mauve3.jpg"));
		uv10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabM[9] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[9].setNomUV(tabUv[9].getNomUv());
				indice = 9;
			}
		});
		uv10.setBounds(402, 238, 44, 33);
		frame.getContentPane().add(uv10);
		uv10.setBorderPainted(false);


		JButton uv11 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabM[10] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[10].setNomUV(tabUv[10].getNomUv());
				indice = 10;
			}
		});
		uv11.setBounds(92, 203, 38, 29);
		frame.getContentPane().add(uv11);


		JButton uv12 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tabM[11] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[11].setNomUV(tabUv[11].getNomUv());
				indice = 11;
			}
		});
		uv12.setBounds(130, 203, 41, 29);
		frame.getContentPane().add(uv12);


		JButton uv13 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tabM[12] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[12].setNomUV(tabUv[12].getNomUv());
				indice = 12;
			}
		});
		uv13.setBounds(171, 203, 45, 29);
		frame.getContentPane().add(uv13);


		JButton uv14 = new JButton(new ImageIcon("Images//uvbleu2.jpg"));
		uv14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tabM[13] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[13].setNomUV(tabUv[13].getNomUv());
				indice = 13;
			}
		});
		uv14.setBorderPainted(false);
		uv14.setBounds(215, 203, 67, 29);
		frame.getContentPane().add(uv14);


		JButton uv15 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tabM[14] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[14].setNomUV(tabUv[14].getNomUv());
				indice = 14;
			}
		});
		uv15.setBounds(92, 232, 38, 29);
		frame.getContentPane().add(uv15);


		JButton uv16 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tabM[15] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[15].setNomUV(tabUv[15].getNomUv());
				indice = 15;
			}
		});
		uv16.setBounds(130, 232, 41, 29);
		frame.getContentPane().add(uv16);


		JButton uv17 = new JButton(new ImageIcon("Images//uvbleu.jpg"));
		uv17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tabM[16] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[16].setNomUV(tabUv[16].getNomUv());
				indice = 16;
			}
		});
		uv17.setBounds(171, 232, 45, 29);
		frame.getContentPane().add(uv17);


		JButton uv18 = new JButton(new ImageIcon("Images//uvbleu3.jpg"));
		uv18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tabM[17] = Prise;
				Prise.getF().setVisible(true);
				prise = true; 
				tabM[17].setNomUV(tabUv[17].getNomUv());
				indice = 17;
			}
		});
		uv18.setBorderPainted(false);
		uv18.setBounds(215, 233, 67, 29);
		frame.getContentPane().add(uv18);




		JButton uv19 = new JButton(new ImageIcon("Images//vert1.jpg"));
		uv19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				tabM[18] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[18].setNomUV(tabUv[18].getNomUv());
				indice = 18;
			}
		});
		uv19.setBounds(397, 282, 67, 30);
		frame.getContentPane().add(uv19);
		uv19.setBorderPainted(false);
		/*
		JButton uv20 = new JButton(new ImageIcon("Images//vert2.jpg"));
		uv20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabM[19] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				tabM[19].setNomUV(tabUv[19].getNomUv());
				indice = 19;
			}
		});
		uv20.setBounds(395, 311, 58, 24);
		uv20.setBorderPainted(false);
		frame.getContentPane().add(uv20);

		/*JButton uv21 = new JButton(new ImageIcon("Images//orange2.jpg"));
		uv21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageBox Prise = new MessageBox();
				/*tabM[20] = Prise;
				Prise.getF().setVisible(true); 
				prise = true;
				/*tabM[20].setNomUV(tabUv[20].getNomUv());
				indice = 20;
			}
		});
		uv21.setBounds(407, 376, 59, 37);
		uv21.setBorderPainted(false);
		frame.getContentPane().add(uv21);*/


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


		diplome.setForeground(Color.ORANGE);
		diplome.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		diplome.setBounds(711, 182, 104, 23);
		frame.getContentPane().add(diplome);


		caracteristique.setForeground(Color.ORANGE);
		caracteristique.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		caracteristique.setBounds(825, 182, 100, 23);
		frame.getContentPane().add(caracteristique);

		JButton ChangerEtudiant = new JButton("Changer d'etudiant");
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

		// Contenu de l'interface Plan	
		
		progressBar.setBounds(10, 530, 170, 14);
		frame.getContentPane().add(progressBar);

		JLabel Tours = new JLabel("Tours :");
		Tours.setBounds(10, 513, 70, 15);
		frame.getContentPane().add(Tours);

		JLabel HeuresDeTravail = new JLabel("Heures de travail restantes : ");
		HeuresDeTravail.setFont(new Font("Dialog", Font.BOLD, 17));
		HeuresDeTravail.setBounds(645, 240, 273, 29);
		frame.getContentPane().add(HeuresDeTravail);


		lblScoreJoueur.setFont(new Font("Dialog", Font.BOLD, 20));
		lblScoreJoueur.setBounds(255, 503, 745, 60);
		frame.getContentPane().add(lblScoreJoueur);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(577, 280, 443, 14);
		frame.getContentPane().add(separator_2);

		/* Bouton Fin de tour */
		JButton FinTour = new JButton("Fin de Tour");
		FinTour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				fini = true;												// Informer le main que la prise est terminée
				Motor.incrementerNbTourJoueur();							// Lui signifier que c'est le tour du joueur suivant de prendre des UVs
				if(Motor.setTour() == 1)									
				{															// Réinitialisation du cadre selon le joueur
					Plan.setPhoto(1);
					System.out.println("Tour du Joueur 1");
					Plan.setNomJoueur(InitFrame.getTextField(1));
					Plan.setDiplome("DUT");
					Plan.setCaracteristique("Geek");
				}
				else if(Motor.setTour() == 2)
				{															// Réinitialisation du cadre selon le joueur
					System.out.println("Tour du Joueur 2");
					Plan.setPhoto(2);
					Plan.setNomJoueur(InitFrame.getTextField(2));
					Plan.setDiplome("License");
					Plan.setCaracteristique("Voiture");
				}
			}

		});
		FinTour.setBounds(696, 394, 218, 36);
		frame.getContentPane().add(FinTour);

		HeuresRestantes.setFont(new Font("Dialog", Font.BOLD, 17));		
		HeuresRestantes.setBounds(928, 240, 38, 29);
		frame.getContentPane().add(HeuresRestantes);

		JLabel imagebosse = new JLabel( new ImageIcon("Images//heures.jpg"));
		imagebosse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		imagebosse.setBounds(590, 219, 50, 50);
		frame.getContentPane().add(imagebosse);

		info = new JTextField();
		info.setBounds(581, 68, 135, 103);
		frame.getContentPane().add(info);
		info.setColumns(10);

		JButton btnRorganiserSesHeures = new JButton("Reorganiser");
		btnRorganiserSesHeures.setBounds(696, 352, 218, 36);
		frame.getContentPane().add(btnRorganiserSesHeures);

		JLabel lblNewLabel = new JLabel( new ImageIcon("Images//Fond2.jpg"));
		lblNewLabel.setBounds(0, 0, 1018, 563);
		frame.getContentPane().add(lblNewLabel);
	}

	// Accesseurs pour la visibilité de l'interface plan
	public JFrame getF(){

		return frame;
	}



	// Accesseurs aux attributs indiquant les informations de timing au main
	public boolean getPrise() {
		return prise;
	}

	public void setPrise(boolean a) {
		prise = a;
	}

	public boolean getFini() {
		return fini;
	}

	public static void setFini(boolean a) {
		fini = a;
	}

	public int getIndice() {
		return indice;
	}

	// Accesseurs du Cadre Joueur
	public static void setNomJoueur(String a){
		NomJoueur.setText(a);
	}

	public static String getNomJoueur(){
		return NomJoueur.getText();
	}

	public void setScore(String s) {
		lblScoreJoueur.setText(s);
	}

	public static void setPhoto(int J) {
		if(J == 1){
			photoJoueur.setIcon(new ImageIcon("Images//Geek.jpg"));
		}
		else if (J == 2){
			photoJoueur.setIcon(new ImageIcon("Images//voiture.jpg"));
		}

	}

	public static void setDiplome( String s) {
		diplome.setText(s);
	}

	public static void setCaracteristique ( String s) {
		caracteristique.setText(s);
	}

	public void setHeuresRestantes(int heures) {

		switch(heures)
		{
		case 0:
			HeuresRestantes.setText("0");
			break;
		case 1 : 
			HeuresRestantes.setText("1");
			break;
		case 2 : 
			HeuresRestantes.setText("2");
			break;
		case 3 : 
			HeuresRestantes.setText("3");
			break;
		case 4 : 
			HeuresRestantes.setText("4");
			break;
		case 5 : 
			HeuresRestantes.setText("5");
			break;	
		}

	}


	// thread de la JProgressBar du nombre de Tours
	public static void run(int pnb, int toursDeJeu){				
		pnb=(pnb*100)/toursDeJeu;
		System.out.println("pnb : "+pnb);
		progressBar.setValue(pnb);
	}       





}
