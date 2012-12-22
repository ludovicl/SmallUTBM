import scheduler.Moteur;


public class Main {

	public static void main (String[] args)
	{
				
		Moteur m= new Moteur();
		m.genererCarte();
		m.choixEtudiants();
		m.choixUv("j1");
		
		System.out.println("Au joueur 2 de choisir !");
		
		m.choixUv("j2");
		
		m.finTour();
	
	//	m.choixUv("j1");
		
		m.choixUv("j1");
		m.choixNouveauEtudiant("j1");
		
		
	//	m.choixUv("j2");
		
	}
	
	
}
