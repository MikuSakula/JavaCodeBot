package QQ;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
public class Code {
	static boolean flag = false;
	public static void main(String[] args) throws AWTException {
		JFrame f = new JFrame("全自动代码编辑器");
		f.setSize(800,600);
		f.setLocation(200,200);
		f.setLayout(null);		
		f.setResizable(false);		
		

		JButton c = new JButton("开始全自动写代码！");
		c.setFont(new Font("宋体",Font.BOLD,20));
		c.setBounds(200, 300, 400, 50);   
		c.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// f.setVisible(false);
				if(!flag) {
					flag = true;
				 try {
					new BOT().Boom();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 f.setVisible(true);
				}
				 else
					 System.exit(0);
				
			}
		});
 
        f.add(c);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
class BOT{
	String sentence=null;
	int times;
	public BOT(String sentence, int times) {
		this.sentence = sentence;
		this.times = times;
	}
	
	public BOT() {	}
	

	public void Boom() throws AWTException {
		String sentence = this.sentence;
		Robot robot=null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.delay(3000);
		//robot.keyPress(93);
		
		String path = "C:\\Users\\Administrator\\Desktop\\code1.txt";
		File src = new File(path);	
		System.out.println("****");
		BufferedReader is =null;
		try {
			is = new BufferedReader (new FileReader(path));
			String line =null;
			while(((line=is.readLine())!=null) ){
				System.out.println(line);
				for (int j = 0; j < line.length();j++) {
					//System.out.println(line.charAt(j));
					if(line.charAt(j)>='0'&&line.charAt(j)<='9') {
						robot.keyPress(line.charAt(j));
						robot.keyRelease(line.charAt(j));
					}
					else if(line.charAt(j)>='a'&&line.charAt(j)<='z') {
						robot.keyPress(line.charAt(j)-32);
						robot.keyRelease(line.charAt(j)-32);
					}
					else if(line.charAt(j)>='A'&&line.charAt(j)<='Z') {
						robot.keyPress(16);
						robot.keyPress(line.charAt(j));
						robot.keyRelease(line.charAt(j));
						robot.keyRelease(16);
						
					}
					else if(line.charAt(j)=='{') {
						robot.keyPress(16);
						robot.keyPress(91);
						robot.keyRelease(91);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='}') {
						robot.keyPress(16);
						robot.keyPress(93);
						robot.keyRelease(93);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='(') {
						robot.keyPress(16);
						robot.keyPress(57);
						robot.keyRelease(57);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)==')') {
						robot.keyPress(16);
						robot.keyPress(48);
						robot.keyRelease(48);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='"') {
						robot.keyPress(16);
						robot.keyPress(222);
						robot.keyRelease(222);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='&') {  //106
						robot.keyPress(16);
						robot.keyPress(55);
						robot.keyRelease(55);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='<') {
						robot.keyPress(16);
						robot.keyPress(44);
						robot.keyRelease(44);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='>') {
						robot.keyPress(16);
						robot.keyPress(46);
						robot.keyRelease(46);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='#') {
						robot.keyPress(16);
						robot.keyPress(51);
						robot.keyRelease(51);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='+') {
						robot.keyPress(16);
						robot.keyPress(61);
						robot.keyRelease(61);
						robot.keyRelease(16);
					}

					else if(line.charAt(j)=='*') {
						robot.keyPress(16);
						robot.keyPress(56);
						robot.keyRelease(56);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='|') {
						robot.keyPress(16);
						robot.keyPress(92);
						robot.keyRelease(92);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='!') {
						robot.keyPress(16);
						robot.keyPress(49);
						robot.keyRelease(49);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='%') {
						robot.keyPress(16);
						robot.keyPress(53);
						robot.keyRelease(53);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)==':') {
						robot.keyPress(16);
						robot.keyPress(59);
						robot.keyRelease(59);
						robot.keyRelease(16);
					}
					else if(line.charAt(j)=='_') {
						robot.keyPress(16);
						robot.keyPress(45);
						robot.keyRelease(45);
						robot.keyRelease(16);
					}
					else {
						if(line.charAt(j)>0&&line.charAt(j)<106) {
							robot.keyPress(line.charAt(j));
							robot.keyRelease(line.charAt(j));
						}
						
					}
					
					robot.delay(20);
				}
				robot.keyPress(10);
				robot.keyRelease(10);
			}
			
			
			
		} catch (FileNotFoundException e) {		
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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

