package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;

public class FrameLogin extends JFrame {

	private Image img_logo = new ImageIcon(FrameLogin.class.getResource("/assets/iconlogo.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_username = new ImageIcon(FrameLogin.class.getResource("/assets/user.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(FrameLogin.class.getResource("/assets/padlock.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	private Image img_login = new ImageIcon(FrameLogin.class.getResource("/assets/iconlogin.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(178, 173, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Usuário")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Usuário");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setText("Usu\u00E1rio");
		txtUsername.setBounds(10, 11, 170, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setBounds(210, 0, 40, 40);
		lblIconUsername.setIcon(new ImageIcon(img_username));
		panel.add(lblIconUsername);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(178, 224, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPassword.setEchoChar('●');
				txtPassword.selectAll();
				if(txtPassword.getText().equals("Senha")) {
					txtPassword.setText("");					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setEchoChar((char)0);
					txtPassword.setText("Senha");
				}
			}
		});
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setText("Senha");
		txtPassword.setBounds(10, 11, 170, 20);
		panel_1.add(txtPassword);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(210, 0, 40, 40);
		lblIconPassword.setIcon(new ImageIcon(img_password));
		panel_1.add(lblIconPassword);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")) {
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Bem-vindo!");
					FrameDashboard dashboard = new FrameDashboard();
					dashboard.setVisible(true);
					FrameLogin.this.dispose();
				} else if(txtUsername.getText().equals("") || txtUsername.getText().equals("Usuário") || 
						txtPassword.getText().equals("") || txtPassword.getText().equals("Senha")) {
					lblLoginMessage.setText("Por favor preencha todos os campos!");
				} else {
					lblLoginMessage.setText("Usuário e senha inválidos!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(48, 90, 82));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(47, 79, 79));
			}
		});
		pnlBtnLogin.setBackground(new Color(47, 79, 79));
		pnlBtnLogin.setBounds(178, 303, 250, 50);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTRAR");
		lblNewLabel.setBounds(118, 11, 56, 28);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		pnlBtnLogin.add(lblNewLabel);
		
		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogin.setBounds(68, 0, 50, 50);
		lblIconLogin.setIcon(new ImageIcon(img_login));
		pnlBtnLogin.add(lblIconLogin);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar esta aplicação?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(570, 0, 30, 30);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(178, 38, 250, 100);
		contentPane.add(lblIconLogo);
		setUndecorated(true);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		lblLoginMessage.setForeground(new Color(255, 255, 0));
		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLoginMessage.setBounds(178, 278, 250, 14);
		contentPane.add(lblLoginMessage);
		setLocationRelativeTo(null);
	}
}
