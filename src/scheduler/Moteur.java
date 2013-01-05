package scheduler;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import jeu.Tc;
import environnement.*;
import ihm.InitFrame;
import interaction.Joueur;



public class Moteur {


	/*---Creation des Joueurs j est un object intermediaire et n'est pas utilisé--*/
	private Joueur j1, j2, j;
	/*--------------------------*/


	/*--------Tablau d'uv !!!!!!!Pensez à bien le mettre à la bonne taille--- */
	private static TypeUv tabUv[]= new TypeUv[20];
	/*------------------------------*/



	private static int nbTour=0;//nombre de tour joué

	private Carte ca ;
	public static TypeUv[] getTabUv()
	{
		return tabUv;
	}

	public Joueur getJ1()
	{
		return j1;
	}

	public Joueur getJ2()
	{
		return j2;
	}



	public Moteur ()
	{	
		//2 stages 
		TypeUv stage1 = new Stage("ST40",1);
		//TypeUv stage2 = new Stage("st50",21);
		TypeUv stage2 = new Stage("st50",2);//car bug avec 21 en number

		//3 CG
		//TypeUv cg1 = new CG("DR02",6);
		TypeUv cg1 = new CG("DR02",3);//car bug avec 6 en number

		TypeUv cg2 = new CG("AR03",10);
		TypeUv cg3 = new CG ("GE01",4);
		//4 Langues
		TypeUv langue1 = new Langue("LE03_BULAT",8);
		TypeUv langue2 = new Langue("LG02",3);
		TypeUv langue3 = new Langue("LS02",19);
		TypeUv langue4 = new Langue("LC00",20);
		//6 CS 
		TypeUv cs1 = new CS("MT42",20);
		TypeUv cs2 = new CS("MT45",5);
		TypeUv cs3 = new CS("BD40",7);
		TypeUv cs4 = new CS("LO43",14);
		TypeUv cs5 = new CS("LO45",18);
		TypeUv cs6 = new CS("RE43",9);
		//6 TM
		TypeUv tm1 = new TM("LO54",11);
		TypeUv tm2 = new TM("TW52",12);
		TypeUv tm3 = new TM("TX52",13);
		TypeUv tm4 = new TM("TO52",15);
		TypeUv tm5 = new TM("VI50",16);
		TypeUv tm6 = new TM("IA54",17);


		tabUv[0]=stage1;
		tabUv[1]=stage2;
		tabUv[2]=cg1;
		tabUv[3]=cg2;
		tabUv[4]=cg3;
		tabUv[5]=langue1;
		tabUv[6]=langue2;
		tabUv[7]=langue3;
		tabUv[8]=langue4;
		tabUv[9]=cs1;
		tabUv[10]=cs2;
		tabUv[11]=cs3;
		tabUv[12]=cs4;
		tabUv[13]=cs5;
		tabUv[14]=cs6;
		tabUv[15]=tm1;
		tabUv[16]=tm2;
		tabUv[17]=tm3;
		tabUv[18]=tm4;
		tabUv[19]=tm5;
		//tabUv[20]=tm6;





		/*--------------Pour verifier emplacement UV---------------------------------------*/
		int map [][] =  {{1,0,1,1,0,1,0,1,0,1,0,1,0,0,1,1,0,0,1,0,1,1}
		,{0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		,{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		,{1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		,{0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		,{1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		,{0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0}
		,{1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0}
		,{0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0}
		,{1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0}
		,{0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,0,0}
		,{1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,0,0}
		,{1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0}
		,{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,0}
		,{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0}
		,{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1}
		,{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1}};

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

		ca =   new Carte( "map", pMapUV );


		/*------------------------------------------------------------------------------*/		

		/*----------Definition noms de joueurs et selection des etudiants-------------------------*/





		j=new Joueur();

		j1 = new Joueur();
		j2 = new Joueur();	



		System.out.println(ca.isVoisin(stage1, stage2));


		System.out.println("Saisir le nom du joueur1 :");	

	///*	---------Cin de l'utilisateur ------
		char buf[]=new char[10];
		Reader in = new InputStreamReader(System.in);
		try {
			in.read(buf,0,10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nomj1 = new String(buf);
		//---------Fin Cin de l'utilisateur ------*/



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

		while (j.etudiantActif.getnombreDeHeures()>0)// tant que le joueur a des credits
		{
			System.out.println(" Nb heures joueur 1 : "+j1.getEtudiantActif().getDescription()+j1.getEtudiantActif().getnombreDeHeures());
			System.out.println(" Nb heures joueur 2 : "+j2.getEtudiantActif().getDescription()+j2.getEtudiantActif().getnombreDeHeures());

			System.out.println("-----"+j.getNomJoueur()+" vous pouvez maintenant deplacer vos heurs de travail-----");

			System.out.println(j.getNomJoueur()+" vous avez "+j.getEtudiantActif().getnombreDeHeures()+" heures de travail");
			System.out.println("Voici les uv : ");	

			for (int i=0; i<tabUv.length;i++)
			{
				System.out.println((i+1)+" : "+tabUv[i].getNomUv()+ " emplacement : "+tabUv[i].getNumber());
				System.out.println("Heures pour joueurs 1 : "+tabUv[i].gettHeuresJ1()+" Heures pour joueur 2 : "+tabUv[i].gettHeuresJ2());
			}
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
				choixUv=choixUv-1;




				if(para=="j1")
				{
					//compare les uv des etudiants du joueur pour savoir si elles sont cote à cote
					for (int i=0; i<tabUv.length;i++)
					{
						//si l'uv à coté appartient à un des etudiants ou si c'est le 1er tour
						if(tabUv[i].gettAppartenance()==j1.getEtudiantActif() ||tabUv[i].gettAppartenance()==j1.getEtudiantEnDeclin() || nbTour==1)
						{
							if(((ca.isVoisin(tabUv[choixUv], tabUv[i])==true) || nbTour==1 ))//si l'uv choisie est à cote d'une uv appartenant au joueur
							{					
								tabUv[choixUv].addHeuresJ1(choixHeures);
								j.getEtudiantActif().decrementerHeures(choixHeures);
								i=tabUv.length;
							}
							else 
								System.out.println("Vous ne pouvez pas placer des heures " +
										"si l'uv choisit n'est pas à coté d'une uv vous appartenant ");
						}
					}
				}

				if(para=="j2")
				{
					//compare les uv des etudiants du joueur pour savoir si elles sont cote à cote
					for (int i=0; i<tabUv.length;i++)
					{
						//si l'uv appartient à un des etudiants ou si c'est le 1er tour
						if(tabUv[i].gettAppartenance()==j2.getEtudiantActif() ||tabUv[i].gettAppartenance()==j2.getEtudiantEnDeclin() || nbTour==1)
						{
							if(((ca.isVoisin(tabUv[choixUv], tabUv[i])==true) || nbTour==1 ))//si l'uv choisie est à cote d'une uv appartenant au joueur
							{					
								tabUv[choixUv].addHeuresJ2(choixHeures);
								j.getEtudiantActif().decrementerHeures(choixHeures);
								i=tabUv.length;
							}
							else 
								System.out.println("Vous ne pouvez pas placer des heures " +
										"si elle l'uv choisit n'est pas à coté d'une uv vous appartenant ");
						}
					}
				}

				/*--------------Attribution des appartenances---------------*/
				if(tabUv[choixUv].gettHeuresJ1()>tabUv[choixUv].gettHeuresJ2())
					tabUv[choixUv].setAppartenance(j1.getEtudiantActif());
				else if(tabUv[choixUv].gettHeuresJ2()>tabUv[choixUv].gettHeuresJ1())
					tabUv[choixUv].setAppartenance(j2.getEtudiantActif());
				else if (tabUv[choixUv].gettHeuresJ1()==tabUv[choixUv].gettHeuresJ2())
				{
					int lower = 1;
					int higher = 2;
					int random = (int)(Math.random() * (higher-lower)) + lower;

					System.out.println("LANCEMENT DES DE : "+random);
					if(random==1)
					{
						tabUv[choixUv].setAppartenance(j1.getEtudiantActif());
					}
					else if (random==2)
					{
						tabUv[choixUv].setAppartenance(j2.getEtudiantActif());
					}						

				}

			}
			else
				System.out.println("Vous n'avez plus assez d'heures!");

			System.out.println(j2.getNomJoueur()+" vous avez "+j2.getEtudiantActif().getnombreDeHeures()+" heures de travail");
		}



	}


	public void finTour()// methode verifiant l'appartenance des uv en fin de tour
	{

		/*----------Verification des appartenances---------------*/ 
		for(int i=0; i<tabUv.length; i++)
		{


			if(tabUv[i].gettAppartenance()==j1.getEtudiantActif()) // si tm1 appartient à un etudiant du joueur 1
			{
				j1.incrementerNbCredit(1); // incremente le credit de joueur 1 de 1;
				System.out.println("L'UV "+ tabUv[i].getNomUv()+" appartient à "+j1.getNomJoueur()+" qui est un "
						+j1.getEtudiantActif().getDescription()+j1.getEtudiantActif().getQualifCaract());

				//redonne les heures à joueur 1 moins 1h
				j1.getEtudiantActif().incrementerHeures(tabUv[i].gettHeuresJ1()-1);

				// laisse 1h par uv
				tabUv[i].setHeuresJ1(1);

			}
			else if (tabUv[i].gettAppartenance()==j2.getEtudiantActif())
			{
				j2.incrementerNbCredit(1);
				System.out.println("L'UV "+ tabUv[i].getNomUv()+" appartient à "+j2.getNomJoueur()+" qui est un "
						+j2.getEtudiantActif().getDescription()+j2.getEtudiantActif().getQualifCaract());
				//redonne les heures à joueur 1 moins 1h
				j2.getEtudiantActif().incrementerHeures(tabUv[i].gettHeuresJ2()-1);

				// laisse 1h par uv
				tabUv[i].setHeuresJ2(1);
			}
			else 
				System.out.println(tabUv[i].getNomUv()+" n'appartien à aucun joueur");
		}

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

		System.out.println(j.getNomJoueur()+ "Voulez-vous choisir une nouvel etudiant ? 1 pour OUI ");

		/*---------Cin de l'utilisateur ------*/
		Scanner in1 = new Scanner(System.in);
		int choixYN = in1.nextInt();
		/*---------Fin Cin de l'utilisateur ------*/


		if (choixYN==1)
		{
			System.out.println("Vous pouvez selectionner un nouvel etudiant ");
			/*----Affichage des etudiants selectionables--------------*/
			for (int i=0; i<j1.getTabEtudiant().length; i++)
				System.out.println(i+1 +" : "+j2.getTabEtudiantIndex(i).getDescription()+j2.getTabEtudiantIndex(i).getQualifCaract());

			/*---------Cin de l'utilisateur ------*/
			Scanner in11 = new Scanner(System.in);
			int choix1 = in11.nextInt();
			/*---------Fin Cin de l'utilisateur ------*/

			System.out.println(j2.getNbCredit());

			if (choix1<=j.getNbCredit())
			{
				for(int i=0; i<tabUv.length; i++)// on laisse 1 heure sur chaque uv par joueur
				{
					//j.getEtudiantEnDeclin().setNbHeures(0);

					if(tabUv[i].gettAppartenance()==j.getEtudiantActif())
					{
						//passe l'édudiant actif en declin;
						j.setEtudiantEnDeclin(j.getEtudiantActif());

						if(j==j1)
							tabUv[i].setHeuresJ1(1);
						else if (j==j2)
							tabUv[i].setHeuresJ2(1);
					}

					//selection du nouvel étudiant
					j1.selectionEtudiant(choix1,j.getTabEtudiantIndex(choix1-1));
					j1.decrementerNbCredit(choix1);
					System.out.println("Vous êtes maintenant un "+j.getEtudiantActif().getDescription()+j.getEtudiantActif().getQualifCaract());
				}	

			}
			else 
				System.out.println("Vous n'avez pas assez de credit");
		}

	}

	public static void incrementerNbTour()
	{
		nbTour++;
	}

	public void testVictoire()
	{
		if(j1.getNbCredit()<j2.getNbCredit())
		{
			System.out.println(j2.getNomJoueur() +" vous avez gagné !");
		}
		else if(j1.getNbCredit()>j2.getNbCredit())
		{
			System.out.println(j1.getNomJoueur() +" vous avez gagné !");
		}
		else
		{
			System.out.println("Egualite entre les joueurs !");
		}	


	}




}
