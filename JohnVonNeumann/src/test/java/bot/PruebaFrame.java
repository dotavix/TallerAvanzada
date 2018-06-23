package bot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PruebaFrame {

	private JFrame frmTestframe;
	private JTextField mensajeTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaFrame window = new PruebaFrame();
					window.frmTestframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PruebaFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTestframe = new JFrame();
		frmTestframe.setTitle("TestFrame");
		frmTestframe.setBounds(100, 100, 450, 300);
		frmTestframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestframe.getContentPane().setLayout(null);

		mensajeTextField = new JTextField();
		mensajeTextField.setBounds(12, 218, 314, 22);
		frmTestframe.getContentPane().add(mensajeTextField);
		mensajeTextField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 13, 408, 192);
		frmTestframe.getContentPane().add(textArea);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Asistente a = new Asistente("Duracell");
				if (mensajeTextField.getText().contains("@" + a.getNombreAsistente())) {

					try {
						String respuesta = a.enviar("Maxi", mensajeTextField.getText());
						textArea.setText(respuesta);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnEnviar.setBounds(338, 218, 82, 22);
		frmTestframe.getContentPane().add(btnEnviar);

	}
}
