package AJP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener{
	JButton deposit,cashwith,mini,balance,fast,exit,changepin;
	String pinno;
	Fastcash(String pinno){
		this.pinno=pinno;
		
		setLayout(null);
		
		JLabel label =new JLabel("SELECT WITHDRAWL AMOUNT");
		label.setBounds(290,100,300,30);
		label.setFont(new Font("Ralyway", Font.BOLD,20));
		add(label);
		
		 deposit=new JButton("RS 100");
		deposit.setBounds(170,200,150,30);
		deposit.addActionListener(this);
		add(deposit);
		
		 cashwith=new JButton(" RS 200");
		cashwith.setBounds(500,200,150,30);
		cashwith.addActionListener(this);
		add(cashwith);
		
		 changepin=new JButton("RS 500");
		 changepin.setBounds(170,270,150,30);
		 changepin.addActionListener(this);
		add(changepin);
		
		 mini=new JButton("RS 1000");
		 mini.setBounds(500,270,150,30);
		 mini.addActionListener(this);
		add( mini);
		
		balance=new JButton("RS 2000");
		 balance.setBounds(170,330,150,30);
		 balance.addActionListener(this);
		add(balance);
		
		 fast=new JButton("RS 5000");
		 fast.setBounds(500,330,150,30);
		 fast.addActionListener(this);
		add( fast);
		
		 exit=new JButton("BACK");
		 exit.setBounds(340,390,150,30);
		 exit.addActionListener(this);
		add(  exit);
		
		setSize(900,900);
		setLocation(300,0);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			setVisible (false);
			new Transcation(pinno).setVisible(true);
			
		}else {
			String amount = ((JButton) ae.getSource()).getText().substring(3);
			
			try {
				Conn con =new Conn();
				ResultSet rs= con.s.executeQuery("Select * from bank where pin = '"+pinno+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}else {
						balance -=Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(ae.getSource()!=exit && balance<Integer.parseInt( amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date= new Date();
				 String query="insert into bank values('"+pinno+"','"+date+"','Withdrawl','"+amount+"')";
				 con.s.executeUpdate(query);
				 JOptionPane.showMessageDialog(null, "Rs"+amount+"Debited Successfully");
				 
				 setVisible(false);
				 new Transcation(pinno).setVisible(true);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}

	public static void main(String[] args) {
		new Fastcash("");

	}

}
