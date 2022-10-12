package SPL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class revise extends JFrame {

	private JPanel contentPane;
	private JTextField PLno;
	private JTextField PLname;
	private JTextField PLroad;
	private JTextField PLaddr;
	private JTextField PLcnt;
	private JTextField PLwOpen;
	private JTextField PLsatOpen;
	private JTextField PLsatClose;
	private JTextField PLholOpen;
	private JTextField PLholClose;
	private JTextField PLnor;
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
	
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField PLwClose;
	private JTextField PLnorpay;
	private JTextField PLregData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String plino=null;
					revise ri = new revise(plino);
					ri.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void UpdateSQL(Connection mycon, String PLnodata ,String PLnamedata , int PLdivisondata ,	int PLtypedata , String PLroaddata , int PLdaydata,
			  String PLaddrdata , String PLcntdata , int PLworthdata , String PLopenDaydata , String PLwOpendata ,	String PLwClosedata ,
			  String PLsatOpendata , String PLsatClosedata , String PLholOpendata ,	String PLholClosedata ,	int PLpayinfodata ,	String PLnordata ,
			  String PLnorpaydata ,	String PLaddtimedata , String PLaddPaydata , String PLdaytimedata , String PLdayPaydata , String PLmonthPaydata ,
			  String PLpayOptdata ,	String PLspecialdata , String PLmNamedata ,	String PLcalldata ,	String PLlatdata , String PLlondata ,String PLDatadata ,
			  String PLcodedata ,  String PLregDatadata ,   int i){
		try {
			String sql = "UPDATE, `PARKING_LOT_INFO` ,SET `pliNo` = ?, `pliName` = ?, `pliType1` = ?, `pliType2` = ?, `pliCnt` = ?, `pliWorth` = ?, `pliDay` = ?," + 
					"`pliEtc` = ?, `pliManageName` = ?, `pliPH` = ?, `pliLAT` = ?, `pliLON` = ?, `pliDate` = ?, `pliRoadAddr` = ?, `pliLandAddr` = ?, `pliIsFree` = ?," 
					+ "`pliDefaultTime` = ?, `pliDefaultFee` = ?, `pliAddTime` = ?, `pliAddFee` = ?, `pliDayTime` = ?, `pliDayFee` = ?, `pliMonthFee` = ?, "
					+ "`pliPayType` = ?, `pliDOW` = ?, `pliWDStart` = ?, `pliWDEnd` = ?, `pliSatStart` = ?, `pliSatEnd` = ?, `pliHolStart` = ?, `pliHolEnd` = ?, "
					+ "`ploCode` = ?, `pliRegDate` = ? where = '"+PLnodata+"'";
			PreparedStatement pstmt = mycon.prepareStatement(sql);
			pstmt.setString(1,PLnodata);
			pstmt.setString(2,PLnamedata);
			pstmt.setInt(3,PLdivisondata);
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
			JOptionPane.showMessageDialog(null, "µ•¿Ã≈Õ∞° ºˆ¡§µ«æ˙Ω¿¥œ¥Ÿ.");
		}catch (Exception e) {

			System.out.println(e);
			JOptionPane.showMessageDialog(null, e, "ø¿∑˘", JOptionPane.ERROR_MESSAGE);
		}
	}


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public revise(String plino) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cksgh\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\parking.jpg"));
		Connection mycon;
		String jdbcURL = "jdbc:mysql://remotemysql.com:3306/GjkEpxrZrT?useSSL=false";
		String id = "GjkEpxrZrT";
		String passwd = "am6q7iSXbm";
		mycon=DriverManager.getConnection(jdbcURL,id,passwd);
		Statement stmt = mycon.createStatement();		
		String sql="SELECT * FROM PARKING_LOT_INFO WHERE plino ='"+plino+"'";
		String sql2="SELECT * FROM PARKING_LOT_OFFER WHERE plino ='"+plino+"'";
		
		setTitle("S.P.L");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PLnoLabel = new JLabel("\uC8FC\uCC28\uC7A5\uAD00\uB9AC\uBC88\uD638");
		PLnoLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLnoLabel.setBounds(27, 12, 118, 18);
		contentPane.add(PLnoLabel);
		
		PLno = new JTextField();
		PLno.setBounds(179, 12, 355, 24);
		try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PLno.setText(rs.getString("pliNo"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}		
		contentPane.add(PLno);
		PLno.setColumns(10);
		
		JLabel PLnameLabel = new JLabel("\uC8FC\uCC28\uC7A5\uBA85");
		PLnameLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLnameLabel.setBounds(27, 45, 72, 18);
		contentPane.add(PLnameLabel);
		
		PLname = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLname.setText(rs.getString("pliName"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLname.setColumns(10);
		PLname.setBounds(179, 45, 355, 24);
		contentPane.add(PLname);
		
		JLabel PLdivisionLabel = new JLabel("\uC8FC\uCC28\uC7A5\uAD6C\uBD84");
		PLdivisionLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdivisionLabel.setBounds(27, 81, 91, 18);
		contentPane.add(PLdivisionLabel);
		
		JComboBox PLdivison = new JComboBox();
		PLdivison.setModel(new DefaultComboBoxModel(new String[] {"∞¯øµ", "πŒøµ"}));
		PLdivison.setSelectedIndex(1);
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int a = rs.getInt("pliType1");
				if(a==0) {
					PLdivison.setSelectedIndex(0);
				}
				else if(a==1) {
					PLdivison.setSelectedIndex(1);
				}
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLdivison.setBounds(179, 78, 57, 24);
		contentPane.add(PLdivison);
		
		JLabel PLtypeLabel = new JLabel("\uC8FC\uCC28\uC7A5\uC720\uD615");
		PLtypeLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLtypeLabel.setBounds(27, 111, 91, 18);
		contentPane.add(PLtypeLabel);	
		
		JComboBox PLtype = new JComboBox();
		PLtype.setModel(new DefaultComboBoxModel(new String[] {"≥ÎªÛ", "≥Îø‹"}));
		PLtype.setSelectedIndex(0);
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int a = rs.getInt("pliType2");
				if(a==0) {
					PLtype.setSelectedIndex(0);
				}
				else if(a==1) {
					PLtype.setSelectedIndex(1);
				}
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLtype.setBounds(179, 108, 57, 24);
		contentPane.add(PLtype);
		
		JLabel PLroadLabel = new JLabel("\uC18C\uC7AC\uC9C0\uB3C4\uB85C\uBA85");
		PLroadLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLroadLabel.setBounds(27, 144, 91, 18);
		contentPane.add(PLroadLabel);
		
		PLroad = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLroad.setText(rs.getString("pliRoadaddr"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLroad.setColumns(10);
		PLroad.setBounds(179, 144, 355, 24);
		contentPane.add(PLroad);
		
		JLabel PLaddrLabel = new JLabel("\uC18C\uC7AC\uC9C0\uC9C0\uBC88\uC8FC\uC18C");
		PLaddrLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLaddrLabel.setBounds(27, 177, 118, 18);
		contentPane.add(PLaddrLabel);
		
		PLaddr = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLaddr.setText(rs.getString("pliLandaddr"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLaddr.setColumns(10);
		PLaddr.setBounds(179, 177, 355, 24);
		contentPane.add(PLaddr);
		
		JLabel PLcntLabel = new JLabel("\uC8FC\uCC28\uAD6C\uD68D\uC218");
		PLcntLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLcntLabel.setBounds(27, 210, 84, 18);
		contentPane.add(PLcntLabel);
		
		PLcnt = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLcnt.setText(rs.getString("pliCnt"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLcnt.setColumns(10);
		PLcnt.setBounds(179, 210, 355, 24);
		contentPane.add(PLcnt);
		
		JLabel PLworthLabel = new JLabel("\uAE09\uC9C0\uAD6C\uBD84");
		PLworthLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLworthLabel.setBounds(27, 243, 72, 18);
		contentPane.add(PLworthLabel);
		
		JComboBox PLworth = new JComboBox();
		PLworth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "±‚≈∏"}));
		PLworth.setSelectedIndex(3);
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int a = rs.getInt("pliWorth");
				if(a==1) {
					PLworth.setSelectedIndex(0);
				}
				else if(a==2) {
					PLworth.setSelectedIndex(1);
				}
				else if(a==3) {
					PLworth.setSelectedIndex(2);
				}
				else if(a==4) {
					PLworth.setSelectedIndex(3);
				}
				else if(a==9) {
					PLworth.setSelectedIndex(4);
				}
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLworth.setBounds(179, 240, 57, 24);
		contentPane.add(PLworth);
		
		JLabel PLdayLabel = new JLabel("\uBD80\uC81C\uC2DC\uD589\uAD6C\uBD84");
		PLdayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdayLabel.setBounds(27, 276, 104, 18);
		contentPane.add(PLdayLabel);
		
		JRadioButton PLdayOn = new JRadioButton("\uC2DC\uD589");
		try {
			ResultSet rs=stmt.executeQuery(sql);			
			while(rs.next()) {
				int DType = rs.getInt("pliDay");				
				if (DType==1) {
					PLdayOn.setSelected(true);
				}
				else if(DType==0) {
					PLdayOn.setSelected(false);
				}
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		buttonGroup.add(PLdayOn);
		PLdayOn.setBounds(179, 272, 57, 27);
		contentPane.add(PLdayOn);
		
		JRadioButton PLdayOff = new JRadioButton("\uBBF8\uC2DC\uD589");
		try {
			ResultSet rs=stmt.executeQuery(sql);			
			while(rs.next()) {
				int DType = rs.getInt("pliDay");				
				if (DType==0) {
					PLdayOff.setSelected(true);
				}
				else if(DType==1) {
					PLdayOff.setSelected(false);
				}
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		buttonGroup.add(PLdayOff);
		PLdayOff.setBounds(254, 272, 72, 27);
		contentPane.add(PLdayOff);
		
		JLabel PLopenDayLabel = new JLabel("\uC6B4\uC601\uC694\uC77C");
		PLopenDayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLopenDayLabel.setBounds(27, 309, 72, 18);
		contentPane.add(PLopenDayLabel);
		
		JComboBox PLopenDay = new JComboBox();
		PLopenDay.setModel(new DefaultComboBoxModel(new String[] {"∆Ú¿œ", "≈‰ø‰¿œ", "∞¯»ﬁ¿œ", "∆Ú¿œ+≈‰ø‰¿œ", "∆Ú¿œ+∞¯»ﬁ¿œ", "≈‰ø‰¿œ+∞¯»ﬁ¿œ", "∆Ú¿œ+≈‰ø‰¿œ+∞¯»ﬁ¿œ"}));
		PLopenDay.setSelectedIndex(6);
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String day = rs.getString("pliDOW");
				String wday = "∆Ú¿œ";
				String sday = "≈‰ø‰¿œ";
				String hday = "∞¯»ﬁ¿œ";
				String wsday = "∆Ú¿œ+≈‰ø‰¿œ";
				String whday = "∆Ú¿œ+∞¯»ﬁ¿œ";
				String shday = "≈‰ø‰¿œ+∞¯»ﬁ¿œ";
				String allday = "∆Ú¿œ+≈‰ø‰¿œ+∞¯»ﬁ¿œ";
				if(day.equals(wday)) {
					PLopenDay.setSelectedIndex(0);
				}
				else if(day.equals(sday)) {
					PLopenDay.setSelectedIndex(1);
				}
				else if(day.equals(hday)) {
					PLopenDay.setSelectedIndex(2);
				}
				else if(day.equals(wsday)) {
					PLopenDay.setSelectedIndex(3);
				}
				else if(day.equals(whday)) {
					PLopenDay.setSelectedIndex(4);
				}
				else if(day.equals(shday)) {
					PLopenDay.setSelectedIndex(5);
				}
				else if(day.equals(allday)) {
					PLopenDay.setSelectedIndex(6);
				}
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLopenDay.setBounds(179, 307, 172, 24);
		contentPane.add(PLopenDay);
		
		PLwOpen = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLwOpen.setText(rs.getString("pliWDStart"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		
		JLabel PLwOpenLabel = new JLabel("\uD3C9\uC77C\uC6B4\uC601\uC2DC\uC791\uC2DC\uAC04");
		PLwOpenLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLwOpenLabel.setBounds(27, 342, 127, 18);
		contentPane.add(PLwOpenLabel);
		PLwOpen.setColumns(10);
		PLwOpen.setBounds(179, 342, 355, 24);
		contentPane.add(PLwOpen);
		
		JLabel PLwCloseLabel = new JLabel("\uD3C9\uC77C\uC6B4\uC601\uC885\uB8CC\uC2DC\uAC04");
		PLwCloseLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLwCloseLabel.setBounds(27, 372, 127, 18);
		contentPane.add(PLwCloseLabel);
		
		PLwClose = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLwClose.setText(rs.getString("pliWDEnd"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLwClose.setColumns(10);
		PLwClose.setBounds(179, 372, 355, 24);
		contentPane.add(PLwClose);
		
		JLabel PLsatOpenLabel = new JLabel("\uD1A0\uC694\uC77C\uC6B4\uC601\uC2DC\uC791\uC2DC\uAC01");
		PLsatOpenLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLsatOpenLabel.setBounds(27, 402, 139, 18);
		contentPane.add(PLsatOpenLabel);
		
		PLsatOpen = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLsatOpen.setText(rs.getString("pliSatStart"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLsatOpen.setColumns(10);
		PLsatOpen.setBounds(179, 402, 355, 24);
		contentPane.add(PLsatOpen);
		
		JLabel PLsatCloseLabel = new JLabel("\uD1A0\uC694\uC77C\uC6B4\uC601\uC885\uB8CC\uC2DC\uAC01");
		PLsatCloseLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLsatCloseLabel.setBounds(27, 435, 139, 18);
		contentPane.add(PLsatCloseLabel);
		
		PLsatClose = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLsatClose.setText(rs.getString("pliSatEnd"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLsatClose.setColumns(10);
		PLsatClose.setBounds(179, 435, 355, 24);
		contentPane.add(PLsatClose);
		
		JLabel PLholOpenLabel = new JLabel("\uACF5\uD734\uC77C\uC6B4\uC601\uC2DC\uC791\uC2DC\uAC01");
		PLholOpenLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLholOpenLabel.setBounds(27, 471, 139, 18);
		contentPane.add(PLholOpenLabel);
		
		PLholOpen = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLholOpen.setText(rs.getString("pliHolStart"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLholOpen.setColumns(10);
		PLholOpen.setBounds(179, 471, 355, 24);
		contentPane.add(PLholOpen);
		
		JLabel PLholCloseLabel = new JLabel("\uACF5\uD734\uC77C\uC6B4\uC601\uC885\uB8CC\uC2DC\uAC01");
		PLholCloseLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLholCloseLabel.setBounds(27, 501, 139, 18);
		contentPane.add(PLholCloseLabel);
		
		PLholClose = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLholClose.setText(rs.getString("pliHolEnd"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLholClose.setColumns(10);
		PLholClose.setBounds(179, 501, 355, 24);
		contentPane.add(PLholClose);
		
		JLabel PLpayInfoLabel = new JLabel("\uC694\uAE08\uC815\uBCF4");
		PLpayInfoLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLpayInfoLabel.setBounds(568, 12, 72, 18);
		contentPane.add(PLpayInfoLabel);
		
		JCheckBox PLpayFree = new JCheckBox("\uBB34\uB8CC");
		try {
			ResultSet rs=stmt.executeQuery(sql);			
			while(rs.next()) {
				int fType = rs.getInt("pliIsFree");				
				if (fType==1) {
					PLpayFree.setSelected(true);
				}
				else if(fType==0) {
					PLpayFree.setSelected(false);
				}
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		PLpayFree.setBounds(738, 8, 57, 27);
		contentPane.add(PLpayFree);
		
		JCheckBox PLpayCharge = new JCheckBox("\uC720\uB8CC");
		try {
			ResultSet rs=stmt.executeQuery(sql);			
			while(rs.next()) {
				int fType = rs.getInt("pliIsFree");	
				if (fType==0) {
					PLpayCharge.setSelected(true);
				}
				else if(fType==1) {
					PLpayCharge.setSelected(false);
				}
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		PLpayCharge.setBounds(801, 8, 57, 27);
		contentPane.add(PLpayCharge);
				
		JLabel PLnorLabel = new JLabel("\uC8FC\uCC28\uAE30\uBCF8\uC2DC\uAC04");
		PLnorLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLnorLabel.setBounds(568, 45, 104, 18);
		contentPane.add(PLnorLabel);
		
		PLnor = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLnor.setText(rs.getString("pliDefaultTime"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLnor.setColumns(10);
		PLnor.setBounds(738, 45, 355, 24);
		contentPane.add(PLnor);
		
		JLabel PLnorpayLabel = new JLabel("\uC8FC\uCC28\uAE30\uBCF8\uC694\uAE08");
		PLnorpayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLnorpayLabel.setBounds(568, 78, 104, 18);
		contentPane.add(PLnorpayLabel);
		
		PLnorpay = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLnorpay.setText(rs.getString("pliDefaultFee"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLnorpay.setColumns(10);
		PLnorpay.setBounds(738, 78, 355, 24);
		contentPane.add(PLnorpay);
		
		JLabel PLaddtimeLabel = new JLabel("\uCD94\uAC00\uB2E8\uC704\uC2DC\uAC04");
		PLaddtimeLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLaddtimeLabel.setBounds(568, 111, 104, 18);
		contentPane.add(PLaddtimeLabel);
		
		PLaddtime = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLaddtime.setText(rs.getString("pliAddTime"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLaddtime.setColumns(10);
		PLaddtime.setBounds(738, 111, 355, 24);
		contentPane.add(PLaddtime);
		
		JLabel PLaddPayLabel = new JLabel("\uCD94\uAC00\uB2E8\uC704\uC694\uAE08");
		PLaddPayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLaddPayLabel.setBounds(568, 144, 104, 18);
		contentPane.add(PLaddPayLabel);
		
		PLaddPay = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLaddPay.setText(rs.getString("pliAddFee"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLaddPay.setColumns(10);
		PLaddPay.setBounds(738, 144, 355, 24);
		contentPane.add(PLaddPay);
		
		JLabel PLdaytimeLabel = new JLabel("1\uC77C\uC8FC\uCC28\uAD8C\uC694\uAE08\uC801\uC6A9\uC2DC\uAC04");
		PLdaytimeLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdaytimeLabel.setBounds(568, 177, 159, 18);
		contentPane.add(PLdaytimeLabel);
		
		PLdaytime = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLdaytime.setText(rs.getString("pliDayTime"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLdaytime.setColumns(10);
		PLdaytime.setBounds(738, 177, 355, 24);
		contentPane.add(PLdaytime);
		
		JLabel PLdayPayLabel = new JLabel("1\uC77C\uC8FC\uCC28\uAD8C\uC694\uAE08");
		PLdayPayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdayPayLabel.setBounds(568, 210, 104, 18);
		contentPane.add(PLdayPayLabel);
				
		PLdayPay = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLdayPay.setText(rs.getString("pliDayFee"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLdayPay.setColumns(10);
		PLdayPay.setBounds(738, 210, 355, 24);
		contentPane.add(PLdayPay);
		
		JLabel PLmonthPayLabel = new JLabel("\uC6D4\uC815\uAE30\uAD8C\uC694\uAE08");
		PLmonthPayLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLmonthPayLabel.setBounds(568, 244, 104, 18);
		contentPane.add(PLmonthPayLabel);
		
		PLmonthPay = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLmonthPay.setText(rs.getString("pliMonthFee"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLmonthPay.setColumns(10);
		PLmonthPay.setBounds(738, 244, 355, 24);
		contentPane.add(PLmonthPay);
		
		JLabel PLpayOptLabel = new JLabel("\uACB0\uC81C\uBC29\uBC95");
		PLpayOptLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLpayOptLabel.setBounds(568, 278, 104, 18);
		contentPane.add(PLpayOptLabel);
		
		PLpayOpt = new JTextField();try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLpayOpt.setText(rs.getString("pliPayType"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLpayOpt.setColumns(10);
		PLpayOpt.setBounds(738, 278, 355, 24);
		contentPane.add(PLpayOpt);
		
		JLabel PLspecialLabel = new JLabel("\uD2B9\uAE30\uC0AC\uD56D");
		PLspecialLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLspecialLabel.setBounds(568, 311, 66, 18);
		contentPane.add(PLspecialLabel);
		
		PLspecial = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLspecial.setText(rs.getString("pliEtc"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLspecial.setColumns(10);
		PLspecial.setBounds(738, 311, 355, 24);
		contentPane.add(PLspecial);
		
		JLabel PLmNameLabel = new JLabel("\uAD00\uB9AC\uAE30\uAD00\uBA85");
		PLmNameLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLmNameLabel.setBounds(568, 344, 84, 18);
		contentPane.add(PLmNameLabel);
		
		PLmName = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLmName.setText(rs.getString("pliManageName"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLmName.setColumns(10);
		PLmName.setBounds(738, 344, 355, 24);
		contentPane.add(PLmName);
		
		JLabel PLcallLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		PLcallLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLcallLabel.setBounds(568, 377, 72, 18);
		contentPane.add(PLcallLabel);
		
		PLcall = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLcall.setText(rs.getString("pliPH"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLcall.setColumns(10);
		PLcall.setBounds(738, 377, 355, 24);
		contentPane.add(PLcall);
		
		JLabel PLlatLabel = new JLabel("\uC704\uB3C4");
		PLlatLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLlatLabel.setBounds(568, 410, 72, 18);
		contentPane.add(PLlatLabel);
		
		PLlat = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLlat.setText(rs.getString("pliLAT"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLlat.setColumns(10);
		PLlat.setBounds(738, 410, 355, 24);
		contentPane.add(PLlat);
		
		JLabel PLlonLabel = new JLabel("\uACBD\uB3C4");
		PLlonLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLlonLabel.setBounds(568, 441, 72, 18);
		contentPane.add(PLlonLabel);
		
		PLlon = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLlon.setText(rs.getString("pliLON"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLlon.setColumns(10);
		PLlon.setBounds(738, 441, 355, 24);
		contentPane.add(PLlon);
		
		JLabel PLdataLabel = new JLabel("\uB370\uC774\uD130\uAE30\uC900");
		PLdataLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLdataLabel.setBounds(568, 474, 84, 18);
		contentPane.add(PLdataLabel);
		
		
		PLdata = new JTextField();
		try{
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				PLdata.setText(rs.getString("pliDate"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLdata.setColumns(10);
		PLdata.setBounds(738, 474, 355, 24);
		contentPane.add(PLdata);
		
		JLabel PLcodeLabel = new JLabel("\uC81C\uACF5\uAE30\uAD00\uCF54\uB4DC");
		PLcodeLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLcodeLabel.setBounds(568, 507, 91, 18);
		contentPane.add(PLcodeLabel);
		
		PLcode = new JTextField();
		try{
			ResultSet rs1=stmt.executeQuery(sql2);
			while(rs1.next()) {
				PLcode.setText(rs1.getString("ploCode"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLcode.setColumns(10);
		PLcode.setBounds(738, 507, 355, 24);
		contentPane.add(PLcode);
		try{
			ResultSet rs1=stmt.executeQuery(sql2);
			while(rs1.next()) {
				PLcode.setText(rs1.getString("ploName"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		
		JButton Cheak = new JButton("\uD655\uC778");
		Cheak.setFont(new Font("±º∏≤", Font.BOLD, 15));
		Cheak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					
					if(PLdayOn.isSelected()) {
						
						if(PLpayFree.isSelected()) {
							
							UpdateSQL(mycon, PLno.getText(), PLname.getText(), PLdivison.getSelectedIndex(), PLtype.getSelectedIndex(), PLroad.getText(), 1, 
									  PLaddr.getText(), PLcnt.getText(), PLworth.getSelectedIndex(), (String)PLopenDay.getSelectedItem(), PLwOpen.getText(), PLwClose.getText(), 
									  PLsatOpen.getText(), PLsatClose.getText(), PLholOpen.getText(), PLholClose.getText(),1 , PLnor.getText(), PLnorpay.getText(), 
									  PLaddtime.getText(), PLaddPay.getText(), PLdaytime.getText(), PLdayPay.getText(), PLmonthPay.getText(), PLpayOpt.getText(), 
									  PLspecial.getText(), PLmName.getText(), PLcall.getText(), PLlat.getText(), PLlon.getText(), PLdata.getText(), PLcode.getText(), 
									  PLregData.getText(), 0);
							
						}
						else if(PLpayCharge.isSelected()){
						
							UpdateSQL(mycon, PLno.getText(), PLname.getText(), PLdivison.getSelectedIndex(), PLtype.getSelectedIndex(), PLroad.getText(), 1, 
									  PLaddr.getText(), PLcnt.getText(), PLworth.getSelectedIndex(), (String)PLopenDay.getSelectedItem(), PLwOpen.getText(), PLwClose.getText(), 
									  PLsatOpen.getText(), PLsatClose.getText(), PLholOpen.getText(), PLholClose.getText(),0 , PLnor.getText(), PLnorpay.getText(), 
									  PLaddtime.getText(), PLaddPay.getText(), PLdaytime.getText(), PLdayPay.getText(), PLmonthPay.getText(), PLpayOpt.getText(), 
									  PLspecial.getText(), PLmName.getText(), PLcall.getText(), PLlat.getText(), PLlon.getText(), PLdata.getText(), PLcode.getText(), 
									  PLregData.getText(), 0);
						}						
					}
					else if(PLdayOff.isSelected()){						
					
						if(PLpayFree.isSelected()) {
						
							UpdateSQL(mycon, PLno.getText(), PLname.getText(), PLdivison.getSelectedIndex(), PLtype.getSelectedIndex(), PLroad.getText(), 0, 
									  PLaddr.getText(), PLcnt.getText(), PLworth.getSelectedIndex(), (String)PLopenDay.getSelectedItem(), PLwOpen.getText(), PLwClose.getText(), 
									  PLsatOpen.getText(), PLsatClose.getText(), PLholOpen.getText(), PLholClose.getText(),1 , PLnor.getText(), PLnorpay.getText(), 
									  PLaddtime.getText(), PLaddPay.getText(), PLdaytime.getText(), PLdayPay.getText(), PLmonthPay.getText(), PLpayOpt.getText(), 
									  PLspecial.getText(), PLmName.getText(), PLcall.getText(), PLlat.getText(), PLlon.getText(), PLdata.getText(), PLcode.getText(), 
									  PLregData.getText(), 0);
						}
						else if(PLpayCharge.isSelected()){
						
							UpdateSQL(mycon, PLno.getText(), PLname.getText(), PLdivison.getSelectedIndex(), PLtype.getSelectedIndex(), PLroad.getText(), 0, 
									  PLaddr.getText(), PLcnt.getText(), PLworth.getSelectedIndex(), (String)PLopenDay.getSelectedItem(), PLwOpen.getText(), PLwClose.getText(), 
									  PLsatOpen.getText(), PLsatClose.getText(), PLholOpen.getText(), PLholClose.getText(),0 , PLnor.getText(), PLnorpay.getText(), 
									  PLaddtime.getText(), PLaddPay.getText(), PLdaytime.getText(), PLdayPay.getText(), PLmonthPay.getText(), PLpayOpt.getText(), 
									  PLspecial.getText(), PLmName.getText(), PLcall.getText(), PLlat.getText(), PLlon.getText(), PLdata.getText(), PLcode.getText(), 
									  PLregData.getText(), 0);
						}						
					}
				} catch (Exception exception) {
					// TODO: handle exception
				}				
			
			}
		});
		
		JLabel PLlegDataLabel = new JLabel("\uB370\uC774\uD130 \uB4F1\uB85D \uC77C\uC790");
		PLlegDataLabel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		PLlegDataLabel.setBounds(568, 543, 127, 18);
		contentPane.add(PLlegDataLabel);
		
		PLregData = new JTextField();
		try{
			ResultSet rs1=stmt.executeQuery(sql2);
			while(rs1.next()) {
				PLregData.setText(rs1.getString("ploRegdate"));
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		PLregData.setColumns(10);
		PLregData.setBounds(738, 541, 355, 24);
		contentPane.add(PLregData);
		Cheak.setBounds(49, 552, 105, 27);
		contentPane.add(Cheak);
		
		JButton Cencel = new JButton("\uCDE8\uC18C");
		Cencel.setFont(new Font("±º∏≤", Font.BOLD, 15));
		Cencel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				//ri.dispose();
			}
		});
		Cencel.setBounds(203, 552, 105, 27);
		contentPane.add(Cencel);		
	}
}
