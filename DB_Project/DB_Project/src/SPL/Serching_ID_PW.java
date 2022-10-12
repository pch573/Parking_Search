package SPL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;

public class Serching_ID_PW extends JFrame {

	
	private JPanel contentPane;
	private JTextField nameText;
	private JTextField name2Text;
	private JTextField IDtext;
	public String namedata;
	private JTextField callText;
	private JTextField call2Text;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Serching_ID_PW serIDPW = new Serching_ID_PW();			
					serIDPW.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Serching_ID_PW() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cksgh\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\parking.jpg"));
		Connection mycon;
		String jdbcURL = "jdbc:mysql://remotemysql.com:3306/GjkEpxrZrT?useSSL=false";
		String id = "GjkEpxrZrT";
		String passwd = "am6q7iSXbm";
		mycon=DriverManager.getConnection(jdbcURL,id,passwd);
		Statement stmt = mycon.createStatement();
		
		setTitle("S.P.L");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514 \uCC3E\uAE30");
		lblNewLabel.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 65, 157, 33);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 20));
		label.setBounds(470, 65, 192, 33);
		contentPane.add(label);
		
		JLabel name = new JLabel("\uC774\uB984");
		name.setFont(new Font("±¼¸²", Font.BOLD, 15));
		name.setBounds(61, 130, 62, 18);
		contentPane.add(name);
		
		nameText = new JTextField();
		nameText.setBounds(128, 130, 157, 24);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JLabel name2 = new JLabel("\uC774\uB984");
		name2.setFont(new Font("±¼¸²", Font.BOLD, 15));
		name2.setBounds(405, 130, 62, 18);
		contentPane.add(name2);
		
		name2Text = new JTextField();
		name2Text.setColumns(10);
		name2Text.setBounds(481, 127, 157, 24);
		contentPane.add(name2Text);
		
		JLabel ID = new JLabel("\uC544\uC774\uB514");
		ID.setFont(new Font("±¼¸²", Font.BOLD, 15));
		ID.setBounds(405, 160, 62, 18);
		contentPane.add(ID);
		
		IDtext = new JTextField();
		IDtext.setColumns(10);
		IDtext.setBounds(481, 157, 157, 24);
		contentPane.add(IDtext);
		
		JLabel PLcallLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		PLcallLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
		PLcallLabel.setBounds(61, 160, 62, 18);
		contentPane.add(PLcallLabel);
		
		callText = new JTextField();
		callText.setBounds(128, 160, 157, 24);
		contentPane.add(callText);
		callText.setColumns(10);
		
		JLabel PLcall2Label = new JLabel("\uC804\uD654\uBC88\uD638");
		PLcall2Label.setFont(new Font("±¼¸²", Font.BOLD, 15));
		PLcall2Label.setBounds(405, 186, 62, 18);
		contentPane.add(PLcall2Label);
		
		call2Text = new JTextField();
		call2Text.setColumns(10);
		call2Text.setBounds(481, 185, 157, 24);
		contentPane.add(call2Text);
		
		JButton idSerching = new JButton("\uAC80\uC0C9");
		idSerching.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namedata = nameText.getText();
				String phdata = callText.getText();
				String sql = "SELECT * FROM MEMBER where mName='"+namedata+"' and "+"mPH='"+phdata+"'";
				try {
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String dbid = rs.getString("mID");
						rs.last();
						int count = rs.getRow();
						if(count >=1) {
							JOptionPane.showMessageDialog(null,"¾ÆÀÌµð : "+dbid);
						}
						else { 
							JOptionPane.showMessageDialog(null,"°¡ÀÔÇÏ½Å ¾ÆÀÌµð°¡ ¾ø½À´Ï´Ù.","S.P.L",JOptionPane.WARNING_MESSAGE);
						}
					}
				}catch (Exception e1) {
					// TODO: handle exception
				} 
					
			}
			
		});		
		idSerching.setBounds(144, 193, 105, 27);
		contentPane.add(idSerching);
		
		JButton pwSerching = new JButton("\uAC80\uC0C9");
		pwSerching.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String namedata2 = name2Text.getText();
				String iddata = IDtext.getText();
				String phdata2 = call2Text.getText();
				String sql = "SELECT * FROM MEMBER where mName='"+namedata2+"' AND mID='"+iddata+"' AND mPH='"+phdata2+"'";
				newPW newPW;
				try {
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String dbname = rs.getString("mName");
						String dbid = rs.getString("mID");
						String dbph = rs.getString("mPH");
						int dbidx = rs.getInt("mIdx");
						if(dbname.equals(namedata2) && dbid.equals(iddata) && dbph.equals(phdata2)) {
							newPW = new newPW(dbidx);
							newPW.setVisible(true);
							setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(null,"°¡ÀÔÇÏ½Å Á¤º¸°¡ ¾ø½À´Ï´Ù.","S.P.L",JOptionPane.WARNING_MESSAGE);
						}
					}
				}catch (Exception e1) {
					
				} 
			}
		});
		pwSerching.setBounds(504, 221, 105, 27);
		contentPane.add(pwSerching);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(307, 289, 105, 27);
		contentPane.add(btnNewButton);
	}
}
