/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author Dr Rakesh Malhotra
 */
public class consoletry {
   public static void console(final InputStream out, final PrintWriter in) {
    //final JTextArea area = new JTextArea();

    // handle "System.out"
    new SwingWorker<Void, String>() {
        @Override protected Void doInBackground() throws Exception {
            Scanner s = new Scanner(out);
            while (s.hasNextLine()) publish(s.nextLine() + "\n");
            return null;
        }
        @Override protected void process(List<String> chunks) {
            for (String line : chunks) frontend.FrontEnd.statuswindow.append(line);
        }
    }.execute();

    // handle "System.in"
    

//    return area;
}
public static void main(String[] args) throws IOException {

    // 1. create the pipes
    PipedInputStream inPipe = new PipedInputStream();
    PipedInputStream outPipe = new PipedInputStream();

    // 2. set the System.in and System.out streams
    System.setIn(inPipe);
    System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));

    PrintWriter inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);

    // 3. create the gui 
    JFrame frame = new JFrame("\"Console\"");
    console(outPipe, inWriter);
    //jt.setEditable(false);
    //frame.add(jt);
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
Scanner s = new Scanner(System.in);
    
    // 4. write some output (to JTextArea)
    //System.out.println("Hello World!");
    //System.out.println("Test");
    //System.out.println("Test");
    //System.out.println("Test");
    
    //jt.setEditable(true);
    // 5. get some input (from JTextArea)
    //System.out.printf("got from input: \"%s\"%n", s.nextLine());
}
 
}
