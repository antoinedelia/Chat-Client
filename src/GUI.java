import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI extends JFrame implements ActionListener{
	private JTextField txtPseudo;
	private JTextField textField;

	/** Construction de la fenêtre d'affichage principale */
	public GUI() {
		initialize();
	}

	private void initialize() {
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(31, 31, 55, 31);
		lblLogin.setVerticalAlignment(SwingConstants.TOP);
		getContentPane().add(lblLogin);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(96, 18, 464, 40);
		getContentPane().add(txtPseudo);
		txtPseudo.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(570, 11, 86, 55);
		getContentPane().add(btnValider);
				
		JTextArea textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setBounds(98, 66, 462, 417);
		textArea.setEnabled(false);
		getContentPane().add(textArea);
		
		JLabel lblVotreMessage = new JLabel("Votre message : ");
		lblVotreMessage.setBounds(0, 500, 96, 40);
		getContentPane().add(lblVotreMessage);
		
		textField = new JTextField();
		textField.setBounds(99, 494, 461, 53);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setBounds(570, 494, 104, 55);
		getContentPane().add(btnEnvoyer);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 

}
