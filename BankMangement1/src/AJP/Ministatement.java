package AJP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class Ministatement extends JFrame {
	
	Ministatement(String pinno){
		setLayout(null);
		JLabel l1=new JLabel();
		add(l1);
		
		JLabel text=new JLabel();
		add(text);
		
		
		JLabel bank =new JLabel("INDIAN BANK");
		bank.setBounds(128,20,200,30);
		bank.setFont(new Font("Ralyway", Font.BOLD,24));
	    add(bank);
		
	    JLabel card =new JLabel();
	    card .setBounds(20,80,200,20);
	    add( card );
		
	    
	    try {
	    	
	    	Conn con=new Conn();
	    	ResultSet rs =con.s.executeQuery("select * from login where pinnumber= '"+pinno+"'");
	    	
	    	while(rs.next()) {
	    		card.setText("Card number : "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX");
	    	}
	    	
	    }catch(Exception e) {
	    	System.out.println(e);
	    }
		
		setSize(400,500);
		setLocation(20,20);
		setVisible(true);
		getContentPane().setBackground(Color.white);
	}

	public static void main(String[] args) {
		new Ministatement("");

	}

}
