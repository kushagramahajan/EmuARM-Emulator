/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class step_over implements Runnable {

    public static boolean barrelshiftpresent = false;
    public static Long pos = new Long(0);
    public static RandomAccessFile br = null;
    public static Integer curent_line;
    public static int ocommon;
    public static int otransfer;
    public Thread t;
    public ScanFile ob;
    public File fpath;
    public static boolean ocall;
    public static int initial_pos;
    public static int end_pos;
    public static int k = 0;
    public static int onext;

    public step_over(File path) {

        t = new Thread(this, "stepover");

        fpath = path;
    }
    static String[] shifts = {"ROR", "LSL", "LSR", "RRX", "ASR"};

    public void scanstart_1() throws InterruptedException {
        try {
            ////System.out.println("step_over scanstart()");

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

            if (ScanFile.curent_line<=FrontEnd.end) {
                //frontend.StepRunWindow.jTextField1.setText(String.valueOf(backend.ScanFile.curent_line+1));
            	strLine = ScanFile.br.readLine();
            	//System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                ScanFile.barrelshiftpresent = false;
                ScanFile.pos = ScanFile.br.getFilePointer();
                end_pos = ScanFile.pos.intValue();
                //  frontend.FrontEnd.activepane.getHighlighter().removeAllHighlights();
                if (ocall == false || ocommon == 0) {
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(initial_pos, end_pos, frontend.handlers.cyanPainter);
                }
                backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

                strLine = strLine.trim();
                if (strLine.isEmpty()) {
                    return;
                }
                //System.out.println("value of transfer" + otransfer);

                if (otransfer == 1 && k == 0) {
                    //System.out.println("QWERTYUIOP");
                    ocommon = 1;
                }

                if (k == 0) {
                    k = 1;
                }


                if (branchToProcedure(strLine)) {
                    StepRun.transfer++;
                    ocommon++;
                    ocall = true;
                    step_out.common++;
                    step_out.call = true;
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 1");
                } else if (ocommon > 0 && stillInProcedure(strLine) == true) {
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 2");
                    ocall = true;
                } else if (ocommon > 0 && stillInProcedure(strLine) == false) {
                    ocommon--;
                    ocall = true;

                    if (ocommon == 0) {
                        ocall = false;
//                        if(otransfer==1)
//                        {ocall=true;}
                    }

                    //System.out.println("CASE 3");
                }
                if (step_out.common > 0 && stillInProcedure(strLine) == false) {
                    step_out.common--;
                    if (step_out.common == 0) {
                        step_out.call = false;
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
            //System.out.println("VALUES " + ocommon + " " + otransfer + " " + ocall + " ");

            if (ocall) {
                //System.out.println("SCANSTART" + strLine);
                scanstart_1();


            } else if (ocall == false || ocommon == 0) {
                //System.out.println("NEXT BUTTON" + strLine);
                frontend.FrontEnd.steprun.setVisible(true);

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


    
    
    public void scanstart() throws InterruptedException {
        try {
            //System.out.println("step_over scanstart()");

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
                if (ocall == false || ocommon == 0) {
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(initial_pos, end_pos, frontend.handlers.cyanPainter);
                }
                backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

                strLine = strLine.trim();
                if (strLine.isEmpty()) {
                    return;
                }
                //System.out.println("value of transfer" + otransfer);

                if (otransfer == 1 && k == 0) {
                    //System.out.println("QWERTYUIOP");
                    ocommon = 1;
                }

                if (k == 0) {
                    k = 1;
                }


                if (branchToProcedure(strLine)) {
                    StepRun.transfer++;
                    ocommon++;
                    ocall = true;
                    step_out.common++;
                    step_out.call = true;
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 1");
                } else if (ocommon > 0 && stillInProcedure(strLine) == true) {
                    frontend.FrontEnd.steprun.setVisible(false);
                    //System.out.println("CASE 2");
                    ocall = true;
                } else if (ocommon > 0 && stillInProcedure(strLine) == false) {
                    ocommon--;
                    ocall = true;

                    if (ocommon == 0) {
                        ocall = false;
//                        if(otransfer==1)
//                        {ocall=true;}
                    }

                    //System.out.println("CASE 3");
                }
                if (step_out.common > 0 && stillInProcedure(strLine) == false) {
                    step_out.common--;
                    if (step_out.common == 0) {
                        step_out.call = false;
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
            //System.out.println("VALUES " + ocommon + " " + otransfer + " " + ocall + " ");

            if (ocall) {
                //System.out.println("SCANSTART" + strLine);
                scanstart();


            } else if (ocall == false || ocommon == 0) {
                //System.out.println("NEXT BUTTON" + strLine);
                frontend.FrontEnd.steprun.setVisible(true);

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

    @Override
    public void run() {
        try {
        	scanstart();

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