package scheduler;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import jeu.Tc;
import jeu.Student;
import environnement.TypeUv;
import interaction.Joueur;

public class Moteur {


	/*---Creation des Joueurs--*/
	private Joueur j1, j2;
	/*--------------------------*/

	/*--------Creation des Uv --- */
	private TypeUv tm1= TypeUv.TM;
	private TypeUv cs1 = TypeUv.CS;
	private TypeUv stage1 = TypeUv.Stage;
	/*------------------------------*/


	
	public Moteur ()
	{

		j1 = new Joueur();
		j2 = new Joueur();	

		System.out.println("Saisire le nom du joueur1 :");	

		/*---------Cin de l'utilisateur ------*/
		char buf[]=new char[10];
		Reader in = new InputStreamReader(System.in);
		try {
			in.read(buf,0,10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nomj1 = new String(buf);
		/*---------Fin Cin de l'utilisateur ------*/

		j1.setNomJoueur(nomj1);

		System.out.println("Le nom du joueur 1 est : "+j1.getNomJoueur());		
		System.out.println("Saisire le nom du joueur2 :");



		/*---------Cin de l'utilisateur ------*/
		try {
			in.read(buf,0,10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nomj2 = new String(buf);
		/*---------Fin Cin de l'utilisateur ------*/

		j2.setNomJoueur(nomj2);
		System.out.println("Le nom du joueur 2 est : "+j2.getNomJoueur());

	}

	public void genererCarte() {

		/*---Definition des coordonnées des UV---*/	
		tm1.setCoordonnees(1,3);
		cs1.setCoordonnees(2,2);
		stage1.setCoordonnees(20,20);
		/*---------------------------------*/

		System.out.println("coordonnees de tm1 : "+tm1.getCoordonneesX()+" , "+tm1.getCoordonneesY());
		System.out.println("coordonnees de cs1 : "+cs1.getCoordonneesX()+" , "+cs1.getCoordonneesY());
		System.out.println("coordonnes de stage1 : "+stage1.getCoordonneesX()+" , "+stage1.getCoordonneesY());

	}

	public void choixEtudiants()
	{
		j1.selectionEtudiant();
		
		j2.selectionEtudiant();

	}

	/*
	private Tc  tc;
	private int tempo;

	private int nbJoueurs;



	  public void decrementerEtudiant(String etu)
	  {
		  if (etu=="tc")
		  	tc.decrementerHeures();

	  }

	  public void incrementerEtudiant(String etu)
	  {
		  tc.incrementerHeures();
	  }



	  public int getNombreHeures(String etu)
	  {
		  if(etu=="tc")
		  {

			  return tc.getnombreDeHeures();
		  }
		  else 
			 return 0; //inutile mais il veut un else...
	  }


	  public Moteur () {
		  tc = new Tc();
	  }

	  public void genererCarte() {
	  }

	  public void compterCredits() {
	  }

	  public void verifierUV() {

	  }

	  public void debuterPartie() {

	  }

	 */



}
