package jeu;

public enum Student {
	
	TC,
	Master,
	License,
	Etranger,
	Prepa,
	DUT;
	
	
	private String description = "";
	
	public String setDescription ()
	{
		return this.description;
	}
	public void setDescrpition(String des)
	{
		this.description=des;	
	}
	
	private int nombreHeuresDeTravail=10;
	
	public int getNombreHeursDeTravail()
	{
		return nombreHeuresDeTravail;
	}
	
	public void setNombreHeursDeTravai(int h)
	{
		nombreHeuresDeTravail=h;
	}
	

}
