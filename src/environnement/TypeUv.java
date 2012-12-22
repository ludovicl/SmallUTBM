package environnement;


import jeu.Etudiant;
public class TypeUv 
{
		
	private int coordonneesX,coordonneesY;
	
	private Etudiant appartenance;
	private int heuresJ1, heuresJ2;
	protected String nomUv;
	
	public TypeUv(String nom)
	{
		nomUv=nom;
	}
	
	public String getNomUv()
	{
		return nomUv;
	}
	
	public void setAppartenance(Etudiant etu)
	{
		appartenance=etu;
	}
	
	public Etudiant gettAppartenance()
	{
		return appartenance;
	}
	
	public void addHeuresJ1(int para)
	{
		heuresJ1+=para;
	}
	
	public void addHeuresJ2(int para)
	{
		heuresJ2+=para;
	}
	
	public int gettHeuresJ1()
	{
		return heuresJ1;
	}
	
	public int gettHeuresJ2()
	{
		return heuresJ2;
	}
	
	public void setHeuresJ1(int n)
	{
		heuresJ1=n;
	}
	
	public void setHeuresJ2(int n)
	{
		heuresJ2=n;
	}
	public void setCoordonnees(int x, int y)
	{		
		this.coordonneesX=x;
		this.coordonneesY=y;	
	}
	
	
	public int getCoordonneesX()
	{
		return this.coordonneesX;
	}
	
	public int getCoordonneesY()
	{
		return this.coordonneesY;
	}
	
	
	
}
