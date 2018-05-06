/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.instructions;

import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author win-7
 */
public class MUL implements InsInterface4,InsInterface3 {
 static int no,no2,no3;
 public static int[] binaryconvert16=null;
    @Override
    public void execute(String ins, String token2, String token3, String token4) {
       backend.InstructionSet.MUL token1=backend.InstructionSet.MUL.valueOf(ins);
       switch(token1)
       {
           case MUL:
                         
                        execMUL(token2,token3,token4);
                        break;
                   case MULEQ:
                         if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULNE:
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULHS:
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULLO:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULMI:
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULPL:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULVS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULVC:
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULHI:
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULLS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULGE:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULLT:
                       
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULGT:
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULLE:
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULAL:
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMUL(token2,token3,token4);
                       }
                       break;
                   case MULEQS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULNES:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULHSS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULLOS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULMIS:
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULPLS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULVSS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULVCS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULHIS:
                     
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULLSS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULGES:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULLTS:
                     
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULGTS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULLES:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULALS:
                      
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMUL(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                            backend.Condition.updateFlags(no);
                       }
                       break;
                   case MULS:
                      
                       execMUL(token2,token3,token4);
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
        binaryconvert16[6]=1;
        
        backend.InstructionSetThumb.MUL token1=backend.InstructionSetThumb.MUL.valueOf(ins);
        switch(token1){
      	  case MUL:
      		  execMUL(token2,token3);
      		if(FrontEnd.build_flag==0)
                backend.Condition.updateFlags(no);
                break;
            
      	  case MULS:
      		  execMUL(token2,token3);
      		if(FrontEnd.build_flag==0)
                backend.Condition.updateFlags(no);
                break;
              
        }
      
  }
  
  public static void execMUL(String token2,String token3){
  	no=backend.Register.convertRegister(token2);
      if(no>-1)
      {
          backend.convertToBinary.encodeRegister(no,binaryconvert16,2,1,0);
              int operand_1 = backend.Register.r[no].value();
              no3=backend.Register.convertRegister(token3);
              
              if(no3>-1)
              {	int operand_2=0;
              try {
                      operand_2 = backend.Register.r[no3].value();
                      
                      backend.convertToBinary.encodeRegister(no3,binaryconvert16,5,4,3);
          
                      //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                      operand_1 = operand_1 * operand_2;
                      if(FrontEnd.build_flag==0)
                      backend.Register.r[no].storeValue(operand_1);
                  } catch (Exception e) {
                	  if(handlers.cmd_var==1){
                   	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"MUL operation failed");
                      }
                      else{
                   
                      frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"MUL operation failed");         
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }    frontend.FrontEnd.exceptionraised++;        return;
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
                              return; 
              }
          }
          
      else if(no==-2) 
       {
    	  if(handlers.cmd_var==1){
         	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
            }
            else{
        
           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
         frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());   }    frontend.FrontEnd.exceptionraised++;    return; 
       }

  }
  

    
    private void execMUL(String token2, String token3, String token4) {
        no=backend.Register.convertRegister(token2);
        if(no>-1)
        {
            no2=backend.Register.convertRegister(token3);
            if(no2>-1)
            {
                no3=backend.Register.convertRegister(token4);
                if(no3>-1)
                {if(FrontEnd.build_flag==0)
                    backend.Register.r[no].b=backend.Register.r[no2].b*backend.Register.r[no3].b;
                }
                else
                {
                	
                	if(handlers.cmd_var==1){
                  	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
                     }
                     else{
                 
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                	frontend.FrontEnd.exceptionraised++;     return;   
                }
            }
            else if(no2==-2)
            {
            	if(handlers.cmd_var==1){
              	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
                 }
                 else{
             
                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());} frontend.FrontEnd.exceptionraised++;     return;  
            }
        }
        else if(no==-2)
        {
        	if(handlers.cmd_var==1){
          	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
             }
             else{
         
            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token2+" is not a valid operand.");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}   frontend.FrontEnd.exceptionraised++;     return;  
        }
    }
    
}
