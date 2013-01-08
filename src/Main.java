import ihm.*;

import scheduler.*;


public class Main {


	public static void main (String[] args)
	{
		int heure = 0;
		
		MessageBox Prise = new MessageBox();
		Motor m= new Motor();
		
		Victoire V = new Victoire();
	 
		
		

		InitFrame window = new InitFrame(m.tabUv);
		window.visible();
		// Tant que la partie n'est pas lancée ( récupération du nom des Joueurs)
		while(window.getF().isVisible())
		{
			
		}
		m.incrementerNbTour();
		m.affecteNomJ1(window.getTextField(1));
		m.affecteNomJ2(window.getTextField(2));
		
		Plan carte = new Plan(m.tabUv , Prise);
		carte.getF().setVisible(true);
		
		m.Score();
		carte.setScore("Score :        				            "+ m.getJ1().getNomJoueur()+ " :  "+ m.getScoreJ1() + "                     "+ m.getJ2().getNomJoueur()+ " : "+ m.getScoreJ2());
		carte.setNomJoueur(m.getJ1().getNomJoueur());
		carte.setPhoto(1);
		
		// Débtut d'une partie : 10 tours de jeu 
		while(m.getTour() < 4)
		{
			m.getJ1().setHeures(5);
			m.getJ2().setHeures(5);
			carte.setHeuresRestantes(m.getJ1().getHeures());
			
			// Début du tour du Joueur 1
				while(m.getJ1().getHeures() != 0)
				{
						while(carte.getPrise() == false)
						{
							
						}
						heure = Prise.waitForIt();  					// Attends que la messagebox soit fermée
					///	m.PriseUv(heure,carte.getIndice(),1);			// Prise des Uvs
						m.AjusteHeures(heure, 1);						// Décrementation des heures disponibles de l'étudiant
						carte.setHeuresRestantes(m.getJ1().getHeures());
						Prise.setHeures(heure);
						Prise.setHeuresN(m.getJ1().getHeures());
						carte.setPrise(false);
				
				}	
				
				if(m.getJ1().getHeures() == 0)
				{
					// Préparation de la carte
					while(carte.getFini() == false)
					{
						
					}
					Plan.setFini(false);
					carte.setHeuresRestantes(m.getJ2().getHeures());
				}
				else
				{
					Plan.setFini(false);
					carte.setHeuresRestantes(m.getJ2().getHeures());
				}
					
			
					// Début du tour du Joueur 2
					while(m.getJ2().getHeures() != 0)
					{
							while(carte.getPrise() == false)
							{
								
							}
							heure = Prise.waitForIt();
							System.out.println(heure);
							//m.PriseUv(heure,carte.getIndice(),2);
							m.AjusteHeures(heure, 2);
							carte.setHeuresRestantes(m.getJ2().getHeures());
							Prise.setHeures(heure);
							Prise.setHeuresN(m.getJ2().getHeures());
							carte.setPrise(false);
					}	
					
					while(carte.getFini() == false)
					{
						
					}
					Plan.setFini(false);
					
					
					m.Score();
					//carte.setScore("Score :        				            "+ m.getJ1().getNomJoueur()+ " :  "+ m.getScoreJ1() + "                     "+ m.getJ2().getNomJoueur()+ " : "+ m.getScoreJ2());
					//carte.run(m.getTour()/2);
					// Incrémentation du nombre de tours
		}
			V.getF().setVisible(true);
			V.setGagnant(m.testVictoire());
	}


}
