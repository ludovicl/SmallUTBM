import environnement.CS;
import environnement.TypeUv;
import jeu.Etudiant;
import ihm.*;
import scheduler.*;


public class MainFinal {

	public static void main (String[] args)
	{
		int heure = 0;

		MessageBox Prise = new MessageBox();
		Motor m= new Motor();



		Etudiant etu2 = new Etudiant();
		m.getJ2().setEtudiantActif(etu2);

		Etudiant etu1 = new Etudiant();
		m.getJ1().setEtudiantActif(etu1);

		Victoire V = new Victoire();
		
		Catalogue C = new Catalogue(etu1);
		
		

		InitFrame window = new InitFrame(m.tabUv);
		window.visible();



		// Tant que la partie n'est pas lancée ( récupération du nom des Joueurs)
		while(window.getF().isVisible())
		{
			System.out.println(" ");


		}
		//m.incrementerNbTour();
		m.affecteNomJ1(window.getTextField(1));
		m.affecteNomJ2(window.getTextField(2));
		C.getF().setVisible(true);
		
		while(C.getF().isVisible())
		{
			System.out.println(" ");
		}
		
		Plan carte = new Plan(m.tabUv , Prise);
		carte.getF().setVisible(true);

		m.Score();
		carte.setScore("Score :        				            "+ m.getJ1().getNomJoueur()+ " :  "+ m.getScoreJ1() + "                     "+ m.getJ2().getNomJoueur()+ " : "+ m.getScoreJ2());
		carte.setNomJoueur(m.getJ1().getNomJoueur());
		carte.setPhoto(1);


		while(m.getTour() < 3)
		{
			//Initialisation d'un tour de Jeu 
			m.getJ1().getEtudiantActif().setNbHeures(5);
			m.getJ2().getEtudiantActif().setNbHeures(5);
			m.incrementerNbTour();
			Plan.run(m.getTour(),3);
			carte.setHeuresRestantes(m.getJ1().getEtudiantActif().getnombreDeHeures());
			//Début du tour du joueur 1
			while (m.getJ1().getEtudiantActif().getnombreDeHeures() > 0)					// Tant que le joueur a encore des heures il peut continuer à étudier des UVs
			{
				while(carte.getPrise() == false)											// Tant que la MessageBox n'a pas été fermée avec le bouton Valider
				{
					System.out.println(" ");
				}	
				heure = Prise.waitForIt(); 													// Attendre que la messagebox soit fermée correctement pour récuperer la valeur du JSpinner
				m.PriseUv(heure,carte.getIndice(),1);										// Prise des Uvs
				carte.setHeuresRestantes(m.getJ1().getEtudiantActif().getnombreDeHeures());	// Rectification de l'indication des heures restantes sur la carte
				m.Appartenance();
				carte.setPrise(false);
			}
			// Préparation de la carte pour le joueur 2

			while(carte.getFini() == false)
			{
				System.out.println(" ");
			}
			Plan.setFini(false);
			carte.setHeuresRestantes(m.getJ2().getEtudiantActif().getnombreDeHeures());		// Réinitialisation du cadre du Joueur : heures disponibles

			//Début du tour du joueur 2
			while (m.getJ2().getEtudiantActif().getnombreDeHeures() > 0)					// Tant que le joueur a encore des heures il peut continuer à étudier des UVs
			{
				while(carte.getPrise() == false)											// Tant que la MessageBox n'a pas été fermée avec le bouton Valider
				{
					System.out.println(" ");
				}	

				heure = Prise.waitForIt(); 													// Attendre que la messagebox soit fermée pour récuperer la valeur du JSpinner
				m.PriseUv(heure,carte.getIndice(),2);										// Prise des Uvs
				m.Appartenance();
				carte.setHeuresRestantes(m.getJ2().getEtudiantActif().getnombreDeHeures());	// Rectification de l'indication des heures restantes sur la carte
				carte.setPrise(false);
			}
			// Préparation de la carte pour le joueur 1
			while(carte.getFini() == false)		
			{
				System.out.println(" ");
			}
			Plan.setFini(false);
			carte.setHeuresRestantes(m.getJ1().getEtudiantActif().getnombreDeHeures());		// Réinitialisation du cadre du Joueur : heures disponibles
			//Décompte des scores
			m.Score();									
			carte.setScore("Score :        				            "+ m.getJ1().getNomJoueur()+ " :  "+ m.getScoreJ1() + "                 "+ m.getJ2().getNomJoueur()+ " : "+ m.getScoreJ2());
			System.out.println("Tour :  " + m.getTour());
		};
			m.incrementerNbTour();
			V.setGagnant(m.testVictoire());
			V.getF().setVisible(true);


	}	

}

