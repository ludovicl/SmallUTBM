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
	
	public static int getTour() {
		return nbTour;
	}
	
	public static int setTour(){
		if( nbTour%2 == 0)
		{
			return 2;
		}
		else
		{
			return 1;
		}
	}
	
	public void PriseUv (int heures, int indice, int j) {
		/*if(j == 1)
		{
			tabUv[indice]. addHeuresJ1(heures);
			tabUv[indice].setPossesseur(J1);
			System.out.println("Joueur 1 a étudié l'UV " + tabUv[indice].getNomUv() + " pendant " + heures +" heures ");
		}
		else if(j == 2)
		{
			tabUv[indice]. addHeuresJ2(heures);
			System.out.println("Joueur 2 a étudié l'UV " + tabUv[indice].getNomUv() + " pendant " + heures +" heures ");
		}*/
		
		if(j == 1)
		{
			if(tabUv[indice].getHeuresJ2() < j1.getHeures())
			{
				tabUv[indice].addHeuresJ1(heures);
				tabUv[indice].setPossesseur(j1);
				System.out.println("Joueur 1 a étudié l'UV " + tabUv[indice].getNomUv() + " pendant " + heures +" heures ");
				
			}
			else
			{
				System.out.println("vous n'avez pas assez d'heures pour prendre cette UV");
				
			}
		}
		else if(j == 2)
		{
			if(tabUv[indice].getHeuresJ1() < j2.getHeures())
			{
				tabUv[indice].addHeuresJ2(heures);
				tabUv[indice].setPossesseur(j2);
				System.out.println("Joueur 2 a étudié l'UV " + tabUv[indice].getNomUv() + " pendant " + heures +" heures ");
				
			}
			else
			{
				System.out.println("vous n'avez pas assez d'heures pour prendre cette UV");
				
			}
		}
	}
	
	public void AjusteHeures(int moins, int j) {
		if(j == 1)
		{
			 j1.HeuresMoins(moins);
		}
		else if(j == 2)
		{
			j2.HeuresMoins(moins);
		}
	}
	
	public int getScoreJ1() {
		return j1.getNbCredit();
	}
	
	public int getScoreJ2() {
		return j2.getNbCredit();
	}
	
	public void Score() {
		int i;
		for (i=0;i<20;i++)
		{
			if(tabUv[i].getPossesseur() == j1)
			{
				j1.setNbCredit(j1.getNbCredit() + tabUv[i].getPrix());
				System.out.println("Test prise");
				System.out.println(tabUv[i].getNomUv());
			}
			else if(tabUv[i].getPossesseur() == j2)
			{
				j2.setNbCredit(j2.getNbCredit() + tabUv[i].getPrix());
				System.out.println("Test prise");
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


