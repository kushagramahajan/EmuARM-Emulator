/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;

import backend.instructions.InsInterface3;
import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author geetika
 */
public class ScanFile implements Runnable {
     public static ihandling ob;
     public static int test_counter=0;
     
//     Set<Thread> threadset = new HashSet<Thread>(),
//     
//     threadSet = Thread.getAllStackTraces().keySet();
     ThreadGroup currentGroup;
     Thread[] threadArray;
     public static int a_mode=0;
     
    public static int[] binaryconvert = null;
    public static int[] binaryconvert16 = null;
    public static boolean mainPresent;
    public static int endOfProgram = -1;
    public static long mainPosition;
    public static ArrayList<Integer> a_end;
    public static int temflag=0;

    public static int getLineNumber(JEditorPane component, int pos){
        int posLine;
        int y = 0;

        try {
        	
            Rectangle caretCoords = component.modelToView(pos);
            y = (int) caretCoords.getY();
        
        } catch (BadLocationException ex) {
        
        	ex.printStackTrace();
        
        }

        int lineHeight = component.getFontMetrics(component.getFont()).getHeight();
        posLine = (y / lineHeight) + 1;
        return posLine;

    }
    
    public static boolean barrelshiftpresent = false;
    public static int shiftType;
    public static int reg1orimm0;
    public static int regnoOrImmOp;
    public static int shiftregno;
    public static int ini_pos = 0;
    public static int val_bp;
    public static Long pos = new Long(0);
    public static RandomAccessFile br = null;
    public static Integer curent_line;
    static int ioflag = 0;
    // public static BufferedWriter outbin = null;
    static String[] shifts = {"ROR", "LSL", "LSR", "RRX", "ASR"};
    public static String[] asm_dir = {".abort",
        ".align",
        ".ascii",
        ".asciz",
        ".balign",
        ".byte",
        ".comm",
        ".data",
        ".def",
        ".dim",
        ".double",
        ".eject",
        ".else",
        ".end",
        ".elseif",
        ".endef",
        ".endfunc",
        ".endif",
        ".endm",
        ".endr",
        ".equ",
        ".equiv",
        ".err",
        ".even",
        ".exitm",
        ".extern",
        ".fail",
        ".file",
        ".fill",
        ".float",
        ".func",
        ".global",
        ".hword",
        ".ident",
        ".if",
        ".include",
        ".incbin",
        ".int",
        ".irp",
        ".irpc",
        ".lcomm",
        ".lflags",
        ".line",
        ".ln",
        ".list",
        ".long",
        ".macro",
        ".mri",
        ".nolist",
        ".octa",
        ".org",
        ".p2align",
        //".print",
        ".psize",
        ".purgem",
        ".quad",
        ".rept",
        ".sbttl",
        ".scl",
        ".section",
        ".set",
        ".short",
        ".single",
        ".size",
        ".sleb128",
        ".skip",
        ".space",
        ".stabd",
        ".stabn",
        ".stabs",
        ".string",
        ".struct",
        ".tag",
        ".text",
        ".title",
        ".type",
        ".uleb128",
        ".val",
        ".vtable_entry",
        ".word"};
    Thread t;
    public static File path;

    @SuppressWarnings("deprecation")
	public ScanFile(File p) {
    	temflag=0;
    	
    	try{//if(!Thread.currentThread().getName().equals("scan")){
//    		if(Thread.currentThread().getName().equals("scan"))
//    			Thread.currentThread().destroy();
    			//Thread.currentThread().stop();
    			
    	t = new Thread(this, "scan");
       
        path = p;
//        if(Thread.currentThread().getName().equals("scan"))
//			Thread.currentThread().interrupt();
		
      //  t.join();
        t.start();
        }
        catch(Exception e){
        	
        }
    }
    SetBreakpoint ob_bkpt;

    @SuppressWarnings("deprecation")
	public ScanFile(File filepath, SetBreakpoint ob_bkpt,ArrayList<Integer> end,int val_bp) {
//    	if(!Thread.currentThread().getName().equals("scan"))
//    	{    
    	try{
//    		if(Thread.currentThread().getName().equals("scan"))
//    			Thread.currentThread().destroy();
    		t = new Thread(this, "scan");
        temflag=1;
        this.a_end=end;
        this.val_bp=val_bp;
        path = filepath;
        this.ob_bkpt = ob_bkpt;
//        if(Thread.currentThread().getName().equals("scan"))
//			Thread.currentThread().interrupt();
		
       // t.join();
        t.start();
        }
        catch(Exception e){
        	
        }
    }

    @SuppressWarnings("deprecation")
	public void scanStart() {



        /* 
         try {
         //for binary file
         outbin = new BufferedWriter(new FileWriter(name));
         } catch (IOException ex) {
         ex.printStackTrace();
         }
         */

    	
        curent_line = new Integer(0);
        backend.Register.r[15].b = 0;
        try {
        	
            String strLine = null;    
            
            if (br == null) {
                File f = path;
                br = new RandomAccessFile(f, "r");
                strLine = new String();
                //System.out.println("main positnd" + mainPresent);
                if (mainPresent) {

                    backend.ScanFile.br.seek(mainPosition);
                    backend.ScanFile.pos = mainPosition;
                    ini_pos = pos.intValue();
                } else {
                    ini_pos = 0;
                    pos = new Long(0);
                }
            }
            
            if(temflag==1){
//            	File f=path;
//            	br = new RandomAccessFile(f, "r");
                pos=(long) 0;
                ini_pos=0;
            	while (a_end.size()!=0 && curent_line < a_end.get(val_bp)-1) {
            		if(frontend.FrontEnd.exceptionraised>0){
            			  backend.Register.r=new Register_spec[16];
            	          for(int i=0;i<16;i++)
            	          	backend.Register.r[i]=new Register_spec();
            	          Condition.cpsr.Z=0;
            	          Condition.cpsr.N=0;
            	          Condition.cpsr.C=0;
            	          Condition.cpsr.V=0;
            	          
            			return;
                	}
            		
                    strLine=br.readLine();
                    if(strLine.contains(".thumb")){
            			strLine=strLine.trim();
            			if(strLine.equalsIgnoreCase(".thumb")){
                		a_mode=1;
            			continue;}
            		}
                	if(strLine.contains(".arm")){
            			strLine=strLine.trim();
            			if(strLine.equalsIgnoreCase(".arm")){
                		a_mode=0;
            			continue;}
            		}
                    
                    //System.out.println();
                    //System.out.println(strLine);
                    
                    pos = (Long) br.getFilePointer();
//                     System.out.println("reached a breakpoint :"+frontend.FrontEnd.breakpointsEnabled);

                    //binaryconvert=new int[32];
                    (new handlers()).update(0);
                    barrelshiftpresent = false;
                    
                    backend.Register.r[15].b = pos.intValue();//update the program counter
                    curent_line = getLineNumber(frontend.FrontEnd.activepane, ini_pos);
                    //System.out.println(curent_line);
                    strLine = strLine.trim();
                    
                    if (strLine.isEmpty()) {
                        continue;
                    }
                    
                    int iasm;
                                   
                    for (iasm = 0; iasm < asm_dir.length; iasm++) {
                    
                    	
                    	if (strLine.contains(asm_dir[iasm])) {
                            break;
                    	}
                    	
                    }
                    
                    if (iasm != asm_dir.length) {
                        continue;
                    }
                    
                    if((strLine.startsWith(".read ") || strLine.startsWith(".READ ")))
                    {
                    	strLine=strLine.trim();
                    	if(!(strLine.startsWith(".read")||strLine.startsWith(".READ "))){
                    		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
                            frontend.FrontEnd.exceptionraised++;
                            return;
                    	}

                     ioflag=1;
                     if(FrontEnd.bflag==0){
	                     frontend.FrontEnd.statuswindow.append("Enter The Input: ");
	                     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                     }
	                 ob=new ihandling(strLine);	
                     
                     try {
                     ob.t.join();
                     // Thread.currentThread().sleep(10000);
                   //  System.err.print("maine w8 kri");
                    }
                    catch (InterruptedException ex) {
                    	 ex.printStackTrace();
                    }
                     //ob.scanhandle(strLine);
                     continue;
                     }
                    else if((strLine.contains(".print ") || strLine.contains(".PRINT "))){
                    	strLine=strLine.trim();
                    	if(!(strLine.startsWith(".print")||strLine.startsWith(".PRINT"))){
                    		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
                            frontend.FrontEnd.exceptionraised++;
                            return;
                    	}
                    	ohandling.printhandle(strLine);
                    	continue;
                    }
                     else
                    strLine = strLine.toUpperCase();
                    if (strLine.startsWith(";") || strLine.startsWith("@")) {
                        //statement contains only a comment
                        continue;
                    } else if (strLine.contains(":")) {
                        //instruction along with a
                        StringTokenizer st2 = new StringTokenizer(strLine, ":");
                        int ct_label = st2.countTokens();
                        if (ct_label == 1) {
                        	//System.out.println("Part 1");
                            continue;
                        } else {
                            if (ct_label == 2) {
                                strLine = st2.nextToken();
                                strLine = st2.nextToken();

                            } else {
                                for(int i = 0; i < ct_label; i++){
                                    strLine = st2.nextToken();
                                }
                            }
                        }
                        strLine = strLine.trim();

                    } else if (strLine.contains(";")) {
                        
                    	//instruction along with a comment
                        StringTokenizer st2 = new StringTokenizer(strLine, ";");
                        strLine = st2.nextToken();
                        strLine = strLine.trim();

                    }
                    else if (strLine.contains("@")) {
                        //instruction along with a comment
                        StringTokenizer st3 = new StringTokenizer(strLine, "@");
                        strLine = st3.nextToken();
                        strLine = strLine.trim();

                    }


                    if(a_mode==0){
                    	if (checkForBarrelShift(strLine) == false) {
                    		tokenizeInstruction(strLine);
                    	}
                    }
                    else{
                    	tokenizeInstruction(strLine);
                    }

                    // if(binaryconvert!=null)
                    //   outbin.append(cnvrt(binaryconvert));


                    /*                if(frontend.FrontEnd.breakpointsEnabled&&ob_bkpt.checkbreakpt(strLine))
                     {
                       
                     try {
                     //breakpoint reached
                     /*
                     * exit from the while loop and start again when play pressed
                     *
                     frontend.FrontEnd.activepane.getHighlighter().addHighlight(ini_pos,pos.intValue(), frontend.FrontEnd.cyanPainter);
                     frontend.FrontEnd.bkpt_note.setVisible(true);
                     frontend.FrontEnd.jButton12.setText("Run Again");
                     } catch (BadLocationException ex) {
                     ex.printStackTrace();
                     }

                     break;
                     }*/
                    ini_pos = pos.intValue();
                }
            	if(FrontEnd.bflag==1){
            	  backend.Register.r=new Register_spec[16];
                  for(int i=0;i<16;i++)
                  	backend.Register.r[i]=new Register_spec();
                  Condition.cpsr.Z=0;
                  Condition.cpsr.N=0;
                  Condition.cpsr.C=0;
                  Condition.cpsr.V=0;
                  FrontEnd.bflag=0;
                  
            	}
            	
            }
            else{
            	
            while ((strLine = br.readLine()) != null) {
//            	//synchronized(this){
            	currentGroup = 
            		      Thread.currentThread().getThreadGroup();
//            	for(int lj=0;lj<threadArray.length;lj++){
//            		System.out.println(threadArray[lj]);
//            	}
            	
            	int cou=0;int index=0;
            	int noThreads = currentGroup.activeCount();
                Thread[] lstThreads = new Thread[noThreads];
                currentGroup.enumerate(lstThreads);
                
//                for (int i = 0; i < noThreads; i++){
////                	System.out.println("Thread No:" + i + " = "
////                			+ lstThreads[i].getName());
//                	if(lstThreads[i].getName().equals("scan")){
//                		cou++;
//                		if(cou==1)
//                		index=i;
//                		
//                	}
//                	
//                }
//                if(cou>1){
//                
//                	
//                try{
//                	//System.out.println(index+"   nknknk");
//                	//lstThreads[index].destroy();
//                }
////                catch(NoSuchMethodError ec){
////                	
////                }
//                catch(Exception e){}
//                
//                
//                }
            	
                
                currentGroup = 
          		      Thread.currentThread().getThreadGroup();
                noThreads = currentGroup.activeCount();
                lstThreads = new Thread[noThreads];
                currentGroup.enumerate(lstThreads);
//                for (int i = 0; i < noThreads; i++){
//                	System.out.println("Thread No:" + i + " = "
//                			+ lstThreads[i].getName());
//                }
            	
            	//test_counter++;
//            	System.out.println(Thread.currentThread().getName());
            	//System.out.println(br);
            	//System.out.println(strLine+"  "+Thread.activeCount());
            	if(frontend.FrontEnd.exceptionraised>0){
            		  backend.Register.r=new Register_spec[16];
                      for(int i=0;i<16;i++)
                      	backend.Register.r[i]=new Register_spec();
                      Condition.cpsr.Z=0;
                      Condition.cpsr.N=0;
                      Condition.cpsr.C=0;
                      Condition.cpsr.V=0;
                    //  System.out.println("here1");
            		return;
            	}
            	if(strLine.contains(".thumb") || strLine.contains(".THUMB")){
        			strLine=strLine.trim();
        			if(strLine.equalsIgnoreCase(".thumb")){
            		a_mode=1;
        			continue;
        			}
        		}
            	
            	if(strLine.contains(".arm") || strLine.contains(".ARM")){
        			strLine=strLine.trim();
        			if(strLine.equalsIgnoreCase(".arm")){
            		a_mode=0;
        			continue;
        		}
        			
        		}
        		if(br!=null)
                pos = (Long) br.getFilePointer();
//                 System.out.println("reached a breakpoint :"+frontend.FrontEnd.breakpointsEnabled);

                //binaryconvert=new int[32];
                (new handlers()).update(0);
                barrelshiftpresent = false;

                if(FrontEnd.build_flag==0)
                backend.Register.r[15].b = pos.intValue();//update the prgram counter
                
                //System.out.println("here2");
                
                curent_line = getLineNumber(frontend.FrontEnd.activepane, ini_pos);
                //System.out.println(curent_line);
                
                strLine = strLine.trim();
                if (strLine.isEmpty()) {
                    continue;
                }
                int iasm;
                               
                for (iasm = 0; iasm < asm_dir.length; iasm++) {
                    if (strLine.contains(asm_dir[iasm])) {
                        break;
                    }
                }
               // System.out.println("here3");
                if (iasm != asm_dir.length) {
                    continue;
                }
                if(strLine.contains("read") || strLine.contains("READ "))
                 {
                	//System.out.println("ddd");
                	strLine=strLine.trim();
                	if(!(strLine.startsWith(".read")||strLine.startsWith(".READ "))){
                		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
                        frontend.FrontEnd.exceptionraised++;
                        return;
                	}
                 ioflag=1;
                 if(FrontEnd.bflag==0){
                	 frontend.FrontEnd.statuswindow.append("Enter The Input: ");
                	 frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                       
                 }
                 else
                	 continue;
                     ob=new ihandling(strLine);
	                 try {
	                 ob.t.join();
	                 // Thread.currentThread().sleep(10000);
	                // System.err.print("maine w8 kri");
	                 } catch (InterruptedException ex) {
	                 ex.printStackTrace();
	                 }
                 
                  
                 //ob.scanhandle(strLine);
                 continue;
                 }
                else if(strLine.contains(".print ") || strLine.contains(".PRINT ")){
                	strLine=strLine.trim();
                	if(!(strLine.startsWith(".print") || strLine.startsWith(".PRINT"))){
                		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
                        frontend.FrontEnd.exceptionraised++;
                        return;
                	}
                	ohandling.printhandle(strLine);
                	continue;
                }
                 else
                strLine = strLine.toUpperCase();
                //System.out.println("here4");
                if (strLine.startsWith(";") || strLine.startsWith("@")) {
                    //statement contains only a comment
                    continue;
                } else if (strLine.contains(":")) {
                    //instruction along with a
                	
                	
                    StringTokenizer st2 = new StringTokenizer(strLine, ":");
                    int ct_label = st2.countTokens();
                    if(ct_label == 1){
                    	//System.out.println("Part 2");
                    	//strLine="";
                    	//br.read();
//                    	System.out.println(strLine);
                    	//strLine="";
                    	
                    	continue;
                    }
                    else{
//                    	System.out.println("Other");
//                    	
//                    	System.out.println(strLine);
                    	
                        if (ct_label == 2) {
                            strLine = st2.nextToken();
                            strLine = st2.nextToken();

                        } else {
                            for (int i = 0; i < ct_label; i++) {
                                strLine = st2.nextToken();
                            }
                        }
                    }
                    strLine = strLine.trim();

                } else if (strLine.contains(";")) {
                    //instruction along with a comment
                    StringTokenizer st2 = new StringTokenizer(strLine, ";");
                    strLine = st2.nextToken();
                    strLine = strLine.trim();

                }
                else if (strLine.contains("@")) {
                    //instruction along with a comment
                    StringTokenizer st3 = new StringTokenizer(strLine, "@");
                    strLine = st3.nextToken();
                    strLine = strLine.trim();

                }

                if(a_mode==0){
                	if (checkForBarrelShift(strLine) == false) {
                		tokenizeInstruction(strLine);
                	}
                }
                else{
                	tokenizeInstruction(strLine);
                }


                ini_pos = pos.intValue();
            }
            //System.out.println(FrontEnd.bflag);
            if(FrontEnd.bflag==1){
            backend.Register.r=new Register_spec[16];
          for(int i=0;i<16;i++)
          	backend.Register.r[i]=new Register_spec();
          Condition.cpsr.Z=0;
          Condition.cpsr.N=0;
          Condition.cpsr.C=0;
          Condition.cpsr.V=0;
          FrontEnd.bflag=0;
          br=null;
          }
     	
            
            }
        //    } 
        } catch (IOException ex) {
            frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unable to access the source file:" + path.getName() + " \n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            frontend.FrontEnd.exceptionraised++;
            return;
        }
        catch(Exception le){}
        
    }

    static boolean checkForBarrelShift(String strLine) {
       //System.out.println(strLine);
    	int barrel_flag = 0;
        for (int i = 0; i < shifts.length; i++) {
            if (strLine.contains(shifts[i])) {
                barrelshiftpresent = true;
                barrel_flag = 1;
                int id = strLine.indexOf(shifts[i]) + 3;
                String imm = strLine.substring(id);
                imm = imm.trim();    // amount of shift
                String sub="";
                if(strLine.charAt(id-5)==','){
                	sub = strLine.substring(0, id - 5);
                	//System.out.println("hsv : "+sub);
                	}
                else{
                	sub = strLine.substring(0, id - 4);
                	//System.out.println("hsv_2 : "+sub);	
                }
                
                StringTokenizer st5 = new StringTokenizer(sub, ", ");
                String last_tkn = new String();
                int ct = st5.countTokens();
                for (int j = 0; j < ct; j++) {
                    last_tkn = st5.nextToken();

                }
                String corectn_pt = sub.substring(0, sub.length() - last_tkn.length());
                last_tkn = last_tkn.trim();  // this is to be shifted
                last_tkn = last_tkn.substring(1);
                int rm = Integer.parseInt(last_tkn);
                shiftregno = rm;
                //System.out.println(backend.Register.r[rm].value() + shifts[i] + imm);
                int data;
                data = backend.Register.r[rm].value();
                data = backend.BarrelShifter.shift(imm, data, InstructionSet.shift.valueOf(shifts[i]));
                corectn_pt = corectn_pt.concat("#").concat(String.valueOf(data));
                corectn_pt=corectn_pt.concat("]");
                //System.out.print("AFTER SHIFT APPEND " + corectn_pt + " :))");
                tokenizeInstruction(corectn_pt);


            }
        }
        if (barrel_flag == 0) {
            return false;
        }
        return true;
    }

    static void tokenizeInstruction(String strLine) {
    	//System.out.println(strLine);
    	//System.out.println("here5");
        StringTokenizer st = null;
        if (!strLine.contains("[") && !strLine.contains("{")) {

            st = new StringTokenizer(strLine, ", \t");
            String[] tokens = strLine.split(",");
            if(st.countTokens()<=tokens.length){
//            	System.out.println(strLine);
//            	System.out.println(st.countTokens()+"    "+ tokens.length);
            	if(handlers.cmd_var==1){
            		System.out.println("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
            	}
            	else{
            	frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            	}
                frontend.FrontEnd.exceptionraised++;
               // System.out.println("here6");
                return;
            }
         //   System.out.println("here7");
            backend.Emit.execute(st);
        } else if (strLine.contains("[")) {
        	if(!strLine.contains("]")){
        		if(handlers.cmd_var==1){
            		System.out.println("ERROR in line " + ScanFile.curent_line +": Unknown syntax \n");
            	}
        		else{
	        		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown syntax \n");
	                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
        		}
                frontend.FrontEnd.exceptionraised++;
                return;
        	}
            st = new StringTokenizer(strLine, "[");
            String token_12 = st.nextToken().trim();
            
            StringTokenizer st2 = new StringTokenizer(token_12, " ,\t");
            String addressing_mode = "[".concat(st.nextToken()).trim();
            String t=addressing_mode.substring(1,addressing_mode.length()-1);
            String[] tokens = t.split(",");
            StringTokenizer st3=new StringTokenizer(t, ", \t");
            
            if(st3.countTokens()<tokens.length){
            	if(handlers.cmd_var==1){
            		System.out.println("ERROR in line " + ScanFile.curent_line +": Unknown syntax \n");
            	}
            	else{
	            	frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown syntax \n");
	                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            	}
            	
                frontend.FrontEnd.exceptionraised++;
                return;
            }
            String ins = st2.nextToken();
            String rd;
            try{
            rd = st2.nextToken();
            }
            catch(Exception e){
            	if(handlers.cmd_var==1){
            		System.out.println("ERROR in line " + ScanFile.curent_line +": Unknown syntax \n");
            	}
            	else{
            		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown syntax \n");
            		frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            	}
                
                frontend.FrontEnd.exceptionraised++;
                return;
            }
            //System.out.println(ins+"              "+rd);
            if (backend.Emit.ht.get(ins) instanceof InsInterface3) {
                InsInterface3 obj1 = (InsInterface3) backend.Emit.ht.get(ins);
                //System.out.println("address-mode:"+addressing_mode);
                obj1.execute(ins, rd, addressing_mode);
            } else {
            	if(handlers.cmd_var==1){
            		System.out.println("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
            	}
            	else{
            		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
            		frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            	}
                frontend.FrontEnd.exceptionraised++;
                return;
            }


        } else if (strLine.contains("{")) {
            st = new StringTokenizer(strLine, "{");
            String token_12 = st.nextToken().trim();
            StringTokenizer st2 = new StringTokenizer(token_12, " ,\t");
            String list_reg = "{".concat(st.nextToken()).trim();
            String ins = st2.nextToken();
            String rd = st2.nextToken();
            
            if (backend.Emit.ht.get(ins) instanceof InsInterface3) {
                InsInterface3 obj1 = (InsInterface3) backend.Emit.ht.get(ins);
                obj1.execute(ins, rd, list_reg);
            } else {
            	if(handlers.cmd_var==1){
            		System.out.println("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
            	}
            	else{
	                frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
	                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            	}
                frontend.FrontEnd.exceptionraised++;
                return;
            }

        }

    }

    @Override
    public void run() {
    	if(handlers.cmd_var==1){
    		try {
				scanStart_cmd();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	else{
    		scanStart();
    	}
        
        //System.out.println("\nRETURNED HERE");
        br = null;
        mainPresent = false;
        if (frontend.FrontEnd.exceptionraised == 0) {
            if(handlers.cmd_var==0)
        	frontend.FrontEnd.statuswindow.append("\nBUILD SUCCESSFUL \n");
            
            else{
            	System.out.println("\nBUILD SUCCESSFUL \n");
            	if(handlers.tables.equalsIgnoreCase("tables")){     
            	   System.out.println("REGISTER TABLE:\n");

	            	 for(int i=0;i<16;i++){
                        if(i==13)
	     	        	 System.out.println("R"+i+"(sp) = "+backend.Register.r[i].b);
                        else if(i==14)
                         System.out.println("R"+i+"(lr) = "+backend.Register.r[i].b);
                        else if(i==15)
                         System.out.println("R"+i+"(pc) = "+backend.Register.r[i].b);
                        else
                         System.out.println("R"+i+" = "+backend.Register.r[i].b);
	     	         }
	            	 System.out.println("\n");
                     
	            	 System.out.println("FLAGS:\n");
	        		 System.out.println("N = "+backend.Condition.cpsr.N);
	        		 System.out.println("Z = "+backend.Condition.cpsr.Z);
	        		 System.out.println("C = "+backend.Condition.cpsr.C);
	        		 System.out.println("V = "+backend.Condition.cpsr.V);
	     	       
	        		 System.out.println("\n\n");

	        	
	        		 System.out.println("BRANCHTABLE:\n");
	        		 String str;	
	        		 Enumeration labels = backend.FirstPass.branchtable.keys();
                     if(labels.hasMoreElements()){
	        	     System.out.println("LABEL"+"				"+"LINE NO\n"); 
	        		 while(labels.hasMoreElements()) {
	        	         str = (String) labels.nextElement();
	        	         String spstring="";
	        	         for(int i=0;i<32-str.length();i++)
	        	        	 spstring+=" "; 
	        	         System.out.println(str + spstring +backend.FirstPass.branchtable.get(str));
	        	      }	 
	        	      }
	        	      
	        	     System.out.println("\n\n");
	         		 
	         		 System.out.println("MEMORYTABLE:\n");
	         		//public Object[][] disp_mem;
	         	     
	         		 int n=Memory.memory.size();
	                if(n>0)
	                {
	                //disp_mem=new Object[n][2];
	                Set keySet = Memory.memory.keySet();
	                Object[] keys=keySet.toArray();
	                AbstractCollection values = (AbstractCollection) Memory.memory.values();
	                Object[] val=values.toArray();
	                System.out.println("MEMORY LOCATION"+"			"+"MEMORY CONTENTS\n");
	                for(int i=0;i<n&&i<512;i++)
	                {	
	                	System.out.println(keys[i]+"				"+val[i]);
	                }
	                
	                }
            	}  
         		 
            }
            
        } else {
        	if(handlers.cmd_var==0)
            frontend.FrontEnd.statuswindow.append("\nBUILD FAILED \n");
           // frontend.FrontEnd.exceptionraised = 0;
        	else{
        		System.out.println("\nBUILD FAILED \n");
        		 
        	}
        	}
        if(handlers.cmd_var==0)
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
    	
   
    }
    void scanStart_cmd() throws IOException{
    	String strLine = null;    
        curent_line=1;
        if (br == null) {
            File f = new File(FrontEnd.filepath);
            //System.out.println(FrontEnd.filepath);
            try {
				br = new RandomAccessFile(f, "r");
			} catch (FileNotFoundException e) {
			//	e.printStackTrace();
				System.out.println("Invalid File...");
				return;
			}
            strLine = new String();
            //System.out.println("main positnd" + mainPresent);
//            if (mainPresent) {
//
//                backend.ScanFile.br.seek(mainPosition);
//                backend.ScanFile.pos = mainPosition;
//                ini_pos = pos.intValue();
//            } else {
//                ini_pos = 0;
//                pos = new Long(0);
//            }
        }
//        System.out.println(br);
    	while ((strLine = br.readLine()) != null) {
    		//System.out.println(strLine);
    		curent_line++;
    		currentGroup = 
        		      Thread.currentThread().getThreadGroup();
        	
        	int cou=0;int index=0;
        	int noThreads = currentGroup.activeCount();
            Thread[] lstThreads = new Thread[noThreads];
            currentGroup.enumerate(lstThreads);
            
//            currentGroup = 
//      		      Thread.currentThread().getThreadGroup();
//            noThreads = currentGroup.activeCount();
  //          lstThreads = new Thread[noThreads];
    //        currentGroup.enumerate(lstThreads);

            if(frontend.FrontEnd.exceptionraised>0){
        		  backend.Register.r=new Register_spec[16];
                  for(int i=0;i<16;i++)
                  	backend.Register.r[i]=new Register_spec();
                  Condition.cpsr.Z=0;
                  Condition.cpsr.N=0;
                  Condition.cpsr.C=0;
                  Condition.cpsr.V=0;
                //  System.out.println("here1");
        		return;
        	}
            
        	if(strLine.contains(".thumb") || strLine.contains(".THUMB")){
    			strLine=strLine.trim();
    			if(strLine.equalsIgnoreCase(".thumb")){
        		a_mode=1;
    			continue;
    			}
    		}
        	
        	if(strLine.contains(".arm") || strLine.contains(".ARM")){
    			strLine=strLine.trim();
    			if(strLine.equalsIgnoreCase(".arm")){
        		a_mode=0;
    			continue;
    		}
    			
    		}
    		if(br!=null)
            pos = (Long) br.getFilePointer();

    		(new handlers()).update(0);
            barrelshiftpresent = false;

            if(FrontEnd.build_flag==0)
            backend.Register.r[15].b = pos.intValue();//update the prgram counter
            
            //System.out.println("here2");
            
            //curent_line = getLineNumber(frontend.FrontEnd.activepane, ini_pos);
            //System.out.println(curent_line);
            
            strLine = strLine.trim();
            if (strLine.isEmpty()) {
                continue;
            }
            int iasm;
                           
            for (iasm = 0; iasm < asm_dir.length; iasm++) {
                if (strLine.contains(asm_dir[iasm])) {
                    break;
                }
            }
           // System.out.println("here3");
            if (iasm != asm_dir.length) {
                continue;
            }
            if(strLine.contains("read") || strLine.contains("READ"))
             {
            	strLine=strLine.trim();
            	if(!(strLine.startsWith(".read")||strLine.startsWith(".READ "))){
            			System.out.println("ERROR in line " + ScanFile.curent_line +": Unknown operation \n");
            		frontend.FrontEnd.exceptionraised++;
                    return;
            	}
             ioflag=1;
             if(FrontEnd.bflag==0){
            		 System.out.print("Enter The Input: ");
            	 
             }
             else
            	 continue;
             
        	 int val=ihandling.main();
        	 strLine = strLine.trim();
        	 strLine = strLine.substring(5, strLine.length());
             strLine = strLine.trim();
             
             int n=ihandling.replacewidnumbr(strLine);
             backend.Register.r[n].b = val;
        
             
             /*             ob=new ihandling(strLine);
             try {
             ob.t.join();
             // Thread.currentThread().sleep(10000);
            // System.err.print("maine w8 kri");
             } catch (InterruptedException ex) {
             ex.printStackTrace();
             }
*/             //ob.scanhandle(strLine);
             continue;
             }
            else if(strLine.contains(".print ") || strLine.contains(".PRINT ")){
            	strLine=strLine.trim();
            	if(!(strLine.startsWith(".print") || strLine.startsWith(".PRINT"))){
            		System.out.println("ERROR in line " + ScanFile.curent_line +": Unknown operation ");
            		frontend.FrontEnd.exceptionraised++;
                    return;
            	}
            	ohandling.printhandle(strLine);
            	continue;
            }
             else
            strLine = strLine.toUpperCase();
            //System.out.println("here4");
            if (strLine.startsWith(";") || strLine.startsWith("@")) {
                //statement contains only a comment
                continue;
            } else if (strLine.contains(":")) {
                //instruction along with a
            	
            	
                StringTokenizer st2 = new StringTokenizer(strLine, ":");
                int ct_label = st2.countTokens();
                if(ct_label == 1){
                	
                	continue;
                }
                else{
                	
                    if (ct_label == 2) {
                        strLine = st2.nextToken();
                        strLine = st2.nextToken();

                    } else {
                        for (int i = 0; i < ct_label; i++) {
                            strLine = st2.nextToken();
                        }
                    }
                }
                strLine = strLine.trim();

            } else if (strLine.contains(";")) {
                //instruction along with a comment
                StringTokenizer st2 = new StringTokenizer(strLine, ";");
                strLine = st2.nextToken();
                strLine = strLine.trim();

            }
            else if (strLine.contains("@")) {
                //instruction along with a comment
                StringTokenizer st3 = new StringTokenizer(strLine, "@");
                strLine = st3.nextToken();
                strLine = strLine.trim();

            }
            if(a_mode==0){
            	if (checkForBarrelShift(strLine) == false) {
            		tokenizeInstruction(strLine);
            	}
            }
            else{
            	tokenizeInstruction(strLine);
            }

            ini_pos = pos.intValue();
        }

    }
    
}
