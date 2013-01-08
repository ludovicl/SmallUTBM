package ihm;

import environnement.*;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;


import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MessageBox {

	private JFrame frame;
	private JLabel nomUV = new JLabel("Null");
	private JLabel lblHeuresNecessaires;
	private int heuresN = 1;
	private int heuresJ= 7;
	private JLabel label;
	private JLabel lblEtudier;
	private JLabel Type;
	private JLabel lblNewLabel;
	private JSpinner spinner;
	JButton btnValider = new JButton("Valider");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageBox window = new MessageBox();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the application.
	 */
	public MessageBox() {
		initialize();
		this.setHeures(heuresN);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 250);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		nomUV.setFont(new Font("DejaVu Sans", Font.PLAIN, 25));
		nomUV.setBounds(179, 0, 85, 28);
		frame.getContentPane().add(nomUV);
		
		lblHeuresNecessaires = new JLabel("Heures necessaires :");
		lblHeuresNecessaires.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		lblHeuresNecessaires.setBounds(10, 53, 170, 28);
		frame.getContentPane().add(lblHeuresNecessaires);
		
		label = new JLabel("    .");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(197, 52, 67, 28);
		frame.getContentPane().add(label);
		
		// Boutons d'interaction avec la fenêtre MessageBox
		
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				/* System.out.println(spinner.getValue());*/
				 frame.setVisible(false);
				 frame.dispose();
				 
			}
		});
		btnValider.setBounds(122, 178, 89, 23);
		frame.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				frame.dispose();
			}
		});
		btnAnnuler.setBounds(236, 178, 89, 23);
		frame.getContentPane().add(btnAnnuler);
		
		// Création d'un JSpinner limité entre 0 et le maximum d'heures disponible
		SpinnerNumberModel sm = new SpinnerNumberModel(0, 0, heuresJ, 1);
		spinner = new JSpinner(sm);
		spinner.setBounds(102, 92, 46, 23);
		frame.getContentPane().add(spinner);
		
		
		lblEtudier = new JLabel("Etudier");
		lblEtudier.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		lblEtudier.setBounds(10, 86, 153, 28);
		frame.getContentPane().add(lblEtudier);
		
		Type = new JLabel("Type :");
		Type.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		Type.setBounds(309, 27, 85, 23);
		frame.getContentPane().add(Type);
		
		lblNewLabel = new JLabel( new ImageIcon("Images//LO43.jpg"));
		lblNewLabel.setBounds(291, 49, 133, 108);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNuitBlanche = new JButton("Nuit Blanche");
		btnNuitBlanche.setBounds(10, 127, 117, 29);
		frame.getContentPane().add(btnNuitBlanche);
	}
	
	public JFrame getF(){
		
		return frame;
	}
	
	public void setNomUV(String a){
		nomUV.setText(a);
	}
	
	public int getSpinner() {
		return (int) spinner.getValue();
	}
	
	public int getHeuresN() {
		return heuresN;
	}
	
	public void setHeuresN(int i) {
		heuresN = i;
	}
	
	public int getHeuresJ() {
		return heuresJ;
	}
	
	public void setHeuresJ(int i) {
		heuresJ = i;
	}
	public void setHeures(int heuresN) {
		switch(heuresN)
		{
		case 1 : 
			label.setText("1");
			break;
		case 2 : 
			label.setText("2");
			break;
		case 3 : 
			label.setText("3");
			break;
		case 4 : 
			label.setText("4");
			break;
		case 5 : 
			label.setText("5");
			break;	
		}
	}
	
	public void disableVal() {
		btnValider.enable(false);	
	}
	public int waitForIt() {
		while(this.getF().isVisible() == true )
		{
			
		}
		return this.getSpinner();
	}
}
