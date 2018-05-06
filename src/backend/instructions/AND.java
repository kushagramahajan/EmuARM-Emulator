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
public class AND implements InsInterface4,InsInterface3{

    static int[] binaryconvert=null;
    static int[] binaryconvert16=null;
    
    static Integer no,no2,no3;
    static int operand_2;

    @Override
    public void execute(String ins, String token2, String token3, String token4) {
        binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=0;
        binaryconvert[23]=0;
        binaryconvert[22]=0;
        binaryconvert[21]=0;
        
        backend.InstructionSet.AND token1=backend.InstructionSet.AND.valueOf(ins);
               switch(token1)
               {
                   case AND:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        execAND(token2,token3,token4);
                        break;
                   case ANDEQ:
                        binaryconvert[20]=0;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDNE:
                        binaryconvert[20]=0;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDHS:
                        binaryconvert[20]=0;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDLO:
                        binaryconvert[20]=0;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDMI:
                        binaryconvert[20]=0;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDPL:
                        binaryconvert[20]=0;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDVS:
                        binaryconvert[20]=0;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDVC:
                        binaryconvert[20]=0;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDHI:
                        binaryconvert[20]=0;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDLS:
                        binaryconvert[20]=0;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDGE:
                        binaryconvert[20]=0;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDLT:
                        binaryconvert[20]=0;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDGT:
                        binaryconvert[20]=0;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDLE:
                        binaryconvert[20]=0;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;

                   case ANDAL:
                        binaryconvert[20]=0;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execAND(token2,token3,token4);
                       }
                       break;
                   case ANDEQS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDNES:
                        binaryconvert[20]=1;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDHSS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDLOS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDMIS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDPLS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDVSS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDVCS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDHIS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDLSS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDGES:
                        binaryconvert[20]=1;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDLTS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDGTS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDLES:
                        binaryconvert[20]=1;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;

                   case ANDALS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execAND(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;
                   case ANDS:
                        binaryconvert[20]=1;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       execAND(token2,token3,token4);
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
          binaryconvert16[6]=0;
          
          backend.InstructionSetThumb.AND token1=backend.InstructionSetThumb.AND.valueOf(ins);
          switch(token1){
        	  case AND:
        		  execAND(token2,token3);
        		  if(FrontEnd.build_flag==0)
                  backend.Condition.updateFlags(no);
                  break;
              
        	  case ANDS:
        		  execAND(token2,token3);
        		  if(FrontEnd.build_flag==0)
                  backend.Condition.updateFlags(no);
                  break;
                
          }
        
    }
    
    public static void execAND(String token2,String token3){
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
                        operand_1 = operand_1 & operand_2;
                        if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_1);
                        else
                     	   backend.Register.r[no].storeValue(0);

                    } catch (Exception e) {
                    	if(handlers.cmd_var==1){
                        	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"AND operation failed");	
                        	}
                        	else{
                    	
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"AND operation failed");         
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
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}       frontend.FrontEnd.exceptionraised++;    return; 
         }

    }
    
public static void execAND(String token2,String token3, String token4)
    {
     
        
      no=backend.Register.convertRegister(token2);
      if(no>-1)
           {
               
              if(FrontEnd.build_flag==0)
               backend.convertToBinary.encodeRegister(no,binaryconvert,19,18,17,16);
               //System.out.println("\n binary:\n");
               for(int i=31;i>=0;i--)
                   //System.out.print(binaryconvert[i]);
               //System.out.print("\n");
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
                           backend.Register.r[no].b = backend.Register.r[no2].b & backend.Register.r[no3].b;
                    	   else
                        	   backend.Register.r[no].b=0;

                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                           	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"AND operation failed");	
                           	}
                           	else{
                       	
                            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"AND operation failed");         
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;         return;
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
         frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}   frontend.FrontEnd.exceptionraised++;            return;}
                        if(FrontEnd.build_flag==0)          
                        backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
               
                       try {
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no].b = backend.Register.r[no2].b & operand_2;
                    	   else
                        	   backend.Register.r[no].b=0;

                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                           	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"AND operation failed");	
                           	}
                           	else{
                       	
                       frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"AND operation failed");         
          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }   frontend.FrontEnd.exceptionraised++;      return;
                       }
                   }
                   else
                   {
                	   if(handlers.cmd_var==1){
                       	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");	
                       	}
                       	else{
                   	
                  frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }    frontend.FrontEnd.exceptionraised++;       return;}
                       
                       
                   }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
                   	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of AND should be a register and "+token3+" is not a valid register.");	
                   	}
                   	else{
               	
                  frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of AND should be a register and "+token3+" is not a valid register.");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
            	   frontend.FrontEnd.exceptionraised++;         return;}
               }
      else if(no==-2)
    {
    	  if(handlers.cmd_var==1){
             	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of AND should be a register and "+token2+" is not a valid register.");	
            }
             	else{
         		  
        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of AND should be a register and "+token2+" is not a valid register.");
frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); } frontend.FrontEnd.exceptionraised++;  return; }
           /*   try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/



           }
    }

