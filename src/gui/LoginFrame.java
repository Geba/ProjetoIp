package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tf_login;
	private JPasswordField pwdSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_login = new JTextField();
		tf_login.setBounds(224, 135, 187, 28);
		contentPane.add(tf_login);
		tf_login.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(179, 141, 61, 16);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(179, 175, 61, 16);
		contentPane.add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setText("senha123");
		pwdSenha.setBounds(224, 169, 187, 28);
		contentPane.add(pwdSenha);
		
		JLabel lblObsParaPrimeiro = new JLabel("Obs.: Para primeiro acesso, use Login: primeiroacesso e Senha: senha123");
		lblObsParaPrimeiro.setBounds(73, 394, 461, 16);
		contentPane.add(lblObsParaPrimeiro);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnEntrar.setBounds(250, 216, 117, 29);
		contentPane.add(btnEntrar);
	}
}
