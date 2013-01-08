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
		Catalogue C = new Catalogue();
		
		InitFrame window = new InitFrame(m.tabUv);
		window.visible();
		
		m.getJ1().getEtudiantActif().setNbHeures(5);
		m.getJ2().getEtudiantActif().setNbHeures(5);
		// Tant que la partie n'est pas lancée ( récupération du nom des Joueurs)
				while(window.getF().isVisible())
				{
					System.out.println(" ");
					
					
				}
				//m.incrementerNbTour();
				m.affecteNomJ1(window.getTextField(1));
				m.affecteNomJ2(window.getTextField(2));
				
				Plan carte = new Plan(m.tabUv , Prise);
				carte.getF().setVisible(true);
				
				m.Score();
				carte.setScore("Score :        				            "+ m.getJ1().getNomJoueur()+ " :  "+ m.getScoreJ1() + "                     "+ m.getJ2().getNomJoueur()+ " : "+ m.getScoreJ2());
				carte.setNomJoueur(m.getJ1().getNomJoueur());
				carte.setPhoto(1);
				
				
				//while(m.getTour() < 3)
				//{
					

					//Début du tour du joueur 1
					while (m.getJ1().getEtudiantActif().getnombreDeHeures() > 0)
					{
						while(carte.getPrise() == false)
						{
							System.out.println(" ");
						}	
						heure = Prise.waitForIt(); 													// Attendre que la messagebox soit fermée pour récuperer la valeur du JSpinner
						m.PriseUv(heure,carte.getIndice(),1);										// Prise des Uvs
						carte.setHeuresRestantes(m.getJ1().getEtudiantActif().getnombreDeHeures());	// Rectification de l'indication des heures restantes sur la carte
						m.Appartenance();
						carte.setPrise(false);
					}
					// Préparation de la carte pour le joueur 2
					while(carte.getFini() == false)
					{
						
					}
					Plan.setFini(false);
					carte.setHeuresRestantes(m.getJ2().getEtudiantActif().getnombreDeHeures());
					//Début du tour du joueur 2
					while (m.getJ2().getEtudiantActif().getnombreDeHeures() > 0)
					{
						while(carte.getPrise() == false)
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
						
					}
					Plan.setFini(false);
					carte.setHeuresRestantes(m.getJ1().getEtudiantActif().getnombreDeHeures());
					//Décompte des scores
					m.Score();
					carte.setScore("Score :        				            "+ m.getJ1().getNomJoueur()+ " :  "+ m.getScoreJ1() + "                 "+ m.getJ2().getNomJoueur()+ " : "+ m.getScoreJ2());
				//}
				
				
			
	}	
	
}
	
