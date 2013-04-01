package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EscolaFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolaFrame frame = new EscolaFrame();
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
	public EscolaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.setBounds(36, 163, 192, 29);
		contentPane.add(btnCadastrarAluno);
		
		JButton btnCadastrarAdministrador = new JButton("Cadastrar Administrador");
		btnCadastrarAdministrador.setBounds(36, 204, 192, 29);
		contentPane.add(btnCadastrarAdministrador);
		
		JButton btnCadastrarFuncionrio = new JButton("Cadastrar Funcion\u00E1rio");
		btnCadastrarFuncionrio.setBounds(36, 286, 192, 29);
		contentPane.add(btnCadastrarFuncionrio);
		
		JButton btnCadastrarProfessor = new JButton("Cadastrar Professor");
		btnCadastrarProfessor.setBounds(36, 245, 192, 29);
		contentPane.add(btnCadastrarProfessor);
		
		JButton btnConfiguraesDaEscola = new JButton("Configura\u00E7\u00F5es da Escola");
		btnConfiguraesDaEscola.setBounds(36, 52, 192, 29);
		contentPane.add(btnConfiguraesDaEscola);
		
		JButton btnCadastrarDisciplina = new JButton("Cadastrar Disciplina");
		btnCadastrarDisciplina.setBounds(36, 327, 192, 29);
		contentPane.add(btnCadastrarDisciplina);
		
		JButton btnRemover = new JButton("Remover Pessoa");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(347, 52, 192, 29);
		contentPane.add(btnRemover);
		
		JButton btnRemoverDisciplina = new JButton("Remover Disciplina");
		btnRemoverDisciplina.setBounds(347, 92, 192, 29);
		contentPane.add(btnRemoverDisciplina);
	}

}
