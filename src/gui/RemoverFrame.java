package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import classesBase.*;
import dados.*;
import excecoes.ElementoNaoEncontradoException;
import excecoes.EntradaInvalidaException;
import excecoes.RepositorioException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private static String tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverFrame frame = new RemoverFrame(tipo);
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
	@SuppressWarnings("static-access")
	public RemoverFrame(final String tipo) {
		this.tipo=tipo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(39, 68, 516, 27);
		contentPane.add(comboBox);
		
		if (tipo.equals("aluno")) {
			Repositorio<Pessoa> repositorio = PaginaPrincipal.fachada
					.getPessoas();
			Iterator<Pessoa> it = repositorio.getIterator();
			while (it.hasNext()) {
				Pessoa p = it.next();
				if (p instanceof Aluno) {
					comboBox.addItem(p);
				}
			}

		} else if (tipo.equals("professor")) {
			Repositorio<Pessoa> repositorio = PaginaPrincipal.fachada
					.getPessoas();
			Iterator<Pessoa> it = repositorio.getIterator();
			while (it.hasNext()) {
				Pessoa p = it.next();
				if (p instanceof Professor) {
					comboBox.addItem(p);
				}
			}
		} else if (tipo.equals("administrador")) {
			Repositorio<Pessoa> repositorio = PaginaPrincipal.fachada
					.getPessoas();
			Iterator<Pessoa> it = repositorio.getIterator();
			while (it.hasNext()) {
				Pessoa p = it.next();
				if (p instanceof Administrador) {
					comboBox.addItem(p);
				}
			}
		} else if (tipo.equals("funcionario")) {
			Repositorio<Pessoa> repositorio = PaginaPrincipal.fachada
					.getPessoas();
			Iterator<Pessoa> it = repositorio.getIterator();
			while (it.hasNext()) {
				Pessoa p = it.next();
				if (p instanceof Funcionario) {
					comboBox.addItem(p);
				}
			}
		} else if (tipo.equals("turma")) {
			Repositorio<Turma> repositorio = PaginaPrincipal.fachada
					.getTurmas();
			Iterator<Turma> it = repositorio.getIterator();
			while (it.hasNext()) {
				Turma t = it.next();
				comboBox.addItem(t);
			}
		} else if (tipo.equals("disciplinas")) {
			Repositorio<Disciplina> repositorio = PaginaPrincipal.fachada
					.getDisciplinas();
			Iterator<Disciplina> it2 = repositorio.getIterator();
			while (it2.hasNext()) {
				Disciplina d = it2.next();
				comboBox.addItem(d);
			}
		}
		
		final Pessoa p=(Pessoa) comboBox.getSelectedItem();
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que quer remover?");
				switch(opc){
				case 0: //sim
					try {
						PaginaPrincipal.fachada.removerPessoa(p.getCpf());
						JOptionPane.showMessageDialog(RemoverFrame.this, tipo+" removido com sucesso.");
					} catch (RepositorioException e1) {
						JOptionPane.showConfirmDialog(null, "Erro no sistema. Desculpe-nos.");
					} catch (EntradaInvalidaException e1) {
					} catch (ElementoNaoEncontradoException e1) {
					}
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
					setVisible(false);
					
					break;
				case 1: //nao
					
					break;
				case 2: //cancelar
					break;
				}
			}
		});
		btnRemover.setBounds(39, 128, 117, 47);
		contentPane.add(btnRemover);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(458, 360, 117, 51);
		contentPane.add(btnVoltar);
		
		

	}

}
