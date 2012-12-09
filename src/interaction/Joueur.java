package interaction;
import java.util.Arrays;
import java.util.Scanner;

import jeu.Student;

public class Joueur {


	private int nbCredit;
	private String nomJoueur;


	public Student studentEnDeclin;
	public Student studentActif;

	/*--Creation des Students----*/
	private Student unTC = Student.TC;
	private Student unMaster  = Student.Master;
	private Student unLicense = Student.License;
	/*-----------------------------*/

	/*-------tableau d'étudiants disponibles----*/
	static private Student[] tabStudent= new Student[3];
	/*----Static car il doit être le même pour tout les joueurs---*/

public Student[] reorganiserTableau(Object tab[],int index)
{	
	
	System.out.println("ca passe avant la boucle");
	Object tempo1, tempo2;
	System.out.println("Taille du tableau : "+tab.length);
	tempo1=tab[tab.length-1];
	tab[tab.length-1]=tab[index-1];
	//tempo2=tab[index];
	System.out.println("à la derniere place du tableau : "+tab[tab.length-1]);

	
	return (Student[]) tab;
	/*
	for(int i=index; i<tab.length-index; i++)
	{	
		System.out.println("ca passe dans la boucle");
		tab[tab.length-i]=tab[index+i];
		//tab[index+i+1]=tab[index+i];
	}*/
	
}

	public Joueur()
	{
		tabStudent[0]=unTC;
		tabStudent[1]=unMaster;
		tabStudent[2]=unLicense;
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

	public void choisirEtudiant(Student stu) 
	{
		studentActif=stu;  
	}

	public void selectionEtudiant()
	{
		System.out.println("Joueur 1 vous avez le choix entre : ");			


		/*----Affichage des etudiants--------------*/
		for (int i=0; i<tabStudent.length; i++)
			System.out.println(i+1 +" : "+tabStudent[i].getDescription());
		/*----------------------------------------*/

		/*---------Cin de l'utilisateur ------*/
		Scanner in = new Scanner(System.in);
		int choix = in.nextInt();
		/*---------Fin Cin de l'utilisateur ------*/

		switch (choix)
		{ 
		case 1: this.choisirEtudiant(unTC);
		System.out.println("Felicitation, vous êtes un "+tabStudent[0].getDescription());
		break;

		case 2:this.choisirEtudiant(unMaster);
		System.out.println("Felicitation, vous êtes un "+tabStudent[1].getDescription());
		break;

		case 3:this.choisirEtudiant(unLicense);
		System.out.println("Felicitation, vous êtes un "+tabStudent[2].getDescription());
		break;

		default: 
			System.out.println("Le choix plante ...");

		}
		
		tabStudent=this.reorganiserTableau(tabStudent, choix);


	}

}
