package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class frontend extends JApplet {

	private JFrame frame;
	private JTextField firstVarName;
	private JTextField firstVarType;
	private JTextField firstVarValue;
	private JTextField secondVarName;
	private JTextField secondVarType;
	private JTextField secondVarValue;
	private JTextField thirdVarName;
	private JTextField thirdVarType;
	private JTextField thirdVarValue;

	/**
	 * Launch the application.
	 */



	public  void init() {
		

		JLabel lblNewLabel = new JLabel("Homomorphic Enryption ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(129, 11, 259, 31);
		

		JLabel lblNewLabel_1 = new JLabel("First Variable:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 53, 105, 14);
		this.getContentPane().add(lblNewLabel_1);
		
		firstVarName = new JTextField();
		firstVarName.setBounds(46, 78, 86, 20);
		this.getContentPane().add(firstVarName);
		firstVarName.setColumns(10);

		firstVarType = new JTextField();
		firstVarType.setColumns(10);
		firstVarType.setBounds(46, 99, 86, 20);
		this.getContentPane().add(firstVarType);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(10, 81, 46, 14);
		this.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Type");
		lblNewLabel_2_1.setBounds(10, 102, 46, 14);
		this.getContentPane().add(lblNewLabel_2_1);

		firstVarValue = new JTextField();
		firstVarValue.setBounds(46, 121, 86, 20);
		this.getContentPane().add(firstVarValue);
		firstVarValue.setColumns(10);

		JLabel lblNewLabel_2_1_1 = new JLabel("Value ");
		lblNewLabel_2_1_1.setBounds(10, 124, 86, 14);
		this.getContentPane().add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Name");
		lblNewLabel_2_2.setBounds(10, 190, 46, 14);
		this.getContentPane().add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_1 = new JLabel("Second Variable:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 162, 122, 14);
		this.getContentPane().add(lblNewLabel_1_1);

		secondVarName = new JTextField();
		secondVarName.setColumns(10);
		secondVarName.setBounds(46, 187, 86, 20);
		this.getContentPane().add(secondVarName);

		secondVarType = new JTextField();
		secondVarType.setColumns(10);
		secondVarType.setBounds(46, 208, 86, 20);
		this.getContentPane().add(secondVarType);

		JLabel lblNewLabel_2_1_2 = new JLabel("Type");
		lblNewLabel_2_1_2.setBounds(10, 211, 46, 14);
		this.getContentPane().add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Value ");
		lblNewLabel_2_1_1_1.setBounds(10, 233, 86, 14);
		this.getContentPane().add(lblNewLabel_2_1_1_1);

		secondVarValue = new JTextField();
		secondVarValue.setColumns(10);
		secondVarValue.setBounds(46, 230, 86, 20);
		this.getContentPane().add(secondVarValue);

		JLabel lblNewLabel_2_3 = new JLabel("Name");
		lblNewLabel_2_3.setBounds(10, 301, 46, 14);
		this.getContentPane().add(lblNewLabel_2_3);

		JLabel lblNewLabel_1_2 = new JLabel("Third Variable:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(10, 273, 105, 14);
		this.getContentPane().add(lblNewLabel_1_2);

		thirdVarName = new JTextField();
		thirdVarName.setColumns(10);
		thirdVarName.setBounds(46, 298, 86, 20);
		this.getContentPane().add(thirdVarName);

		thirdVarType = new JTextField();
		thirdVarType.setColumns(10);
		thirdVarType.setBounds(46, 319, 86, 20);
		this.getContentPane().add(thirdVarType);

		JLabel lblNewLabel_2_1_3 = new JLabel("Type");
		lblNewLabel_2_1_3.setBounds(10, 322, 46, 14);
		this.getContentPane().add(lblNewLabel_2_1_3);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Value ");
		lblNewLabel_2_1_1_2.setBounds(10, 344, 86, 14);
		this.getContentPane().add(lblNewLabel_2_1_1_2);

		thirdVarValue = new JTextField();
		thirdVarValue.setColumns(10);
		thirdVarValue.setBounds(46, 341, 86, 20);
		this.getContentPane().add(thirdVarValue);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(199, 76, 279, 282);
		this.getContentPane().add(textArea);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.selectAll();
				textArea.replaceSelection("");
				textArea.append("First Variable:"+"\n");
				textArea.append("name:"+firstVarName.getText()+"\n");
				textArea.append("type:"+firstVarType.getText()+"\n");
				textArea.append("value:"+firstVarValue.getText()+"\n");
				textArea.append("--------------------------------"+"\n");
				textArea.append("Second Variable:"+"\n");
				textArea.append("name:"+secondVarName.getText()+"\n");
				textArea.append("type:"+secondVarType.getText()+"\n");
				textArea.append("value:"+secondVarValue.getText()+"\n");
				textArea.append("--------------------------------"+"\n");
				textArea.append("Third Variable:"+"\n");
				textArea.append("name:"+thirdVarName.getText()+"\n");
				textArea.append("type:"+thirdVarType.getText()+"\n");
				textArea.append("value:"+thirdVarValue.getText()+"\n");
				textArea.append("--------------------------------"+"\n");
			}
		});
		btnSubmit.setBounds(46, 388, 89, 23);
		this.add(btnSubmit);
		this.getContentPane().add(lblNewLabel);
		
		
	}
	

	/**
	 * Create the application.
	 */
	public frontend() {
	}
}


