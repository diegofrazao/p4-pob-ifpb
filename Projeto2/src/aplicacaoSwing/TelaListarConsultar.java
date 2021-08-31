package aplicacaoSwing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Aluguel;
import modelo.Cliente;
import modelo.Veiculo;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class TelaListarConsultar {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button_2;
	private JButton button_3;
	private JButton button;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public TelaListarConsultar() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Listar e Consultar");
		frame.setBounds(100, 100, 615, 366);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 38, 485, 116);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.YELLOW);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Cliente", "Veiculo"}
				));
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		button_2 = new JButton("Listar clientes pelo nome");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Endereço");
					List<Cliente> lista = Fachada.consultarClientes(textField.getText());
					for(Cliente c : lista)
						model.addRow(new Object[]{ c.getNome(), c.getEndereco()});
					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frame,erro.getMessage());
				}
			}
		});
		button_2.setBounds(44, 170, 237, 23);
		frame.getContentPane().add(button_2);

		button_3 = new JButton("Listar veiculos pela placa");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Placa do veiculo");
					model.addColumn("Modelo");
					model.addColumn("Ano");
					List<Veiculo> lista = Fachada.consultarVeiculos(textField_1.getText());
					for(Veiculo v : lista)
						model.addRow(new String[]{ v.getPlaca(), v.getModelo(), Integer.toString(v.getAno())});
					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frame,erro.getMessage());
				}
			}
		});
		button_3.setBounds(44, 204, 237, 23);
		frame.getContentPane().add(button_3);

		button = new JButton("Consultar clientes com N alugueis");
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Carro alugado");
					int n = Integer.parseInt(textField_2.getText());
					List<Cliente> lista = Fachada.consultarClienteNAlugueis(n);
					for(Cliente c : lista)
						for(Aluguel a : c.getAluguel())
							model.addRow(new Object[]{ c.getNome(), a.getVeiculo().getPlaca()});
					table.setModel(model);
				}
				catch(NumberFormatException erro){
					JOptionPane.showMessageDialog(frame,"digite somente numero");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frame,erro.getMessage());
				}
			}
		});
		button.setBounds(44, 274, 255, 23);
		frame.getContentPane().add(button);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(301, 172, 120, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(301, 206, 120, 20);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(311, 276, 35, 20);
		frame.getContentPane().add(textField_2);
		
		JButton button_3_1 = new JButton("Listar alugueis pela placa");
		button_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Carro alugado");
					model.addColumn("Cliente");
					model.addColumn("Valor da diaria");
					model.addColumn("Data do Aluguel");
					model.addColumn("Data de devoluçao");
					List<Veiculo> lista = Fachada.consultarVeiculos(textField_3.getText());
					for(Veiculo v : lista)
						for(Aluguel a : v.getAluguel())
							model.addRow(new Object[]{ v.getPlaca(), a.getCliente().getNome(), "R$ " + a.getValorDiaria(), a.getDataAluguel(), a.getDataDevolucao()});
					table.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(frame,erro.getMessage());
				}
			}
		});
		button_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3_1.setBounds(44, 238, 237, 23);
		frame.getContentPane().add(button_3_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(301, 240, 120, 20);
		frame.getContentPane().add(textField_3);

		frame.setVisible(true);
	}
}
