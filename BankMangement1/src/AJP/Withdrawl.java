package AJP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener {
	
	JButton withdrawl,back;
	String pinno;
	 JTextField tf;
    Withdrawl(String pinno){
    	 this.pinno=pinno;
    	 JLabel text =new JLabel("Enter the amount You want to Withdrawl");
    	 text.setFont(new Font("Ralyway", Font.BOLD,20));
    	 text.setBounds(260,150,400,30);
    	 add(text);
    	 
    	 tf=new JTextField();
    	 tf.setFont(new Font("Arial", Font.BOLD,20));
    	 tf.setBounds(250,200,400,30);
    	 add(tf);
    	 
    	 withdrawl =new JButton("Withdrawl");
    	 withdrawl.setBounds(200,270,150,30);
    	 withdrawl.addActionListener(this);
    	 add( withdrawl);
    	 
    	 back =new JButton("Back");
    	 back.setBounds(550,270,150,30);
    	 back.addActionListener(this);
    	 add(back);
    	 
    	 setLayout(null);
    	 setSize(900,900);
    	 setLocation(300,0);
 		getContentPane().setBackground(Color.WHITE);
    	 setVisible(true);
    	 
     }
     public void actionPerformed(ActionEvent ae) {
    	 if(ae.getSource()==withdrawl) {
    		 String withdrwaltf=tf.getText();
    		 Date date =new Date();
    		 if( withdrwaltf.equals("")) {
    			 JOptionPane.showMessageDialog(null, "Please enter the amount ");
    			 
    		 }
    		 else {
    			
    			try {
    				 Conn con=new Conn();
        			 String sql="insert into bank values('"+pinno+"','"+date+"','WITHDRAWL','"+ withdrwaltf+"')";
    				 con.s.executeUpdate(sql);
    				 JOptionPane.showMessageDialog(null, "Rs " +withdrwaltf+" WITHDRAWL Successfully ");
    				 setVisible(false);
    				 new Transcation(pinno).setVisible(true);
    				
    			}catch(Exception e) {
    				System.out.println(e);
    			}
    		 }
    		 
    	 }else if(ae.getSource()==back) {
    		 setVisible(false);
    		 new Transcation(pinno).setVisible(true);
    		 
    	 }
     }
	
	
	public static void main(String[] args) {
	new Withdrawl("");

	}

}
