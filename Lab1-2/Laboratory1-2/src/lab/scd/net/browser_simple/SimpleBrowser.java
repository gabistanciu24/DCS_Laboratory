/*
 * SimpleBrowser.java
 */
package lab.scd.net.browser_simple;



import javax.swing.*;

import java.io.*;
import java.util.Properties;

public class SimpleBrowser {
    
public static void main(String[] args) {
    
    Properties props = System.getProperties();

	String initialPage = "http://google.com";

	JEditorPane jep = new JEditorPane( );
	jep.setEditable(false);
	jep.addHyperlinkListener(new LinkFollower(jep));

	try {
	    jep.setPage(initialPage);
	}
	catch (IOException e) {
		System.err.println("Usage: java SimpleWebBrowser url");
		System.err.println(e);
		System.exit(-1);
	}
	
	// set up the window
	JScrollPane scrollPane = new JScrollPane(jep);
	JFrame f = new JFrame("Simple Web Browser");
	f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	f.setContentPane(scrollPane);
	f.setSize(512, 342);
	f.setVisible(true);

	}
}