import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	private JFrame frame;
	JLabel title,email,password;
	JTextField emailtext;
	JPasswordField pwdtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);  
		title= new JLabel("SIGN IN"); 
		title.setBounds(200, 50, 350, 50);
		title.setFont(new Font("Serif", Font.PLAIN, 40));
		frame.add(title);
		
		email = new JLabel("Email"); 
		email.setBounds(50, 150, 250, 20); 
		email.setFont(new Font("Serif", Font.PLAIN, 20));
		frame.add(email);
		
		emailtext = new JTextField(); 
		emailtext.setBounds(200, 150, 250,30); 
		frame.add(emailtext);
		
		password = new JLabel("Password"); 
		password.setBounds(50, 200, 250, 20); 
		password.setFont(new Font("Serif", Font.PLAIN, 20));
		frame.add(password);
		
		pwdtext=new JPasswordField();
		pwdtext.setBounds(200, 200, 250, 30);
		frame.add(pwdtext);
		
		JButton login =new JButton("LOGIN");
		login.setBounds(150,250, 100, 30);
		frame.add(login);
		
	
		 frame.setSize(700,700);  
		 frame.setLayout(null); 
		 login.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                String Email = emailtext.getText();
	                String password = pwdtext.getText();
	         
	                
	              try {
	                     if((emailtext.getText().length()==0)||(pwdtext.getText().length()==0)) {
	                         JOptionPane.showMessageDialog(login, "Enter Username & Password");
	                         //login.setEnabled(false);
	                     }
	                     
	                     if((emailtext.getText().length()!=0)&&(pwdtext.getText().length()!=0)){
	                    	 //login.setEnabled(true);
	                    	 Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user",
	     	                        "root", "root1234");

	     	             PreparedStatement st = (PreparedStatement) connection
	     	                        .prepareStatement("Select Email, pwd from  Authentication where Email=? and pwd=?");
	                    st.setString (1,Email);
	                    st.setString( 2,password);
	                    ResultSet rs = st.executeQuery();
	                    //System.out.println(rs);
	                    if (rs.next()) {
	                       
	                        JOptionPane.showMessageDialog(login, "You have successfully logged in");
	                    } else {
	                        JOptionPane.showMessageDialog(login, "Wrong Username & Password");
	                    }
	                     }
	                   
	                }
	                 catch (SQLException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	            }
	        });	
		 }
	

}
