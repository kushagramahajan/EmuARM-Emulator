/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

/**
 *
 * @author geetika
 */
public class Register_spec {

    public Integer b;
    public Register_spec()
    {
        b=new Integer(0);
        
    }

    public void storeValue(int d)
    {
        //decimal_to_binary
        b=d;
    }
    public int value()
    {
        
        return b;
    }
public int firstByteValue()
    {
        int tmp = 0x000000ff;
        int val=(int) (tmp&b);
        return val;
    }

public int first5bitValue()
    {
        int tmp = 0x0000001f;
        int val=(int)(tmp&b);
        return val;
    }

    int sign() {
        if(b<0)
            return 1;
        else return 0;
    }

}
