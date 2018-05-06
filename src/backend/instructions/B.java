/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import backend.ScanFile;
import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author geetika
 */
public class B implements InsInterface2 {

	static int[] binaryconvert=null;
	static int[] binaryconvert16=null;
    public static String caller="";
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
        binaryconvert[24]=0;
        
        backend.InstructionSet.B token1=backend.InstructionSet.B.valueOf(ins);

        switch(token1)
        {
            case B:
                binaryconvert[31]=1;
                binaryconvert[30]=1;
                binaryconvert[29]=1;
                binaryconvert[28]=0;
                       
                execb(token2);
                break;
            case BEQ:
                binaryconvert[31]=0;
                binaryconvert[30]=0;
                binaryconvert[29]=0;
                binaryconvert[28]=0;
                       
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BNE:
                binaryconvert[31]=0;
                binaryconvert[30]=0;
                binaryconvert[29]=0;
                binaryconvert[28]=1;
                       
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BHS:
                binaryconvert[31]=0;
                binaryconvert[30]=0;
                binaryconvert[29]=1;
                binaryconvert[28]=0;
                       
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLO:
                binaryconvert[31]=0;
                binaryconvert[30]=0;
                binaryconvert[29]=1;
                binaryconvert[28]=1;
                       
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BMI:
                binaryconvert[31]=0;
                binaryconvert[30]=1;
                binaryconvert[29]=0;
                binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BPL:
                binaryconvert[31]=0;
                binaryconvert[30]=1;
                binaryconvert[29]=0;
                binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BVS:
                binaryconvert[31]=0;
                binaryconvert[30]=1;
                binaryconvert[29]=1;
                binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BVC:
                binaryconvert[31]=0;
                binaryconvert[30]=1;
                binaryconvert[29]=1;
                binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BHI:
                binaryconvert[31]=1;
                binaryconvert[30]=0;
                binaryconvert[29]=0;
                binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLS:
                binaryconvert[31]=1;
                binaryconvert[30]=0;
                binaryconvert[29]=0;
                binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BGE:
                binaryconvert[31]=1;
                binaryconvert[30]=0;
                binaryconvert[29]=1;
                binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLT:
                binaryconvert[31]=1;
                binaryconvert[30]=0;
                binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BGT:
                binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BLE:
                binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                {
                          execb(token2);
                }
                break;
            case BAL:
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
        binaryconvert16[13]=0;
        binaryconvert16[12]=1;
        
        backend.InstructionSetThumb.B token1=backend.InstructionSetThumb.B.valueOf(ins);
        caller="";
        switch(token1){
        case B:
            binaryconvert16[13]=1;
            binaryconvert16[12]=0;
            binaryconvert16[11]=0;
            caller="b";
            execb(token2);
            break;
        case BEQ:
        	binaryconvert16[11]=0;
            binaryconvert16[10]=0;
            binaryconvert16[9]=0;
            binaryconvert16[8]=0;
                   
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BNE:
        	binaryconvert16[11]=0;
            binaryconvert16[10]=0;
            binaryconvert16[9]=0;
            binaryconvert16[8]=1;
                   
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BCS:
        	binaryconvert16[11]=0;
            binaryconvert16[10]=0;
            binaryconvert16[9]=1;
            binaryconvert16[8]=0;
                   
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BCC:
        	binaryconvert16[11]=0;
            binaryconvert16[10]=0;
            binaryconvert16[9]=1;
            binaryconvert16[8]=1;
                   
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BMI:
        	binaryconvert16[11]=0;
            binaryconvert16[10]=1;
            binaryconvert16[9]=0;
            binaryconvert16[8]=0;
                    
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BPL:
        	binaryconvert16[11]=0;
            binaryconvert16[10]=1;
            binaryconvert16[9]=0;
            binaryconvert16[8]=1;
                    
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BVS:
        	binaryconvert16[11]=0;
            binaryconvert16[10]=1;
            binaryconvert16[9]=1;
            binaryconvert16[8]=0;
                    
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BVC:
        	binaryconvert16[11]=0;
            binaryconvert16[10]=1;
            binaryconvert16[9]=1;
            binaryconvert16[8]=1;
                    
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BHI:
        	binaryconvert16[11]=1;
            binaryconvert16[10]=0;
            binaryconvert16[9]=0;
            binaryconvert16[8]=0;
                     
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BLS:
        	binaryconvert16[11]=1;
            binaryconvert16[10]=0;
            binaryconvert16[9]=0;
            binaryconvert16[8]=1;
                    
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BGE:
        	binaryconvert16[11]=1;
            binaryconvert16[10]=0;
            binaryconvert16[9]=1;
            binaryconvert16[8]=0;
                     
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BLT:
        	binaryconvert16[11]=1;
        binaryconvert16[10]=0;
        binaryconvert16[9]=1;
        binaryconvert16[8]=1;
        
                    
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BGT:
        	binaryconvert16[11]=1;
            binaryconvert16[10]=1;
            binaryconvert16[9]=0;
            binaryconvert16[8]=0;
            
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        case BLE:
        	binaryconvert16[11]=1;
            binaryconvert16[10]=1;
            binaryconvert16[9]=0;
            binaryconvert16[8]=1;
            
                    
            if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
            {
                      execb(token2);
            }
            break;
        }
    
        
	}
	

    private void execb(String token2)   // B{cond} label
    {
        //System.out.print(":)) i came here in B :"+token2);
        long linkregister;
        try {
            token2.trim();
            
            Long lno = null;
            try {
            	lno = (Long) backend.FirstPass.branchtable.get(token2.toUpperCase());
//                System.out.println("whkqdgjqwhdvjq");
//                System.out.println(backend.FirstPass.branchtable.get(token2.toUpperCase()));
//                System.out.println("whkqdgjqwhdvjq");
            	cnvrt(lno);
                //System.out.print(lno);
            } catch (Exception e) {
           	 if(handlers.cmd_var==1){
                	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": Label "+token2+" not found in the program.");	
                	}
                	else{
             	
                 frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": Label "+token2+" not found in the program.");
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }        frontend.FrontEnd.exceptionraised++;return; }
            if(lno!=null && lno>=0)
            {
            	//System.out.println(backend.ScanFile.br);
                backend.ScanFile.br.seek(lno);
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
            else if(lno==-3)
            {			
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
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }
       	 frontend.FrontEnd.exceptionraised++; return;}
        /*  try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
   
        
    }

    private void cnvrt(Long lno) {
        String tmp=Long.toBinaryString(lno);
        
        if(ScanFile.a_mode==0){
        	for(int i=0;i<=23;i++)
        	{
        		if(i<tmp.length())
        			binaryconvert[i]=tmp.charAt(i)-'0';
        		else
        			binaryconvert[i]=0;
        	}	
        }
        else if(caller.equals("b")){
        	Long v=lno>>1;
        		String tr=Long.toBinaryString(v);
        		
        	for(int i=0;i<11;i++){
        		if(i<tr.length())
        			binaryconvert16[i]=tr.charAt(i)-'0';
        		else
        			binaryconvert16[i]=0;
        	}
        }
        else{
        	Long v=lno>>1;
        		String tr=Long.toBinaryString(v);
        		
        	for(int i=0;i<8;i++){
        		if(i<tr.length())
        			binaryconvert16[i]=tr.charAt(i)-'0';
        		else
        			binaryconvert16[i]=0;
        	}
        }
        
    }
    
    }

   