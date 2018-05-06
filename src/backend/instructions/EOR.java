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
public class EOR implements InsInterface4,InsInterface3{
static int[] binaryconvert=null;
static int[] binaryconvert16=null;
     static int no,no2,no3;
     static int operand_2;

    @Override
    public void execute(String ins, String token2, String token3, String token4) {
      binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=0;
        binaryconvert[23]=0;
        binaryconvert[22]=0;
        binaryconvert[21]=1;
 backend.InstructionSet.EOR token1=backend.InstructionSet.EOR.valueOf(ins);
               switch(token1)
               {
                   case EOR:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        execEOR(token2,token3,token4);
                        break;
                   case EOREQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORNE:
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORHS:
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORPL:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORVS:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORLS:
                      binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORGT:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EORAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execEOR(token2,token3,token4);
                       }
                       break;
                   case EOREQS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
 
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORNES:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORHSS:
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORLOS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORMIS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORPLS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORVSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORVCS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORHIS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORLSS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORGES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORLTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORGTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORLES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORALS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execEOR(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case EORS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       execEOR(token2,token3,token4);
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
        binaryconvert16[9]=0;
        binaryconvert16[8]=0;
        binaryconvert16[7]=0;
        binaryconvert16[6]=1;
        
        backend.InstructionSetThumb.EOR token1=backend.InstructionSetThumb.EOR.valueOf(ins);
        switch(token1){
      	  case EOR:
      		  execEOR(token2,token3);
      		if(FrontEnd.build_flag==0)
                backend.Condition.updateFlags(no);
                break;
            
      	  case EORS:
      		  execEOR(token2,token3);
      		if(FrontEnd.build_flag==0)
                backend.Condition.updateFlags(no);
                break;
              
        }
      
  }
  
  public static void execEOR(String token2,String token3){
  	no=backend.Register.convertRegister(token2);
      if(no>-1)
      {
          if(FrontEnd.build_flag==0)
          backend.convertToBinary.encodeRegister(no,binaryconvert16,2,1,0);
              
          	int operand_1 = backend.Register.r[no].value();
              no3=backend.Register.convertRegister(token3);
              
              if(no3>-1)
              {	int operand_2=0;
              try {
                      operand_2 = backend.Register.r[no3].value();
                      
                      if(FrontEnd.build_flag==0)
                      backend.convertToBinary.encodeRegister(no3,binaryconvert16,5,4,3);
          
                      //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                      operand_1 = operand_1 ^ operand_2;
                      
                      if(FrontEnd.build_flag==0)
                      backend.Register.r[no].storeValue(operand_1);
                      else
                   	   backend.Register.r[no].storeValue(0);

                  
              } catch (Exception e) {
            		if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"EOR operation failed");
            	        }
            	        else{
            	    
                      frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"EOR operation failed");         
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}     frontend.FrontEnd.exceptionraised++;        return;
                  }
                  

              }
                  else
              {
                		if(handlers.cmd_var==1){
                	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                	        }
                	        else{
                	    
                              frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }   frontend.FrontEnd.exceptionraised++;   
                              return;   }
          }
          
      else if(no==-2) 
       {
    		if(handlers.cmd_var==1){
    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
    	        }
    	        else{
    	    
           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
         frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}       frontend.FrontEnd.exceptionraised++;    return; 
       }

  }
  

   
public static void execEOR(String token2,String token3, String token4)
    {
         no=backend.Register.convertRegister(token2);
         if(no>-1)
           {
              if(FrontEnd.build_flag==0)
               backend.convertToBinary.encodeRegister(no,binaryconvert,19,18,17,16);
                no2=backend.Register.convertRegister(token3);
               if(no2>-1)
               {
            	   				if(FrontEnd.build_flag==0)
                              backend.convertToBinary.encodeRegister(no2,binaryconvert,15,14,13,12);
       
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
                           if(FrontEnd.build_flag==0)
                             backend.convertToBinary.encodeRegister(no3,binaryconvert,3,2,1,0);
               
                       try {
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no].b = backend.Register.r[no2].b ^ backend.Register.r[no3].b;
                    	   else
                        	   backend.Register.r[no].b=0;

                       } catch (Exception e) {
                    		if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"EOR operation failed");
                    	        }
                    	        else{
                    	    
                    	   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"EOR operation failed");         
             frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}   frontend.FrontEnd.exceptionraised++;    return;
                       }
   
                   }
                   else if(token4.startsWith("#"))
                   {
                        
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
                    		frontend.FrontEnd.exceptionraised++;       return;  }
                       if(FrontEnd.build_flag==0)      
                       backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
          
                       try {
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no].b = backend.Register.r[no2].b ^ operand_2;
                    	   else
                        	   backend.Register.r[no].b=0;

                       } catch (Exception e) {
                    		if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"EOR operation failed");
                    	        }
                    	        else{
                    	    
                            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"EOR operation failed");         
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}    frontend.FrontEnd.exceptionraised++;  return;
                       }
 
                   }
                   else
                   {
                		if(handlers.cmd_var==1){
                	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                	        }
                	        else{
                	    
                          frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}      frontend.FrontEnd.exceptionraised++;  return;}
               }
               else if(no2==-2)
               {
            		if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of EOR should be a register and "+token3+" is not a valid register.");
            	        }
            	        else{
            	    
                 frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of EOR should be a register and "+token3+" is not a valid register.");
          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}   frontend.FrontEnd.exceptionraised++;  return; }

                   }
         else if(no==-2)
    {
        		if(handlers.cmd_var==1){
        	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of EOR should be a register and "+token2+" is not a valid register.");
        	        }
        	        else{
        	    
         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of EOR should be a register and "+token2+" is not a valid register.");
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++;return; }
              /*try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/

               }


           }
    


