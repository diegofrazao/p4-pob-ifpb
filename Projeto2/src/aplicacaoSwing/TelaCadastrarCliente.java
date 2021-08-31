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

public class TelaCadastrarCliente {
	private JFrame frame;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;

	
	public TelaCadastrarCliente() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Cadastro");
		frame.setBounds(100, 100, 263, 215);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("nome:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 26, 71, 14);
		frame.getContentPane().add(label);
		
		label_2 = new JLabel("");
		label_2.setBounds(10, 139, 227, 14);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(91, 23, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 51, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		button = new JButton("Cadastrar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = textField.getText();
					String endereco = textField_1.getText();
					Fachada.cadastrarCliente(nome, endereco);
					textField.setText("");
					textField_1.setText("");
					label_2.setText("cadastro realizado");
				}
				catch(Exception e) {
					label_2.setText("cadastro mal sucedido");
				}
			}
		});
		button.setBounds(69, 94, 108, 23);
		frame.getContentPane().add(button);
		
		label_1 = new JLabel("endereço:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 54, 71, 14);
		frame.getContentPane().add(label_1);
		
		
		frame.setVisible(true);
	}
}
