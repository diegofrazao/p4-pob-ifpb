package aplicacaoSwing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaApagar {
	private JFrame frame;
	private JLabel label_2;
	private JTextField textField;
	private JButton button;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private final ButtonGroup grupo = new ButtonGroup();

	public TelaApagar() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setTitle("Apagar");
		frame.setBounds(100, 100, 265, 195);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label_2 = new JLabel("");
		label_2.setBounds(10, 128, 227, 14);
		frame.getContentPane().add(label_2);

		textField = new JTextField();
		textField.setBounds(43, 50, 161, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		radioButton = new JRadioButton("cliente");
		radioButton.setSelected(true);
		grupo.add(radioButton);
		radioButton.setBounds(23, 20, 65, 23);
		frame.getContentPane().add(radioButton);

		radioButton_1 = new JRadioButton("veiculo");
		grupo.add(radioButton_1);
		radioButton_1.setBounds(90, 20, 65, 23);
		frame.getContentPane().add(radioButton_1);
		
		radioButton_2 = new JRadioButton("aluguel");
		grupo.add(radioButton_2);
		radioButton_2.setBounds(157, 20, 80, 23);
		frame.getContentPane().add(radioButton_2);

		button = new JButton("Apagar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String termo = textField.getText();
					if(radioButton.isSelected())
						Fachada.excluirCliente(termo);
					if(radioButton_1.isSelected())
						Fachada.excluirVeiculo(termo);
					if(radioButton_2.isSelected())
						Fachada.excluirAluguel(termo);
					textField.setText("");
					label_2.setText("exclusão realizada");
				}
				catch(Exception e) {
					label_2.setText(e.getMessage());
				}
			}
		});
		button.setBounds(68, 80, 108, 23);
		frame.getContentPane().add(button);
		
		frame.setVisible(true);
	}
}
