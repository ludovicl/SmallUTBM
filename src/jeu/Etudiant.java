package jeu;

import java.util.ArrayList;
import java.util.Vector;

import environnement.TypeUv;

public class Etudiant {


	private int random (int min, int max)
	{
		return  (int)(Math.random() * (max-min)) + min;
	}

	protected int nombreDeHeures=5;
	private static int rand;
	private Caracteristique qualif;
	protected String nomQualification;
	protected String description;
	protected String typeStudent;

	
	// à implementer
	private static ArrayList<Integer> listRandom= new ArrayList<Integer>(8);

	public String getQualifCaract()
	{
		return qualif.getDescription();

	}


	public Etudiant()
	{
		rand = random(1,8);// effectuer un random en 1 et 8


		switch (rand) 
		{ 
		case 1:
			Geek unGeek=new Geek();
			qualif = unGeek;
			break; 	

		case 2:
			Pistone unPistone=new Pistone();
			qualif = unPistone;
			break; 

		case 3:
			PossedantVoiture possVoiture = new PossedantVoiture(); 
			qualif = possVoiture;
			break; 


		case 4:
			AlcooliqueBdf alcoBDF= new AlcooliqueBdf();
			qualif=alcoBDF;
			break;

		case 5:
			SemestreSup semSup = new SemestreSup(); 
			qualif = semSup;
			break; 

		case 6:
			Ae assoEtudi=new Ae();
			qualif=assoEtudi;
			break; 

		case 7:
			Philateliste unPhilateliste= new Philateliste(); 
			qualif= unPhilateliste;
			break; 

		case 8:
			Bds bureauSport = new Bds();
			qualif = bureauSport;
			break; 

		}

	}


	public void deplacerHeure()
	{
		if(nombreDeHeures > 0)
			nombreDeHeures--;
		else
			System.out.println("Vous n'avez plus d'heures ?? d??placer sur cet ??tudiant");
	}

	public int getnombreDeHeures()
	{
		return nombreDeHeures;
	}

	public void decrementerHeures(int h)
	{
		nombreDeHeures=nombreDeHeures-h;
	}

	public void incrementerHeures(int h)
	{
		nombreDeHeures+=h;
	}


	public static Etudiant[] reorganiserTableau(Etudiant tab[],int index)
	{	
		Etudiant newTab[]=new Etudiant[tab.length-1];//creation d'un nouveau tableau

		//recopie tout les element de tab dans newTab sauf l'index
		for(int i=0; i<index-1; i++)//on va de 0 à index-1
		{
			newTab[i]=tab[i];
		}	

		for(int i=index-1; i<tab.length-1; i++)
		{
			newTab[i]=tab[i+1];
		}
		
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

	public void deplacerHeures(int nbH, TypeUv uv)
	{
		
	}
	

}


