
package backend;

/**
 * flag register and conditional instructions
 */

/**
 *
 * @author geetika
 */
public class Condition {
    public static final int EQ=0;     //Equal
    public static final int NE=1;     //Not Equal
    public static final int HS=2;     //unsigned higher or same
    public static final int LO=3;     //unsigned lower
    public static final int MI=4;     //minus
    public static final int PL=5;     //plus
    public static final int VS=6;     //overflow set
    public static final int VC=7;     //overflow clear
    public static final int HI=8;     //unsigned higher
    public static final int LS=9;     //unsigned lower or same
    public static final int GE=10;    //unsigned greater or equal
    public static final int LT=11;    //signed less than
    public static final int GT=12;    //signed greater than
    public static final int LE=13;    //signed less than or equal
    public static final int AL=14;    //always
    public static FlagRegister cpsr,spsr;

    public Condition()
    {
        cpsr=new FlagRegister();
        spsr=new FlagRegister();
    }
    public  static int checkCondition(int cd)
    {
        switch(cd)
        {

            case EQ:
                if(cpsr.Z==1)
                    return 1;
                else
                    return 0;
                
            case NE:
                if(cpsr.Z==0)
                    return 1;
                else
                    return 0;
                
            case HS:
                if(cpsr.C==1)
                    return 1;
                else
                    return 0;
                
            case LO:
                if(cpsr.C==0)
                    return 1;
                else
                    return 0;
                
            case MI:
                if(cpsr.N==1)
                    return 1;
                else
                    return 0;
                
            case PL:
                if(cpsr.N==0)
                    return 1;
                else
                    return 0;
                
            case VS:
                if(cpsr.V==1)
                    return 1;
                else
                    return 0;
                
            case VC:
                if(cpsr.V==0)
                    return 1;
                else
                    return 0;
                
            case HI:
                if(cpsr.C==1 && cpsr.Z==0)
                    return 1;
                else
                    return 0;
                
            case LS:
                if(cpsr.C==0 && cpsr.Z==1)
                    return 1;
                else
                    return 0;
                
            case GE:
                if(cpsr.N==cpsr.V)
                    return 1;
                else
                    return 0;
                
            case LT:
                if(cpsr.N!=cpsr.V)
                    return 1;
                else
                    return 0;
            case GT:
                if(cpsr.Z==0 && cpsr.N==cpsr.V)
                    return 1;
                else
                    return 0;
                
            case LE:
                if(cpsr.Z==1 && cpsr.N!=cpsr.V)
                    return 1;
                else
                    return 0;
                
            case AL:
                return 1;
                
            default:
                return -1;

        }
        
    }

    public static void updateFlags(int b)
    {	
    	//System.out.println(b);
        Condition.cpsr.N=backend.Register.r[b].sign();
        long val=backend.Register.r[b].value();
        if(val==0)
            Condition.cpsr.Z=1;
        else
            Condition.cpsr.Z=0;
    }
     public static void updateFlags(int b,int id1,int id2,int chck,int ins)
    {
         //if ins=1 than cmp else cmn
        Condition.cpsr.N=b<0?1:0;
        int val = b;
         int s2=0,s1=0;
        
        if(val==0)
            Condition.cpsr.Z=1;
        else
            Condition.cpsr.Z=0;
if(ins==1){
        
            {
                if(val>=0)
                {
                    Condition.cpsr.C=1;
                }
                else
                {
                    Condition.cpsr.C=0;
                }
            }
            
}
else
{
              if(val>=Math.pow(2, 32))
                Condition.cpsr.C=1;
            else
                Condition.cpsr.C=0;
}
                    if(b>Math.pow(2,31)||b<-Math.pow(2,31))
                        Condition.cpsr.V=1;
                    else
                        Condition.cpsr.V=0;
                
    }
    public static void updateFlags(int id,String token1,int id1,int id2,int chck)
    {
        //chck=1, id2 is index else id is immed data
        int s2=0,s1=0;
        Condition.cpsr.N=backend.Register.r[id].sign();
        long val=backend.Register.r[id].value();
        if(val==0)
        {
            Condition.cpsr.Z=1;
           
        }
        else
            Condition.cpsr.Z=0;
        if(token1.contains("ADD"))
        {
            if(val>=Math.pow(2, 32))
                Condition.cpsr.C=1;
            else
                Condition.cpsr.C=0;


        }
        else if(token1.contains("SUB"))
        {
            if(chck==0)
            {
                if(backend.Register.r[id1].value()>id2)
                {
                    Condition.cpsr.C=1;
                }
                else
                {
                    Condition.cpsr.C=0;
                }
            }
            else
            {
                 if(backend.Register.r[id1].value()>backend.Register.r[id2].value())
                {
                    Condition.cpsr.C=1;
                }
                else
                {
                    Condition.cpsr.C=0;
                }
            }
        }
 if(chck!=0)
     id2=(int) backend.Register.r[id2].value();

                if(id2>=Math.pow(2, 31))
                {
                    s2=1;
                }
                s1=backend.Register.r[id1].sign();
                if(s1!=s2)
                {
                    Condition.cpsr.V=0;
                }
                else
                {
                    int s3=backend.Register.r[id].sign();
                    if(s3==s1)
                        Condition.cpsr.V=0;
                    else
                        Condition.cpsr.V=1;
                }


    }

}


