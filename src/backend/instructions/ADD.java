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
public class ADD implements InsInterface4,InsInterface3{
    
static int[] binaryconvert=null;
static int[] binaryconvert16=null;

    static int no,no2,no3,chck;
    static int operand_2;

    @Override
    public void execute(String ins, String token2, String token3, String token4) {
    	if(ScanFile.a_mode==1){
    		execute(ins,token2,token3,token4,0);
    		return ;
    	}
    	binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=0;
        binaryconvert[23]=1;
        binaryconvert[22]=0;
        binaryconvert[21]=0;
 backend.InstructionSet.ADD token1=backend.InstructionSet.ADD.valueOf(ins);
       
               switch(token1)
               {
                   case ADD:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                        execadd(token2,token3,token4);
                        break;
                   case ADDEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDHI:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execadd(token2,token3,token4);
                       }
                       break;
                   case ADDEQS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDNES:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDHSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDLOS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDMIS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDPLS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDVSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDVCS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDHIS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDLSS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDGES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDLTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDGTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDLES:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDALS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execadd(token2,token3,token4);
                          if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2,(int) operand_2,chck);
                       }
                       break;
                   case ADDS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                        
                       execadd(token2,token3,token4);
                       if(FrontEnd.build_flag==0)
                          if(chck==1)
                            backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                          else
                            backend.Condition.updateFlags(no,token1.name(),no2, (int) operand_2,chck);
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
        binaryconvert16[9]=0;
 backend.InstructionSetThumb.ADD token1=backend.InstructionSetThumb.ADD.valueOf(ins);
      
    	switch(token1)
        {
            case ADD:

                 execadd(token2,token3,token4,x);
                 
                 //if(backend.Register.convertRegister(token2)<8 && backend.Register.convertRegister(token3)<8 && backend.Register.convertRegister(token4)<8){
                 if(FrontEnd.build_flag==0)
                 if(chck==1)
                   backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                 else
                   backend.Condition.updateFlags(no,token1.name(),no2, (int) operand_2,chck);//}
              break;
            
            case ADDS:

            	execadd(token2,token3,token4,x);
                
            	if(FrontEnd.build_flag==0)
                if(chck==1)
                  backend.Condition.updateFlags(no,token1.name(),no2,no3,chck);
                else
                  backend.Condition.updateFlags(no,token1.name(),no2, (int) operand_2,chck);
             break;
           	
        }
        
    }
    
    public void execute(String ins, String token2, String token3){
    	binaryconvert16=new int[16];
        binaryconvert16[15]=0;
//        binaryconvert16[14]=0;
//        binaryconvert16[13]=1;
//        binaryconvert16[12]=1;
//        binaryconvert16[11]=0;
        int x=0;
        backend.InstructionSetThumb.ADD token1=backend.InstructionSetThumb.ADD.valueOf(ins);
      
    	switch(token1)
        {
            case ADD:

                 
                 if(token3.startsWith("#")){
                   binaryconvert16[14]=0;
                   binaryconvert16[13]=1;
                   binaryconvert16[12]=1;
                   binaryconvert16[11]=0;

                	 execadd(token2,token3);
                if(FrontEnd.build_flag==0)
                 if(chck==1)
                   backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
                 else
                   backend.Condition.updateFlags(no,token1.name(),no, (int) operand_2,chck);
                 }
                 else if(backend.Register.convertRegister(token2)<=15 && backend.Register.convertRegister(token3)<=15){
                	 
                	 binaryconvert16[14]=1;
                     binaryconvert16[13]=0;
                     binaryconvert16[12]=0;
                     binaryconvert16[11]=0;
                     binaryconvert16[10]=1;
                     binaryconvert16[9]=0;
                     binaryconvert16[8]=0;
                     
                	 execadd(token2,token3,x);
                	 
                	 if(backend.Register.convertRegister(token2)<=7 && backend.Register.convertRegister(token3)<=7)
                	 {
                		 if(FrontEnd.build_flag==0)
                             backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
                         
                           
                	 }
                	 
                 }
              break;
            
            case ADDS:

            	 if(token3.startsWith("#")){
                     binaryconvert16[14]=0;
                     binaryconvert16[13]=1;
                     binaryconvert16[12]=1;
                     binaryconvert16[11]=0;

                  	 execadd(token2,token3);
                  	if(FrontEnd.build_flag==0)
                   if(chck==1)
                     backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
                   else
                     backend.Condition.updateFlags(no,token1.name(),no, (int) operand_2,chck);
                   }
                   else if(backend.Register.convertRegister(token2)<=15 && backend.Register.convertRegister(token3)<=15){
                  	 
                  	 binaryconvert16[14]=1;
                       binaryconvert16[13]=0;
                       binaryconvert16[12]=0;
                       binaryconvert16[11]=0;
                       binaryconvert16[10]=1;
                       binaryconvert16[9]=0;
                       binaryconvert16[8]=0;
                       
                  	 execadd(token2,token3,x);
                  	 
                  	 if(backend.Register.convertRegister(token2)<=7 && backend.Register.convertRegister(token3)<=7)
                  	 {
                  		if(FrontEnd.build_flag==0)
                               backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
                  	 }
                  	 
                   }
            	
                break;
           	
        }
        

    }
    
    public static void execadd(String token2,String token3,int x){
    	if(backend.Register.convertRegister(token2)>7){
    		binaryconvert16[7]=1;
    	}
    	else{
    		binaryconvert16[7]=0;
    	}
    	
    	if(backend.Register.convertRegister(token3)>7){
    		binaryconvert16[6]=1;
    	}
    	else{
    		binaryconvert16[6]=0;
    	}
    	
    	no=backend.Register.convertRegister(token2);
    	
         if(no>-1)
         {
            backend.convertToBinary.encodeRegister(no-8*binaryconvert16[7],binaryconvert16,2,1,0);
                
            	int operand_1 = backend.Register.r[no].value();
                no3=backend.Register.convertRegister(token3);
                
                if(no3>-1)
                {	int operand_2=0;
                try {
                        operand_2 = backend.Register.r[no3].value();
                        backend.convertToBinary.encodeRegister(no3-binaryconvert16[6]*8,binaryconvert16,5,4,3);
            
                        //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                        operand_1 = operand_1 + operand_2;
                        if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_1);
                        else
                     	   backend.Register.r[no].storeValue(0);

                    } catch (Exception e) {
                    	if(handlers.cmd_var==1){
                    	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                    	}
                    	else{
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");         
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                    	}
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
                            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); 
                    	}
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
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
           	frontend.FrontEnd.exceptionraised++;    return; 
         }

    
    
    }
    
    public static void execadd(String token2,String token3){
    	no=backend.Register.convertRegister(token2);
        if(no>-1)
        {
            backend.convertToBinary.encodeRegister(no,binaryconvert16,10,9,8);
                int operand_1 = backend.Register.r[no].value();
                no3=backend.Register.convertRegister(token3);
                
                if(token3.startsWith("#"))
                {		int l=0;
                     chck=0;
                     
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
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                    	frontend.FrontEnd.exceptionraised++;     return;  }
                    backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert16,0,7);
            
                     //System.out.println("op2 :"+operand_2);
                     operand_1=operand_1+operand_2;
                    try {
                    	if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_1);
                    	else
                     	   backend.Register.r[no].storeValue(0);

                    } catch (Exception e) {

                       	if(handlers.cmd_var==1){
                        	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                        	}
                        	else{
                    	
                    	frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");         
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                       	frontend.FrontEnd.exceptionraised++;      return;
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
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
         	frontend.FrontEnd.exceptionraised++;    return; 
         }

    }
    

    
    
    public static void execadd(String token2,String token3, String token4,int x){
    	no=backend.Register.convertRegister(token2);
        if(no>-1)
        {   backend.convertToBinary.encodeRegister(no,binaryconvert16,2,1,0);
            int operand_d;
            no2=backend.Register.convertRegister(token3);
            if(no2>-1)
            {
                int operand_1 = 0;
                operand_1 = backend.Register.r[no2].value();
                backend.convertToBinary.encodeRegister(no2,binaryconvert16,5,4,3);
                
                no3=backend.Register.convertRegister(token4);
                if(no3>-1)
                {
                    chck=1;
                    try {
                        operand_2 = backend.Register.r[no3].value();
                        
                        backend.convertToBinary.encodeRegister(no3,binaryconvert16,8,7,6);
            
                        //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                        operand_d = operand_1 + operand_2;
                        
                        if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_d);
                        else
                     	   backend.Register.r[no].storeValue(0);

                    } catch (Exception e) {
                    	if(handlers.cmd_var==1){
                        	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                        	}
                        	else{
                    	
                    	frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");         
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                    	frontend.FrontEnd.exceptionraised++;        return;
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
                    frontend.FrontEnd.exceptionraised++;     return;  }
                    backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert16,6,8);
            
                     //System.out.println("op2 :"+operand_2);
                     operand_d=operand_1+operand_2;
                    try {
                    	if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_d);
                    	else
                     	   backend.Register.r[no].storeValue(0);

                    } catch (Exception e) {
                    	if(handlers.cmd_var==1){
                        	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                        	}
                        	else{
                    	
                      frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");         
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }
                    	frontend.FrontEnd.exceptionraised++;      return;
                    }
                     //System.out.println("ans :"+operand_d);
                }
                else
                {   if(handlers.cmd_var==1){
                	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");	
                	}
                	else{
            	
                                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                frontend.FrontEnd.exceptionraised++;   
                                return;   }
            } else if(no2==-2)
            {
            	if(handlers.cmd_var==1){
                	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");	
                	}
                	else{
      
                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
             frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}     frontend.FrontEnd.exceptionraised++;    return; 
            }
            


        }else if(no==-2) 
         {if(handlers.cmd_var==1){
         	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");	
         	}
         	else{

             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}       frontend.FrontEnd.exceptionraised++;    return; 
         }

    }
    
public static void execadd(String token2,String token3, String token4)
    {
        no=backend.Register.convertRegister(token2);
           if(no>-1)
           {
               backend.convertToBinary.encodeRegister(no,binaryconvert,19,18,17,16);
               int operand_d;
               no2=backend.Register.convertRegister(token3);
               if(no2>-1)
               {
                   int operand_1 = 0;
                   operand_1 = backend.Register.r[no2].value();
                   
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
                           
                           backend.convertToBinary.encodeRegister(no3,binaryconvert,3,2,1,0);
               
                           //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                           operand_d = operand_1 + operand_2;
                           
                           if(FrontEnd.build_flag==0)
                           backend.Register.r[no].storeValue(operand_d);
                           else
                        	   backend.Register.r[no].storeValue(0);

                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                           	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                           	}
                           	else{
                       	
                           frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");         
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }   frontend.FrontEnd.exceptionraised++;        return;
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
                    	   frontend.FrontEnd.exceptionraised++;     return;  }
                       
                       backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
               
                        //System.out.println("op2 :"+operand_2);
                        operand_d=operand_1+operand_2;
                       try {
                    	   
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no].storeValue(operand_d);
                    	   else
                        	   backend.Register.r[no].storeValue(0);

                    	   
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                           	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");	
                           	}
                           	else{
                       	
                         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"ADD operation failed");         
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}      frontend.FrontEnd.exceptionraised++;      return;
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
                               frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                	   frontend.FrontEnd.exceptionraised++;   
                                   return;   }
               } else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
                   	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");	
                   	}
                   	else{
         
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
                frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
            	   frontend.FrontEnd.exceptionraised++;    return; 
               }
               


           }else if(no==-2) 
            {
        	   if(handlers.cmd_var==1){
               	System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");	
               	}
               	else{
     
                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
        	   frontend.FrontEnd.exceptionraised++;    return; 
            }
   
  /*   try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
*/
     
    }
}

