package aplicacaoSwing;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;

public class TelaPrincipal {

	private JFrame frame;
	private JMenu mnConsulta;
	private JMenu mnCliente;
	private JMenu mnVeiculo;
	private JMenu mnAluguel;
	private JMenuItem mntmCadastrarCliente;
	private JMenuItem mntmApagarCliente;
	private JMenuItem mntmListarCliente;
	private JMenuItem mntmCadastrarVeiculo;
	private JMenuItem mntmApagarVeiculo;
	private JMenuItem mntmListarVeiculo;
	private JMenuItem mntmCadastrarAluguel;
	private JMenuItem mntmConsultarAluguel;
	private JLabel label;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				
				Fachada.inicializar();
				
				frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				JOptionPane.showMessageDialog(frame, "sistema inicializado !");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(frame, "sistema finalizado !");
			}
		});
		frame.setTitle("Locadora");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(label);
		frame.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaCadastrarCliente();
			}
		});
		mnCliente.add(mntmCadastrarCliente);

		mntmApagarCliente = new JMenuItem("Apagar");
		mntmApagarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaApagar();
			}
		});
		mnCliente.add(mntmApagarCliente);
		
		
		mntmListarCliente = new JMenuItem("Listar");
		mntmListarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaListarConsultar();
			}
		});
		mnCliente.add(mntmListarCliente);

		//-----------------------------------------------------------------
		mnVeiculo = new JMenu("Veiculo");
		menuBar.add(mnVeiculo);
		
		mntmCadastrarVeiculo = new JMenuItem("Cadastrar");
		mntmCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaCadastrarVeiculo();
			}
		});
		mnVeiculo.add(mntmCadastrarVeiculo);

		mntmApagarVeiculo = new JMenuItem("Apagar");
		mntmApagarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaApagar();
			}
		});
		mnVeiculo.add(mntmApagarVeiculo);
		
		
		mntmListarVeiculo = new JMenuItem("Listar");
		mntmListarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaListarConsultar();
			}
		});
		mnVeiculo.add(mntmListarVeiculo);
	
		//-----------------------------------------------------------------
		mnAluguel = new JMenu("Aluguel");
		menuBar.add(mnAluguel);
		
		mntmCadastrarAluguel = new JMenuItem("Cadastrar");
		mntmCadastrarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaCadastrarAluguel();
			}
		});
		mnAluguel.add(mntmCadastrarAluguel);

		mntmCadastrarAluguel = new JMenuItem("Apagar");
		mntmCadastrarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaApagar();
			}
		});
		mnAluguel.add(mntmCadastrarAluguel);
		
		
		mntmCadastrarAluguel = new JMenuItem("Listar");
		mntmCadastrarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaListarConsultar();
			}
		});
		mnAluguel.add(mntmCadastrarAluguel);
		
		mntmConsultarAluguel = new JMenuItem("Consultar");
		mntmConsultarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaConsultarAluguel();
			}
		});
		mnAluguel.add(mntmConsultarAluguel);
	
		//-----------------------------------------------------------------
		mnConsulta = new JMenu("Consultas");
		menuBar.add(mnConsulta);
		mnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new TelaListarConsultar();
			}
		});
	}
}
