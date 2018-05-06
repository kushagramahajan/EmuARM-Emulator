/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.instructions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import frontend.FrontEnd;
import frontend.handlers;

/**
 *
 * @author win-7
 */
public class LDM implements InsInterface3 {
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
       backend.InstructionSet.LDM token1=backend.InstructionSet.LDM.valueOf(ins);
               switch(token1)
               {
                   case LDMFD:
                        mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                     
                        execldm(token2,token3);
                        break;
                   case LDMEQFD:
                      mode=fd;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMNEFD:
                      mode=fd;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMHSFD:
                       mode=fd;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLOFD:
                       mode=fd;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMMIFD:
                     mode=fd;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMPLFD:
                       mode=fd;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                     
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMVSFD:
                       mode=fd;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                   
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMVCFD:
                      mode=fd;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMHIFD:
                       mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLSFD:
                       mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMGEFD:
                       mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLTFD:
                      mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMGTFD:
                      mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                  
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLEFD:
                       mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMALFD:
                      mode=fd;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                       
                  case LDMFA:
                     mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                     
                        execldm(token2,token3);
                        break;
                   case LDMEQFA:
                       mode=fa;
                      binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMNEFA:
                       mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMHSFA:
                       mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLOFA:
                         mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMMIFA:
                         mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMPLFA:
                         mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                     
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMVSFA:
                        mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                   
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMVCFA:
                        mode=fa;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMHIFA:
                        mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLSFA:
                        mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMGEFA:
                        mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLTFA:
                         mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMGTFA:
                         mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                  
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLEFA:
                         mode=fa;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMALFA:
                         mode=fa;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                       case LDMEA:
                      mode=ea;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                     
                        execldm(token2,token3);
                        break;
                   case LDMEQEA:
                        mode=ea;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMNEEA:
                       mode=ea;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMHSEA:
                      mode=ea;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLOEA:
                        mode=ea;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMMIEA:
                        mode=ea;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMPLEA:
                        mode=ea;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                     
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMVSEA:
                        mode=ea;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                   
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMVCEA:
                       mode=ea;
                        binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMHIEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLSEA:
                      mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMGEEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLTEA:
                       mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMGTEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                  
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLEEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMALEA:
                        mode=ea;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                       case LDMED:
                         mode=ed;
                        binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                     
                        execldm(token2,token3);
                        break;
                   case LDMEQED:
                         mode=ed;
                        binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMNEED:
                       mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMHSED:
                        mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                       
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLOED:
                        mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMMIED:
                        mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMPLED:
                        mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                     
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMVSED:
                        mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                   
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMVCED:
                        mode=ed;
                       binaryconvert[31]=0;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                     
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMHIED:
                        mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                      
                        
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLSED:
                        mode=ed;
                        binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMGEED:
                        mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLTED:
                        mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=0;
                        binaryconvert[29]=1;
                        binaryconvert[28]=1;
                      
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMGTED:
                        mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=0;
                  
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMLEED:
                        mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=0;
                        binaryconvert[28]=1;
                    
                        if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
                   case LDMALED:
                       mode=ed;
                       binaryconvert[31]=1;
                        binaryconvert[30]=1;
                        binaryconvert[29]=1;
                        binaryconvert[28]=0;
                    
                       if(backend.Condition.checkCondition(token1.ordinal()-1)==1)
                       {
                          execldm(token2,token3);
                       }
                       break;
               }
    }

    private void execldm(String token2, String token3) {
        
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
                    address=address-(ct*4)+4;
                    break;
                case fd: 
                    
                    break;
                case ea: 
                    address=address-(ct*4);
                    break;
                case ed:
                    address=address+4;
                   
                    break;
            }
                for(int i=0;i<ct;i++)
                {
                    int tmp=backend.Register.convertRegister(st.nextToken().trim());
                    registers.add(tmp);
                    Integer val1=backend.Memory.get(address);
                    if(tmp!=15 && FrontEnd.build_flag==0)
                    backend.Register.r[tmp].b=val1;
                    else
               {
                   if(val1!=backend.ScanFile.endOfProgram&&val1!=null){
            try {
                
                backend.ScanFile.br.seek(val1);
                backend.ScanFile.pos=val1.longValue();
                if(FrontEnd.build_flag==0)
                backend.Register.r[tmp].b=val1;
            } catch (IOException ex) {
               
            	if(handlers.cmd_var==1){
                	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"LDM operation failed");
                  }
                  else{
               
                   frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": LDM operation failed.");
      frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }
            	frontend.FrontEnd.exceptionraised++;   ex.printStackTrace(); return;     
               
            }} 
                       }
                        address+=4;
                   
                }
                if(update_flag==1 && FrontEnd.build_flag==0)
                {
                    if(mode==fd || mode==ed)
                        backend.Register.r[base].b+=4*ct;
                    else
                        backend.Register.r[base].b-=4*ct;
                }
                
                
            }
            else
            {
            	if(handlers.cmd_var==1){
                	  System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                  }
                  else{
               
             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
         frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }   frontend.FrontEnd.exceptionraised++;       
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
      /*    try {
    backend.ScanFile.outbin.append("\n");
    for(int i=31;i>=0;i--)
       
            backend.ScanFile.outbin.append((char)(binaryconvert[i]+'0'));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }
    
}
