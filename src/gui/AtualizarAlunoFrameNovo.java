package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import dados.RepositorioArrayTurma;
import excecoes.ElementoJaCadastradoException;
import excecoes.ElementoNaoEncontradoException;
import excecoes.EntradaInvalidaException;
import excecoes.RepositorioException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;

import classesBase.Aluno;
import classesBase.Endereco;
import classesBase.Pessoa;
import classesBase.Turma;
import dados.Repositorio;

@SuppressWarnings("serial")
public class AtualizarAlunoFrameNovo extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textRG;
	private JTextField textDataNasc;
	private JTextField textPai;
	private JTextField textMae;  // FALTA RESOLVER O COMBOBOX DA TURMA!!!!
	private JTextField textRua;
	private JTextField textNumero;
	private JTextField textCEP;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textPais;
	private JTextField textTelefone;
	private String sexo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static Aluno aluno;
	private Turma turma;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarAlunoFrameNovo frame = new AtualizarAlunoFrameNovo(aluno);
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
	public AtualizarAlunoFrameNovo(Aluno aluno) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblatualizarAluno = new JLabel("atualizar Aluno");
		lblatualizarAluno.setBounds(21, 18, 144, 16);
		contentPane.add(lblatualizarAluno);
		
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
		
		textCPF = new JTextField();
		textCPF.setBounds(214, 121, 141, 28);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(21, 127, 61, 16);
		contentPane.add(lblRg);
		
		textRG = new JTextField();
		textRG.setBounds(45, 121, 125, 28);
		contentPane.add(textRG);
		textRG.setColumns(10);
		
		textDataNasc = new JTextField();
		textDataNasc.setBounds(245, 87, 125, 28);
		contentPane.add(textDataNasc);
		textDataNasc.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento (dd/mm/aaaa)");
		lblDataDeNascimento.setBounds(21, 93, 228, 16);
		contentPane.add(lblDataDeNascimento);
		
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		buttonGroup.add(rdbtnFeminino);
		rdbtnFeminino.setBounds(432, 102, 141, 23);
		contentPane.add(rdbtnFeminino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		buttonGroup.add(rdbtnMasculino);
		rdbtnMasculino.setBounds(432, 126, 141, 23);
		contentPane.add(rdbtnMasculino);
		//JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexo = "Feminino";
			}
		});

		//JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sexo = "Masculino";
			}
		});
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(432, 87, 61, 16);
		contentPane.add(lblSexo);
		
		JLabel lblNomeDoPai = new JLabel("Nome do Pai:");
		lblNomeDoPai.setBounds(21, 167, 94, 16);
		contentPane.add(lblNomeDoPai);
		
		textPai = new JTextField();
		textPai.setBounds(112, 161, 461, 28);
		contentPane.add(textPai);
		textPai.setColumns(10);
		
		JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e:");
		lblNomeDaMe.setBounds(21, 200, 94, 16);
		contentPane.add(lblNomeDaMe);
		
		textMae = new JTextField();
		textMae.setBounds(122, 194, 451, 28);
		contentPane.add(textMae);
		textMae.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(21, 234, 61, 16);
		contentPane.add(lblEndereo);
		
		JLabel lblN = new JLabel("N\u00BA :");
		lblN.setBounds(432, 234, 61, 16);
		contentPane.add(lblN);
		
		textRua = new JTextField();
		textRua.setBounds(90, 228, 320, 28);
		contentPane.add(textRua);
		textRua.setColumns(10);
		
		textNumero = new JTextField();
		textNumero.setBounds(460, 228, 113, 28);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(21, 268, 61, 16);
		contentPane.add(lblCep);
		
		textCEP = new JTextField();
		textCEP.setBounds(56, 262, 130, 28);
		contentPane.add(textCEP);
		textCEP.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(397, 268, 61, 16);
		contentPane.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(439, 262, 134, 28);
		contentPane.add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(198, 268, 61, 16);
		contentPane.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(248, 262, 134, 28);
		contentPane.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(21, 302, 61, 16);
		contentPane.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setBounds(70, 296, 125, 28);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		JLabel lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setBounds(210, 302, 61, 16);
		contentPane.add(lblPas);
		
		textPais = new JTextField();
		textPais.setBounds(245, 296, 121, 28);
		contentPane.add(textPais);
		textPais.setColumns(10);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setBounds(21, 341, 61, 16);
		contentPane.add(lblTurma);
		
		JButton btnatualizar = new JButton("Atualizar");
		btnatualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnatualizar.setBounds(461, 365, 112, 42);
		contentPane.add(btnatualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		});
		btnVoltar.setBounds(334, 365, 117, 42);
		contentPane.add(btnVoltar);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(378, 302, 61, 16);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(439, 296, 134, 28);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		JComboBox<Turma> cbxTurma = new JComboBox<Turma>();
		cbxTurma.setBounds(70, 337, 141, 27);
		contentPane.add(cbxTurma);
		
		JButton btnNewButton = new JButton("Adicionar Nova");
		btnNewButton.setBounds(70, 372, 141, 29);
		contentPane.add(btnNewButton);
		

		this.textBairro.setText(this.aluno.getEndereco().getBairro());
		this.textCEP.setText(this.aluno.getEndereco().getCep());
		this.textCidade.setText(this.aluno.getEndereco().getCidade());
		this.textRua.setText(this.aluno.getEndereco().getRua());
		this.textBairro.setText(this.aluno.getEndereco().getBairro());
		this.textCidade.setText(this.aluno.getEndereco().getCidade());
		this.textEstado.setText(this.aluno.getEndereco().getEstado());
		this.textNumero.setText(this.aluno.getEndereco().getNumero());
		this.textNome.setText(this.aluno.getNome());
		this.textRG.setText(this.aluno.getIdentidade());
		this.textDataNasc.setText(this.aluno.getDataNasc());
		this.textPais.setText(this.aluno.getEndereco().getPais());
		this.textCPF.setText(this.aluno.getCpf());
		this.textPai.setText(this.aluno.getPai());
		this.textMae.setText(this.aluno.getMae());
		this.textTelefone.setText(this.aluno.getTelefone());
		//seleciona o sexo de acordo com o j� salvo
		if(this.aluno.getSexo().equals("M")){
			rdbtnMasculino.setSelected(true);
		}else{
			rdbtnFeminino.setSelected(true);
		}
		
		//Preenche a comboBox com todos os items e deixa selecionado aqquele que est� salvo;
		cbxTurma.removeAllItems();
		Repositorio<Turma> repositorio = PaginaPrincipal.fachada.getTurmas(); 
		Iterator<Turma> it = repositorio.getIterator();
		while (it.hasNext()){
			Turma turmaAux = it.next();
			cbxTurma.addItem(turmaAux);
		}
		
		cbxTurma.setSelectedItem(this.aluno.getTurma());
		
		
		
	}
	
	private void atualizar(){
		try{
			String nome = textNome.getText();
			String cpf = textCPF.getText();
			String dataNasc = textDataNasc.getText();
			String rg = textRG.getText();
			String telefone = textTelefone.getText();
			String rua = textRua.getText();
			String numero = textNumero.getText();
			String cep = textCEP.getText();
			String bairro = textBairro.getText();
			String cidade = textCidade.getText();
			String estado = textEstado.getText();
			String pais = textPais.getText();
			String pai = textPai.getText();
			String mae = textMae.getText();
			//String numero = tf_numero.getText();
			Endereco endereco = new Endereco(rua, numero, bairro, cep, cidade, estado, pais);
			Aluno alunoAux = new Aluno(cpf, nome, dataNasc, rg, pais, telefone, endereco, pai, mae, turma);
			
			PaginaPrincipal.fachada.atualizarPessoa(alunoAux); //<<<<<<
			JOptionPane.showMessageDialog(this,"Aluno cadastrado com sucesso.");
		} catch (ElementoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositorioException e) {
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

