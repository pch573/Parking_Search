package SPL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					int index=1;
					admin frame = new admin(index);
					frame.setVisible(true);
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
	public admin(int idx) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cksgh\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\parking.jpg"));
		setTitle("관리자모드");
		Connection mycon;
		String jdbcURL = "jdbc:mysql://remotemysql.com:3306/GjkEpxrZrT?useSSL=false";
		String id = "GjkEpxrZrT";
		String passwd = "am6q7iSXbm";
		mycon=DriverManager.getConnection(jdbcURL,id,passwd);
		Statement stmt = mycon.createStatement();
		
		String tisql="select * from MEMBER where mIdx="+idx;
		ResultSet tirs=stmt.executeQuery(tisql);
		if(tirs.next()) {
		if(tirs.getInt("mLevel")==1) {
			setTitle("사용자모드");
		}
		else {
			setTitle("관리자모드");
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1307, 790);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("지역");
		lblNewLabel.setBounds(87, 30, 65, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("요금");
		lblNewLabel_1.setBounds(87, 127, 56, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("요일");
		lblNewLabel_2.setBounds(87, 79, 65, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("주차장명");
		lblNewLabel_3.setBounds(87, 179, 65, 15);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(151, 27, 298, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 176, 298, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("전체");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(151, 123, 78, 23);
		rdbtnNewRadioButton_3.setSelected(true);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("유료");
		buttonGroup.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(233, 123, 73, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("무료");
		buttonGroup.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setBounds(319, 123, 73, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 252, 508, 470);
		contentPane.add(scrollPane);
		
		String rowCount[]= {"번호", "주차장명", "주소", "유료/무료", "1시간당 요금"};
		Object columnNames[][]= {};
		DefaultTableModel model = new DefaultTableModel(columnNames, rowCount) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		table = new JTable(model);

		TableRowSorter sorter = new TableRowSorter(model);
		table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(4).setPreferredWidth(94);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_24 = new JLabel("리스트 수: ");
		lblNewLabel_24.setBounds(444, 222, 148, 15);
		contentPane.add(lblNewLabel_24);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("평일");
		chckbxNewCheckBox.setBounds(151, 75, 78, 23);
		chckbxNewCheckBox.setSelected(true);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("토요일");
		chckbxNewCheckBox_1.setBounds(233, 75, 78, 23);
		chckbxNewCheckBox_1.setSelected(true);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("공휴일");
		chckbxNewCheckBox_2.setBounds(319, 75, 73, 23);
		chckbxNewCheckBox_2.setSelected(true);
		contentPane.add(chckbxNewCheckBox_2);
		
		JButton button = new JButton("검색");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int wd=0;
				if(chckbxNewCheckBox.isSelected()) {
					wd=1;
				}
				if(chckbxNewCheckBox_1.isSelected()) {
					wd=2;
				}
				if(chckbxNewCheckBox_2.isSelected()) {
					wd=3;
				}
				if(chckbxNewCheckBox.isSelected() && chckbxNewCheckBox_1.isSelected()) {
					wd=4;
				}
				if(chckbxNewCheckBox.isSelected() && chckbxNewCheckBox_2.isSelected()) {
					wd=5;
				}
				if(chckbxNewCheckBox_1.isSelected() && chckbxNewCheckBox_2.isSelected()) {
					wd=6;
				}
				if(chckbxNewCheckBox.isSelected() && chckbxNewCheckBox_1.isSelected() && chckbxNewCheckBox_2.isSelected()) {
					wd=7;
				}
				model.setRowCount(0);
				String adrs=textField.getText();
				String name=textField_1.getText();
				String sql="";
				if(wd==1) {
				if(rdbtnNewRadioButton_3.isSelected()) {
					sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
							+ "(`pliDOW`='평일')";
				}
				if(rdbtnNewRadioButton_4.isSelected()) {
					sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
							+ "(`pliDOW`='평일') AND `pliIsFree`= 0";
					}
				if(rdbtnNewRadioButton_5.isSelected()) {
					sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
							+ "(`pliDOW`='평일') AND `pliIsFree`= 1";
					}
				}
				if(wd==2) {
					if(rdbtnNewRadioButton_3.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='토요일')";
					}
					if(rdbtnNewRadioButton_4.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='토요일') AND `pliIsFree`= 0";
						}
					if(rdbtnNewRadioButton_5.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='토요일') AND `pliIsFree`= 1";
						}
					}
				if(wd==3) {
					if(rdbtnNewRadioButton_3.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='공휴일')";
					}
					if(rdbtnNewRadioButton_4.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='공휴일') AND `pliIsFree`= 0";
						}
					if(rdbtnNewRadioButton_5.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='공휴일') AND `pliIsFree`= 1";
						}
					}
				if(wd==4) {
					if(rdbtnNewRadioButton_3.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='평일+토요일' OR `pliDOW`='토요일' OR `pliDOW`='평일')";
					}
					if(rdbtnNewRadioButton_4.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='평일+토요일' OR `pliDOW`='토요일' OR `pliDOW`='평일') AND `pliIsFree`= 0";
						}
					if(rdbtnNewRadioButton_5.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='평일+토요일' OR `pliDOW`='토요일' OR `pliDOW`='평일') AND `pliIsFree`= 1";
						}
					}
				if(wd==5) {
					if(rdbtnNewRadioButton_3.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='평일+공휴일' OR `pliDOW`='공휴일' OR `pliDOW`='평일')";
					}
					if(rdbtnNewRadioButton_4.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='평일+공휴일' OR `pliDOW`='공휴일' OR `pliDOW`='평일') AND `pliIsFree`= 0";
						}
					if(rdbtnNewRadioButton_5.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='평일+공휴일' OR `pliDOW`='공휴일' OR `pliDOW`='평일') AND `pliIsFree`= 1";
						}
					}
				if(wd==6) {
					if(rdbtnNewRadioButton_3.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='토요일+공휴일' OR `pliDOW`='공휴일' OR `pliDOW`='토요일')";
					}
					if(rdbtnNewRadioButton_4.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='토요일+공휴일' OR `pliDOW`='공휴일' OR `pliDOW`='토요일') AND `pliIsFree`= 0";
						}
					if(rdbtnNewRadioButton_5.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='토요일+공휴일' OR `pliDOW`='공휴일' OR `pliDOW`='토요일') AND `pliIsFree`= 1";
						}
					}
				if(wd==7) {
					if(rdbtnNewRadioButton_3.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='평일+토요일+공휴일' OR `pliDOW`='토요일+공휴일' OR `pliDOW`='공휴일' OR `pliDOW`='토요일' OR `pliDOW`='평일' OR `pliDOW`='평일+공휴일' OR `pliDOW`='평일+토요일')";
					}
					if(rdbtnNewRadioButton_4.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='평일+토요일+공휴일' OR `pliDOW`='토요일+공휴일' OR `pliDOW`='공휴일' OR `pliDOW`='토요일' OR `pliDOW`='평일' OR `pliDOW`='평일+공휴일' OR `pliDOW`='평일+토요일') AND `pliIsFree`= 0";
						}
					if(rdbtnNewRadioButton_5.isSelected()) {
						sql="SELECT * FROM PARKING_LOT_INFO WHERE (`pliLandAddr` LIKE '%"+adrs+"%' OR `pliRoadAddr` LIKE '%"+adrs+"%') AND `pliName` LIKE '%"+name+"%' AND "
								+ "(`pliDOW`='평일+토요일+공휴일' OR `pliDOW`='토요일+공휴일' OR `pliDOW`='공휴일' OR `pliDOW`='토요일' OR `pliDOW`='평일' OR `pliDOW`='평일+공휴일' OR `pliDOW`='평일+토요일') AND `pliIsFree`= 1";
						}
					}
				try {
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						if(rs.getInt("pliIsFree")==0) {
							model.addRow(new Object[] {rs.getString("pliNo"),rs.getString("pliName"),rs.getString("pliRoadAddr"),"유료",rs.getInt("pliDefaultFee")});
					}
					else {
							model.addRow(new Object[] {rs.getString("pliNo"),rs.getString("pliName"),rs.getString("pliRoadAddr"),"무료",rs.getInt("pliDefaultFee")});
						}
						}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				int rows= table.getRowCount();
				lblNewLabel_24.setText("리스트 수: " + rows);
			}
		});
		
		button.setBounds(87, 218, 97, 23);
		contentPane.add(button);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(682, 10, 567, 691);
		contentPane.add(layeredPane);
		layeredPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "세부사항", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(24, 275, 347, 188);
		layeredPane.add(layeredPane_1);
		layeredPane_1.setBorder(new TitledBorder(null, "요금정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBounds(24, 487, 347, 130);
		layeredPane.add(layeredPane_2);
		layeredPane_2.setBorder(new TitledBorder(null, "운영 시간 정보", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_4 = new JLabel("최근 수정일 : ");
		lblNewLabel_4.setBounds(31, 36, 288, 15);
		layeredPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_23 = new JLabel(" ");
		lblNewLabel_23.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_23.setBounds(31, 61, 347, 35);
		layeredPane.add(lblNewLabel_23);
		
		JLabel lblNewLabel_5 = new JLabel("고유 관리번호 : ");
		lblNewLabel_5.setBounds(31, 106, 288, 15);
		layeredPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("주차 구획 수 : ");
		lblNewLabel_6.setBounds(31, 131, 142, 15);
		layeredPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("차량 부제 시행 구분 :");
		lblNewLabel_7.setBounds(31, 156, 423, 15);
		layeredPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("관리 기관명 : ");
		lblNewLabel_8.setBounds(31, 181, 503, 15);
		layeredPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("전화 번호 : ");
		lblNewLabel_9.setBounds(31, 206, 347, 15);
		layeredPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("도로명 주소 : ");
		lblNewLabel_10.setBounds(31, 231, 477, 15);
		layeredPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_22 = new JLabel("지번 주소 : ");
		lblNewLabel_22.setBounds(31, 256, 488, 15);
		layeredPane.add(lblNewLabel_22);
		
		JLabel lblNewLabel_11 = new JLabel("유/무료 구분 : ");
		lblNewLabel_11.setBounds(12, 31, 209, 15);
		layeredPane_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("기본 30분에 ");
		lblNewLabel_12.setBounds(12, 56, 209, 15);
		layeredPane_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("추가 10분당 ");
		lblNewLabel_13.setBounds(12, 81, 209, 15);
		layeredPane_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("1일 주차권 요금 : ");
		lblNewLabel_14.setBounds(12, 106, 209, 15);
		layeredPane_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("1달 주차권 요금 : ");
		lblNewLabel_15.setBounds(12, 131, 209, 15);
		layeredPane_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("결제 유형 : ");
		lblNewLabel_16.setBounds(12, 156, 223, 15);
		layeredPane_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("운영 요일 : ");
		lblNewLabel_17.setBounds(12, 25, 323, 15);
		layeredPane_2.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("평일 운영 시간 : ");
		lblNewLabel_18.setBounds(12, 50, 323, 15);
		layeredPane_2.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("토요일 운영 시간 : ");
		lblNewLabel_19.setBounds(12, 75, 323, 15);
		layeredPane_2.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("공휴일 운영 시간 : ");
		lblNewLabel_20.setBounds(12, 100, 323, 15);
		layeredPane_2.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("기타 사항 : ");
		lblNewLabel_21.setBounds(31, 642, 503, 15);
		layeredPane.add(lblNewLabel_21);
		
		
		String sql="select * from MEMBER where mIdx="+idx;
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()) {
		if(rs.getInt("mLevel")==1) {
			JButton btnNewButton_1 = new JButton("수정");
			btnNewButton_1.setBounds(495, 75, 97, 23);
			btnNewButton_1.setVisible(false);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("삽입");
			btnNewButton_2.setBounds(495, 123, 97, 23);
			btnNewButton_2.setVisible(false);
			contentPane.add(btnNewButton_2);
			
			JButton btnNewButton = new JButton("삭제");
			btnNewButton.setBounds(495, 26, 97, 23);
			btnNewButton.setVisible(false);
			contentPane.add(btnNewButton);
		}
		else {
			JButton btnNewButton_1 = new JButton("수정");
			btnNewButton_1.setBounds(495, 75, 97, 23);
			btnNewButton_1.setVisible(true);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String update=(String) table.getValueAt(table.getSelectedRow(), 0);
					String upsql="select * from PARKING_LOT_INFO where pliNo='"+update+"'";
					try {
						ResultSet uprs=stmt.executeQuery(upsql);
					    while(uprs.next()) {
					    String reindex=uprs.getString("pliNo");
						revise re=new revise(reindex);
						re.setVisible(true);
						} 
					    } catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("삽입");
			btnNewButton_2.setBounds(495, 123, 97, 23);
			btnNewButton_2.setVisible(true);
			contentPane.add(btnNewButton_2);
			
			JButton btnNewButton = new JButton("삭제");
			btnNewButton.setBounds(495, 26, 97, 23);
			btnNewButton.setVisible(true);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null,"정말 삭제하시겠습니까?","삭제창",JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {
						String delete=(String) table.getValueAt(table.getSelectedRow(), 0);
						String delsql="delete from PARKING_LOT_INFO where pliNo=?";
						try {
							PreparedStatement pstmt = mycon.prepareStatement(delsql);
							pstmt.setString(1,delete);
							pstmt.executeUpdate();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int row=table.getSelectedRow();
						if(row>=0) {
							DefaultTableModel del=(DefaultTableModel)table.getModel();
					        del.removeRow(row);
							}
						int rows= table.getRowCount();
						lblNewLabel_24.setText("리스트 수: " + rows);
						}
					else {
					}
				}
			});
			contentPane.add(btnNewButton);
		}
		}

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {	
				String str=null;
				if(table.getSelectedRow()>-1) {	
					str=(String) table.getValueAt(table.getSelectedRow(), 0);
				}
				String sql1="select * from PARKING_LOT_INFO where pliNo='"+str+"'";
				try {
					ResultSet rs1=stmt.executeQuery(sql1);
					if(rs1.next()) {
					lblNewLabel_4.setText("최근 수정일 : "+rs1.getString("pliDate"));
					}
					ResultSet rs20 = stmt.executeQuery(sql1);
					if(rs20.next()) {
						lblNewLabel_23.setText(rs20.getString("pliName"));
						}
					ResultSet rs2=stmt.executeQuery(sql1);
					if(rs2.next()) {
					lblNewLabel_5.setText("고유 관리번호 : "+rs2.getString("pliNo"));
					}
					ResultSet rs3=stmt.executeQuery(sql1);
					if(rs3.next()) {
					lblNewLabel_6.setText("주차 구획 수 : "+rs3.getString("pliCnt"));
					}
					ResultSet rs4=stmt.executeQuery(sql1);
					if(rs4.next()) {
						if(rs4.getInt("pliDay")==0) {
							lblNewLabel_7.setText("차량 부제 시행 구분 : 미시행");
						}
						else {
							lblNewLabel_7.setText("차량 부제 시행 구분 : 요일제");
						}
					}
					ResultSet rs5=stmt.executeQuery(sql1);
					if(rs5.next()) {
					lblNewLabel_8.setText("관리 기관명 : "+rs5.getString("pliManageName"));
					}
					ResultSet rs6=stmt.executeQuery(sql1);
					if(rs6.next()) {
					lblNewLabel_9.setText("전화 번호 : "+rs6.getString("pliPH"));
					}
					ResultSet rs7=stmt.executeQuery(sql1);
					if(rs7.next()) {
					lblNewLabel_10.setText("도로명 주소 : "+rs7.getString("pliRoadAddr"));
					}
					ResultSet rs8=stmt.executeQuery(sql1);
					if(rs8.next()) {
					lblNewLabel_22.setText("지번 주소 : "+rs8.getString("pliLandAddr"));
					}
					ResultSet rs9=stmt.executeQuery(sql1);
					if(rs9.next()) {
						if(rs9.getInt("pliIsFree")==0) {
							lblNewLabel_11.setText("유/무료 구분 : 유료");
						}
						else{
							lblNewLabel_11.setText("유/무료 구분 : 무료");
						}
					}
					ResultSet rs10=stmt.executeQuery(sql1);
					if(rs10.next()) {
					lblNewLabel_12.setText("기본 30분에 "+rs10.getString("pliDefaultFee")+"원");
					}
					ResultSet rs11=stmt.executeQuery(sql1);
					if(rs11.next()) {
					lblNewLabel_13.setText("추가 10분당 "+rs11.getString("pliAddFee")+"원");
					}
					ResultSet rs12=stmt.executeQuery(sql1);
					if(rs12.next()) {
					lblNewLabel_14.setText("1일 주차권 요금 : "+rs12.getString("pliDayFee"));
					}
					ResultSet rs13=stmt.executeQuery(sql1);
					if(rs13.next()) {
					lblNewLabel_15.setText("1달 주차권 요금 : "+rs13.getString("pliMonthFee"));
					}
					ResultSet rs14=stmt.executeQuery(sql1);
					if(rs14.next()) {
					lblNewLabel_16.setText("결제 유형 : "+rs14.getString("pliPayType"));
					}
					ResultSet rs15=stmt.executeQuery(sql1);
					if(rs15.next()) {
					lblNewLabel_17.setText("운영 요일 : "+rs15.getString("pliDOW"));
					}
					ResultSet rs16=stmt.executeQuery(sql1);
					if(rs16.next()) {
					lblNewLabel_18.setText("평일 운영 시간 : "+rs16.getString("pliWDStart")+"~"+rs16.getString("pliWDEnd"));
					}
					ResultSet rs17=stmt.executeQuery(sql1);
					if(rs17.next()) {
					lblNewLabel_19.setText("토요일 운영 시간 : "+rs17.getString("pliSatStart")+"~"+rs17.getString("pliSatEnd"));
					}
					ResultSet rs18=stmt.executeQuery(sql1);
					if(rs18.next()) {
					lblNewLabel_20.setText("공휴일 운영 시간 : "+rs18.getString("pliHolStart")+"~"+rs18.getString("pliHolEnd"));
					}
					ResultSet rs19=stmt.executeQuery(sql1);
					if(rs19.next()) {
					lblNewLabel_21.setText("기타 사항 : "+rs19.getString("pliEtc"));
					}
					
					
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			} 
		});
	}
}
