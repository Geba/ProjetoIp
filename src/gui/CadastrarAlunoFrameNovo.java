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

public class CadastrarAlunoFrameNovo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAlunoFrameNovo frame = new CadastrarAlunoFrameNovo();
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
	public CadastrarAlunoFrameNovo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar Aluno");
		lblCadastrarAluno.setBounds(21, 18, 144, 16);
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
		
		JLabel lblNomeDoPai = new JLabel("Nome do Pai:");
		lblNomeDoPai.setBounds(21, 167, 94, 16);
		contentPane.add(lblNomeDoPai);
		
		textField_4 = new JTextField();
		textField_4.setBounds(112, 161, 461, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e:");
		lblNomeDaMe.setBounds(21, 200, 94, 16);
		contentPane.add(lblNomeDaMe);
		
		textField_5 = new JTextField();
		textField_5.setBounds(122, 194, 451, 28);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(21, 234, 61, 16);
		contentPane.add(lblEndereo);
		
		JLabel lblN = new JLabel("N\u00BA :");
		lblN.setBounds(432, 234, 61, 16);
		contentPane.add(lblN);
		
		textField_6 = new JTextField();
		textField_6.setBounds(90, 228, 320, 28);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(460, 228, 113, 28);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(21, 268, 61, 16);
		contentPane.add(lblCep);
		
		textField_8 = new JTextField();
		textField_8.setBounds(57, 262, 134, 28);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(203, 268, 61, 16);
		contentPane.add(lblBairro);
		
		textField_9 = new JTextField();
		textField_9.setBounds(245, 262, 134, 28);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(21, 302, 61, 16);
		contentPane.add(lblCidade);
		
		textField_10 = new JTextField();
		textField_10.setBounds(77, 296, 134, 28);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(228, 302, 61, 16);
		contentPane.add(lblEstado);
		
		textField_11 = new JTextField();
		textField_11.setBounds(277, 296, 125, 28);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(417, 302, 61, 16);
		contentPane.add(lblPas);
		
		textField_12 = new JTextField();
		textField_12.setBounds(452, 296, 121, 28);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setBounds(21, 341, 61, 16);
		contentPane.add(lblTurma);
		
		JRadioButton rdbtnAno = new JRadioButton("1\u00BA  ano");
		rdbtnAno.setBounds(77, 337, 141, 23);
		contentPane.add(rdbtnAno);
		
		JRadioButton rdbtnAno_1 = new JRadioButton("2\u00BA  ano");
		rdbtnAno_1.setBounds(77, 358, 141, 23);
		contentPane.add(rdbtnAno_1);
		
		JRadioButton rdbtnAno_2 = new JRadioButton("3\u00BA  ano");
		rdbtnAno_2.setBounds(77, 379, 141, 23);
		contentPane.add(rdbtnAno_2);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(461, 365, 112, 42);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(334, 365, 117, 42);
		contentPane.add(btnVoltar);
	}
}

