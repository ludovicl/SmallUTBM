import ihm.*;

import scheduler.*;


public class Main {

	public static void main (String[] args)
	{

		Motor m= new Motor();
		

		InitFrame window = new InitFrame(Motor.tabUv);

		while(window.getF().isVisible())
		{

		}
		window.visible();

		m.incrementerNbTour();
		m.affecteNomJ1(window.getTextField(1));
		m.affecteNomJ2(window.getTextField(2));
		
		Plan carte = new Plan(m.tabUv);
		carte.getF().setVisible(true); 
		carte.setNomJoueur(m.getJ1().getNomJoueur());
		carte.setPhoto(1);
	
		
		/*System.out.println(m.getJ1().getNomJoueur());
		System.out.println(m.getJ2().getNomJoueur());*/
		
	}


}
