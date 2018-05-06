/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;

import java.io.IOException;

import backend.ScanFile;
import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author geetika
 */
public class MOV implements InsInterface3{
static int[] binaryconvert=null;
static int[] binaryconvert16=null;
   
    static int no2,no3;


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
        binaryconvert[23]=1;
        binaryconvert[22]=0;
        binaryconvert[19]=0;
        binaryconvert[18]=0;
        binaryconvert[17]=0;
        binaryconvert[16]=0;
        binaryconvert[21]=1;
       backend.InstructionSet.MOV token1=backend.InstructionSet.MOV.valueOf(ins);
               switch(token1)
               {
                  case MOV:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                        execMOV(token3,token4);
                        break;
                   case MOVEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVMI:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVLE:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMOV(token3,token4);
                       }
                       break;
                   case MOVEQS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
 
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVNES:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVHSS:
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVLOS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVMIS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVPLS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVVSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVVCS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVHIS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVLSS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVGES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVLTS:
                      binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVGTS:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVLES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVALS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMOV(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       }
                       break;
                   case MOVS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       execMOV(token3,token4);
                       if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(backend.Register.r[no2].b);
                       break;
               }
        
    }
    
    public void execute(String ins, String token3, String token4,int x){
    	binaryconvert16=new int[16];
        binaryconvert16[15]=0;
//        binaryconvert16[14]=0;
//        binaryconvert16[13]=1;
//        binaryconvert16[12]=0;
//        binaryconvert16[11]=0;
//        
        backend.InstructionSetThumb.MOV token1=backend.InstructionSetThumb.MOV.valueOf(ins);
        
        switch(token1){
        
        case MOV:
        	
        	if(token4.startsWith("#")){
              binaryconvert16[14]=0;
              binaryconvert16[13]=1;
              binaryconvert16[12]=0;
              binaryconvert16[11]=0;

        		execMOV(token3,token4,x);
        		
        		//changed later earlier not commented
        		
//        		if(FrontEnd.build_flag==0)
//        		backend.Condition.updateFlags(backend.Register.r[no2].b);
            
        	}
        	
        	else if(backend.Register.convertRegister(token3)<=15 && (backend.Register.convertRegister(token4)<=15)){
        		binaryconvert16[14]=1;
                binaryconvert16[13]=0;
                binaryconvert16[12]=0;
                binaryconvert16[11]=0;
                binaryconvert16[10]=1;
                
        		execMOV(token3,token4,x,0);
        		if(FrontEnd.build_flag==0)
        		if(backend.Register.convertRegister(token3)<=7 && (backend.Register.convertRegister(token4)<=7)){
        			
        			backend.Condition.updateFlags(backend.Register.r[no2].b);
                }
        		
        	}
        	
            break;
        
        case MOVS:
        	
        	if(token4.startsWith("#")){
              binaryconvert16[14]=0;
              binaryconvert16[13]=1;
              binaryconvert16[12]=0;
              binaryconvert16[11]=0;

        		execMOV(token3,token4,x);
        		if(FrontEnd.build_flag==0)
        		backend.Condition.updateFlags(no2);
            }
        	
        	else if(backend.Register.convertRegister(token3)<=15 && (backend.Register.convertRegister(token4)<=15)){
        		binaryconvert16[14]=1;
                binaryconvert16[13]=0;
                binaryconvert16[12]=0;
                binaryconvert16[11]=0;
                binaryconvert16[10]=1;
                
        		execMOV(token3,token4,x,0);
        		if(FrontEnd.build_flag==0)
        		if(backend.Register.convertRegister(token3)<=7 && (backend.Register.convertRegister(token4)<=7)){
        			backend.Condition.updateFlags(no2);
                }
        		
        	}
        	
            break;        
        }
        
    }
    
    public static void execMOV(String token3, String token4,int x,int y){
    	if(backend.Register.convertRegister(token3)>7){
    		binaryconvert16[7]=1;
    	}
    	else{
    		binaryconvert16[7]=0;
    	}
    	
    	if(backend.Register.convertRegister(token4)>7){
    		binaryconvert16[6]=1;
    	}
    	else{
    		binaryconvert16[6]=0;
    	}
    	
    	no2=backend.Register.convertRegister(token3);
    	
         if(no2>-1)
         {
        	 
            backend.convertToBinary.encodeRegister(no2-8*binaryconvert16[7],binaryconvert16,2,1,0);
                
            	int operand_1 = backend.Register.r[no2].value();
                no3=backend.Register.convertRegister(token4);
                
                if(no3>-1)
                {	int operand_2=0;
                try {
                        operand_2 = backend.Register.r[no3].value();
                        
                        backend.convertToBinary.encodeRegister(no3-binaryconvert16[6]*8,binaryconvert16,5,4,3);
            
                        //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                        operand_1 = operand_2;
                        if(FrontEnd.build_flag==0){
                        backend.Register.r[no2].storeValue(operand_1);
                        backend.Register.r[no2].b=operand_1;
                        }
                        else{
                        	backend.Register.r[no2].storeValue(0);
                            backend.Register.r[no2].b=0;
                            	
                        }
                        
                    } catch (Exception e) {
                    	if(handlers.cmd_var==1){
                    		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"MOV operation failed");
                    	}
                    	else{
                    	
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"MOV operation failed");         
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
                            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}    frontend.FrontEnd.exceptionraised++;   
                                return;   }

         }
         
         else if(no2==-2) 
         {
        	 if(handlers.cmd_var==1){
         		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" invalid operand.");
         	}
         	else{
         	
             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}       frontend.FrontEnd.exceptionraised++;    return; 
         }

	
    }
    
    public static void execMOV(String token3, String token4,int x){

    	no2=backend.Register.convertRegister(token3);
           if(no2>-1)
           {
        	   
                    backend.convertToBinary.encodeRegister(no2,binaryconvert16,10,9,8);
   
                    
                no3=backend.Register.convertRegister(token4);
           
               if(token4.startsWith("#"))
               {

                    Integer operand_2 = 0;
                   try {
                	   if(token4.startsWith("#0X")){
                		   operand_2 = Integer.parseInt(token4.trim().substring(3),16);
                	   }
                	   else
                		   operand_2 = Integer.parseInt(token4.trim().substring(1));
                   } catch (NumberFormatException numberFormatException) {
                	   if(handlers.cmd_var==1){
                   		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                   	}
                   	else{
                   	
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                	   frontend.FrontEnd.exceptionraised++;
                        return;}
                   
                          backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert16,0,7);
      
                   try {
                	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no2].b = (int)operand_2;
                	   else
                		   backend.Register.r[no2].b = 0;
                   } catch (Exception e) {
                	   if(handlers.cmd_var==1){
                   		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"MOV operation failed");
                   	}
                   	else{
                   	
                	   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": MOV  operation failed.");
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++;         return;
                   }

               }
               else
               {
            	   if(handlers.cmd_var==1){
               		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
               	}
               	else{
               	
                    frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
      frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); } frontend.FrontEnd.exceptionraised++;        return;}
           }
           else if(no2==-2)
           {
        	   if(handlers.cmd_var==1){
           		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
           	}
           	else{
           	
                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}   frontend.FrontEnd.exceptionraised++;     return; }

    }
    
    
public static void execMOV(String token3, String token4)
    {

            String num;

                no2=backend.Register.convertRegister(token3);
               if(no2>-1)
               {
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
                             backend.convertToBinary.encodeRegister(no3,binaryconvert,3,2,1,0);
               
                       try {
                           if(no3==15)
                           {
                               if(backend.Register.r[no3].b!=backend.ScanFile.endOfProgram&&backend.Register.r[no3].b!=null)
                                {
                                    try {
                                            backend.ScanFile.br.seek(backend.Register.r[no3].b);
                                            backend.ScanFile.pos=backend.Register.r[no3].b.longValue();
                                            if(FrontEnd.build_flag==0)
                                            backend.Register.r[15].b=backend.Register.r[no3].b;
                                            else
                                     		   backend.Register.r[15].b = 0;
                                        }    
                                    catch (IOException ex) {
               
                                    	if(handlers.cmd_var==1){
                                    		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"MOV operation failed");
                                    	}
                                    	else{
                                    	
                                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": MOV operation failed.");
                                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}        frontend.FrontEnd.exceptionraised++;    return;     
               
                                        }
                                }
                                
                           }
                           else if(no3==14)
                        	   if(FrontEnd.build_flag==0)
                                backend.Register.r[no2].b = backend.Register.r[no3].b+8;
                        	   else
                        		   backend.Register.r[no2].b = 0;
                           else
                           {
                        	   if(FrontEnd.build_flag==0)
                               backend.Register.r[no2].b = backend.Register.r[no3].b;
                        	   else
                        		   backend.Register.r[no2].b = 0;
                           }
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                       		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"MOV operation failed");
                       	}
                       	else{
                       	
                           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": MOV  operation failed.");
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                    	   frontend.FrontEnd.exceptionraised++;     return;
                       }
                   }
                   else if(token4.startsWith("#"))
                   {

                        Integer operand_2 = 0;
                       try {
                    	   if(token4.startsWith("#0X")){
                    		   operand_2 = Integer.parseInt(token4.trim().substring(3),16); 
                    	   }
                    	   else{
                    		   operand_2 = Integer.parseInt(token4.trim().substring(1));
                    	   }
                    	   }catch (NumberFormatException numberFormatException) {
                    	   if(handlers.cmd_var==1){
                       		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                       	}
                       	else{
                       	
                            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                    	   frontend.FrontEnd.exceptionraised++;
            return;}
                              backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
          
                       try {
                          
                           if(no3==15)
                           {
                               if(operand_2!=backend.ScanFile.endOfProgram&&operand_2!=null)
                                {
                                    try {
                                            backend.ScanFile.br.seek(operand_2);
                                            backend.ScanFile.pos=operand_2.longValue();
                                            if(FrontEnd.build_flag==0)
                                            backend.Register.r[15].b=operand_2;
                                        }    
                                    catch (IOException ex) {
               
                                    	if(handlers.cmd_var==1){
                                    		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"MOV operation failed");
                                    	}
                                    	else{
                                    	
                                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": MOV operation failed.");
                                    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }  frontend.FrontEnd.exceptionraised++;    return;     
               
                                        }
                                }
                                
                           }
                           else if(no3==14)
                        	   if(FrontEnd.build_flag==0)
                                backend.Register.r[no2].b = operand_2+8;
                        	   else
                        		   backend.Register.r[no2].b = 0;
                           else
                           {if(FrontEnd.build_flag==0)
                               backend.Register.r[no2].b =operand_2;
                           else
                    		   backend.Register.r[no2].b = 0;
                           }
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                       		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"MOV operation failed");
                       	}
                       	else{
                       	
                           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": MOV  operation failed.");
         frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); } frontend.FrontEnd.exceptionraised++;         return;
                       }
 
                   }
                   else
                   {
                	   if(handlers.cmd_var==1){
                   		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                   	}
                   	else{
                   	
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++;        return;}
               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
               		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
               	}
               	else{
               	
                    frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;     return; }
                /*try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/



           }
}
