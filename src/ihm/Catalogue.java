package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

import interaction.Joueur;
import jeu.*;


public class Catalogue extends JInternalFrame implements ActionListener, ItemListener {

	public JFrame frame;
	private Etudiant etu;
	private Joueur j;


	JButton LBT[]= new JButton[2];
	JCheckBox LCB[] = new JCheckBox[6];

	private Etudiant etuAReturn;
	private Caracteristique caraAReturn;

	private Tc unTC = new Tc();
	private Master unMaster  = new Master();
	private License unLicense = new License();
	private Etranger unEtranger = new Etranger();
	private Prepa unPrepa = new Prepa();
	private Dut unDUT = new Dut();

	private Geek unGeek=new Geek();
	private  Pistone unPistone=new Pistone();
	private 	PossedantVoiture possVoiture = new PossedantVoiture(); 
	private 	AlcooliqueBdf alcoBDF= new AlcooliqueBdf();
	private 	SemestreSup semSup = new SemestreSup(); 
	private 	Ae assoEtudi=new Ae();
	private 	Philateliste unPhilateliste= new Philateliste(); 
	private 	Bds bureauSport = new Bds();
	

	private Etudiant tabStudent[] = {unTC, unMaster, unLicense, unEtranger, unPrepa, unDUT};
	private Caracteristique tabCarac[] = {unPistone, unGeek, bureauSport, semSup,assoEtudi,alcoBDF,unPhilateliste,possVoiture};
	private JLabel fond = new JLabel();
	Etudiant SavTabStudent[] = tabStudent;
	Caracteristique SavtabCarac[] = tabCarac;
	String SaveValS[] = new String[6];
	String SaveValC[] = new String[8];
	String SaveValP[] = {"1","2","3","4","5","6"};
	String joueur, caract;

	
	/**
	 * Launch the application.
	 */



	/**
	 * Create the application.
	 */
	public Catalogue(Etudiant etu) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		
		//les numeros
		JPanel Numeros = new JPanel();
		Numeros.setBounds(0, 11, 41, 260);
		frame.getContentPane().add(Numeros);
		Numeros.setLayout(null);

		int x=10,y=10,larg=57,haut=26;
		int j=0;
		JLabel Lnum[] = new JLabel[6];

		for(j=1;j<=6;j++){
			Lnum[j-1]=new JLabel(""+j);
			Lnum[j-1].setBounds(x, y+(40*(j-1)), 12, 20);
			Numeros.add(Lnum[j-1]);
		}
		//les �tudiants
		JPanel Etudiants = new JPanel();
		Etudiants.setBounds(41, 11, 121, 260);
		frame.getContentPane().add(Etudiants);
		Etudiants.setLayout(null);

		int valeur=0;
		JLabel L[]=new JLabel[6];

		j=0;
		int i=6;
		while(i>0) {

			valeur=generateVal(i);
			L[j]=new JLabel(tabStudent[valeur-1].getDescription());
			L[j].setBounds(x, y+(40*j), larg, haut);
			SaveValS[j]= L[j].getText();
			Etudiants.add(L[j]);
			tabStudent = suppStu (valeur-1,tabStudent);
			j++;
			i--;

		}
		
		

		//les caracteristiques
		JPanel Qualifications = new JPanel();
		Qualifications.setBounds(161, 11, 200, 260);
		frame.getContentPane().add(Qualifications);
		Qualifications.setLayout(null);

		JLabel LCarac[]=new JLabel[7];

		j=0;
		i=7;
		x=10; y=11; larg=250; haut=26;
		int valeurC =0 ;
		while(i>0) {
			valeurC=generateVal(i);
			LCarac[j]=new JLabel(tabCarac[valeurC-1].getDescription());
			LCarac[j].setBounds(x, y+(40*j), larg, haut);
			Qualifications.add(LCarac[j]);
			
			SaveValC[j]=LCarac[j].getText();
			
			tabCarac = suppStu (valeurC-1,tabCarac);
			j++;
			i--;

		}
		//prix

		JPanel Prix = new JPanel();
		Prix.setBounds(400, 11, 35, 260);
		frame.getContentPane().add(Prix);
		Prix.setLayout(null);

		x=10; y=10; larg=57; haut=26;
		j=6;
		JLabel Lprix[] = new JLabel[6];
		for(j=1;j<=6;j++){
			Lprix[j-1]=new JLabel(""+j);
			Lprix[j-1].setBounds(x, y+(40*(j-1)), 12, 20);
			Prix.add(Lprix[j-1]);
		}

		/* Pour cr�er les CheckBox */

		JPanel Choix = new JPanel();
		Choix.setLayout(null);
		Choix.setBounds(434, 11, 41, 260);
		frame.getContentPane().add(Choix);


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


		LCB[0].addItemListener(this);
		LCB[1].addItemListener(this);
		LCB[2].addItemListener(this);
		LCB[3].addItemListener(this);
		LCB[4].addItemListener(this);
		LCB[5].addItemListener(this);


		//Les Buttons

		JPanel Buttons = new JPanel();
		Buttons.setBounds(316, 306, 245, 40);
		frame.getContentPane().add(Buttons);
		Buttons.setLayout(null);


		for(j=1;j<=2;j++){
			LBT[j-1]=new JButton(""+j);
			LBT[j-1].setBounds(x+(100*(j-1)), y, 89, 23);
			Buttons.add(LBT[j-1]);
		}
		LBT[0].setText("Valider");
		LBT[1].setText("Annuler");
		LBT[0].addActionListener(this);
		LBT[1].addActionListener(this);
		
	
	
	}
	@Override
	public void itemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		JCheckBox Jbox = new JCheckBox();
		Jbox = (JCheckBox ) evt.getSource();
		if ( Jbox.isSelected() == true && Jbox == LCB[0]) {

			LCB[1].setEnabled(true);
			//System.out.println(SaveValS[0] + " " + SaveValC[0]);
			joueur = SaveValS[0];
			caract=SaveValC[0];
			//System.out.println(joueur);
		}
		else if(Jbox==LCB[0]) {
			for(int i=1;i<6;++i) {
				LCB[i].setEnabled(false);
				LCB[i].setSelected(false);
			}
		}
		else if ( Jbox.isSelected() == true && Jbox == LCB[1]) {

			LCB[2].setEnabled(true);
			//System.out.println(SaveValS[1] + " " + SaveValC[1]);
			joueur = SaveValS[1];
			caract=SaveValC[1];
		}
		else if(Jbox==LCB[1]){
			joueur = SaveValS[0];
			caract=SaveValC[0];
			for(int i=2;i<6;++i){
				LCB[i].setEnabled(false);
				LCB[i].setSelected(false);
			}
		}
		else if ( Jbox.isSelected() == true && Jbox == LCB[2]) {

			LCB[3].setEnabled(true);
			//System.out.println(SaveValS[2] + " " + SaveValC[2]);
			joueur = SaveValS[2];
			caract=SaveValC[2];
		}
		else if(Jbox==LCB[2]){
			joueur = SaveValS[1];
			caract=SaveValC[1];
			for(int i=3;i<6;++i){
				LCB[i].setEnabled(false);
				LCB[i].setSelected(false);
			}
		}
		else if ( Jbox.isSelected() == true && Jbox == LCB[3]) {

			LCB[4].setEnabled(true);
			//System.out.println(SaveValS[3] + " " + SaveValC[3]);
			joueur = SaveValS[3];
			caract=SaveValC[3];

		}
		else if(Jbox==LCB[3]){
			joueur = SaveValS[2];
			caract=SaveValC[2];
			for(int i=4;i<6;++i){
				LCB[i].setEnabled(false);
				LCB[i].setSelected(false);
			}
		}
		else if ( Jbox.isSelected() == true && Jbox == LCB[4]) {

			LCB[5].setEnabled(true);
			//System.out.println(SaveValS[4] + " " + SaveValC[4]);
			joueur = SaveValS[4];
			caract=SaveValC[4];

		}
		else if(Jbox==LCB[4]){
			joueur = SaveValS[3];
			caract=SaveValC[3];
			LCB[5].setEnabled(false);
			LCB[5].setSelected(false);

		}
		else if ( Jbox.isSelected() == true && Jbox == LCB[5]) {

			//System.out.println(SaveValS[5] + " " + SaveValC[5]);
			joueur = SaveValS[5];
			caract=SaveValC[5];

		}
		else if(Jbox==LCB[5]){

			joueur = SaveValS[4];
			caract=SaveValC[4];

		}
	}
	/*Actions performed by the Buttons*/
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton BT = new JButton();
		BT = (JButton ) e.getSource();
		if(BT==LBT[0]){
			System.out.println(joueur);
			if (caract==unPistone.getDescription())
			{
				System.out.println(unPistone.getDescription());
				caraAReturn=unPistone;
			}
			else if (caract==unGeek.getDescription())
			{
				System.out.println(unGeek.getDescription());
				caraAReturn=unGeek;
			}
			else if (caract==unPhilateliste.getDescription())
			{
				System.out.println(unPhilateliste.getDescription());
				caraAReturn=unPhilateliste;
			}
			else if (caract==bureauSport.getDescription())
			{
				System.out.println(bureauSport.getDescription());
				caraAReturn=bureauSport;
			}
			else if (caract==semSup.getDescription())
			{
				System.out.println(semSup.getDescription());
				caraAReturn=semSup;
			}
			else if (caract==possVoiture.getDescription())
			{
				System.out.println(possVoiture.getDescription());
				caraAReturn=possVoiture;
			}

			else if (caract==alcoBDF.getDescription())
			{
				System.out.println(alcoBDF.getDescription());
				caraAReturn=alcoBDF;
			}
			else if (caract==assoEtudi.getDescription())
			{
				System.out.println(assoEtudi.getDescription());
				caraAReturn=assoEtudi;
			}

			
			if (joueur == "DUT"){
				System.out.println("Dut");
				etuAReturn=unDUT;

			}
			else if (joueur == "TC"){
				System.out.println("Tc");
				etuAReturn=unTC;
			}
			else if (joueur == "Etranger"){
				System.out.println("Etranger");
				etuAReturn=unEtranger;
			}
			else if (joueur == "License"){
				System.out.println("License");
				etuAReturn=unLicense;
			}
			else if (joueur == "Master"){
				System.out.println("Master");
				etuAReturn=unMaster;
			}
			else if (joueur == "Prepa"){
				System.out.println("Prepa");
				etuAReturn=unPrepa;
			}
			frame.setVisible(false);
			frame.dispose();
		}

		if ( BT == LBT[1]){
			System.out.println("Annuler");
			frame.dispose();
		}
	}

	/* Pour g�nerer les valeur */

	public JFrame getF(){
		
		return frame;
	}
	
	public int generateVal(int cpt)

	{

		Random random = new Random();
		int valeur = 1 + random.nextInt(cpt);
		return valeur;
	} 

	/* fonction pour supprimer les valeur en double */

	public Etudiant[] suppStu (int valeur,Etudiant tabStudent[]){
		int i,j=0;
		Etudiant tab[]=new Etudiant[6];

		for(i=0;i < tabStudent.length;++i){
			if (tabStudent[i]!=tabStudent[valeur]){
				tab[j++]=tabStudent[i];
			}

		}
		return tab;
	}

	public Caracteristique[] suppStu (int valeur,Caracteristique tabCaract[]){
		int i,j=0;
		Caracteristique tab[]=new Caracteristique[8];

		for(i=0;i < tabCaract.length;++i){
			if (tabCaract[i]!=tabCaract[valeur]){
				tab[j++]=tabCaract[i];
			}

		}
		return tab;
	}

	public Etudiant getEtudiant()
	{
		etuAReturn.setCaracteristique(caraAReturn);
		return etuAReturn;
	}
	
	
}
