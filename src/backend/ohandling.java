/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author Dr Rakesh Malhotra
 */
public class ohandling {
       public static void printhandle(String strline)
    {
        strline=strline.trim();
        
        if (strline.startsWith(".print") || strline.startsWith(".PRINT")) {
            strline = strline.substring(6, strline.length());
            if(!strline.startsWith(" ")){
            	if(handlers.cmd_var==0)
            		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line + ": Wrong Syntax\n");
            	else{
            		System.out.println("ERROR in line " + ScanFile.curent_line + ": Wrong Syntax\n");
            	}
            	frontend.FrontEnd.exceptionraised++;
                return;
            }
            strline = strline.trim();
        }
        else {
        	
        	if(handlers.cmd_var==0)
        		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown commandscan \n");
        	else{
        		System.out.println("ERROR in line " + ScanFile.curent_line + ": Unknown commandscan\n");
        	}
        	frontend.FrontEnd.exceptionraised++;
            return;

        }

        
        int n=ihandling.replacewidnumbr(strline);
        
        if(n==-1){
        	if(handlers.cmd_var==0)
        		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line + ": Wrong Syntax\n");
        	else{
        		System.out.println("ERROR in line " + ScanFile.curent_line + ": Wrong Syntax\n");
        	}
        	frontend.FrontEnd.exceptionraised++;
            return;
		}
        
        if(ScanFile.a_mode==1)
    		if(n>=8 && n<=12){
    			if(handlers.cmd_var==0)
    				frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line + ": Invalid Register Value \n");
    			else{
            		System.out.println("ERROR in line " + ScanFile.curent_line + ": Invalid Register Value\n");
            	}
    			
    			frontend.FrontEnd.exceptionraised++;
                return;		
    		
    		}
        if(ScanFile.a_mode==0)
    		if(n>=16){
    			
    			if(handlers.cmd_var==0)
    				frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line + ": Invalid Register Value \n");
    			else{
            		System.out.println("ERROR in line " + ScanFile.curent_line + ": Invalid Register Value\n");
            	}
    			frontend.FrontEnd.exceptionraised++;
                return;		
    		
    		}
    
    		if(n==-1){
    			if(handlers.cmd_var==0)
    				frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line + ": Wrong Syntax \n");
    			else{
            		System.out.println("ERROR in line " + ScanFile.curent_line + ": Wrong Syntax\n");
            	}
    			 frontend.FrontEnd.exceptionraised++;
                 return;
    		}
    		if(FrontEnd.bflag==0){
    		String x=replacewithValue(strline);
    		
    		if(handlers.cmd_var==0)
    			frontend.FrontEnd.statuswindow.append("Value of "+strline+" is: "+x+"\n");
    		else{
    			System.out.println("Value of "+strline+" is: " + x + "\n");
    		}
    		
    		}
//                if(!strline.contains("%d"))
//                {
//                    if(strline.startsWith("\"") && strline.endsWith("\\000\""))
//                    {
//                        strline=strline.substring(1, strline.length()-5);
//                        frontend.FrontEnd.statuswindow.append(strline);frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
//                try {
//                    backend.ScanFile.br.seek(backend.instructions.BL.linkregister);
//                    backend.Register.r[15].b=backend.instructions.BL.linkregister.intValue();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//                
//                
//                    }
//                    else
//                    {
//                 //error       
//                    }
//                    
//                }
//               
//                else
//                {
//                 
//                  
//                    if(strline.startsWith("\"") && strline.endsWith("\\000\""))
//                    {
//                         strline=strline.substring(1, strline.length()-5);
//     
//                       int i=1;
//                        while(strline.contains("%d"))
//                        {
//                      
//                            
//                            
//                            strline=strline.replaceFirst("%d",backend.Register.r[i].b.toString());
//                            //System.out.println(strline);
//                            i++;
//                        }
//                        frontend.FrontEnd.statuswindow.append(strline);frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
//              
//                    }
//                    else
//                    {
//                        //error
//                    }
//                }
            
       
    }
    
    private static String replacewithValue(String string) {
        string=string.trim();
        if(string.startsWith("R") || string.startsWith("r"))
        {
            
            string=string.substring(1);
       
            string=String.valueOf(backend.Register.r[Integer.valueOf(string)].b);
        }
                                   
        return string;
    }

}
