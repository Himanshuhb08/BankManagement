package AJP;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class signupthree extends JFrame implements ActionListener {
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	signupthree(String formno){
		this.formno=formno;
		
		setTitle("New Account Appliction Form - page 3");
		setLayout(null);
		
		JLabel l1=new JLabel(" Page 3: Account Details");
		l1.setFont(new Font("Ralyway", Font.BOLD,24));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		JLabel l2=new JLabel("Account Type :");
		l2.setFont(new Font("Ralyway", Font.BOLD,24));
		l2.setBounds(100,140,200,30);
		add(l2);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Ralyway", Font.BOLD,16));
		r1.setBounds(100,180,170,20);
		r1.setBackground(Color.WHITE);
		add(r1);
		
		r2=new JRadioButton("Current Account");
		r2.setFont(new Font("Ralyway", Font.BOLD,16));
		r2.setBounds(350,180,170,20);
		r2.setBackground(Color.WHITE);
		add(r2);
		
		r3=new JRadioButton("Fixed Account");
		r3.setFont(new Font("Ralyway", Font.BOLD,16));
		r3.setBounds(100,220,170,20);
		r3.setBackground(Color.WHITE);
		add(r3);
		
		r4=new JRadioButton("Recuring Account");
		r4.setFont(new Font("Ralyway", Font.BOLD,16));
		r4.setBounds(350,220,170,20);
		r4.setBackground(Color.WHITE);
		add(r4);
		
		ButtonGroup other1 =new ButtonGroup();
		other1.add( r1);
		other1.add( r2);
		other1.add( r3);
		other1.add( r4);
		
		
		JLabel l3=new JLabel("Card no :");
		l3.setFont(new Font("Ralyway", Font.BOLD,24));
		l3.setBounds(100,300,200,30);
		add(l3);
		
		JLabel l4=new JLabel("XXXX-XXXX-XXXX-8810");
		l4.setFont(new Font("Ralyway", Font.BOLD,24));
		l4.setBounds(300,300,400,30);
		add(l4);
		
	

		JLabel l5=new JLabel("Pin no :");
		l5.setFont(new Font("Ralyway", Font.BOLD,24));
		l5.setBounds(100,350,200,30);
		add(l5);
		
		JLabel l6=new JLabel("XXXX");
		l6.setFont(new Font("Ralyway", Font.BOLD,24));
		l6.setBounds(300,350,400,30);
		add(l6);
		
		
		JLabel l8=new JLabel("Services required :");
		l8.setFont(new Font("Ralyway", Font.BOLD,24));
		l8.setBounds(100,400,250,30);
		add(l8);
		
		c1=new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setForeground(Color.BLACK);
		c1.setFont(new Font("Ralyway", Font.BOLD,14));
		c1.setBounds(170,450,200,30);
		add(c1);
		
		c2=new JCheckBox("INTERNET BANKING");
		c2.setBackground(Color.WHITE);
		c2.setForeground(Color.BLACK);
		c2.setFont(new Font("Ralyway", Font.BOLD,14));
		c2.setBounds(350,450,350,30);
		add(c2);
		
		c3=new JCheckBox("MOBILE BANKING");
		c3.setBackground(Color.WHITE);
		c3.setForeground(Color.BLACK);
		c3.setFont(new Font("Ralyway", Font.BOLD,14));
		c3.setBounds(170,500,200,30);
		add(c3);
		
		c4=new JCheckBox("EMAIL ALERT");
		c4.setBackground(Color.WHITE);
		c4.setForeground(Color.BLACK);
		c4.setFont(new Font("Ralyway", Font.BOLD,14));
		c4.setBounds(350,500,200,30);
		add(c4);
		
		c5=new JCheckBox("CHEQUE BOOK");
		c5.setBackground(Color.WHITE);
		c5.setForeground(Color.BLACK);
		c5.setFont(new Font("Ralyway", Font.BOLD,14));
		c5.setBounds(170,550,200,30);
		add(c5);
		
		c6=new JCheckBox("E-STSTEMENTS");
		c6.setBackground(Color.WHITE);
		c6.setForeground(Color.BLACK);
		c6.setFont(new Font("Ralyway", Font.BOLD,14));
		c6.setBounds(350,550,200,30);
		add(c6);
		
		c7=new JCheckBox("I HEREBY DECLARE THAT ABOVE THE ABOVE ENTERED DETAILS ARE CORRECT");
		c7.setBackground(Color.WHITE);
		c7.setForeground(Color.BLACK);
		c7.setFont(new Font("Ralyway", Font.BOLD,10));
		c7.setBounds(100,620,600,30);
		add(c7);
		
		submit =new JButton("SUBMIT");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Ralyway", Font.BOLD,14));
		submit.setBounds(420,660,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel =new JButton("CANCEL");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Ralyway", Font.BOLD,14));
		cancel.setBounds(540,660,100,30);
		cancel.addActionListener(this);
		add(cancel);

		setSize(850,840);
		setLocation(350,0);
		setVisible(true);
		getContentPane().setBackground(Color.white);
	
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			String acctype=null;
			if(r1.isSelected()) {
				acctype="Saving Account";
			}
			else if(r2.isSelected()) {
				acctype="Current Account";
			}
			else if(r3.isSelected()) {
				acctype="Fixed Account";
			}
			else if(r4.isSelected()) {
				acctype="Recuring Account";
			}
			
			Random ran =new Random();
		String cardnumber= " "+Math.abs(ran.nextLong()%90000000L+504093600000000L);
		String pinnumber=" "+Math.abs(ran.nextLong()%9000L+1000L);
		
		String facility=" ";
		if(c1.isSelected()) {
			facility=facility +" ATM CARD";
		}
		else if(c2.isSelected()) {
			facility=facility+" INTERNET BANKING";
		}
		else if(c3.isSelected()) {
			facility=facility+" MOBILE BANKING";
		}
		else if(c4.isSelected()) {
			facility=facility+" EMAIL ALERTS";
		}
		else if(c5.isSelected()) {
			facility=facility+" CHEQUE BOOK";
		}
		else if(c6.isSelected()) {
			facility=facility+" E-STATEMENT";
		}
		try {
			if(acctype.equals("")) {
				JOptionPane.showMessageDialog(null, "Account type is required");
			}
			
			else {
				
				Conn con=new Conn();
				String query1="Insert into signup3 values( '"+formno+"', '"+acctype+"', '"+ cardnumber+"', '"+ pinnumber+"','"+facility+"' )";
				String query2="Insert into login values( '"+formno+"',  '"+ cardnumber+"', '"+ pinnumber+"' )";
				con.s.executeUpdate(query1);
				con.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "cardnumber: "+cardnumber+"\n Pin: "+pinnumber);
				
				setVisible(false);
				new Deposit(pinnumber).setVisible(true);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
			
			
			}
		
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
		
		}
	}
	

	public static void main(String[] args) {
		new signupthree("");

	}

}
