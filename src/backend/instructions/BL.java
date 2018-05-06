/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;
import java.io.IOException;

import backend.ScanFile;
import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author geetika
 */
public class BL implements InsInterface2{
   static int[] binaryconvert=null; 
   static int[] binaryconvert16=null;
   
   public static Long linkregister=new Long(0);

    @Override
  public void execute(String ins, String token2) {
        if(ScanFile.a_mode==1){
        	execute(ins,token2,0);
        	return;
        }
    	binaryconvert=new int[32];
        binaryconvert[27]=1;
        binaryconvert[26]=0;
        binaryconvert[25]=1;
        binaryconvert[24]=1;
        //System.err.println("reached in bl");
        backend.InstructionSet.BL token1=backend.InstructionSet.BL.valueOf(ins);

        switch(token1)
        {
            case BL:
                
                binaryconvert[31]=1;
                binaryconvert[30]=1;
                binaryconvert[29]=1;
                binaryconvert[28]=0;
                       
                execb(token2);
                break;
            case BLEQ:
                binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLNE:
                binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLHS:
                binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLLO:
                binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLMI:
                binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLPL:
                binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLVS:
                binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLVC:
                binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLHI:
                binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLLS:
                binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLGE:
                binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLLT:
                binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLGT:
                binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLLE:
                binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLAL:
                binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
        }
        }
    
    public void execute(String ins, String token2,int x){
    	binaryconvert16=new int[16];
        binaryconvert16[15]=1;
        binaryconvert16[14]=1;
        binaryconvert16[13]=1;
        binaryconvert16[12]=1;
        //System.err.println("reached in bl");
        backend.InstructionSetThumb.BL token1=backend.InstructionSetThumb.BL.valueOf(ins);

        switch(token1)
        {
            case BL:
                
                execb(token2);
                break;
        }
    }

    private void execb(String token2)   // BL{cond} label
    {
        ////System.out.println("reached execb");
        //System.err.println("got a print statemnt");
            try {
            token2=token2.trim();
            Long lno = null;
            try {
                lno = (Long) backend.FirstPass.branchtable.get(token2);
                if(ScanFile.a_mode==0)
                	cnvrt(lno);
            } catch (Exception e) {
            	if(handlers.cmd_var==1){
            		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": Label "+token2+" not found in the program.");
            	}
            	else{
                
                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": Label "+token2+" not found in the program.");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
            	frontend.FrontEnd.exceptionraised++;e.printStackTrace(); return;}
            if(lno!=null && lno>=0)
            {
                
                linkregister=backend.ScanFile.br.getFilePointer();
                backend.ScanFile.br.seek(lno);
                if(FrontEnd.build_flag==0)
                	backend.Register.r[14].b=linkregister.intValue();
                else
             	   backend.Register.r[14].b=0;

                  backend.ScanFile.pos=lno;
            }
            else if(lno==-1)
            {
               
                //printf statement
                linkregister=backend.ScanFile.br.getFilePointer();
                backend.ScanFile.br.seek(backend.Register.r[0].b);
                String tmp=backend.ScanFile.br.readLine();
                
                String strline=backend.ScanFile.br.readLine();
                strline=strline.trim();
                //System.err.println("branchd to "+strline);
                if(strline.startsWith(".ascii"))
                {
                    strline=strline.substring(6);
                    
                    backend.ohandling.printhandle(strline);
                }
                 backend.ScanFile.br.seek(linkregister);
            }
            else if(lno==-2)
            {
                //scanf statement
            }
            else if(lno==-3)
            {
                //modsi3 statement
            	if(FrontEnd.build_flag==0)
            	backend.Register.r[0].b=backend.Register.r[0].b%backend.Register.r[1].b;
            	else
             	   backend.Register.r[0].b=0;

            }
        } catch (IOException ex) {
        	if(handlers.cmd_var==1){
               	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": Unable to branch to that location.");	
               	}
               	else{
         
        	
            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": Unable to branch to that location.");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++; return;  
    }                   

    }
    
    
      private void cnvrt(Long lno){
        String tmp=Long.toBinaryString(lno);
        for(int i=0;i<=23;i++)
        {
            if(i<tmp.length())
                binaryconvert[i]=tmp.charAt(i)-'0';
            else
                binaryconvert[i]=0;
        }
    }
}
