package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesBase.Professor;

import classesBase.Turma;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.JButton;


import excecoes.ElementoJaCadastradoException;
import excecoes.ElementoNaoEncontradoException;
import excecoes.RepositorioException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import dados.Repositorio;

public class EditarProfessorTurmasFrame extends JFrame {

	private JPanel contentPane;
	private static Professor p;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProfessorTurmasFrame frame = new EditarProfessorTurmasFrame(p);
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
	public EditarProfessorTurmasFrame(final Professor p) {
		this.p=p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblTurmasDoProfessor = new JLabel("Selecione a turma a ser removida");
		lblTurmasDoProfessor.setBounds(25, 227, 166, 16);
		contentPane.add(lblTurmasDoProfessor);
		
		final JComboBox comboBoxRemover = new JComboBox();
		comboBoxRemover.setBounds(198, 222, 362, 27);
		contentPane.add(comboBoxRemover);
		
		comboBoxRemover.removeAllItems();
		Iterator<Turma> itTurmasAtuais= this.p.getTurmas().getIterator();
		while(itTurmasAtuais.hasNext()){
			Turma turmaAux = itTurmasAtuais.next();
			comboBoxRemover.addItem(turmaAux);
		}
		 
		final JComboBox comboBoxAdicionar = new JComboBox();
		comboBoxAdicionar.setBounds(198, 290, 362, 27);
		contentPane.add(comboBoxAdicionar);
		
		comboBoxAdicionar.removeAllItems();
		Iterator<Turma> it = PaginaPrincipal.fachada.getTurmas().getIterator();
		while (it.hasNext()){
			Turma turmaAux = it.next();
			comboBoxAdicionar.addItem(turmaAux);
		}
		
		JLabel lblTurmasDaEscola = new JLabel("Selecione a turma a ser adicionada");
		lblTurmasDaEscola.setBounds(25, 301, 166, 16);
		contentPane.add(lblTurmasDaEscola);
		
		JButton btnAdicionarSelecionada = new JButton("Adicionar Selecionada");
		btnAdicionarSelecionada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						PaginaPrincipal.fachada.adicionarTurmaProfessor(p, (Turma) comboBoxAdicionar.getSelectedItem());
						String aviso = "Turma adicionada com sucesso!";
						JOptionPane.showMessageDialog(null, aviso);
						
					} catch (ElementoJaCadastradoException e1) {
						JOptionPane.showMessageDialog(null, "Turma já cadastrada!");
					}
			}}	
		);
		
		btnAdicionarSelecionada.setBounds(378, 323, 182, 29);
		contentPane.add(btnAdicionarSelecionada);
		
		JButton btnAdicionarNova = new JButton("Adicionar Nova");
		btnAdicionarNova.setBounds(198, 323, 182, 29);
		contentPane.add(btnAdicionarNova);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(461, 363, 118, 44);
		contentPane.add(btnVoltar);
		
		final JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PaginaPrincipal.fachada.removerTurmaProfessor(p, (Turma) comboBoxRemover.getSelectedItem());
					String aviso = "Turma adicionada com sucesso!";
					JOptionPane.showMessageDialog(null, aviso);
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(null, "Desculpe-nos, ocorreu um erro no sistema. ):");
				} catch (ElementoNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, "Turma n‹o encontrada.");
				}
			}
		});
		btnRemover.setBounds(378, 250, 182, 29);
		contentPane.add(btnRemover);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 32, 526, 180);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel lblTurmasAtuais = new JLabel("Turmas Atuais:");
		lblTurmasAtuais.setBounds(34, 7, 128, 14);
		contentPane.add(lblTurmasAtuais);
	
		
	}

	
	
}
