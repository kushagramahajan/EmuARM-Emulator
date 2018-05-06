/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

/**
 *
 * @author geetika
 */
public class FlagRegister {
    public int N;
    public int C;
    public int Z;
    public int V;
    int Q;
    int I;
    int F;
    int T;
    int[] ext;
    int[] M;
    
    FlagRegister()
    {
        N=0;
        C=0;
        Z=0;
        V=0;
        Q=0;
        I=0;
        F=0;
        T=0;
        M=new int[5];
        ext=new int[18];
        for(int i=0;i<5;i++)    // user mode : 0b10000
            M[i]=0;
        M[4]=1;
    }

    public void update(int[] b,String mask,int[] binaryconvert)
    {
        if(mask.contains("F"))
        {
            binaryconvert[19]=1;
            N=b[31];
            Z=b[30];
            C=b[29];
            V=b[28];
            Q=b[27];
            ext[17]=b[26];
            ext[16]=b[25];
            ext[15]=b[24];

        }
        else
            binaryconvert[19]=0;
        if(mask.contains("C"))
        {
            binaryconvert[16]=1;
        I=b[7];
        F=b[6];
        T=b[5];
        for(int i=4;i>=0;i--)
            M[i]=b[i];
        }
        else
            binaryconvert[16]=0;
        if(mask.contains("X"))
        {
            binaryconvert[17]=1;
            //b[8-15]
            for(int i=0;i<8;i++)
                ext[i]=b[8+i];
            
        }
        else
            binaryconvert[17]=0;
        
        if(mask.contains("S"))
        {
            //b[16-23]
            binaryconvert[18]=1;
            for(int i=0;i<8;i++)
                ext[8+i]=b[16+i];
            
        }
        else
            binaryconvert[18]=0;
        if(!mask.isEmpty() && (!mask.contains("S") && !mask.contains("X") && !mask.contains("C") && !mask.contains("F")))
        {
            frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Unknown mask specified for flag register. \n");
       frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());      frontend.FrontEnd.exceptionraised++;    return;   
        }
    }

    public String value()
    {
        char[] b=new char[32];
        b[0]=(char) ((char) N+'0');
        b[1]=(char) ((char) Z+'0');
        b[2]=(char) ((char)C+'0');
        b[3]=(char) ((char)V+'0');
        b[4]=(char) ((char)Q+'0');
        for(int i=23;i>=5;i--)
            b[i]='0';
        b[24]=(char) ((char)I+'0');
        b[25]=(char) ((char)F+'0');
        b[26]=(char) ((char)T+'0');
        for(int i=0;i<=4;i++)
            b[i+27]=(char) ((char)M[4-i]+'0');
        
       
        return String.copyValueOf(b);
    }
public int getValue()
    {
        int[] b=new int[32];
        b[31]=N;
        b[30]=Z;
        b[29]=C;
        b[28]=V;
        b[27]=Q;
        for(int i=26;i>=8;i--)
            b[i]=0;
        b[7]=I;
        b[6]=F;
        b[5]=T;
        for(int i=4;i>=0;i--)
            b[i]=M[i];
        
        int a=0;
        for(int i=0;i<32;i++)
            a+=b[i]*Math.pow(2, i);
        
        return a;
    }

    public boolean modeUser()
    {
        if(M[4]==1)
        {
            if(M[3]==0)
            {
                if(M[2]==0)
                {
                    if(M[1]==0)
                    {
                        if(M[0]==0)
                        {
                            return true;
                        }
                    }
                }
            }
        }
           
        return false;
    }
    /**
     * b[31]=N;
     * b[30]=Z;
     * b[29]=C;
     * b[28]=V;
     * b[27]=Q;
     * b[26-8]=unused;
     * b[7]=I;
     * b[6]=F;
     * b[5]=T;
     * b[4-0]=M[4-0];
     *
     */

}
