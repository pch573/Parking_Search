package SPL;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

class Login extends JFrame{

	private JPanel contentPane;
	private JTextField idText;
	private JPasswordField pwText;
	String id = "GjkEpxrZrT";
	String passwd = "am6q7iSXbm";
	myJDBC myjdbc = new myJDBC(id, passwd);
	Connection mycon=myjdbc.getConn();
	static Login login = new Login();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login()  {
		setBackground(Color.GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cksgh\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\parking.jpg"));
		setTitle("S.P.L");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 476);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("S.P.L");
		lblNewLabel.setBounds(174, 32, 189, 57);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("휴먼엑스포", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel ID = new JLabel("\uC544\uC774\uB514");
		ID.setHorizontalAlignment(SwingConstants.CENTER);
		ID.setFont(new Font("굴림", Font.BOLD, 15));
		ID.setBounds(87, 114, 62, 24);
		contentPane.add(ID);
		
		JLabel PW = new JLabel("\uBE44\uBC00\uBC88\uD638");
		PW.setHorizontalAlignment(SwingConstants.CENTER);
		PW.setFont(new Font("굴림", Font.BOLD, 15));
		PW.setBounds(87, 183, 62, 18);
		contentPane.add(PW);
		
		idText = new JTextField();
		idText.setToolTipText("ID\r\n");
		idText.setBounds(161, 115, 222, 24);
		contentPane.add(idText);
		idText.setColumns(10);
		
		pwText = new JPasswordField();
		pwText.setToolTipText("Password");
		pwText.setBounds(161, 181, 222, 24);
		contentPane.add(pwText);
		
		JButton loginButton = new JButton("\uB85C\uADF8\uC778");
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String iddata = idText.getText();
				String pwdata = pwText.getText();
				String sql = "SELECT * FROM MEMBER M WHERE mID =  '"+iddata+"' and mPW = md5('"+pwdata+"')";
				try {
					Statement stmt = mycon.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
					int index = rs.getInt("mIdx");
					admin admin = new admin(index);
					rs.last();
					int count = rs.getRow();
					if(count >=1) {
						JOptionPane.showMessageDialog(null,"로그인되었습니다");
						admin.setVisible(true);
						setVisible(false);
					}
					else { 
						JOptionPane.showMessageDialog(null,"아이디 혹은 비밀번호가 틀렸습니다.","로그인 오류",JOptionPane.WARNING_MESSAGE);	
					}
				}
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		loginButton.setBounds(274, 247, 105, 27);
		contentPane.add(loginButton);
		
		JButton joinButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					JoinMember join = new JoinMember();					
					join.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		joinButton.setBounds(157, 247, 105, 27);
		contentPane.add(joinButton);
		
		JButton seridpwButton = new JButton("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		seridpwButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Serching_ID_PW seridpw = new Serching_ID_PW();
					seridpw.setVisible(true);
				} catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		seridpwButton.setBounds(157, 308, 222, 27);
		contentPane.add(seridpwButton);
		
		
	}
}
