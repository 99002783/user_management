import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class TextValidation extends JFrame{
JTextField text;
JLabel label;
JPanel p;
TextValidation(){
text=new JTextField(15);
label=new JLabel("Enter number:");
p=new JPanel();
p.add(label);
p.add(text);
text.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){

                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                }
                else{
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
                    text.setText(" ");
                }
            }
});
add(p);
setVisible(true);
setSize(300,100);
}
public static void main(String[]args){
TextValidation v=new TextValidation();
}
}