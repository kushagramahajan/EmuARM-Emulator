/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.instructions;

import backend.InstructionSet.shift;
import frontend.FrontEnd;
import frontend.handlers;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author geetika
 */
public class MSR implements InsInterface3{

   static int[] binaryconvert=null;
    static int no2;


    @Override
    public void execute(String ins, String token3, String token4) {
        binaryconvert=new int[32];
        binaryconvert[27]=0;
        binaryconvert[26]=0;
        binaryconvert[24]=1;
        binaryconvert[23]=0;
        binaryconvert[21]=1;
        binaryconvert[20]=0;
        binaryconvert[15]=1;
        binaryconvert[14]=1;
        binaryconvert[13]=1;
        binaryconvert[12]=1;
        
      backend.InstructionSet.MSR token1=backend.InstructionSet.MSR.valueOf(ins);
               switch(token1)
               {
                  case MSR:
                      binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        execMSR(token3,token4);
                        break;
                   case MSREQ:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRNE:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRHS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRLO:
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                       
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRMI:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRPL:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRVS:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRVC:
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRHI:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRLS:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRGE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRLT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRGT:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRLE:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;
                   case MSRAL:
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                        
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execMSR(token3,token4);
                       }
                       break;

               }
          
    }


public static void execMSR(String token3, String token4)
    {

            String num,fields = null;
            int C_flag=0;

               if(token3.startsWith("CPSR"))
               {
                   binaryconvert[22]=0;
                   C_flag=1;
               }
               else if(token3.startsWith("SPSR"))
               {
                   binaryconvert[22]=1;
                   C_flag=0;
               }
               else
               {
            	   if(handlers.cmd_var==1){
            	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
            	        }
            	        else{
            	     
                    frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
          frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}      frontend.FrontEnd.exceptionraised++;return;
               }
                   try {
            fields = token3.substring(5);
        } catch (Exception e) {
        	if(handlers.cmd_var==1){
            	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
              }
              else{
           
            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++;  return;}
                     no2=backend.Register.convertRegister(token4);
                   if(no2>-1)
                   {
                       binaryconvert[25]=0;
                       for(int j=11;j>=4;j--)
                           binaryconvert[j]=0;
                       if(FrontEnd.build_flag==0)
                        backend.convertToBinary.encodeRegister(no2,binaryconvert,3,2,1,0);
              
                       String s=Integer.toBinaryString(backend.Register.r[no2].b);
                        ////System.out.println("binary :"+s);
                       
                       int[] intArray = new int[32];
 
                       for (int i = 0; i < s.length(); i++) {
                            intArray[i] = s.charAt(s.length()-i-1)-'0';
                           }
                        //System.out.println("value :");
                       
                       for(int i=0;i<32;i++)
                            //System.out.print(intArray[i]);
                    if(FrontEnd.build_flag==0)   
                    if(C_flag==1)
                            backend.Condition.cpsr.update(intArray,fields,binaryconvert);
                       else
                            backend.Condition.spsr.update(intArray,fields,binaryconvert);
                       
                           }
                   else if(token4.startsWith("#"))
                   {
                       binaryconvert[25]=1;
                       /*
                        * this immediate value should be a 12bit value
                        * in decimal
                        * 
                        * 1) convert decimal to binary
                        * 2) bit 8-11 for the rotate immd
                        * 3) bit 0-7 for the immediate data
                        * 4) convert back to decimal numbers 
                        * 5) send to barrel shifter
                        * 6) store the result back
                        * 7) convert back to binary
                        * 8) update cpsr flags
                        */
                       //#<immed_8>(7-0), <rotate_amount> (11-8)
                       int operand_2=Integer.parseInt(token4.substring(1)); // immediate operand
                       
                        String bin=Integer.toBinaryString((int)operand_2);  // step 1: converted to binary
                        
                        if(bin.length()>12)
                            bin=bin.substring(bin.length()-13, bin.length()-1); // 12bit field only
                        else if(bin.length()<12) 
                        {
                            int l=bin.length();
                            for(int i=l;i<12;i++)
                                bin="0".concat(bin);
                            
                        }
                        for(int j=0;j<12;j++)
                            binaryconvert[j]=bin.charAt(11-j)-'0';
                        //System.out.print(" -->"+bin);
                        String rot_immd=bin.substring(0,4); // upper 4bits for rotate amnt
                        rot_immd = new StringBuffer(rot_immd).reverse().toString();
                        int rot_im=0;
                        for(int i=0;i<4;i++)
                        {
                            if(rot_immd.charAt(i)=='1')
                                rot_im+=Math.pow(2, i);
                        }
                        rot_immd="#".concat(String.valueOf(rot_im));
                        
                        String immmd=bin.substring(4);
                        immmd = new StringBuffer(immmd).reverse().toString();
                        int immed_data=0;
                        for(int i=0;i<immmd.length();i++)
                        {
                            if(immmd.charAt(i)=='1')
                                immed_data+=Math.pow(2, i);
                        }
                        //System.out.print("rotate "+immed_data+" : "+rot_immd+":)");
                        immed_data=backend.BarrelShifter.shift(rot_immd,immed_data, shift.ROR); // step 5: send to barrel shiftr
                        String ans=Integer.toBinaryString(immed_data);      //step 7: convert back to binary
                        if(ans.length()<32)
                        {
                            int l=ans.length();
                            for(int i=l;i<32;i++)
                                ans="0".concat(ans);
                        }
                        int[] op2=new int[32];
                        for(int i=0;i<32;i++)
                        {
                            if(ans.charAt(i)=='1')
                                op2[31-i]=1;
                        }
                        
                        if(FrontEnd.build_flag==0)
                        if(C_flag==1)
                            backend.Condition.cpsr.update(op2,fields,binaryconvert);
                        else
                            backend.Condition.spsr.update(op2,fields,binaryconvert);
                            
                   }
                   else 
                   {
                	   if(handlers.cmd_var==1){
                	      	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
                	        }
                	        else{
                	     
                       frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token4+" is not a valid operand.");
             frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }  frontend.FrontEnd.exceptionraised++;return;    }
                 /*    try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
   
                   
               }
}


           



