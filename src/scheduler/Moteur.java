package scheduler;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import jeu.Tc;
import environnement.*;
import interaction.Joueur;



public class Moteur {


	/*---Creation des Joueurs j est un object intermediaire et n'est pas utilisé--*/
	private Joueur j1, j2, j;
	/*--------------------------*/

	/*--------Creation des Uv --- */
	private static TM tm1= new TM(0,"tm1");
	private static CS cs1= new CS (1,"cs1");
	private static Stage stage1= new Stage(2,"stage1");
	
	
	/*------------------------------*/

	//Carte ca = new Carte( "map", pMapUV );

	public Moteur ()
	{

		/*--------------Pour verifier emplacement UV---------------------------------------*/
		int map [][] =  { {0,1,1},{1,0,0},{1,0,0} };
		int i;
		int idx;
		int ln;
		ln = map.length;
		boolean b;

		boolean[][] pMapUV = new boolean [ln][ln]; 
		for (i=0; i<ln; i++)
		{
			for (idx=0; idx<ln; idx++)
			{
				if (map[i][idx]==1)
					pMapUV[i][idx]=true;
				else
					pMapUV[i][idx]=false;
			}
		}

		/*------------------------------------------------------------------------------*/		

		/*----------Definition noms de joueurs et selection des etudiants-------------------------*/
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


		/*-----Afichage nom joueur et nb credit joueur1------*/
		j1.setNomJoueur(nomj1);
		System.out.println("Le nom du joueur 1 est : "+j1.getNomJoueur());
		System.out.println(" Il a : "+j1.getNbCredit()+ "credits");
		System.out.println("Le joueur 2 a : "+j2.getNbCredit()+" credits");
		System.out.println();
		/*-----------------------------------------------*/

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
		System.out.println("Joueur 1 : "+j1.getNbCredit()+" credit(s)");
		System.out.println("Joueur 2 : "+j2.getNbCredit()+" credit(s)");
		System.out.println();
		/*-------------------------------------------------------------------*/
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


		/*-----------------Si le nombre de credit du joueur est superieur au prix en credits de l'étudiant---------------*/
		if(j1.getNbCredit()>=choix)
		{
			j1.selectionEtudiant(choix,j1.getTabEtudiantIndex(choix-1));
			j1.decrementerNbCredit(choix);
			System.out.println("Vous êtes maintenant un "+j1.getEtudiantActif().getDescription()+j1.getEtudiantActif().getQualifCaract());
			System.out.println("Joueur 1 : "+j1.getNbCredit()+" credit(s)");
			System.out.println("Joueur 2 : "+j2.getNbCredit()+" credit(s)");
			System.out.println();
		}
		else
		{
			System.out.println("Vous n'avez pas assez de credit pour cet etudiant");
		}
		/*-------------------------------------------------------------------------------------------------------------------------*/


		/*----Affichage des etudiants selectionable--------------------------------------*/
		for (int i=0; i<j2.getTabEtudiant().length; i++)
			System.out.println(i+1 +" : "+j2.getTabEtudiantIndex(i).getDescription()+j2.getTabEtudiantIndex(i).getQualifCaract());


		/*---------Cin de l'utilisateur ------*/
		Scanner in1 = new Scanner(System.in);
		int choix1 = in1.nextInt();
		/*---------Fin Cin de l'utilisateur ------*/

		if(j2.getNbCredit()>=choix1)
		{
			j2.selectionEtudiant(choix1,j2.getTabEtudiantIndex(choix1-1));
			
			j2.decrementerNbCredit(choix1);
			
			System.out.println("Joueur 2 : "+j2.getNbCredit()+" credit(s)");
			System.out.println("Joueur 1 : "+j1.getNbCredit()+" credit(s)");
			System.out.println("Vous êtes maintenant un "+j2.getEtudiantActif().getDescription()+j2.getEtudiantActif().getQualifCaract());
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
			System.out.println(" Nb heures joueur 1 : "+j1.getEtudiantActif().getDescription()+j1.getEtudiantActif().getnombreDeHeures());
			System.out.println(" Nb heures joueur 2 : "+j2.getEtudiantActif().getDescription()+j2.getEtudiantActif().getnombreDeHeures());
			
			System.out.println("-----"+j.getNomJoueur()+" vous pouvez maintenant deplacer vos heurs de travail-----");

			System.out.println(j.getNomJoueur()+" vous avez "+j.getEtudiantActif().getnombreDeHeures()+" heures de travail");
			System.out.println("Voici les uv : ");	

			System.out.println("1. : "+tm1.getNomUv()+" emplacement : "+tm1.getNumber());

			System.out.println("Heures pour joueurs 1 : "+tm1.gettHeuresJ1()+" Heures pour joueur 2 : "+tm1.gettHeuresJ2());
			System.out.println();

			System.out.println("2. : "+cs1.getNomUv()+" emplacement : "+cs1.getNumber());

			System.out.println("Heures pour joueurs 1 : "+cs1.gettHeuresJ1()+" Heures pour joueur 2 : "+cs1.gettHeuresJ2());
			System.out.println();

			System.out.println("3. : "+stage1.getNomUv()+" emplacement : "+stage1.getNumber());

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

	/*	if (para == "j1")
		{
			j1=j;
		}
		else if (para =="j2")
		{
			j2=j;
		}*/
		
	}


	public void finTour()// methode verifiant l'appartenance des uv
	{

		/*----------Verification des appartenances---------------*/ 
		if(tm1.gettAppartenance()==j1.getEtudiantActif()) // si tm1 appartient à un etudiant du joueur 1
		{
			j1.incrementerNbCredit(1); // incremente le credit de joueur 1 de 1;
			System.out.println("L'UV "+ tm1.getNomUv()+" appartient à "+j1.getNomJoueur()+" qui est un "
					+j1.getEtudiantActif().getDescription()+j1.getEtudiantActif().getQualifCaract());

			//redonne les heures à joueur 1 moins 1h
			j1.getEtudiantActif().incrementerHeures(tm1.gettHeuresJ1()-1);

			// laisse 1h par uv
			tm1.setHeuresJ1(1);

		}
		else if (tm1.gettAppartenance()==j2.getEtudiantActif())
		{
			j2.incrementerNbCredit(1);
			System.out.println("L'UV "+ tm1.getNomUv()+" appartient à "+j2.getNomJoueur()+" qui est un "
					+j2.getEtudiantActif().getDescription()+j2.getEtudiantActif().getQualifCaract());
			//redonne les heures à joueur 1 moins 1h
			j2.getEtudiantActif().incrementerHeures(tm1.gettHeuresJ2()-1);

			// laisse 1h par uv
			tm1.setHeuresJ2(1);
		}
		else 
			System.out.println(tm1.getNomUv()+" n'appartien à aucun joueur");


		if(cs1.gettAppartenance()==j1.getEtudiantActif()) // si cs1 appartient à un etudiant du joueur 1
		{
			j1.incrementerNbCredit(1); // increment le credit de joueur 1 de 1;
			System.out.println("L'UV "+ cs1.getNomUv()+" appartient à "+j1.getNomJoueur()+" qui est un "
					+j1.getEtudiantActif().getDescription()+j1.getEtudiantActif().getQualifCaract());

			//redonne les heures à joueur 1 moins 1h
			j1.getEtudiantActif().incrementerHeures(cs1.gettHeuresJ1()-1);

			// laisse 1h par uv
			cs1.setHeuresJ1(1);
		}
		else if (cs1.gettAppartenance()==j2.getEtudiantActif())
		{
			j2.incrementerNbCredit(1);
			System.out.println("L'UV "+ cs1.getNomUv()+" appartient à "+j2.getNomJoueur()+" qui est un "
					+j2.getEtudiantActif().getDescription()+j2.getEtudiantActif().getQualifCaract());
			//redonne les heures à joueur 1 moins 1h
			j2.getEtudiantActif().incrementerHeures(cs1.gettHeuresJ2()-1);

			// laisse 1h par uv
			cs1.setHeuresJ2(1);
		}
		else 
			System.out.println(cs1.getNomUv()+" n'appartien à aucun joueur");


		if(stage1.gettAppartenance()==j1.getEtudiantActif()) // sis stage1 appartient à un etudiant du joueur 1
		{
			j1.incrementerNbCredit(1); // increment le credit de joueur 1 de 1;
			System.out.println("L'UV "+ stage1.getNomUv()+" appartient à "+j1.getNomJoueur()+" qui est un "
					+j1.getEtudiantActif().getDescription()+j1.getEtudiantActif().getQualifCaract());
			//redonne les heures à joueur 1 moins 1h
			j1.getEtudiantActif().incrementerHeures(stage1.gettHeuresJ1()-1);

			// laisse 1h par uv
			stage1.setHeuresJ1(1);
		}
		else if (stage1.gettAppartenance()==j2.getEtudiantActif())
		{
			j2.incrementerNbCredit(1);
			System.out.println("L'UV "+ stage1.getNomUv()+" appartient à "+j2.getNomJoueur()+" qui est un "
					+j2.getEtudiantActif().getDescription()+j2.getEtudiantActif().getQualifCaract());

			//redonne les heures à joueur 1 moins 1h
			j2.getEtudiantActif().incrementerHeures(stage1.gettHeuresJ2()-1);

			// laisse 1h par uv
			stage1.setHeuresJ2(1);
		}
		else 
			System.out.println(stage1.getNomUv()+" n'appartien à aucun joueur");

		/*----------------------------------------------------------------------------------------*/

	}



	public void choixNouveauEtudiant(String s)
	{
		if (s == "j1")
		{
			j=j1;
		}
		else if (s =="j2")
		{
			j=j2;
		}
		System.out.println(j.getNomJoueur()+ "Voulez-vous choisir une nouvel etudiant ? Y/N ");

		/*---------Cin de l'utilisateur ------*/
		Scanner in1 = new Scanner(System.in);
		String choixYN = in1.toString();
		/*---------Fin Cin de l'utilisateur ------*/

		if (choixYN == "y" || choixYN == "Y")
		{
			System.out.println("Vous pouvez selectionner un nouvel etudiant ");
			/*----Affichage des etudiants selectionables--------------*/
			for (int i=0; i<j2.getTabEtudiant().length; i++)
				System.out.println(i+1 +" : "+j2.getTabEtudiantIndex(i).getDescription()+j2.getTabEtudiantIndex(i).getQualifCaract());

			/*---------Cin de l'utilisateur ------*/
			Scanner in11 = new Scanner(System.in);
			int choix1 = in11.nextInt();
			/*---------Fin Cin de l'utilisateur ------*/
			System.out.println(j2.getNbCredit());

		}

	}


}
