package backend.instructions;

import frontend.FrontEnd;

public class NEG implements InsInterface3{
	static int[] binaryconvert16=null;
    static int no,no2,no3,chck;
    static int operand_2;
    
    @Override
    public void execute(String ins, String token2, String token3) {
    	binaryconvert16=new int[16];
    	binaryconvert16[15]=0;
    	binaryconvert16[15]=1;
    	binaryconvert16[15]=0;
    	binaryconvert16[15]=0;
    	binaryconvert16[15]=0;
    	binaryconvert16[15]=0;
    	binaryconvert16[15]=1;
    	binaryconvert16[15]=0;
    	binaryconvert16[15]=0;
    	binaryconvert16[15]=1;
    	  backend.InstructionSetThumb.NEG token1=backend.InstructionSetThumb.NEG.valueOf(ins);
          switch(token1)
                 {
          
          case NEG:
        	  execNEG(token2,token3);
        	  if(FrontEnd.build_flag==0)
              if(chck==1)
                backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
              else
                backend.Condition.updateFlags(no,token1.name(),no,(int) operand_2,chck);
           break;
          case NEGS:
        	  execNEG(token2,token3);
        	  if(FrontEnd.build_flag==0)
              if(chck==1)
                backend.Condition.updateFlags(no,token1.name(),no,no3,chck);
              else
                backend.Condition.updateFlags(no,token1.name(),no,(int) operand_2,chck);
           break;

                 }
    }
    
    public static void execNEG(String token2,String token3){
    	no=backend.Register.convertRegister(token2);
        if(no>-1)
        {
        	if(FrontEnd.build_flag==0)
            backend.convertToBinary.encodeRegister(no,binaryconvert16,2,1,0);
                int operand_1 = backend.Register.r[no].value();
                no3=backend.Register.convertRegister(token3);
                
                if(no3>-1)
                {	
                	chck=1;
                	int operand_2=0;
                try {
                        operand_2 = backend.Register.r[no3].value();
                        if(FrontEnd.build_flag==0)
                        backend.convertToBinary.encodeRegister(no3,binaryconvert16,5,4,3);
            
                        //System.out.println("no3:" + no3 + "op2 :" + operand_2 + "op1:" + operand_1);
                        operand_1 = -operand_2;
                        if(FrontEnd.build_flag==0)
                        backend.Register.r[no].storeValue(operand_1);
                    } catch (Exception e) {
                        frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"NEG operation failed");         
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());     frontend.FrontEnd.exceptionraised++;        return;
                    }
                    

                }
                else
                {
                                frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+token3+" is not a valid operand.");
                            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());    frontend.FrontEnd.exceptionraised++;   
                                return;   }
            }
            
        else if(no==-2) 
         {
        	
             frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+": invalid operand.");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());       frontend.FrontEnd.exceptionraised++;    return; 
         }

    }
}
