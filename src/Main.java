import scheduler.Moteur;


public class Main {

	public static void main (String[] args)
	{

		Moteur m= new Moteur();
		m.choixEtudiants();
		
		System.out.println("TOUR UN !");
		/*---Tour1--------*/
		Moteur.incrementerNbTour();
		m.choixUv("j1");
		m.choixNouveauEtudiant("j1");
		m.choixUv("j2");
		m.choixNouveauEtudiant("j2");
		m.finTour();
		/*---------------*/
		
		System.out.println("TOUR DEUX !");
		
		/*---Tour2--------*/
		Moteur.incrementerNbTour();
		m.choixUv("j1");
		m.choixUv("j2");
		m.choixNouveauEtudiant("j1");
		m.finTour();
		/*---------------*/
		
		
	}


}
