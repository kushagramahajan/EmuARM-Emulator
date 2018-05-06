/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import backend.Memory;
import backend.ScanFile;
import backend.SetBreakpoint;
import backend.StepRun;
import backend.step_out;
import backend.step_over;

/**
 *
 * @author win-7
 */
public class handlers {
	public static int cntn=0;
	//whether it is run from the command line or not
	public static int cmd_var=0;
    public static String tables="";
	private int num = 0;
    public static int countOpened = 0;
    public static int no_of_rem=0;
   // public static Highlighter.HighlightPainter whitePainter;
    public static ArrayList<String> a=new ArrayList<String>();
    public static ArrayList<Integer> a_end=new ArrayList<Integer>();
    public static ArrayList<Integer> unsort_a_end=new ArrayList<Integer>();
    
    public static Highlighter.HighlightPainter cyanPainter;
    public static int counter=0;
    public static int counter_track=0;
    int temflag=1;
    public handlers() {
        cyanPainter = new DefaultHighlighter.DefaultHighlightPainter(
                Color.cyan);
              
    }

    void newFile() {
    	if(handlers.cmd_var==1){
        	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
        	}
        	else{
            
        FrontEnd.statuswindow.append("Opening Blank File..\n");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
        try {
            FrontEnd.activepane = new JEditorPane();
            JScrollPane scroll = new JScrollPane();
            scroll.setViewportView(FrontEnd.activepane);
            FrontEnd.activepane.setEditorKit(new NumberedEditorKit());
            FrontEnd.activepane.setText(" ");
            //FrontEnd.EditorPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/resources/1309349801_Cut.png"))); // NOI18N
            ImageIcon icon1=new ImageIcon(getClass().getResource("/resources/circle_red.png"));
            
            //JLabel l1=new JLabel(icon1);
            
            FrontEnd.EditorPane.addTab("Untitled" + num + ".s",icon1, scroll,"Untitled" + num + ".s");
            FrontEnd.EditorPane.setIconAt(num,icon1);
            //FrontEnd.EditorPane.add(l1,scroll);
            
            FrontEnd.activepane.setHighlighter(new frontend.MyHighlighter());
            FrontEnd.activepane.setSelectionColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));

            num++;
            countOpened++;

            FrontEnd.EditorPane.setTabComponentAt(countOpened - 1, new ButtonTabComponent(FrontEnd.EditorPane));
            FrontEnd.EditorPane.setSelectedIndex(countOpened - 1);
            FrontEnd.filepath = null;
            backend.FirstPass.branchtable = null;
            backend.FirstPass.branchtable = new Hashtable();
            new Memory();
            backend.Register.resetRegisters();
            clean_branchtable();
            clean_memtable();
            //setTitle(filename);
            if(handlers.cmd_var==1){
            	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
            	}
            	else{
                
            FrontEnd.statuswindow.append("New blank file opened..\n");
            FrontEnd.statuswindow.setCaretPosition(FrontEnd.statuswindow.getText().length());}

        } catch (Exception e) {
        	if(handlers.cmd_var==1){
            	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
            	}
            	else{
                
            FrontEnd.statuswindow.append("Some error occured while opening new file\n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            e.printStackTrace();}

        }
    }

    void openfile() {

        FrontEnd.statuswindow.append("Opening File..\n");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
        backend.Register.resetRegisters();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new MyCustomFilter());
        int returnVal = fileChooser.showOpenDialog(new javax.swing.JFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                // What to do with the file, e.g. display it in a TextArea


                open(file);
                backend.Register.resetRegisters();
                clean_branchtable();
                clean_memtable();
            } catch (Exception ex) {
            	if(handlers.cmd_var==1){
                	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                	}
                	else{
                    
                FrontEnd.statuswindow.append("problem accessing file" + file.getAbsolutePath() + "\n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                	}
            }
        } else {
        	if(handlers.cmd_var==1){
            	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
            	}
            	else{
                
            FrontEnd.statuswindow.append("File access cancelled by user.\n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            	}
        }    // TODO add your handling code here:

    }

    void savefile() {
    	if(handlers.cmd_var==1){
        	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
        	}
        	else{
            
        FrontEnd.statuswindow.append("Saving File...\n");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
        int id = FrontEnd.EditorPane.getSelectedIndex();
        if (FrontEnd.EditorPane.getToolTipTextAt(id) == null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new MyCustomFilter());
            int returnVal = fileChooser.showSaveDialog(new javax.swing.JFrame());
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try {

                    FrontEnd.filepath = fileChooser.getSelectedFile().getPath() + ".s";
                    File n = new File(FrontEnd.filepath);
                    BufferedWriter out = new BufferedWriter(new FileWriter(FrontEnd.filepath));
                    //DefaultMutableTreeNode node = new DefaultMutableTreeNode(n.getName(), false);
                    // ft.curDir.insert(node, ft.curDir.getChildCount());
                    // node.setParent(ft.curDir);
                    //((DefaultTreeModel) ft.tree.getModel()).reload();
                    out.write(FrontEnd.activepane.getText());
                    String fname = fileChooser.getSelectedFile().getName();
                    JOptionPane.showMessageDialog(null, "Saved " + ((fileChooser.getSelectedFile() != null) ? fname : "nothing"));
                    FrontEnd.EditorPane.setTitleAt(id, fname);
                    FrontEnd.EditorPane.setToolTipTextAt(id, FrontEnd.filepath);
                    out.close();
                    backend.Register.resetRegisters();
                    clean_branchtable();
                    clean_memtable();

                } catch (Exception e) {
                    FrontEnd.statuswindow.append("Error occured while saving file...\n");
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                    FrontEnd.statuswindow.append(e.getStackTrace().toString());
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                    JOptionPane.showMessageDialog(null, "Saving File cancelled.");
                    frontend.FrontEnd.exceptionraised++;
                    e.printStackTrace();
                }
            } else {
            	if(handlers.cmd_var==1){
                	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                	}
                	else{
                    
                FrontEnd.statuswindow.append("Saving cancelled by user.\n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                	}
            	}
        } else {
            BufferedWriter out = null;
            try {
                FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(id);
                out = new BufferedWriter(new FileWriter(FrontEnd.filepath));
                out.write(FrontEnd.activepane.getText());
            } catch (IOException ex) {
            	if(handlers.cmd_var==1){
                	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                	}
                	else{
                    
            	FrontEnd.statuswindow.append("Error occured while saving file...\n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                	if(handlers.cmd_var==1){
                    	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                    	}
                    	else{
                        
                    FrontEnd.statuswindow.append("Error occured while saving file...\n");
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                    FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                    //frontend.FrontEnd.exceptionraised++;
                    	}
                    	
                    	}
            }

        }
    }

    void exit() {
        System.exit(0);
    }

    void cut() {
        String sel = FrontEnd.activepane.getSelectedText();
        StringSelection ss = new StringSelection(sel);
        FrontEnd.clip.setContents(ss, ss);
        FrontEnd.activepane.replaceSelection(" ");
    }

    void copy() {
        String sel = FrontEnd.activepane.getSelectedText();
        StringSelection clipString = new StringSelection(sel);
        FrontEnd.clip.setContents(clipString, clipString);
    }

    void paste() {
        Transferable cliptran = FrontEnd.clip.getContents(this);
        try {
            String sel = (String) cliptran.getTransferData(DataFlavor.stringFlavor);
            FrontEnd.activepane.replaceSelection(sel);
        } catch (Exception ex) {
            Logger.getLogger(handlers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void run() {
    	
    	FrontEnd.exceptionraised = 0;
        new Memory();
        backend.Register.resetRegisters();
        clean_branchtable();
        clean_memtable();

        backend.Register.r[14].b = backend.ScanFile.endOfProgram;

        BufferedWriter out = null;
        File fin = null;

        int id = FrontEnd.EditorPane.getSelectedIndex();
        if (FrontEnd.EditorPane.getToolTipTextAt(id) != null) {
            FrontEnd.statuswindow.append("Saving File...\n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            try {
                FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(id);
                fin = new File(FrontEnd.filepath);
                out = new BufferedWriter(new FileWriter(fin));
                out.write(FrontEnd.activepane.getText());
            } catch (IOException ex) {
                FrontEnd.statuswindow.append("Error occured while saving file...\n");
                FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    FrontEnd.statuswindow.append("Error occured while saving file...\n");
                    FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                    frontend.FrontEnd.exceptionraised++;
                }
            }
            FrontEnd.statuswindow.append("Compiling source file " + FrontEnd.filepath + "\n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            clean_branchtable();

            clean_memtable();
            Integer ct = new Integer(0);
            ct = backend.FirstPass.scan(fin);
            //System.out.print("ct returned :" + ct);
            FrontEnd.statuswindow.append("run :\n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            try {
                backend.ScanFile ob = new backend.ScanFile(fin);
                update_branchtable(ct);
                update(0);

            }
            catch (Exception e) {
            }
        } else {
            try {
                // Create temp file.
                File temp = File.createTempFile("temp", ".s");

                FrontEnd.filepath = null;
                out = null;
                try {

                    out = new BufferedWriter(new FileWriter(temp));
                    out.write(FrontEnd.activepane.getText());
        
                } catch (IOException ex) {
                    FrontEnd.statuswindow.append("Error occured ...\n");
                    FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                } finally {
                    try {
                        out.close();
                    } catch (IOException ex) {
                        FrontEnd.statuswindow.append("Error occured ...\n");
                        FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                        //frontend.FrontEnd.exceptionraised++;
                    }
                }
                
                FrontEnd.statuswindow.append("Compiling source file \n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                clean_branchtable();

                clean_memtable();
                Integer ct = new Integer(0);
                ct = backend.FirstPass.scan(temp);
                //System.out.print("ct returned :" + ct);
                FrontEnd.statuswindow.append("run :\n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                try {
                    backend.ScanFile ob = new backend.ScanFile(temp);
                    update_branchtable(ct);
                    update(0);

                } catch (Exception e) {
                }
                // Delete temp file when program exits.
                temp.deleteOnExit();

                // Write to temp file
                //BufferedWriter out = new BufferedWriter(new FileWriter(temp));
                //out.write("aString");
                //out.close();
            } catch (IOException e) {
            }
        }




    }
    
    
    public static void main(String args,String tables){
    	FrontEnd.exceptionraised = 0;
    	cmd_var=1;
    	handlers.tables=tables;
        new Memory();
        backend.Register.resetRegisters();
//        clean_branchtable();
   //     clean_memtable();
//System.out.println("kjj");
        backend.Register.r[14].b = backend.ScanFile.endOfProgram;

        BufferedWriter out = null;
        File fin = null;
        
        
        try {
            File temp = new File(args);

            FrontEnd.filepath = args;
            out = null;

            System.out.println("Compiling source file \n");
//            clean_branchtable();
//
//            clean_memtable();
            Integer ct = new Integer(0);
            ct = backend.FirstPass.scan(temp);
            //System.out.print("ct returned :" + ct);
            System.out.println("run :\n");
            try {
                backend.ScanFile ob = new backend.ScanFile(temp);
                update_branchtable(ct);
                update(0);

            } catch (Exception e) {
            }
            
            //out.write("aString");
            //out.close();
        } catch (Exception e) {
        }


    }
    
    
    
    static int ini_line = 0, fin_line = 0;

    static void assignIniFin(int a, int b) {
        ini_line = a;
        fin_line = b;
        //System.out.println(ini_line + "" + fin_line + " in assignIniFin");
    }
    public static int debugMode = 0;

    void stepover() {
        frontend.FrontEnd.steprun.setVisible(true);
        debugMode = 2;
    }
    
    public void helper(){
    	FrontEnd.exceptionraised = 0;
      new Memory();
      backend.Register.resetRegisters();
      clean_branchtable();
      clean_memtable();
  	
      int id = FrontEnd.EditorPane.getSelectedIndex();
      
  	BufferedWriter out = null;
      File fin = null;
     
      int caretpos = frontend.FrontEnd.activepane.getCaretPosition();
      
      int end = ScanFile.getLineNumber(frontend.FrontEnd.activepane,caretpos);
             
      FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(id);
      fin = new File(FrontEnd.filepath);
      backend.ScanFile.path = fin;
      
      try{
      	out = new BufferedWriter(new FileWriter(fin));
          out.write(FrontEnd.activepane.getText());
          out.close();
          
      	
      	
      
       	RandomAccessFile b = new RandomAccessFile(fin, "r");
      	String l="";
      	
      	for(int i=0;i<end;i++){
      		l=b.readLine();
      	}
      	
      	b.close();
      	
      	//remove highlight for breakpoint
      	
//      	FrontEnd.activepane.setHighlighter(new frontend.MyHighlighter());
//        FrontEnd.activepane.setSelectionColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));
      	
      	if(a_end.contains(end)){
      		//String str=b.readLine();
            int start=0;
            int ending=0;
            int cn=0;
            Highlighter.Highlight[] hilites=frontend.FrontEnd.activepane.getHighlighter().getHighlights();
            
            
            String text=FrontEnd.activepane.getText();
            
            while ((ending = text.indexOf('\n', start)) >= 0) {
            	cn++;
            	if(cn==end){
            		int i=unsort_a_end.indexOf(cn);
            		
            		//System.out.println(i+ "          "+cn);
            		if(Test.rem_flag==1){
            			int w=a_end.indexOf(end);
                  		int y=unsort_a_end.indexOf(end);
                  		a_end.remove(w);
                  		unsort_a_end.remove(y);
                  		//System.out.println(a_end.size());
                  		
                  		a.remove(w);
                  		counter-=2;
                  		counter_track=0;
                  		//FrontEnd.continue_bp.setEnabled(false);
                  		if(counter==0){
                  			FrontEnd.enab=false;
                  			backend.ScanFile.temflag=0;
                  		}
            			frontend.FrontEnd.activepane.getHighlighter().removeHighlight(hilites[0]);
            		}
            		else{
//                        int w=a_end.indexOf(end);
//                  		int y=unsort_a_end.indexOf(end);
//                  		a_end.remove(w);
//                  		unsort_a_end.remove(y);
//                  		
//                  		a.remove(w);

            			frontend.FrontEnd.activepane.getHighlighter().removeHighlight(hilites[0]);
            			//frontend.FrontEnd.activepane.getHighlighter().addHighlight(start, ending+1, whitePainter);
            			//frontend.FrontEnd.statuswindow.append(start+"   "+ending+1);

            		}
            		break;
            	}
            		
            	start = ending+1;
            }
            int w=a_end.indexOf(end);
      		int y=unsort_a_end.indexOf(end);
      		a_end.remove(w);
      		unsort_a_end.remove(y);
      		
      		a.remove(w);
      		counter-=2;
      		counter_track=0;
      		//FrontEnd.continue_bp.setEnabled(false);
      		if(counter==0){
      			FrontEnd.enab=false;
      			backend.ScanFile.temflag=0;
      		}
            
      	}
      	else{
      		
       	a.add(l);
      	a_end.add(end);
      	unsort_a_end.add(end);
      	int n=a_end.size();
      	for (int j = 1; j < n; j++) {
              int key = a_end.get(j);
              String s=a.get(j);
              int i = j-1;
              while ( (i > -1) && ( a_end.get(i) > key ) ) {
               a_end.set(i+1, a_end.get(i));
               a.set(i+1, a.get(i));
               i--;
              }
              a_end.set(i+1, key);
              a.set(i+1, s);
      	}
      	}
      	
      	
      }
      
      catch(Exception e){
    	  
      }
      
     
      }
    
    void bp1(int val_bp){
    	if(val_bp==0){
    		FrontEnd.exceptionraised = 0;
            new Memory();
            backend.Register.resetRegisters();
            clean_branchtable();
            clean_memtable();

    	}
//        	System.out.println();
       	try{
        	File fin=null;
        	fin = new File(FrontEnd.filepath);
        	
        	backend.ScanFile.br = new RandomAccessFile(fin, "r");
            backend.ScanFile.br.seek(0);
            
            backend.ScanFile.pos = backend.ScanFile.br.getFilePointer();
            obj4=new SetBreakpoint();
            obj4.Set_Breakpoint(a);
           // backend.ScanFile ob=new ScanFile(fin,obj4,end);
       	
                
        Integer ct = new Integer(0);
        ct = backend.FirstPass.scan(fin);
        //System.out.print("ct returned :" + ct);
        FrontEnd.statuswindow.append("run :\n");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
        
            backend.ScanFile ob = new backend.ScanFile(fin,obj4,a_end,val_bp);
            update_branchtable(ct);
            update(0);
       	}
          	catch(Exception e){
           		
           	}
     
     }

        
    
    
    
    void stepout() {
        frontend.FrontEnd.steprun.setVisible(true);
        debugMode = 1;
        //steprun2();

        /*
         * BufferedWriter out = null; backend.Register.resetRegisters();
         * clean_branchtable(); clean_memtable(); try { FrontEnd.exceptionraised
         * = 0; File fin = null; int id =
         * FrontEnd.EditorPane.getSelectedIndex(); backend.Register.r[15].b = 0;
         *
         *
         * backend.ScanFile.curent_line = new Integer(0); if
         * (FrontEnd.EditorPane.getToolTipTextAt(id) != null) {
         * FrontEnd.statuswindow.append("Saving File...\n");
         * frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
         * try { FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(id);
         * fin = new File(FrontEnd.filepath); out = new BufferedWriter(new
         * FileWriter(fin)); out.write(FrontEnd.activepane.getText());
         * FrontEnd.statuswindow.append("Compiling source file " +
         * FrontEnd.filepath + "\n");
         * frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
         * //StepRunWindow obj = new StepRunWindow(new javax.swing.JFrame(),
         * true); backend.ScanFile.path = fin; backend.ScanFile.br = new
         * RandomAccessFile(fin, "r"); // int ct_line = 0; //
         * backend.ScanFile.br.seek(0);
         *
         * // String file_text = frontend.FrontEnd.activepane.getText(); //
         * String[] lines = file_text.split("\r\n|\r|\n"); // ct_line =
         * lines.length; // System.out.println("number of lines " + ct_line);
         *
         * backend.ScanFile.pos = backend.ScanFile.br.getFilePointer();
         * //obj.call(fin); FrontEnd.steprun.setVisible(true);
         *
         * // f = 0; // b = new checkpoint(ct_line); // FrontEnd.addTab(b);
         *
         *
         *
         * } catch (IOException ex) { FrontEnd.statuswindow.append("Error
         * occured while saving file...\n");
         * FrontEnd.statuswindow.append(ex.getStackTrace().toString());
         * frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
         * } finally { try { out.close(); } catch (IOException ex) {
         * FrontEnd.statuswindow.append("Error occured while saving file...\n");
         * FrontEnd.statuswindow.append(ex.getStackTrace().toString());
         * frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
         * frontend.FrontEnd.exceptionraised++; } }
         *
         * } else { try { // Create temp file. File temp =
         * File.createTempFile("temp", ".s"); FrontEnd.filepath = null; out =
         * null; try { out = new BufferedWriter(new FileWriter(temp));
         * out.write(FrontEnd.activepane.getText());
         * //statuswindow.append("Compiling source file " + filepath + "\n"); //
         * StepRunWindow obj = new StepRunWindow(new javax.swing.JFrame(),
         * true); backend.ScanFile.path = temp; // obj.call(temp);
         * backend.ScanFile.br = new RandomAccessFile(temp, "rw");
         * backend.ScanFile.pos = backend.ScanFile.br.getFilePointer();
         * FrontEnd.steprun.setVisible(true); //int ct_line = 0;
         * backend.ScanFile.br.seek(0);
         *
         * //String file_text = frontend.FrontEnd.activepane.getText(); //
         * String[] lines = file_text.split("\r\n|\r|\n"); // ct_line =
         * lines.length; // System.out.println("number of lines " + ct_line);
         *
         * backend.ScanFile.pos = backend.ScanFile.br.getFilePointer();
         * //obj.call(fin); FrontEnd.steprun.setVisible(true);
         *
         * // f = 0; //b = new checkpoint(ct_line); //FrontEnd.addTab(b);
         *
         * } catch (IOException ex) { FrontEnd.statuswindow.append("Error
         * occured ...\n");
         * FrontEnd.statuswindow.append(ex.getStackTrace().toString());
         * frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
         * } finally { try { out.close(); } catch (IOException ex) {
         * FrontEnd.statuswindow.append("Error occured ...\n");
         * FrontEnd.statuswindow.append(ex.getStackTrace().toString());
         * frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
         * //frontend.FrontEnd.exceptionraised++; } } // Delete temp file when
         * program exits. temp.deleteOnExit();
         *
         * // Write to temp file //BufferedWriter out = new BufferedWriter(new
         * FileWriter(temp)); //out.write("aString"); //out.close(); } catch
         * (IOException e) { } }
         *
         *
         *
         *
         * //*********************************************** //
         * sActionPerformed(evt);
         *
         * // TODO add your handling code here: } catch (Exception ex) {
         * Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null,
         * ex); }
         *
         */

    }

    void stepinto() {
        debugMode = 0;
        checkpoint.reset();
        backend.StepRun.transfer = 0;
        backend.step_over.otransfer = 0;
        backend.step_out.common = 0;
        backend.step_out.call = false;
        backend.step_out.next = 0;
        backend.step_over.ocall = false;
        backend.step_over.ocommon = 0;
        backend.step_out.i = 0;
        backend.step_out.j = 0;
        backend.step_over.k = 0;
        backend.step_over.onext = 0;
        ini_line = 0;
        fin_line = 0;
        backend.StepRun.ini_line = 0;
        backend.StepRun.fin_line = 0;
        backend.StepRun.initial_pos = 0;
        BufferedWriter out = null;
        backend.Register.resetRegisters();
        clean_branchtable();
        clean_memtable();
        FrontEnd.run_stepOut.setEnabled(true);
        FrontEnd.run_stepOver.setEnabled(true);

        FrontEnd.r_stepOut.setEnabled(true);
        FrontEnd.r_stepover.setEnabled(true);

        FrontEnd.reset.setEnabled(true);
        try {
            FrontEnd.exceptionraised = 0;
            File fin = null;
            int id = FrontEnd.EditorPane.getSelectedIndex();
            backend.Register.r[15].b = 0;


            backend.ScanFile.curent_line = new Integer(0);
            if (FrontEnd.EditorPane.getToolTipTextAt(id) != null) {
                FrontEnd.statuswindow.append("Saving File...\n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                try {
                    FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(id);
                    fin = new File(FrontEnd.filepath);
                    out = new BufferedWriter(new FileWriter(fin));
                    out.write(FrontEnd.activepane.getText());
                    FrontEnd.statuswindow.append("Compiling source file " + FrontEnd.filepath + "\n");
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                    //StepRunWindow obj = new StepRunWindow(new javax.swing.JFrame(), true);
                    backend.ScanFile.path = fin;
                    backend.ScanFile.br = new RandomAccessFile(fin, "r");
                    int ct_line = 0;
                    backend.ScanFile.br.seek(0);

                    String file_text = frontend.FrontEnd.activepane.getText();
                    String[] lines = file_text.split("\r\n|\r|\n");
                    ct_line = lines.length;
                    //System.out.println("number of lines " + ct_line);

                    backend.ScanFile.pos = backend.ScanFile.br.getFilePointer();
                    //obj.call(fin);
                    FrontEnd.steprun.setVisible(true);

                    f = 0;
                    b = new checkpoint(ct_line);
                    FrontEnd.addTab(b);



                } catch (IOException ex) {
                    FrontEnd.statuswindow.append("Error occured while saving file...\n");
                    FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                } finally {
                    try {
                        out.close();
                    } catch (IOException ex) {
                        FrontEnd.statuswindow.append("Error occured while saving file...\n");
                        FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                        frontend.FrontEnd.exceptionraised++;
                    }
                }

            } else {
                try {
                    // Create temp file.
                    File temp = File.createTempFile("temp", ".s");
                    FrontEnd.filepath = null;
                    out = null;
                    try {
                        out = new BufferedWriter(new FileWriter(temp));
                        out.write(FrontEnd.activepane.getText());
                        //statuswindow.append("Compiling source file " + filepath + "\n");
                        // StepRunWindow obj = new StepRunWindow(new javax.swing.JFrame(), true);
                        backend.ScanFile.path = temp;
                        // obj.call(temp);
                        backend.ScanFile.br = new RandomAccessFile(temp, "rw");
                        backend.ScanFile.pos = backend.ScanFile.br.getFilePointer();
                        FrontEnd.steprun.setVisible(true);
                        int ct_line = 0;
                        backend.ScanFile.br.seek(0);

                        String file_text = frontend.FrontEnd.activepane.getText();
                        String[] lines = file_text.split("\r\n|\r|\n");
                        ct_line = lines.length;
                        //System.out.println("number of lines " + ct_line);

                        backend.ScanFile.pos = backend.ScanFile.br.getFilePointer();
                        //obj.call(fin);
                        FrontEnd.steprun.setVisible(true);

                        f = 0;
                        b = new checkpoint(ct_line);
                        FrontEnd.addTab(b);

                    } catch (IOException ex) {
                        FrontEnd.statuswindow.append("Error occured ...\n");
                        FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                    } finally {
                        try {
                            out.close();
                        } catch (IOException ex) {
                            FrontEnd.statuswindow.append("Error occured ...\n");
                            FrontEnd.statuswindow.append(ex.getStackTrace().toString());
                            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                            //frontend.FrontEnd.exceptionraised++;
                        }
                    }
                    // Delete temp file when program exits.
                    temp.deleteOnExit();

                    // Write to temp file
                    //BufferedWriter out = new BufferedWriter(new FileWriter(temp));
                    //out.write("aString");
                    //out.close();
                } catch (IOException e) {
                }
            }




            //***********************************************
//            sActionPerformed(evt);

            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update_memorytable(int memref_ct) {
        Object[][] obj = backend.Memory.disp_mem;

        clean_memtable();
        for (int i = 0; i < memref_ct; i++) {
            memorytable.model2.addRow(obj[i]);
   
        }
    }

    public static void clean_branchtable() {
        int c = JumpTable.model2.getRowCount();
        for (int i = c - 1; i >= 0; i--) {
            JumpTable.model2.removeRow(i);

        }
    }

    public static void clean_memtable() {
        int c = memorytable.model2.getRowCount();
        for (int i = c - 1; i >= 0; i--) {
            memorytable.model2.removeRow(i);

        }
    }

    public void open(File file) {
        int ob;
        if ((ob = check_if_open(file.getAbsolutePath())) != -1) {
            FrontEnd.EditorPane.setSelectedIndex(ob);
        } else {
            backend.Register.resetRegisters();
            try {
                FrontEnd.activepane = new JEditorPane();
                JScrollPane scroll = new JScrollPane();
                //   JScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
                scroll.setViewportView(FrontEnd.activepane);
                FrontEnd.activepane.setEditorKit(new NumberedEditorKit());
                FrontEnd.activepane.setHighlighter(new frontend.MyHighlighter());
                FrontEnd.activepane.setSelectionColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));

                FrontEnd.activepane.read(new FileReader(file.getAbsoluteFile()), null);
                FrontEnd.EditorPane.add(file.getName(), scroll);
                countOpened++;
                FrontEnd.EditorPane.setTabComponentAt(countOpened - 1, new ButtonTabComponent(FrontEnd.EditorPane));
                FrontEnd.EditorPane.setSelectedIndex(countOpened - 1);
                FrontEnd.EditorPane.setToolTipTextAt(countOpened - 1, file.getAbsolutePath());

                FrontEnd.filepath = file.getAbsolutePath();
                //System.out.println("I am set wid " + FrontEnd.filepath);


                backend.FirstPass.branchtable = null;
                backend.FirstPass.branchtable = new Hashtable();
                new Memory();
                clean_branchtable();
                clean_memtable();
            } catch (Exception ex) {
                FrontEnd.statuswindow.append("problem accessing file" + file.getAbsolutePath() + "\n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());

                ex.printStackTrace();
            }
        }
    }

    private int check_if_open(String path) {
        for (int i = 0; i < countOpened; i++) {
            //System.out.println(path + " checked with " + FrontEnd.EditorPane.getToolTipTextAt(i) + countOpened + "\n");
            if (FrontEnd.EditorPane.getToolTipTextAt(i) != null) {
                if (FrontEnd.EditorPane.getToolTipTextAt(i).equals(path)) {
                    return i;
                }
            }
        }
        return -1;


    }

    public static void update_branchtable(Integer n) {
        Object[][] obj = backend.FirstPass.obj;
        //System.out.print("in updatebranchtable" + n + " :" + obj);
        clean_branchtable();
        for (int i = 0; i < n; i++) {
            JumpTable.model2.addRow(obj[i]);
            //System.out.print(obj);
        }
    }

    public static void update(final int ch) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	if(cmd_var==0){
            	registerPane.n_t.setText(Integer.toString(backend.Condition.cpsr.N));
                registerPane.z_t.setText(Integer.toString(backend.Condition.cpsr.Z));
                registerPane.c_t.setText(Integer.toString(backend.Condition.cpsr.C));
                registerPane.v_t.setText(Integer.toString(backend.Condition.cpsr.V));
                if (ch == 0) {
                    registerPane.r0_t.setText(String.valueOf(backend.Register.r[0].b));
                    registerPane.r1_t.setText(String.valueOf(backend.Register.r[1].b));
                    registerPane.r2_t.setText(String.valueOf(backend.Register.r[2].b));
                    registerPane.r3_t.setText(String.valueOf(backend.Register.r[3].b));
                    registerPane.r4_t.setText(String.valueOf(backend.Register.r[4].b));
                    registerPane.r5_t.setText(String.valueOf(backend.Register.r[5].b));
                    registerPane.r6_t.setText(String.valueOf(backend.Register.r[6].b));
                    registerPane.r7_t.setText(String.valueOf(backend.Register.r[7].b));
                    registerPane.r8_t.setText(String.valueOf(backend.Register.r[8].b));
                    registerPane.r9_t.setText(String.valueOf(backend.Register.r[9].b));
                    registerPane.r10_t.setText(String.valueOf(backend.Register.r[10].b));
                    registerPane.r11_t.setText(String.valueOf(backend.Register.r[11].b));
                    registerPane.r12_t.setText(String.valueOf(backend.Register.r[12].b));
                    registerPane.r13_t.setText(String.valueOf(backend.Register.r[13].b));
                    registerPane.r14_t.setText(String.valueOf(backend.Register.r[14].b));
                    registerPane.r15_t.setText(String.valueOf(backend.Register.r[15].b));

                } else if (ch == 1) {
                    registerPane.r0_t.setText(Integer.toBinaryString(backend.Register.r[0].b));
                    registerPane.r1_t.setText(Integer.toBinaryString(backend.Register.r[1].b));
                    registerPane.r2_t.setText(Integer.toBinaryString(backend.Register.r[2].b));
                    registerPane.r3_t.setText(Integer.toBinaryString(backend.Register.r[3].b));
                    registerPane.r4_t.setText(Integer.toBinaryString(backend.Register.r[4].b));
                    registerPane.r5_t.setText(Integer.toBinaryString(backend.Register.r[5].b));
                    registerPane.r6_t.setText(Integer.toBinaryString(backend.Register.r[6].b));
                    registerPane.r7_t.setText(Integer.toBinaryString(backend.Register.r[7].b));
                    registerPane.r8_t.setText(Integer.toBinaryString(backend.Register.r[8].b));
                    registerPane.r9_t.setText(Integer.toBinaryString(backend.Register.r[9].b));
                    registerPane.r10_t.setText(Integer.toBinaryString(backend.Register.r[10].b));
                    registerPane.r11_t.setText(Integer.toBinaryString(backend.Register.r[11].b));
                    registerPane.r12_t.setText(Integer.toBinaryString(backend.Register.r[12].b));
                    registerPane.r13_t.setText(Integer.toBinaryString(backend.Register.r[13].b));
                    registerPane.r14_t.setText(Integer.toBinaryString(backend.Register.r[14].b));
                    registerPane.r15_t.setText(Integer.toBinaryString(backend.Register.r[15].b));

                } else if (ch == 2) {
                    registerPane.r0_t.setText(Integer.toHexString(backend.Register.r[0].b));
                    registerPane.r1_t.setText(Integer.toHexString(backend.Register.r[1].b));
                    registerPane.r2_t.setText(Integer.toHexString(backend.Register.r[2].b));
                    registerPane.r3_t.setText(Integer.toHexString(backend.Register.r[3].b));
                    registerPane.r4_t.setText(Integer.toHexString(backend.Register.r[4].b));
                    registerPane.r5_t.setText(Integer.toHexString(backend.Register.r[5].b));
                    registerPane.r6_t.setText(Integer.toHexString(backend.Register.r[6].b));
                    registerPane.r7_t.setText(Integer.toHexString(backend.Register.r[7].b));
                    registerPane.r8_t.setText(Integer.toHexString(backend.Register.r[8].b));
                    registerPane.r9_t.setText(Integer.toHexString(backend.Register.r[9].b));
                    registerPane.r10_t.setText(Integer.toHexString(backend.Register.r[10].b));
                    registerPane.r11_t.setText(Integer.toHexString(backend.Register.r[11].b));
                    registerPane.r12_t.setText(Integer.toHexString(backend.Register.r[12].b));
                    registerPane.r13_t.setText(Integer.toHexString(backend.Register.r[13].b));
                    registerPane.r14_t.setText(Integer.toHexString(backend.Register.r[14].b));
                    registerPane.r15_t.setText(Integer.toHexString(backend.Register.r[15].b));


                } else if (ch == 3) {
                    registerPane.r0_t.setText(Integer.toOctalString(backend.Register.r[0].b));
                    registerPane.r1_t.setText(Integer.toOctalString(backend.Register.r[1].b));
                    registerPane.r2_t.setText(Integer.toOctalString(backend.Register.r[2].b));
                    registerPane.r3_t.setText(Integer.toOctalString(backend.Register.r[3].b));
                    registerPane.r4_t.setText(Integer.toOctalString(backend.Register.r[4].b));
                    registerPane.r5_t.setText(Integer.toOctalString(backend.Register.r[5].b));
                    registerPane.r6_t.setText(Integer.toOctalString(backend.Register.r[6].b));
                    registerPane.r7_t.setText(Integer.toOctalString(backend.Register.r[7].b));
                    registerPane.r8_t.setText(Integer.toOctalString(backend.Register.r[8].b));
                    registerPane.r9_t.setText(Integer.toOctalString(backend.Register.r[9].b));
                    registerPane.r10_t.setText(Integer.toOctalString(backend.Register.r[10].b));
                    registerPane.r11_t.setText(Integer.toOctalString(backend.Register.r[11].b));
                    registerPane.r12_t.setText(Integer.toOctalString(backend.Register.r[12].b));
                    registerPane.r13_t.setText(Integer.toOctalString(backend.Register.r[13].b));
                    registerPane.r14_t.setText(Integer.toOctalString(backend.Register.r[14].b));
                    registerPane.r15_t.setText(Integer.toOctalString(backend.Register.r[15].b));

                }
            	}
            }
        });


    }

    void EditorStateChanged(ChangeEvent evt) {

        JScrollPane sp = (JScrollPane) FrontEnd.EditorPane.getSelectedComponent();
        if (FrontEnd.EditorPane.getTabCount() != 0) {
            //System.out.print("no of components :" + FrontEnd.EditorPane.getComponentCount());
            JViewport vp = (JViewport) sp.getViewport();
            //JEditorPane ep = new JEditorPane();
            //if(! (vp.getComponent(0) instanceof frontend.setbkpt))
            {
                FrontEnd.activepane = (JEditorPane) vp.getComponent(0);
                if (FrontEnd.EditorPane.getToolTipText() != null) {
                    FrontEnd.filepath = FrontEnd.EditorPane.getToolTipTextAt(FrontEnd.EditorPane.getSelectedIndex());
                } else {
                    FrontEnd.filepath = new String();
                }
                //System.out.println("Editor state changed to " + FrontEnd.filepath);
            }
        } else {
        }


    }
    checkpoint b;
    static StepRun obj;
    static step_out obj2;
    static step_over obj3;
    static SetBreakpoint obj4;
    static int f = 0;

    public void steprun2() throws IOException {
        //FrontEnd.exceptionraised=0;
        handlers.clean_branchtable();
        //  handlers.clean_memtable();
        FrontEnd.activepane.getHighlighter().removeAllHighlights();
        Integer ct = new Integer(0);
        //System.out.println("blah " + ini_line + "blah" + fin_line + "blah" + f);
        ct = backend.FirstPass.scan(backend.ScanFile.path);
        
        if (f == 0 && ini_line != fin_line) {
            for (int i = 1; i < ini_line; i++) {
                ScanFile.br.readLine();
            }
        }

        if (debugMode == 0) {
            //System.out.println("1234 " + ini_line + "asdf" + fin_line);
            
            //System.out.println();
            //System.out.println(ini_line+" "+fin_line+" executed");
            //System.out.println();
            
            obj = new StepRun(backend.ScanFile.path, ini_line, fin_line, f);
            //System.out.println("steprun2()debugmode=0");
            f = 1;
//            if(temflag==0){
//            	f=0;
//            }
            
            
            
            obj.t.start();
        } else if (debugMode == 1) {
            obj2 = new step_out(backend.ScanFile.path,ini_line, fin_line, f);
            obj2.t.start();
            //System.out.println("steprun2()debugmode=1");
            f=1;
        } else if (debugMode == 2) {
            obj3 = new step_over(backend.ScanFile.path);
            obj3.t.start();
            //System.out.println("steprun2()debugmode=2");
        }
        
        handlers.update_branchtable(ct);
        (new handlers()).update(0);
        int memref_ct = Memory.display();
        if (memref_ct > 0) {
            handlers.update_memorytable(memref_ct);

        }
        if (FrontEnd.exceptionraised != 0) {
            FrontEnd.statuswindow.append("ERROR IN EXECUTION "+FrontEnd.exceptionraised+"\n");
            FrontEnd.exceptionraised = 0;
        }
        
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());// TODO add your handling code here:

    }

    void steprunActionPerformed(ActionEvent evt) throws IOException {
        steprun2();
    }

    class MyCustomFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".s" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".s");
        }

        @Override
        public String getDescription() {
            return "(*.s)";
        }
    }
}