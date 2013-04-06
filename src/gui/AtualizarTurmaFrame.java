package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import classesBase.Turma;

import excecoes.ElementoJaCadastradoException;
import excecoes.ElementoNaoEncontradoException;
import excecoes.EntradaInvalidaException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarTurmaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private static Turma turma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarTurmaFrame frame = new AtualizarTurmaFrame(turma);
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
	public AtualizarTurmaFrame(Turma turma) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarTurma = new JLabel("Cadastrar Turma");
		lblCadastrarTurma.setBounds(31, 33, 104, 16);
		contentPane.add(lblCadastrarTurma);

		JLabel lblDigiteONome = new JLabel("Digite o nome da turma:");
		lblDigiteONome.setBounds(31, 75, 166, 16);
		contentPane.add(lblDigiteONome);

		textNome = new JTextField();
		textNome.setBounds(190, 69, 134, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		btnCadastrar.setBounds(455, 356, 117, 48);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		});
		btnVoltar.setBounds(326, 356, 117, 48);
		contentPane.add(btnVoltar);

		JLabel lblOsAlunosQue = new JLabel(
				"Os alunos que compoem esta turma poderao");
		lblOsAlunosQue.setBounds(26, 356, 288, 16);
		contentPane.add(lblOsAlunosQue);

		JLabel lblPoderaoSerEditados = new JLabel(
				"ser editados no menu Editar Aluno");
		lblPoderaoSerEditados.setBounds(26, 373, 288, 16);
		contentPane.add(lblPoderaoSerEditados);
		
		this.textNome.setText(turma.getNome());
	}

	public void voltar() {
		MenuPrincipal frame = new MenuPrincipal();
		frame.setVisible(true);
		setVisible(false);
	}

	public void atualizar() {
		String nome = textNome.getText();
		Turma turmaAux = new Turma(nome);
		
		try {
			PaginaPrincipal.fachada.atualizarTurma(turmaAux);
			JOptionPane
					.showMessageDialog(this, "Turma cadastrada com sucesso!");
		} catch (ElementoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
