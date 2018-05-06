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
public class BIC implements InsInterface4,InsInterface3{
//static int[] binaryconvert=null;
  static int no,no2,no3;
    static int operand_2;

    @Override
    public void execute(String ins, String token2, String token3, String token4) {
       backend.ScanFile.binaryconvert=new int[32];
        backend.ScanFile.binaryconvert[27]=0;
        backend.ScanFile.binaryconvert[26]=0;
        backend.ScanFile.binaryconvert[24]=1;
        backend.ScanFile.binaryconvert[23]=1;
        backend.ScanFile.binaryconvert[22]=1;
        backend.ScanFile.binaryconvert[21]=0;
        backend.InstructionSet.BIC token1=backend.InstructionSet.BIC.valueOf(ins);
               switch(token1)
               {
                   case BIC:
                        backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                        execBIC(token2,token3,token4);
                        break;
                   case BICEQ:
                        backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICNE:
                        backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICHS:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICLO:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICMI:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICPL:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICVS:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICVC:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICHI:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICLS:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICGE:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICLT:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICGT:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICLE:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICAL:    
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                       }
                       break;
                   case BICEQS:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICNES:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICHSS:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICLOS:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICMIS:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICPLS:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICVSS:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICVCS:
                       backend.ScanFile.binaryconvert[31]=0;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICHIS:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICLSS:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICGES:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICLTS:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=0;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICGTS:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICLES:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=0;
                        backend.ScanFile.binaryconvert[28]=1;
                        backend.ScanFile.binaryconvert[20]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                           backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICALS:    
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execBIC(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       }
                       break;
                   case BICS:
                       backend.ScanFile.binaryconvert[31]=1;
                        backend.ScanFile.binaryconvert[30]=1;
                        backend.ScanFile.binaryconvert[29]=1;
                        backend.ScanFile.binaryconvert[28]=0;
                        backend.ScanFile.binaryconvert[20]=0;
                        
                       execBIC(token2,token3,token4);
                       if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no);
                       break;


               }
         
    }
    public void execute(String ins, String token2, String token3){
    	backend.ScanFile.binaryconvert16=new int[16];
        backend.ScanFile.binaryconvert16[15]=0;
        backend.ScanFile.binaryconvert16[14]=1;
        backend.ScanFile.binaryconvert16[13]=0;
        backend.ScanFile.binaryconvert16[12]=0;
        backend.ScanFile.binaryconvert16[11]=0;
        backend.ScanFile.binaryconvert16[10]=0;
        backend.ScanFile.binaryconvert16[9]=1;
        backend.ScanFile.binaryconvert16[8]=1;
        backend.ScanFile.binaryconvert16[7]=1;
        backend.ScanFile.binaryconvert16[6]=0;
        
        backend.InstructionSetThumb.BIC token1=backend.InstructionSetThumb.BIC.valueOf(ins);
       
        switch(token1){
        
        case BIC:
        	execBIC(token2,token3);
        	if(FrontEnd.build_flag==0)
            backend.Condition.updateFlags(no);
         break;
        
        case BICS:
        	execBIC(token2,token3);
        	if(FrontEnd.build_flag==0)
            backend.Condition.updateFlags(no);
         break;
        
        }
    }
    
    public static void execBIC(String token2,String token3){
    	no=backend.Register.convertRegister(token2);
        if(no>-1)
        {
            if(FrontEnd.build_flag==0)
            backend.convertToBinary.encodeRegister(no,backend.ScanFile.binaryconvert16,2,1,0);
                int operand_1 = backend.Register.r[no].value();
                no3=backend.Register.convertRegister(token3);
                
                if(no3>-1)
                {	int operand_2=0;
                try {
                        operand_2 = backend.Register.r[no3].value();
                        
                        if(FrontEnd.build_flag==0)
                        backend.convertToBinary.encodeRegister(no3,backend.ScanFile.binaryconvert16,5,4,3);
            
                        //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                        operand_1 = operand_1 & (~operand_2);
                        if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_1);
                        else
                     	   backend.Register.r[no].storeValue(0);

                    } catch (Exception e) {
                    	if(handlers.cmd_var==1){
                    		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"BIC operation failed");
                    	}
                    	else{
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"BIC operation failed");         
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }   frontend.FrontEnd.exceptionraised++;        return;
                    }
                    

                }
                else
                {
                	if(handlers.cmd_var==1){
                		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                	}
                	else{
                    
                                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }  frontend.FrontEnd.exceptionraised++;   
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
    
public static void execBIC(String token2,String token3, String token4)
    {
        
      no=backend.Register.convertRegister(token2);
    if(no>-1)
           {
              if(FrontEnd.build_flag==0)
                backend.convertToBinary.encodeRegister(no,backend.ScanFile.binaryconvert,19,18,17,16);
                  no2=backend.Register.convertRegister(token3);
               if(no2>-1)
               {
                  
            	   if(FrontEnd.build_flag==0)
                   backend.convertToBinary.encodeRegister(no2,backend.ScanFile.binaryconvert,15,14,13,12);
                     no3=backend.Register.convertRegister(token4);
                   if(no3>-1)
                   {
                           backend.ScanFile.binaryconvert[25]=0;
                           backend.ScanFile.binaryconvert[11]=0;
                           backend.ScanFile.binaryconvert[10]=0;
                           backend.ScanFile.binaryconvert[9]=0;
                           backend.ScanFile.binaryconvert[8]=0;
                           backend.ScanFile.binaryconvert[7]=0;
                           backend.ScanFile.binaryconvert[6]=0;
                           backend.ScanFile.binaryconvert[5]=0;
                           backend.ScanFile.binaryconvert[4]=0;
                             
                           if(FrontEnd.build_flag==0)
                           backend.convertToBinary.encodeRegister(no3,backend.ScanFile.binaryconvert,3,2,1,0);
                 
                       try {
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no].b = backend.Register.r[no2].b & (~backend.Register.r[no3].b);
                    	   else
                        	   backend.Register.r[no].b=0;

                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                       		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"BIC operation failed");
                    	   }
                       	else{
                           
                           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"BIC operation failed");         
 frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}     frontend.FrontEnd.exceptionraised++;              return;
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
         frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());   }     frontend.FrontEnd.exceptionraised++;     return;  }
                       
                       if(FrontEnd.build_flag==0)                        
                       backend.convertToBinary.encodeSecondOperand(operand_2,backend.ScanFile.binaryconvert);
          
                       try {
                    	   
                    	   if(FrontEnd.build_flag==0)
                    	   backend.Register.r[no].b = backend.Register.r[no2].b & (~operand_2);
                    	   else
                        	   backend.Register.r[no].b=0;

                       
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                       		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"BIC operation failed");
                       	}
                       	else{
                           
                            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"BIC operation failed");         
         frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }    frontend.FrontEnd.exceptionraised++;     return;
                       }
                   }
                   else
                   {
                	   if(handlers.cmd_var==1){
                   		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                   	}
                   	else{
                       
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
      frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}   frontend.FrontEnd.exceptionraised++;           return;}

               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
                      	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of BIC should be a register and "+token3+" is not a valid register.");	
                      	}
                      	else{
                
                    frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The operands of BIC should be a register and "+token3+" is not a valid register.");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); } frontend.FrontEnd.exceptionraised++;        return;  }
           }
    else if(no==-2)
    {
    	if(handlers.cmd_var==1){
           	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of BIC should be a register and "+token2+" is not a valid register.");	
           	}
           	else{
     
    	
         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"The destination operand of BIC should be a register and "+token2+" is not a valid register.");
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
    	frontend.FrontEnd.exceptionraised++; return;}
    /* try { backend.ScanFile.outbin.append("\n");
   
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(backend.ScanFile.binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }
}
