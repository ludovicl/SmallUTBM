package Interface;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre window = new Fenetre();
					System.out.println("test");
					Catalogue frame = new Catalogue();
					frame.setVisible(true);
					System.out.println("test");
					JLabel L=new JLabel("TEST");
					
					L.setBounds(10, 10, 100, 30);
					window.frame.add(frame);
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
	public Fenetre() {
		initialize();
		 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public JFrame getF(){
		
		return frame;
	}

}
