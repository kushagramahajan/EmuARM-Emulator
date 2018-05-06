/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import frontend.FrontEnd;
import frontend.handlers;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Dr Rakesh Malhotra
 */
public class ihandling implements Runnable {

    static String inpstrng;
    int countval;
    String[] istring;
//    static int value[];
    private static int flag;
    private static int value;
    int countpercentd;
    // static boolean done;
    String strline;
    Thread t;

    public ihandling(String strline) {
        this.strline = strline;
        //=false;
        
        try{
        t = new Thread(this, strline);
        t.start();
        }
        catch(Exception e){
        	
        }

    }

    public synchronized void scanhandle() {
        strline = strline.trim();
        if (strline.startsWith(".read") || strline.startsWith(".READ")) {
            strline = strline.substring(5, strline.length());
            strline = strline.trim();
            
            int n=replacewidnumbr(strline);
            if(ScanFile.a_mode==1)
        		if(n>=8){
        			if(handlers.cmd_var==0)
        				frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line + ": Invalid Register Value \n");
        			else{
        				System.out.println("ERROR in line " + ScanFile.curent_line + ": Invalid Register Value \n");
        			}
        			frontend.FrontEnd.exceptionraised++;
                    return;		
        		
        		}
            if(ScanFile.a_mode==0)
        		if(n>=16){
        			if(handlers.cmd_var==0)
        				frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Invalid Register Value \n");
        			else{
        				System.out.println("ERROR in line " + ScanFile.curent_line + ": Invalid Register Value \n");
        			}
        			
        			frontend.FrontEnd.exceptionraised++;
                    return;		
        		
        		}
        
        		if(n==-1){
        			if(handlers.cmd_var==0)
        				frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line + ": Wrong Syntax\n");
        			else{
        				System.out.println("ERROR in line " + ScanFile.curent_line + ": Wrong Syntax \n");
        			}
        			 
        			
        			frontend.FrontEnd.exceptionraised++;
                     return;
        		}
        		 if (flag == 0) {
                   }

                   if (flag == 1) {
                	   try{
                		   if(istring[0].startsWith("0x") || istring[0].startsWith("0X")){
                			   value=Integer.parseInt(istring[0].substring(2),16);
                			   
                		   }
                		   else
                		      value = Integer.parseInt(istring[0]);
                		      
                       }
                	   catch(Exception e){
                		   if(handlers.cmd_var==0)
                			   frontend.FrontEnd.statuswindow.append("Invalid Input\n");
                		   else{
               					System.out.println("Invalid Input\n");
               				}
               			
                		   frontend.FrontEnd.exceptionraised++;
                           return;

                	   }
                       backend.Register.r[n].b = value;
                       flag = 0;
                       (new handlers()).update(0);
                       //System.out.print("Register value set");
                   }

            
            
//            if (strline.startsWith("(") && strline.endsWith(")")) {
//                strline = strline.substring(1, strline.length() - 1);
//                StringTokenizer pt = new StringTokenizer(strline, ",");
//                int counttkn = pt.countTokens();
//                String op[] = new String[counttkn];
//                for (int i = 0; i < counttkn; i++) {
//                    op[i] = pt.nextToken();
//                }
//
//                if (counttkn == 1) {
//                    frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line + ": Wrong Syntax\n");
//                    frontend.FrontEnd.exceptionraised++;
//                    return;
//
//
//                } else {
//                    countpercentd = 0;
//                    boolean done = false;
//                    int j = 0;
//                    while (done != true) {
//                        if (op[j].contains("%d")) {
//                            op[j] = op[j].replaceFirst("%d", "");
//                            j++;
//                            countpercentd++;
//                        }
//                        else if(op[j].contains("%x")){
//                        	op[j] = op[j].replaceFirst("%x", "");
//                            j++;
//                            countpercentd++;
//                        }
//                        	else {
//                            done = true;
//                        }
//                    }
//                    //System.out.println("COUNTPERCENTD" + countpercentd);
//                    if (countpercentd < counttkn) {
//                        for (int i = 0; i < countpercentd; i++) {
//                            //System.out.println("ITERATION" + i);
//                            int no = replacewidnumbr(op[i+countpercentd]);
//                            	if(ScanFile.a_mode==1){
//                            		if(no>=8){
//
//                                    	frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line + ": Invalid Register Value \n");
//                                        frontend.FrontEnd.exceptionraised++;
//                                        return;		
//                            		}
//                            		
//                            	}
//                	
//                            
//
//                            if (flag == 0) {
//                            }
//
//                            if (flag == 1) {
//                                value = Integer.parseInt(istring[i]);
//                                backend.Register.r[no].b = value;
//                                if (i==countpercentd-1)
//                                flag = 0;
//                                (new handlers()).update(0);
//                                //System.out.print("Register value set");
//                            }
//
//                            // 
//                        }
//                    } else {
//                    }
//
//                }
//            }
        } else {
        	if(handlers.cmd_var==0)
        		frontend.FrontEnd.statuswindow.append("ERROR in line " + ScanFile.curent_line +": Unknown commandscan \n");
        	else{
				System.out.println("ERROR in line " + ScanFile.curent_line + ": Unknown commandscan \n");
			}
			
        	frontend.FrontEnd.exceptionraised++;
            return;

        }

    }
    

    public static int main() {
        // printhandle("printf(\" %d hi %d \",67, 89)");
        //System.out.print("hi :");
    	if(FrontEnd.build_flag==0){
	        Scanner s = new Scanner(System.in);
	        String inp=s.nextLine();
	        if(inp.startsWith("0X") || inp.startsWith("0x")){
	        	return(Integer.parseInt(inp.trim().substring(2),16));
	        }
	        else{
	        	return(Integer.parseInt(inp.trim()));
	        }
    	}
    
    	return -1 ;
    }
    

    public static int replacewidnumbr(String string) {
        string = string.trim();
        //string = string.substring(1);
        
        if (string.startsWith("r") || string.startsWith("R")) {
        	 
        	string = string.substring(1);
            int val = Integer.parseInt(string);
            return val;
        }
        return -1;
    }

    public synchronized void setinput(StringBuffer line) {

        inpstrng = String.valueOf(line);
        inpstrng = inpstrng.trim();
        flag = 1;
        //System.err.println("read :" + inpstrng + " & flag =" + flag);
        StringTokenizer st = new StringTokenizer(inpstrng, " ");
        countval = st.countTokens();
        istring = new String[countval];
        for (int i = 0; i < countval; i++) {
            istring[i] = st.nextToken();
        }
        if(handlers.cmd_var==0)
        	frontend.FrontEnd.statuswindow.setEditable(false);
        // this.t.resume();
    }

    @Override
    public void run() {
        flag = 0;
      //  System.err.println("\nhi:)");
        if(handlers.cmd_var==0)
        	frontend.FrontEnd.statuswindow.setEditable(true);

        
            synchronized (this.t) {
                while (flag == 0) {
                    try {
                        t.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

             //   System.err.println("\ntestg:)");


            }
            scanhandle();
            //=true;
        
    }
}
