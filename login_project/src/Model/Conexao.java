package Model;

import java.sql.*;
import javax.swing.JOptionPane;

import View.FrameDashboard;
import View.FrameLogin;

public class Conexao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dbjavacrud", "root", "");
		} catch(ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "A conexão com o Banco de Dados falhou");
			ex.printStackTrace();
			FrameLogin frameLogin = new FrameLogin();
			frameLogin.setVisible(true);
//			frameDashboard.dispose();
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "A conexão com o Banco de Dados falhou");
			ex.printStackTrace();
			FrameLogin frameLogin = new FrameLogin();
			frameLogin.setVisible(true);
//			frameDashboard.dispose();
		}
	}
	
	public void InsertClient(String name, String email, String tell) {
		Connect();
		try {
			pst = conn.prepareStatement("INSERT INTO clientes(nome, email, telefone) VALUES (?, ?, ?)");
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, tell);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente adicionado com SUCESSO!");
		} catch(SQLException el) {
			el.printStackTrace();
		}
	}
	
	public void UpdateClient(String id, String name, String email, String tell) {
		Connect();
		try {
			pst = conn.prepareStatement("UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE id = ?");
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, tell);
			pst.setString(4, id);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente alterado com SUCESSO!");
		} catch(SQLException el) {
			el.printStackTrace();
		}
	}
	
	public void DeleteClient(String id) {
		Connect();
		try {
			pst = conn.prepareStatement("DELETE FROM clientes WHERE id = ?");
			pst.setString(1, id);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente deletado com SUCESSO!");
		} catch(SQLException el) {
			el.printStackTrace();
		}
	}
	
	public ResultSet load_table() {
		Connect();
		try {
			pst = conn.prepareStatement("SELECT * FROM clientes");
			rs = pst.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
			rs = null;
		}
		return rs;
	}
	
	public String[] searchClient(String id) {
		Connect();
		try {
			pst = conn.prepareStatement("SELECT nome, email, telefone FROM clientes WHERE id = ?");
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next() == true) {
				String name = rs.getString(1);
				String email = rs.getString(2);
				String tell = rs.getString(3);
				
				return new String[]{name, email, tell};
			}
		} catch(SQLException el) {
			el.printStackTrace();
		}
		
		return new String[]{"", "", ""};
	}
}
