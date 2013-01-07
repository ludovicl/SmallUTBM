package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;


public class Catalogue extends JInternalFrame implements ActionListener, ItemListener {

	private JFrame frame;
	JButton LBT[]= new JButton[2];
	JCheckBox LCB[] = new JCheckBox[6];
	String tabStudent[] = {"TC", "Master", "Licence", "Etranger", "Prepa", "DUT"};
	String tabCarac[] = {"Pistoné", "Geek", "B.D.Teufeur", "Semestres sup'","A.E.","B.D.S.", "Philateliste","Covoitureur","Club Welcome"};
	
	String SavTabStudent[] = tabStudent;
	String SavtabCarac[] = tabCarac;
	String SaveValS[] = {"","","","","","",""};
	String SaveValC[] = {"","","","","","",""};
	String SaveValP[] = {"1","2","3","4","5","6"};
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Catalogue window = new Catalogue();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Catalogue() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.getContentPane().setLayout(null);
		
		//les numeros
				JPanel Numeros = new JPanel();
				Numeros.setBounds(0, 11, 41, 260);
				frame.getContentPane().add(Numeros);
				Numeros.setLayout(null);
				
				int x=10,y=10,larg=57,haut=26;
				int j=0;
				JLabel Lnum[] = new JLabel[6];
				
				for(j=1;j<=6;j++){
					Lnum[j-1]=new JLabel(""+j);
					Lnum[j-1].setBounds(x, y+(40*(j-1)), 12, 20);
					Numeros.add(Lnum[j-1]);
				}
				//les étudiants
				JPanel Etudiants = new JPanel();
				Etudiants.setBounds(41, 11, 121, 260);
				frame.getContentPane().add(Etudiants);
				Etudiants.setLayout(null);
				
				
				int valeur=0;
				JLabel L[]=new JLabel[6];
						
				j=0;
				int i=6;
				while(i>0) {
					
					valeur=generateVal(i);
					L[j]=new JLabel(tabStudent[valeur-1]);
					L[j].setBounds(x, y+(40*j), larg, haut);
					SaveValS[j]= L[j].getText();
					Etudiants.add(L[j]);
					tabStudent = suppStu (valeur-1,tabStudent);
					j++;
					i--;
			
				}
				
			//les carracteristiques
				JPanel Qualifications = new JPanel();
				Qualifications.setBounds(161, 11, 200, 260);
				frame.getContentPane().add(Qualifications);
				Qualifications.setLayout(null);
						
				JLabel LCarac[]=new JLabel[7];
				
				j=0;
				i=7;
				x=10; y=11; larg=250; haut=26;
				int valeurC =0 ;
				while(i>0) {
					valeurC=generateVal(i);
					LCarac[j]=new JLabel(tabCarac[valeurC-1]);
					LCarac[j].setBounds(x, y+(40*j), larg, haut);
					Qualifications.add(LCarac[j]);
					SaveValC[j]=LCarac[j].getText();
					tabCarac = suppStu (valeurC-1,tabCarac);
					j++;
					i--;
			
				}
			//prix
				
				JPanel Prix = new JPanel();
				Prix.setBounds(400, 11, 35, 260);
				frame.getContentPane().add(Prix);
				Prix.setLayout(null);
				
				x=10; y=10; larg=57; haut=26;
				j=6;
				JLabel Lprix[] = new JLabel[6];
				for(j=1;j<=6;j++){
					Lprix[j-1]=new JLabel(""+j);
					Lprix[j-1].setBounds(x, y+(40*(j-1)), 12, 20);
					Prix.add(Lprix[j-1]);
				}
				
				/* Pour créer les CheckBox */
				
				JPanel Choix = new JPanel();
				Choix.setLayout(null);
				Choix.setBounds(434, 11, 41, 260);
				frame.getContentPane().add(Choix);
				
				
				x=10; y=10; larg=57; haut=26;
				j=6;
				
				
				for(j=1;j<=6;j++){
					LCB[j-1]=new JCheckBox(""+j);
					LCB[j-1].setBounds(x, y+(40*(j-1)), 21, 23);
					Choix.add(LCB[j-1]);
				}
			
				LCB[1].setEnabled(false);
				LCB[2].setEnabled(false);
				LCB[3].setEnabled(false);
				LCB[4].setEnabled(false);
				LCB[5].setEnabled(false);
				
				
				LCB[0].addItemListener(this);
				LCB[1].addItemListener(this);
				LCB[2].addItemListener(this);
				LCB[3].addItemListener(this);
				LCB[4].addItemListener(this);
				LCB[5].addItemListener(this);
			
				
			//Les Buttons
				
				JPanel Buttons = new JPanel();
				Buttons.setBounds(316, 306, 245, 40);
				frame.getContentPane().add(Buttons);
				Buttons.setLayout(null);
				
				
				for(j=1;j<=2;j++){
					LBT[j-1]=new JButton(""+j);
					LBT[j-1].setBounds(x+(100*(j-1)), y, 89, 23);
					Buttons.add(LBT[j-1]);
				}
				LBT[0].setText("Valider");
				LBT[1].setText("Annuler");
				LBT[0].addActionListener(this);
				LBT[1].addActionListener(this);
	}
	@Override
	public void itemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		JCheckBox Jbox = new JCheckBox();
		Jbox = (JCheckBox ) evt.getSource();
		if ( Jbox.isSelected() == true && Jbox == LCB[0]) {
		
		LCB[1].setEnabled(true);
		System.out.println(SaveValS[0] + " " + SaveValC[0]);
	}
	else if(Jbox==LCB[0]) {
		for(int i=1;i<6;++i) {
			System.out.println("jouj li khedama");
			LCB[i].setEnabled(false);
			LCB[i].setSelected(false);
		}
	}
		else if ( Jbox.isSelected() == true && Jbox == LCB[1]) {
			
				LCB[2].setEnabled(true);
				System.out.println(SaveValS[1] + " " + SaveValC[1]);
								
		}
		else if(Jbox==LCB[1]){
			for(int i=2;i<6;++i){
				LCB[i].setEnabled(false);
				LCB[i].setSelected(false);
			}
		}
			else if ( Jbox.isSelected() == true && Jbox == LCB[2]) {
				
				LCB[3].setEnabled(true);
				System.out.println(SaveValS[2] + " " + SaveValC[2]);
				
			}
				else if(Jbox==LCB[2]){
					for(int i=3;i<6;++i){
						LCB[i].setEnabled(false);
						LCB[i].setSelected(false);
					}
			}
				else if ( Jbox.isSelected() == true && Jbox == LCB[3]) {
					
					LCB[4].setEnabled(true);
					System.out.println(SaveValS[3] + " " + SaveValC[3]);
					
				}
					else if(Jbox==LCB[3]){
						for(int i=4;i<6;++i){
							LCB[i].setEnabled(false);
							LCB[i].setSelected(false);
						}
					}
						else if ( Jbox.isSelected() == true && Jbox == LCB[4]) {
							
							LCB[5].setEnabled(true);
							System.out.println(SaveValS[4] + " " + SaveValC[4]);
							
														
					}
							else if(Jbox==LCB[4]){
								
									LCB[5].setEnabled(false);
									LCB[5].setSelected(false);
							
							}
								else if ( Jbox.isSelected() == true && Jbox == LCB[5]) {
								
									System.out.println(SaveValS[5] + " " + SaveValC[5]);
							
						}
								else if(Jbox==LCB[5]){
									
									System.out.println(SaveValS[5] + " 2 " + SaveValC[5]);
							
							}
	}
	/*Actions performed by the Buttons*/
	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton BT = new JButton();
		BT = (JButton ) e.getSource();
		if(BT==LBT[0]){
			System.out.println("Valider");
		}
		if ( BT == LBT[1]){
			System.out.println("Annuler");
		}
	}
	
/* Pour génerer les valeur */
	
	public int generateVal(int cpt)
	 
	{
		
		Random random = new Random();
		int valeur = 1 + random.nextInt(cpt);
		return valeur;
	} 
	
	/* fonction pour supprimer les valeur en double */
	
	public String[] suppStu (int valeur,String tabStudent[]){
		int i,j=0;
		String tab[]={"","","","","","","","",""};
		
		for(i=0;i < tabStudent.length;++i){
			if (tabStudent[i]!=tabStudent[valeur]){
				tab[j++]=tabStudent[i];
			}
			
		}
		return tab;
	}
	
	 public JFrame getF(){
			
			return frame;
	}


}
