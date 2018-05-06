/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import frontend.FrontEnd;
import frontend.handlers;
import frontend.registerPane;

/**
 *
 * @author geetika
 */
public class Register {
    public static Register_spec[] r;
    public Register()
    {
        r=new Register_spec[16];
        for(int i=0;i<16;i++)
            r[i]=new Register_spec();
         
    }
public static void resetRegisters()
{	//r=new Register_spec[16];
     for(int i=0;i<16;i++){
 //   	 r[i]=new Register_spec();
    	 r[i].b=0; 
//    	 System.out.println(r[i].b);
//    	 System.out.println("abcd");
    	 }
     
    // backend.Condition x=new backend.Condition();
//     backend.Condition.cpsr.Z=0;
//     backend.Condition.cpsr.C=0;
//     backend.Condition.cpsr.V=0;
       r[14].b=backend.ScanFile.endOfProgram;
}
    public static int convertRegister(String reg)
    {
        if(reg.startsWith("R") || reg.startsWith("r"))
        {
            int no = 0;
            String num=reg.substring(1);
               try {
                   no = Integer.valueOf(num);
               } catch (NumberFormatException numberFormatException) {
                   if(handlers.cmd_var==1){
                	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+reg+" is not a valid operand.");
                   }
                   else{
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+reg+" is not a valid operand.");
                   frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}  frontend.FrontEnd.exceptionraised++;         
                 //  System.out.println("correct value");  
                   return -1;
               }
               if(((no<0||no>15) && ScanFile.a_mode==0) || (ScanFile.a_mode==1 && ((no>=8 && no<=12)||(no<0 && no>15))))
               {
            	   if(handlers.cmd_var==1){
                	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+reg+" is not a valid operand.");
                   }
                   else{
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+reg+" is not a valid operand.");
                  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
            	   frontend.FrontEnd.exceptionraised++;     
                  
               }
            return no;
        }
        else if(reg.equals("SL"))
        {
            return 10;
        }
        else if(reg.equals("SB"))
        {
            return 9;
        }
        else if(reg.equals("SP"))
        {
            return 13;
        }
        else if(reg.equals("IP"))
        {
            return 12;
        }
        else if(reg.equals("PC"))
        {
            return 15;
        }
        else if(reg.equals("LR"))
        {
            return 14;
        }
        else if(reg.equalsIgnoreCase("FP"))
        {
            return 11;
        }
        else if(reg.startsWith("#"))
        {
            return -2;
        }
        else
        {
        	//System.out.println("correct value_2");
        	   if(handlers.cmd_var==1){
            	   System.out.println("\nERROR in line "+backend.ScanFile.curent_line+": Unrecognized operand "+reg);
               }
               else{
        	frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": Unrecognized operand "+reg);
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
        	   frontend.FrontEnd.exceptionraised++;
            return -1;
        }	
        
      
    }
}

