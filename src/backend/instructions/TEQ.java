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
public class TEQ implements InsInterface3{

static int[] binaryconvert=null;    
static int no2,no3;
static int b=0;

    @Override
    public void execute(String ins, String token3, String token4) {
        binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=1;
        binaryconvert[23]=0;
        binaryconvert[22]=0;
        binaryconvert[21]=1;
        backend.InstructionSet.TEQ token1=backend.InstructionSet.TEQ.valueOf(ins);
               switch(token1)
               {
                   case TEQ:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                        execTEQ(token3,token4);
                        if(FrontEnd.build_flag==0)
                        backend.Condition.updateFlags(b);
                        break;
                   case TEQEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQVC:
                      binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQHI:
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                        
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQGT:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQLE:
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        binaryconvert[20]=0;
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;
                   case TEQAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        binaryconvert[20]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execTEQ(token3,token4);
                          if(FrontEnd.build_flag==0)
                          backend.Condition.updateFlags(b);
                       }
                       break;

               }
        
    }

    
public static void execTEQ(String token3, String token4)
    {

            String num;

                no2=backend.Register.convertRegister(token3);
               if(no2>-1)
               {
            	   if(FrontEnd.build_flag==0)
                     backend.convertToBinary.encodeRegister(no2,binaryconvert,19,18,17,16);
                     binaryconvert[15]=0;
                     binaryconvert[14]=0;
                     binaryconvert[13]=0;
                     binaryconvert[12]=0;
                     
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
                           b = backend.Register.r[no2].b ^ backend.Register.r[no3].b;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": TEQ operation failed.\n");
                    	        }
                    	        else{
                    	     
                         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": TEQ operation failed.\n");         
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++;   return;
                       }
   
                   }
                   else if(token4.startsWith("#"))
                   {

                       int operand_2 = 0;
                       try {
                           operand_2 = Integer.parseInt(token4.substring(1));
                       } catch (NumberFormatException numberFormatException) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                    	        }
                    	        else{
                    	     
                 frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");         
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}       frontend.FrontEnd.exceptionraised++;      return;  }
                       if(FrontEnd.build_flag==0)        
                       backend.convertToBinary.encodeSecondOperand(operand_2,binaryconvert);
          
                        try {
                           b = backend.Register.r[no2].b ^ operand_2;
                       } catch (Exception e) {
                    	   if(handlers.cmd_var==1){
                    	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": TEQ operation failed.\n");
                    	        }
                    	        else{
                    	     
                         frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": TEQ operation failed.\n");         
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}   frontend.FrontEnd.exceptionraised++;return;
                       }
                   }
                   else
                   {
                	   if(handlers.cmd_var==1){
                	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                	        }
                	        else{
                	     
                 frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");         
          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}    frontend.FrontEnd.exceptionraised++;     return;}


                   }
               else if(no2==-2)
                    {
            	   if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
            	        }
            	        else{
            	     
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");         
         frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  } frontend.FrontEnd.exceptionraised++;   return;
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


