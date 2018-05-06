/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Dr Rakesh Malhotra
 */
public class convertToBinary {

     

    public static void encodeRegister(Integer no, int[] binaryconvert, int i, int i0, int i1, int i2) {
        
        try {
            
            String binary = Integer.toBinaryString(no);
            //System.out.println("$"+binary);
            for(int ik=binary.length();ik<4;ik++)
             binary="0".concat(binary);
            //System.out.println("$"+binary);
          binaryconvert[i] = binary.charAt(0) - '0';
            binaryconvert[i0] = binary.charAt(1) - '0';
            binaryconvert[i1] = binary.charAt(2) - '0';
            binaryconvert[i2] = binary.charAt(3) - '0';
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.print("\n reachd in and :"+no+"\n");
    }
    
    public static void encodeRegister(Integer no, int[] binaryconvert16, int i, int i0, int i1) {
        
        try {
            
            String binary = Integer.toBinaryString(no);
            //System.out.println("$"+binary);
            for(int ik=binary.length();ik<3;ik++)
             binary="0".concat(binary);
            //System.out.println("$"+binary);
          binaryconvert16[i] = binary.charAt(0) - '0';
            binaryconvert16[i0] = binary.charAt(1) - '0';
            binaryconvert16[i1] = binary.charAt(2) - '0';
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //System.out.print("\n reachd in and :"+no+"\n");
    }

    
    public static void encodeSecondOperand(int operand_2, int[] binaryconvert16,int st,int end) {
        int len=end-st+1;

            //immediate
    	binaryconvert16[10]=1;
            String binary=Integer.toBinaryString(operand_2);
            for(int j=binary.length();j<len;j++)
                binary="0".concat(binary);
            for(int j=0;j<len;j++){
            	binaryconvert16[st+j]=binary.charAt(j)-'0';
            }
    
    }
    
    

    public static void encodeSecondOperand(int operand_2, int[] binaryconvert) {
        if(ScanFile.barrelshiftpresent)
        {
            binaryconvert[25]=0;
            if(BarrelShifter.typeofshift==8)
            {
                binaryconvert[11]=0;
                binaryconvert[10]=0;
                binaryconvert[9]=0;
                binaryconvert[8]=0;
                binaryconvert[7]=0;
                binaryconvert[6]=1;
                binaryconvert[5]=1;
                binaryconvert[4]=0;
            }
            else
            {
                try {
            
            String binary = Integer.toBinaryString(BarrelShifter.typeofshift);
            //System.out.println("$"+binary);
            for(int ik=binary.length();ik<3;ik++)
             binary="0".concat(binary);
            //System.out.println("$"+binary);
            binaryconvert[6] = binary.charAt(1) - '0';
            binaryconvert[5] = binary.charAt(2) - '0';
//            binaryconvert[4] = binary.charAt(3) - '0';
        } catch (Exception e) {
            e.printStackTrace();
        }
                try {
            
            String binary = Integer.toBinaryString(ScanFile.regnoOrImmOp);
            //System.out.println("$"+binary);
           if(ScanFile.reg1orimm0==1)
           { 
               for(int ik=binary.length();ik<4;ik++)
                  binary="0".concat(binary);
            //System.out.println("$"+binary);
          binaryconvert[11] = binary.charAt(0) - '0';
            binaryconvert[10] = binary.charAt(1) - '0';
            binaryconvert[9] = binary.charAt(2) - '0';
            binaryconvert[8] = binary.charAt(3) - '0';
            binaryconvert[7]=0;
        } 
        else
        {
              for(int ik=binary.length();ik<5;ik++)
                  binary="0".concat(binary);
            //System.out.println("$"+binary);
            binaryconvert[11] = binary.charAt(0) - '0';
            binaryconvert[10] = binary.charAt(1) - '0';
            binaryconvert[9] = binary.charAt(2) - '0';
            binaryconvert[8] = binary.charAt(3) - '0';
            binaryconvert[7]= binary.charAt(3)-'0';
         
        }
                } catch (Exception e) {
            e.printStackTrace();
        }
           
                
            }
            encodeRegister(ScanFile.shiftregno,binaryconvert,3,2,1,0);
        }
        else
        {
            //immediate
            String binary=Integer.toBinaryString(operand_2);
            for(int j=0;j<8;j++)
                binary="0".concat(binary);
            binaryconvert[7]=binary.charAt(0)-'0';
            binaryconvert[6]=binary.charAt(1)-'0';
        binaryconvert[5]=binary.charAt(2)-'0';
        binaryconvert[4]=binary.charAt(3)-'0';
        binaryconvert[3]=binary.charAt(4)-'0';
        binaryconvert[2]=binary.charAt(5)-'0';
        binaryconvert[1]=binary.charAt(6)-'0';
        binaryconvert[0]=binary.charAt(7)-'0';
        binaryconvert[25]=1;
        binaryconvert[8]=0;
        binaryconvert[9]=0;
        binaryconvert[10]=0;
        binaryconvert[11]=0;
        
        
        }
    }
    RandomAccessFile br=null;
    String binaryfile=null;
    RandomAccessFile raf=null;
    public convertToBinary(String path)
    {
        try {
            File f = new File(path);
             br=new RandomAccessFile(f,"rw");
             String directory=f.getParent();
             String fname=f.getName();
             int i=fname.indexOf(".");
             fname=fname.substring(0, i+1);
             binaryfile=directory.concat("\\".concat(fname).concat("obj"));
             System.out.print(binaryfile);
             File bin=new File(binaryfile);
             raf=new RandomAccessFile(bin,"rw");
        } catch (FileNotFoundException ex) {
            frontend.FrontEnd.statuswindow.append("Error in creating object file :"+binaryfile+"\n");
     frontend.FrontEnd.exceptionraised++;return;    }
    }
    
    
    public static void main(String argsp[])
    {
        convertToBinary obj = new convertToBinary("f:\\a\\hello.txt");
        obj.start();
        
    }

    private void start() {
        try {
            String strline=new String();
            while ((strline = raf.readLine()) != null)
            {
                convertLine(strline);
            }
        } catch (IOException ex) {
                frontend.FrontEnd.statuswindow.append("Error in creating object file :"+binaryfile+"\n");
      frontend.FrontEnd.exceptionraised++;return;   }
    }

    private void convertLine(String strline) {
        
    }
    
}
