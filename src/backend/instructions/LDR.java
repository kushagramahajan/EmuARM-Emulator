/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;

import backend.ScanFile;
import frontend.FrontEnd;
import frontend.handlers;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author geetika
 */
public class LDR implements InsInterface3 {
static int[] binaryconvert=null;
static int[] binaryconvert16=null;

    private RandomAccessFile br_tmp;

    @Override
    public void execute(String ins, String token3, String token4) {
        if(ScanFile.a_mode==1){
        	execute(ins,token3,token4,0);
        	return;
        }
    	binaryconvert=new int[32];
binaryconvert[27]=0;
binaryconvert[26]=1;
binaryconvert[22]=0;
binaryconvert[20]=1;
        backend.InstructionSet.LDR token1=backend.InstructionSet.LDR.valueOf(ins);
               switch(token1)
               {
                   case LDR:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        execLDR(token3,token4);
                        break;
                   case LDREQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);
                       }
                       break;
                   case LDRNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRHI:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;
                   case LDRAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execLDR(token3,token4);

                       }
                       break;

               }

    }

    public void execute(String ins, String token3, String token4,int x){
    	binaryconvert16=new int[16];
    	binaryconvert16[15]=0;
    	binaryconvert16[14]=1;
    	
    	backend.InstructionSetThumb.LDR token1=backend.InstructionSetThumb.LDR.valueOf(ins);
    	switch(token1){
    	case LDR:
    		execLDR(token3,token4,x);
            break;
    	}
        
    }
    
    private void execLDR(String Rd, String addressing_mode,int x){
        int reg_id = 0;
        reg_id=backend.Register.convertRegister(Rd);
       if(reg_id>-1)
       {
           		if((addressing_mode.contains("R15") || addressing_mode.contains("PC"))&& addressing_mode.contains("#")){
           			binaryconvert16[13]=0;
           			binaryconvert16[12]=0;
           			binaryconvert16[11]=1;
           			backend.convertToBinary.encodeRegister(reg_id,binaryconvert16,10,9,8);
           			//backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert16,0,7);
           	      
              }
           		else if(!addressing_mode.contains("#")){
           			binaryconvert16[13]=0;
           			binaryconvert16[12]=1;
           			binaryconvert16[11]=1;
           			binaryconvert16[10]=0;
           			backend.convertToBinary.encodeRegister(reg_id,binaryconvert16,2,1,0);
                    
           		}
           		else if((addressing_mode.contains("R13") || addressing_mode.contains("SP"))&& addressing_mode.contains("#")){
           			binaryconvert16[15]=1;
           			binaryconvert16[14]=0;
           			binaryconvert16[13]=0;
           			binaryconvert16[12]=1;
           			binaryconvert16[11]=1;
           			backend.convertToBinary.encodeRegister(reg_id,binaryconvert16,10,9,8);

           		}
           		else{
           			binaryconvert16[13]=1;
           			binaryconvert16[12]=0;
           			binaryconvert16[11]=1;
           			
           			backend.convertToBinary.encodeRegister(reg_id,binaryconvert16,2,1,0);
                    
           		}
              
       }
       else
       {
    	   if(handlers.cmd_var==1){
          		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+Rd+" is not a valid operand.");
          	}
          	else{
             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+Rd+" is not a valid operand.");
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }   frontend.FrontEnd.exceptionraised++;     return;
       }
       
       Integer val1=new Integer(0);
       
       int address=new backend.AddressingModes().evaluateAddress(addressing_mode,binaryconvert16,x);
       //System.out.print("address2 :"+address+":)");
       
       {
      
        {	try{
               val1=backend.Memory.get(address);
        }
        catch(Exception e){
        	
        }
        
        }
       }
       
       if(reg_id!=15)
    	   if(FrontEnd.build_flag==0)
    	   backend.Register.r[reg_id].b=val1;
    	   else
    		   backend.Register.r[reg_id].b=0;
    	      
       else
       {
           if(val1!=backend.ScanFile.endOfProgram&&val1!=null)
           {
               try {
                        backend.ScanFile.br.seek(val1);
                        backend.ScanFile.pos=val1.longValue();
                        if(FrontEnd.build_flag==0)
                        backend.Register.r[reg_id].b=val1;
                        else
                        	backend.Register.r[reg_id].b=0;
               } 
               catch (IOException ex) {
       
            	   if(handlers.cmd_var==1){
               		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"LDR operation failed");
               	}
               	else{
               	
                    frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": LDR operation failed.");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }        frontend.FrontEnd.exceptionraised++;    return;     
       
                    }
           }
       }
   
    }
    
    private void execLDR(String Rd, String addressing_mode) {
        int reg_id = 0;
         reg_id=backend.Register.convertRegister(Rd);
        if(reg_id>-1)
        {
        	   backend.convertToBinary.encodeRegister(reg_id,binaryconvert,15,14,13,12);
               
        }
        else
        {
        	  if(handlers.cmd_var==1){
             		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+Rd+" is not a valid operand.");
             	}
             	else{
             	
              frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+Rd+" is not a valid operand.");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }  frontend.FrontEnd.exceptionraised++;     return;
        }
        Integer val1=new Integer(0);
        if(addressing_mode.startsWith("="))
        {
            binaryconvert[24]=0;
            binaryconvert[23]=1;
            binaryconvert[22]=0;
            binaryconvert[21]=0;
            binaryconvert[19]=0;
            binaryconvert[18]=0;
            binaryconvert[17]=0;
            binaryconvert[16]=0;
            addressing_mode=addressing_mode.substring(1);
            try {
                val1 = Integer.parseInt(addressing_mode);
                String tmp=Integer.toBinaryString(val1);
                for(int i=tmp.length();i<12;i++)
                    tmp="0".concat(tmp);
                for(int i=11;i>=0;i--)
                    binaryconvert[i]=(char)tmp.charAt(11-i)-'0';
            } catch (NumberFormatException numberFormatException) {
            	if(handlers.cmd_var==1){
             		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": Invalid Immediate data.");
             	}
             	else{
             
                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": Invalid Immediate data.");
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++;     return; }
            
        }
        else if(addressing_mode.startsWith("."))
        {
            //load a label's address
            StringTokenizer st=new StringTokenizer(addressing_mode,"+");
            int ct_token=st.countTokens();
            if(ct_token==2)
            {
                String label=st.nextToken().trim();
                
                String cons=st.nextToken().trim();
                int con=Integer.parseInt(cons);
                con/=4;
            
            Long lno = null;
            try {
                lno = (Long) backend.FirstPass.branchtable.get(label.toUpperCase());
               
                File f =ScanFile.path;
                br_tmp=new RandomAccessFile(f,"r");
                br_tmp.seek(lno);
                br_tmp.readLine(); // read dt label
                String line=new String();
                while(con>=0)
                {
                    line=br_tmp.readLine();
                    con--;
                }
                StringTokenizer st_tmp=new StringTokenizer(line," \t");
                String tmp=st_tmp.nextToken();
                //System.out.println(tmp);
                label=st_tmp.nextToken().trim();
                if (label.startsWith(".")) {
                    lno = (Long) backend.FirstPass.branchtable.get(label.toUpperCase());
                } else {
                    lno=Long.parseLong(label);
                }
                val1=lno.intValue();
            } catch (Exception e) {
            	 if(handlers.cmd_var==1){
               		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": Label "+label+" not found in the program.");
               	}
               	else{
               
                 frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": Label "+label+" not found in the program.");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }   frontend.FrontEnd.exceptionraised++;e.printStackTrace();return; }
            }
            else if(ct_token==1)
            {
                 String label=st.nextToken().trim();
                 Long lno = null;
            try {
                lno = (Long) backend.FirstPass.branchtable.get(label.toUpperCase());
//                System.err.println("path :"+frontend.FrontEnd.filepath);
                File f =ScanFile.path;
                
                br_tmp=new RandomAccessFile(f,"r");
                br_tmp.seek(lno);
                br_tmp.readLine();
                String line=br_tmp.readLine(); // read dt label
                StringTokenizer st_tmp=new StringTokenizer(line," \t");
                String tmp=st_tmp.nextToken();
                
                label=st_tmp.nextToken().trim();
                //System.err.println(label);
                if (label.startsWith(".")) {
                    lno = (Long) backend.FirstPass.branchtable.get(label.toUpperCase());
                } else {
                    lno=Long.parseLong(label);
                }
                val1=lno.intValue();
                
            } catch (Exception e) {
            	   if(handlers.cmd_var==1){
                  		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": Label "+label+" not found in the program.");
                  	}
                  	else{
                  	
                 frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": Label "+label+" not found in the program.");
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());   }  frontend.FrontEnd.exceptionraised++;
            e.printStackTrace();return; }
            }
        }
        else
        {
            int address=new backend.AddressingModes().evaluateAddress(addressing_mode,binaryconvert);
            //System.out.print("address2 :"+address+":)");
            
            {
           
             {
                    val1=backend.Memory.get(address);
             }
            }
         } 
               if(reg_id!=15)
            	   if(FrontEnd.build_flag==0)
            	   backend.Register.r[reg_id].b=val1;
            	   else
            		   backend.Register.r[reg_id].b=0;
               else
               {
                   if(val1!=backend.ScanFile.endOfProgram&&val1!=null)
                   {
                       try {
                                backend.ScanFile.br.seek(val1);
                                backend.ScanFile.pos=val1.longValue();
                                if(FrontEnd.build_flag==0)
                                backend.Register.r[reg_id].b=val1;
                                else
                                	backend.Register.r[reg_id].b=0;
                            } 
                       catch (IOException ex) {
                    	   if(handlers.cmd_var==1){
                          		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"LDR operation failed");
                          	}
                          	else{
                          	
               
                            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": LDR operation failed.");
                   frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }       frontend.FrontEnd.exceptionraised++;    return;     
               
                            }
                   }
               }
               /*  try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
   

    }
     

}
