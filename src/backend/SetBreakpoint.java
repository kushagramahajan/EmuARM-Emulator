/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win-7
 */
public class SetBreakpoint {
    public List breakpoints;
    
    public SetBreakpoint()
    {
        breakpoints=new ArrayList();
    }
    
    
    public void Set_Breakpoint(List bkpt)
    {
        
        for(int i=0;i<bkpt.size();i++){
            String tmp=(String)bkpt.get(i);
            breakpoints.add(tmp.trim().toUpperCase());
        }
        
        //for(int i=0;i<breakpoints.size();i++)
            //System.out.println(breakpoints.get(i));
    }
    
    public boolean checkbreakpt(String line)
    {
        
        if(breakpoints.contains(line))
            return true;
        
        return false;
    }

}
