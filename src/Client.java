
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.io.*;
public class Client extends JFrame implements ActionListener   
{
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JTextArea a1;
	
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
Client(){
	
	 p1 = new JPanel();
     p1.setLayout(null);
     p1.setBackground(new Color(7, 94, 84));
     p1.setBounds(0, 0, 450, 50);
     add(p1);
	
	ImageIcon i1 = new ImageIcon( ClassLoader.getSystemResource("icons/3.png"));
	Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);
	JLabel l1 = new JLabel(i3);
	l1.setBounds(10, 10, 30, 30);
	p1.add(l1);
	
	l1.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent ae){
            System.exit(0);
        }
    });
	
	
	ImageIcon i4 = new ImageIcon( ClassLoader.getSystemResource("icons/dhoni1.jpg"));
	Image i5 = i4.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
	ImageIcon i6 = new ImageIcon(i5);
	JLabel l2 = new JLabel(i6);
	l2.setBounds(40, 8, 35, 35);
	p1.add(l2);
	
	ImageIcon i7 = new ImageIcon( ClassLoader.getSystemResource("icons/3icon.png"));
	Image i8 = i7.getImage().getScaledInstance(15, 30, Image.SCALE_DEFAULT);
	ImageIcon i9 = new ImageIcon(i8);
	JLabel l5 = new JLabel(i9);
	l5.setBounds(320, 10, 15, 30);
	p1.add(l5);
	
	
	ImageIcon i10 = new ImageIcon( ClassLoader.getSystemResource("icons/video.png"));
	Image i11 = i10.getImage().getScaledInstance(25, 35, Image.SCALE_DEFAULT);
	ImageIcon i12 = new ImageIcon(i11);
	JLabel l6 = new JLabel(i12);
	l6.setBounds(280, 8, 25, 35);
	p1.add(l6);
	
	
	ImageIcon i13 = new ImageIcon( ClassLoader.getSystemResource("icons/phone.png"));
	Image i14 = i13.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
	ImageIcon i16 = new ImageIcon(i14);
	JLabel l7 = new JLabel(i16);
	l7.setBounds(240, 10, 30, 30);
	p1.add(l7);
	
	
	JLabel l3 = new JLabel("Dhoni");
    l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
    l3.setForeground(Color.WHITE);
    l3.setBounds(80, 5, 90, 16);
    p1.add(l3);   
    
    
    JLabel l4 = new JLabel("Active Now");
    l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
    l4.setForeground(Color.WHITE);
    l4.setBounds(80, 25, 90, 18);
    p1.add(l4);
    
    
    a1 = new JTextArea();
    a1.setBounds(5, 52, 340, 410);
    a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
    a1.setEditable(false);
    a1.setLineWrap(true);
    a1.setWrapStyleWord(true);
    add(a1);
    
    t1 = new JTextField();
    t1.setBounds(5, 465, 270, 30);
    t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
    add(t1);
    
    
    b1 = new JButton("Send");
    b1.setBounds(275, 465, 70, 30);
    b1.setBackground(new Color(7, 94, 84));
    b1.setForeground(Color.WHITE);
    b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
    b1.addActionListener(this);
    add(b1);
    
	
	getContentPane().setBackground(Color.DARK_GRAY);
	setLayout(null);
	setSize(350, 500);
	setLocation(850,150);
	setUndecorated(true);
	setVisible(true);
}


public void actionPerformed(ActionEvent ae) {
	try{
	//String msginput ="";	
	String out = t1.getText();
	a1.setText(a1.getText()+"\n\t\t\t"+out);
	dout.writeUTF(out);
	t1.setText("");
	}catch(Exception e) {}
}
public static void main (String args[]) {
	new Client().setVisible(true); 

	try {
		String msginput = "";
		s = new Socket("127.0.0.1", 4000);
		din = new DataInputStream (s.getInputStream());
		dout = new DataOutputStream (s.getOutputStream());
		
		while(!msginput.equals("exit")) {
		msginput = din.readUTF();
		a1.setText(a1.getText()+"\n"+msginput);

		}
		//s.close();
	}
	catch(Exception e) {}
}
}
