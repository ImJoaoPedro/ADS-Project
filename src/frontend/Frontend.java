package frontend;

import consultant.client.Consultant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frontend extends JFrame {

	private JTextField firstVarName;
	private JTextField firstVarType;
	private JTextField firstVarValue;
	private JTextField secondVarName;
	private JTextField secondVarType;
	private JTextField secondVarValue;
	private JTextField thirdVarName;
	private JTextField thirdVarType;
	private JTextField thirdVarValue;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */

	public void init() {
		this.setTitle("Homomorphic Enryption Project");

		this.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("First Variable:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 53, 105, 14);
		this.getContentPane().add(lblNewLabel_1);
		
		firstVarName = new JTextField();
		firstVarName.setBounds(46, 78, 86, 20);
		this.getContentPane().add(firstVarName);
		firstVarName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(10, 81, 46, 14);
		this.getContentPane().add(lblNewLabel_2);

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

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Value ");
		lblNewLabel_2_1_1_1.setBounds(10, 233, 86, 14);
		this.getContentPane().add(lblNewLabel_2_1_1_1);

		secondVarValue = new JTextField();
		secondVarValue.setColumns(10);
		secondVarValue.setBounds(46, 230, 86, 20);
		this.getContentPane().add(secondVarValue);

		JLabel lblNewLabel_2_3 = new JLabel("Value ");
		lblNewLabel_2_3.setBounds(10, 301, 46, 14);
		this.getContentPane().add(lblNewLabel_2_3);

		JLabel lblNewLabel_1_2 = new JLabel("Desired Quality:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(10, 273, 105, 14);
		this.getContentPane().add(lblNewLabel_1_2);

		thirdVarName = new JTextField();
		thirdVarName.setColumns(10);
		thirdVarName.setBounds(46, 298, 86, 20);
		this.getContentPane().add(thirdVarName);

		textArea = new JTextArea();
		textArea.setBounds(199, 76, 279, 282);
		this.getContentPane().add(textArea);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(46, 388, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textArea.selectAll();
				//textArea.replaceSelection("");
				String[] args = new String[3];
				args[0] = thirdVarName.getText();
				args[1] = firstVarValue.getText();
				args[2] = secondVarValue.getText();
				Consultant consultant = new Consultant(args);
				consultant.setTextArea(textArea);
				consultant.start();
			}
		});
		this.add(btnSubmit);
	}
	

	/**
	 * Create the application.
	 */
	public Frontend() {
		init();
	}

}


