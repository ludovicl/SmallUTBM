package Interface;


import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;


public class Catalogue extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
 	 *
 	 *
 	 */
	JButton LBT[]= new JButton[2];
	JCheckBox LCB[] = new JCheckBox[6];
	String tabStudent[] = {"TC", "Master", "Licence", "Etranger", "Prepa", "DUT"};
	String tabCarac[] = {"Pistone", "Geek", "Possedant une voiture", "Alcoolique du BDF", "Possédant des semestres sup'","Faisant partie de l'AE", "Philateliste"};
	
	String SavTabStudent[] = tabStudent;
	String SavtabCarac[] = tabCarac;
	int SaveValS[] = new int[6];
	int SaveValC[] = new int[7];

	
	/**
	 * Create the frame.
	 */
	public Catalogue() {
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(null);
		
	//les numeros
		JPanel Numeros = new JPanel();
		Numeros.setBounds(0, 11, 41, 260);
		getContentPane().add(Numeros);
		Numeros.setLayout(null);
		
		int x=10,y=10,larg=57,haut=26;
		int j=0;
		JLabel Lnum[] = new JLabel[6];
		
		for(j=1;j<=6;j++){
			Lnum[j-1]=new JLabel(""+j);
			Lnum[j-1].setBounds(x, y+(40*(j-1)), 12, 20);
			Numeros.add(Lnum[j-1]);
		}
		
		
	//les étudiants
		JPanel Etudiants = new JPanel();
		Etudiants.setBounds(41, 11, 121, 260);
		getContentPane().add(Etudiants);
		Etudiants.setLayout(null);
		
		
		int valeur=0;
		JLabel L[]=new JLabel[6];
				
		j=0;
		int i=6;
		while(i>0) {
			
			valeur=generateVal(i);
			valeur=generateVal(i);
			SaveValS[j]= valeur;
			L[j]=new JLabel(tabStudent[valeur-1]);
			L[j].setBounds(x, y+(40*j), larg, haut);
			Etudiants.add(L[j]);
			tabStudent = suppStu (valeur-1,tabStudent);
			j++;
			i--;
	
		}
		
	//les carracteristiques
		JPanel Qualifications = new JPanel();
		Qualifications.setBounds(161, 11, 200, 260);
		getContentPane().add(Qualifications);
		Qualifications.setLayout(null);
				
		JLabel LCarac[]=new JLabel[7];
		
		j=0;
		i=7;
		x=10; y=11; larg=250; haut=26;
		int valeurC =0 ;
		while(i>0) {
			valeurC=generateVal(i);
			SaveValC[j]= valeurC;
			LCarac[j]=new JLabel(tabCarac[valeurC-1]);
			LCarac[j].setBounds(x, y+(40*j), larg, haut);
			Qualifications.add(LCarac[j]);
			tabCarac = suppStu (valeurC-1,tabCarac);
			j++;
			i--;
	
		}
	//prix
		
		JPanel Prix = new JPanel();
		Prix.setBounds(400, 11, 35, 260);
		getContentPane().add(Prix);
		Prix.setLayout(null);
		
		x=10; y=10; larg=57; haut=26;
		j=6;
		JLabel Lprix[] = new JLabel[6];
		
		for(j=1;j<=6;j++){
			Lprix[j-1]=new JLabel(""+j);
			Lprix[j-1].setBounds(x, y+(40*(j-1)), 12, 20);
			Prix.add(Lprix[j-1]);
		}
		
		/* Pour créer les CheckBox */
		
		JPanel Choix = new JPanel();
		Choix.setLayout(null);
		Choix.setBounds(434, 11, 41, 260);
		getContentPane().add(Choix);
		
		
		x=10; y=10; larg=57; haut=26;
		j=6;
		
		
		for(j=1;j<=6;j++){
			LCB[j-1]=new JCheckBox(""+j);
			LCB[j-1].setBounds(x, y+(40*(j-1)), 21, 23);
			Choix.add(LCB[j-1]);
		}
	
		LCB[1].setEnabled(false);
		LCB[2].setEnabled(false);
		LCB[3].setEnabled(false);
		LCB[4].setEnabled(false);
		LCB[5].setEnabled(false);
		
		
		LCB[0].addActionListener(this);
		LCB[1].addActionListener(this);
		LCB[2].addActionListener(this);
		LCB[3].addActionListener(this);
		LCB[4].addActionListener(this);
	
		
	//Les Buttons
		
		JPanel Buttons = new JPanel();
		Buttons.setBounds(316, 306, 245, 40);
		getContentPane().add(Buttons);
		Buttons.setLayout(null);
		
		for(j=1;j<=2;j++){
			LBT[j-1]=new JButton(""+j);
			LBT[j-1].setBounds(x+(100*(j-1)), y, 89, 23);
			Buttons.add(LBT[j-1]);
		}
		LBT[0].setText("Valider");
		LBT[1].setText("Annuler");
	}
	/* */
	public void actionPerformed(ActionEvent e)
	{
		JCheckBox Jbox = new JCheckBox();
		Jbox = (JCheckBox ) e.getSource();
		if ( Jbox.isSelected() == true && Jbox == LCB[0]) {
			LCB[1].setEnabled(true);
		}
		else if(Jbox==LCB[0]) {
			for(int i=1;i<6;++i) {
				LCB[i].setEnabled(false);
				LCB[i].setSelected(false);
			}
		}
			else if ( Jbox.isSelected() == true && Jbox == LCB[1]) {
				
					LCB[2].setEnabled(true);
				
			}
			else if(Jbox==LCB[1]){
				for(int i=2;i<6;++i){
					LCB[i].setEnabled(false);
					LCB[i].setSelected(false);
				}
			}
				else if ( Jbox.isSelected() == true && Jbox == LCB[2]) {
					
					LCB[3].setEnabled(true);
					System.out.println("LCB 2" + SavTabStudent[SaveValS[2]-1] + SavtabCarac[SaveValC[2]-1] ); // pas encore au point !
				}
					else if(Jbox==LCB[2]){
						for(int i=3;i<6;++i){
							LCB[i].setEnabled(false);
							LCB[i].setSelected(false);
						}
				}
					else if ( Jbox.isSelected() == true && Jbox == LCB[3]) {
						
						LCB[4].setEnabled(true);
						
					}
						else if(Jbox==LCB[3]){
							for(int i=4;i<6;++i){
								LCB[i].setEnabled(false);
								LCB[i].setSelected(false);
							}
						}
							else if ( Jbox.isSelected() == true && Jbox == LCB[4]) {
								
								LCB[5].setEnabled(true);
							
						}
								else if(Jbox==LCB[4]){
									
										LCB[5].setEnabled(false);
										LCB[5].setSelected(false);
								
								}
		/*Ajouter les actions performed par les Boutons*/
		
		
	}
	
/* Pour génerer les valeur */
	
	public int generateVal(int cpt)
	 
	{
		
		Random random = new Random();
		int valeur = 1 + random.nextInt(cpt);
		return valeur;
	} 
	
	/* fonction pour supprimer les valeur en double */
	
	public String[] suppStu (int valeur,String tabStudent[]){
		int i,j=0;
		String tab[]={"","","","","","",""};
		
		for(i=0;i < tabStudent.length;++i){
			if (tabStudent[i]!=tabStudent[valeur]){
				tab[j++]=tabStudent[i];
			}
			
		}
		return tab;
	}
}
