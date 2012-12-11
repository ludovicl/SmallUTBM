package jeu;

public class Etudiant {


	protected int nombreDeHeures;


	private Caracteristique qualif;

	public String getQualifCaract()
	{
		System.out.println("dans get Qualif caract");
		return qualif.getDescription();
		
	}
	


	protected String nomQualification;
	protected String description;
	protected String typeStudent;
	
	//public Etudiant() {
		
	//}

	public Etudiant()//String typeStu)
	{
		//typeStudent=typeStu;

		/*--random entre 1 et 8---*/
		int lower = 1;
		int higher = 8;
		int random = (int)(Math.random() * (higher-lower)) + lower;
		/*-------------------------*/

		switch (random) 
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
		//System.out.println("DANS ETUDIANT : "+description);

	//	description=typeStudent+qualif.getDescription();
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


