package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.DaoUsuario;
import Modelo.usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vususrio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textUsuario;
	private JTextField textClave;
	private JLabel lblIdusuario;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JButton btnAgregar;
	private JTable tblUsuarios;
	DaoUsuario dao=new DaoUsuario();
	protected JLabel txtUsuario;
	protected JLabel txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vususrio frame = new vususrio();
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
	public vususrio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 421);
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setTitle("CRUD USUARIOS");
        setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setBounds(40, 21, 81, 30);
		contentPane.add(lblNewLabel);
		
		lblIdusuario = new JLabel("0");
		lblIdusuario.setFont(new Font("Arial", Font.BOLD, 18));
		lblIdusuario.setAlignmentX(0.5f);
		lblIdusuario.setBounds(159, 21, 56, 30);
		contentPane.add(lblIdusuario);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 18));
		lblUsuario.setAlignmentX(0.5f);
		lblUsuario.setBounds(40, 55, 81, 30);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClave.setFont(new Font("Arial", Font.BOLD, 18));
		lblClave.setAlignmentX(0.5f);
		lblClave.setBounds(40, 96, 81, 30);
		contentPane.add(lblClave);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(159, 62, 193, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textClave = new JTextField();
		textClave.setColumns(10);
		textClave.setBounds(159, 104, 178, 20);
		contentPane.add(textClave);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					usuario user=new usuario();
					user.setUsuario(txtUsuario.getText());
					user.setClave(txtClave.getText());
					if (dao.insertarUsuario(user, user)) {
						JOptionPane.showMessageDialog(null,"SE AGREGO CORRECTAMENTE");
						
					}else {
						JOptionPane.showMessageDialog(null,"ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"ERROR");
					
					
				}
				
			}
		});
		btnAgregar.setBounds(467, 27, 89, 23);
		contentPane.add(btnAgregar);
		
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(467, 61, 89, 23);
		contentPane.add(btnActualizar);
		
		
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(467, 131, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(467, 97, 89, 23);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 643, 217);
		contentPane.add(scrollPane);
		
		tblUsuarios = new JTable();
		tblUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblUsuarios);
	}
}
