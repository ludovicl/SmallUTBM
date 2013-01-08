package scheduler;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import jeu.Tc;
import environnement.*;
import ihm.*;
import interaction.Joueur;



public class Motor {

	private Joueur j1, j2;

	public static TypeUv tabUv[]= new TypeUv[20];

	private static int nbTour=0;
	private static int nbTourJoueurs=0;

	private Carte ca ;

	public Motor ()
	{	
		//2 stages 
		TypeUv stage1 = new Stage("ST40",1);
		//TypeUv stage2 = new Stage("st50",21);
		TypeUv stage2 = new Stage("ST50",2);//car bug avec 21 en number

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
		tabUv[0].setHeuresJ1(0);
		tabUv[0].setHeuresJ2(0);
		
		
		tabUv[1]=stage2;
		tabUv[1].setHeuresJ1(0);
		tabUv[1].setHeuresJ2(0);

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
		//	tabUv[20]=tm6;

		j1 = new Joueur();
		j2 = new Joueur();

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
	}



	// Accesseurs

	public Joueur getJ1(){
		return j1;
	}

	public Joueur getJ2(){
		return j2;
	}

	public void affecteNomJ1(String s) {
		j1.setNomJoueur(s);
	}

	public void affecteNomJ2(String s) {
		j2.setNomJoueur(s);
	}

	public static void incrementerNbTour()
	{
		nbTour++;
	}
	
	public static void incrementerNbTourJoueur()
	{
		nbTourJoueurs++;
	}


	public static int getTour() {
		return nbTour;
	}

	public static int setTour(){
		if( nbTourJoueurs%2 == 0)
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}

	
	// Méthode Prise des Uvs
	public void PriseUv(int heures, int indice, int j) {

		if(j == 1)
		{
			
			if (heures<=j1.getEtudiantActif().getnombreDeHeures())				// Si l'étudiant a assez d'heures pour prendre l'UV
			{
				
				for (int i=0; i<tabUv.length;i++)
				{
					// Si l'uv est voisine à une autre appartenant à l'étudiant ou si c'est le premier tour
					if(tabUv[i].gettAppartenance()==j1.getEtudiantActif() ||tabUv[i].gettAppartenance()==j1.getEtudiantEnDeclin() || nbTour==1)
					{
						if(((ca.isVoisin(tabUv[indice], tabUv[i])==true) || nbTour==1 ))	// Si l'uv est voisine à une autre appartenant à l'étudiant
						{					
							tabUv[indice].addHeuresJ1(heures);								// Ajouter les heures du J1 sur l'UV
							j1.getEtudiantActif().decrementerHeures(heures);				// Enlever les heures dépensées au joueur 1
							i=tabUv.length;													// Sortir de la boucle dès que nécessaire
						}
						else 
						{
							System.out.println("Vous ne pouvez pas placer des heures " +
									"si l'uv choisie n'est pas à coté d'une uv vous appartenant ");
						}
					}

				}
			
			}
		}
		else if(j==2)	// Même chose pour le joueur 2
		{
			 
			if (heures<=j2.getEtudiantActif().getnombreDeHeures())
			{
				for (int i=0; i<tabUv.length;i++)
				{
					//si l'uv à coté appartient à un des etudiants ou si c'est le 1er tour
					if(tabUv[i].gettAppartenance()==j2.getEtudiantActif() ||tabUv[i].gettAppartenance()==j2.getEtudiantEnDeclin() || nbTour==1)
					{
						System.out.println("nbTour : " + nbTour);
						if(((ca.isVoisin(tabUv[indice], tabUv[i])==true) || nbTour==1 ))//si l'uv choisie est à cote d'une uv appartenant au joueur
						{					
							tabUv[indice].addHeuresJ2(heures);
							j2.getEtudiantActif().decrementerHeures(heures);
							i=tabUv.length;
						}
						else 
						{
							System.out.println("Vous ne pouvez pas placer des heures " +
									"si l'uv choisie n'est pas à coté d'une uv vous appartenant ");
						}
					}
				}
			}

		}

	}					

	public void Appartenance() {
		int i;
		for(i=0;i<20;i++)			// On parcourt le tableau, pour chaque UV on comapre les heures du joueur 1 et 2 dépensées et on en déduit l'appartenance
		{
			if(tabUv[i].getHeuresJ1()>tabUv[i].getHeuresJ2())
				tabUv[i].setAppartenance(j1.getEtudiantActif());
			else if(tabUv[i].getHeuresJ2()>tabUv[i].getHeuresJ1())
				tabUv[i].setAppartenance(j2.getEtudiantActif());
		}
	}

	public int getScoreJ1() {
		return j1.getNbCredit();
	}

	public int getScoreJ2() {
		return j2.getNbCredit();
	}

	public void Score() {				// Calcul des Scores , pareillement, on parcoure le tableau pour chaque UV et on en déduit les scores
		int i;
		for (i=0;i<20;i++)
		{
			

			if(tabUv[i].gettAppartenance() == j1.getEtudiantActif())		
			{
				j1.setNbCredit(j1.getNbCredit() + tabUv[i].getPrix());
				System.out.println("Test prise1");
				System.out.println(tabUv[i].getNomUv());
			}
		    if(tabUv[i].gettAppartenance() == j2.getEtudiantActif())
			{
				j2.setNbCredit(j2.getNbCredit() + tabUv[i].getPrix());
				System.out.println("Test prise2");
				System.out.println(tabUv[i].getNomUv());
			}
			
		
		    
		    
		}
	}
	
	public Joueur testVictoire()
	{
		if(j1.getNbCredit()<j2.getNbCredit())
		{
			return j2;
		}
		else if(j1.getNbCredit()>j2.getNbCredit())
		{
			return j1;
		}
		else
		{
			return null;
		}	


	}




}


