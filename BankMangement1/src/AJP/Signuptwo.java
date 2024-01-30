package AJP;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;




public class Signuptwo extends JFrame implements ActionListener {
	
	JTextField adnotf,pantf;
	
	JRadioButton syes,sno,eyes,eno;
	JButton next;
	JComboBox varreligion, varcatagory,salary, educations,varoccupation;
	int random;
	String formno;
	Signuptwo(String formno){
		this.formno=formno;
		setLayout(null);
		
		
		setTitle("New Account Appliction Form - page 2");
		
		JLabel Additionaldetail =new JLabel(" Page 2: Additinal Details");
		Additionaldetail.setFont(new Font ("Ralyway",Font.BOLD,24));
		Additionaldetail.setBounds(290,80,400,30);
		add(Additionaldetail);
		
		JLabel religion=new JLabel(" Religion: ");
		religion.setFont(new Font ("Ralyway",Font.BOLD,20));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		String vr[]= {"Hindu","Muslim","Sikh","other"};
		 varreligion =new JComboBox(vr);
		varreligion.setBounds(300,140,400,30);
	    add(varreligion);
				

		JLabel catagory =new JLabel("Category: ");
		catagory.setFont(new Font ("Ralyway",Font.BOLD,20));
		catagory.setBounds(100,190,200,30);
		add(catagory);
		
		String vc[]= {"OBC","Open","Sc","other"};
		 varcatagory =new JComboBox(vc);
		varcatagory.setBounds(300,190,400,30);
	    add(varcatagory);
		
		
		JLabel Income =new JLabel("Income:");
		Income.setFont(new Font ("Ralyway",Font.BOLD,20));
		Income.setBounds(100,240,200,30);
		add(Income);
		
		String vs[]= {"Null","<1,50,00","<5,00,000","upto 10 lakh"};
		 salary =new JComboBox(vs);
		salary.setBounds(300,240,400,30);
	    add(salary);
	
		
		JLabel education =new JLabel(" Educational");
		education.setFont(new Font ("Ralyway",Font.BOLD,20));
		education.setBounds(100,310,200,30);
		add(education);
	
		
		JLabel qualification =new JLabel(" Qualification:");
		 qualification.setFont(new Font ("Ralyway",Font.BOLD,20));
		 qualification.setBounds(100,340,200,30);
		add(  qualification);
		
		String ve[]= {"Non Graduate","Graduate","Post graduate","other"};
		 educations =new JComboBox(ve);
		educations .setBounds(300,340,400,30);
	    add(educations );
	
		JLabel occupation =new JLabel(" Occupation :");
		occupation.setFont(new Font ("Ralyway",Font.BOLD,20));
		occupation.setBounds(100,390,200,30);
		add(occupation);
		
		String vo[]= {"GovermentJob","Businessman","other"};
		 varoccupation =new JComboBox(vo);
		 varoccupation.setBounds(300,390,400,30);
	    add( varoccupation );
		
		
		
		JLabel panno =new JLabel("Pan number:");
		panno .setFont(new Font ("Ralyway",Font.BOLD,20));
		panno .setBounds(100,440,200,30);
		add(panno );
		
		pantf=new JTextField();
		pantf.setFont(new Font ("Arial ",Font.BOLD,14));
		pantf.setBounds(300,440,400,30);
	    add(pantf);
		
		

		JLabel aadharno =new JLabel(" Aadhaar no: ");
		 aadharno .setFont(new Font ("Ralyway",Font.BOLD,20));
		 aadharno.setBounds(100,490,200,30);
		add( aadharno);
		
		adnotf=new JTextField();
		adnotf.setFont(new Font ("Arial ",Font.BOLD,14));
		adnotf.setBounds(300,490,400,30);
	    add(adnotf);
		
		JLabel state =new JLabel(" Senior citizen: ");
		state .setFont(new Font ("Rae:lyway",Font.BOLD,20));
		state .setBounds(100,540,400,30);
		add(state);
		
		 syes = new JRadioButton("yes");
		 syes.setBounds(300,540,100,30);
		 syes.setBackground(Color.white);
		add( syes);
		
		 sno = new JRadioButton("No");
		 sno.setBounds(450,540,100,30);
		 sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup other =new ButtonGroup();
		other.add( syes);
		other.add( sno);
		
		
		JLabel EXacc =new JLabel(" Existing Account : ");
		EXacc.setFont(new Font ("Ralyway",Font.BOLD,20));
		EXacc .setBounds(100,590,200,30);
		add(EXacc);
		
		eyes = new JRadioButton("yes");
		 eyes.setBounds(300,590,100,30);
		 eyes.setBackground(Color.white);
		add( eyes);
		
		 eno = new JRadioButton("No");
		 eno.setBounds(450,590,100,30);
		 eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup other1 =new ButtonGroup();
		other1.add( eyes);
		other1.add( eno);
		
	    
	     next =new JButton("Next");
	    next.setBackground(Color.black);
	    next.setForeground(Color.white);
	    next.setBounds(620,660,80,30);
	    next.addActionListener(this);
	    add(next);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		getContentPane().setBackground(Color.white);
	}
	public void actionPerformed(ActionEvent ae) {
		
		String religion= (String) varreligion.getSelectedItem();
		String category =(String) varcatagory.getSelectedItem();
		String income=(String) salary.getSelectedItem();
		String seducation =(String) educations.getSelectedItem();
		String occupation =(String) varoccupation.getSelectedItem();
		String seniorcitizen=null;
		if(syes.isSelected()) {
			seniorcitizen="yes";
			
		}else if(sno.isSelected()){
			seniorcitizen="no";
		}
		
		
		String EXacc =null;
		if(eyes.isSelected()) {
			EXacc="yes";
		}else if(eno.isSelected()) {
			EXacc="no";
		}
		
		
		String pan= pantf.getText();
		String adhar = adnotf.getText();
		
		
		try {
			
				Conn c =new Conn();
				String query="insert into signup2 values('"+formno+"', '"+religion+"','"+category+"','"+income+"','"+ seducation+"','"+ occupation+"', '"+seniorcitizen +"', '"+ EXacc+"', '"+pan+"', '"+adhar+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new signupthree(formno).setVisible(true);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new Signuptwo(" ");
	}

}
