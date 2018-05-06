/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.StringTokenizer;

/**
 *
 * @author geetika
 */
public class AddressingModes {
    
    int[] binaryconvert;
    
    public Integer evaluateAddress(String addressing_mode,int[] binaryconv)
    {
        this.binaryconvert=binaryconv;
        ////System.out.println("address 1:"+addressing_mode+":)");
        Integer address=new Integer(0);
        addressing_mode=addressing_mode.trim();
        if(!addressing_mode.startsWith("["))
        {
             frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Address should start with [\n");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
        }
        else
        {
             addressing_mode=addressing_mode.substring(1);
             if(addressing_mode.endsWith("]"))
             {
                 StringTokenizer st_case1=new StringTokenizer(addressing_mode,",");
                 int count=st_case1.countTokens();
                 if(count==1)
                 {
                     String tmp=st_case1.nextToken();
                     tmp=tmp.substring(1,2);
                     address=backend.Register.r[Integer.parseInt(tmp)].b; 
                     
                    
                 }
                 else
                    address=calculate(st_case1,1); 
                 
             }
             else if(addressing_mode.endsWith("!"))
             {
                 StringTokenizer st_case2=new StringTokenizer(addressing_mode,",");
                 address=calculate(st_case2,2); 
             }
             else
             {
                StringTokenizer st_case3=new StringTokenizer(addressing_mode,",");
                address=calculate(st_case3,3); 
             }
        }
        
        binaryconv[23]=binaryconvert[23];
        binaryconv[21]=binaryconvert[21];
        binaryconv[24]=binaryconvert[24];
        binaryconv[25]=binaryconvert[25];
        binaryconv[19]=binaryconvert[19];
        binaryconv[18]=binaryconvert[18];
        binaryconv[17]=binaryconvert[17];
        binaryconv[16]=binaryconvert[16];
        for(int i=0;i<=11;i++)
            binaryconv[i]=binaryconvert[i];
        return address;
        
    }
    
    public Integer evaluateAddress(String addressing_mode,int[] binaryconv,int x){
    	this.binaryconvert=binaryconv;
        //System.out.println("address 1:"+addressing_mode+":)");
        Integer address=new Integer(0);
        addressing_mode=addressing_mode.trim();
        if(!addressing_mode.startsWith("["))
        {
             frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Address should start with [\n");
        frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
        }
        else
        {
             addressing_mode=addressing_mode.substring(1);
             if(addressing_mode.endsWith("]"))
             {
                 StringTokenizer st_case1=new StringTokenizer(addressing_mode,",");
                 int count=st_case1.countTokens();
                 if((addressing_mode.contains("R15") || addressing_mode.contains("PC"))&& addressing_mode.contains("#")){
                 
                	 address=calculate(st_case1,1); 
                	 for(int i=0;i<8;i++){
                		 binaryconv[i]=binaryconvert[i];
                	 }
                 }
                 
                 else if(!addressing_mode.contains("#")){
                	 
                //	 StringTokenizer st_case2=new StringTokenizer(addressing_mode,",");
                	 address=calculate(st_case1,1); 
                	 for(int i=3;i<=8;i++){
                		 binaryconv[i]=binaryconvert[i];
                	 }
                     
                 }
                 else if((addressing_mode.contains("R13") || addressing_mode.contains("SP"))&& addressing_mode.contains("#")){
                	// StringTokenizer st_case3=new StringTokenizer(addressing_mode,",");
                	 address=calculate(st_case1,1); 
                     for(int i=0;i<=7;i++){
                    	 binaryconv[i]=binaryconvert[i];
                     }
                 }
                 else{
                	 //StringTokenizer st_case4=new StringTokenizer(addressing_mode,",");
                	 address=calculate(st_case1,1); 
                	 for(int i=3;i<=10;i++){
                		 binaryconv[i]=binaryconvert[i];
                	 }
                     
                 }
             }
//             else if(addressing_mode.endsWith("!"))
//             {
//                 StringTokenizer st_case2=new StringTokenizer(addressing_mode,",");
//                 address=calculate(st_case2,2); 
//             }
//             else
//             {
//                StringTokenizer st_case3=new StringTokenizer(addressing_mode,",");
//                address=calculate(st_case3,3); 
//             }
        }
        
        return address;
        
    }

    private Integer calculateImmdOfst(String base_reg1, String offset_token1,int cs) {
        Integer address=new Integer(0);
        int minus_flag=0;
        switch(cs)
        {
            case 1:
                offset_token1=offset_token1.substring(1,offset_token1.length()-1);
                
                binaryconvert[21]=0;
                binaryconvert[24]=1;
                binaryconvert[25]=0;
                
                break;
            case 2:
                binaryconvert[21]=1;
                binaryconvert[24]=1;
                binaryconvert[25]=0;
                
                offset_token1=offset_token1.substring(1,offset_token1.length()-2);
                break;
            case 3:
                binaryconvert[21]=0;
                binaryconvert[24]=0;
                binaryconvert[25]=0;
                
                offset_token1=offset_token1.substring(1);
                base_reg1=base_reg1.substring(0,base_reg1.length()-1);
                break;
        }
          //System.out.println(base_reg1+","+offset_token1);
        try {
            base_reg1 = base_reg1.trim();
            int regB = backend.Register.convertRegister(base_reg1); // base register
            
            	backend.convertToBinary.encodeRegister(regB,binaryconvert,19,18,17,16);
            
            if(offset_token1.startsWith("+"))
                offset_token1=offset_token1.substring(1);
            else if(offset_token1.startsWith("-"))
            {
                minus_flag=1;
                offset_token1=offset_token1.substring(1);
            }
                         
            int ofset = Integer.parseInt(offset_token1);
            String bin_ofset=Integer.toBinaryString(ofset);
            for(int i=bin_ofset.length();i<12;i++)
                bin_ofset="0".concat(bin_ofset);
            for(int i=0;i<=11;i++)
                binaryconvert[i]=bin_ofset.charAt(11-i);
            if(cs==3)
            {
                address=backend.Register.r[regB].b;
                if(minus_flag==0)
                {
                    binaryconvert[23]=1;
                    
                    backend.Register.r[regB].b=address+ofset;
                }
                else
                {
                    binaryconvert[23]=0;
                    
                    backend.Register.r[regB].b=address-ofset;
                }
            }
            else
            {
                if(minus_flag==0)
                    address=backend.Register.r[regB].b+ofset;
                else
                    address=backend.Register.r[regB].b-ofset;
                
                if(cs==2)
                    backend.Register.r[regB].b=address;
            
                
            }
            } catch (NumberFormatException numberFormatException) {
     frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Number Format Exception\n");
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
            }
        
        
            return address;
    }

    private Integer calculateImmdOfst(String base_reg1, String offset_token1,int cs,int x){
    	Integer address=new Integer(0);
        int minus_flag=0;
        switch(cs)
        {
            case 1:
                offset_token1=offset_token1.substring(1,offset_token1.length()-1);    
                break;
            }
          //System.out.println(base_reg1+","+offset_token1);
        try {
            base_reg1 = base_reg1.trim();
            int regB = backend.Register.convertRegister(base_reg1); // base register
            
            if(regB!=13 && regB!=15){
            	backend.convertToBinary.encodeRegister(regB,binaryconvert,5,4,3);
                	
            }
            
            if(offset_token1.startsWith("+"))
                offset_token1=offset_token1.substring(1);
            else if(offset_token1.startsWith("-"))
            {
                minus_flag=1;
                offset_token1=offset_token1.substring(1);
            }
                         
            int ofset = Integer.parseInt(offset_token1);
            int l=ofset>>2;
            String temp=Integer.toBinaryString(l);
            String bin_ofset=Integer.toBinaryString(ofset);
            
            if(regB==13 || regB==15){
            	for(int i=temp.length();i<8;i++)
            		temp="0".concat(temp);
            	for(int i=0;i<=7;i++)
            		binaryconvert[i]=temp.charAt(7-i);}
            
            else{
            	for(int i=bin_ofset.length();i<5;i++)
            		bin_ofset="0".concat(bin_ofset);
            
            	for(int i=0;i<=4;i++)
            		binaryconvert[i+6]=bin_ofset.charAt(4-i);
            
            }
            
            
                if(minus_flag==0)
                    address=backend.Register.r[regB].b+ofset;
                else
                    address=backend.Register.r[regB].b-ofset;
            
            } catch (NumberFormatException numberFormatException) {
     frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Number Format Exception\n");
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
            }
        
        
            return address;
    }

    private Integer calculateRegOfst(String base_reg1, String offset_token1,int cs,int x){
    	Integer address=new Integer(0);
        int minus_flag=0;
                
        switch(cs)
        {
            case 1:
                offset_token1=offset_token1.substring(0,offset_token1.length()-1);
                break;
        }
        
          
        try {
            base_reg1 = base_reg1.trim();
            int regB = Integer.parseInt(base_reg1.substring(1));
            backend.convertToBinary.encodeRegister(regB,binaryconvert,5,4,3);
            
            
            if(offset_token1.startsWith("+"))
                offset_token1=offset_token1.substring(1);
            else if(offset_token1.startsWith("-"))
            {
                minus_flag=1;
                offset_token1=offset_token1.substring(1);
            }
            
            int ofset = backend.Register.r[Integer.parseInt(offset_token1.substring(1))].b;
            backend.convertToBinary.encodeRegister(Integer.parseInt(offset_token1.substring(1)),binaryconvert,8,7,6);
            
            
                if(minus_flag==0){
                    address=backend.Register.r[regB].b+ofset;}
                else
                {   
                    address=backend.Register.r[regB].b-ofset;
                }
                
            
            } catch (NumberFormatException numberFormatException) {
     frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Number Format Exception\n");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++; 
            }
        
        
            return address;
    	
    }
    
    private Integer calculateRegOfst(String base_reg1, String offset_token1,int cs) {
    Integer address=new Integer(0);
        int minus_flag=0;
        for(int i=11;i>=4;i--)
                    binaryconvert[i]=0;
                
        switch(cs)
        {
            case 1:
                binaryconvert[25]=1;
                binaryconvert[24]=1;
                binaryconvert[21]=0;
                
                offset_token1=offset_token1.substring(0,offset_token1.length()-1);
                break;
            case 2:
                binaryconvert[25]=1;
                binaryconvert[24]=1;
                binaryconvert[21]=1;
                
                
                offset_token1=offset_token1.substring(0,offset_token1.length()-2);
                break;
            case 3:
                binaryconvert[25]=1;
                binaryconvert[24]=0;
                binaryconvert[21]=0;
                
                
                base_reg1=base_reg1.substring(0,base_reg1.length()-2);
                break;
        }
        
          
        try {
            base_reg1 = base_reg1.trim();
            int regB = Integer.parseInt(base_reg1.substring(1));
            backend.convertToBinary.encodeRegister(regB,binaryconvert,19,18,17,16);
            
            if(offset_token1.startsWith("+"))
                offset_token1=offset_token1.substring(1);
            else if(offset_token1.startsWith("-"))
            {
                minus_flag=1;
                offset_token1=offset_token1.substring(1);
            }
            
            int ofset = backend.Register.r[Integer.parseInt(offset_token1.substring(1))].b;
            backend.convertToBinary.encodeRegister(Integer.parseInt(offset_token1.substring(1)),binaryconvert,3,2,1,0);
            
            if(cs==3)
            {
                address=backend.Register.r[regB].b;
                if(minus_flag==0)
                    backend.Register.r[regB].b=address+ofset;
                else
                    backend.Register.r[regB].b=address-ofset;
            }
            else
            {
                if(minus_flag==0){
                    binaryconvert[23]=1;
                    address=backend.Register.r[regB].b+ofset;}
                else
                {
                    binaryconvert[23]=0;
                    address=backend.Register.r[regB].b-ofset;
                }
                if(cs==2)
                    backend.Register.r[regB].b=address;
            
                
            }
            } catch (NumberFormatException numberFormatException) {
     frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Number Format Exception\n");
    frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++; 
            }
        
        
            return address;
    }

    private Integer calculateWithShift(String base_reg1, String offset_token1, String shift_token1,int cs) {
 Integer address=new Integer(0);
        int minus_flag=0;
        switch(cs)
        {
            case 1:
                binaryconvert[25]=1;
                binaryconvert[24]=1;
                binaryconvert[21]=0;
                binaryconvert[4]=0;
                shift_token1=shift_token1.substring(0,offset_token1.length()-1);
                break;
            case 2:
                binaryconvert[25]=1;
                binaryconvert[24]=1;
                binaryconvert[21]=1;
                binaryconvert[4]=0;
                
                shift_token1=shift_token1.substring(0,offset_token1.length()-2);
                break;
            case 3:
                binaryconvert[25]=1;
                binaryconvert[24]=0;
                binaryconvert[21]=0;
                binaryconvert[4]=0;
               
                base_reg1=base_reg1.substring(0,base_reg1.length()-1);
                break;
        }
        try {
            base_reg1 = base_reg1.trim();
            int regB = Integer.parseInt(base_reg1.substring(1));
            backend.convertToBinary.encodeRegister(regB,binaryconvert,19,18,17,16);
            
            if(offset_token1.startsWith("+"))
                offset_token1=offset_token1.substring(1);
            else if(offset_token1.startsWith("-"))
            {
                minus_flag=1;
                offset_token1=offset_token1.substring(1);
            }
            
            int Regofset = Integer.parseInt(offset_token1.substring(1));
            backend.convertToBinary.encodeRegister(Regofset,binaryconvert,3,2,1,0);
            
            StringTokenizer st=new StringTokenizer(shift_token1,"#");
            String shift=st.nextToken().trim();
            
            String shift_amnt=(st.nextToken().trim());
            String tmp=Integer.toBinaryString(Integer.parseInt(shift_amnt));
            if(tmp.length()>5)
            {
                //overflow error
            }
            else
            {
                
                for(int i=tmp.length();i<5;i++)
                    tmp="0".concat(tmp);
                for(int i=11,j=0;i>=7;i--,j++)
                    binaryconvert[i]=tmp.charAt(j);
            }
            shift_amnt="#".concat(shift_amnt);
            int ofset=backend.BarrelShifter.shift(shift_amnt,backend.Register.r[Regofset].b,InstructionSet.shift.valueOf(shift));
          
            if(cs==3)
            {
                address=backend.Register.r[regB].b;
                if(minus_flag==0)
                {
                    binaryconvert[23]=1;
                    
                    backend.Register.r[regB].b=address+ofset;
                }
                else
                {
                    binaryconvert[23]=0;
                    
                    backend.Register.r[regB].b=address-ofset;
                }
            }
            else
            {
                if(minus_flag==0)
                    address=backend.Register.r[regB].b+ofset;
                else
                    address=backend.Register.r[regB].b-ofset;
                
                if(cs==2)
                    backend.Register.r[regB].b=address;
            
                
            }
            } catch (NumberFormatException numberFormatException) {
            frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Number Format Exception\n");
     frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;
            }
        
        
            return address;
    
    }
    
    private Integer calculate(StringTokenizer st_case1,int cs)
    {
        Integer address=new Integer(0);
        int ct1=st_case1.countTokens();
        String[] token1=new String[ct1];
        //System.out.println("qhjbcihqebdciqhebdciqehdc");
        //System.out.println(ct1);
        for(int i=0;i<ct1;i++)
        {
            token1[i]=st_case1.nextToken();
            token1[i]=token1[i].trim();
            //System.out.println(token1[i]);
        }
        //System.out.println("qhjbcihqebdciqhebdciqehdc");
        
        if(token1[1].startsWith("#"))
        {
            //System.out.println("address 2:"+token1[0]+","+token1[1]+":)");
            				if(ScanFile.a_mode==0)
                             address=calculateImmdOfst(token1[0],token1[1],cs);
            				else
            					address=calculateImmdOfst(token1[0],token1[1],cs,0);
        }					
        else if(ct1==2)
        {					
        						if(ScanFile.a_mode==0)
                              address=calculateRegOfst(token1[0],token1[1],cs);
        						else
                                    address=calculateRegOfst(token1[0],token1[1],cs,0);

        
        }
        else if(ct1==3)
        {
                              address=calculateWithShift(token1[0],token1[1],token1[2],cs);
        }
        else{
            frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Invalid Addressing format\n");
             frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length()); frontend.FrontEnd.exceptionraised++;}     
                         
                 
                 return address;
    }
    
}
