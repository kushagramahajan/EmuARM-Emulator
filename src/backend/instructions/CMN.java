/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;

import java.io.IOException;
import javax.swing.JOptionPane;

import backend.ScanFile;
import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author geetika
 */
public class CMN implements InsInterface3{

static int[] binaryconvert=null;
static int[] binaryconvert16=null;
    static int no2,no3,chck;
static int b=0;
static int operand_2;

    @Override
    public void execute(String ins, String token3, String token4) {
        if(ScanFile.a_mode==1){
        	execute(ins,token3,token4,0);
        	return;
        }
    	
    	binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=1;
        binaryconvert[23]=0;
        binaryconvert[22]=1;
        binaryconvert[21]=1;
        backend.InstructionSet.CMN token1=backend.InstructionSet.CMN.valueOf(ins);
               switch(token1)
               {
                   case CMN:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        execCMN(token3,token4);
                        if(FrontEnd.build_flag==0)
                        backend.Condition.updateFlags(b, no2, no3, chck,0);
                        break;
                   case CMNEQ:
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNMI:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNHI:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNGT:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNLE:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

                   case CMNAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execCMN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                                backend.Condition.updateFlags(b, no2, no3, chck,0);
                          else
                                backend.Condition.updateFlags(b, no2, (int)operand_2, chck,0);
                       }
                       break;

               }
         
    }
    
    public void execute(String ins, String token3, String token4,int x){
    	binaryconvert16=new int[16];
        binaryconvert16[15]=0;
        binaryconvert16[14]=1;
        binaryconvert16[13]=0;
        binaryconvert16[12]=0;
        binaryconvert16[11]=0;
        binaryconvert16[10]=0;
        binaryconvert16[9]=1;
        binaryconvert16[8]=0;
        binaryconvert16[7]=1;
        binaryconvert16[6]=1;
        
        backend.InstructionSetThumb.CMN token1=backend.InstructionSetThumb.CMN.valueOf(ins);
        switch(token1){
        case CMN:
            
            execCMN(token3,token4,x);
            if(FrontEnd.build_flag==0)
            backend.Condition.updateFlags(b, no2, no3, chck,0);
            break;

        }
        
    }

    public static void execCMN(String token3, String token4,int x){
    	no2=backend.Register.convertRegister(token3);
        if(no2>-1)
        {
        	if(FrontEnd.build_flag==0)
               backend.convertToBinary.encodeRegister(no2,binaryconvert16,2,1,0);
               
              no3=backend.Register.convertRegister(token4);
            if(no3>-1)
            {
                 chck=1;
                 if(FrontEnd.build_flag==0)
                      backend.convertToBinary.encodeRegister(no3,binaryconvert16,5,4,3);
          
                try {
                	if(FrontEnd.build_flag==0)
                    b = backend.Register.r[no2].b + backend.Register.r[no3].b;
                    //System.err.println("VALUE OF B"+b);
                } catch (Exception e) {
                	if(handlers.cmd_var==1){
                       	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"CMP operation failed");	
                       	}
                       	else{
                 
                    frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"CMP operation failed");         
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;      return;
                }

            }
              else
            {
            	  if(handlers.cmd_var==1){
                     	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");	
                     	}
                     	else{
               
                 frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
 frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); } frontend.FrontEnd.exceptionraised++;          return;}
        }
        else if(no2==-2)
        {
        	 if(handlers.cmd_var==1){
             	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of CMP should be a register and "+token3+" is not a valid register.");	
             	}
             	else{
       
             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of CMP should be a register and "+token3+" is not a valid register.");
 frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
        	 frontend.FrontEnd.exceptionraised++;       return;}    

    }
    
public static void execCMN(String token3, String token4)
    {

            String num;

                no2=backend.Register.convertRegister(token3);
               if(no2>-1)
               {
            	   if(FrontEnd.build_flag==0)
                    backend.convertToBinary.encodeRegister(no2,binaryconvert,19,18,17,16);
                    binaryconvert[15]=0;
                    binaryconvert[14]=0;
                    binaryconvert[13]=0;
                    binaryconvert[12]=0;
                   
                     no3=backend.Register.convertRegister(token4);
                    if(no3>-1)
                   {
                       chck=1;
                       
                       binaryconvert[25]=0;
                          binaryconvert[11]=0;
                           binaryconvert[10]=0;
                           binaryconvert[9]=0;
                           binaryconvert[8]=0;
                           binaryconvert[7]=0;
                           binaryconvert[6]=0;
                           binaryconvert[5]=0;
                           binaryconvert[4]=0;
                           
                           if(FrontEnd.build_flag==0)
                             backend.convertToBinary.encodeRegister(no3,binaryconvert,3,2,1,0);
                 
                       try {
                    	   if(FrontEnd.build_flag==0)
                           b = backend.Register.r[no2].b + backend.Register.r[no3].b;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                              	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"CMP operation failed");	
                              	}
                              	else{
                        
                         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"CMN operation failed");         
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;   return;
                       }
                   }
                   else if(token4.startsWith("#"))
                   {
                        chck=0;
                       try {
                    	   if(token4.startsWith("#0X")){
                    		   operand_2 = Integer.parseInt(token4.trim().substring(3),16); 
                    	   }
                    	   else
                           operand_2 = Integer.parseInt(token4.substring(1));
                       } catch (NumberFormatException numberFormatException) {
                    	   if(handlers.cmd_var==1){
                            	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");	
                            	}
                            	else{
                      
                             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");         
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  } frontend.FrontEnd.exceptionraised++;   return;  }
                       if(FrontEnd.build_flag==0)
                       backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
          
                       try {
                    	   if(FrontEnd.build_flag==0)
                           b = backend.Register.r[no2].b + operand_2;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                              	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"CMP operation failed");	
                              	}
                              	else{
                        
                        
             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"CMN operation failed");         
               frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;  return;
                       }
  
                   }
                   else
                   {
                	   if(handlers.cmd_var==1){
                        	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");	
                        	}
                        	else{
                  
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                 frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());} frontend.FrontEnd.exceptionraised++;  return;}
               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
                    	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of CMN should be a register and "+token3+" is not a valid register.");	
                    	}
                    	else{
              
                    frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of CMN should be a register and "+token3+" is not a valid register.");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;  return;}
            /*    try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/



           }
}
