package lottery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.css.RGBColor;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;

public class lottery extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_4;
	private JList list;
	private JButton btnDelete;
	private JButton btnRoll;
	
	int numIndex = 0;
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(208, 48, 56, 29);
		panel.add(textField_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(142, 48, 56, 29);
		panel.add(textField_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(340, 48, 56, 29);
		panel.add(textField_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(274, 48, 56, 29);
		panel.add(textField_4);
		
		JPanel pnlNumBtns = new JPanel();
		pnlNumBtns.setBounds(10, 104, 386, 248);
		panel.add(pnlNumBtns);
		pnlNumBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(403, 51, 87, 23);
		panel.add(btnAdd);
		
		list = new JList();
		list.setBounds(10, 395, 386, 170);
		panel.add(list);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(403, 392, 87, 23);
		panel.add(btnDelete);
		
		btnRoll = new JButton("Roll");
		btnRoll.setBounds(403, 483, 87, 82);
		panel.add(btnRoll);
		
		JLabel lblEnterNums = new JLabel("Enter Nums");
		lblEnterNums.setBounds(10, 10, 169, 15);
		panel.add(lblEnterNums);
		
		JLabel lblSavedNums = new JLabel("Saved Nums");
		lblSavedNums.setBounds(10, 370, 147, 15);
		panel.add(lblSavedNums);
		
		JButton btnRandom = new JButton("Random");
		btnRandom.setBounds(403, 104, 87, 23);
		panel.add(btnRandom);
		
		JLabel lblNumErr = new JLabel("\u8ACB\u8F38\u51651~49\u9593\u7684\u6578\u5B57!!");
		lblNumErr.setVisible(false);
		lblNumErr.setForeground(Color.RED);
		lblNumErr.setBounds(10, 79, 264, 15);
		panel.add(lblNumErr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(300, 600));
		contentPane.add(scrollPane);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblResults);
		
		//Start
		JTextField[] tfNums = {textField, textField_1, textField_2, textField_3, textField_4, textField_5};
		Integer[] enteredNums = new Integer[6];
		JButton[] btns = new JButton[49];
		
		ActionListener numBtnPress = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton)e.getSource();
				String num = btn.getText();
				
				//check if pressed btn is orange
				if(btn.getBackground()!=Color.orange){
					tfNums[numIndex].setText(num);
					btn.setBackground(Color.orange);
					
					if(enteredNums[numIndex]!=null){
						btns[enteredNums[numIndex]-1].setBackground(Color.white);
					}
					enteredNums[numIndex]=Integer.parseInt(num);
					
					if(numIndex==5){
						numIndex=0;
					}else{
						numIndex++;
					}
				}else{
					//cancel num
					btn.setBackground(Color.white);
					for(JTextField tf : tfNums){
						if(tf.getText().equals(num)){
							tf.setText("");
							tf.setBackground(Color.white);
						}
					}
				}
				
			}
		};
		//build number buttons
		for(int i = 1; i <= 49; i++){
			JButton btn = new JButton();
			btn.setName("btn"+i);
			btn.setText(String.valueOf(i));
			btn.setPreferredSize(new Dimension(50, 24));
			pnlNumBtns.add(btn);
			btn.setBackground(Color.white);
			btns[i-1]=btn;
			btn.addActionListener(numBtnPress);
		}
		//Text Change Listener
		FocusAdapter focusLost = new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				JTextField tb = (JTextField) arg0.getSource();
				try{
					//check if 1~49
					if (Integer.parseInt(tb.getText())<1||Integer.parseInt(tb.getText())>49) {
						tb.grabFocus();
						tb.setBackground(Color.red);
						lblNumErr.setVisible(true);
						System.out.println("not 1~49 nums");
					}else {
						//valid
						tb.setBackground(Color.white);
						lblNumErr.setVisible(false);
						//if changing number, make old num btn white
						if(enteredNums[Arrays.asList(tfNums).indexOf(tb)]!=null){
							btns[enteredNums[Arrays.asList(tfNums).indexOf(tb)]-1].setBackground(Color.white);
						}			
						//store entered number and make btn orange
						enteredNums[Arrays.asList(tfNums).indexOf(tb)] = Integer.parseInt(tb.getText());
						btns[Integer.parseInt(tb.getText())-1].setBackground(Color.orange);
						
						//check if other tfs not valid
						for(JTextField tf : tfNums){
							try{
							if(Integer.parseInt(tf.getText())<1||Integer.parseInt(tf.getText())>49){
								lblNumErr.setVisible(true);
								System.out.println("another tf is not 1~49 nums");
							}
							}catch(Exception ex){
								if (!tf.getText().isEmpty()) {
									lblNumErr.setVisible(true);
									System.out.println("another tf is not nums");
								}
							}
						}
						//check if duplicate
						for(JTextField t : tfNums){
							if(tb!=t){
								if(tb.getText().equals(t.getText())){
									t.setBackground(Color.red);
									tb.setBackground(Color.red);
									JOptionPane.showMessageDialog(null, "duplicated nums");
									tb.grabFocus();
									break;
								}
							}							
						}
					}
				}catch(Exception ex){
					System.out.println(ex);
					if (!tb.getText().isEmpty()) {
						tb.setBackground(Color.red);
						lblNumErr.setVisible(true);
						tb.grabFocus();
						System.out.println("not nums");
					}else{
						System.out.println("empty");
						tb.setBackground(Color.white);
						//check if any invalid, if invalid show err text
						lblNumErr.setVisible(false);	
						for(JTextField tf : tfNums){	
							try{
							if(Integer.parseInt(tf.getText())<1||Integer.parseInt(tf.getText())>49){
								lblNumErr.setVisible(true);		
							}
							}catch(Exception e){		
								if (!tf.getText().isEmpty()) {
									lblNumErr.setVisible(true);		
								}
							}
						}
					}
				}
			}
		};

		textField.addFocusListener(focusLost);
		textField_1.addFocusListener(focusLost);
		textField_3.addFocusListener(focusLost);
		textField_2.addFocusListener(focusLost);
		textField_5.addFocusListener(focusLost);
		textField_4.addFocusListener(focusLost);
	}
}
