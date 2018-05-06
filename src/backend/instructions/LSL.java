package backend.instructions;

import frontend.FrontEnd;
import frontend.handlers;

public class LSL implements InsInterface4,InsInterface3{
	static int[] binaryconvert16=null;
	   static int no,no2,no3,chck;
	    static int operand_2;
	@Override
    public void execute(String ins, String token2, String token3, String token4){
		binaryconvert16=new int[16];
		binaryconvert16[15]=0;
		binaryconvert16[14]=0;
		binaryconvert16[13]=0;
		binaryconvert16[12]=0;
		binaryconvert16[11]=0;
		
		backend.InstructionSetThumb.LSL token1=backend.InstructionSetThumb.LSL.valueOf(ins);
		
		no=backend.Register.convertRegister(token2);
    	no2=backend.Register.convertRegister(token3);
    	try{
    		int operand_1 = backend.Register.r[no2].value();
    		
    			backend.convertToBinary.encodeRegister(no,binaryconvert16,2,1,0);
    			backend.convertToBinary.encodeRegister(no2,binaryconvert16,5,4,3);
    		
    		operand_2=backend.BarrelShifter.lslShift(operand_1, token4);
    		int x=Integer.parseInt(token4.substring(1));
    			backend.convertToBinary.encodeSecondOperand(x, binaryconvert16, 6, 10);
    		
    		if(FrontEnd.build_flag==0){
    			backend.Register.r[no].storeValue(operand_2);
        	
    			backend.Condition.updateFlags(no);
    		}
    		else
    			backend.Register.r[no].storeValue(0);
    	}
    	
    	catch (Exception e) {
    		if(handlers.cmd_var==1){
        		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"LSL operation failed");
        	}
        	else{
        	
            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"LSL operation failed");         
frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }    frontend.FrontEnd.exceptionraised++;        return;
        }
    	
    	
    	
	}
	public void execute(String ins, String token2, String token3){
		binaryconvert16=new int[16];
		binaryconvert16[15]=0;
		binaryconvert16[14]=1;
		binaryconvert16[13]=0;
		binaryconvert16[12]=0;
		binaryconvert16[11]=0;
		binaryconvert16[10]=0;
		binaryconvert16[9]=0;
		binaryconvert16[8]=0;
		binaryconvert16[7]=1;
		binaryconvert16[6]=0;
	
		backend.InstructionSetThumb.LSL token1=backend.InstructionSetThumb.LSL.valueOf(ins);
		
		no=backend.Register.convertRegister(token2);
		no2=backend.Register.convertRegister(token3);
    	try{
    		int operand_1 = backend.Register.r[no2].value();
    		
    		backend.convertToBinary.encodeRegister(no,binaryconvert16,2,1,0);
    		backend.convertToBinary.encodeRegister(no2,binaryconvert16,5,4,3);
    		
    		operand_2=backend.BarrelShifter.lslShift(operand_1, token3);
    		
    		if(FrontEnd.build_flag==0){
        	backend.Register.r[no].storeValue(operand_2);
        	backend.Condition.updateFlags(no);
        	}
    		else
    			backend.Register.r[no].storeValue(0);
    	}
    	
    	catch (Exception e) {
    		if(handlers.cmd_var==1){
        		System.out.println("\nERROR in line "+backend.ScanFile.curent_line+":"+"LSL operation failed");
        	}
        	else{
        	
            frontend.FrontEnd.statuswindow.append("\nERROR in line "+backend.ScanFile.curent_line+":"+"LSL operation failed");         
frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); }    frontend.FrontEnd.exceptionraised++;        return;
        }
    	
		
	}
	
}
