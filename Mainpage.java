import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.*; 
public class Mainpage {

	public static void main(String[] args) {  
		JFrame f=new JFrame();//creating instance of JFrame  
		
		JLabel l1 = new JLabel("User Management System"); 
		l1.setBounds(120, 50, 450, 50);
		l1.setFont(new Font("Serif", Font.PLAIN, 40));          
		JButton add=new JButton("Register User");//creating instance of JButton  
		JButton signin=new JButton("Sign In");
		add.setBounds(250,150,150, 40);//x axis, y axis, width, height  
		signin.setBounds(250,200,150, 40);         
		f.add(add);//adding button in JFrame
		f.add(signin);
		f.add(l1);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//f.dispose();
				new form();
			}

		});
		
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//f.dispose();
				new Login();
			}

		});
		         
		f.setSize(700,600);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		}  
}

