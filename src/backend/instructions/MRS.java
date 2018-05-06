/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;

import java.io.IOException;

import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author geetika
 */
public class MRS implements InsInterface3{
static int[] binaryconvert=null;
    static int no2;


    @Override
    public void execute(String ins, String token3, String token4) {
       binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[25]=0;
        binaryconvert[24]=1;
        binaryconvert[23]=0;
        binaryconvert[21]=0;
        binaryconvert[20]=0;
        binaryconvert[19]=1;
        binaryconvert[18]=1;
        binaryconvert[17]=1;
        binaryconvert[16]=1;
        for(int j=0;j<=11;j++)
        binaryconvert[j]=0;
        
       backend.InstructionSet.MRS token1=backend.InstructionSet.MRS.valueOf(ins);
               switch(token1)
               {
                   case MRS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        execMRS(token3,token4);
                        break;
                   case MRSEQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSHI:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   case MRSAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMRS(token3,token4);
                       }
                       break;
                   
               }
        
    }

   
public static void execMRS(String token3, String token4)
    {

            String num;

            token3=token3.trim();
            token4=token4.trim();
            
              no2=backend.Register.convertRegister(token3);
               if(no2>-1)
               {
            	   if(FrontEnd.build_flag==0)
                    backend.convertToBinary.encodeRegister(no2,binaryconvert,15,14,13,12);
              
                   Integer val1=null;   
                   if(token4.startsWith("C"))
                   {
                       binaryconvert[22]=0;
                       val1=backend.Condition.cpsr.getValue();
                       if(FrontEnd.build_flag==0)
                         backend.Register.r[no2].b=val1;
                        
                   }
                   else if(token4.startsWith("S"))
                   {
                       binaryconvert[22]=1;
                       val1=backend.Condition.spsr.getValue();
                       if(FrontEnd.build_flag==0)
                       backend.Register.r[no2].b=val1;
                            if(backend.Condition.cpsr.modeUser())
                            	if(handlers.cmd_var==0){
                                 frontend.FrontEnd.statuswindow.append("WARNING in line "+backend.ScanFile.curent_line+":"+" Result UNPREDICTABLE.");
                   frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                            	else{
                            		System.out.println("WARNING in line "+backend.ScanFile.curent_line+":"+" Result UNPREDICTABLE.");
                            	}
                            }
                   if(no2==15)
                   {
                	   if(handlers.cmd_var==1){
                	      	  System.out.println("WARNING in line "+backend.ScanFile.curent_line+":"+" Result UNPREDICTABLE.");
                	        }
                	        else{
                	     
                       frontend.FrontEnd.statuswindow.append("WARNING in line "+backend.ScanFile.curent_line+":"+" Result UNPREDICTABLE.");
                       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                       if(val1!=null)
                        try {
                                backend.ScanFile.br.seek(val1);
                                } catch (IOException ex) {
               
                                	if(handlers.cmd_var==1){
                                    	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": Operation failed.");
                                      }
                                      else{
                                   
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": Operation failed.");
      frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                                	frontend.FrontEnd.exceptionraised++;          return;    
               
            }
                   }
                   
               }
               else if(no2==-2)
               {
            	   if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
            	        }
            	        else{
            	     
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
            	   frontend.FrontEnd.exceptionraised++;          return; }
 /* try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
   */

           }

}
