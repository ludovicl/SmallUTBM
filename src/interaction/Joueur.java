package interaction;
import java.util.Arrays;
import java.util.Scanner;

import jeu.*;

public class Joueur {


	private int nbCredit=5;
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

	/*-------tableau d'étudiants disponibles static car le même pour tout les etudiant----*/
	private static Etudiant[] tabEtudiant= new Etudiant[6];

	public int getNbCredit()
	{
		return nbCredit;
	}

	public void setNbCredit(int cred)
	{
		nbCredit=cred;
	}

	public Joueur() //creation tableau Etudiant dans le constructeur
	{
		tabEtudiant[0]=unTC;	
		tabEtudiant[1]=unMaster;
		tabEtudiant[2]=unEtranger;
		tabEtudiant[3]=unPrepa;
		tabEtudiant[4]=unDUT;
		tabEtudiant[5]=unLicense;
	}

	public void decrementerNbCredit(int nb)
	{
		nbCredit=nbCredit-nb;
	}

	public void incrementerNbCredit(int nb)
	{
		nbCredit=nbCredit+nb;
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


	public  void  selectionEtudiant(int choix, Etudiant etu)
	{
		etudiantActif=etu;
		tabEtudiant=Etudiant.reorganiserTableau(tabEtudiant, choix);	
	}

	public Etudiant getEtudiantActif ()
	{
		return etudiantActif;
	}

	public Etudiant getEtudiantEnDeclin ()
	{
		return etudiantEnDeclin;
	}

	public Etudiant[] getTabEtudiant()
	{
		return tabEtudiant;
	}

	public Etudiant getTabEtudiantIndex(int i)
	{
		return tabEtudiant[i];

	}

}
