/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author geetika
 */
public class Memory {
     public static HashMap memory;
     public static Object[][] disp_mem;
     public static Integer n;
     public Memory()
     {
         memory=null;
         memory=new HashMap();
         n=new Integer(0);
         
     }
    public static int get(int address)
    {
        Integer data=new Integer(0);
        data=(Integer)memory.get(address);
        return data;
        
    }

  
    public static void put(int b,int address) {
        
    	memory.put(address, b);
        n=memory.size();
        
    }
    
    public static int display()
    {
        
        
        n=memory.size();
        if(n>0)
        {
        disp_mem=new Object[n][2];
        Set keySet = memory.keySet();
        Object[] keys=keySet.toArray();
        AbstractCollection values = (AbstractCollection) memory.values();
        Object[] val=values.toArray();
        for(int i=0;i<n&&i<512;i++)
        {	
        	//System.out.println(disp_mem[i][0]+" "+keys[i]);
            try{
            	disp_mem[i][0]=keys[i];
            	disp_mem[i][1]=val[i];
            }
            catch(Exception e){}
        }
        }
        return n;
    }

}
