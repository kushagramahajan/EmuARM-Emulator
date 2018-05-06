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
public class ORR implements InsInterface4,InsInterface3{
static int[] binaryconvert=null;
static int[] binaryconvert16=null;
   static int no,no2,no3,chck;
     static int operand_2;

    @Override
    public void execute(String ins, String token2, String token3, String token4) {
        binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=1;
        binaryconvert[23]=1;
        binaryconvert[22]=0;
        binaryconvert[21]=0;
         backend.InstructionSet.ORR token1=backend.InstructionSet.ORR.valueOf(ins);
        switch(token1)
               {
                   case ORR:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                        execORR(token2,token3,token4);
                        break;
                   case ORREQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRHS:
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRPL:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRVC:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORRAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execORR(token2,token3,token4);
                       }
                       break;
                   case ORREQS:
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
 
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRNES:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRHSS:
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRLOS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRMIS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRPLS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRVSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRVCS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRHIS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRLSS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRGES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRLTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRGTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRLES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRALS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execORR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case ORRS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       execORR(token2,token3,token4);
                       if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                          
                       break;


               }
        
    }


    public void execute(String ins, String token2, String token3){
  	  binaryconvert16=new int[16];
        binaryconvert16[15]=0;
        binaryconvert16[14]=1;
        binaryconvert16[13]=0;
        binaryconvert16[12]=0;
        binaryconvert16[11]=0;
        binaryconvert16[10]=0;
        binaryconvert16[9]=1;
        binaryconvert16[8]=1;
        binaryconvert16[7]=0;
        binaryconvert16[6]=0;
        
        backend.InstructionSetThumb.ORR token1=backend.InstructionSetThumb.ORR.valueOf(ins);
        switch(token1){
      	  case ORR:
      		  execORR(token2,token3);
      		if(FrontEnd.build_flag==0)
                backend.Condition.updateFlags(no);
                break;
            
      	  case ORRS:
      		  execORR(token2,token3);
      		if(FrontEnd.build_flag==0)
                backend.Condition.updateFlags(no);
                break;
              
        }
      
  }
  
  public static void execORR(String token2,String token3){
  	no=backend.Register.convertRegister(token2);
      if(no>-1)
      {
    	  if(FrontEnd.build_flag==0)
          backend.convertToBinary.encodeRegister(no,binaryconvert16,2,1,0);
              int operand_1 = backend.Register.r[no].value();
              no3=backend.Register.convertRegister(token3);
              
              if(token3.startsWith("R"))
              {		chck=1;
            	  int operand_2=0;
              try {
                      operand_2 = backend.Register.r[no3].value();
                      if(FrontEnd.build_flag==0)
                      backend.convertToBinary.encodeRegister(no3,binaryconvert16,5,4,3);
          
                      //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                      operand_1 = operand_1 | operand_2;
                      if(FrontEnd.build_flag==0)
                      backend.Register.r[no].storeValue(operand_1);
                  } catch (Exception e) {
                	  if(handlers.cmd_var==1){
                      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ORR operation failed");
                        }
                        else{
                     
                      frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ORR operation failed");         
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                	  frontend.FrontEnd.exceptionraised++;        return;
                  }
                  

              }
                  else
              {
                	  if(handlers.cmd_var==1){
                      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                        }
                        else{
                     
                              frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                	  frontend.FrontEnd.exceptionraised++;   
                              return;   }
          }
          
      else if(no==-2) 
       {
    	  if(handlers.cmd_var==1){
          	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
            }
            else{
         
           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
         frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());   }
    	  frontend.FrontEnd.exceptionraised++;    return; 
       }

  }
  

    
public static void execORR(String token2,String token3, String token4)
    {
          no=backend.Register.convertRegister(token2);
    if(no>-1)
           {
    		if(FrontEnd.build_flag==0)
               backend.convertToBinary.encodeRegister(no,binaryconvert,19,18,17,16);
                 no2=backend.Register.convertRegister(token3);
               if(no2>=-1)
               {
            	   if(FrontEnd.build_flag==0)
                   backend.convertToBinary.encodeRegister(no2,binaryconvert,15,14,13,12);
                   no3=backend.Register.convertRegister(token4);
                   if(token4.startsWith("R"))
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
                           backend.Register.r[no].b = backend.Register.r[no2].b | backend.Register.r[no3].b;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ORR operation failed");
                    	        }
                    	        else{
                    	     
                         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ORR operation failed");         
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                    	   frontend.FrontEnd.exceptionraised++;           return;
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
               frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                    	   frontend.FrontEnd.exceptionraised++;        return;  }
                        if(FrontEnd.build_flag==0)     
                        backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
          
                        try {
                        	if(FrontEnd.build_flag==0)
                           backend.Register.r[no].b = backend.Register.r[no2].b | operand_2;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ORR operation failed");
                    	        }
                    	        else{
                    	     
                       frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ORR operation failed");         
             frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                    	   frontend.FrontEnd.exceptionraised++;       return;
                       }
                      }
                   else
                   {
                	   if(handlers.cmd_var==1){
                	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                	        }
                	        else{
                	     
                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                	   frontend.FrontEnd.exceptionraised++;     return;  }
               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of ORR should be a register and "+token3+" is not a valid register.");
            	        }
            	        else{
            	     
                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of ORR should be a register and "+token3+" is not a valid register.");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
            	   frontend.FrontEnd.exceptionraised++;     return;}


           }
    else if(no==-2)
    {
    	if(handlers.cmd_var==1){
        	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of ORR should be a register and "+token2+" is not a valid register.");
          }
          else{
       
         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of ORR should be a register and "+token2+" is not a valid register.");
frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
    	frontend.FrontEnd.exceptionraised++;   return;}
 /*    try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
*/
    }
}
