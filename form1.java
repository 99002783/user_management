import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;

public class form1 {

	private JFrame frame;
	JLabel  l1, l2, l3, l4, 
	l5, l6, l7,l8,l9,l10,l11,middlename,pincode;
	JPasswordField tf7,tf8 ;   
	JComboBox cb1 ;
	JTextField tf1,tf2,tf3, 
	tf4,tf5,tf6,middletext,pintext;
	private JLabel lastNameVal;
	private JLabel emailVal;
	private JLabel contactValid;
	private JLabel pwdVal;
	private JLabel confirmVal;
	private JLabel pinValid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form1 window = new form1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public form1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton back=new JButton("Home");  
		back.setBounds(10,10,100,40);
		
		l1 = new JLabel("User Registration"); 
		l1.setBounds(200, 50, 350, 50);
		l1.setFont(new Font("Serif", Font.PLAIN, 40));
		
		
		l2 = new JLabel("First Name"); 
		l2.setBounds(50, 150, 250, 20); 
		l2.setFont(new Font("Serif", Font.PLAIN, 20));
		
		tf1 = new JTextField(); 
		tf1.setBounds(250, 150, 250,30); 
		
		JLabel firstVal = new JLabel("Enter First Name");
		firstVal.setForeground(Color.RED);
		firstVal.setBounds(521, 149, 130, 30);
		frame.getContentPane().add(firstVal);
		firstVal.setVisible(false);
		
		
		middlename = new JLabel("Middle Name "); 
		middlename.setBounds(50, 200, 250, 20); 
		middlename.setFont(new Font("Serif", Font.PLAIN, 20));
		
		middletext = new JTextField(); 
		middletext.setBounds(250, 200, 250, 30);
		
		    l3 = new JLabel( 
				"Last Name"); 
			l3.setBounds(50, 250, 250, 20); 
			l3.setFont(new Font("Serif", Font.PLAIN, 20));

			tf2 = new JTextField(); 
			tf2.setBounds(250, 250, 250, 30); 

			l4 = new JLabel("Email ID"); 
			l4.setBounds(50, 300, 250, 20); 
			l4.setFont(new Font("Serif", Font.PLAIN, 20));

			tf3 = new JTextField(); 
			tf3.setBounds(250, 300, 250, 30); 

			l5 = new JLabel("Contact Number"); 
			l5.setBounds(50, 350, 250, 20); 
			l5.setFont(new Font("Serif", Font.PLAIN, 20));

			tf4 = new JTextField(); 
			tf4.setBounds(250, 350, 250, 30); 
		    
//			contactVal=new JTextField();
//			contactVal.setBounds(450, 350, 250, 30);
//			add(contactVal);
		    
			

			l6 = new JLabel("Gender"); 
			l6.setBounds(50, 400, 250, 20); 
			l6.setFont(new Font("Serif", Font.PLAIN, 20));

			JRadioButton r5 
			= new JRadioButton("Male"); 
			r5.setActionCommand("Male");
		   JRadioButton r6 
			= new JRadioButton("Female"); 
		   
		   r6.setActionCommand("Female");

		r5.setBounds(250, 400, 100, 30); 
		r6.setBounds(350, 400, 100, 30); 

		ButtonGroup bg = new ButtonGroup(); 
		bg.add(r5); 
		bg.add(r6);
		
		l7 = new JLabel("Country"); 
		l7.setBounds(50, 450, 250, 20); 
		l7.setFont(new Font("Serif", Font.PLAIN, 20));

		tf5 = new JTextField(); 
		tf5.setBounds(250, 450, 250, 30); 
		
		l8=new JLabel("State"); 
		l8.setBounds(50,500,250,20);
		l8.setFont(new Font("Serif", Font.PLAIN, 20));
		
		String states[] 
				=  {
						"------select-------",
						"AP",
		            "Arunachal",
		            "Assam",
		            "Bihar",
		            "Chhattisgarh",
		            "Goa",
		            "Gujarat",
		            "Haryana",
		            "HimachalPradesh",
		            "Jammu",
		            "Jharkhand",
		            "Karnataka",
		            "Kerala",
		            "MadhyaPradesh",
		            "Maharashtra",
		            "Manipur",
		            "Meghalaya",
		            "Mizoram",
		            "Nagaland",
		            "Odisha",
		            "Punjab",
		            "Rajasthan",
		            "Sikkim",
		            "Tamil Nadu",
		            "Telangana",
		            "Tripura",
		            "Uttarakhand",
		            "Uttar Pradesh",
		            "West Bengal",
		            "Andaman ",
		            "Chandigarh",
		            "Dadra",
		            "Daman and Diu",
		            "Delhi",
		            "Lakshadweep",
		            "Puducherry"}; 
		
		cb1= new JComboBox(states); 
		cb1.setBounds(250,500,250,20);
		
		l9 = new JLabel("City"); 
		l9.setBounds(50, 550, 250, 20); 
		l9.setFont(new Font("Serif", Font.PLAIN, 20));

		tf6 = new JTextField(); 
		tf6.setBounds(250, 550, 250, 30); 
		
		pincode = new JLabel("Pin Code"); 
		pincode.setBounds(50, 600, 250, 20); 
		pincode.setFont(new Font("Serif", Font.PLAIN, 20));

		pintext = new JTextField(); 
		pintext.setBounds(250, 600, 250, 30); 
		
		l10 = new JLabel("Password"); 
		l10.setBounds(50,650,250,20);
		l10.setFont(new Font("Serif", Font.PLAIN, 20));
		
		tf7=new JPasswordField();
		tf7.setBounds(250,650,250,30);
		
		l11 = new JLabel("Confirm Password"); 
		l11.setBounds(50,700,250,20);
		l11.setFont(new Font("Serif", Font.PLAIN, 20));
		
		
		tf8=new JPasswordField();
		tf8.setBounds(250,700,250,30);
		//tf8.setBorder(new LineBorder(Color.red,1));
		
		
		JButton b=new JButton("Register");  
		b.setBounds(150,750,100,40);
		
		JButton clear=new JButton("Clear");
		clear.setBounds(150,800,100,40);
		
		
		frame.add(l1); 
		frame.add(l2); 
		frame.add(l3);
		frame.add(l4); 
		frame.add(l5); 
		frame.add(l6); 
		frame.add(l7);
		frame.add(l8);
		frame.add(l9);
		frame.add(l10);
		frame.add(l11);
		frame.add(tf1); 
		frame.add(tf2); 
		frame.add(tf3); 
		frame.add(tf4); 
		frame.add(tf6);
		frame.add(tf7);
		frame.add(tf5);
		frame.add(tf8);
		frame.add(r5); 
		frame.add(middlename);
		frame.add(pincode);
		frame.add(pintext);
		frame.add(middletext);
		frame.add(r6); 
		frame.add(cb1);
		frame.add(b);
		frame.add(back);
		frame.add(clear);
		
		
		
		tf1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                 tf1.setEditable(true);
                
            }
            @Override
            public void focusLost(FocusEvent e) {
            	
                if((tf1.getText().length() == 0)) 
                {
                	tf1.setBorder(new LineBorder(Color.red,1));
                	firstVal.setVisible(true);
                }
                
            }
        });	
		
		tf1.addKeyListener(new KeyAdapter() {
		public void keyReleased(KeyEvent e) {
			if(!(tf1.getText().length() == 0))
        	{
            	tf1.setBorder(new LineBorder(Color.gray,1));
            	firstVal.setVisible(false);
            }
        	
        	if(tf1.getText().length()>10)
            {
            	JOptionPane.showMessageDialog(null, "only 10 characters allowed");
            	//tf1.setText("");
            }
		}
            
		});
		tf1.addKeyListener(new KeyAdapter(){
	        public void keyReleased(KeyEvent e){
	        	
	        	char ch = e.getKeyChar();
	            if(!(Character.isLetter(ch)|| (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE )){
	            	//e.consume();
	            	tf1.setBorder(new LineBorder(Color.red,1));
	            	firstVal.setVisible(true);
	              }
	            else
	            {
	            	tf1.setBorder(new LineBorder(Color.gray,1));
                	firstVal.setVisible(false);
	            }
	        	
	         }
	        });
		
		
		
		
		tf2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
            	
            }
            @Override
            public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
            	 if((tf2.getText().length() == 0)) 
                 {
                 	tf2.setBorder(new LineBorder(Color.red,1));
                 	lastNameVal.setVisible(true);
                 }
            }
        });
		
		tf2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(!(tf2.getText().length() == 0))
	        	{
	            	tf2.setBorder(new LineBorder(Color.gray,1));
	            	lastNameVal.setVisible(false);
	            }
	        	
	        	if(tf2.getText().length()>10)
	            {
	            	JOptionPane.showMessageDialog(null, "only 10 characters allowed");
	            	tf2.setText("");
	            }
			}
	            
			});
		
		tf2.addKeyListener(new KeyAdapter(){
	        public void keyReleased(KeyEvent e){
	        	
	        	char ch = e.getKeyChar();
	            if(!(Character.isLetter(ch)|| (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE )){
	            	//e.consume();
	            	tf2.setBorder(new LineBorder(Color.red,1));
	            	lastNameVal.setVisible(true);
	              }
	            else
	            {
	            	tf2.setBorder(new LineBorder(Color.gray,1));
                	lastNameVal.setVisible(false);
	            }
	        	
	         }
	        });
		tf3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                 tf3.setEditable(true);
            }
            @Override
            public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
            	 String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	        	 Pattern p = Pattern.compile(EMAIL_REGEX);
	                Matcher m = p.matcher(tf3.getText()); 
	                if((!m.matches()))
		        	 {
		        		tf3.setBorder(new LineBorder(Color.red,1));
		             	emailVal.setVisible(true);
		        	 }
	                else
	                {
	                	tf3.setBorder(new LineBorder(Color.gray,1));
		             	emailVal.setVisible(false);
	                }
       
            }
        });
		
		tf3.addKeyListener(new KeyAdapter(){
	        public void keyTyped(KeyEvent e){
	        	 char ch = e.getKeyChar();
	        	 if((tf3.getText().length()>25 || (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE)) 
	                {
	        		 e.consume();
	                }
	        }
	           
	        });
		
		
		
		
		
		
		tf4.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                 tf4.setEditable(true);
            }
            @Override
            public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
            	if((tf4.getText().length()>10 || tf4.getText().length()<10)) 
            		
                {
                	tf4.setBorder(new LineBorder(Color.red,1));
                	contactValid.setVisible(true);
                }
                else
                {
                	tf4.setBorder(new LineBorder(Color.gray,1));
                	contactValid.setVisible(false);
                }
                
            }
        });
		

		tf4.addKeyListener(new KeyAdapter(){
	        public void keyReleased(KeyEvent e){
	        	 char ch = e.getKeyChar();
	        	//System.out.println(tf4.getText().length());
	        	 if(tf4.getText().length()==10) {
	        		
	        		 tf4.setBorder(new LineBorder(Color.gray,1));
	        		 
	        		 contactValid.setVisible(false);
	        		 
	        	 }
	        	 if((Character.isLetter(ch)|| (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE)) 
	                {
	        	         e.consume();
	        	         tf4.setBorder(new LineBorder(Color.red,1));
		        		 contactValid.setVisible(true);
//	        		 pinValid.setVisible(false);
	                }
	        	 else
	        	 {
	        		tf4.setBorder(new LineBorder(Color.gray,1));
//	             	pinValid.setVisible(true);
	        	 }
	        }
	           
	        });
		
		tf4.addKeyListener(new KeyAdapter(){
	        public void keyTyped(KeyEvent e){
	        	 char ch = e.getKeyChar();
	        	 if((tf4.getText().length()>9 || (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE)) 
	                {
	        		 e.consume();
	        		 tf4.setBorder(new LineBorder(Color.gray,1));
	        		 contactValid.setVisible(false);
	                }
	        }
	           
	        });
		
		
		
		pintext.addKeyListener(new KeyAdapter(){
	        public void keyReleased(KeyEvent e){
	        	 char ch = e.getKeyChar();
	        	//System.out.println(pintext.getText().length());
	        	 if(pintext.getText().length()==6 || pintext.getText().length()<6) {
	        		
	        		 pintext.setBorder(new LineBorder(Color.gray,1));
		             	pinValid.setVisible(false);
	        	 }
	        	 if((Character.isLetter(ch)|| (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE)) 
	                {
	        	         //e.consume();
//	        		 pinValid.setVisible(false);
	                }
	        	 if(pintext.getText().length()>6 || Character.isLetter(ch) )
	        	 {
	        		pintext.setBorder(new LineBorder(Color.red,1));
	             	pinValid.setVisible(true);
	        	 }
	        }
	           
	        });
		
		pintext.addKeyListener(new KeyAdapter(){
	        public void keyTyped(KeyEvent e){
	        	 char ch = e.getKeyChar();
	        	 if((pintext.getText().length()>5 || (ch==KeyEvent.VK_BACK_SPACE)|| ch==KeyEvent.VK_DELETE)) 
	                {
	        		 e.consume();
	        		 pintext.setBorder(new LineBorder(Color.gray,1));
		             	pinValid.setVisible(false);
	                }
	        }
	           
	        });
		
		
		
		
		tf7.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                 tf7.setEditable(true);
                  }
            @Override
            public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
            	String regex = "^(?=.*[0-9])"
                        + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=.*[@#$%^&+=])"; 
            	Pattern p = Pattern.compile(regex); 
                // Pattern class contains matcher() method 
                // to find matching between given password 
                // and regular expression. 
                Matcher m = p.matcher(tf7.getText()); 
                if(!m.matches()&&tf7.getText().length()<8 )
                {
	        		tf7.setBorder(new LineBorder(Color.red,1));
	        		pwdVal.setVisible(true);
	             	
	                }
	        	 else
	        	 {
	        		tf7.setBorder(new LineBorder(Color.gray,1));
	        		pwdVal.setVisible(false);
	        	 }
            }
        });	
		
		tf8.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                 tf8.setEditable(true);
            }
            @Override
            public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
            	if (!Arrays.equals(tf7.getPassword(),tf8.getPassword())) {
            		
            		//e.consume();
            		//System.out.println(tf7.getPassword());
            		//System.out.println(tf8.getPassword());
	        		tf8.setBorder(new LineBorder(Color.red,1));
	             	confirmVal.setVisible(true);
	             }
	        	 else
	        	 {
	        		tf8.setBorder(new LineBorder(Color.gray,1));
	        		
	        		confirmVal.setVisible(false);
	        	 } 
            }
        });	
		
	             b.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
	             String firstName = tf1.getText();
	             String middleName=middletext.getText();
	             String lastName = tf2.getText();
	             String mobileNumber = tf4.getText();
	             String emailId = tf3.getText();
	             String gender=bg.getSelection().getActionCommand().toString();
	             String city = tf6.getText();
	             String country=tf5.getText();
	             String state = cb1.getSelectedItem().toString();
	             String pincode = pintext.getText();
	             String password = tf7.getText();
	             String confirm = tf8.getText();
	         

	             String msg = "" + firstName;
	             msg += " \n";

	             try {
	                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=FALSE", "root", "root1234");


	                String query = "INSERT INTO User values('"+ emailId +"','" + firstName + "','" + middleName + "','" + lastName + "','" + mobileNumber + "','"+ gender +"')";
	               
	                  //PreparedStatement preparedStmt = conn.prepareStatement(query);
	                 Statement sta = connection.createStatement();
	                 int x = sta.executeUpdate(query);
//	                 if (x == 0) 
//	                 {
//	                     JOptionPane.showMessageDialog(b, "User alredy exist");
//	                 } 
//	                 else 
//	                 {
//	                     JOptionPane.showMessageDialog(b,
//	                         "Welcome, " + msg + "Your account is sucessfully created");
//	                 }
	                 
	                 String query1= "INSERT INTO Authentication values('"+ emailId +"','" + password + "','" + confirm + "')";
	                 sta.executeUpdate(query1);
	                 String query2= "INSERT INTO Address values('"+ emailId +"','" + city + "','" + state + "','"+ pincode +"','"+ country +"')";
	                 sta.executeUpdate(query2);
	                 
	                 PreparedStatement st = (PreparedStatement) connection.prepareStatement("select Email from user where Email ='" +emailId+"'");
                     st.setString (1,emailId);
                     ResultSet rs = st.executeQuery();
	                 if(rs.next()){
	                	 JOptionPane.showMessageDialog(b,"User alredy exist");
	                	 
	                 }
	                 else 
	                 {
	                     JOptionPane.showMessageDialog(b,
	                         "Welcome, " + msg + "Your account is sucessfully created");
	                 }
	                 connection.close();
	                 } 
	            catch (Exception exception) 
	             {
	                 exception.printStackTrace();
	             }
	         }
	     });
	
	back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			
			new Mainpage(); 
			//main.setVisible(true);
			//dispose();
		}

	});
		
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				tf1.setText("");
				tf2.setText("");
				tf3.setText(""); 
				tf4.setText(""); 
				tf5.setText("");
				tf6.setText("");
				middletext.setText("");
				pintext.setText("");
				tf8.setText("");
				tf7.setText("");
				}
});

	frame.setSize(800,900);  
	frame.getContentPane().setLayout(null); 
	
	lastNameVal = new JLabel("Please Enter Last Name");
	lastNameVal.setForeground(Color.RED);
	lastNameVal.setBounds(521, 249, 172, 30);
	frame.getContentPane().add(lastNameVal);
	lastNameVal.setVisible(false);
	
	emailVal = new JLabel("Enter Valid Email");
	emailVal.setForeground(Color.RED);
	emailVal.setBounds(521, 299, 172, 30);
	emailVal.setVisible(false);
	frame.getContentPane().add(emailVal);
	
	contactValid = new JLabel("Enter Valid Contact Number");
	contactValid.setForeground(Color.RED);
	contactValid.setBounds(521, 350, 186, 30);
	frame.getContentPane().add(contactValid);
	contactValid.setVisible(false);
	
	pwdVal = new JLabel("Enter a password with length 8 ");
	pwdVal.setForeground(Color.RED);
	pwdVal.setBounds(521, 650, 253, 30);
	frame.getContentPane().add(pwdVal);
	pwdVal.setVisible(false);
	
	confirmVal = new JLabel("Password Doesn't Match");
	confirmVal.setForeground(Color.RED);
	confirmVal.setBounds(521, 700, 172, 30);
	frame.getContentPane().add(confirmVal);
	confirmVal.setVisible(false);
	
	pinValid = new JLabel("Please Enter 6 digits");
	pinValid.setForeground(Color.RED);
	pinValid.setBounds(521, 599, 172, 30);
	frame.getContentPane().add(pinValid);
	pinValid.setVisible(false);
}
}
