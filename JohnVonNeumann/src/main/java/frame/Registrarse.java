package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import bdd.Conector;
import bdd.Data;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Registrarse extends Login {

	private JFrame frmRegistro;
	private JTextField usrTextField;
	private JTextField edadTextField;
	private JTextField ciudadTextField;
	private JTextField passTextField;
	private JTextField repassTextField;

	/**
	 * Launch the application.
	 */
	public void invocarRegistro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrarse window = new Registrarse();
					window.frmRegistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrarse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistro = new JFrame();
		frmRegistro.setTitle("Registro");
		frmRegistro.setBounds(100, 100, 450, 300);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);

		usrTextField = new JTextField();
		usrTextField.setBounds(144, 13, 176, 22);
		frmRegistro.getContentPane().add(usrTextField);
		usrTextField.setColumns(10);

		edadTextField = new JTextField();
		edadTextField.setBounds(144, 48, 176, 22);
		frmRegistro.getContentPane().add(edadTextField);
		edadTextField.setColumns(10);

		ciudadTextField = new JTextField();
		ciudadTextField.setBounds(144, 83, 176, 22);
		frmRegistro.getContentPane().add(ciudadTextField);
		ciudadTextField.setColumns(10);

		passTextField = new JTextField();
		passTextField.setBounds(144, 118, 176, 22);
		frmRegistro.getContentPane().add(passTextField);
		passTextField.setColumns(10);

		repassTextField = new JTextField();
		repassTextField.setBounds(144, 153, 176, 22);
		frmRegistro.getContentPane().add(repassTextField);
		repassTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel.setBounds(48, 17, 84, 16);
		frmRegistro.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Edad");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(48, 52, 84, 16);
		frmRegistro.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Ciudad");
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(48, 87, 84, 16);
		frmRegistro.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(48, 122, 84, 16);
		frmRegistro.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Re Password");
		lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(24, 159, 108, 16);
		frmRegistro.getContentPane().add(lblNewLabel_4);

		JButton btnNewButton = new JButton("Regristarse");
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usr = usrTextField.getText();
				String pass = passTextField.getText();
				String repass = repassTextField.getText();
				String edad = edadTextField.getText();
				String ciudad = ciudadTextField.getText();

				Conector con = new Conector();
				con.connect();

				/*if (usr.equals(null) || pass.equals(null) || repass.equals(null) || edad.equals(null)
						|| ciudad.equals(null))
					JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "ERROR - Empty fields",
							JOptionPane.ERROR_MESSAGE);
				*/
			
					if (con.mostrarUsuario(usr)) {
						JOptionPane.showMessageDialog(null, " El usuario ya esta en uso", "ERROR - Usuario existente",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (pass.equals(repass)) {
							Data d = new Data();
							d.setUser(usr);
							d.setPassword(pass);
							d.setEdad(edad);
							d.setCiudad(ciudad);
							con.saveData(d);
							JOptionPane.showMessageDialog(null, "Registrado Correctamente", "EXITO",
									JOptionPane.DEFAULT_OPTION);
						} else {
							JOptionPane.showMessageDialog(null, " Las passwords no coinciden", "ERROR - Passwords",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				
				con.close();

			}
		});
		btnNewButton.setBounds(70, 205, 127, 35);
		frmRegistro.getContentPane().add(btnNewButton);

		JButton volverBtn = new JButton("Volver");
		volverBtn.setFont(new Font("Consolas", Font.PLAIN, 15));
		volverBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistro.setVisible(false);
				frmChatbot.setVisible(true);

			}
		});
		volverBtn.setBounds(223, 205, 138, 35);
		frmRegistro.getContentPane().add(volverBtn);
	}

}
