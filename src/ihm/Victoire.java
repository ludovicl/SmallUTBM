package ihm;

import interaction.Joueur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import scheduler.*;

public class Victoire {

	private JFrame frame;
	private JLabel gagnant = new JLabel("Joueur 1 / 2");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Victoire window = new Victoire();
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
	public Victoire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		JLabel lblFinDePartie = new JLabel("Fin de Partie");
		lblFinDePartie.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblFinDePartie.setBounds(139, 22, 195, 38);
		frame.getContentPane().add(lblFinDePartie);
		
		JLabel lblGagnant = new JLabel("Gagnant :");
		lblGagnant.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblGagnant.setBounds(40, 134, 141, 31);
		frame.getContentPane().add(lblGagnant);
		
		
		gagnant.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		gagnant.setBounds(253, 131, 162, 36);
		frame.getContentPane().add(gagnant);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(57, 225, 117, 29);
		frame.getContentPane().add(btnQuitter);
		
		JButton btnNouvellePartie = new JButton("Nouvelle Partie");
		btnNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Motor NouvellePartie = new Motor();
			}
		});
		btnNouvellePartie.setBounds(217, 225, 141, 29);
		frame.getContentPane().add(btnNouvellePartie);
	}
	
	public JFrame getF(){
		
		return frame;
	}
	
	public void setGagnant(Joueur j){
		gagnant.setText(j.getNomJoueur());
	}
}
