package gui;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;


import excecoes.ElementoNaoEncontradoException;

import excecoes.RepositorioException;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

import classesBase.Endereco;
import classesBase.Funcionario;

//import classesBase.Administrador;

@SuppressWarnings("serial")
public class AtualizarFuncionarioFrame extends JFrame {

	
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textRg;
	private JTextField textDataNasc;
	private JTextField textRua;
	private JTextField textNumero;
	private JTextField textCep;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textPais;
	private JTextField textTelefone;
	private JTextArea textFuncao;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String sexo;
	private static Funcionario funcionario;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarFuncionarioFrame frame = new AtualizarFuncionarioFrame(funcionario);
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
	public AtualizarFuncionarioFrame(Funcionario funcionario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarAluno = new JLabel("Cadastrar Funcionario");
		lblCadastrarAluno.setBounds(21, 18, 170, 16);
		contentPane.add(lblCadastrarAluno);

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

		textRg = new JTextField();
		textRg.setBounds(45, 121, 125, 28);
		contentPane.add(textRg);
		textRg.setColumns(10);

		textDataNasc = new JTextField();
		textDataNasc.setBounds(245, 87, 125, 28);
		contentPane.add(textDataNasc);
		textDataNasc.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel(
				"Data de Nascimento (dd/mm/aaaa)");
		lblDataDeNascimento.setBounds(21, 93, 228, 16);
		contentPane.add(lblDataDeNascimento);

		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexo = "Feminino";
			}
		});
		buttonGroup.add(rdbtnFeminino);
		rdbtnFeminino.setBounds(432, 102, 141, 23);
		contentPane.add(rdbtnFeminino);

		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexo = "Masculino";
			}
		});
		buttonGroup.add(rdbtnMasculino);
		rdbtnMasculino.setBounds(432, 126, 141, 23);
		contentPane.add(rdbtnMasculino);


		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(432, 87, 61, 16);
		contentPane.add(lblSexo);

		JLabel lblEndereo = new JLabel("Endereco:");
		lblEndereo.setBounds(21, 161, 61, 16);
		contentPane.add(lblEndereo);

		JLabel lblN = new JLabel("No :");
		lblN.setBounds(432, 161, 61, 16);
		contentPane.add(lblN);

		textRua = new JTextField();
		textRua.setBounds(90, 155, 320, 28);
		contentPane.add(textRua);
		textRua.setColumns(10);

		textNumero = new JTextField();
		textNumero.setBounds(460, 155, 113, 28);
		contentPane.add(textNumero);
		textNumero.setColumns(10);

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

		JLabel lblPas = new JLabel("Pais:");
		lblPas.setBounds(417, 229, 61, 16);
		contentPane.add(lblPas);

		textPais = new JTextField();
		textPais.setBounds(452, 223, 121, 28);
		contentPane.add(textPais);
		textPais.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		btnCadastrar.setBounds(461, 365, 112, 42);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voltar();
			}
		});
		btnVoltar.setBounds(334, 365, 117, 42);
		contentPane.add(btnVoltar);

		JLabel lblFuno = new JLabel("Funcao:");
		lblFuno.setBounds(21, 263, 250, 16);
		contentPane.add(lblFuno);

		textFuncao = new JTextArea();
		textFuncao.setBounds(21, 285, 250, 96);
		contentPane.add(textFuncao);

		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(299, 269, 80, 16);
		contentPane.add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(366, 263, 134, 28);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);

		//this.fachada = PaginaPrincipal.fachada;

		this.textBairro.setText(funcionario.getEndereco().getBairro());
		this.textCep.setText(funcionario.getEndereco().getCep());
		this.textCidade.setText(funcionario.getEndereco().getCidade());
		this.textRua.setText(funcionario.getEndereco().getRua());
		this.textBairro.setText(funcionario.getEndereco().getBairro());
		this.textCep.setText(funcionario.getEndereco().getCep());
		this.textCidade.setText(funcionario.getEndereco().getCidade());
		this.textEstado.setText(funcionario.getEndereco().getEstado());
		this.textNumero.setText(funcionario.getEndereco().getNumero());
		this.textNome.setText(funcionario.getNome());
		this.textRg.setText(funcionario.getIdentidade());
		this.textDataNasc.setText(funcionario.getDataNasc());
		this.textPais.setText(funcionario.getEndereco().getPais());
		this.textCpf.setText(funcionario.getCpf());
		this.textDataNasc.setText(funcionario.getDataNasc());
		textFuncao.setText(funcionario.getFuncao());
		this.textTelefone.setText(funcionario.getTelefone());
		if(funcionario.getSexo().equals("M")){
			rdbtnMasculino.setSelected(true);
		}else{
			rdbtnFeminino.setSelected(true);
		}
		cpfOriginal = funcionario.getCpf();
	}

	private void atualizar(){
		System.out.println(sexo);
		try{
			String nome = textNome.getText();
			String cpf = textCpf.getText();
			String dataNasc = textDataNasc.getText();
			String rg = textRg.getText();
			String telefone = textTelefone.getText();
			String rua = textRua.getText();
			String numero = textNumero.getText();
			String cep = textCep.getText();
			String bairro = textBairro.getText();
			String cidade = textCidade.getText();
			String estado = textEstado.getText();
			String pais = textPais.getText();
			String funcao = textFuncao.getText();

			//String numero = textNumero.getText();
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			Funcionario funcionarioAux = new Funcionario(cpf, nome, dataNasc, rg, pais, telefone, endereco, funcao);
			PaginaPrincipal.fachada.atualizarPessoa(cpfOriginal, funcionarioAux);
			JOptionPane.showMessageDialog(this,"Funcionario atualizado com sucesso.");
		} catch (RepositorioException e) {
			JOptionPane.showMessageDialog(this,"Erro no repositorio.");
		} catch (ElementoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private void voltar() {
		MenuPrincipal frame1 = new MenuPrincipal();
		frame1.setVisible(true);
		this.setVisible(false);
	}
}
