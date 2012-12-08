package scheduler;
import jeu.Tc;
import jeu.Student;
import environnement.Uv;
import interaction.Joueur;

public class Moteur {

	
	/*---Instantiation des Joueurs--*/
	private Joueur j1, j2;
	/*--------------------------*/
	
	/*--------Instantiation des Uv --- */
	private Uv tm1= Uv.TM;
	private Uv cs1 = Uv.CS;
	private Uv stage1 = Uv.Stage;
	/*------------------------------*/
	
	Moteur ()
	{
		/*---Definition des coordonnées des UV---*/	
		tm1.setCoordonnees(1, 2);
		cs1.setCoordonnees(2, 2);
		stage1.setCoordonnees(3, 2);
		/*---------------------------------*/
		
		
		String nomj1;
		//System..in(nomj1);

		j1.setNomJoueur(nomj1);
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
