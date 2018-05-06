/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;

import frontend.FrontEnd;
import frontend.handlers;
import java.io.IOException;
import javax.swing.JOptionPane;

import backend.ScanFile;

/**
 *
 * @author geetika
 */
public class STR implements InsInterface3{

  static int[] binaryconvert=null;
  static int[] binaryconvert16=null;

    @Override
    public void execute(String ins, String token3, String token4) {
        if(ScanFile.a_mode==1){
        	execute(ins,token3,token4,0);
        	return;
        }
    	binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[22]=0;
        binaryconvert[20]=0;
        
         backend.InstructionSet.STR token1=backend.InstructionSet.STR.valueOf(ins);
               switch(token1)
               {
                   case STR:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        execSTR(token3,token4);

                        break;
                   case STREQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRHI:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

                   case STRAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTR(token3,token4);

                       }
                       break;

               }

    }
    
    public void execute(String ins, String token3, String token4,int x){
    	binaryconvert16=new int[16];
//        binaryconvert16[27]=0;
//        binaryconvert16[26]=0;
//        binaryconvert16[22]=0;
//        binaryconvert16[20]=0;
//        
         backend.InstructionSetThumb.STR token1=backend.InstructionSetThumb.STR.valueOf(ins);
               switch(token1)
               {
                   case STR:
                       
                        execSTR(token3,token4,x);

                        break;
               }
    }

    private void execSTR(String Rd, String addressing_mode,int x){
    	int address=new backend.AddressingModes().evaluateAddress(addressing_mode,binaryconvert16,x);
        //System.out.print("address :"+address+":)");
           int reg_id=backend.Register.convertRegister(Rd);
        if(reg_id>-1)
        {
            if(!addressing_mode.contains("#")){
            	binaryconvert16[15]=0;
            	binaryconvert16[14]=1;
            	binaryconvert16[13]=0;
            	binaryconvert16[12]=1;
            	binaryconvert16[11]=0;
            	binaryconvert16[10]=0;
            	binaryconvert16[9]=0;
            	
            	backend.convertToBinary.encodeRegister(reg_id,binaryconvert16,2,1,0);
            
            }
            else if((addressing_mode.contains("SP")||addressing_mode.contains("R13")) && addressing_mode.contains("#")){
             	binaryconvert16[15]=1;
            	binaryconvert16[14]=0;
            	binaryconvert16[13]=0;
            	binaryconvert16[12]=1;
            	binaryconvert16[11]=0;
            	
            	backend.convertToBinary.encodeRegister(reg_id,binaryconvert16,10,9,8);
                
            }
            else{
            	binaryconvert16[15]=0;
            	binaryconvert16[14]=1;
            	binaryconvert16[13]=1;
            	binaryconvert16[12]=0;
            	binaryconvert16[11]=0;
           
            	backend.convertToBinary.encodeRegister(reg_id,binaryconvert16,2,1,0);
                
            }
            
            
            Integer data=new Integer(0);
            data=backend.Register.r[reg_id].b;
           
            {
            	if(FrontEnd.build_flag==0)
            		backend.Memory.put(data, address);
            	else
            		backend.Memory.put(0, address);
            	//System.err.println("store executed ::"+backend.Memory.display());
            	//System.out.println(handlers.cmd_var);
            if(FrontEnd.build_flag==0)   
            	if(handlers.cmd_var==0)
            		handlers.update_memorytable(backend.Memory.display());
            }
        }
        
        else if(reg_id==-2)
        {
        	  if(handlers.cmd_var==1){
           	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+Rd+" is not a valid operand.\n");
              }
              else{
           
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+Rd+" is not a valid operand.\n");
               frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;  return;
                  
        }
        
    }
    
    private void execSTR(String Rd, String addressing_mode) {
        int address=new backend.AddressingModes().evaluateAddress(addressing_mode,binaryconvert);
        //System.out.print("address :"+address+":)");
           int reg_id=backend.Register.convertRegister(Rd);
        if(reg_id>-1)
        {
            backend.convertToBinary.encodeRegister(reg_id,binaryconvert,15,14,13,12);
            
            Integer data=new Integer(0);
            data=backend.Register.r[reg_id].b;
           
            {
            	if(FrontEnd.build_flag==0){
                backend.Memory.put(data, address);
                 //System.err.println("store executed ::"+backend.Memory.display());
                if(handlers.cmd_var==0)
                handlers.update_memorytable(backend.Memory.display());
            	}
            	else{
            		backend.Memory.put(0, address);
            		 if(handlers.cmd_var==0)  
            			 handlers.update_memorytable(backend.Memory.display());
                  	
            	}
            	}
        }
        else if(reg_id==-2)
        {
               if(handlers.cmd_var==1){
            	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+Rd+" is not a valid operand.\n");
               }
               else{
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+Rd+" is not a valid operand.\n");
               frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;  return;
                  
        }
        
      /*    try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
   
    }


}
