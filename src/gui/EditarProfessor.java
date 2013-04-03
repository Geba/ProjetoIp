package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class EditarProfessor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProfessor frame = new EditarProfessor();
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
	public EditarProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInserirDisciplina = new JButton("Inserir Disciplina");
		btnInserirDisciplina.setBounds(10, 34, 122, 23);
		contentPane.add(btnInserirDisciplina);
		
		JButton btnRemoverDisciplina = new JButton("Remover Disciplina");
		btnRemoverDisciplina.setBounds(10, 96, 122, 23);
		contentPane.add(btnRemoverDisciplina);
		
		JButton btnVerDisciplinas = new JButton("Ver Disciplinas");
		btnVerDisciplinas.setBounds(10, 158, 122, 23);
		contentPane.add(btnVerDisciplinas);
		
		JButton btnInserirTurma = new JButton("Inserir Turma");
		btnInserirTurma.setBounds(10, 220, 122, 23);
		contentPane.add(btnInserirTurma);
		
		JButton btnRemoverTurma = new JButton("Remover Turma");
		btnRemoverTurma.setBounds(10, 282, 122, 23);
		contentPane.add(btnRemoverTurma);
		
		JButton btnVerTurmas = new JButton("Ver Turmas");
		btnVerTurmas.setBounds(10, 344, 122, 23);
		contentPane.add(btnVerTurmas);
	}
}
