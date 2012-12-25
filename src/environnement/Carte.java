package environnement;


public class Carte {
	private String name;
	private boolean mapUV[][];
	
	public Carte (String pName, boolean[][] pMapUV){
		int i, j, ln;
		ln = pMapUV.length;
		this.setName(pName);
		this.mapUV = new boolean [ln][ln];
		
		for (i=0; i<ln; i++){
			for (j=0; j<ln; j++){
				mapUV[i][j]=pMapUV[i][j];
			}
		}
	}
	
	public boolean isVoisin (TypeUv uv1, TypeUv uv2){
		System.out.println(mapUV[uv1.getNumber()][uv2.getNumber()]);
		return (mapUV [uv1.getNumber()][uv2.getNumber()]);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
