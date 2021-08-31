package aplicacaoSwing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fachada.Fachada;

public class TelaCadastrarVeiculo {
	private JFrame frame;
	private JLabel label;
	private JLabel lblModelo;
	private JLabel label_2;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JTextField textField_2;

	
	public TelaCadastrarVeiculo() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Cadastro");
		frame.setBounds(100, 100, 263, 215);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("placa:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 26, 71, 14);
		frame.getContentPane().add(label);
		
		label_2 = new JLabel("");
		label_2.setBounds(10, 147, 227, 14);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(91, 23, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 51, 121, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		button = new JButton("Cadastrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String placa = textField.getText();
					String modelo = textField_1.getText();
					int ano = Integer.parseInt(textField_2.getText());
					Fachada.cadastrarVeiculo(placa, modelo, ano);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					label_2.setText("cadastro realizado");
				}
				catch(Exception e) {
					label_2.setText("cadastro mal sucedido");
				}
			}
		});
		button.setBounds(68, 113, 108, 23);
		frame.getContentPane().add(button);
		
		lblModelo = new JLabel("modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelo.setBounds(10, 54, 71, 14);
		frame.getContentPane().add(lblModelo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 82, 121, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel lblAnoo = new JLabel("ano:");
		lblAnoo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnoo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAnoo.setBounds(10, 85, 71, 14);
		frame.getContentPane().add(lblAnoo);
		
		
		frame.setVisible(true);
	}
}
