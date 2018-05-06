package backend;

/**
 *
 * @author geetika
 */
public class BarrelShifter {
    public static int shift(int data)
    {
        data=rrxShift(data);
        return data;
    }
    public static int typeofshift;
    public static int shift(String imm, int data, backend.InstructionSet.shift s)
    {
       imm.trim();
        switch(s)
        {
            case LSL:
                data=lslShift(data,imm);
                
                break;
            case LSR:
                data=lsrShift(data,imm);
                break;
            case ROR:
                data=rorShift(data,imm);
                break;
            case RRX:
                data=rrxShift(data);
                break;
            case ASR:
                data=asrShift(data,imm);
                break;
            default:frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Unknown Shift Operation\n");
                   frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
        }

        return data;

    }

   public static int lslShift(Integer data,String sft )
    {
        
        int shiftr_operand=0;
        int shiftr_carry_out = 0;
        int shift = 0;
        if(sft.startsWith("#"))
        {
            typeofshift=0;
            try {
                shift = Integer.parseInt(sft.substring(1));
            } catch (NumberFormatException numberFormatException) {
                  frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Invalid "+sft);
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  frontend.FrontEnd.exceptionraised++;
      
      }
            ScanFile.reg1orimm0=0;
            ScanFile.regnoOrImmOp=shift;
   }
        else if(sft.startsWith("R"))
        {
            typeofshift=1;
            int no3 = 0;
            try {
                no3 = Integer.valueOf(sft.substring(1));
            } catch (NumberFormatException numberFormatException) {
                frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Invalid "+sft);
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
        }
            ScanFile.reg1orimm0=1;
            ScanFile.regnoOrImmOp=no3;
     shift= backend.Register.r[no3].firstByteValue();
        }
        else
        {
            frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Invalid "+sft);
   frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());   frontend.FrontEnd.exceptionraised++;
        }
        	if(shift==0)
            {
                shiftr_operand=data;
                shiftr_carry_out=backend.Condition.cpsr.C;
            }
            else if(shift<=31)
            {
                try {
                    shiftr_carry_out = Integer.toBinaryString(data).toCharArray()[32 - shift]-'0';
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    String str=Integer.toBinaryString(data);
                    //System.out.println(str);
                    int len=str.length();
                    for(int i=len;i<32;i++)
                        str="0".concat(str);
                        
                        shiftr_carry_out = str.toCharArray()[32 - shift]-'0';
                        //System.out.println(":"+shiftr_carry_out);
                }catch (Exception e) {
                    frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Invalid Shift Operation\n");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  frontend.FrontEnd.exceptionraised++;
                }
                shiftr_operand=data<<shift;
                //System.out.println(data);
                //System.out.println(shiftr_operand);
                

            }
            else
            {
                shiftr_operand=0;
                if(shift==32)
                    shiftr_carry_out=(data<<31)>>>31;
                else
                    shiftr_carry_out=0;


            }
        backend.Condition.cpsr.C=shiftr_carry_out;
        return shiftr_operand;

    }
public static int rorShift(Integer data,String sft )
    {
        int shiftr_operand=0;
        int shiftr_carry_out = 0;
        int shift = 0;
        if(sft.startsWith("#"))
        {
            typeofshift=6;
            try {
                shift = Integer.parseInt(sft.substring(1));
            } catch (NumberFormatException numberFormatException) {
            }
         ScanFile.reg1orimm0=0;
            ScanFile.regnoOrImmOp=shift;
   
            
            if(shift == 0)
            {
                //See “Data-processing operands - Rotate right with extend” on page A5-17
                rrxShift(data);
            }
            else /* shift_imm > 0 */
            {
                shiftr_operand = Integer.rotateRight(data, shift);
                try {
                    shiftr_carry_out = Integer.toBinaryString(data).toCharArray()[shift - 1]-'0';
                } catch (ArrayIndexOutOfBoundsException e) {
                     String str=Integer.toBinaryString(data);
                    
                    int len=str.length();
                    for(int i=len;i<32;i++)
                        str="0".concat(str);
                        
                        shiftr_carry_out = str.toCharArray()[shift-1]-'0';
                }
            }
        }
        else if(sft.startsWith("R"))
        {
            typeofshift=7;
            int  no3=Integer.valueOf(sft.substring(1));
            
            ScanFile.reg1orimm0=1;
            ScanFile.regnoOrImmOp=no3;
            shift= backend.Register.r[no3].firstByteValue();
            int shift2=backend.Register.r[no3].first5bitValue();
            if(shift == 0)
            {
                shiftr_operand = data;
                shiftr_carry_out = backend.Condition.cpsr.C;
            }
            else if(shift2  == 0)
            {
                shiftr_operand = data;
                shiftr_carry_out = data>>>31;
            }
            else /* Rs[4:0] > 0 */
            {
                shiftr_operand = Integer.rotateRight(data,shift2);
                try {
                    shiftr_carry_out = Integer.toBinaryString(data).toCharArray()[shift2 - 1]-'0';
                } catch (ArrayIndexOutOfBoundsException e) {
                     String str=Integer.toBinaryString(data);
                    
                    int len=str.length();
                    for(int i=len;i<32;i++)
                        str="0".concat(str);
                        
                        shiftr_carry_out = str.toCharArray()[shift2-1]-'0';
                }catch (Exception e) {
                    frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Invalid Shift Operation\n");
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
                }
            }
        }
        else
        {
            frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Invalid "+sft+"\n");
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
        }

        backend.Condition.cpsr.C=shiftr_carry_out;
        return shiftr_operand;

    }

     public static int lsrShift(Integer data,String sft )
    {
        int shiftr_operand=0;
        int shiftr_carry_out = 0;
        int shift = 0;
        if(sft.startsWith("#"))
        {
            typeofshift=2;
            try {
                shift = Integer.parseInt(sft.substring(1));
            } catch (NumberFormatException numberFormatException) {
            }
      ScanFile.reg1orimm0=0;
            ScanFile.regnoOrImmOp=shift;
   
             if(shift==0)
            {

            
                shiftr_operand=0;
                shiftr_carry_out=data>>>31;
            }
            else
            {
                shiftr_operand=data>>>shift;
                try {
                    shiftr_carry_out = Integer.toBinaryString(data).toCharArray()[shift - 1]-'0';
                } catch (ArrayIndexOutOfBoundsException e) {
                     String str=Integer.toBinaryString(data);
                    
                    int len=str.length();
                    for(int i=len;i<32;i++)
                        str="0".concat(str);
                        
                        shiftr_carry_out = str.toCharArray()[shift-1]-'0';
                }catch (Exception e) {
                    frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Unknown Shift Operation\n");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  frontend.FrontEnd.exceptionraised++;
                }

            }
        }
        else if(sft.startsWith("R"))
        {
            typeofshift=3;
            int  no3=Integer.valueOf(sft.substring(1));
            
            ScanFile.reg1orimm0=1;
            ScanFile.regnoOrImmOp=no3;
            shift= backend.Register.r[no3].firstByteValue();
             if(shift==0)
            {
                shiftr_operand=data;
                shiftr_carry_out=backend.Condition.cpsr.C;
            }
            else if(shift<32)
            {
                shiftr_operand=data>>>shift;
                try {
                    shiftr_carry_out = Integer.toBinaryString(data).toCharArray()[shift - 1] - '0';
                } catch (ArrayIndexOutOfBoundsException e) {
                     String str=Integer.toBinaryString(data);
                    
                    int len=str.length();
                    for(int i=len;i<32;i++)
                        str="0".concat(str);
                        
                        shiftr_carry_out = str.toCharArray()[shift-1]-'0';
                }catch (Exception e) {
                }

            }
            else if(shift ==32)
            {
                 
                    shiftr_operand=0;
                shiftr_carry_out=data>>>31;

            }
            else
            {
                
                shiftr_operand=0;
                shiftr_carry_out=0;

            }
        }
        else
        {
            frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Invalid "+sft+"\n");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  frontend.FrontEnd.exceptionraised++;
        }
       
            
        backend.Condition.cpsr.C=shiftr_carry_out;
        return shiftr_operand;

    }

     public static int rrxShift(Integer data)
     {
         typeofshift=8;
         int[] ds=new int[33];
         String s=Integer.toBinaryString(data);
         int[] intArray = {0,0,0,0,0,0,0,0,0,0,
                           0,0,0,0,0,0,0,0,0,0,
                           0,0,0,0,0,0,0,0,0,0,0,0};
 
        for (int i = 0; i < s.length(); i++) {
            intArray[i] = Character.digit(s.charAt(i), 2);
}
         System.arraycopy(intArray, 0, ds, 0, 32);
         ds[32]=backend.Condition.cpsr.C;
         backend.Condition.cpsr.C=ds[0];
         ds=ShiftRight(ds);
         System.arraycopy(ds,0, intArray,0, 32);
         s=String.valueOf(intArray);
         data=Integer.parseInt(s,2);
         
         return data;

     }
 public static int asrShift(int data,String sft )
    {
        int shiftr_operand=0;
        int shiftr_carry_out = 0;
        int shift = 0;
        if(sft.startsWith("#"))
        {
            typeofshift=4;
            shift=Integer.parseInt(sft.substring(1));
      ScanFile.reg1orimm0=0;
            ScanFile.regnoOrImmOp=shift;
   
            if(shift == 0)
            {
                if(data>>>31 == 0)
                {
                    
                    shiftr_operand=0;
                    shiftr_carry_out = data>>>31;
                }
                else /* data[31] == 1 */
                {
                    shiftr_operand=1;
                    shiftr_carry_out = data>>>31;
                }
            }
            else /* shift_imm > 0 */
            {
                    shiftr_operand = data>>shift;
                    try {
                    shiftr_carry_out = Integer.toBinaryString(data).toCharArray()[shift - 1] - '0';
                } catch (ArrayIndexOutOfBoundsException e) {
                     String str=Integer.toBinaryString(data);
                    
                    int len=str.length();
                    for(int i=len;i<32;i++)
                        str="0".concat(str);
                        
                        shiftr_carry_out = str.toCharArray()[shift-1]-'0';
                }catch (Exception e) {
                    frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Unknown Shift Operation\n");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());  frontend.FrontEnd.exceptionraised++;
                }
            }
        }
        else if(sft.startsWith("R"))
        {
            typeofshift=5;
            int  no3=Integer.valueOf(sft.substring(1));
            
            ScanFile.reg1orimm0=1;
            ScanFile.regnoOrImmOp=no3;
            shift= backend.Register.r[no3].firstByteValue();
            if(shift == 0)
            {
                shiftr_operand = data;
                shiftr_carry_out = backend.Condition.cpsr.C;
            }
            else if(shift < 32)
            {
                shiftr_operand = data>>shift;
                try {
                    shiftr_carry_out = Integer.toBinaryString(data).toCharArray()[shift - 1] - '0';
                } catch (ArrayIndexOutOfBoundsException e) {
                     String str=Integer.toBinaryString(data);
                    
                    int len=str.length();
                    for(int i=len;i<32;i++)
                        str="0".concat(str);
                        
                        shiftr_carry_out = str.toCharArray()[shift-1]-'0';
                }catch (Exception e) {
                    frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Unknown Shift Operation\n");
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
                }
            }
            else /* Rs[7:0] >= 32 */
            {
                if (data>>>31 == 0)
                {
                   
                        shiftr_operand=0;
                    shiftr_carry_out = data>>>31;
                }
                else /* Rm[31] == 1 */
                {
                    
                        shiftr_operand=1;
                    shiftr_carry_out = data>>>31;
                }
            }
        }
        else
        {
           frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Invalid Shift Operation\n");
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
        }


        backend.Condition.cpsr.C=shiftr_carry_out;
        return shiftr_operand;

    }

   
   

    private static int[] ShiftRight(int[] data) {

               int t=data[0];
                for(int i=0;i<=31;i++)
                {
                    data[i]=data[i+1];

                }
                
        return data;
    }

    


}
