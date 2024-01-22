/*
 * MainApp.java
 */
package lab.scd.net.browser;

import javax.swing.JFrame;

public class MainApp extends JFrame{
    
    public MainApp(){
    		Browser b = new Browser();
    		getContentPane().add(b);
    		pack();
    		setVisible(true);
    		}

    public static void main(String args[])
    	{
        MainApp s = new MainApp();
    	}
  
}