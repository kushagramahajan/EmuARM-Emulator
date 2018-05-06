/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.instructions;

import frontend.FrontEnd;
import frontend.handlers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author win-7
 */
public class STM implements InsInterface3{
   static int[] binaryconvert=null;
final static int fa=0;
final static int fd=1;
final static int ea=2;
final static int ed=3;
static int mode;
    private int update_flag=0;
    @Override
    public void execute(String ins, String token2, String token3) {
          binaryconvert=new int[32];
       backend.InstructionSet.STM token1=backend.InstructionSet.STM.valueOf(ins);
               switch(token1)
               {
                   case STMFD:
                       mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                     
                        execSTM(token2,token3);
                        break;
                   case STMEQFD:
                        mode=fd;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMNEFD:
                        mode=fd;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMHSFD:
                       mode=fd;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLOFD:
                         mode=fd;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMMIFD:
                         mode=fd;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMPLFD:
                         mode=fd;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                     
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMVSFD:
                        mode=fd;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                   
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMVCFD:
                         mode=fd;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMHIFD:
                         mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLSFD:
                         mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMGEFD:
                         mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLTFD:
                        mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMGTFD:
                         mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                  
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLEFD:
                         mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMALFD:
                        mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                       
                  case STMFA:
                       mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                     
                        execSTM(token2,token3);
                        break;
                   case STMEQFA:
                      mode=fa;
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMNEFA:
                       mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMHSFA:
                        mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLOFA:
                        mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMMIFA:
                        mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMPLFA:
                        mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                     
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMVSFA:
                       mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                   
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMVCFA:
                        mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMHIFA:
                        mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLSFA:
                       mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMGEFA:
                        mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLTFA:
                       mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMGTFA:
                       mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                  
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLEFA:
                       mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMALFA:
                        mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                       case STMEA:
                        mode=ea;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                     
                        execSTM(token2,token3);
                        break;
                   case STMEQEA:
                        mode=ea;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMNEEA:
                        mode=ea;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMHSEA:
                        mode=ea;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLOEA:
                        mode=ea;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMMIEA:
                        mode=ea;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMPLEA:
                        mode=ea;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                     
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMVSEA:
                        mode=ea;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                   
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMVCEA:
                        mode=ea;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMHIEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLSEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMGEEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLTEA:
                       mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMGTEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                  
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLEEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMALEA:
                       mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                       case STMED:
                        mode=ed;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                     
                        execSTM(token2,token3);
                        break;
                   case STMEQED:
                        mode=ed;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMNEED:
                       mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMHSED:
                       mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLOED:
                       mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMMIED:
                        mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMPLED:
                        mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                     
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMVSED:
                        mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                   
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMVCED:
                       mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMHIED:
                        mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLSED:
                       mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMGEED:
                       mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLTED:
                       mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMGTED:
                       mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                  
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMLEED:
                        mode=ed;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
                   case STMALED:
                       mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execSTM(token2,token3);
                       }
                       break;
               }
    }

    private void execSTM(String token2, String token3) {
        
        int base=0;
        if(token2.endsWith("!"))
        {
          token2=token2.substring(0, token2.length()-1); 
          update_flag=1;
           base=backend.Register.convertRegister(token2);
        }
        else
        {
             base=backend.Register.convertRegister(token2);
             update_flag=0;
        }
        if(base>-1)
        {
             int address=backend.Register.r[base].b;
            if(token3.startsWith("{") && token3.endsWith("}"))
            {
                token3=token3.substring(1, token3.length()-1);
                StringTokenizer st=new StringTokenizer(token3,",");
                ArrayList registers=new ArrayList();
                int ct=st.countTokens();
                switch(mode)
            {
                case  fa:
                    address=address+4;
                    break;
                case fd: 
                    address=address-(ct*4);
                    break;
                case ea: 
                    
                    break;
                case ed:
                    address=address+4-(ct*4);
                    
                    break;
            }
                for(int i=0;i<ct;i++)
                {
                    int tmp=backend.Register.convertRegister(st.nextToken().trim());
                    registers.add(tmp);
                    if(FrontEnd.build_flag==0)
                    backend.Memory.put(backend.Register.r[tmp].b, address);
                    if(FrontEnd.build_flag==0)
                    if(handlers.cmd_var==0)
                    	handlers.update_memorytable(backend.Memory.display());
                    address+=4;
                }
                 if(update_flag==1)
                {
                    if(mode==fa||mode==ea)
                    	if(FrontEnd.build_flag==0)
                        backend.Register.r[base].b=backend.Register.r[base].b+ct*4;
                    else if(mode==fd||mode==ed)
                    	if(FrontEnd.build_flag==0)
                        backend.Register.r[base].b-=ct*4;
                }
               
                
            }
            else
            {
            	if(handlers.cmd_var==1){
                	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                  }
                  else{
               
             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  }
            	frontend.FrontEnd.exceptionraised++;       
             return; 
            }
        }
        else if(base ==-2)
        {
        	if(handlers.cmd_var==1){
            	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token2+" is not a valid operand.");
              }
              else{
           
             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token2+" is not a valid operand.");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
        	frontend.FrontEnd.exceptionraised++;       
             return;
        }
       /*   try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }
     
    
}
