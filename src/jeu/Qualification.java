package jeu;

public enum Qualification {
	Pistone,
	Geek,
	PossedantUneVoiture,
	AlcooliqueBDF,
	SemestreSup,
	Ae,
	Philateliste,
	Bds;
	
	private String description = "";
	
	public String setDescription ()
	{
		return this.description;
	}
	public void setDescrpition(String des)
	{
		this.description=des;	
	}
	
}
