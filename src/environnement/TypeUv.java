package environnement;


import jeu.Etudiant;
import interaction.Joueur;
public class TypeUv 
{
	private Joueur Possesseur;
	private Etudiant possesseur;
	private int heuresJ1, heuresJ2;
	protected String nomUv;
	private int number;
	protected int prix;
	
	
	public TypeUv (String pName,int pNumber){
		number = pNumber;
		nomUv=pName;
	}
	
	public int getPrix() {
		return prix;
	}
	
	public int getNumber() {
		return number;
	}
	
	
	public void setNumber (int number) {
		this.number = number;
	}
	
	
	public String getNomUv()
	{
		return nomUv;
	}
	
	public void setAppartenance(Etudiant etu)
	{
		possesseur=etu;
	}
	
	public Etudiant gettAppartenance()
	{
		return possesseur;
	}
	
	
	
	public void addHeuresJ1(int para)
	{
		heuresJ1+=para;
	}
	
	public void addHeuresJ2(int para)
	{
		heuresJ2+=para;
	}
	
	public int getHeuresJ1()
	{
		return heuresJ1;
	}
	
	public int getHeuresJ2()
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
	
	
	
	
}
