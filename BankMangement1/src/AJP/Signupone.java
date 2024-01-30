package AJP;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;




public class Signupone extends JFrame implements ActionListener {
	
	JTextField nametf,fnametf,emailtf, addtf,citytf,statetf , pintf,dobtf;
	Random ran;
	JRadioButton male,female,married,unmarried;
	JButton next;
	int random;
	Signupone(){
		setLayout(null);
		
		 ran =new Random();
		 random =Math.abs(ran.nextInt() % 1000);
		setTitle("Page 2");
		
		JLabel formno =new JLabel("Application Form No "+random);
		formno.setFont(new Font ("Ralyway",Font.BOLD,38));
		formno.setBounds(160,20,600,40);
		add(formno);
		
		JLabel personaldetail =new JLabel(" Page 1: Personal Details");
		personaldetail.setFont(new Font ("Ralyway",Font.BOLD,22));
		personaldetail.setBounds(290,80,400,30);
		add(personaldetail);
		
		JLabel name =new JLabel(" Name:");
		 name.setFont(new Font ("Ralyway",Font.BOLD,20));
		 name.setBounds(100,140,100,30);
		add( name);
		
		nametf=new JTextField();
	    nametf.setFont(new Font ("Arial ",Font.BOLD,14));
	    nametf.setBounds(300,140,400,30);
	    add(nametf);
		

		JLabel fname =new JLabel("Father's Name:");
		 fname.setFont(new Font ("Ralyway",Font.BOLD,20));
		 fname.setBounds(100,190,200,30);
		add(fname);
		
		fnametf=new JTextField();
	    fnametf.setFont(new Font ("Arial ",Font.BOLD,14));
	    fnametf.setBounds(300,190,400,30);
	    add(fnametf);
		
		JLabel dob =new JLabel("Date of birth:");
		dob.setFont(new Font ("Ralyway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		dobtf=new JTextField();
		dobtf.setFont(new Font ("Arial ",Font.BOLD,14));
		dobtf.setBounds(300,240,200,30);
	    add(dobtf);
		
		JLabel gender =new JLabel("Gender:");
		gender.setFont(new Font ("Ralyway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.white);
		add(male);
		
		 female = new JRadioButton("Female");
		female.setBounds(450,290,100,30);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gendergrp=new ButtonGroup();
		gendergrp.add(male);
		gendergrp.add(female);
		
		JLabel email =new JLabel(" email:");
		 email.setFont(new Font ("Ralyway",Font.BOLD,20));
		 email.setBounds(100,340,200,30);
		add( email);
		
		emailtf=new JTextField();
		emailtf.setFont(new Font ("Arial ",Font.BOLD,14));
		emailtf.setBounds(300,340,400,30);
	    add(emailtf);
		
		JLabel maritial =new JLabel(" Marital Status:");
		 maritial.setFont(new Font ("Ralyway",Font.BOLD,20));
		 maritial.setBounds(100,390,200,30);
		add( maritial);
		
		 married = new JRadioButton("Married");
		 married.setBounds(300,390,100,30);
		 married.setBackground(Color.white);
		add( married);
		
		 unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		ButtonGroup other =new ButtonGroup();
		other.add( married);
		other.add( unmarried);
		
		
		JLabel address =new JLabel("Address:");
		 address .setFont(new Font ("Ralyway",Font.BOLD,20));
		 address .setBounds(100,440,200,30);
		add( address );
		
		addtf=new JTextField();
		addtf.setFont(new Font ("Arial ",Font.BOLD,14));
		addtf.setBounds(300,440,400,30);
	    add(addtf);
		
		

		JLabel city =new JLabel(" city: ");
		 city .setFont(new Font ("Ralyway",Font.BOLD,20));
		 city .setBounds(100,490,200,30);
		add( city);
		
		citytf=new JTextField();
		citytf.setFont(new Font ("Arial ",Font.BOLD,14));
		citytf.setBounds(300,490,400,30);
	    add(citytf);
		
		JLabel state =new JLabel(" state: ");
		state .setFont(new Font ("Ralyway",Font.BOLD,20));
		state .setBounds(100,540,400,30);
		add(state);
		
		statetf=new JTextField();
		statetf.setFont(new Font ("Arial ",Font.BOLD,14));
		statetf.setBounds(300,540,400,30);
	    add(statetf);
		
		
		JLabel pincode =new JLabel(" pincode: ");
		pincode.setFont(new Font ("Ralyway",Font.BOLD,20));
		pincode .setBounds(100,590,200,30);
		add(pincode);
		
		pintf=new JTextField();
		pintf.setFont(new Font ("Arial ",Font.BOLD,14));
		pintf.setBounds(300,590,400,30);
	    add(pintf);
	    
	    
	     next =new JButton("Next");
	    next.setBackground(Color.black);
	    next.setForeground(Color.white);
	    next.setBounds(620,660,80,30);
	    next.addActionListener(this);
	    add(next);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		getContentPane().setBackground(Color.white);;
	}
	public void actionPerformed(ActionEvent ae) {
		String formno=" "+random;
		String name=nametf.getText();
		String fname =fnametf.getText();
		String dob=dobtf.getText();
		String gender=null;
		if(male.isSelected()) {
			gender="male";
			
		}else if(female.isSelected()){
			gender="Female";
		}
		
		String email=emailtf.getText();
		String martial =null;
		if(married.isSelected()) {
			martial="Married";
			
		}else if(unmarried.isSelected()) {
			martial="unmarried";
		}
		
		
		String address= addtf.getText();
		String city = citytf.getText();
		String state= statetf.getText();
		String pin = pintf.getText();
		
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is required");
			}else {
				Conn c =new Conn();
				String query="insert into signup1 values('"+formno+"', '"+name+"','"+fname+"','"+dob +"','"+ gender+"','"+email+"', '"+ martial+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new Signuptwo(formno).setVisible(true);
		}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new Signupone();
	}

}
