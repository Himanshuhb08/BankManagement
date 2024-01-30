package AJP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class Pinchange extends JFrame implements ActionListener {
	
	JButton back,change;
	JTextField pin,rpin;
	String pinno;
	Pinchange(String pinno){
		this.pinno=pinno;
		setLayout(null);
		JLabel label =new JLabel("CHANGE YOUR PIN");
		label.setBounds(300,100,300,30);
		label.setFont(new Font("System", Font.BOLD,20));
		add(label);
		
		
		JLabel pintext=new JLabel("New Pin:");
		pintext.setBounds(180,160,300,30);
		pintext.setFont(new Font("Raleway", Font.BOLD,20));
		add(pintext);
		
		pin =new JTextField();
		pin.setFont(new Font("Ralyway", Font.BOLD,14));
		pin.setBounds(340,160,200,25);
		add(pin);
		 
		JLabel rpintext=new JLabel("Re-Enter Pin:");
		rpintext.setBounds(180,200,300,30);
		rpintext.setFont(new Font("Ralyway", Font.BOLD,20));
		add(rpintext);
		
		 rpin =new JTextField();
		rpin.setFont(new Font("Ralyway", Font.BOLD,14));
		rpin.setBounds(340,200,200,25);
		add(rpin);
		
	    change =new JButton("CHANGE");
 		change.setBounds(200,270,150,30);
		change.addActionListener(this);
		change.setFont(new Font("Ralyway", Font.BOLD,18));
		add(change);
		
		
		 back =new JButton("BACK");
		back.setBounds(390,270,150,30);
		back.addActionListener(this);
		back.setFont(new Font("Ralyway", Font.BOLD,18));
		add(back);
		
		
		setSize(800,850);
		setLocation(300,0);
		setVisible(true);
		getContentPane().setBackground(Color.white);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==change) {
			
			try {
				
				String npin=pin.getText();
				String rnpin=rpin.getText();
				
				if(!npin.equals(npin)) {
					JOptionPane.showMessageDialog(null, "Enter pin does not match");
					return;
				}
				
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter the pin");
					return;
				}
				if(rnpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter the repin");
					return;
				}
				
				Conn con=new Conn();
				String query1="update bank set pin = '"+rnpin+"' where pin= '"+pinno+"'"; 
				String query2="update login set pinnumber = '"+rnpin+"' where pinnumber= '"+pinno+"'"; 
				String query3="update signup3 set pin = '"+rnpin+"' where pin= '"+pinno+"'"; 
				
				con.s.executeUpdate(query1);
				con.s.executeUpdate(query2);
				con.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "Pin change Successfully");
				
				setVisible(false);
				new Transcation(rnpin).setVisible(true);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}else {
			setVisible(false);
			new Transcation(pinno).setVisible(true); 
		}
	}

	public static void main(String[] args) {
	new Pinchange("");

	}

}
