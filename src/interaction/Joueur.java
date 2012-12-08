package interaction;
import jeu.Student;

public class Joueur {


	private int nbCredit;
	private String nomJoueur;
	
		
    public Student studentEnDeclin;
    public Student studentActif;
    
    
    public Joueur()
    {

    }
    
	 public void setNomJoueur (String nom)
	 {
		 this.nomJoueur=nom;
		 
	 }
	 
	 public String getNomJoueur()
	 {
		 return nomJoueur;
	 }
	 
	 public void passerEtudiantEnDeclin() 
	 {
		  
	 }
	
	  public void deplacerHeures() 
	  {
		  
	  }
	
	  public void lancerDe() 
	  {
		  
	  }
	
	  public void finirTour() 
	  {
		  
	  }
	
	  public void choisirEtudiant(Student stu) 
	  {
		  studentActif=stu;
		  
	  }
	
	  
	  
}
