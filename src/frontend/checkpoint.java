package frontend;

import backend.ScanFile;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class checkpoint extends JPanel implements ActionListener {

    private static HashMap<JButton, ArrayList<Integer>> map = new HashMap<JButton, ArrayList<Integer>>();
    ArrayList<Integer> list;
    static int incr = 0;
    static Integer fin_line = 0;
    static Integer ini_line = 0;
   // public static JButton reset;
    int ct;

    public checkpoint(int count) {
        //System.out.println("  checkpoint(count) is called  ");

        setLayout(new FlowLayout());
        ct = count;
        JButton button;
        //System.out.println("asdfghjkl" + count);
        

        JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        

        for (int i = 1; i <= count; i++) {
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> al = new ArrayList<Integer>();
            //  for (int j = 0; j < 3; j++) {

            Integer temp = i;
            al.add(temp);
            sb.append("");
            //}

            button = new JButton(sb.toString().trim());
            // button.setBorder(null);
            button.setName("button" + i);
            button.setMargin(new Insets(6, 6, 6, 6));
            button.addActionListener(this);
            button.setBorderPainted(false);
            button.setFocusable(false);
            button.setToolTipText(temp.toString());
            button.setContentAreaFilled(false);
            button.setOpaque(false);
            map.put(button, al);
            checkPanel.add(button);
        }
add(checkPanel);





    }
    public static void reset() 
            {
                incr = 0;
             Set<JButton> checklist = map.keySet();
                Iterator itr = checklist.iterator();
                ini_line=0;
                fin_line=0;
                while (itr.hasNext()) {
                    JButton b = (JButton) itr.next();
                    b.setIcon(null);
                    b.setEnabled(true);

                }
              //  FrontEnd.steprun.setVisible(true);
            }

    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();

        //if (e.getStateChange() == ItemEvent.SELECTED) {

        list = (map.get(source));
        incr++;
        //}
        source.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/resources/circle_red.png")));
        source.setPreferredSize(new Dimension(20, 10));
        
        if (incr == 1) {
            ini_line = list.get(0);
        }
        fin_line = list.get(0);
        if (incr == 2) {
            incr = 0;
            Set<JButton> checklist = map.keySet();
            Iterator itr = checklist.iterator();
            while (itr.hasNext()) {
                JButton b = (JButton) itr.next();
                if (b.getIcon() == null) {
                    b.setEnabled(false);
                }
            }


        }

        if (ini_line > fin_line) {
            int t = ini_line;
            ini_line = fin_line;
            fin_line = t;
        }

        handlers.assignIniFin(ini_line.intValue(), fin_line.intValue());
    }
}
