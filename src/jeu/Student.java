package jeu;

import java.util.Random;
import java.util.Scanner;


public enum Student {

	TC("TC "),
	Master("Master "),
	License("License "),
	Etranger("Etranger "),
	Prepa("Prepa "),
	DUT("DUT ");

	private Qualification qualif;

	private int nbHeures=10;

	private String nomQualification;
	private String description = "";
	private String typeStudent;
	
	

	Student(String typeStu)
	{
		typeStudent=typeStu;

		/*--random entre 1 et 8---*/
		int lower = 1;
		int higher = 8;
		int random = (int)(Math.random() * (higher-lower)) + lower;
		/*-------------------------*/

		switch (random) 
		{ 
		case 1:qualif=Qualification.Geek;
		nomQualification="Geek";
		break; 	

		case 2:qualif=Qualification.Pistone;
		nomQualification="pistone";
		break; 

		case 3:qualif=Qualification.PossedantUneVoiture; 
		nomQualification="possedant une voiture";
		break; 


		case 4:qualif=Qualification.AlcooliqueBDF;
		nomQualification="alcoolique du BDF";
		break;

		case 5:qualif=Qualification.SemestreSup; 
		nomQualification="possédant des semestres sup";
		break; 

		case 6:qualif=Qualification.Ae;
		nomQualification="faisant partie de l'AE";
		break; 

		case 7:qualif=Qualification.Philateliste; 
		nomQualification="philateliste";
		break; 

		case 8:qualif=Qualification.Bds;
		nomQualification="faisant partie du bureau des sport";
		break; 

		}
		
		description=typeStudent+nomQualification;
	}

	public static Student[] reorganiserTableau(Student tab[],int index)
	{	
		Student newTab[]=new Student[tab.length-1];//creation d'un nouveau tableau

		//recopie tout les element de tab dans newTab sauf l'index
		for(int i=0; i<index-1; i++)//on va de 0 à index-1
		{
			System.out.println("work 1 !------"+ i);
			newTab[i]=tab[i];
		}	

		for(int i=index-1; i<tab.length-1; i++)
		{
			System.out.println("work 2 ! -----"+(i-index+1) );
			newTab[i]=tab[i+1];
		}


		for(int i=0; i<newTab.length;i++)
			System.out.println(newTab[i]);
		System.out.println("all work !");
		//	tab=newTab;
		return   newTab;
	} 

	public String getDescription ()
	{
		return this.description;
	}	

	private int nombreHeuresDeTravail=10;

	public int getNombreHeursDeTravail()
	{
		return nombreHeuresDeTravail;
	}

	public void setNombreHeursDeTravai(int h)
	{
		nombreHeuresDeTravail=h;
	}





}
