package SPL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;



public class newPW extends JFrame {

	private JPanel contentPane;

	
	private JPasswordField newPWtext;
	private JPasswordField newPWtext_cheak;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int midx=1;
					newPW npw = new newPW(midx);
					npw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void UpdateSQL(Connection mycon,int dbidx, String pwdata, int i)
	   {
	      try {
	    	  String sql = "UPDATE `MEMBER` SET `mPW`=md5(?) WHERE mIdx="+dbidx;
	    	  PreparedStatement pstmt = mycon.prepareStatement(sql);
	    	  pstmt.setString(1,pwdata);
	    	  int rs =pstmt.executeUpdate();
	    	  JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
	      }catch (Exception e) {
	         // TODO: handle exception
	         System.out.println(e);
	         JOptionPane.showMessageDialog(null, e, "오류", JOptionPane.ERROR_MESSAGE);
	      }
	   }
	/**
	 * Create the frame.
	 * @param dbidx 
	 * @throws SQLException 
	 */
	public newPW(int dbidx) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cksgh\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\parking.jpg"));
		Connection mycon;
		String jdbcURL = "jdbc:mysql://remotemysql.com:3306/GjkEpxrZrT?useSSL=false";
		String id = "GjkEpxrZrT";
		String passwd = "am6q7iSXbm";
		mycon=DriverManager.getConnection(jdbcURL,id,passwd);
		Statement stmt = mycon.createStatement();
		
		setTitle("S.P.L");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("휴먼엑스포", Font.BOLD, 20));
		lblNewLabel.setBounds(137, 0, 227, 34);
		contentPane.add(lblNewLabel);
		
		JLabel newPW = new JLabel("\uC0C8 \uBE44\uBC00\uBC88\uD638");
		newPW.setFont(new Font("굴림", Font.BOLD, 15));
		newPW.setBounds(14, 59, 135, 28);
		contentPane.add(newPW);
		
		newPWtext = new JPasswordField();
		newPWtext.setBounds(150, 61, 284, 26);
		contentPane.add(newPWtext);
		
		
		newPWtext_cheak = new JPasswordField();
		newPWtext_cheak.setBounds(150, 114, 284, 26);
		contentPane.add(newPWtext_cheak);
		
		JLabel newPW_cheak = new JLabel("\uC0C8 \uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		newPW_cheak.setFont(new Font("굴림", Font.BOLD, 15));
		newPW_cheak.setBounds(14, 112, 135, 28);
		contentPane.add(newPW_cheak);
		
		JButton cheak = new JButton("\uD655\uC778");
		cheak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwdata = newPWtext.getText();
				String pwdata_cheak = newPWtext_cheak.getText();
				if(pwdata.equals(pwdata_cheak)) {
					UpdateSQL(mycon,dbidx, pwdata, 0);
					setVisible(false);
					
				}
			}
		});
		cheak.setBounds(71, 184, 105, 27);
		contentPane.add(cheak);
		
		JButton cencel = new JButton("\uCDE8\uC18C");
		cencel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				
			}
		});
		cencel.setBounds(310, 184, 105, 27);
		contentPane.add(cencel);
	}
}
