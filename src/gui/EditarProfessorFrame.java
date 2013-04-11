package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import classesBase.*;

import dados.Repositorio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class EditarProfessorFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProfessorFrame frame = new EditarProfessorFrame();
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
	public EditarProfessorFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneAOpcao = new JLabel("Selecione a opcao desejada:");
		lblSelecioneAOpcao.setBounds(50, 153, 268, 16);
		contentPane.add(lblSelecioneAOpcao);
		
		comboBox = new JComboBox();
		comboBox.setBounds(40, 62, 462, 27);
		contentPane.add(comboBox);
		
		Repositorio<Pessoa> repositorio = PaginaPrincipal.fachada
				.getPessoas();
		Iterator<Pessoa> it = repositorio.getIterator();
		while (it.hasNext()) {
			Pessoa p = it.next();
			if (p instanceof Professor) {
				comboBox.addItem(p);
			}
		}
		
		JButton btnAtualizarDados = new JButton("Atualizar dados");
		btnAtualizarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pessoa p=null;
				try{
				p = (Pessoa) comboBox.getSelectedItem();
				} catch(NullPointerException e){
					JOptionPane.showMessageDialog(EditarProfessorFrame.this, "Selecione um professor:");
				}
				AtualizarProfessorFrame frame = new AtualizarProfessorFrame((Professor) p);
				frame.setVisible(true);
			}
		});
		btnAtualizarDados.setBounds(40, 181, 146, 50);
		contentPane.add(btnAtualizarDados);
		
		JButton btnInserirTurma = new JButton("Editar turmas");
		btnInserirTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//EDITAR TURMAS
				
			}
		});
		btnInserirTurma.setBounds(198, 181, 146, 50);
		contentPane.add(btnInserirTurma);
		
		JButton btnInserirDisciplina = new JButton("Editar disciplinas");
		btnInserirDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//EDITAR DISCIPLINAS
				
			}
		});
		btnInserirDisciplina.setBounds(356, 181, 146, 50);
		contentPane.add(btnInserirDisciplina);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(463, 360, 117, 50);
		contentPane.add(btnVoltar);
		
		JLabel lblSelecioneOProfessor = new JLabel("Selecione o professor a ser editado:");
		lblSelecioneOProfessor.setBounds(50, 32, 254, 16);
		contentPane.add(lblSelecioneOProfessor);
		
	}
}
