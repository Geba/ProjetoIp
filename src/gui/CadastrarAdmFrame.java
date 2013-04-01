package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class CadastrarAdmFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAdmFrame frame = new CadastrarAdmFrame();
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
	public CadastrarAdmFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar Administrador");
		lblCadastrarAluno.setBounds(21, 18, 170, 16);
		contentPane.add(lblCadastrarAluno);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setBounds(21, 59, 112, 16);
		contentPane.add(lblNomeCompleto);
		
		textField = new JTextField();
		textField.setBounds(138, 53, 435, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(182, 127, 61, 16);
		contentPane.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setBounds(214, 121, 141, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(21, 127, 61, 16);
		contentPane.add(lblRg);
		
		textField_2 = new JTextField();
		textField_2.setBounds(45, 121, 125, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(245, 87, 125, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento (dd/mm/aaaa)");
		lblDataDeNascimento.setBounds(21, 93, 228, 16);
		contentPane.add(lblDataDeNascimento);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(432, 102, 141, 23);
		contentPane.add(rdbtnFeminino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(432, 126, 141, 23);
		contentPane.add(rdbtnMasculino);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(432, 87, 61, 16);
		contentPane.add(lblSexo);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(21, 161, 61, 16);
		contentPane.add(lblEndereo);
		
		JLabel lblN = new JLabel("N\u00BA :");
		lblN.setBounds(432, 161, 61, 16);
		contentPane.add(lblN);
		
		textField_6 = new JTextField();
		textField_6.setBounds(90, 155, 320, 28);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(460, 155, 113, 28);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(21, 195, 61, 16);
		contentPane.add(lblCep);
		
		textField_8 = new JTextField();
		textField_8.setBounds(57, 189, 134, 28);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(203, 195, 61, 16);
		contentPane.add(lblBairro);
		
		textField_9 = new JTextField();
		textField_9.setBounds(245, 189, 134, 28);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(21, 229, 61, 16);
		contentPane.add(lblCidade);
		
		textField_10 = new JTextField();
		textField_10.setBounds(77, 223, 134, 28);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(228, 229, 61, 16);
		contentPane.add(lblEstado);
		
		textField_11 = new JTextField();
		textField_11.setBounds(277, 223, 125, 28);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(417, 229, 61, 16);
		contentPane.add(lblPas);
		
		textField_12 = new JTextField();
		textField_12.setBounds(452, 223, 121, 28);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(461, 365, 112, 42);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(334, 365, 117, 42);
		contentPane.add(btnVoltar);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setBounds(21, 263, 250, 16);
		contentPane.add(lblFuno);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 285, 250, 96);
		contentPane.add(textArea);
		
		JLabel lblInsiraUmLogin = new JLabel("Insira um login:");
		lblInsiraUmLogin.setBounds(287, 277, 105, 16);
		contentPane.add(lblInsiraUmLogin);
		
		textField_4 = new JTextField();
		textField_4.setBounds(389, 271, 142, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDigiteUmaSenha = new JLabel("Digite uma senha:");
		lblDigiteUmaSenha.setBounds(287, 305, 134, 16);
		contentPane.add(lblDigiteUmaSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(409, 299, 134, 28);
		contentPane.add(passwordField);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme sua senha:");
		lblConfirmeASenha.setBounds(287, 333, 134, 16);
		contentPane.add(lblConfirmeASenha);
		
		textField_5 = new JTextField();
		textField_5.setBounds(419, 327, 134, 28);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}

