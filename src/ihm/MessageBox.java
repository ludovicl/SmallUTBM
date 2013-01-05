package ihm;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MessageBox {

	private JFrame frame;
	private JLabel nomUV = new JLabel("Null");
	private JLabel lblHeuresNecessaires;
	private int HeuresNecessaires;
	private JLabel label;
	private JLabel lblEtudier;
	private JLabel Type;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageBox window = new MessageBox();
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
	public MessageBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 250);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		nomUV.setFont(new Font("DejaVu Sans", Font.PLAIN, 25));
		nomUV.setBounds(179, 0, 85, 28);
		frame.getContentPane().add(nomUV);
		
		lblHeuresNecessaires = new JLabel("Heures n\u00E9cessaires :");
		lblHeuresNecessaires.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		lblHeuresNecessaires.setBounds(10, 53, 170, 28);
		frame.getContentPane().add(lblHeuresNecessaires);
		
		label = new JLabel("    .");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(197, 52, 67, 28);
		frame.getContentPane().add(label);
		
		JButton btnValider = new JButton("Valider");
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
		
		JSpinner spinner = new JSpinner();
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
}
