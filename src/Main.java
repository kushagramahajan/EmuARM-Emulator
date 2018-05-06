
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;

import backend.Condition;
import backend.Emit;
import backend.Memory;
import backend.Register;
import frontend.FrontEnd;
import frontend.handlers;



public class Main {
    
	/**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
       Register registerset=new Register();
       backend.Register.r[14].b=backend.ScanFile.endOfProgram;
        Condition condition = new Condition();
        Memory memory = new Memory();
        Emit e=new Emit();
        e.createHash();
        if(args.length==0){
        	FrontEnd fe = null;
        	handlers.cmd_var=0;
        	fe.main();
        }
        else{
        	handlers.cmd_var=1;
        	frontend.handlers hl=new frontend.handlers();
        	String fileToBeSent=args[0].split("=")[1];
        	fileToBeSent=fileToBeSent.trim();
        	String tables = "";
        	
        	if(args.length==2)
        		tables=args[1].substring(1);
        	//System.out.println(System.getProperty("user.dir")+"/"+fileToBeSent);
        	File file = new File(fileToBeSent);
        	if(file.isAbsolute()){
        		hl.main(fileToBeSent,tables);
        	}
        	else{
        		hl.main(System.getProperty("user.dir")+"/"+fileToBeSent,tables);
        	}
        }
        
    }

}
