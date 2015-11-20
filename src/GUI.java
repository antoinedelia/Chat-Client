import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI extends JFrame implements ActionListener, KeyListener{
	private JLabel labelLogin;
	private JTextField textFieldLogin;
	private JButton buttonLogin;

	private JTextArea textArea;

	private JLabel labelMessage;
	private JTextField textFieldMessage;
	private JButton buttonMessage;

	private String login, message = "";

	/** Construction de la fenêtre d'affichage principale */
	public GUI() {
		initialize();
	}

	private void initialize() {
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		labelLogin = new JLabel("Login");
		labelLogin.setBounds(31, 31, 55, 31);
		labelLogin.setVerticalAlignment(SwingConstants.TOP);
		getContentPane().add(labelLogin);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(96, 18, 464, 40);
		getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);

		textFieldLogin.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				login = textFieldLogin.getText();
				textFieldLogin.setEnabled(false);
				buttonLogin.setEnabled(false);
				textFieldMessage.setEnabled(true);
				buttonMessage.setEnabled(true);
			}
		});

		buttonLogin = new JButton("Valider");
		buttonLogin.setBounds(570, 11, 86, 55);
		getContentPane().add(buttonLogin);

		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login = textFieldLogin.getText();
				textFieldLogin.setEnabled(false);
				buttonLogin.setEnabled(false);
				textFieldMessage.setEnabled(true);
				buttonMessage.setEnabled(true);
			}
		});

		textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setBounds(98, 66, 462, 417);
		textArea.setEnabled(false);
		getContentPane().add(textArea);

		labelMessage = new JLabel("Votre message : ");
		labelMessage.setBounds(0, 500, 96, 40);
		getContentPane().add(labelMessage);

		textFieldMessage = new JTextField();
		textFieldMessage.setBounds(99, 494, 461, 53);
		getContentPane().add(textFieldMessage);
		textFieldMessage.setColumns(10);
		textFieldMessage.setEnabled(false);

		textFieldMessage.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				message = textFieldMessage.getText();
				textFieldMessage.setText("");
			}
		});

		buttonMessage = new JButton("Envoyer");
		buttonMessage.setBounds(570, 494, 104, 55);
		getContentPane().add(buttonMessage);
		buttonMessage.setEnabled(false);

		buttonMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				message = textFieldMessage.getText();
				textFieldMessage.setText("");

			}
		});

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public String getLogin()
	{
		return this.login;
	}

	public String getMessage()
	{
		return this.message;
	}

	public void setMessages(String s)
	{
		textArea.append(s);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
