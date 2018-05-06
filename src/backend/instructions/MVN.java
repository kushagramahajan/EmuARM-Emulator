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
public class MVN implements InsInterface3{

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
        binaryconvert[22]=1;
        binaryconvert[21]=1;
        binaryconvert[19]=0;
        binaryconvert[18]=0;
        binaryconvert[17]=0;
        binaryconvert[16]=0;
        
        backend.InstructionSet.MVN token1=backend.InstructionSet.MVN.valueOf(ins);
        switch(token1)
               {
                  case MVN:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                        execMVN(token3,token4);
                        break;
                   case MVNEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNMI:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNLE:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMVN(token3,token4);
                       }
                       break;
                   case MVNEQS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
 
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNNES:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNHSS:
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNLOS:
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNMIS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNPLS:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNVSS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNVCS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNHIS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNLSS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNGES:
                      binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNLTS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNGTS:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNLES:
                     binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNALS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-16)==1)
                       {
                          execMVN(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(no2);
                       }
                       break;
                   case MVNS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       execMVN(token3,token4);
                       if(FrontEnd.build_flag==0)
                       backend.Condition.updateFlags(no2);
                       break;
               }
         
    }
    
    public void execute(String ins, String token3, String token4,int x){
    	binaryconvert16[15]=0;
        binaryconvert16[14]=1;
        binaryconvert16[13]=0;
        binaryconvert16[12]=0;
        binaryconvert16[11]=0;
        binaryconvert16[10]=0;
        binaryconvert16[9]=1;
        binaryconvert16[8]=1;
        binaryconvert16[7]=1;
        binaryconvert16[6]=1;
        
    	backend.InstructionSetThumb.MVN token1=backend.InstructionSetThumb.MVN.valueOf(ins);
        
    	switch(token1){
    	
    	case MVN:
    		execMVN(token3,token4,x);
    		if(FrontEnd.build_flag==0)
            backend.Condition.updateFlags(no2);
            break;
            
    	case MVNS:
    		execMVN(token3,token4,x);
    		if(FrontEnd.build_flag==0)
            backend.Condition.updateFlags(no2);
            break;
            
    	}
    }

    public static void execMVN(String token3, String token4, int x){
    	String num;

    	  no2=backend.Register.convertRegister(token3);
    	               if(no2>-1)
    	               {
    	                   
    	     if(FrontEnd.build_flag==0)
    	     backend.convertToBinary.encodeRegister(no2,binaryconvert16,2,1,0);
    	         no3=backend.Register.convertRegister(token4);
    	                   if(no3>-1)
    	                   {
    	                	   if(FrontEnd.build_flag==0)
    	                       backend.convertToBinary.encodeRegister(no3,binaryconvert16,5,4,3);
    	               
    	                       try {
    	                    	   if(FrontEnd.build_flag==0)
    	                           backend.Register.r[no2].b = ~backend.Register.r[no3].b;
    	                       } catch (Exception e) {
    	                    	   if(handlers.cmd_var==1){
    	                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": MVN  operation failed.");
    	                    	        }
    	                    	        else{
    	                    	     
    	                               frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": MVN  operation failed.");
    	          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}    frontend.FrontEnd.exceptionraised++;      return;
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
                	    	   frontend.FrontEnd.exceptionraised++;return;             }
    	               		}
    	               else if(no2==-2)
    	               {
    	            	   if(handlers.cmd_var==1){
    	            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
    	            	        }
    	            	        else{
    	            	         
    	            	   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
    	 frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
    	            	   frontend.FrontEnd.exceptionraised++;  }
    	               /* try {
    	    backend.ScanFile.outbin.append("\n");
    	    for(int i=31;i>=0;i--)
    	       
    	            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
    	        } catch (IOException ex) {
    	            ex.printStackTrace();
    	        }*/


    }
    
    
public static void execMVN(String token3, String token4)
    {

            String num;

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
                           backend.Register.r[no2].b = ~backend.Register.r[no3].b;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": MVN  operation failed.");
                    	        }
                    	        else{
                    	     
                    	   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": MVN  operation failed.");
          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}    frontend.FrontEnd.exceptionraised++;      return;
                       }
                            
                     }



                   
                   else if(token4.startsWith("#"))
                   {

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
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                    	   frontend.FrontEnd.exceptionraised++;         return;   }
                       if(FrontEnd.build_flag==0)   
                       backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
            
                       try {
                    	   if(FrontEnd.build_flag==0)
                           backend.Register.r[no2].b = ~operand_2;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": MVN  operation failed.");
                    	        }
                    	        else{
                    	     
                    	   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": MVN  operation failed.");
          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
                    	   frontend.FrontEnd.exceptionraised++;     return;
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
                	   frontend.FrontEnd.exceptionraised++;return;             }
               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
            	        }
            	        else{
            	     
                                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
 frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());} frontend.FrontEnd.exceptionraised++;  }
               /* try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/

               }


           }

