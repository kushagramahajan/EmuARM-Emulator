/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import frontend.handlers;

/**
 *
 * @author geetika
 */
public class FirstPass {
    public static Hashtable branchtable=new Hashtable();
    public static Object obj[][];
    public static int scan(File path)
    {
        long ct=0;
        int count = 0;
        obj=new Object[1000][2];
        RandomAccessFile br=null;
       
        try {
            
            int ctl=0;
            File f = path;
            br=new RandomAccessFile(f,"r");
            FileChannel      inChannel = br.getChannel();
            ct=inChannel.position();
            String strLine;
            
            int idx=0;
            while ((strLine = br.readLine()) != null) {
                
                ctl++;
                if(!strLine.contains(":"))
                {
                    // do nothing
                }
                else
                {
                    count++;
                    //line contains a label
                    StringTokenizer st=new StringTokenizer(strLine,":");
                    //other_things   labelname : other_things
                    String label=st.nextToken();
                    label=label.trim();
                    if(label.equalsIgnoreCase("MAIN"))
                    {
                       backend.ScanFile.mainPresent=true; 
                       backend.ScanFile.mainPosition=ct;
                    }
                    else if(label.startsWith(".ident")){continue;}
                    StringTokenizer st2=new StringTokenizer(label," ");
                    int cnt=st2.countTokens();
                    for(int i=0;i<cnt;i++)
                        label=st2.nextToken();
                    if(idx<1000)
                    {
                        obj[idx][0]=(String)label;
                        obj[idx++][1]=Integer.toString(ctl);
                    }
                    
                    branchtable.put(label.toUpperCase(), ct);
                    
                    
                 
                }
                ct=inChannel.position();
            }
            // branchtable.put("PRINTF", new Long(-1));
            // branchtable.put("SCANF", new Long(-2));
            // branchtable.put("__MODSI3",new Long(-3));
            
        } 
        catch (IOException ex) {
        	if(handlers.cmd_var==1){
        		System.out.println("Error occured while accessing source file");
        	}
        	else{
        		frontend.FrontEnd.statuswindow.append("Error occured while accessing source file");
        		frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());    frontend.FrontEnd.exceptionraised++;
        	}
        	
        	} finally {
            try {
                
                br.close();
            } catch (IOException ex) {
            	if(handlers.cmd_var==1){
            		System.out.println("Error occured while accessing source file");
            	}
            	else{
	            	frontend.FrontEnd.statuswindow.append("Error occured while accessing source file");
	            	frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());    frontend.FrontEnd.exceptionraised++;
            	}	
            	}
        }
        return count;
        
    }

 }
