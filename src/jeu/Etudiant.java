package jeu;

public class Etudiant {
	
	
	protected int nombreDeHeures;
	
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
}
