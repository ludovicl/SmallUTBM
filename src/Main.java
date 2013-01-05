import ihm.InitFrame;

import scheduler.Moteur;


public class Main {

	public static void main (String[] args)
	{

		Moteur m= new Moteur();
		m.choixEtudiants();
		
		for (int i=1; i<9; i++)
		{
			System.out.println("TOUR : " +i );
			Moteur.incrementerNbTour();
			m.choixUv("j1");
			m.choixNouveauEtudiant("j1");
			m.choixUv("j2");
			m.choixNouveauEtudiant("j2");
			m.finTour();
		}

		m.testVictoire();
	}


}
