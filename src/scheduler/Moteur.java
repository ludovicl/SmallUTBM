package scheduler;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import jeu.Tc;
import environnement.TypeUv;
import interaction.Joueur;



public class Moteur {


	/*---Creation des Joueurs--*/
	static private Joueur j1, j2;
	/*--------------------------*/

	/*--------Creation des Uv --- */
	private TypeUv tm1= new TypeUv("tm1");
	private TypeUv cs1= new TypeUv("cs1");
	private TypeUv stage1= new TypeUv("stage1");
	/*------------------------------*/
	private Joueur j ;




	public Moteur ()
	{
		j=new Joueur();

		j1 = new Joueur();
		j2 = new Joueur();	

		System.out.println("Saisir le nom du joueur1 :");	

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
		System.out.println("TAILLL "+j1.getTabEtudiant().length);

		/*----Affichage des etudiants--------------*/
		for (int i=0; i<j1.getTabEtudiant().length; i++)
			System.out.println(i+1 +" : "+j1.getTabEtudiantIndex(i).getDescription()+j1.getTabEtudiantIndex(i).getQualifCaract());
		/*----------------------------------------*/

		/*---------Cin de l'utilisateur ------*/
		Scanner in = new Scanner(System.in);
		int choix = in.nextInt();
		/*---------Fin Cin de l'utilisateur ------*/


		System.out.println(j1.getNbCredit());

		/*---Si le nombre de credit du joueur est superieur au credit de l'étudiant---*/
		if(j1.getNbCredit()>choix)
		{
			j1.selectionEtudiant(choix,j1.getTabEtudiantIndex(choix));
			j1.decrementerNbCredit(choix);
			System.out.println("Vous êtes maintenant un "+j1.getEtudiantActif().getDescription()+j1.getEtudiantActif().getQualifCaract());
			System.out.println(j1.getNomJoueur()+" vous avez "+j1.getNbCredit()+" credits");
		}
		else
		{
			System.out.println("Vous n'avez pas assez de credit pour cet etudiant");
		}

		/*----Affichage des etudiants selectionable--------------*/
		for (int i=0; i<j2.getTabEtudiant().length; i++)
			System.out.println(i+1 +" : "+j2.getTabEtudiantIndex(i).getDescription()+j2.getTabEtudiantIndex(i).getQualifCaract());


		/*---------Cin de l'utilisateur ------*/
		Scanner in1 = new Scanner(System.in);
		int choix1 = in1.nextInt();
		/*---------Fin Cin de l'utilisateur ------*/
		System.out.println(j2.getNbCredit());

		if(j2.getNbCredit()>choix1)
		{
			j2.selectionEtudiant(choix,j2.getTabEtudiantIndex(choix1));
			j2.decrementerNbCredit(choix);
			System.out.println("Vous êtes maintenant un "+j2.getEtudiantActif().getDescription()+j2.getEtudiantActif().getQualifCaract());
			System.out.println(j2.getNomJoueur()+" vous avez"+j2.getNbCredit()+" credit");
		}
		else
		{
			System.out.println("Vous n'avez pas assez de credit pour cet etudiant");
		}


	}


	public void choixUv(String para)
	{			
		if (para == "j1")
		{
			j=j1;
		}
		else if (para =="j2")
		{
			j=j2;

		}

		while (j.etudiantActif.getnombreDeHeures()>0)// tant que le joueur à des credits
		{
			System.out.println("-----"+j.getNomJoueur()+" vous pouvez maintenant deplacer vos heurs de travail-----");
			System.out.println(j.getNomJoueur()+" vous avez "+j.getEtudiantActif().getnombreDeHeures()+" heures de travail");
			System.out.println("Voici les uv : ");	
			System.out.println("1. : "+tm1.getNomUv()+" X : "+tm1.getCoordonneesX()+" Y : "+tm1.getCoordonneesY());
			System.out.println("Heures pour joueurs 1 : "+tm1.gettHeuresJ1()+" Heures pour joueur 2 : "+tm1.gettHeuresJ2());
			System.out.println();
			System.out.println("2. : "+cs1.getNomUv()+" X : "+cs1.getCoordonneesX()+" Y : "+cs1.getCoordonneesY());
			System.out.println("Heures pour joueurs 1 : "+cs1.gettHeuresJ1()+" Heures pour joueur 2 : "+cs1.gettHeuresJ2());
			System.out.println();
			System.out.println("3. : "+stage1.getNomUv()+" X : "+stage1.getCoordonneesX()+" Y : "+stage1.getCoordonneesY());
			System.out.println("Heures pour joueurs 1 : "+stage1.gettHeuresJ1()+" Heures pour joueur 2 : "+stage1.gettHeuresJ2());
			System.out.println();


			System.out.println("Selectionnez le nombre d'heure à deplacer :");


			/*---------Cin de l'utilisateur ------*/
			Scanner in1 = new Scanner(System.in);
			int choixHeures = in1.nextInt();
			/*---------Fin Cin de l'utilisateur ------*/

			System.out.println("Selectionnez votre uv : ");

			/*---------Cin de l'utilisateur ------*/
			Scanner in2 = new Scanner(System.in);
			int choixUv = in2.nextInt();
			/*---------Fin Cin de l'utilisateur ------*/


			if (choixHeures<=j.getEtudiantActif().getnombreDeHeures())
			{
				System.out.println("On est dans le switch");
				switch (choixUv) {
				case 1:
					if(para=="j1")
						tm1.addHeuresJ1(choixHeures);
					else if (para =="j2")
						tm1.addHeuresJ2(choixHeures);
					j.getEtudiantActif().decrementerHeures(choixHeures);
					
					if(tm1.gettHeuresJ1()>tm1.gettHeuresJ2())
						tm1.setAppartenance(j1.getEtudiantActif());
					else if(tm1.gettHeuresJ2()>tm1.gettHeuresJ1())
						tm1.setAppartenance(j2.getEtudiantActif());
					else if (tm1.gettHeuresJ1()==tm1.gettHeuresJ2())
						System.out.println("On va lancer les Dès !");
					break;

				case 2:
					if(para=="j1")
						cs1.addHeuresJ1(choixHeures);
					else if (para =="j2")
						cs1.addHeuresJ2(choixHeures);
					j.getEtudiantActif().decrementerHeures(choixHeures);
					if(cs1.gettHeuresJ1()>cs1.gettHeuresJ2())
						cs1.setAppartenance(j1.getEtudiantActif());
					else if(cs1.gettHeuresJ2()>cs1.gettHeuresJ1())
						tm1.setAppartenance(j2.getEtudiantActif());
					else if (cs1.gettHeuresJ1()==cs1.gettHeuresJ2())
						System.out.println("On va lancer les Dès !");
					break;

				case 3:
					if(para=="j1")
						stage1.addHeuresJ1(choixHeures);
					else if (para =="j2")
						stage1.addHeuresJ2(choixHeures);
					j.getEtudiantActif().decrementerHeures(choixHeures);
					if(stage1.gettHeuresJ1()>stage1.gettHeuresJ2())
						tm1.setAppartenance(j1.getEtudiantActif());
					else if(stage1.gettHeuresJ2()>stage1.gettHeuresJ1())
						stage1.setAppartenance(j2.getEtudiantActif());
					else if (stage1.gettHeuresJ1()==stage1.gettHeuresJ2())
						System.out.println("On va lancer les Dès !");
					break;
				default:
					break;
				}
			}
			else
				System.out.println("Vous n'avez plus assez d'heures!");
			System.out.println(j2.getNomJoueur()+" vous avez "+j2.getEtudiantActif().getnombreDeHeures()+" heures de travail");

		}
	}


	public void choixNouveauEtudiant()
	{
		System.out.println("Vous les vous choisir une nouvel etudiant ? Y/N ");

		/*---------Cin de l'utilisateur ------*/
		Scanner in1 = new Scanner(System.in);
		String choixYN = in1.toString();
		/*---------Fin Cin de l'utilisateur ------*/

		if (choixYN == "y" || choixYN == "Y")
		{

		}



	}





}
