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
public class ADC implements InsInterface4,InsInterface3{
static int[] binaryconvert=null;
static int[] binaryconvert16=null;
  static int no,no2,no3,chck;
static int operand_2;
    @Override
    public void execute(String ins, String token2, String token3, String token4) {
binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=0;
        binaryconvert[23]=1;
        binaryconvert[22]=0;
        binaryconvert[21]=1;
        backend.InstructionSet.ADC token1=backend.InstructionSet.ADC.valueOf(ins);
               switch(token1)
               {
                   case ADC:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        execadc(token2,token3,token4);
                        break;
                   case ADCEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCMI:
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCPL:
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCVS:
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCVC:
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCLS:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCGE:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCLT:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCGT:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCLE:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCAL:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadc(token2,token3,token4);
                       }
                       break;
                   case ADCEQS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCNES:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCHSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCLOS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCMIS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCPLS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCVSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCVCS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCHIS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCLSS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCGES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCLTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCGTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCLES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCALS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadc(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADCS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                        
                       execadc(token2,token3,token4);
                       if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
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
        binaryconvert16[8]=1;
        binaryconvert16[7]=0;
        binaryconvert16[6]=1;
        
        backend.InstructionSetThumb.ADC token1=backend.InstructionSetThumb.ADC.valueOf(ins);
        switch(token1){
      	  case ADC:
      		  execadc(token2,token3);
      		if(FrontEnd.build_flag==0)
      		if(chck==1)
                backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
              else
                backend.Condition.updateFlags(no,token1.name(),no,(int) operand_2,chck);
                break;
            
      	  case ADCS:
      		  execadc(token2,token3);
      		if(FrontEnd.build_flag==0)
      		if(chck==1)
                backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
              else
                backend.Condition.updateFlags(no,token1.name(),no,(int) operand_2,chck);
                break;
              
        }
      
  }
  
  public static void execadc(String token2,String token3){
  	no=backend.Register.convertRegister(token2);
      if(no>-1)
      {
          if(FrontEnd.build_flag==0)
          backend.convertToBinary.encodeRegister(no,binaryconvert16,2,1,0);
              int operand_1 = backend.Register.r[no].value();
              no3=backend.Register.convertRegister(token3);
              
              if(no3>-1)
            	  
              {	chck=1;
            	  int operand_2=0;
              try {
                      operand_2 = backend.Register.r[no3].value();
                      if(FrontEnd.build_flag==0)
                      backend.convertToBinary.encodeRegister(no3,binaryconvert16,5,4,3);
          
                      //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                      operand_1 = operand_1 + operand_2+backend.Condition.cpsr.C;
                      if(FrontEnd.build_flag==0)
                      backend.Register.r[no].storeValue(operand_1);
                      else
                    	  backend.Register.r[no].storeValue(0);
                        
                  } catch (Exception e) {
                      if(handlers.cmd_var==1){
                    	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADC operation failed");
                      }
                      else{
                    	  frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADC operation failed");         
                      
                	  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());    
                      }
                	  frontend.FrontEnd.exceptionraised++;
					  return;
                  }
                  

              }
                  else
              {
                	  
                	  if(handlers.cmd_var==1){
                    	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.\n");
                      }
                      else{
                    	
                              frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.\n");
                              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                      }
                              frontend.FrontEnd.exceptionraised++;   
                              return;   }
          }
          
      else if(no==-2) 
       {
    	  if(handlers.cmd_var==1){
        	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+" invalid operand.\n");
          }
          else{
           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.\n");
          
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
          }
           frontend.FrontEnd.exceptionraised++;    return; 
       }

  }
  

    
public static void execadc(String token2,String token3, String token4)
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
               
                           operand_d = operand_1 + operand_2 + backend.Condition.cpsr.C;
                           if(FrontEnd.build_flag==0)
                           backend.Register.r[no].storeValue(operand_d);
                           else
                        	   backend.Register.r[no].storeValue(0);
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                         	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADC operation failed");
                           }
                           else{
                         	
                    	   		 frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADC operation failed");         
							     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); 
                           }
							     frontend.FrontEnd.exceptionraised++;    return; 
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
                         	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.\n");
                           }
                           else{
                         	
                    	   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.\n");         
                             frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); 
                           } 
                             frontend.FrontEnd.exceptionraised++;     return;
		                }
                                 backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
               
                        operand_d=operand_1+operand_2+backend.Condition.cpsr.C;
                       try {
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no].storeValue(operand_d);
                    	   else
                    		   backend.Register.r[no].storeValue(0);
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                          	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADC operation failed");
                            }
                            else{
        
                    	   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADC operation failed");         
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                            }        
        frontend.FrontEnd.exceptionraised++;    return;
                       }
                   }
                   else
                   {
                	   if(handlers.cmd_var==1){
                      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.\n");
                        }
                        else{
                     
                     frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.\n");
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                        }
                	   frontend.FrontEnd.exceptionraised++;    return;
                   }
               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
                  	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.\n");
                    }
                    else{
                 
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.\n");
               frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                    }
            	   frontend.FrontEnd.exceptionraised++;    return; 
               }
              


           }
            else if(no==-2) 
            {
            	if(handlers.cmd_var==1){
                	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.\n");
                  }
                  else{
               
                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.\n");
             frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
            	frontend.FrontEnd.exceptionraised++;    return; 
            }
           
    /* try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }
    }


