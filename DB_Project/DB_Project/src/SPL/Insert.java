package SPL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Insert extends JFrame {

	private JPanel contentPane;
	private JTextField PLno;
	private JTextField PLname;
	private JTextField PLroad;
	private JTextField PLaddr;
	private JTextField PLcnt;
	private JTextField PLwOpen;
	private JTextField PLwClose;
	private JTextField PLsatOpen;
	private JTextField PLsatClose;
	private JTextField PLholOpen;
	private JTextField PLholClose;
	private JTextField PLnor;
	private JTextField PLnorpay;
	private JTextField PLaddtime;
	private JTextField PLaddPay;
	private JTextField PLdaytime;
	private JTextField PLdayPay;
	private JTextField PLmonthPay;
	private JTextField PLpayOpt;
	private JTextField PLspecial;
	private JTextField PLmName;
	private JTextField PLcall;
	private JTextField PLlat;
	private JTextField PLlon;
	private JTextField PLdata;
	private JTextField PLcode;
	private JTextField PLregData;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void InsertSQL(Connection mycon, String PLnodata ,String PLnamedata ,	int PLdivisondata ,	int PLtypedata , String PLroaddata , int PLdaydata,
						  String PLaddrdata , String PLcntdata , int PLworthdata , String PLopenDaydata , String PLwOpendata ,	String PLwClosedata ,
						  String PLsatOpendata , String PLsatClosedata , String PLholOpendata ,	String PLholClosedata ,	int PLpayinfodata ,	String PLnordata ,
						  String PLnorpaydata ,	String PLaddtimedata , String PLaddPaydata , String PLdaytimedata , String PLdayPaydata , String PLmonthPaydata ,
						  String PLpayOptdata ,	String PLspecialdata , String PLmNamedata ,	String PLcalldata ,	String PLlatdata , String PLlondata ,String PLDatadata ,
						  String PLcodedata ,  String PLregDatadata ,   int i)
	   {
	      try {
	    	  String sql = "INSERT INTO `PARKING_LOT_INFO`(`pliNo`, `pliName`, `pliType1`, `pliType2`, `pliCnt`, `pliWorth`, `pliDay`, `pliEtc`, `pliManageName`,"
	    	  				+ " `pliPH`, `pliLAT`, `pliLON`, `pliDate`, `pliRoadAddr`, `pliLandAddr`, `pliIsFree`, `pliDefaultTime`, `pliDefaultFee`, `pliAddTime`,"
	    	  				+ " `pliAddFee`, `pliDayTime`, `pliDayFee`, `pliMonthFee`, `pliPayType`, `pliDOW`, `pliWDStart`, `pliWDEnd`, `pliSatStart`, `pliSatEnd`,"
	    	  				+ " `pliHolStart`, `pliHolEnd`, `ploCode`, `pliRegDate`) "
	    	  				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    	  PreparedStatement pstmt = mycon.prepareStatement(sql);
	    	  pstmt.setString(1,PLnodata);
				pstmt.setString(2,PLnamedata);
				pstmt.setInt(3, PLdivisondata);
				pstmt.setInt(4,PLtypedata);
				pstmt.setString(5,PLcntdata);
				pstmt.setInt(6,PLworthdata);
				pstmt.setInt(7,PLdaydata);
				pstmt.setString(8,PLspecialdata);
				pstmt.setString(9,PLmNamedata);
				pstmt.setString(10,PLcalldata);
				pstmt.setString(11,PLlatdata);
				pstmt.setString(12,PLlondata);
				pstmt.setString(13,PLDatadata);
				pstmt.setString(14,PLroaddata);
				pstmt.setString(15,PLaddrdata);
				pstmt.setInt(16,PLpayinfodata);
				pstmt.setString(17,PLnordata);
				pstmt.setString(18,PLnorpaydata);
				pstmt.setString(19,PLaddtimedata);
				pstmt.setString(20,PLaddPaydata);
				pstmt.setString(21,PLdaytimedata);
				pstmt.setString(22,PLdayPaydata);
				pstmt.setString(23,PLmonthPaydata);
				pstmt.setString(24,PLpayOptdata);
				pstmt.setString(25,PLopenDaydata);
				pstmt.setString(26,PLwOpendata);
				pstmt.setString(27,PLwClosedata);
				pstmt.setString(28,PLsatOpendata);
				pstmt.setString(29,PLsatClosedata);
				pstmt.setString(30,PLholOpendata);
				pstmt.setString(31,PLholClosedata);
				pstmt.setString(32,PLcodedata);
				pstmt.setString(33,PLregDatadata);
	    	  int rs =pstmt.executeUpdate();
	    	  JOptionPane.showMessageDialog(null, "µ•¿Ã≈Õ∞° ª¿‘µ«æ˙Ω¿¥œ¥Ÿ.");
	      }catch (Exception e) {
	         // TODO: handle exception
	         System.out.println(e);
	         JOptionPane.showMessageDialog(null, e, "ø¿∑˘", JOptionPane.ERROR_MESSAGE);
	      }
	   }

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Insert() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cksgh\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\parking.jpg"));
		Connection mycon;
		String jdbcURL = "jdbc:mysql://remotemysql.com:3306/GjkEpxrZrT?useSSL=false";
		String id = "GjkEpxrZrT";
		String passwd = "am6q7iSXbm";
		mycon=DriverManager.getConnection(jdbcURL,id,passwd);
		Statement stmt = mycon.createStatement();		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PLnoLabel = new JLabel("\uC8FC\uCC28\uC7A5\uAD00\uB9AC\uBC88\uD638");
		PLnoLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLnoLabel.setBounds(14, 24, 116, 18);
		contentPane.add(PLnoLabel);
		
		PLno = new JTextField();
		PLno.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLno.setColumns(10);
		PLno.setBounds(166, 24, 355, 24);
		contentPane.add(PLno);
		
		JLabel PLnameLabel = new JLabel("\uC8FC\uCC28\uC7A5\uBA85");
		PLnameLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLnameLabel.setBounds(14, 57, 72, 18);
		contentPane.add(PLnameLabel);
		
		PLname = new JTextField();
		PLname.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLname.setColumns(10);
		PLname.setBounds(166, 57, 355, 24);
		contentPane.add(PLname);
		
		JLabel PLdivisonLabel = new JLabel("\uC8FC\uCC28\uC7A5\uAD6C\uBD84");
		PLdivisonLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdivisonLabel.setBounds(14, 90, 91, 18);
		contentPane.add(PLdivisonLabel);
		
		JComboBox PLdivison = new JComboBox();
		PLdivison.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLdivison.setMaximumRowCount(3);
		PLdivison.setModel(new DefaultComboBoxModel(new String[] {"∞¯øµ", "πŒøµ"}));
		PLdivison.setSelectedIndex(0);
		PLdivison.setBounds(166, 93, 57, 24);
		contentPane.add(PLdivison);
		
		JLabel PLtypeLabel = new JLabel("\uC8FC\uCC28\uC7A5\uC720\uD615");
		PLtypeLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLtypeLabel.setBounds(14, 123, 91, 18);
		contentPane.add(PLtypeLabel);
		
		JComboBox PLtype = new JComboBox();
		PLtype.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLtype.setMaximumRowCount(3);
		PLtype.setModel(new DefaultComboBoxModel(new String[] {"≥ÎªÛ", "≥Îø‹"}));
		PLtype.setSelectedIndex(0);
		PLtype.setBounds(166, 123, 57, 24);
		contentPane.add(PLtype);
		
		JLabel PLroadLabel = new JLabel("\uC18C\uC7AC\uC9C0\uB3C4\uB85C\uBA85");
		PLroadLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLroadLabel.setBounds(14, 156, 91, 18);
		contentPane.add(PLroadLabel);
		
		PLroad = new JTextField();
		PLroad.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLroad.setColumns(10);
		PLroad.setBounds(166, 156, 355, 24);
		contentPane.add(PLroad);
		
		JLabel PLaddrLabel = new JLabel("\uC18C\uC7AC\uC9C0\uC9C0\uBC88\uC8FC\uC18C");
		PLaddrLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLaddrLabel.setBounds(14, 189, 116, 18);
		contentPane.add(PLaddrLabel);
		
		PLaddr = new JTextField();
		PLaddr.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLaddr.setColumns(10);
		PLaddr.setBounds(166, 189, 355, 24);
		contentPane.add(PLaddr);
		
		JLabel PLcntLabel = new JLabel("\uC8FC\uCC28\uAD6C\uD68D\uC218");
		PLcntLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLcntLabel.setBounds(14, 222, 91, 18);
		contentPane.add(PLcntLabel);
		
		PLcnt = new JTextField();
		PLcnt.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLcnt.setColumns(10);
		PLcnt.setBounds(166, 222, 355, 24);
		contentPane.add(PLcnt);
		
		JLabel PLworthLabel = new JLabel("\uAE09\uC9C0\uAD6C\uBD84");
		PLworthLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLworthLabel.setBounds(14, 255, 72, 18);
		contentPane.add(PLworthLabel);
		
		JComboBox PLworth = new JComboBox();
		PLworth.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLworth.setMaximumRowCount(6);
		PLworth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "±‚≈∏"}));
		PLworth.setSelectedIndex(3);
		PLworth.setBounds(166, 252, 57, 24);
		contentPane.add(PLworth);
		
		JLabel PLdayLabel = new JLabel("\uBD80\uC81C\uC2DC\uD589\uAD6C\uBD84");
		PLdayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdayLabel.setBounds(14, 288, 104, 18);
		contentPane.add(PLdayLabel);
		
		JRadioButton PLdayOn = new JRadioButton("\uC2DC\uD589");
		PLdayOn.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		buttonGroup.add(PLdayOn);
		PLdayOn.setBounds(166, 284, 57, 27);
		contentPane.add(PLdayOn);
		
		JRadioButton PLdayOff = new JRadioButton("\uBBF8\uC2DC\uD589");
		PLdayOff.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		buttonGroup.add(PLdayOff);
		PLdayOff.setBounds(241, 284, 72, 27);
		contentPane.add(PLdayOff);
		
		JLabel PLopenDayLabel = new JLabel("\uC6B4\uC601\uC694\uC77C");
		PLopenDayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLopenDayLabel.setBounds(14, 321, 72, 18);
		contentPane.add(PLopenDayLabel);
		
		JComboBox PLopenDay = new JComboBox();
		PLopenDay.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLopenDay.setModel(new DefaultComboBoxModel(new String[] {"∆Ú¿œ", "≈‰ø‰¿œ", "∞¯»ﬁ¿œ", "∆Ú¿œ+≈‰ø‰¿œ", "∆Ú¿œ+∞¯»ﬁ¿œ", "≈‰ø‰¿œ+∞¯»ﬁ¿œ", "∆Ú¿œ+≈‰ø‰¿œ+∞¯»ﬁ¿œ"}));
		PLopenDay.setSelectedIndex(6);
		PLopenDay.setBounds(166, 319, 172, 24);
		contentPane.add(PLopenDay);
		
		JLabel PLwOpenLabel = new JLabel("\uD3C9\uC77C\uC6B4\uC601\uC2DC\uC791\uC2DC\uAC04");
		PLwOpenLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLwOpenLabel.setBounds(14, 354, 127, 18);
		contentPane.add(PLwOpenLabel);
		
		PLwOpen = new JTextField();
		PLwOpen.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLwOpen.setColumns(10);
		PLwOpen.setBounds(166, 354, 355, 24);
		contentPane.add(PLwOpen);
		
		JLabel PLwCloseLabel = new JLabel("\uD3C9\uC77C\uC6B4\uC601\uC885\uB8CC\uC2DC\uAC04");
		PLwCloseLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLwCloseLabel.setBounds(14, 384, 127, 18);
		contentPane.add(PLwCloseLabel);
		
		PLwClose = new JTextField();
		PLwClose.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLwClose.setColumns(10);
		PLwClose.setBounds(166, 384, 355, 24);
		contentPane.add(PLwClose);
		
		JLabel PLsatOpenLabel = new JLabel("\uD1A0\uC694\uC77C\uC6B4\uC601\uC2DC\uC791\uC2DC\uAC01");
		PLsatOpenLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLsatOpenLabel.setBounds(14, 414, 139, 18);
		contentPane.add(PLsatOpenLabel);
		
		PLsatOpen = new JTextField();
		PLsatOpen.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLsatOpen.setColumns(10);
		PLsatOpen.setBounds(166, 414, 355, 24);
		contentPane.add(PLsatOpen);
		
		JLabel PLsatCloseLabel = new JLabel("\uD1A0\uC694\uC77C\uC6B4\uC601\uC885\uB8CC\uC2DC\uAC01");
		PLsatCloseLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLsatCloseLabel.setBounds(14, 447, 139, 18);
		contentPane.add(PLsatCloseLabel);
		
		PLsatClose = new JTextField();
		PLsatClose.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLsatClose.setColumns(10);
		PLsatClose.setBounds(166, 447, 355, 24);
		contentPane.add(PLsatClose);
		
		JLabel PLholOpenLabel = new JLabel("\uACF5\uD734\uC77C\uC6B4\uC601\uC2DC\uC791\uC2DC\uAC01");
		PLholOpenLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLholOpenLabel.setBounds(14, 483, 139, 18);
		contentPane.add(PLholOpenLabel);
		
		PLholOpen = new JTextField();
		PLholOpen.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLholOpen.setColumns(10);
		PLholOpen.setBounds(166, 483, 355, 24);
		contentPane.add(PLholOpen);
		
		JLabel PLholCloseLabel = new JLabel("\uACF5\uD734\uC77C\uC6B4\uC601\uC885\uB8CC\uC2DC\uAC01");
		PLholCloseLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLholCloseLabel.setBounds(14, 513, 139, 18);
		contentPane.add(PLholCloseLabel);
		
		PLholClose = new JTextField();
		PLholClose.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLholClose.setColumns(10);
		PLholClose.setBounds(166, 513, 355, 24);
		contentPane.add(PLholClose);
		
		JLabel PLpayInfoLabel = new JLabel("\uC694\uAE08\uC815\uBCF4");
		PLpayInfoLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLpayInfoLabel.setBounds(553, 24, 72, 18);
		contentPane.add(PLpayInfoLabel);
		
		JCheckBox PLpayFree = new JCheckBox("\uBB34\uB8CC");
		PLpayFree.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLpayFree.setBounds(725, 20, 57, 27);
		contentPane.add(PLpayFree);
		
		JCheckBox PLpayCharge = new JCheckBox("\uC720\uB8CC");
		PLpayCharge.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLpayCharge.setBounds(788, 20, 57, 27);
		contentPane.add(PLpayCharge);
		
		JLabel PLnorLabel = new JLabel("\uC8FC\uCC28\uAE30\uBCF8\uC2DC\uAC04");
		PLnorLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLnorLabel.setBounds(553, 57, 104, 18);
		contentPane.add(PLnorLabel);
		
		PLnor = new JTextField();
		PLnor.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLnor.setColumns(10);
		PLnor.setBounds(725, 57, 355, 24);
		contentPane.add(PLnor);
		
		JLabel PLnorpayLabel = new JLabel("\uC8FC\uCC28\uAE30\uBCF8\uC694\uAE08");
		PLnorpayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLnorpayLabel.setBounds(553, 90, 104, 18);
		contentPane.add(PLnorpayLabel);
		
		PLnorpay = new JTextField();
		PLnorpay.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLnorpay.setColumns(10);
		PLnorpay.setBounds(725, 90, 355, 24);
		contentPane.add(PLnorpay);
		
		JLabel PLaddtimeLabel = new JLabel("\uCD94\uAC00\uB2E8\uC704\uC2DC\uAC04");
		PLaddtimeLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLaddtimeLabel.setBounds(553, 123, 104, 18);
		contentPane.add(PLaddtimeLabel);
		
		PLaddtime = new JTextField();
		PLaddtime.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLaddtime.setColumns(10);
		PLaddtime.setBounds(725, 123, 355, 24);
		contentPane.add(PLaddtime);
		
		JLabel PLaddPayLabel = new JLabel("\uCD94\uAC00\uB2E8\uC704\uC694\uAE08");
		PLaddPayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLaddPayLabel.setBounds(553, 156, 104, 18);
		contentPane.add(PLaddPayLabel);
		
		PLaddPay = new JTextField();
		PLaddPay.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLaddPay.setColumns(10);
		PLaddPay.setBounds(725, 156, 355, 24);
		contentPane.add(PLaddPay);
		
		JLabel PLdaytimeLabel = new JLabel("1\uC77C\uC8FC\uCC28\uAD8C\uC694\uAE08\uC801\uC6A9\uC2DC\uAC04");
		PLdaytimeLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdaytimeLabel.setBounds(553, 189, 159, 18);
		contentPane.add(PLdaytimeLabel);
		
		PLdaytime = new JTextField();
		PLdaytime.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLdaytime.setColumns(10);
		PLdaytime.setBounds(725, 189, 355, 24);
		contentPane.add(PLdaytime);
		
		JLabel PLdayPayLabel = new JLabel("1\uC77C\uC8FC\uCC28\uAD8C\uC694\uAE08");
		PLdayPayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdayPayLabel.setBounds(553, 222, 104, 18);
		contentPane.add(PLdayPayLabel);
		
		PLdayPay = new JTextField();
		PLdayPay.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLdayPay.setColumns(10);
		PLdayPay.setBounds(725, 222, 355, 24);
		contentPane.add(PLdayPay);
		
		JLabel PLmonthPayLabel = new JLabel("\uC6D4\uC815\uAE30\uAD8C\uC694\uAE08");
		PLmonthPayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLmonthPayLabel.setBounds(553, 256, 104, 18);
		contentPane.add(PLmonthPayLabel);
		
		PLmonthPay = new JTextField();
		PLmonthPay.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLmonthPay.setColumns(10);
		PLmonthPay.setBounds(725, 256, 355, 24);
		contentPane.add(PLmonthPay);
		
		JLabel PLpayOptLabel = new JLabel("\uACB0\uC81C\uBC29\uBC95");
		PLpayOptLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLpayOptLabel.setBounds(553, 290, 104, 18);
		contentPane.add(PLpayOptLabel);
		
		PLpayOpt = new JTextField();
		PLpayOpt.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLpayOpt.setColumns(10);
		PLpayOpt.setBounds(725, 290, 355, 24);
		contentPane.add(PLpayOpt);
		
		JLabel PLspecialLabel = new JLabel("\uD2B9\uAE30\uC0AC\uD56D");
		PLspecialLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLspecialLabel.setBounds(553, 323, 66, 18);
		contentPane.add(PLspecialLabel);
		
		PLspecial = new JTextField();
		PLspecial.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLspecial.setColumns(10);
		PLspecial.setBounds(725, 323, 355, 24);
		contentPane.add(PLspecial);
		
		JLabel PLmNameLabel = new JLabel("\uAD00\uB9AC\uAE30\uAD00\uBA85");
		PLmNameLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLmNameLabel.setBounds(553, 356, 84, 18);
		contentPane.add(PLmNameLabel);
		
		PLmName = new JTextField();
		PLmName.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLmName.setColumns(10);
		PLmName.setBounds(725, 356, 355, 24);
		contentPane.add(PLmName);
		
		JLabel PLcallLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		PLcallLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLcallLabel.setBounds(553, 389, 72, 18);
		contentPane.add(PLcallLabel);
		
		PLcall = new JTextField();
		PLcall.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLcall.setColumns(10);
		PLcall.setBounds(725, 389, 355, 24);
		contentPane.add(PLcall);
		
		JLabel PLlatLabel = new JLabel("\uC704\uB3C4");
		PLlatLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLlatLabel.setBounds(553, 422, 72, 18);
		contentPane.add(PLlatLabel);
		
		PLlat = new JTextField();
		PLlat.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLlat.setColumns(10);
		PLlat.setBounds(725, 422, 355, 24);
		contentPane.add(PLlat);
		
		JLabel PLlonLabel = new JLabel("\uACBD\uB3C4");
		PLlonLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLlonLabel.setBounds(553, 453, 72, 18);
		contentPane.add(PLlonLabel);
		
		PLlon = new JTextField();
		PLlon.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLlon.setColumns(10);
		PLlon.setBounds(725, 453, 355, 24);
		contentPane.add(PLlon);
		
		JLabel PLdataLabel = new JLabel("\uB370\uC774\uD130\uAE30\uC900");
		PLdataLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdataLabel.setBounds(553, 486, 84, 18);
		contentPane.add(PLdataLabel);
		
		PLdata = new JTextField();
		PLdata.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLdata.setColumns(10);
		PLdata.setBounds(725, 486, 355, 24);
		contentPane.add(PLdata);
		
		JLabel PLcodeLabel = new JLabel("\uC81C\uACF5\uAE30\uAD00\uCF54\uB4DC");
		PLcodeLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLcodeLabel.setBounds(553, 519, 104, 18);
		contentPane.add(PLcodeLabel);
		
		PLcode = new JTextField();
		PLcode.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLcode.setColumns(10);
		PLcode.setBounds(725, 519, 355, 24);
		contentPane.add(PLcode);
		
		
		
		JLabel PLlegDataLabel = new JLabel("\uB370\uC774\uD130 \uB4F1\uB85D \uC77C\uC790");
		PLlegDataLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLlegDataLabel.setBounds(553, 556, 127, 18);
		contentPane.add(PLlegDataLabel);
		
		PLregData = new JTextField();
		PLregData.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		PLregData.setColumns(10);
		PLregData.setBounds(725, 553, 355, 24);
		contentPane.add(PLregData);
		
		JButton Cheak = new JButton("\uD655\uC778");
		Cheak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					boolean sw=false;
					if(PLdayOn.isSelected()) {
						sw=true;
						if(PLpayFree.isSelected()) {
							sw=true;
							InsertSQL(mycon, PLno.getText(), PLname.getText(), PLdivison.getSelectedIndex(), PLtype.getSelectedIndex(), PLroad.getText(), 1, 
									  PLaddr.getText(), PLcnt.getText(), PLworth.getSelectedIndex(), (String)PLopenDay.getSelectedItem(), PLwOpen.getText(), PLwClose.getText(), 
									  PLsatOpen.getText(), PLsatClose.getText(), PLholOpen.getText(), PLholClose.getText(),1 , PLnor.getText(), PLnorpay.getText(), 
									  PLaddtime.getText(), PLaddPay.getText(), PLdaytime.getText(), PLdayPay.getText(), PLmonthPay.getText(), PLpayOpt.getText(), 
									  PLspecial.getText(), PLmName.getText(), PLcall.getText(), PLlat.getText(), PLlon.getText(), PLdata.getText(), PLcode.getText(), 
									  PLregData.getText(), 0);
							
						}
						else if(PLpayCharge.isSelected()){
							sw=true;
							InsertSQL(mycon, PLno.getText(), PLname.getText(), PLdivison.getSelectedIndex(), PLtype.getSelectedIndex(), PLroad.getText(), 1, 
									  PLaddr.getText(), PLcnt.getText(), PLworth.getSelectedIndex(), (String)PLopenDay.getSelectedItem(), PLwOpen.getText(), PLwClose.getText(), 
									  PLsatOpen.getText(), PLsatClose.getText(), PLholOpen.getText(), PLholClose.getText(),0 , PLnor.getText(), PLnorpay.getText(), 
									  PLaddtime.getText(), PLaddPay.getText(), PLdaytime.getText(), PLdayPay.getText(), PLmonthPay.getText(), PLpayOpt.getText(), 
									  PLspecial.getText(), PLmName.getText(), PLcall.getText(), PLlat.getText(), PLlon.getText(), PLdata.getText(), PLcode.getText(), 
									  PLregData.getText(), 0);
						}						
					}
					else if(PLdayOff.isSelected()){						
						sw=true;
						if(PLpayFree.isSelected()) {
							sw=true;
							InsertSQL(mycon, PLno.getText(), PLname.getText(), PLdivison.getSelectedIndex(), PLtype.getSelectedIndex(), PLroad.getText(), 0, 
									  PLaddr.getText(), PLcnt.getText(), PLworth.getSelectedIndex(), (String)PLopenDay.getSelectedItem(), PLwOpen.getText(), PLwClose.getText(), 
									  PLsatOpen.getText(), PLsatClose.getText(), PLholOpen.getText(), PLholClose.getText(),1 , PLnor.getText(), PLnorpay.getText(), 
									  PLaddtime.getText(), PLaddPay.getText(), PLdaytime.getText(), PLdayPay.getText(), PLmonthPay.getText(), PLpayOpt.getText(), 
									  PLspecial.getText(), PLmName.getText(), PLcall.getText(), PLlat.getText(), PLlon.getText(), PLdata.getText(), PLcode.getText(), 
									  PLregData.getText(), 0);
						}
						else if(PLpayCharge.isSelected()){
							sw=true;
							InsertSQL(mycon, PLno.getText(), PLname.getText(), PLdivison.getSelectedIndex(), PLtype.getSelectedIndex(), PLroad.getText(), 0, 
									  PLaddr.getText(), PLcnt.getText(), PLworth.getSelectedIndex(), (String)PLopenDay.getSelectedItem(), PLwOpen.getText(), PLwClose.getText(), 
									  PLsatOpen.getText(), PLsatClose.getText(), PLholOpen.getText(), PLholClose.getText(),0 , PLnor.getText(), PLnorpay.getText(), 
									  PLaddtime.getText(), PLaddPay.getText(), PLdaytime.getText(), PLdayPay.getText(), PLmonthPay.getText(), PLpayOpt.getText(), 
									  PLspecial.getText(), PLmName.getText(), PLcall.getText(), PLlat.getText(), PLlon.getText(), PLdata.getText(), PLcode.getText(), 
									  PLregData.getText(), 0);
						}						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}				
			}
		});
		Cheak.setFont(new Font("±º∏≤", Font.BOLD, 15));
		Cheak.setBounds(36, 564, 105, 27);
		contentPane.add(Cheak);
		
		JButton Cencel = new JButton("\uCDE8\uC18C");
		Cencel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		Cencel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		Cencel.setBounds(190, 564, 105, 27);
		contentPane.add(Cencel);
	}
}
