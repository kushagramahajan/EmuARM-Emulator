/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;

import java.io.IOException;
import javax.swing.JOptionPane;

import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author geetika
 */
public class RSC implements InsInterface4{
static int[] binaryconvert=null;
     static int no,no2,no3,chck;
     static int operand_2;

    @Override
    public void execute(String ins, String token2, String token3, String token4) {
        binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=0;
        binaryconvert[23]=1;
        binaryconvert[22]=1;
        binaryconvert[21]=1;
         backend.InstructionSet.RSC token1=backend.InstructionSet.RSC.valueOf(ins);
        switch(token1)
               {
                   case RSC:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                        execRSC(token2,token3,token4);
                        break;
                   case RSCEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCVC:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCGT:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSC(token2,token3,token4);
                       }
                       break;
                   case RSCEQS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
 
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCNES:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCHSS:
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCLOS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCMIS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCPLS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCVSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCVCS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCHIS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCLSS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCGES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCLTS:
                      binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCGTS:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCLES:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCALS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSCS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       execRSC(token2,token3,token4);
                       if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       break;


               }
          
    }

   
public static void execRSC(String token2,String token3, String token4)
    {
          no=backend.Register.convertRegister(token2);
    if(no>-1)
           {
    		if(FrontEnd.build_flag==0)
               backend.convertToBinary.encodeRegister(no,binaryconvert,19,18,17,16);
               int operand_d;
                 no2=backend.Register.convertRegister(token3);
               if(no2>-1)
               {
                   int operand_1 = 0;
                       operand_1 = backend.Register.r[no2].value();
                       
               if(FrontEnd.build_flag==0)       
               backend.convertToBinary.encodeRegister(no2,binaryconvert,15,14,13,12);
                     no3=backend.Register.convertRegister(token4);
                   if(no3>-1)
                   {
                       chck=1;
                      
                       
                           operand_2 = backend.Register.r[no3].value();
                       
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
                   
                       if(backend.Condition.cpsr.C==0)
                            operand_d=operand_2-operand_1-1;
                       else
                            operand_d=operand_2-operand_1;

                       try {
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no].storeValue(operand_d);
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"RSC operation failed");
                    	        }
                    	        else{
                    	     
                          frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"RSC operation failed");         
          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                    	   frontend.FrontEnd.exceptionraised++;return;
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
                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                    	   frontend.FrontEnd.exceptionraised++; return;     }
                       if(FrontEnd.build_flag==0)    
                       backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
          
                         if(backend.Condition.cpsr.C==0)
                            operand_d=operand_2-operand_1-1;
                       else
                            operand_d=operand_2-operand_1;
                       
                       try {
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no].storeValue(operand_d);
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"RSC operation failed");
                    	        }
                    	        else{
                    	     
                    frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"RSC operation failed");         
                 frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }
                    	   frontend.FrontEnd.exceptionraised++; return;  }
                   }
                   else
                   {
                	   if(handlers.cmd_var==1){
                	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                	        }
                	        else{
                	     
                              frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                	   frontend.FrontEnd.exceptionraised++; return; }
               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of RSC should be a register and "+token3+" is not a valid register.");
            	        }
            	        else{
            	     
              frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of RSC should be a register and "+token3+" is not a valid register.");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
            	   frontend.FrontEnd.exceptionraised++; return;}


           }
    else if(no==-2)
            {
    	if(handlers.cmd_var==1){
        	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of RSC should be a register and "+token2+" is not a valid register.");
          }
          else{
       
               frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of RSC should be a register and "+token2+" is not a valid register.");
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
    	frontend.FrontEnd.exceptionraised++;return;
            }
   /*  try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
*/
    }
}
