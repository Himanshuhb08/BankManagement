package AJP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class Balance extends JFrame implements ActionListener {

	String pinno;
	Balance(String pinno){
		this.pinno=pinno;
		setLayout(null);
		
		JButton back = new JButton(" BACK");
		back.setBounds(320,300,150,30);
		back.setFont(new Font("Ralyway", Font.BOLD,18));
		back.addActionListener(this);
		add(back);
		int balance=0;
	

		try {
			Conn con =new Conn();
			ResultSet rs= con.s.executeQuery("Select * from bank where pin = '"+pinno+"'");
			
			while(rs.next()) {
				
				if(rs.getString("type").equals("deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}else {
					balance -=Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e) {
				System.out.println(e);
			}
		
		JLabel label =new JLabel("Your Current Balance is : " + balance);
		label.setBounds(250,200,400,30);
		label.setFont(new Font("Ralyway", Font.BOLD,24));
		add(label);
		
		
		
		
		setSize(800,850);
		setLocation(300,0);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transcation(pinno).setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Balance("");

	}

}
