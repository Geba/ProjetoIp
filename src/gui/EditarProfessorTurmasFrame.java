package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classesBase.Pessoa;
import classesBase.Professor;
import classesBase.Turma;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import excecoes.ElementoNaoEncontradoException;
import excecoes.RepositorioException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class EditarProfessorTurmasFrame extends JFrame {

	private JPanel contentPane;
	private static Pessoa p;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
	public EditarProfessorTurmasFrame(final Pessoa p) {
		this.p=p;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblTurmasDoProfessor = new JLabel("Selecione a turma a ser removida");
		lblTurmasDoProfessor.setEnabled(false);
		lblTurmasDoProfessor.setBounds(68, 70, 279, 16);
		contentPane.add(lblTurmasDoProfessor);
		
		final JComboBox comboBoxRemover = new JComboBox();
		comboBoxRemover.setEnabled(false);
		comboBoxRemover.setSelectedIndex(0);
		comboBoxRemover.setBounds(62, 90, 498, 27);
		contentPane.add(comboBoxRemover);
		
		JRadioButton rdbtnRemover = new JRadioButton("Remover");
		JRadioButton rdbtnAdicionar = new JRadioButton("Adicionar");
		
		buttonGroup.add(rdbtnRemover);
		rdbtnRemover.setBounds(32, 35, 141, 23);
		contentPane.add(rdbtnRemover);
		
		
		buttonGroup.add(rdbtnAdicionar);
		rdbtnAdicionar.setBounds(32, 176, 141, 23);
		contentPane.add(rdbtnAdicionar);
		
		JComboBox comboBoxAdicionar = new JComboBox();
		comboBoxAdicionar.setEnabled(false);
		comboBoxAdicionar.setBounds(62, 231, 498, 27);
		contentPane.add(comboBoxAdicionar);
		
		JLabel lblTurmasDaEscola = new JLabel("Selecione a turma a ser adicionada");
		lblTurmasDaEscola.setEnabled(false);
		lblTurmasDaEscola.setBounds(68, 211, 279, 16);
		contentPane.add(lblTurmasDaEscola);
		
		JButton btnAdicionarSelecionada = new JButton("Adicionar Selecionada");
		btnAdicionarSelecionada.setEnabled(false);
		btnAdicionarSelecionada.setBounds(378, 264, 182, 29);
		contentPane.add(btnAdicionarSelecionada);
		
		JButton btnAdicionarNova = new JButton("Adicionar Nova");
		btnAdicionarNova.setEnabled(false);
		btnAdicionarNova.setBounds(198, 264, 182, 29);
		contentPane.add(btnAdicionarNova);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(461, 363, 118, 44);
		contentPane.add(btnVoltar);
		
		final JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					((Professor)p).removerTurma((Turma)comboBoxRemover.getSelectedItem());
				} catch (RepositorioException e1) {
					JOptionPane.showMessageDialog(null, "Desculpe-nos, ocorreu um erro no sistema. ):");
				} catch (ElementoNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, "Turma n‹o encontrada.");
				}
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(378, 118, 182, 29);
		contentPane.add(btnRemover);
		
		rdbtnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTurmasDoProfessor.setEnabled(true);
				btnRemover.setEnabled(true);
				comboBoxRemover.setEnabled(true);
				
				Iterator<Turma> it =((Professor)p).getTurmas().getIterator();
				while(it.hasNext()){
					Turma t=(Turma) it.next();
					comboBoxRemover.addItem(t);
				}
			}
		});
		
		
		rdbtnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//BOLINHA DE ADICIONAR
				
				
			}
		});
		
	}
}
