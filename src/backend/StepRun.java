package backend;

import frontend.FrontEnd;
import frontend.checkpoint;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.text.BadLocationException;

public class StepRun implements Runnable {

    public Thread t;
    public File fpath;
    public static int ini_line = 0;
    public static int fin_line = 0;
    public static int initial_pos;
    int end_pos;
    // static int f = 0;
    public static int transfer;
    public static int srun=0;

    public StepRun(File path, int ini, int fin, int f) {

        t = new Thread(this, "steprun");
        fpath = path;

        if (f == 0&&ini!=0) {
            
            ini_line = ini;
            fin_line = fin;
            if (ini == fin) {
                ini_line = 1;
            } else {
                ini_line = ini;
            }
            ////System.out.println("BLAH " +  ini_line+"BLAH"+fin_line+"BLAH"+f);
        }


        f = 1;
        //System.out.println(ini + "" + fin + "" + ini_line + " " + fin_line + " in steprun");

    }
    static String[] shifts = {"ROR", "LSL", "LSR", "RRX", "ASR"};

    
    public void scanStart_1(){
    	//System.out.println("step run scanstart()");
        
    	if (ini_line != 0) {
            //System.out.println("STEP RUN UPAR");
            try {

                ScanFile.pos = ScanFile.br.getFilePointer();
                initial_pos = ScanFile.pos.intValue();

                //System.out.print("val returnd is :" + initial_pos + " and length is :" + ScanFile.path.length());
                if (ini_line <= fin_line) {
                    ScanFile.br.seek(ScanFile.pos);
                } else {
                    frontend.FrontEnd.steprun.setEnabled(false);
                    frontend.FrontEnd.warning.setVisible(true);
                    frontend.FrontEnd.cross.setVisible(true);
                    frontend.FrontEnd.run_stepOut.setEnabled(false);
                    frontend.FrontEnd.run_stepOver.setEnabled(false);
                    frontend.FrontEnd.r_stepOut.setEnabled(false);
                    frontend.FrontEnd.r_stepover.setEnabled(false);
                    frontend.FrontEnd.check.removeTabAt(0);

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
                
                if (ini_line<FrontEnd.end&& ini_line <= fin_line-1) {
                	strLine = ScanFile.br.readLine();
                	ini_line++;
                    //System.out.println("asdfghj " + ini_line + fin_line);
                    //frontend.StepRunWindow.jTextField1.setText(String.valueOf(backend.ScanFile.curent_line+1));
                    //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                    ScanFile.barrelshiftpresent = false;
                    ScanFile.pos = ScanFile.br.getFilePointer();
                    end_pos = ScanFile.pos.intValue();
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(0, 60, frontend.handlers.cyanPainter);
                    backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                    ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);
                    //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                    strLine = strLine.trim();
                    if (strLine.isEmpty()) {
                        return;
                    }


                    int iasm;
                    for (iasm = 0; iasm < backend.ScanFile.asm_dir.length; iasm++) {
                        if (strLine.contains(backend.ScanFile.asm_dir[iasm])) {
                            break;
                        }
                    }

                    if (iasm != backend.ScanFile.asm_dir.length) {
                        return;
                    }

                    /*
                     * if(strLine.contains("scanf")) { //ioflag=1;
                     * ScanFile.ob=new ihandling(strLine); try {
                     * ScanFile.ob.t.join(); //
                     * Thread.currentThread().sleep(10000);
                     * System.err.print("maine w8 kri"); } catch
                     * (InterruptedException ex) { ex.printStackTrace(); }
                     * //ob.scanhandle(strLine); return; } else
                     */
                    strLine = strLine.toUpperCase();
                    strLine = strLine.toUpperCase();


                    if (strLine.startsWith(";") || strLine.startsWith("@")) {
                        return;//statement contains only a comment

                    } else if (strLine.contains(":")) {

                        //instruction along with a 
                        StringTokenizer st2 = new StringTokenizer(strLine, ":");
                        int ct_label = st2.countTokens();
                        if (ct_label == 1) {
                          //  System.err.println("\nhi");
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

                    //initial_pos=end_pos+1;

                } else {
                    frontend.FrontEnd.steprun.setEnabled(false);
                    frontend.FrontEnd.warning.setVisible(true);
                    frontend.FrontEnd.cross.setVisible(true);

                    if (frontend.FrontEnd.exceptionraised == 0) {
                        frontend.FrontEnd.statuswindow.append("BUILD SUCCESSFUL \n");
                    } else {
                        frontend.FrontEnd.statuswindow.append("BUILD FAILED \n");
                    }
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                }
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                frontend.FrontEnd.statuswindow.append("\nERROR in line " + ScanFile.curent_line + ": Unable to access the source file:" + fpath.getName() + " \n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                frontend.FrontEnd.exceptionraised++;
                return;
            }

        } else {
        	//System.out.println("STEP RUN NEECHE");
            try {

                initial_pos = ScanFile.pos.intValue();
                //System.out.print("val returnd is :" + initial_pos + " and length is :" + ScanFile.path.length());
                if (initial_pos < ScanFile.path.length()) {
                    ScanFile.br.seek(ScanFile.pos);
                } else {
                    frontend.FrontEnd.steprun.setEnabled(false);
                    frontend.FrontEnd.warning.setVisible(true);
                    frontend.FrontEnd.cross.setVisible(true);
                    frontend.FrontEnd.run_stepOut.setEnabled(false);
                    frontend.FrontEnd.run_stepOver.setEnabled(false);
                    frontend.FrontEnd.r_stepOut.setEnabled(false);
                    frontend.FrontEnd.r_stepover.setEnabled(false);
                    frontend.checkpoint.reset();
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
//                	 ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);
                	
                	strLine = ScanFile.br.readLine();
                	
                	//System.out.println("ffdbc");
                	//System.out.println(initial_pos);
                	//System.out.println("ffdbc");
                	
                	//System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                    ScanFile.barrelshiftpresent = false;
                    ScanFile.pos = ScanFile.br.getFilePointer();
                    int end_pos = ScanFile.pos.intValue();
                     
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(initial_pos, end_pos, frontend.handlers.cyanPainter);
                    backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                    ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

                    strLine = strLine.trim();
                    if (strLine.isEmpty()) {
                        return;
                    }
                    if (branchToProcedure(strLine)) {
                        //System.out.println("step run branch to procedure upar wali");
                        srun=1;
                        transfer++;
                        step_over.otransfer = 1;

                        step_out.common++;
                        step_out.call = true;
                        // //System.out.println("val of common(steprun) is " + step_out.common);
                    } else if (stillInProcedure(strLine) == true) {
                        step_over.otransfer = 0;
                        step_out.call = false;
                        step_over.ocall = false;
                        if (step_out.common > 0) {
                            step_out.call = true;
                        }
                        if (step_over.ocommon > 0) {
                            step_over.ocall = true;
                        }
                    } else if (stillInProcedure(strLine) == false) {
                        if (step_out.common > 0) {
                            step_out.common--;
                            step_out.call = true;

                            if (transfer != 0) {
                                transfer--;

                            }
                            if (step_out.common == StepRun.transfer || step_out.common == 0) {
                                step_out.call = false;
                            }

                            //System.out.println("CASE 3");

//                    if (step_out.next != StepRun.transfer) {
//                        step_out.next++;
//                    } else {
//                        step_out.next = 0;
//                    }

                        }
                        if (step_over.ocommon > 0) {
                            step_over.ocommon--;
                            step_over.ocall = true;

                            if (step_over.ocommon == 0) {
                                step_over.ocall = false;

                            }
                        }
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

                    /*
                     * if(strLine.contains("scanf")) { //ioflag=1;
                     * ScanFile.ob=new ihandling(strLine); try {
                     * ScanFile.ob.t.join(); //
                     * Thread.currentThread().sleep(10000);
                     * System.err.print("maine w8 kri"); } catch
                     * (InterruptedException ex) { ex.printStackTrace(); }
                     * //ob.scanhandle(strLine); return; } else
                     */
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

                    //initial_pos=end_pos+1;

                } else {
                    frontend.FrontEnd.steprun.setEnabled(false);
                    frontend.FrontEnd.warning.setVisible(true);
                    frontend.FrontEnd.cross.setVisible(true);
                    if (frontend.FrontEnd.exceptionraised == 0) {
                        frontend.FrontEnd.statuswindow.append("BUILD SUCCESSFUL \n");
                    } else {
                        frontend.FrontEnd.statuswindow.append("BUILD FAILED \n");
                    }
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                }
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
    public void scanStart() {
        //System.out.println("step run scanstart()");
        if (ini_line != 0) {
            //System.out.println("STEP RUN UPAR");
            try {

                ScanFile.pos = ScanFile.br.getFilePointer();
                initial_pos = ScanFile.pos.intValue();

                //System.out.print("val returnd is :" + initial_pos + " and length is :" + ScanFile.path.length());
                if (ini_line <= fin_line) {
                    ScanFile.br.seek(ScanFile.pos);
                } else {
                    frontend.FrontEnd.steprun.setEnabled(false);
                    frontend.FrontEnd.warning.setVisible(true);
                    frontend.FrontEnd.cross.setVisible(true);
                    frontend.FrontEnd.run_stepOut.setEnabled(false);
                    frontend.FrontEnd.run_stepOver.setEnabled(false);
                    frontend.FrontEnd.r_stepOut.setEnabled(false);
                    frontend.FrontEnd.r_stepover.setEnabled(false);
                    frontend.FrontEnd.check.removeTabAt(0);

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
                if ((strLine = ScanFile.br.readLine()) != null && ini_line <= fin_line-1) {
                    ini_line++;
                    //System.out.println("asdfghj " + ini_line + fin_line);
                    //frontend.StepRunWindow.jTextField1.setText(String.valueOf(backend.ScanFile.curent_line+1));
                    //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                    ScanFile.barrelshiftpresent = false;
                    ScanFile.pos = ScanFile.br.getFilePointer();
                    end_pos = ScanFile.pos.intValue();
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(0, 60, frontend.handlers.cyanPainter);
                    backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                    ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);
                    //System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                    strLine = strLine.trim();
                    if (strLine.isEmpty()) {
                        return;
                    }


                    int iasm;
                    for (iasm = 0; iasm < backend.ScanFile.asm_dir.length; iasm++) {
                        if (strLine.contains(backend.ScanFile.asm_dir[iasm])) {
                            break;
                        }
                    }

                    if (iasm != backend.ScanFile.asm_dir.length) {
                        return;
                    }

                    /*
                     * if(strLine.contains("scanf")) { //ioflag=1;
                     * ScanFile.ob=new ihandling(strLine); try {
                     * ScanFile.ob.t.join(); //
                     * Thread.currentThread().sleep(10000);
                     * System.err.print("maine w8 kri"); } catch
                     * (InterruptedException ex) { ex.printStackTrace(); }
                     * //ob.scanhandle(strLine); return; } else
                     */
                    strLine = strLine.toUpperCase();
                    strLine = strLine.toUpperCase();


                    if (strLine.startsWith(";") || strLine.startsWith("@")) {
                        return;//statement contains only a comment

                    } else if (strLine.contains(":")) {

                        //instruction along with a 
                        StringTokenizer st2 = new StringTokenizer(strLine, ":");
                        int ct_label = st2.countTokens();
                        if (ct_label == 1) {
                           // System.err.println("\nhi");
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

                    //initial_pos=end_pos+1;

                } else {
                    frontend.FrontEnd.steprun.setEnabled(false);
                    frontend.FrontEnd.warning.setVisible(true);
                    frontend.FrontEnd.cross.setVisible(true);

                    if (frontend.FrontEnd.exceptionraised == 0) {
                        frontend.FrontEnd.statuswindow.append("BUILD SUCCESSFUL \n");
                    } else {
                        frontend.FrontEnd.statuswindow.append("BUILD FAILED \n");
                    }
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                }
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                frontend.FrontEnd.statuswindow.append("\nERROR in line " + ScanFile.curent_line + ": Unable to access the source file:" + fpath.getName() + " \n");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                frontend.FrontEnd.exceptionraised++;
                return;
            }

        } else {
        	//System.out.println("STEP RUN NEECHE");
            try {

                initial_pos = ScanFile.pos.intValue();
                //System.out.print("val returnd is :" + initial_pos + " and length is :" + ScanFile.path.length());
                if (initial_pos < ScanFile.path.length()) {
                    ScanFile.br.seek(ScanFile.pos);
                } else {
                    frontend.FrontEnd.steprun.setEnabled(false);
                    frontend.FrontEnd.warning.setVisible(true);
                    frontend.FrontEnd.cross.setVisible(true);
                    frontend.FrontEnd.run_stepOut.setEnabled(false);
                    frontend.FrontEnd.run_stepOver.setEnabled(false);
                    frontend.FrontEnd.r_stepOut.setEnabled(false);
                    frontend.FrontEnd.r_stepover.setEnabled(false);
                    frontend.checkpoint.reset();
                    FrontEnd.reset.setEnabled(false);
                    return;
                }
                String strLine = new String();
                if (initial_pos == 0 && ScanFile.mainPresent) {
                    backend.ScanFile.br.seek(ScanFile.mainPosition);
                    backend.ScanFile.pos = ScanFile.mainPosition;
                    initial_pos = ScanFile.pos.intValue();
                }
                else {
                    initial_pos++;
                }
                
                if ((strLine = ScanFile.br.readLine()) != null) {
                    //frontend.StepRunWindow.jTextField1.setText(String.valueOf(backend.ScanFile.curent_line+1));
//                	 ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

                	//System.out.println("\n" + strLine + " at line" + String.valueOf(backend.ScanFile.curent_line));
                    ScanFile.barrelshiftpresent = false;
                    ScanFile.pos = ScanFile.br.getFilePointer();
                    int end_pos = ScanFile.pos.intValue();
                    frontend.FrontEnd.activepane.getHighlighter().addHighlight(initial_pos, end_pos, frontend.handlers.cyanPainter);
                    backend.Register.r[15].b = ScanFile.pos.intValue();//update the prgram counter
                    ScanFile.curent_line = ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);

                    strLine = strLine.trim();
                    if (strLine.isEmpty()) {
                        return;
                    }
                    if (branchToProcedure(strLine)) {
                        //System.out.println("step run branch to procedure upar wali");
                        srun=1;
                        transfer++;
                        step_over.otransfer = 1;

                        step_out.common++;
                        step_out.call = true;
                        // //System.out.println("val of common(steprun) is " + step_out.common);
                    } else if (stillInProcedure(strLine) == true) {
                        step_over.otransfer = 0;
                        step_out.call = false;
                        step_over.ocall = false;
                        if (step_out.common > 0) {
                            step_out.call = true;
                        }
                        if (step_over.ocommon > 0) {
                            step_over.ocall = true;
                        }
                    } else if (stillInProcedure(strLine) == false) {
                        if (step_out.common > 0) {
                            step_out.common--;
                            step_out.call = true;

                            if (transfer != 0) {
                                transfer--;

                            }
                            if (step_out.common == StepRun.transfer || step_out.common == 0) {
                                step_out.call = false;
                            }

                            //System.out.println("CASE 3");

//                    if (step_out.next != StepRun.transfer) {
//                        step_out.next++;
//                    } else {
//                        step_out.next = 0;
//                    }

                        }
                        if (step_over.ocommon > 0) {
                            step_over.ocommon--;
                            step_over.ocall = true;

                            if (step_over.ocommon == 0) {
                                step_over.ocall = false;

                            }
                        }
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

                    /*
                     * if(strLine.contains("scanf")) { //ioflag=1;
                     * ScanFile.ob=new ihandling(strLine); try {
                     * ScanFile.ob.t.join(); //
                     * Thread.currentThread().sleep(10000);
                     * System.err.print("maine w8 kri"); } catch
                     * (InterruptedException ex) { ex.printStackTrace(); }
                     * //ob.scanhandle(strLine); return; } else
                     */
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

                    //initial_pos=end_pos+1;

                } else {
                    frontend.FrontEnd.steprun.setEnabled(false);
                    frontend.FrontEnd.warning.setVisible(true);
                    frontend.FrontEnd.cross.setVisible(true);
                    if (frontend.FrontEnd.exceptionraised == 0) {
                        frontend.FrontEnd.statuswindow.append("BUILD SUCCESSFUL \n");
                    } else {
                        frontend.FrontEnd.statuswindow.append("BUILD FAILED \n");
                    }
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                }
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
        //System.out.println("step run run()");
        scanStart();

    }

    private boolean branchToProcedure(String strLine) throws BadLocationException {
        //System.out.println("step run branch to procedure upar wali");
        if (new StringTokenizer(strLine, " ,\t").countTokens() == 2 && strLine.toUpperCase().contains("BL")) {
            //System.out.println("step run branch to procedure neeche wali");
           
            return true;
        }
        return false;
    }

    private boolean stillInProcedure(String strLine) {
        if (strLine.toUpperCase().contains("LDMFD")) {
            return false;
        }
        return true;
    }
}