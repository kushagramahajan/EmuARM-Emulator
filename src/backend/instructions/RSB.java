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
public class RSB implements InsInterface4{
static int[] binaryconvert=null;
      static int no,no2,no3,chck;
      static int operand_2;

    @Override
    public void execute(String ins, String token2, String token3, String token4) {
        binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=0;
        binaryconvert[23]=0;
        binaryconvert[22]=1;
        binaryconvert[21]=1;
         backend.InstructionSet.RSB token1=backend.InstructionSet.RSB.valueOf(ins);
        switch(token1)
               {
                   case RSB:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                        execRSB(token2,token3,token4);
                        break;
                   case RSBEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBVS:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execRSB(token2,token3,token4);
                       }
                       break;
                   case RSBEQS:
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
 
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBNES:
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBHSS:
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBLOS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBMIS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBPLS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBVSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBVCS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBHIS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBLSS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBGES:
                      binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBLTS:
                      binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBGTS:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBLES:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBALS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execRSB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case RSBS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       execRSB(token2,token3,token4);
                       if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       break;


               }
          
    }

    
public static void execRSB(String token2,String token3, String token4)
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
                       try {
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
               
                        operand_d = operand_2 - operand_1;
 						if(FrontEnd.build_flag==0)
                           backend.Register.r[no].storeValue(operand_d);
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"RSB operation failed");
                    	        }
                    	        else{
                    	     
                         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"RSB operation failed");         
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                    	   frontend.FrontEnd.exceptionraised++;      return;
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
                    	   frontend.FrontEnd.exceptionraised++;        return; }
                       if(FrontEnd.build_flag==0) 
                       backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
          
                        operand_d=operand_2-operand_1;
                       try {
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no].storeValue(operand_d);
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"RSB operation failed");
                    	        }
                    	        else{
                    	     
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"RSB operation failed");         
      frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }
                    	   frontend.FrontEnd.exceptionraised++;          return;
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
                	   frontend.FrontEnd.exceptionraised++;   return;  }
               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of RSB should be a register and "+token3+" is not a valid register.");
            	        }
            	        else{
            	     
              frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of RSB should be a register and "+token3+" is not a valid register.");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++;    return;
               }


           }
    else if(no==-2)
    {if(handlers.cmd_var==1){
    	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of RSB should be a register and "+token2+" is not a valid register.");
      }
      else{
   
         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of RSB should be a register and "+token2+" is not a valid register.");
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
    frontend.FrontEnd.exceptionraised++; return; }
          /*    try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/

    }

}
