/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;

import java.io.IOException;
import javax.swing.JOptionPane;

import backend.ScanFile;
import frontend.handlers;

/**
 *
 * @author geetika
 */
public class TST implements InsInterface3 {
static int no2,no3;
static int b=0;
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
        binaryconvert[24]=1;
        binaryconvert[23]=0;
        binaryconvert[22]=0;
        binaryconvert[21]=0;
          backend.InstructionSet.TST token1=backend.InstructionSet.TST.valueOf(ins);
               switch(token1)
               {
                   case TST:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       execTST(token3,token4);
                        backend.Condition.updateFlags(b);
                        break;
                   case TSTEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTHS:
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTLT:
                      binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTLE:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
                       }
                       break;

                   case TSTAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTST(token3,token4);
                          backend.Condition.updateFlags(b);
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
        binaryconvert16[7]=0;
        binaryconvert16[6]=0;
        
        backend.InstructionSetThumb.TST token1=backend.InstructionSetThumb.TST.valueOf(ins);
        switch(token1)
        {
            case TST:
                 
                execTST(token3,token4,x);
                 backend.Condition.updateFlags(b);
                 break;
        }
    }
    
    public static void execTST(String token3, String token4,int x){
        
        no2=backend.Register.convertRegister(token3);
                      if(no2>-1)
                      {
                         
                         backend.convertToBinary.encodeRegister(no2,binaryconvert16,2,1,0);
                            no3=backend.Register.convertRegister(token4);
                          if(no3>-1)
                          {
                             
                                    backend.convertToBinary.encodeRegister(no3,binaryconvert16,5,4,3);
                      
                              try {
                                  b = backend.Register.r[no2].b & backend.Register.r[no3].b;
                              } catch (Exception e) {
                            	  if(handlers.cmd_var==1){
                                  	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"TST operation failed");
                                    }
                                    else{
                                 
                               frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": TST operation failed.");
                 frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                            	  frontend.FrontEnd.exceptionraised++;      return;
                              }
                          }
                           else
                          {
                        	   if(handlers.cmd_var==1){
                        	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                        	        }
                        	        else{
                        	     
                               frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                        	   frontend.FrontEnd.exceptionraised++;        return;
                          }
                      }
                      else if(no2==-2)
                      {
                    	  if(handlers.cmd_var==1){
                          	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                            }
                            else{
                         
                          frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                    	  frontend.FrontEnd.exceptionraised++;       return;
                      
                      } 


                  }

    
    
public static void execTST(String token3, String token4)
    {

            String num;
            
 no2=backend.Register.convertRegister(token3);
               if(no2>-1)
               {
                  
                  backend.convertToBinary.encodeRegister(no2,binaryconvert,19,18,17,16);
                     binaryconvert[15]=0;
                     binaryconvert[14]=0;
                     binaryconvert[13]=0;
                     binaryconvert[12]=0;
                    no3=backend.Register.convertRegister(token4);
                   if(no3>-1)
                   {
                      
                      
                          binaryconvert[25]=0;
                            binaryconvert[11]=0;
                           binaryconvert[10]=0;
                           binaryconvert[9]=0;
                           binaryconvert[8]=0;
                           binaryconvert[7]=0;
                           binaryconvert[6]=0;
                           binaryconvert[5]=0;
                           binaryconvert[4]=0;
                             backend.convertToBinary.encodeRegister(no3,binaryconvert,3,2,1,0);
               
                       try {
                           b = backend.Register.r[no2].b & backend.Register.r[no3].b;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"TST operation failed");
                    	        }
                    	        else{
                    	     
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": TST operation failed.");
          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }
                    	   frontend.FrontEnd.exceptionraised++;      return;
                       }
                   }
                   else if(token4.startsWith("#"))
                   {
                       
                       int operand_2 = 0;
                       try {
                           operand_2 = Integer.parseInt(token4.substring(1));
                       } catch (NumberFormatException numberFormatException) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                    	        }
                    	        else{
                    	     
                    frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                    	   frontend.FrontEnd.exceptionraised++;       return;  }
                               backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
          
                        try {
                           b = backend.Register.r[no2].b & operand_2;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": TST operation failed.");
                    	        }
                    	        else{
                    	     
                       frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": TST operation failed.");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                    	   frontend.FrontEnd.exceptionraised++;      return;
                       }
                        


                   }
                   else
                   {
                	   if(handlers.cmd_var==1){
                	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                	        }
                	        else{
                	     
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }
                	   frontend.FrontEnd.exceptionraised++;        return;
                   }
               }
               else if(no2==-2)
               {
            	   
            	   if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
            	        }
            	        else{
            	     
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
            	   frontend.FrontEnd.exceptionraised++;       return;
               
               } 


           }
    }
    
   


