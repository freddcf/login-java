package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import Model.Conexao;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameDashboard extends JFrame {

	private Image img_search = new ImageIcon(FrameLogin.class.getResource("/assets/lupa.png")).getImage()
			.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
	private Image img_signout = new ImageIcon(FrameLogin.class.getResource("/assets/signout.png")).getImage()
			.getScaledInstance(22, 22, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtUserEmail;
	private JTextField txtUserTell;
	private JTable table = new JTable();
	private JTextField txtSearchField;

	public Conexao conn = new Conexao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashboard frame = new FrameDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void load_table() {
		Conexao conn = new Conexao();
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table.setModel(DbUtils.resultSetToTableModel(conn.load_table()));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setResizable(false);
	}

	/**
	 * Create the frame.
	 */
	public FrameDashboard() {
		load_table();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setLocationRelativeTo(null);
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar esta aplicação?", "Confirmação",
						JOptionPane.YES_NO_OPTION) == 0) {
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
		lblX.setBounds(820, 0, 30, 30);
		contentPane.add(lblX);

		JLabel lblNewLabel = new JLabel("Banco de Clientes");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(301, 32, 248, 41);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel.setBackground(new Color(0, 128, 128));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registrar",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(41, 176, 420, 205);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsername = new JLabel("Nome do Cliente");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUsername.setBounds(23, 43, 129, 22);
		panel.add(lblUsername);

		JLabel lblUserEmail = new JLabel("Email do Cliente");
		lblUserEmail.setForeground(Color.WHITE);
		lblUserEmail.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUserEmail.setBounds(23, 93, 125, 22);
		panel.add(lblUserEmail);

		JLabel lblUserTell = new JLabel("Telefone do Cliente");
		lblUserTell.setForeground(Color.WHITE);
		lblUserTell.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblUserTell.setBounds(23, 142, 149, 22);
		panel.add(lblUserTell);

		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBounds(209, 44, 180, 26);
		txtUsername.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		txtUserEmail = new JTextField();
		txtUserEmail.setBorder(null);
		txtUserEmail.setColumns(10);
		txtUserEmail.setBounds(209, 94, 180, 26);
		txtUserEmail.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(txtUserEmail);

		txtUserTell = new JTextField();
		txtUserTell.setBorder(null);
		txtUserTell.setColumns(10);
		txtUserTell.setBounds(209, 146, 180, 26);
		txtUserTell.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(txtUserTell);

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = txtUsername.getText();
				String uemail = txtUserEmail.getText();
				String utell = txtUserTell.getText();
				if ((uname.length() <= 100 && uname.length() != 0) && (uemail.length() <= 65 && uemail.length() != 0)
						&& (utell.length() <= 11 && utell.length() != 0)) {
					if (utell.matches("[+-]?\\d*(\\.\\d+)?")) {
						conn.InsertClient(uname, uemail, utell);
						load_table();
						txtUsername.setText("");
						txtUserEmail.setText("");
						txtUserTell.setText("");
						txtSearchField.setText("");
						txtUsername.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "Telefone inválido");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Quantidade de caracteres excedida");
				}
			}
		});
		btnSalvar.setBorder(null);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(47, 79, 79));
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSalvar.setBounds(70, 406, 150, 50);
		contentPane.add(btnSalvar);

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText("");
				txtUserEmail.setText("");
				txtUserTell.setText("");
				txtUsername.requestFocus();
			}
		});
		btnLimpar.setBounds(277, 406, 150, 50);
		btnLimpar.setBorder(null);
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(new Color(47, 79, 79));
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		contentPane.add(btnLimpar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(502, 106, 300, 275);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);

		JPanel pnlSearchBar = new JPanel();
		pnlSearchBar.setBackground(new Color(47, 79, 79));
		pnlSearchBar.setBounds(41, 106, 420, 50);
		contentPane.add(pnlSearchBar);
		pnlSearchBar.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Buscar ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(23, 14, 71, 22);
		pnlSearchBar.add(lblNewLabel_1);

		JPanel pnlSearchField = new JPanel();
		pnlSearchField.setBackground(Color.WHITE);
		pnlSearchField.setBounds(113, 11, 284, 30);
		pnlSearchBar.add(pnlSearchField);
		pnlSearchField.setLayout(null);

		JLabel lblIconSearch = new JLabel("");
		lblIconSearch.setBounds(243, 0, 41, 30);
		pnlSearchField.add(lblIconSearch);
		lblIconSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIconSearch.setBorder(null);
		lblIconSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSearch.setIcon(new ImageIcon(img_search));

		txtSearchField = new JTextField();
		txtSearchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String id = txtSearchField.getText();
				String[] dataFetch = conn.searchClient(id);
				txtUsername.setText(dataFetch[0]);
				txtUserEmail.setText(dataFetch[1]);
				txtUserTell.setText(dataFetch[2]);
			}
		});
		txtSearchField.setColumns(10);
		txtSearchField.setBorder(null);
		txtSearchField.setBounds(10, 4, 221, 22);
		pnlSearchField.add(txtSearchField);

		JPanel pnlSignout = new JPanel();
		pnlSignout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlSignout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmação",
						JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin frameLogin = new FrameLogin();
					frameLogin.setVisible(true);
					FrameDashboard.this.dispose();
				}
			}
		});
		pnlSignout.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		pnlSignout.setBackground(new Color(0, 139, 139));
		pnlSignout.setBounds(725, 43, 77, 32);
		contentPane.add(pnlSignout);
		pnlSignout.setLayout(null);

		JLabel lblIconSignout = new JLabel("");
		lblIconSignout.setBounds(10, 5, 22, 22);
		pnlSignout.add(lblIconSignout);
		lblIconSignout.setIcon(new ImageIcon(img_signout));

		JLabel lblNewLabel_2 = new JLabel("Sair");
		lblNewLabel_2.setBounds(37, 5, 29, 22);
		pnlSignout.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));

		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid = txtSearchField.getText();
				String uname = txtUsername.getText();
				String uemail = txtUserEmail.getText();
				String utell = txtUserTell.getText();
				if ((uname.length() <= 100 && uname.length() != 0) && (uemail.length() <= 65 && uemail.length() != 0)
						&& (utell.length() <= 11 && utell.length() != 0)) {
					conn.UpdateClient(uid, uname, uemail, utell);
					load_table();
					txtUsername.setText("");
					txtUserEmail.setText("");
					txtUserTell.setText("");
					txtSearchField.setText("");
					txtUsername.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "Quantidade de caracteres excedida");
				}
			}
		});
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(new Color(47, 79, 79));
		btnAlterar.setBounds(502, 406, 130, 50);
		contentPane.add(btnAlterar);

		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid = txtSearchField.getText();
				if (uid.matches("[+-]?\\d*(\\.\\d+)?")) {
					if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este cliente?",
							"Confirmação", JOptionPane.YES_NO_OPTION) == 0) {

						conn.DeleteClient(uid);
						load_table();
						txtUsername.setText("");
						txtUserEmail.setText("");
						txtUserTell.setText("");
						txtSearchField.setText("");
						txtUsername.requestFocus();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Quantidade de caracteres excedida");
				}
			}
		});
		btnDeletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletar.setForeground(Color.WHITE);
		btnDeletar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnDeletar.setBorder(null);
		btnDeletar.setBackground(new Color(47, 79, 79));
		btnDeletar.setBounds(672, 406, 130, 50);
		contentPane.add(btnDeletar);
	}
}
