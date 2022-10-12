package SPL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JoinMember extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
	private JTextField nameText;
	private JTextField idText;
	private JPasswordField pwText;
	private JPasswordField pw_cheakText;
	private JTextField PLEmailText;
	private JTextField PLphText;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			
					Login login = new Login();
					JoinMember join = new JoinMember();
					join.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void InsertSQL(Connection mycon,String iddata,String pwdata,String namedata,String Emaildata,String PHdata, int i)
	   {
	      try {
	    	  String sql = "insert into GjkEpxrZrT.MEMBER (`mID`,`mPW`,`mName`,`mEMail`,`mPH`) values(?,md5(?),?,?,?)";
	    	  PreparedStatement pstmt = mycon.prepareStatement(sql);
	    	  pstmt.setString(1,iddata);
	    	  pstmt.setString(2,pwdata);
	    	  pstmt.setString(3,namedata);
	    	  pstmt.setString(4,Emaildata);
	    	  pstmt.setString(5,PHdata);
	    	  int rs =pstmt.executeUpdate();
	    	  JOptionPane.showMessageDialog(null, "회원가입을 성공했습니다.");
	      }catch (Exception e) {
	         // TODO: handle exception
	         System.out.println(e);
	         JOptionPane.showMessageDialog(null, e, "오류", JOptionPane.ERROR_MESSAGE);
	      }
	   }
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JoinMember() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cksgh\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\parking.jpg"));
		Connection mycon;
		String jdbcURL = "jdbc:mysql://remotemysql.com:3306/GjkEpxrZrT?useSSL=false";
		String id = "GjkEpxrZrT";
		String passwd = "am6q7iSXbm";
		mycon=DriverManager.getConnection(jdbcURL,id,passwd);
		Statement stmt = mycon.createStatement();
		
		setTitle("S.P.L");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("휴먼엑스포", Font.BOLD, 20));
		lblNewLabel.setBounds(149, 0, 129, 36);
		contentPane.add(lblNewLabel);
		
		JLabel Name = new JLabel("\uC774\uB984");
		Name.setFont(new Font("굴림", Font.BOLD, 15));
		Name.setBounds(14, 50, 62, 18);
		contentPane.add(Name);
		
		nameText = new JTextField(10);
		nameText.setBounds(143, 47, 238, 24);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JLabel ID = new JLabel("\uC544\uC774\uB514");
		ID.setFont(new Font("굴림", Font.BOLD, 15));
		ID.setBounds(14, 80, 62, 18);
		contentPane.add(ID);
		
		idText = new JTextField();
		idText.setColumns(10);
		idText.setBounds(143, 77, 238, 24);
		contentPane.add(idText);
		
		JLabel PW = new JLabel("\uBE44\uBC00\uBC88\uD638");
		PW.setFont(new Font("굴림", Font.BOLD, 15));
		PW.setBounds(14, 110, 62, 18);
		contentPane.add(PW);
		
		pwText = new JPasswordField();
		pwText.setEchoChar('*');
		pwText.setBounds(143, 107, 238, 24);
		contentPane.add(pwText);
		
		JLabel PW_cheak = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		PW_cheak.setFont(new Font("굴림", Font.BOLD, 15));
		PW_cheak.setBounds(14, 140, 96, 18);
		contentPane.add(PW_cheak);
		
		pw_cheakText = new JPasswordField();
		pw_cheakText.setEchoChar('*');
		pw_cheakText.setBounds(143, 137, 238, 24);
		contentPane.add(pw_cheakText);
		
		JLabel PLEmailLabel = new JLabel("\uC774\uBA54\uC77C");
		PLEmailLabel.setFont(new Font("굴림", Font.BOLD, 15));
		PLEmailLabel.setBounds(14, 173, 62, 18);
		contentPane.add(PLEmailLabel);
		
		PLEmailText = new JTextField();
		PLEmailText.setColumns(30);
		PLEmailText.setBounds(143, 170, 238, 24);
		contentPane.add(PLEmailText);
		
		JLabel PLphLabel = new JLabel("\uD578\uB4DC\uD3F0\uBC88\uD638");
		PLphLabel.setFont(new Font("굴림", Font.BOLD, 15));
		PLphLabel.setBounds(14, 203, 82, 18);
		contentPane.add(PLphLabel);
		
		PLphText = new JTextField();
		PLphText.setColumns(20);
		PLphText.setBounds(143, 200, 238, 24);
		contentPane.add(PLphText);
		
		JButton cheak = new JButton("\uD655\uC778");
		cheak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pwText.getText().equals(pw_cheakText.getText())) {
					InsertSQL(mycon, idText.getText(), pwText.getText(), nameText.getText(), PLEmailText.getText(), PLphText.getText(), 0);
					setVisible(false);
				}
				else if(pwText.getText() !=pw_cheakText.getText()) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "회원가입 오류", JOptionPane.WARNING_MESSAGE);
				}			
			}
		});		
		cheak.setBounds(54, 256, 105, 27);
		contentPane.add(cheak);
		
		JButton cencel = new JButton("\uCDE8\uC18C");
		cencel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr0) {
				//JoinMember join;
				setVisible(false);
				
			}
		});
		cencel.setBounds(262, 256, 105, 27);
		contentPane.add(cencel);
		
		
	}
	
}
