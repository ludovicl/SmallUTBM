package jeu;

public class Etudiant {


	protected int nombreDeHeures;


	private Caracteristique qualif;

	private int nbHeures=10;

	private String nomQualification;
	private String description = "";
	private String typeStudent;

	public Etudiant() {
	}

	Etudiant(String typeStu)
	{
		typeStudent=typeStu;

		/*--random entre 1 et 8---*/
		int lower = 1;
		int higher = 8;
		int random = (int)(Math.random() * (higher-lower)) + lower;
		/*-------------------------*/

		switch (random) 
		{ 
		case 1:qualif=Caracteristique.Geek;
		nomQualification="Geek";
		break; 	

		case 2:qualif=Caracteristique.Pistone;
		nomQualification="pistone";
		break; 

		case 3:qualif=Caracteristique.PossedantUneVoiture; 
		nomQualification="possedant une voiture";
		break; 


		case 4:qualif=Caracteristique.AlcooliqueBDF;
		nomQualification="alcoolique du BDF";
		break;

		case 5:qualif=Caracteristique.SemestreSup; 
		nomQualification="possédant des semestres sup";
		break; 

		case 6:qualif=Caracteristique.Ae;
		nomQualification="faisant partie de l'AE";
		break; 

		case 7:qualif=Caracteristique.Philateliste; 
		nomQualification="philateliste";
		break; 

		case 8:qualif=Caracteristique.Bds;
		nomQualification="faisant partie du bureau des sport";
		break; 

		}

		description=typeStudent+nomQualification;
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

	public void decrementerHeures()
	{
		nombreDeHeures--;
	}

	public void incrementerHeures()
	{
		nombreDeHeures++;
	}


	public static Etudiant[] reorganiserTableau(Etudiant tab[],int index)
	{	
		Etudiant newTab[]=new Etudiant[tab.length-1];//creation d'un nouveau tableau

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


