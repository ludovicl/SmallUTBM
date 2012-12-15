package interaction;
import java.util.Arrays;
import java.util.Scanner;

import jeu.Dut;
import jeu.Etranger;
import jeu.Etudiant;
import jeu.License;
import jeu.Master;
import jeu.Prepa;
import jeu.Tc;

public class Joueur {


	private int nbCredit;
	private String nomJoueur;


	public Etudiant etudiantEnDeclin;
	public Etudiant etudiantActif;

	/*--Creation des Students----*/
	private Tc unTC = new Tc();
	private Master unMaster  = new Master();
	private License unLicense = new License();
	private Etranger unEtranger = new Etranger();
	private Prepa unPrepa = new Prepa();
	private Dut unDUT = new Dut();

	/*-----------------------------*/

	/*-------tableau d'étudiants disponibles----*/
	static private Etudiant[] tabEtudiant= new Etudiant[6];
	/*----Static car il doit être le même pour tout les joueurs---*/
	
	
	public Joueur()
	{
		tabEtudiant[0]=unTC;	
		tabEtudiant[1]=unMaster;
		tabEtudiant[2]=unEtranger;
		tabEtudiant[3]=unPrepa;
		tabEtudiant[4]=unDUT;
		tabEtudiant[5]=unLicense;
	}

	public void setNomJoueur (String nom)
	{
		this.nomJoueur=nom;

	}

	public String getNomJoueur()
	{
		return nomJoueur;
	}

	public void passerEtudiantEnDeclin() 
	{

	}

	public void deplacerHeures() 
	{

	}

	public void lancerDe() 
	{

	}

	public void finirTour() 
	{

	}

	public void choisirEtudiant(Etudiant stu) 
	{
		etudiantActif=stu;  
	}

	public void selectionEtudiant()
	{
		System.out.println(nomJoueur+" vous avez le choix entre : ");			


		/*----Affichage des etudiants--------------*/
		for (int i=0; i<tabEtudiant.length; i++)
			System.out.println(i+1 +" : "+tabEtudiant[i].getDescription()+tabEtudiant[i].getQualifCaract());
		/*----------------------------------------*/

		/*---------Cin de l'utilisateur ------*/
		Scanner in = new Scanner(System.in);
		int choix = in.nextInt();
		/*---------Fin Cin de l'utilisateur ------*/


		
		tabEtudiant=Etudiant.reorganiserTableau(tabEtudiant, choix);

		//for(int i=0; i<tabEtudiant.length;i++)
			//System.out.println(tabEtudiant[i]);

	}

}
