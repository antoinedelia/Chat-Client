import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class GUI extends JFrame{
	  private Panel mPanel = new Panel();
	    private Panel tPanel= new Panel();
	    private Label tLabel;
	    private Label cLabel;
	    
	    /** Construction de la fenêtre d'affichage principale */
	    public GUI() {
	        super();
	        setTitle("Chatexar");
	        setSize(800,800);
	       
	        Panel mainPanel = new Panel();
	        BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
	        add(mainPanel);
	        this.mPanel = mainPanel;
	        addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent we) {
	                dispose();
	             }
	          });
	        
	         show();
	          
	    } 

}
