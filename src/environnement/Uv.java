package environnement;

import java.awt.geom.Point2D;

public enum Uv 
{

	TM(),
	CS,
	Stage;
	
	private int coordonneesX,coordonneesY;
	
	
	
	
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
