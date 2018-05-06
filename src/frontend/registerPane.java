package frontend;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *


import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author win-7
 *
public class registerPane extends JPanel{
    GridLayout experimentLayout = new GridLayout(11,4,10,10);
    registerPane()
    {
        this.setLayout(experimentLayout);
        experimentLayout.layoutContainer(this);
        r0=new JLabel("R0");
        r1=new JLabel("R1");
        r2=new JLabel("R2");
        r3=new JLabel("R3");
        r4=new JLabel("R4");
        r5=new JLabel("R5");
        r6=new JLabel("R6");
        r7=new JLabel("R7");
        r8=new JLabel("R8");
        r9=new JLabel("R9");
        r10=new JLabel("R10");
        r11=new JLabel("R11");
        r12=new JLabel("R12");
        r13=new JLabel("R13");
        r14=new JLabel("R14");
        r15=new JLabel("R15");
//        cpsr=new JLabel("CPSR");
        z=new JLabel("Z");
        n=new JLabel("N");
        c=new JLabel("C");
        v=new JLabel("V");
        r0_t=new JTextField("");
        r1_t=new JTextField("");
        r2_t=new JTextField("");
        r3_t=new JTextField("");
        r4_t=new JTextField("");
        r5_t=new JTextField("");
        r6_t=new JTextField("");
        r7_t=new JTextField("");
        r8_t=new JTextField("");
        r9_t=new JTextField("");
        r10_t=new JTextField("");
        r11_t=new JTextField("");
        r12_t=new JTextField("");
        r13_t=new JTextField("");
        r14_t=new JTextField("");
        r15_t=new JTextField("");
//        cpsr_t=new JTextField("");
        z_t=new JTextField("");
        n_t=new JTextField("");
        c_t=new JTextField("");
        v_t=new JTextField("");
        
        r0_t.setEditable(false);
    r1_t.setEditable(false);
    r2_t.setEditable(false);
    r3_t.setEditable(false);
    r4_t.setEditable(false);
    r5_t.setEditable(false);
    r6_t.setEditable(false);
    r7_t.setEditable(false);
    r8_t.setEditable(false);
    r9_t.setEditable(false);
    r10_t.setEditable(false);
    r11_t.setEditable(false);
    r12_t.setEditable(false);
    r13_t.setEditable(false);
    r14_t.setEditable(false);
    r15_t.setEditable(false);
    
    z_t.setEditable(false);
    n_t.setEditable(false);
    c_t.setEditable(false);
    v_t.setEditable(false);
    
        add(r0);
        add(r0_t);
        add(r1);
        add(r1_t);
        add(r2);
        add(r2_t);
        add(r3);
        add(r3_t);
        add(r4);
        add(r4_t);
        add(r5);
        add(r5_t);
        add(r6);
        add(r6_t);
        add(r7);
        add(r7_t);
        add(r8);
        add(r8_t);
        add(r9);
        add(r9_t);
        add(r10);
        add(r10_t);
        add(r11);
        add(r11_t);
        add(r12);
                add(r12_t);
        add(r13);
        add(r13_t);
        add(r14);
        add(r14_t);
        add(r15);
        add(r15_t);
        
        add(n);
        add(n_t);
        add(z);
        add(z_t);
        add(c);
        add(c_t);
        add(v);
        add(v_t);
        //add(cpsr);
        //add(cpsr_t);
        
    
    }
    public static void main(String args[])
    {
        registerPane scrollpane=new registerPane();
        JFrame frame = new JFrame("FileTreeDemo");
    frame.getContentPane().add(scrollpane, "Center");
    frame.setSize(400,600);
    frame.setVisible(true);
    }
    JLabel r0;
    JLabel r1;
    JLabel r2;
    JLabel r3;
    JLabel r4;
    JLabel r5;
    JLabel r6;
    JLabel r7;
    JLabel r8;
    JLabel r9;
    JLabel r10;
    JLabel r11;
    JLabel r12;
    JLabel r13;
    JLabel r14;
    JLabel r15;
    //JLabel cpsr;
    JLabel z;
    JLabel n;
    JLabel c;
    JLabel v;
    JTextField r0_t;
    JTextField r1_t;
    JTextField r2_t;
    JTextField r3_t;
    JTextField r4_t;
    JTextField r5_t;
    JTextField r6_t;
    JTextField r7_t;
    JTextField r8_t;
    JTextField r9_t;
    JTextField r10_t;
    JTextField r11_t;
    JTextField r12_t;
    JTextField r13_t;
    JTextField r14_t;
    JTextField r15_t;
    //JTextField cpsr_t;
    JTextField z_t;
    JTextField n_t;
    JTextField c_t;
    JTextField v_t;
    
     
    
}
*/


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class registerPane extends MyPanel{
    
 

    public registerPane() {
        GridBagLayout gbl=new GridBagLayout();
        
        setLayout(gbl);
       
      r0=new JLabel("R0",SwingConstants.CENTER);
        r1=new JLabel("R1",SwingConstants.CENTER);
        r2=new JLabel("R2",SwingConstants.CENTER);
        r3=new JLabel("R3",SwingConstants.CENTER);
        r4=new JLabel("R4",SwingConstants.CENTER);
        r5=new JLabel("R5",SwingConstants.CENTER);
        r6=new JLabel("R6",SwingConstants.CENTER);
        r7=new JLabel("R7",SwingConstants.CENTER);
        r8=new JLabel("R8",SwingConstants.CENTER);
        r9=new JLabel("R9",SwingConstants.CENTER);
        r10=new JLabel("R10",SwingConstants.CENTER);
        r11=new JLabel("R11",SwingConstants.CENTER);
        r12=new JLabel("R12",SwingConstants.CENTER);
        r13=new JLabel("R13(sp)",SwingConstants.CENTER);
        r14=new JLabel("R14(lr)",SwingConstants.CENTER);
        r15=new JLabel("R15(pc)",SwingConstants.CENTER);
//        cpsr=new JLabel("CPSR");
        z=new JLabel("Z",SwingConstants.CENTER);
        n=new JLabel("N",SwingConstants.CENTER);
        c=new JLabel("C",SwingConstants.CENTER);
        v=new JLabel("V",SwingConstants.CENTER);
        r0_t=new MyTextField("");
        r1_t=new MyTextField("");
        r2_t=new MyTextField("");
        r3_t=new MyTextField("");
        r4_t=new MyTextField("");
        r5_t=new MyTextField("");
        r6_t=new MyTextField("");
        r7_t=new MyTextField("");
        r8_t=new MyTextField("");
        r9_t=new MyTextField("");
        r10_t=new MyTextField("");
        r11_t=new MyTextField("");
        r12_t=new MyTextField("");
        r13_t=new MyTextField("");
        r14_t=new MyTextField("");
        r15_t=new MyTextField("");
//        cpsr_t=new JTextField("");
        z_t=new MyTextField("");
        n_t=new MyTextField("");
        c_t=new MyTextField("");
        v_t=new MyTextField("");
        
        r0_t.setEditable(false);
    r1_t.setEditable(false);
    r2_t.setEditable(false);
    r3_t.setEditable(false);
    r4_t.setEditable(false);
    r5_t.setEditable(false);
    r6_t.setEditable(false);
    r7_t.setEditable(false);
    r8_t.setEditable(false);
    r9_t.setEditable(false);
    r10_t.setEditable(false);
    r11_t.setEditable(false);
    r12_t.setEditable(false);
    r13_t.setEditable(false);
    r14_t.setEditable(false);
    r15_t.setEditable(false);
    
    z_t.setEditable(false);
    n_t.setEditable(false);
    c_t.setEditable(false);
    v_t.setEditable(false);
     
      
      
      
    //lang_decide.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Decimal", "Binary", "Hexadecimal", "Octal" }));

    //lang_decide.setPreferredSize(new Dimension(500,25));
    //lang_decide.setPrototypeDisplayValue("XXXXXXXXXXX");
    
//l2.setVisible(false);


     GridBagConstraints gbc = makeGbc2(2, 0);
      //add(lang_decide,gbc);
      //gbc=makeGbc2(3,0);
      //add(l2,gbc);
      gbc = makeGbc(0,1);
      //r0.setMaximumSize(new Dimension(20,20));
        add(r0,gbc);
         gbc = makeGbc2(1,1);
        add(r0_t,gbc);
         gbc = makeGbc(2,1);
        add(r1,gbc);
         gbc = makeGbc2(3,1);
        add(r1_t,gbc);
         gbc = makeGbc(0,2);
        add(r2,gbc);
         gbc = makeGbc2(1,2);
        add(r2_t,gbc);
         gbc = makeGbc(2,2);
        add(r3,gbc);
         gbc = makeGbc2(3,2);
        add(r3_t,gbc);
         gbc = makeGbc(0,3);
        add(r4,gbc);
         gbc = makeGbc2(1,3);
        add(r4_t,gbc);
         gbc = makeGbc(2,3);
        add(r5,gbc);
         gbc = makeGbc2(3,3);
        add(r5_t,gbc);
         gbc = makeGbc(0,4);
        add(r6,gbc);
         gbc = makeGbc2(1,4);
        add(r6_t,gbc);
         gbc = makeGbc(2,4);
        add(r7,gbc);
         gbc = makeGbc2(3,4);
        add(r7_t,gbc);
         gbc = makeGbc(0,5);
        add(r8,gbc);
         gbc = makeGbc2(1,5);
        add(r8_t,gbc);
         gbc = makeGbc(2,5);
        add(r9,gbc);
         gbc = makeGbc2(3,5);
        add(r9_t,gbc);
         gbc = makeGbc(0,6);
        add(r10,gbc);
         gbc = makeGbc2(1,6);
        add(r10_t,gbc);
         gbc = makeGbc(2,6);
        add(r11,gbc);
         gbc = makeGbc2(3,6);
        add(r11_t,gbc);
         gbc = makeGbc(0,7);
        add(r12,gbc);
         gbc = makeGbc2(1,7);
                add(r12_t,gbc);
         gbc = makeGbc(2,7);
        add(r13,gbc);
         gbc = makeGbc2(3,7);
        add(r13_t,gbc);
         gbc = makeGbc(0,8);
        add(r14,gbc);
         gbc = makeGbc2(1,8);
        add(r14_t,gbc);
         gbc = makeGbc(2,8);
        add(r15,gbc);
         gbc = makeGbc2(3,8);
        add(r15_t,gbc);
        gbc = makeGbc(0,9);
        add(n,gbc);
         gbc = makeGbc2(1,9);
        add(n_t,gbc);
         gbc = makeGbc(2,9);
        add(z,gbc);
        gbc = makeGbc2(3,9);
        add(z_t,gbc);
        gbc = makeGbc(0,10);
        add(c,gbc);
        gbc = makeGbc2(1,10);
        add(c_t,gbc);
        gbc = makeGbc(2,10);
        add(v,gbc);
        gbc = makeGbc2(3,10);
        add(v_t,gbc);
    }

    private GridBagConstraints makeGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        
       gbc.gridwidth = 1;
        gbc.gridheight = 1;
      gbc.ipadx=0;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = (x == 0) ? GridBagConstraints.LINE_START : GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }
private GridBagConstraints makeGbc2(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //gbc.ipadx=10;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = (x == 0) ? GridBagConstraints.LINE_START : GridBagConstraints.LINE_END;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }
    private static void createAndShowUI() {
        JFrame frame = new JFrame("Register Pane");
        frame.getContentPane().add(new registerPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
       
       
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
    
   

        JLabel r0;
    JLabel r1;
    JLabel r2;
    JLabel r3;
    JLabel r4;
    JLabel r5;
    JLabel r6;
    JLabel r7;
    JLabel r8;
    JLabel r9;
    JLabel r10;
    JLabel r11;
    JLabel r12;
    JLabel r13;
    JLabel r14;
    JLabel r15;
    //JLabel cpsr;
    JLabel z;
    JLabel n;
    JLabel c;
    JLabel v;
    public static JTextField r0_t;
    public static JTextField r1_t;
    public static JTextField r2_t;
    public static JTextField r3_t;
    public static JTextField r4_t;
    public static JTextField r5_t;
    public static JTextField r6_t;
    public static JTextField r7_t;
    public static JTextField r8_t;
    public static JTextField r9_t;
    public static JTextField r10_t;
    public static JTextField r11_t;
    public static JTextField r12_t;
    public static JTextField r13_t;
    public static JTextField r14_t;
    public static JTextField r15_t;
    //JTextField cpsr_t;
    public static JTextField z_t;
    public static JTextField n_t;
    public static JTextField c_t;
    public static JTextField v_t;

}



 class MyPanel extends JPanel {
     public static JPopupMenu menu;
     handlers h;
    public MyPanel() {
      super();
      h=new handlers();
      addMouseListener(new PopupTriggerListener());
       menu = new javax.swing.JPopupMenu();
JMenuItem lang1 = new JMenuItem("Decimal");
    lang1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                h.update(0);
      }
    });
    menu.add(lang1);
JMenuItem lang2 = new JMenuItem("Binary");
    lang2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                h.update(1);
      }
    });
    menu.add(lang2);
JMenuItem lang3 = new JMenuItem("Hexadecimal");
    lang3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                h.update(2);
      }
    });
    menu.add(lang3);
JMenuItem lang4 = new JMenuItem("Octal");
    lang4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                h.update(3);
      }
    });
    menu.add(lang4);

    }

    class PopupTriggerListener extends MouseAdapter {
      public void mousePressed(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
          menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
      }

      public void mouseReleased(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
          menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
      }

      public void mouseClicked(MouseEvent ev) {
      }
    }
  }


  class MyTextField extends JTextField {
     public static JPopupMenu menu;
     handlers h;
    public MyTextField(String t) {
      super(t);
      h=new handlers();
      addMouseListener(new PopupTriggerListener());
       menu = new javax.swing.JPopupMenu();
JMenuItem lang1 = new JMenuItem("Decimal");
    lang1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                h.update(0);
      }
    });
    menu.add(lang1);
JMenuItem lang2 = new JMenuItem("Binary");
    lang2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                h.update(1);
      }
    });
    menu.add(lang2);
JMenuItem lang3 = new JMenuItem("Hexadecimal");
    lang3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                h.update(2);
      }
    });
    menu.add(lang3);
JMenuItem lang4 = new JMenuItem("Octal");
    lang4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                h.update(3);
      }
    });
    menu.add(lang4);

    }

    class PopupTriggerListener extends MouseAdapter {
      public void mousePressed(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
          menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
      }

      public void mouseReleased(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
          menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
      }

      public void mouseClicked(MouseEvent ev) {
      }
    }
  }

