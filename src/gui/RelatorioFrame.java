package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatorioFrame extends JFrame {

	private JPanel contentPane;
	private static String tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioFrame frame = new RelatorioFrame(tipo);
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
	public RelatorioFrame(String tipo) {
		this.tipo=tipo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 48, 560, 326);
		contentPane.add(textPane);
		
		String palavra = tipo.substring(0, 1).toUpperCase() + tipo.substring(1,tipo.length()).toLowerCase();
		
		JLabel lblRelatorio = new JLabel("Relatorio "+palavra);
		lblRelatorio.setBounds(20, 20, 186, 16);
		contentPane.add(lblRelatorio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal frame = new MenuPrincipal();
				frame.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltar.setBounds(463, 379, 117, 43);
		contentPane.add(btnVoltar);
		
		if (tipo.equalsIgnoreCase("aluno")){
			textPane.setText(PaginaPrincipal.fachada.relatorioAlunos());
		}
		
	}
}
