package br.com.lojacalcados.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.lojacalcados.dao.DAOCliente;
import br.com.lojacalcados.dao.DAOContato;
import br.com.lojacalcados.dao.DAODadosPessoais;
import br.com.lojacalcados.dao.DAOEndereco;
import br.com.lojacalcados.pojo.Cliente;
import br.com.lojacalcados.pojo.Contato;
import br.com.lojacalcados.pojo.DadosPessoais;
import br.com.lojacalcados.pojo.Endereco;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JFormattedTextField txtCPF;
	private JFormattedTextField txtDataNascimento;
	private JTextField txtEmail;
	private JFormattedTextField txtTelRes;
	private JFormattedTextField txtTelCel;
	private JFormattedTextField txtTelCom;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JFormattedTextField txtCep;
	private JTable table;
	private JScrollPane scrollPane;
	//instancia Pojo
	private Cliente cliente = new Cliente();
	private DadosPessoais dp = new DadosPessoais();
	private Contato ct = new Contato();
	private Endereco end = new Endereco();
	//instancia do dao
	private DAOCliente daocli = new DAOCliente();
	private DAODadosPessoais daodp = new DAODadosPessoais();
	private DAOContato daocontato = new DAOContato();
	private DAOEndereco daoend = new DAOEndereco();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {
		setResizable(false);
		setTitle("Tela Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 746);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBorder(null);
		pnlTitulo.setBackground(new Color(204, 204, 204));
		pnlTitulo.setBounds(28, 22, 779, 124);
		contentPane.add(pnlTitulo);
		pnlTitulo.setLayout(null);
		
		JLabel lblicone = new JLabel("");
		lblicone.setIcon(new ImageIcon("C:\\Users\\cauam.rmarque\\Documents\\LojaCalcados\\imagens\\hawk64.png"));
		lblicone.setBounds(21, 11, 70, 102);
		pnlTitulo.add(lblicone);
		
		JLabel lblTituloTela = new JLabel("Gerenciar Clientes");
		lblTituloTela.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTituloTela.setBounds(109, 25, 368, 69);
		pnlTitulo.add(lblTituloTela);
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\cauam.rmarque\\Documents\\LojaCalcados\\imagens\\disquete.png"));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.setBounds(382, 31, 159, 63);
		pnlTitulo.add(btnSalvar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon("C:\\Users\\cauam.rmarque\\Documents\\LojaCalcados\\imagens\\lupa.png"));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConsultar.setBounds(569, 32, 159, 63);
		pnlTitulo.add(btnConsultar);
		
		JPanel pnlDP = new JPanel();
		pnlDP.setBackground(new Color(204, 204, 204));
		pnlDP.setBounds(28, 167, 425, 165);
		contentPane.add(pnlDP);
		pnlDP.setLayout(null);
		
		JLabel lblCliente = new JLabel("Nome do Cliente:");
		lblCliente.setBounds(22, 23, 100, 14);
		pnlDP.add(lblCliente);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(22, 58, 100, 14);
		pnlDP.add(lblCPF);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setBounds(22, 95, 100, 14);
		pnlDP.add(lblDataNascimento);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(22, 130, 100, 14);
		pnlDP.add(lblSexo);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(161, 20, 235, 20);
		pnlDP.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		try {
		txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCPF.setBounds(161, 55, 235, 20);
		pnlDP.add(txtCPF);
		
		txtDataNascimento = new JFormattedTextField(new MaskFormatter("####-##-##"));
		txtDataNascimento.setBounds(160, 92, 236, 20);
		pnlDP.add(txtDataNascimento);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JComboBox cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cboSexo.setBounds(225, 126, 171, 22);
		pnlDP.add(cboSexo);
		
		JPanel pnlContato = new JPanel();
		pnlContato.setBackground(new Color(204, 204, 204));
		pnlContato.setBounds(463, 167, 344, 165);
		contentPane.add(pnlContato);
		pnlContato.setLayout(null);
		
		JLabel lblTelRes = new JLabel("Telefone Residencial:");
		lblTelRes.setBounds(10, 27, 129, 14);
		pnlContato.add(lblTelRes);
		
		JLabel lblFoneCel = new JLabel("Telefone Celular:");
		lblFoneCel.setBounds(10, 52, 115, 14);
		pnlContato.add(lblFoneCel);
		
		JLabel lblFoneComercial = new JLabel("Telefone Comercial:");
		lblFoneComercial.setBounds(10, 89, 115, 14);
		pnlContato.add(lblFoneComercial);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 114, 115, 14);
		pnlContato.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(160, 111, 174, 20);
		pnlContato.add(txtEmail);
		
		try {
		txtTelRes = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		txtTelRes.setBounds(160, 24, 174, 20);
		pnlContato.add(txtTelRes);
		
		 txtTelCel = new JFormattedTextField(new MaskFormatter("(##) 9####-####"));
		txtTelCel.setBounds(160, 49, 174, 20);
		pnlContato.add(txtTelCel);
		
		 txtTelCom = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		txtTelCom.setBounds(160, 80, 174, 20);
		pnlContato.add(txtTelCom);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(28, 353, 779, 141);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo Logradouro:");
		lblTipo.setBounds(23, 24, 101, 14);
		panel.add(lblTipo);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(23, 49, 101, 14);
		panel.add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(23, 80, 101, 14);
		panel.add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(23, 105, 101, 14);
		panel.add(lblComplemento);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(382, 49, 101, 14);
		panel.add(lblCep);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(382, 24, 101, 14);
		panel.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(382, 80, 101, 14);
		panel.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(382, 105, 101, 14);
		panel.add(lblEstado);
		
		JComboBox cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Rua", "Avenida", "Pra\u00E7a", "Alameda", "Viela", "Estrada", "Travessa"}));
		cboTipo.setBounds(124, 22, 227, 18);
		panel.add(cboTipo);
		
		try {
		txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		txtCep.setBounds(483, 47, 227, 18);
		panel.add(txtCep);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(124, 47, 227, 17);
		panel.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(124, 78, 227, 17);
		panel.add(txtNumero);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(124, 103, 227, 17);
		panel.add(txtComplemento);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(483, 22, 227, 17);
		panel.add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(483, 78, 227, 17);
		panel.add(txtCidade);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(483, 103, 227, 17);
		panel.add(txtEstado);
		
		JPanel lblClientes = new JPanel();
		lblClientes.setBounds(35, 505, 772, 178);
		contentPane.add(lblClientes);
		lblClientes.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 752, 162);
		lblClientes.add(scrollPane);
		
		
		carregarDados();
		
		
		
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Fazer as passagens dos elementos do formulário para os respectivos objetos
				//e depois cadastrar
				
				end.setTipo(cboTipo.getSelectedItem().toString());
				end.setLogradouro(txtLogradouro.getText());
				end.setNumero(txtNumero.getText());
				end.setComplemento(txtComplemento.getText());
				end.setCep(txtCep.getText());
				end.setBairro(txtBairro.getText());
				end.setCidade(txtCidade.getText());
				end.setEstado(txtEstado.getText());
				
				//efetuar a gravação do endereço na tela.
				//O ID gerado será alocado em uma variável
				String rse = daoend.create(end);
				
				//Passagem dos dados para o objeto contato
				ct.setTelefoneResidencial(txtTelRes.getText());
				ct.setTelefoneCelular(txtTelCel.getText());
				ct.setTelefoneComercial(txtTelCom.getText());
				ct.setEmail(txtEmail.getText());
				String rsc = daocontato.create(ct);
				
				//Passagem dos dados para o objeto dados pessoais
				dp.setCpf(txtCPF.getText());
				dp.setDataNascimento(Date.valueOf(txtDataNascimento.getText()));
				dp.setSexo(cboSexo.getSelectedItem().toString());
				String rsdb = daodp.create(dp);
				
				
				//Passagem dos dados para o objeto cliente
				cliente.setNomeCliente(txtNomeCliente.getText());
				dp.setIdDadosPessoais(Long.parseLong(rsdb));
				cliente.setDadosPessoais(dp);
				
				ct.setIdContato(Long.parseLong(rsc));
				cliente.setContato(ct);
				
				end.setIdEndereco(Long.parseLong(rse));
				cliente.setEndereco(end);
				
				JOptionPane.showMessageDialog(null,  daocli.create(cliente));
				
				carregarDados();
				
				
				
			}
		});
		
		
			
		}
	
	private void carregarDados() {
		//Construir o cabeçalho da tabela
				String[] cabecalho = {
						"id do Cliente",
						"Nome do Cliente",
						"CPF",
						"Sexo",
						"Tel. Residencial",
						"Tel. Celular",
						"Tel. Comercial",
						"E-Mail",
						"Tipo",
						"Logradouro",
						"Número",
						"Complemento",
						"CEP",
						"Bairro",
						"Cidade",
						"Estado"
				};
				
				List<Cliente> lstcliente = new ArrayList<Cliente>();
				lstcliente = daocli.read();
				Object[] dados = new Object[16];
				DefaultTableModel tm = new DefaultTableModel(cabecalho,0);		
				for(int i = 0 ; i < lstcliente.size() ; i++) {
					
					
					dados[0] = lstcliente.get(i).getIdCliente();
					dados[1] = lstcliente.get(i).getNomeCliente();
					dados[2] = lstcliente.get(i).getDadosPessoais().getCpf();
					dados[3] = lstcliente.get(i).getDadosPessoais().getSexo();
					dados[4] = lstcliente.get(i).getContato().getTelefoneResidencial();
					dados[5] = lstcliente.get(i).getContato().getTelefoneCelular();
					dados[6] = lstcliente.get(i).getContato().getTelefoneComercial();
					dados[7] = lstcliente.get(i).getContato().getEmail();
					dados[8] = lstcliente.get(i).getEndereco().getTipo();
					dados[9] = lstcliente.get(i).getEndereco().getLogradouro();
					
					dados[10] = lstcliente.get(i).getEndereco().getNumero();
					dados[11] = lstcliente.get(i).getEndereco().getComplemento();
					dados[12] = lstcliente.get(i).getEndereco().getCep();
					dados[13] = lstcliente.get(i).getEndereco().getBairro();
					dados[14] = lstcliente.get(i).getEndereco().getCidade();
					dados[15] = lstcliente.get(i).getEndereco().getEstado();
					
					tm.addRow(dados);			
				}
				
				table = new JTable(tm);
				
				
				table = new JTable(tm);
				scrollPane.setViewportView(table);
	}
	
	
	
	}





