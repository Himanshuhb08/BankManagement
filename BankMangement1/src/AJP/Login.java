package AJP;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Login extends JFrame implements ActionListener{
	
	JButton login,clear,signup;
	JTextField CardTextField;
	JPasswordField PinTextField;
	Login(){
		setTitle("Automated teller machine");
		setLayout(null);
		
		JLabel text=new JLabel("Welcome to Atm");
		text.setBounds(250,40,400,30);
		text.setFont(new Font("Osward ",Font.BOLD ,38));
		add(text);
		
		JLabel Cardno=new JLabel("Card No: ");
		Cardno.setBounds(120,150,150,30);
		Cardno.setFont(new Font("Raleway ",Font.BOLD ,28));
		add(Cardno);
		
		 CardTextField =new JTextField();
		CardTextField.setBounds(300,150,250,30);
		CardTextField.setFont(new Font ("Arial ",Font.BOLD,14));
		add(CardTextField);
		
		JLabel Pin=new JLabel("Pin : ");
		Pin.setBounds(120,220,250,30);
		Pin.setFont(new Font("Raleway ",Font.BOLD ,28));
		add(Pin);
		
		 PinTextField =new JPasswordField();
		PinTextField.setBounds(300,220,250,30);
		PinTextField.setFont(new Font ("Arial ",Font.BOLD,14));
		add(PinTextField);
		
		 login =new JButton("LOGIN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		 clear =new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		 signup =new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		getContentPane().setBackground(Color.WHITE);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear) {
			CardTextField.setText("");
			 PinTextField.setText("");
			
			
		}else if(ae.getSource()==login) {
			
	        try {
	        	Conn conn=new Conn();
				String cardno =CardTextField.getText();
				String pinno= PinTextField.getText();
				
				String query="select * from login where cardnumber= '"+cardno+"'and pinnumber= ' "+pinno+"' ";
	        	ResultSet rs=conn.s.executeQuery(query);
	        	if(rs.next()) {
	        		setVisible(false);
	        		new Transcation( pinno).setVisible(true);
	        	}
	        	else {
	        		JOptionPane.showMessageDialog(null, "Incorrect data");
	        	}
	        	
	        	
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
			
			
		}else if(ae.getSource()==signup) {
			
			setVisible(false);
			new Signupone().setVisible(true);
			
		}
		
	}
	

	public static void main(String[] args) {
		new Login();
		
	}

}
