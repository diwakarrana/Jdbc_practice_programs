import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GuiSecondAppMetaData {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ResultSet rs ;
	private JTextField textField_5;
	private Connection con ;
	private PreparedStatement ps1;
	private PreparedStatement ps2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiSecondAppMetaData window = new GuiSecondAppMetaData();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiSecondAppMetaData() {
		initialize();
		jdbc();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(200, 200, 943, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Example");
		
		JLabel lblStudentNumber = new JLabel("Student Number :-");
		lblStudentNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentNumber.setBounds(44, 52, 129, 23);
		frame.getContentPane().add(lblStudentNumber);
		
		JLabel lblStudentName = new JLabel("Student Name :-");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStudentName.setBounds(44, 86, 129, 23);
		frame.getContentPane().add(lblStudentName);
		
		JLabel lblM = new JLabel("M1:-");
		lblM.setFont(lblM.getFont().deriveFont(16f));
		lblM.setBounds(44, 131, 46, 14);
		frame.getContentPane().add(lblM);
		
		JLabel lblM_1 = new JLabel("M2:-");
		lblM_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblM_1.setBounds(44, 156, 46, 14);
		frame.getContentPane().add(lblM_1);
		
		JLabel lblM_2 = new JLabel("M3:-");
		lblM_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblM_2.setBounds(44, 181, 46, 14);
		frame.getContentPane().add(lblM_2);
		//........................................................................................
		JButton btnPrev = new JButton("Prev");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEditableFalse();
				try {
					if(!rs.isFirst()) {
						textField_5.setText(" ");
					rs.previous();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					textField_3.setText(rs.getString(4));
					textField_4.setText(rs.getString(5));
					} else {
						textField_5.setText("this is first record");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnPrev.setBounds(34, 206, 89, 23);
		frame.getContentPane().add(btnPrev);
		//........................................................................................
		JButton btnFirst = new JButton("first");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEditableFalse();
				try {
					textField_5.setText(" ");
				rs.first();
				textField.setText(rs.getString(1));
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_4.setText(rs.getString(5));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnFirst.setBounds(229, 206, 89, 23);
		frame.getContentPane().add(btnFirst);
		//........................................................................................
		JButton btnLast = new JButton("last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEditableFalse();
				try {
						textField_5.setText(" ");
					rs.last();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					textField_3.setText(rs.getString(4));
					textField_4.setText(rs.getString(5));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLast.setBounds(328, 206, 89, 23);
		frame.getContentPane().add(btnLast);
		//........................................................................................
		JButton btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEditableFalse();
				try {
					if(!rs.isLast()) {
						textField_5.setText(" ");
					rs.next();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					textField_3.setText(rs.getString(4));
					textField_4.setText(rs.getString(5));
					} else {
						textField_5.setText("this is last record");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		});
		btnNext.setBounds(130, 206, 89, 23);
		frame.getContentPane().add(btnNext);
		
		textField = new JTextField();
		textField.setForeground(Color.blue);
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(186, 55, 164, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.blue);
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(186, 89, 164, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.blue);
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(186, 130, 164, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.blue);
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(186, 155, 164, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.blue);
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(186, 180, 164, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.RED);
		textField_5.setEditable(false);
		textField_5.setBounds(44, 21, 348, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnFillData = new JButton("Fill Data");
		btnFillData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField_1.setEditable(true);
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				textField_4.setEditable(true);
				
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				
			}
		});
		btnFillData.setBounds(34, 252, 89, 23);
		frame.getContentPane().add(btnFillData);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Integer sno = Integer.parseInt(textField.getText());
					String name = textField_1.getText();
					Integer m1 = Integer.parseInt(textField_2.getText());
					Integer m2 = Integer.parseInt(textField_3.getText());
					Integer m3 = Integer.parseInt(textField_4.getText());
					String query = "insert into student (sno, name, m1, m2, m3) values("+sno+","+"'"+name+"'"+","+m1+","+m2+","+m3+")";
					ps2 = con.prepareStatement(query);
					int result = ps2.executeUpdate();
					if(result !=0) {
						textField_5.setText("Data is inserted successfully ");
					}else {
						textField_5.setText("something went wrong ");
					}
					
				}catch (NumberFormatException e) {
					textField_5.setText("Data is not properly filled up");
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInsert.setBounds(130, 252, 89, 23);
		frame.getContentPane().add(btnInsert);
		
		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField_1.setEditable(true);
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				textField_4.setEditable(true);
				
			}
		});
		btnEdit.setBounds(328, 252, 89, 23);
		frame.getContentPane().add(btnEdit);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Integer sno = Integer.parseInt(textField.getText());
					String name = textField_1.getText();
					Integer m1 = Integer.parseInt(textField_2.getText());
					Integer m2 = Integer.parseInt(textField_3.getText());
					Integer m3 = Integer.parseInt(textField_4.getText());
					String query = "update student set name = '"+name+"',m1 = "+m1+", m2 = "+m2+", m3 ="+m3+" where sno = "+sno ;
					ps2 = con.prepareStatement(query);
					int result = ps2.executeUpdate();
					if(result !=0) {
						textField_5.setText("Data is updated successfully ");
					}else {
						textField_5.setText("something went wrong ");
					}
					
				}catch (NumberFormatException e) {
					textField_5.setText("Data is not properly filled up");
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jdbc();//updating data base to ui
				setEditableFalse();
			}
		});
		btnUpdate.setBounds(229, 252, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(548, 32, 28, 20);
		frame.getContentPane().add(comboBox);
		
		JCheckBox chckbxCheckedIt = new JCheckBox("checked it");
		chckbxCheckedIt.setBounds(595, 31, 97, 23);
		frame.getContentPane().add(chckbxCheckedIt);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(548, 88, 121, 23);
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(548, 181, 298, 184);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setSurrendersFocusOnKeystroke(true);
		table.setForeground(Color.RED);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(Color.YELLOW);
	}
	
	private void jdbc () {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##rana","rana123");
			 ps1 = con.prepareStatement("select sno, name, m1, m2, m3 from student",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 rs = ps1.executeQuery();
			rs.next();
		
		} catch (ClassNotFoundException | SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}//end of jdbc method making connection
	
	private void setEditableFalse() {
		textField.setEditable(false);
		textField_1.setEditable(false);
		textField_2.setEditable(false);
		textField_3.setEditable(false);
		textField_4.setEditable(false);
	}
}
