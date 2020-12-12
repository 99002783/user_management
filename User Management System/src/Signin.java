import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Signin {
	JLabel title,email,password;
	JTextField emailtext;
	JPasswordField pwdtext;
	
	JFrame f= new JFrame();
	Signin()
	{
		f.setVisible(true);  
		title= new JLabel("SIGN IN"); 
		title.setBounds(200, 50, 350, 50);
		title.setFont(new Font("Serif", Font.PLAIN, 40));
		f.add(title);
		
		email = new JLabel("Email"); 
		email.setBounds(50, 150, 250, 20); 
		email.setFont(new Font("Serif", Font.PLAIN, 20));
		f.add(email);
		
		
		emailtext = new JTextField(); 
		emailtext.setBounds(200, 150, 250,30); 
		f.add(emailtext);
		
		password = new JLabel("Password"); 
		password.setBounds(50, 200, 250, 20); 
		password.setFont(new Font("Serif", Font.PLAIN, 20));
		f.add(password);
		
		pwdtext=new JPasswordField();
		pwdtext.setBounds(200, 200, 250, 30);
		f.add(pwdtext);
		
		JButton login =new JButton("LOGIN");
		login.setBounds(150,250, 100, 30);
		f.add(login);
		

		 f.setSize(700,900);  
		 f.setLayout(null); 
		 login.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                String email = emailtext.getText();
	                String password = pwdtext.getText();
	                try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user",
	                        "root", "root1234");

	                    PreparedStatement st = (PreparedStatement) connection
	                        .prepareStatement("Select Email, pwd from  Authentication where Email=? and pwd=?");

	                    st.setString(1,email);
	                    st.setString(2,password);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                        
	                        JOptionPane.showMessageDialog(login, "You have successfully logged in");
	                    } else {
	                        JOptionPane.showMessageDialog(login, "Wrong Username & Password");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
	            }
	        });
		
	}
	

	public static void main(String[] args) 
	{ 
		new Signin(); 
	}

}
