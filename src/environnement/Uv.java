package environnement;

import java.awt.geom.Point2D;

public enum Uv 
{

	TM,
	CS,
	Stage;
	
	
	private Point2D coordonees;
	
	public Point2D getCoordonnees()
	{
		return coordonees;
	}
	
	public void setCoordonnees(double x, double y)
	{
		coordonees.setLocation(x, y);
	}
	
	
	
}
