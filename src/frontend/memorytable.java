/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author win-7
 */
public class memorytable extends JPanel {
	static Dimension dimension;
	memorytable()
    {
        label=new JLabel("Memory Table");
        contain=new JScrollPane();
        jumpTable=new JTable();
        int range=1000;
        Object[][] obj2 = new Object[range][2];

        for(int i=0;i<range;i++)
        {

            obj2[i][0]="    ";
            obj2[i][1]="    ";
        }
        model2 = new javax.swing.table.DefaultTableModel(obj2,
            new String [] {"Memory Location", "Memory Contents"});

        jumpTable.setModel(model2);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
    	
        dimension = toolkit.getScreenSize();
        
        contain.setViewportView(jumpTable);
        contain.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contain.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        contain.setPreferredSize(new Dimension(dimension.width/3,dimension.height));
        //add(label,BorderLayout.PAGE_START);
        add(contain,BorderLayout.CENTER);
    }
    public static void main(String args[])
    {	
        memorytable scrollpane=new memorytable();
        JFrame frame = new JFrame("FileTreeDemo");
    frame.getContentPane().add(scrollpane);
   frame.setSize(2*dimension.width/9,600);
    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);    
    frame.setVisible(true);
    }
    JLabel label;
    JScrollPane contain;
    JTable jumpTable;
    public static DefaultTableModel model2;
    
}
