/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 * Executes the remaining lines of a function in which the current
 * execution point lies. The next statement displayed is the statement
 * following the procedure call. All of the code is executed between 
 * the current and the final execution points. Available in break mode only.


 * @author win-7
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.text.BadLocationException;
/**
 *
 * @author Dr Rakesh Malhotra
 */
public class StepOut implements Runnable{
 
  public Thread t;
  public String fpath;
    private boolean call;
  
  
  public StepOut(String path)
  {
     
   t=new Thread(this,"steprun");
      fpath=path;
        
  }
  
  static String[] shifts={"ROR","LSL","LSR","RRX","ASR"};
    public  void scanStart()
    {
        call=true;
       
        try {
           
            int initial_pos=ScanFile.pos.intValue();
            ScanFile.br.seek(ScanFile.pos);
            String strLine=new String();
          if (initial_pos==0&&ScanFile.mainPresent) {
                    backend.ScanFile.br.seek(ScanFile.mainPosition);
                    backend.ScanFile.pos = ScanFile.mainPosition;
                    initial_pos = ScanFile.pos.intValue();
                } 
            while ((strLine = ScanFile.br.readLine()) != null && call == true)
            {
                call=false;
                frontend.StepRunWindow.jTextField1.setText(String.valueOf(backend.ScanFile.curent_line+1));
                //System.out.println("\n"+strLine+" at line"+String.valueOf(backend.ScanFile.curent_line));  
                ScanFile.barrelshiftpresent=false;
                ScanFile.pos=ScanFile.br.getFilePointer();
                int end_pos=ScanFile.pos.intValue();
                frontend.StepRunWindow.programdisplay.getHighlighter().addHighlight(initial_pos,
					end_pos, frontend.StepRunWindow.cyanPainter);
                backend.Register.r[15].b=ScanFile.pos.intValue();//update the prgram counter
                ScanFile.curent_line=ScanFile.getLineNumber(frontend.FrontEnd.activepane, initial_pos);
                strLine=strLine.trim();
                 if(strLine.isEmpty())
                     continue;
                 
                 /**************************************/
                 
                 if(branchToProcedure(strLine)||stillInProcedure(strLine))
                 {
                     call=true;
                 }
                 
                 
                 
                 
                //System.out.println("\n"+strLine+" at line"+String.valueOf(backend.ScanFile.curent_line));
                int iasm;
                for(iasm=0;iasm<backend.ScanFile.asm_dir.length;iasm++)
                {
                    if(strLine.contains(backend.ScanFile.asm_dir[iasm]))
                            {
                                continue;
                            }
                }
                
                if(iasm!=backend.ScanFile.asm_dir.length)
                    return;
              
                /*if(strLine.contains("scanf"))
                {
                    //ioflag=1;
                    ScanFile.ob=new ihandling(strLine);
                    try {
                       ScanFile.ob.t.join();
                       // Thread.currentThread().sleep(10000);
                        System.err.print("maine w8 kri");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    //ob.scanhandle(strLine);
                    return;
                }
                else*/
                    strLine=strLine.toUpperCase();strLine=strLine.toUpperCase();
                    
                
                if(strLine.startsWith(";") || strLine.startsWith("@"))
                {
                    continue;//statement contains only a comment
                               
                }
                else if(strLine.contains(":"))
                {
                    
                    //instruction along with a 
                    StringTokenizer st2=new StringTokenizer(strLine,":");
                    int ct_label=st2.countTokens();
                    if(ct_label==1)
                    { 
                        System.err.println("\nhi");
                        System.err.print(ScanFile.getLineNumber(frontend.StepRunWindow.programdisplay, initial_pos));
                        continue;
                    }
                    else
                    {
                        if(ct_label==2)
                        {
                            strLine=st2.nextToken();
                            strLine=st2.nextToken();
                    
                        }
                        else
                        {
                            for(int i=0;i<ct_label;i++)
                                strLine=st2.nextToken();
                        }
                    }
                    strLine=strLine.trim();
                            
                }
                else
                    if(strLine.contains(";"))
                {
                    //instruction along with a comment
                    StringTokenizer st2=new StringTokenizer(strLine,";");
                    strLine=st2.nextToken();
                    strLine=strLine.trim();
                    
                }
                
                
                if(ScanFile.checkForBarrelShift(strLine)==false)
                    ScanFile.tokenizeInstruction(strLine);
              
            }
           
            
            if(call)
            {
                frontend.StepRunWindow.steprun.setEnabled(false);
                frontend.StepRunWindow.warning.setVisible(true);
                if (frontend.FrontEnd.exceptionraised == 0) {
                frontend.FrontEnd.statuswindow.append("BUILD SUCCESSFUL \n");
            } else {
                frontend.FrontEnd.statuswindow.append("BUILD FAILED \n");
            }frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            }

  
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        frontend.FrontEnd.statuswindow.append("\nERROR in line "+ScanFile.curent_line+": Unable to access the source file:"+fpath+" \n");
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());   frontend.FrontEnd.exceptionraised++;  return;    
        } 
    }

    @Override
    public void run() {
        scanStart();
    }

    private boolean branchToProcedure(String strLine) {
        
        if(new StringTokenizer(strLine," ,\t").countTokens()==2 &&strLine.toUpperCase().contains("BL"))
            return true;
        return false;
    }

    private boolean stillInProcedure(String strLine) {
        if(strLine.toUpperCase().contains("LDMFD"))
            return false;
        return true;
    }
}