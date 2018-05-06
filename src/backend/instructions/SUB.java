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
public class SUB implements InsInterface4,InsInterface3 {
static int[] binaryconvert=null;
static int[] binaryconvert16=null;
      static int no,no2,no3,chck;

    @Override
    public void execute(String ins, String token2, String token3, String token4) {
        if(ScanFile.a_mode==1){
        	execute(ins,token2,token3,token4,0);
        	return;
        }
    	binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=0;
        binaryconvert[23]=0;
        binaryconvert[22]=1;
        binaryconvert[21]=0;
         backend.InstructionSet.SUB token1=backend.InstructionSet.SUB.valueOf(ins);
        switch(token1)
               {
                   case SUB:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                        execSUB(token2,token3,token4);
                        break;
                   case SUBEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBPL:
                     binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBVC:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBGT:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                   case SUBAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSUB(token2,token3,token4);
                       }
                       break;
                  case SUBEQS:
                     binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
 
                       
                      if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBNES:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBHSS:
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBLOS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBMIS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBPLS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBVSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBVCS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBHIS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBLSS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBGES:
                      binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBLTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBGTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBLES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBALS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execSUB(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       }
                       break;
                   case SUBS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       execSUB(token2,token3,token4);
                       if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                       break;


               }
        
    }
    public void execute(String ins, String token2, String token3, String token4 ,int x){
    	binaryconvert16=new int[16];
        binaryconvert16[15]=0;
        binaryconvert16[14]=0;
        binaryconvert16[13]=0;
        binaryconvert16[12]=1;
        binaryconvert16[11]=1;
        binaryconvert16[9]=1;
 backend.InstructionSetThumb.SUB token1=backend.InstructionSetThumb.SUB.valueOf(ins);
      
    	switch(token1)
        {
            case SUB:

                 execSUB(token2,token3,token4,x);
                 
                 //if(backend.Register.convertRegister(token2)<8 && backend.Register.convertRegister(token3)<8 && backend.Register.convertRegister(token4)<8){
                 if(FrontEnd.build_flag==0)
                 if(chck==1)
                   backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                 else
                   backend.Condition.updateFlags(no,token1.name(),no2, no3,chck);//}
              break;
            
            case SUBS:

            	execSUB(token2,token3,token4,x);
                
            	if(FrontEnd.build_flag==0)
                if(chck==1)
                  backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                else
                  backend.Condition.updateFlags(no,token1.name(),no2, no3,chck);
             break;
           	
        }
        
    }
    
    public void execute(String ins, String token2, String token3){
    	binaryconvert16=new int[16];
        binaryconvert16[15]=0;
        binaryconvert16[14]=0;
        binaryconvert16[13]=1;
        binaryconvert16[12]=1;
        binaryconvert16[11]=1;
        
        backend.InstructionSetThumb.SUB token1=backend.InstructionSetThumb.SUB.valueOf(ins);
      
    	switch(token1)
        {
            case SUB:

                 execSUB(token2,token3);
                 
                 //if(backend.Register.convertRegister(token2)<8 && backend.Register.convertRegister(token3)<8 && backend.Register.convertRegister(token4)<8){
                 if(FrontEnd.build_flag==0)
                 if(chck==1)
                   backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
                 else
                   backend.Condition.updateFlags(no,token1.name(),no, no3,chck);//}
              break;
            
            case SUBS:

            	execSUB(token2,token3);
                
            	if(FrontEnd.build_flag==0)
                if(chck==1)
                  backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
                else
                  backend.Condition.updateFlags(no,token1.name(),no, no3,chck);
             break;
           	
        }
        

    }

    public static void execSUB(String token2,String token3, String token4,int x){
    	no=backend.Register.convertRegister(token2);
        if(no>-1)
        {
        	if(FrontEnd.build_flag==0)
            backend.convertToBinary.encodeRegister(no,binaryconvert16,5,4,3);
            int operand_d;
            no2=backend.Register.convertRegister(token3);
            if(no2>-1)
            {
                int operand_1 = 0;
                operand_1 = backend.Register.r[no2].value();
               
                if(FrontEnd.build_flag==0)
                backend.convertToBinary.encodeRegister(no2,binaryconvert16,2,1,0);
                
                no3=backend.Register.convertRegister(token4);
                if(no3>-1)
                {binaryconvert16[10]=0;
                    chck=1;
                    try {
                    	int operand_2=0;
                        operand_2 = backend.Register.r[no3].value();
                        if(FrontEnd.build_flag==0)
                        backend.convertToBinary.encodeRegister(no3,binaryconvert16,8,7,6);
            
                        ////System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                        operand_d = operand_1 - operand_2;
                        if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_d);
                        else
                     	   backend.Register.r[no].storeValue(0);

                    } catch (Exception e) {
                    	if(handlers.cmd_var==1){
                      	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");
                         }
                         else{
                     
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");         
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }    frontend.FrontEnd.exceptionraised++;        return;
                    }
                    

                }
                else if(token4.startsWith("#"))
                {
                     chck=0;
                     binaryconvert16[10]=1;
                     int operand_2=0;
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
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }     frontend.FrontEnd.exceptionraised++;     return;  }
                    if(FrontEnd.build_flag==0)          
                    backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert16,6,8);
            
                     //System.out.println("op2 :"+operand_2);
                     operand_d=operand_1-operand_2;
                    try {
                    	if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_d);
                    	else
                     	   backend.Register.r[no].storeValue(0);

                    } catch (Exception e) {
                    	if(handlers.cmd_var==1){
                       	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");
                          }
                          else{
                      
                      frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");         
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());   }   frontend.FrontEnd.exceptionraised++;      return;
                    }
                     //System.out.println("ans :"+operand_d);
                }
                else
                {
                	if(handlers.cmd_var==1){
                    	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                       }
                       else{
                   
                                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }  frontend.FrontEnd.exceptionraised++;   
                                return;   }
            } else if(no2==-2)
            {
            	if(handlers.cmd_var==1){
                	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
                   }
                   else{
               
            	frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
             frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }   frontend.FrontEnd.exceptionraised++;    return; 
            }
            


        }else if(no==-2) 
         {
        	if(handlers.cmd_var==1){
         	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
            }
            else{
        
             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }     frontend.FrontEnd.exceptionraised++;    return; 
         }

    }

    public static void execSUB(String token2,String token3){
    	no=backend.Register.convertRegister(token2);
        if(no>-1)
        {
        	if(FrontEnd.build_flag==0)
            backend.convertToBinary.encodeRegister(no,binaryconvert16,10,9,8);
                int operand_1 = backend.Register.r[no].value();
                no3=backend.Register.convertRegister(token3);
                

                if(token3.startsWith("#"))
                {
                     chck=0;
                     int l=0;int operand_2=0;
                    try {
                    	if(token3.startsWith("#0X")){
                 		   operand_2 = Integer.parseInt(token3.trim().substring(3),16); 
                 	   }
                 	   else
                        operand_2 = Integer.parseInt(token3.substring(1));
                    } catch (NumberFormatException numberFormatException) {
                    	if(handlers.cmd_var==1){
                        	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                           }
                           else{
                       
                       frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");         
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }     frontend.FrontEnd.exceptionraised++;     return;  }
                    if(FrontEnd.build_flag==0)          
                    backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert16,0,7);
            
                     //System.out.println("op2 :"+operand_2);
                     operand_1=operand_1-operand_2;
                    try {
                    	if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_1);
                    	else
                     	   backend.Register.r[no].storeValue(0);

                    } catch (Exception e) {
                    	if(handlers.cmd_var==1){
                       	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");
                          }
                          else{
                      
                      frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");         
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }    frontend.FrontEnd.exceptionraised++;      return;
                    }
                     //System.out.println("ans :"+operand_1);
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
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }      frontend.FrontEnd.exceptionraised++;    return; 
         }

    }

    
public static void execSUB(String token2,String token3, String token4)
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
                           int operand_2 = 0;
                       
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
               
    operand_d = operand_1 - operand_2;
    					if(FrontEnd.build_flag==0)
                           backend.Register.r[no].storeValue(operand_d);
    					else
                     	   backend.Register.r[no].storeValue(0);

                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                          	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");
                             }
                             else{
                         
                           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");         
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;   return;
                       }

                   }
                   else if(token4.startsWith("#"))
                   {
                        chck=0;

                        int operand_2 = 0;
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
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }frontend.FrontEnd.exceptionraised++;     return;
                       }
                       if(FrontEnd.build_flag==0)
                        backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
          
                        operand_d=operand_1-operand_2;
                       try {
                    	   if(FrontEnd.build_flag==0)
                    	   backend.Register.r[no].storeValue(operand_d);
                    	   else
                        	   backend.Register.r[no].storeValue(0);

                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                          	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");
                             }
                             else{
                         
                           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"SUB operation failed");         
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }   frontend.FrontEnd.exceptionraised++;     return;
                       }
                   }
                   else
                   {
                	   if(handlers.cmd_var==1){
                       	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                          }
                          else{
                      
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}   frontend.FrontEnd.exceptionraised++;      return;}
               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
                	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
                   }
                   else{
               
               frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of SUB should be a register and "+token3+" is not a valid register.");
      frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }   frontend.FrontEnd.exceptionraised++;     return; }


           }
    else if(no==-2)
            {
    	if(handlers.cmd_var==1){
     	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of SUB should be a register and "+token2+" is not a valid register.");
        }
        else{
    
              frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of SUB should be a register and "+token2+" is not a valid register.");
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++;     return;
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
