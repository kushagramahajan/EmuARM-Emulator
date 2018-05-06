package backend;

import frontend.FrontEnd;
import frontend.handlers;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

/**
 *
 * @author namita
 */
public class step_out implements Runnable {

    public static boolean barrelshiftpresent = false;
    public static Long pos = new Long(0);
    public static RandomAccessFile br = null;
    public static Integer curent_line;
    public static int common;
    public Thread t, t1;
    public ScanFile ob;
    public File fpath;
    public static boolean call;
    public static int initial_pos;
    public static int end_pos;
    public static int next;
    private int ld;
    public static int i = 0;
    public static int j = 0;
    private int abc = 0;

    public step_out(File path, int ini, int fin, int f) {

        t = new Thread(this, "stepout");
        t1 = new Thread(this, "step");
        fpath = path;
        
        if (f == 0&&ini!=0) {
            
            StepRun.ini_line = ini;
            StepRun.fin_line = fin;
            if (ini == fin) {
                StepRun.ini_line = 1;
            } else {
                StepRun.ini_line = ini;
            }
            //System.out.println("BLAH " +  StepRun.ini_line+"BLAH"+StepRun.fin_line+"BLAH"+f);
        }


        f = 1;
    }
    static String[] shifts = {"ROR", "LSL", "LSR", "RRX", "ASR"};

    public void scanStart_1() throws InterruptedException {
        if (StepRun.ini_line != 0) {
        try {
            //System.out.println("step_out scanstart() UPAR WALA");

            //call = true;
             ScanFile.pos = ScanFile.br.getFilePointer();
            initial_pos = ScanFile.pos.intValue();
            //System.out.println("1234567initial pos= "+ initial_pos);
            //System.out.print("val returnd is :" + initial_pos + " and length is :" + ScanFile.path.length());
          
            if (StepRun.ini_line <= StepRun.fin_line-1) {
                ScanFile.br.seek(ScanFile.pos);
            } else {
                frontend.FrontEnd.steprun.setVisible(false);
                frontend.FrontEnd.warning.setVisible(true);
                frontend.FrontEnd.cross.setVisible(true);
                frontend.FrontEnd.run_stepOut.setEnabled(false);
                frontend.FrontEnd.run_stepOver.setEnabled(false);
                frontend.FrontEnd.r_stepOut.setEnabled(false);
                frontend.FrontEnd.r_stepover.setEnabled(false);

                FrontEnd.reset.setEnabled(false);

                return;
            }
            String strLine = new String();
            if (initial_pos == 0 && ScanFile.mainPresent) {
                backend.ScanFile.br.seek(ScanFile.mainPosition);
                backend.ScanFile.pos = ScanFile.mainPosition;
                initial_pos = ScanFile.pos.intValue();
            } else {
                initial_pos++;
            }
            ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

            if (StepRun.ini_line<FrontEnd.end  && StepRun.ini_line <= StepRun.fin_line-1) {
            	strLine = ScanFile.br.readLine();
            	StepRun.ini_line++;
                //frontend.StepRunWindow.jTextField1.setText(String.valueOf(backend.ScanFile.curent_line+1));
                //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                ScanFile.barrelshiftpresent = false;
                ScanFile.pos = ScanFile.br.getFilePointer();
                end_pos = ScanFile.pos.intValue();
                //  frontend.FrontEnd.activepane.getHighlighter().removeAllHighlights();
                if (call == false || common == 0) {
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(initial_pos, end_pos, frontend.handlers.cyanPainter);
                }
                backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

                strLine = strLine.trim();
                if (strLine.isEmpty()) {
                    return;
                }

                if (StepRun.transfer > 0 && i == 0 && strLine.contains("BL")) {
                    //System.out.println("QWERTYUIOP");
                    common--;
                    i = 1;
                }


                if (branchToProcedure(strLine)) {
                    if (StepRun.srun == 1) {
                        abc = 1;
                    }
                    common++;
                    call = true;
                    step_over.otransfer = 1;
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 1");
                } else if (common > 0 && stillInProcedure(strLine) == true) {
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 2");
                    call = true;
                } else if (common > 0 && stillInProcedure(strLine) == false) {
                    common--;
                    call = true;
                    if (StepRun.srun == 1) {
                        abc = 1;
                    }
                    if (StepRun.transfer != 0) {
                        StepRun.transfer--;

                    }
                    if (common == StepRun.transfer || common == 0) {
                        call = false;
                    }

                    //System.out.println("CASE 3");

//                    if (next != StepRun.transfer) {
//                        next++;
//                    } else {
//                        next = 0;
//                    }


                }
                if (step_over.ocommon > 0 && stillInProcedure(strLine) == false) {
                    step_over.ocommon--;
                    step_over.ocall = true;

                    if (step_over.ocommon == 0) {
                        step_over.ocall = false;

                    }
                }

                //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                int iasm;
                for (iasm = 0; iasm < backend.ScanFile.asm_dir.length; iasm++) {
                    if (strLine.contains(backend.ScanFile.asm_dir[iasm])) {
                        break;
                    }
                }

                if (iasm != backend.ScanFile.asm_dir.length) {
                    return;
                }

                strLine = strLine.toUpperCase();
                strLine = strLine.toUpperCase();


                if (strLine.startsWith(";") || strLine.startsWith("@")) {
                    return;//statement contains only a comment

                } else if (strLine.contains(":")) {

                    //instruction along with a 
                    StringTokenizer st2 = new StringTokenizer(strLine, ":");
                    int ct_label = st2.countTokens();
                    if (ct_label == 1) {
                        //System.err.println("\nhi");
                        //System.err.print(ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos));
                        return;
                    } else {
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
                if (ScanFile.checkForBarrelShift(strLine) == false) {
                    ScanFile.tokenizeInstruction(strLine);
                }
            }
            //System.out.println("VALUES " + common + " " + StepRun.transfer + " " + call + " " + next);

            if (call || abc == 1) {
                if (abc == 1) {
                    abc = 0;
                    StepRun.srun = 0;
                }
                scanStart_1();
                //System.out.println("SCANSTART" + strLine);
            } //            else if (next != 0 && StepRun.transfer > 0) {
            //                scanStart(); System.out.println("SCANSTART"+strLine);
            //                if (next == StepRun.transfer) {
            //                    next = 0;
            //                }
            //            } 
            else if (call == false || common == 0) {
                frontend.FrontEnd.steprun.setVisible(true);
                //System.out.println("NEXT BUTTON" + strLine);
            }
            if (frontend.FrontEnd.exceptionraised == 0) {
                frontend.FrontEnd.statuswindow.append("BUILD SUCCESSFUL \n");
            } else {
                frontend.FrontEnd.statuswindow.append("BUILD FAILED \n");
            }
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());

        } catch (BadLocationException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            frontend.FrontEnd.statuswindow.append("\nERROR in line " + ScanFile.curent_line + ": Unable to access the source file:" + fpath.getName() + " \n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            frontend.FrontEnd.exceptionraised++;
            return;
        }
        }else{
         try {
            //System.out.println("step_out scanstart() NEECHE WALA");

            //call = true;
            initial_pos = ScanFile.pos.intValue();
            //System.out.print("val returnd is :" + initial_pos + " and length is :" + ScanFile.path.length());
            if (initial_pos < ScanFile.path.length()) {
                ScanFile.br.seek(ScanFile.pos);
            } else {
                frontend.FrontEnd.steprun.setVisible(false);
                frontend.FrontEnd.warning.setVisible(true);
                frontend.FrontEnd.cross.setVisible(true);
                frontend.FrontEnd.run_stepOut.setEnabled(false);
                frontend.FrontEnd.run_stepOver.setEnabled(false);
                frontend.FrontEnd.r_stepOut.setEnabled(false);
                frontend.FrontEnd.r_stepover.setEnabled(false);

                FrontEnd.reset.setEnabled(false);

                return;
            }
            String strLine = new String();
            if (initial_pos == 0 && ScanFile.mainPresent) {
                backend.ScanFile.br.seek(ScanFile.mainPosition);
                backend.ScanFile.pos = ScanFile.mainPosition;
                initial_pos = ScanFile.pos.intValue();
            } else {
                initial_pos++;
            }
            ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

            if (ScanFile.curent_line<FrontEnd.end) {
                //frontend.StepRunWindow.jTextField1.setText(String.valueOf(backend.ScanFile.curent_line+1));
            	strLine = ScanFile.br.readLine();
            	//System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                ScanFile.barrelshiftpresent = false;
                ScanFile.pos = ScanFile.br.getFilePointer();
                end_pos = ScanFile.pos.intValue();
                //  frontend.FrontEnd.activepane.getHighlighter().removeAllHighlights();
                if (call == false || common == 0) {
                	
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(initial_pos, end_pos, frontend.handlers.cyanPainter);
                
                }
                
                backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

                strLine = strLine.trim();
                if (strLine.isEmpty()) {
                    return;
                }

                if (StepRun.transfer > 0 && i == 0 && strLine.contains("BL")) {
                    //System.out.println("QWERTYUIOP");
                    common--;
                    i = 1;
                }


                if (branchToProcedure(strLine)) {
                    if (StepRun.srun == 1) {
                        abc = 1;
                    }
                    common++;
                    call = true;
                    step_over.otransfer = 1;
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 1");
                } else if (common > 0 && stillInProcedure(strLine) == true) {
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 2");
                    call = true;
                } else if (common > 0 && stillInProcedure(strLine) == false) {
                    common--;
                    call = true;
                    if (StepRun.srun == 1) {
                        abc = 1;
                    }
                    if (StepRun.transfer != 0) {
                        StepRun.transfer--;

                    }
                    if (common == StepRun.transfer || common == 0) {
                        call = false;
                    }

                    //System.out.println("CASE 3");

//                    if (next != StepRun.transfer) {
//                        next++;
//                    } else {
//                        next = 0;
//                    }


                }
                if (step_over.ocommon > 0 && stillInProcedure(strLine) == false) {
                    step_over.ocommon--;
                    step_over.ocall = true;

                    if (step_over.ocommon == 0) {
                        step_over.ocall = false;

                    }
                }

                //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                int iasm;
                for (iasm = 0; iasm < backend.ScanFile.asm_dir.length; iasm++) {
                    if (strLine.contains(backend.ScanFile.asm_dir[iasm])) {
                        break;
                    }
                }

                if (iasm != backend.ScanFile.asm_dir.length) {
                    return;
                }

                strLine = strLine.toUpperCase();
                strLine = strLine.toUpperCase();


                if (strLine.startsWith(";") || strLine.startsWith("@")) {
                    return;//statement contains only a comment

                } else if (strLine.contains(":")) {

                    //instruction along with a 
                    StringTokenizer st2 = new StringTokenizer(strLine, ":");
                    int ct_label = st2.countTokens();
                    if (ct_label == 1) {
                        //System.err.println("\nhi");
                        //System.err.print(ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos));
                        return;
                    } else {
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
                if (ScanFile.checkForBarrelShift(strLine) == false) {
                    ScanFile.tokenizeInstruction(strLine);
                }
            }
            //System.out.println("VALUES " + common + " " + StepRun.transfer + " " + call + " " + next);

            if (call || abc == 1) {
                if (abc == 1) {
                    abc = 0;
                    StepRun.srun = 0;
                }
                scanStart_1();
                //System.out.println("SCANSTART" + strLine);
            } //            else if (next != 0 && StepRun.transfer > 0) {
            //                scanStart(); System.out.println("SCANSTART"+strLine);
            //                if (next == StepRun.transfer) {
            //                    next = 0;
            //                }
            //            } 
            else if (call == false || common == 0) {
                frontend.FrontEnd.steprun.setVisible(true);
                //System.out.println("NEXT BUTTON" + strLine);
            }
            if (frontend.FrontEnd.exceptionraised == 0) {
                frontend.FrontEnd.statuswindow.append("BUILD SUCCESSFUL \n");
            } else {
                frontend.FrontEnd.statuswindow.append("BUILD FAILED \n");
            }
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());

        } catch (BadLocationException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            frontend.FrontEnd.statuswindow.append("\nERROR in line " + ScanFile.curent_line + ": Unable to access the source file:" + fpath.getName() + " \n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            frontend.FrontEnd.exceptionraised++;
            return;
        }
        
        }
    }

    public void scanStart() throws InterruptedException {
        if (StepRun.ini_line != 0) {
        try {
            //System.out.println("step_out scanstart() UPAR WALA");

            //call = true;
             ScanFile.pos = ScanFile.br.getFilePointer();
            initial_pos = ScanFile.pos.intValue();
            //System.out.println("1234567initial pos= "+ initial_pos);
            //System.out.print("val returnd is :" + initial_pos + " and length is :" + ScanFile.path.length());
          
            if (StepRun.ini_line <= StepRun.fin_line-1) {
                ScanFile.br.seek(ScanFile.pos);
            } else {
                frontend.FrontEnd.steprun.setVisible(false);
                frontend.FrontEnd.warning.setVisible(true);
                frontend.FrontEnd.cross.setVisible(true);
                frontend.FrontEnd.run_stepOut.setEnabled(false);
                frontend.FrontEnd.run_stepOver.setEnabled(false);
                frontend.FrontEnd.r_stepOut.setEnabled(false);
                frontend.FrontEnd.r_stepover.setEnabled(false);

                FrontEnd.reset.setEnabled(false);

                return;
            }
            String strLine = new String();
            if (initial_pos == 0 && ScanFile.mainPresent) {
                backend.ScanFile.br.seek(ScanFile.mainPosition);
                backend.ScanFile.pos = ScanFile.mainPosition;
                initial_pos = ScanFile.pos.intValue();
            } else {
                initial_pos++;
            }
            if ((strLine = ScanFile.br.readLine()) != null  && StepRun.ini_line <= StepRun.fin_line-1) {
                 StepRun.ini_line++;
                //frontend.StepRunWindow.jTextField1.setText(String.valueOf(backend.ScanFile.curent_line+1));
                //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                ScanFile.barrelshiftpresent = false;
                ScanFile.pos = ScanFile.br.getFilePointer();
                end_pos = ScanFile.pos.intValue();
                //  frontend.FrontEnd.activepane.getHighlighter().removeAllHighlights();
                if (call == false || common == 0) {
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(initial_pos, end_pos, frontend.handlers.cyanPainter);
                }
                backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

                strLine = strLine.trim();
                if (strLine.isEmpty()) {
                    return;
                }

                if (StepRun.transfer > 0 && i == 0 && strLine.contains("BL")) {
                    //System.out.println("QWERTYUIOP");
                    common--;
                    i = 1;
                }


                if (branchToProcedure(strLine)) {
                    if (StepRun.srun == 1) {
                        abc = 1;
                    }
                    common++;
                    call = true;
                    step_over.otransfer = 1;
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 1");
                } else if (common > 0 && stillInProcedure(strLine) == true) {
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 2");
                    call = true;
                } else if (common > 0 && stillInProcedure(strLine) == false) {
                    common--;
                    call = true;
                    if (StepRun.srun == 1) {
                        abc = 1;
                    }
                    if (StepRun.transfer != 0) {
                        StepRun.transfer--;

                    }
                    if (common == StepRun.transfer || common == 0) {
                        call = false;
                    }

                    //System.out.println("CASE 3");

//                    if (next != StepRun.transfer) {
//                        next++;
//                    } else {
//                        next = 0;
//                    }


                }
                if (step_over.ocommon > 0 && stillInProcedure(strLine) == false) {
                    step_over.ocommon--;
                    step_over.ocall = true;

                    if (step_over.ocommon == 0) {
                        step_over.ocall = false;

                    }
                }

                //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                int iasm;
                for (iasm = 0; iasm < backend.ScanFile.asm_dir.length; iasm++) {
                    if (strLine.contains(backend.ScanFile.asm_dir[iasm])) {
                        break;
                    }
                }

                if (iasm != backend.ScanFile.asm_dir.length) {
                    return;
                }

                strLine = strLine.toUpperCase();
                strLine = strLine.toUpperCase();


                if (strLine.startsWith(";") || strLine.startsWith("@")) {
                    return;//statement contains only a comment

                } else if (strLine.contains(":")) {

                    //instruction along with a 
                    StringTokenizer st2 = new StringTokenizer(strLine, ":");
                    int ct_label = st2.countTokens();
                    if (ct_label == 1) {
                        //System.err.println("\nhi");
                        //System.err.print(ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos));
                        return;
                    } else {
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
                if (ScanFile.checkForBarrelShift(strLine) == false) {
                    ScanFile.tokenizeInstruction(strLine);
                }
            }
            //System.out.println("VALUES " + common + " " + StepRun.transfer + " " + call + " " + next);

            if (call || abc == 1) {
                if (abc == 1) {
                    abc = 0;
                    StepRun.srun = 0;
                }
                scanStart();
                //System.out.println("SCANSTART" + strLine);
            } //            else if (next != 0 && StepRun.transfer > 0) {
            //                scanStart(); System.out.println("SCANSTART"+strLine);
            //                if (next == StepRun.transfer) {
            //                    next = 0;
            //                }
            //            } 
            else if (call == false || common == 0) {
                frontend.FrontEnd.steprun.setVisible(true);
                //System.out.println("NEXT BUTTON" + strLine);
            }
            if (frontend.FrontEnd.exceptionraised == 0) {
                frontend.FrontEnd.statuswindow.append("BUILD SUCCESSFUL \n");
            } else {
                frontend.FrontEnd.statuswindow.append("BUILD FAILED \n");
            }
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());

        } catch (BadLocationException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            frontend.FrontEnd.statuswindow.append("\nERROR in line " + ScanFile.curent_line + ": Unable to access the source file:" + fpath.getName() + " \n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            frontend.FrontEnd.exceptionraised++;
            return;
        }
        }else{
         try {
            //System.out.println("step_out scanstart() NEECHE WALA");

            //call = true;
            initial_pos = ScanFile.pos.intValue();
            //System.out.print("val returnd is :" + initial_pos + " and length is :" + ScanFile.path.length());
            if (initial_pos < ScanFile.path.length()) {
                ScanFile.br.seek(ScanFile.pos);
            } else {
                frontend.FrontEnd.steprun.setVisible(false);
                frontend.FrontEnd.warning.setVisible(true);
                frontend.FrontEnd.cross.setVisible(true);
                frontend.FrontEnd.run_stepOut.setEnabled(false);
                frontend.FrontEnd.run_stepOver.setEnabled(false);
                frontend.FrontEnd.r_stepOut.setEnabled(false);
                frontend.FrontEnd.r_stepover.setEnabled(false);

                FrontEnd.reset.setEnabled(false);

                return;
            }
            String strLine = new String();
            if (initial_pos == 0 && ScanFile.mainPresent) {
                backend.ScanFile.br.seek(ScanFile.mainPosition);
                backend.ScanFile.pos = ScanFile.mainPosition;
                initial_pos = ScanFile.pos.intValue();
            } else {
                initial_pos++;
            }
            if ((strLine = ScanFile.br.readLine()) != null) {
                //frontend.StepRunWindow.jTextField1.setText(String.valueOf(backend.ScanFile.curent_line+1));
                //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                ScanFile.barrelshiftpresent = false;
                ScanFile.pos = ScanFile.br.getFilePointer();
                end_pos = ScanFile.pos.intValue();
                //  frontend.FrontEnd.activepane.getHighlighter().removeAllHighlights();
                if (call == false || common == 0) {
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(initial_pos, end_pos, frontend.handlers.cyanPainter);
                }
                backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

                strLine = strLine.trim();
                if (strLine.isEmpty()) {
                    return;
                }

                if (StepRun.transfer > 0 && i == 0 && strLine.contains("BL")) {
                    //System.out.println("QWERTYUIOP");
                    common--;
                    i = 1;
                }


                if (branchToProcedure(strLine)) {
                    if (StepRun.srun == 1) {
                        abc = 1;
                    }
                    common++;
                    call = true;
                    step_over.otransfer = 1;
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 1");
                } else if (common > 0 && stillInProcedure(strLine) == true) {
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 2");
                    call = true;
                } else if (common > 0 && stillInProcedure(strLine) == false) {
                    common--;
                    call = true;
                    if (StepRun.srun == 1) {
                        abc = 1;
                    }
                    if (StepRun.transfer != 0) {
                        StepRun.transfer--;

                    }
                    if (common == StepRun.transfer || common == 0) {
                        call = false;
                    }

                    //System.out.println("CASE 3");

//                    if (next != StepRun.transfer) {
//                        next++;
//                    } else {
//                        next = 0;
//                    }


                }
                if (step_over.ocommon > 0 && stillInProcedure(strLine) == false) {
                    step_over.ocommon--;
                    step_over.ocall = true;

                    if (step_over.ocommon == 0) {
                        step_over.ocall = false;

                    }
                }

                //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                int iasm;
                for (iasm = 0; iasm < backend.ScanFile.asm_dir.length; iasm++) {
                    if (strLine.contains(backend.ScanFile.asm_dir[iasm])) {
                        break;
                    }
                }

                if (iasm != backend.ScanFile.asm_dir.length) {
                    return;
                }

                strLine = strLine.toUpperCase();
                strLine = strLine.toUpperCase();


                if (strLine.startsWith(";") || strLine.startsWith("@")) {
                    return;//statement contains only a comment

                } else if (strLine.contains(":")) {

                    //instruction along with a 
                    StringTokenizer st2 = new StringTokenizer(strLine, ":");
                    int ct_label = st2.countTokens();
                    if (ct_label == 1) {
                        //System.err.println("\nhi");
                        //System.err.print(ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos));
                        return;
                    } else {
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
                if (ScanFile.checkForBarrelShift(strLine) == false) {
                    ScanFile.tokenizeInstruction(strLine);
                }
            }
            //System.out.println("VALUES " + common + " " + StepRun.transfer + " " + call + " " + next);

            if (call || abc == 1) {
                if (abc == 1) {
                    abc = 0;
                    StepRun.srun = 0;
                }
                scanStart();
                //System.out.println("SCANSTART" + strLine);
            } //            else if (next != 0 && StepRun.transfer > 0) {
            //                scanStart(); System.out.println("SCANSTART"+strLine);
            //                if (next == StepRun.transfer) {
            //                    next = 0;
            //                }
            //            } 
            else if (call == false || common == 0) {
                frontend.FrontEnd.steprun.setVisible(true);
                //System.out.println("NEXT BUTTON" + strLine);
            }
            if (frontend.FrontEnd.exceptionraised == 0) {
                frontend.FrontEnd.statuswindow.append("BUILD SUCCESSFUL \n");
            } else {
                frontend.FrontEnd.statuswindow.append("BUILD FAILED \n");
            }
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());

        } catch (BadLocationException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            frontend.FrontEnd.statuswindow.append("\nERROR in line " + ScanFile.curent_line + ": Unable to access the source file:" + fpath.getName() + " \n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            frontend.FrontEnd.exceptionraised++;
            return;
        }
        
        }
    }

    @Override
    public void run() {
        try {
            //System.out.println("step_out run()");
        	scanStart();
        } catch (InterruptedException ex) {
            Logger.getLogger(step_out.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean branchToProcedure(String strLine) throws BadLocationException {

        if (new StringTokenizer(strLine, " ,\t").countTokens() == 2 && strLine.toUpperCase().contains("BL")) {
            //  frontend.FrontEnd.activepane.getHighlighter().addHighlight(initial_pos, end_pos, frontend.handlers.cyanPainter);
            return true;
        }
        return false;
    }

    public boolean stillInProcedure(String strLine) {
        if (strLine.toUpperCase().contains("LDMFD")) {
            return false;
        }
        return true;
    }
}