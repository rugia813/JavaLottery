package lottery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class lottery extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JList list;
	private JButton btnDelete;
	private JButton btnRoll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lottery frame = new lottery();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lottery() {
		setTitle("Lottery");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 600));
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 48, 56, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(76, 48, 56, 29);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(208, 48, 56, 29);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(142, 48, 56, 29);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(340, 48, 56, 29);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(274, 48, 56, 29);
		panel.add(textField_5);
		
		JPanel pnlNumBtns = new JPanel();
		pnlNumBtns.setBounds(10, 104, 386, 170);
		panel.add(pnlNumBtns);
		pnlNumBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(403, 51, 87, 23);
		panel.add(btnAdd);
		
		list = new JList();
		list.setBounds(10, 322, 386, 170);
		panel.add(list);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(403, 319, 87, 23);
		panel.add(btnDelete);
		
		btnRoll = new JButton("Roll");
		btnRoll.setBounds(403, 410, 87, 82);
		panel.add(btnRoll);
		
		JLabel lblEnterNums = new JLabel("Enter Nums");
		lblEnterNums.setBounds(10, 10, 169, 15);
		panel.add(lblEnterNums);
		
		JLabel lblSavedNums = new JLabel("Saved Nums");
		lblSavedNums.setBounds(10, 297, 147, 15);
		panel.add(lblSavedNums);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(300, 600));
		contentPane.add(scrollPane);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblResults);
	}
}
