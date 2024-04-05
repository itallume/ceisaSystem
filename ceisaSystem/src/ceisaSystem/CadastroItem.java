package ceisaSystem;

import Exceptions.NomeInvalido;
import Exceptions.Quantidadeinvalida;
import Exceptions.ValorUnitarioInvalido;
import models.Cadastro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroItem {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldQuant;
	private JTextField textFieldPrecoU;
	private JTextField textFieldPrecoA;
	private JTextField textFieldPrecoV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroItem window = new CadastroItem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private boolean verificarCampoDouble(String numeroTexto) {
		try {
			Double.parseDouble(numeroTexto);
		}catch(NumberFormatException ex) {
			return false;
		}
		if (Double.parseDouble(numeroTexto) < 0) {
			throw new NumberFormatException("Valores numéricos precisam ser positivos.");
		}
		return true;
	}
	
	private boolean verificarCampoInteger(String numeroTexto) {
		try {
			Integer.parseInt(numeroTexto);
		}catch(NumberFormatException ex) {
			return false;
		}
		if (Integer.parseInt(numeroTexto) < 0) {
			throw new NumberFormatException("Valores numéricos precisam ser positivos.");
		}
		return true;	
	}

	/**
	 * Create the application.
	 */
	public CadastroItem() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 380);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(254, 205, 247));
		
		
		JLabel lblNewLabel = new JLabel("Cadastro De Produtos");
		lblNewLabel.setBounds(10, 12, 464, 38);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(44, 68, 83, 22);
		frame.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(43, 94, 170, 29);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblQuant = new JLabel("Quantidade:");
		lblQuant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuant.setBounds(275, 65, 113, 29);
		frame.getContentPane().add(lblQuant);
		
		textFieldQuant = new JTextField();
		textFieldQuant.setColumns(10);
		textFieldQuant.setBounds(275, 94, 170, 29);
		frame.getContentPane().add(textFieldQuant);
		
		JLabel lblPrecoU = new JLabel("Preço Unitário:");
		lblPrecoU.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecoU.setBounds(43, 134, 149, 29);
		frame.getContentPane().add(lblPrecoU);
		
		textFieldPrecoU = new JTextField();
		textFieldPrecoU.setColumns(10);
		textFieldPrecoU.setBounds(43, 165, 170, 29);
		frame.getContentPane().add(textFieldPrecoU);
		
		JLabel lblPrecoA = new JLabel("Preço Atacado:");
		lblPrecoA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecoA.setBounds(275, 134, 142, 29);
		frame.getContentPane().add(lblPrecoA);
		
		textFieldPrecoA = new JTextField();
		textFieldPrecoA.setColumns(10);
		textFieldPrecoA.setBounds(275, 165, 170, 29);
		frame.getContentPane().add(textFieldPrecoA);
		
		JLabel lblPrecoV = new JLabel("Preço Varejo:");
		lblPrecoV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecoV.setBounds(43, 205, 149, 29);
		frame.getContentPane().add(lblPrecoV);
		
		textFieldPrecoV = new JTextField();
		textFieldPrecoV.setColumns(10);
		textFieldPrecoV.setBounds(43, 235, 170, 29);
		frame.getContentPane().add(textFieldPrecoV);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(240, 240, 240));
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnCadastrar.setBounds(275, 227, 170, 38);
		frame.getContentPane().add(btnCadastrar);
		
		JLabel avisosLabel = new JLabel("");
		avisosLabel.setForeground(new Color(236, 0, 0));
		avisosLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		avisosLabel.setBounds(44, 286, 401, 44);
		frame.getContentPane().add(avisosLabel);
		
		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldNome.getText().isEmpty()) {
					avisosLabel.setText("Digite um nome válido.");
				}else {
					avisosLabel.setText("");
				}
			}
		});
		textFieldQuant.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Integer.parseInt(textFieldQuant.getText());
					avisosLabel.setText("");
				}
				catch (Exception ex){
					avisosLabel.setText("Digite um valor válido para quantidade.");
				}
				
			}
		});
		
		textFieldPrecoU.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Double.parseDouble(textFieldPrecoU.getText());
					avisosLabel.setText("");
				}
				catch (Exception ex){
					avisosLabel.setText("Digite um valor válido para preço unitário.");
				}
			}
		});
		
		textFieldPrecoA.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Double.parseDouble(textFieldPrecoA.getText());
					avisosLabel.setText("");
				}
				catch (Exception ex){
					avisosLabel.setText("Digite um valor válido para preço atacado.");
				}
			
			}
		});
		

		textFieldPrecoV.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Double.parseDouble(textFieldPrecoV.getText());
					avisosLabel.setText("");
				}
				catch (Exception ex){
					avisosLabel.setText("Digite um valor válido para preço varejo.");
				}
			}
		});
		
		
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){	
				try {
					var cadastro = new Cadastro(textFieldNome.getText(), textFieldQuant.getText(), textFieldPrecoU.getText());
					String nome = cadastro.getNome();
					int quantidade = cadastro.getQuantidade();
					double precoUnitario = cadastro.getPrecoUnitario();

					var itens = new Item(nome, quantidade, precoUnitario);

					avisosLabel.setText(itens.getNome());
				  }
				catch(NomeInvalido ex) {
					avisosLabel.setText(ex.getMessage());
					textFieldNome.setText("");
				}
				catch(Quantidadeinvalida ex) {
					avisosLabel.setText(ex.getMessage());
					textFieldQuant.setText("");
				}
				catch(ValorUnitarioInvalido ex) {
					avisosLabel.setText(ex.getMessage());
					textFieldPrecoU.setText("");
				}
				catch (Exception ex) {
					avisosLabel.setText(ex.getMessage());
				}
			}

				});
		frame.setVisible(true);
	}
}
