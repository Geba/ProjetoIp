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

import com.apple.dnssd.TXTRecord;

import classesBase.Professor;

public class AtualizarProfessorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textRG;
	private JTextField textDataNascimento;
	private JTextField textEndereco;
	private JTextField textNcasa;
	private JTextField textCep;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textPais;
	private static Professor professor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarProfessorFrame frame = new AtualizarProfessorFrame(
							professor);
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
	public AtualizarProfessorFrame(Professor professor) {//todos os campos serão atualizados com os dados do professor
		this.professor = professor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAtualizarProfessor = new JLabel("Atualizar Professor");
		lblAtualizarProfessor.setBounds(21, 18, 144, 16);
		contentPane.add(lblAtualizarProfessor);

		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setBounds(21, 59, 112, 16);
		contentPane.add(lblNomeCompleto);

		textNome = new JTextField();
		textNome.setBounds(138, 53, 435, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(182, 127, 61, 16);
		contentPane.add(lblCpf);

		textCpf = new JTextField();
		textCpf.setBounds(214, 121, 141, 28);
		contentPane.add(textCpf);
		textCpf.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(21, 127, 61, 16);
		contentPane.add(lblRg);

		textRG = new JTextField();
		textRG.setBounds(45, 121, 125, 28);
		contentPane.add(textRG);
		textRG.setColumns(10);

		textDataNascimento = new JTextField();
		textDataNascimento.setBounds(245, 87, 125, 28);
		contentPane.add(textDataNascimento);
		textDataNascimento.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel(
				"Data de Nascimento (dd/mm/aaaa)");
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

		textEndereco = new JTextField();
		textEndereco.setBounds(90, 155, 320, 28);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);

		textNcasa = new JTextField();
		textNcasa.setBounds(460, 155, 113, 28);
		contentPane.add(textNcasa);
		textNcasa.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(21, 195, 61, 16);
		contentPane.add(lblCep);

		textCep = new JTextField();
		textCep.setBounds(57, 189, 134, 28);
		contentPane.add(textCep);
		textCep.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(203, 195, 61, 16);
		contentPane.add(lblBairro);

		textBairro = new JTextField();
		textBairro.setBounds(245, 189, 134, 28);
		contentPane.add(textBairro);
		textBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(21, 229, 61, 16);
		contentPane.add(lblCidade);

		textCidade = new JTextField();
		textCidade.setBounds(77, 223, 134, 28);
		contentPane.add(textCidade);
		textCidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(228, 229, 61, 16);
		contentPane.add(lblEstado);

		textEstado = new JTextField();
		textEstado.setBounds(277, 223, 125, 28);
		contentPane.add(textEstado);
		textEstado.setColumns(10);

		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(417, 229, 61, 16);
		contentPane.add(lblPas);

		textPais = new JTextField();
		textPais.setBounds(452, 223, 121, 28);
		contentPane.add(textPais);
		textPais.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(461, 365, 112, 42);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(334, 365, 117, 42);
		contentPane.add(btnVoltar);

		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o:");
		lblFuno.setBounds(21, 263, 250, 16);
		contentPane.add(lblFuno);

		JTextArea textAreaFuncao = new JTextArea();
		textAreaFuncao.setBounds(21, 285, 250, 96);
		contentPane.add(textAreaFuncao);
		
		this.textBairro.setText(this.professor.getEndereco().getBairro());
		this.textCep.setText(this.professor.getEndereco().getCep());
		this.textCidade.setText(this.professor.getEndereco().getCidade());
		this.textEndereco.setText(this.professor.getEndereco().getRua());
		this.textBairro.setText(this.professor.getEndereco().getBairro());
		this.textCep.setText(this.professor.getEndereco().getCep());
		this.textCidade.setText(this.professor.getEndereco().getCidade());
		this.textEstado.setText(this.professor.getEndereco().getEstado());
		this.textNcasa.setText(this.professor.getEndereco().getNumero());
		this.textNome.setText(this.professor.getNome());
		this.textRG.setText(this.professor.getIdentidade());
		this.textDataNascimento.setText(this.professor.getDataNasc());
		this.textPais.setText(this.professor.getEndereco().getPais());
		this.textCpf.setText(this.professor.getCpf());
		
	}
}
