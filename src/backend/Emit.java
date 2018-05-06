
package backend;

import backend.InstructionSet.*;

import backend.instructions.InsInterface2;
import backend.instructions.InsInterface3;
import backend.instructions.InsInterface4;
import frontend.handlers;

import java.util.Hashtable;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author geetika
 */
public class Emit {
    public static Hashtable ht;
    public static Hashtable ht1;
    public Emit()
    {
        ht=new Hashtable();
        ht1=new Hashtable();
    }
    
    public void createHash()
    {
        ht.clear();
        ht1.clear();
        
        ADC[] adc=backend.InstructionSet.ADC.values();
        backend.InstructionSetThumb.ADC[] adc1=backend.InstructionSetThumb.ADC.values();
        
        for(int i=0;i<adc.length;i++)
        {
            ht.put(adc[i].name(),new backend.instructions.ADC());


        }

        for(int i=0;i<adc1.length;i++)
        {
            ht1.put(adc1[i].name(),new backend.instructions.ADC());


        }

        ADD[] add=backend.InstructionSet.ADD.values();
        backend.InstructionSetThumb.ADD[] add1=backend.InstructionSetThumb.ADD.values();
        
        for(int i=0;i<add.length;i++)
        {
            ht.put(add[i].name(),new backend.instructions.ADD());


        }
        for(int i=0;i<add1.length;i++)
        {
            ht1.put(add1[i].name(),new backend.instructions.ADD());


        }
        
        AND[] and=backend.InstructionSet.AND.values();
        backend.InstructionSetThumb.AND[] and1=backend.InstructionSetThumb.AND.values();
        
        for(int i=0;i<and.length;i++)
        {
            ht.put(and[i].name(),new backend.instructions.AND());


        }
        for(int i=0;i<and1.length;i++)
        {
            ht1.put(and1[i].name(),new backend.instructions.AND());


        }
        
        
        BIC[] bic=backend.InstructionSet.BIC.values();
        backend.InstructionSetThumb.BIC[] bic1=backend.InstructionSetThumb.BIC.values();
        
        for(int i=0;i<bic.length;i++)
        {
            ht.put(bic[i].name(),new backend.instructions.BIC());


        }
        for(int i=0;i<bic1.length;i++)
        {
            ht1.put(bic1[i].name(),new backend.instructions.BIC());


        }
        
        CMN[] cmn=backend.InstructionSet.CMN.values();
        backend.InstructionSetThumb.CMN[] cmn1=backend.InstructionSetThumb.CMN.values();
        
        for(int i=0;i<cmn.length;i++)
        {
            ht.put(cmn[i].name(),new backend.instructions.CMN());


        }
        for(int i=0;i<cmn1.length;i++)
        {
            ht1.put(cmn1[i].name(),new backend.instructions.CMN());


        }
        
        CMP[] cmp=backend.InstructionSet.CMP.values();
        backend.InstructionSetThumb.CMP[] cmp1=backend.InstructionSetThumb.CMP.values();
        
        for(int i=0;i<cmp.length;i++)
        {
            ht.put(cmp[i].name(),new backend.instructions.CMP());


        }
        for(int i=0;i<cmp1.length;i++)
        {
            ht1.put(cmp1[i].name(),new backend.instructions.CMP());


        }
        
        EOR[] eor=backend.InstructionSet.EOR.values();
        backend.InstructionSetThumb.EOR[] eor1=backend.InstructionSetThumb.EOR.values();
        
        for(int i=0;i<eor.length;i++)
        {
            ht.put(eor[i].name(),new backend.instructions.EOR());


        }
        for(int i=0;i<eor1.length;i++)
        {
            ht1.put(eor1[i].name(),new backend.instructions.EOR());


        }
        MOV[] mov=backend.InstructionSet.MOV.values();
        backend.InstructionSetThumb.MOV[] mov1=backend.InstructionSetThumb.MOV.values();
        
        for(int i=0;i<mov.length;i++)
        {
            ht.put(mov[i].name(),new backend.instructions.MOV());


        }
        for(int i=0;i<mov1.length;i++)
        {
            ht1.put(mov1[i].name(),new backend.instructions.MOV());


        }
        
         MVN[] mvn=backend.InstructionSet.MVN.values();
         backend.InstructionSetThumb.MVN[] mvn1=backend.InstructionSetThumb.MVN.values();
         
        for(int i=0;i<mvn.length;i++)
        {
            ht.put(mvn[i].name(),new backend.instructions.MVN());


        }
        for(int i=0;i<mvn1.length;i++)
        {
            ht1.put(mvn1[i].name(),new backend.instructions.MVN());


        }        
        ORR[] orr=backend.InstructionSet.ORR.values();
        backend.InstructionSetThumb.ORR[] orr1=backend.InstructionSetThumb.ORR.values();
        
        for(int i=0;i<orr.length;i++)
        {
            ht.put(orr[i].name(),new backend.instructions.ORR());


        }
        for(int i=0;i<orr1.length;i++)
        {
            ht1.put(orr1[i].name(),new backend.instructions.ORR());


        }        
        RSB[] rsb=backend.InstructionSet.RSB.values();
        backend.InstructionSetThumb.RSB[] rsb1=backend.InstructionSetThumb.RSB.values();
        
        for(int i=0;i<rsb.length;i++)
        {
            ht.put(rsb[i].name(),new backend.instructions.RSB());


        }
        for(int i=0;i<rsb1.length;i++)
        {
            ht1.put(rsb1[i].name(),new backend.instructions.RSB());


        }
        
        RSC[] rsc=backend.InstructionSet.RSC.values();
        backend.InstructionSetThumb.RSC[] rsc1=backend.InstructionSetThumb.RSC.values();
        
        for(int i=0;i<rsc.length;i++)
        {
            ht.put(rsc[i].name(),new backend.instructions.RSC());


        }
        for(int i=0;i<rsc1.length;i++)
        {
            ht1.put(rsc1[i].name(),new backend.instructions.RSC());


        }
         SBC[] sbc=backend.InstructionSet.SBC.values();
         backend.InstructionSetThumb.SBC[] sbc1=backend.InstructionSetThumb.SBC.values();
         
        for(int i=0;i<sbc.length;i++)
        {
            ht.put(sbc[i].name(),new backend.instructions.SBC());


        }
        for(int i=0;i<sbc1.length;i++)
        {
            ht1.put(sbc1[i].name(),new backend.instructions.SBC());


        }
         SUB[] sub=backend.InstructionSet.SUB.values();
         backend.InstructionSetThumb.SUB[] sub1=backend.InstructionSetThumb.SUB.values();
         
        for(int i=0;i<sub.length;i++)
        {
            ht.put(sub[i].name(),new backend.instructions.SUB());


        }
        for(int i=0;i<sub1.length;i++)
        {
            ht1.put(sub1[i].name(),new backend.instructions.SUB());


        }
         TEQ[] teq=backend.InstructionSet.TEQ.values();
         backend.InstructionSetThumb.TEQ[] teq1=backend.InstructionSetThumb.TEQ.values();
         
        for(int i=0;i<teq.length;i++)
        {
            ht.put(teq[i].name(),new backend.instructions.TEQ());


        }
        for(int i=0;i<teq1.length;i++)
        {
            ht1.put(teq1[i].name(),new backend.instructions.TEQ());


        }
        
         TST[] tst=backend.InstructionSet.TST.values();
         backend.InstructionSetThumb.TST[] tst1=backend.InstructionSetThumb.TST.values();
         
        for(int i=0;i<tst.length;i++)
        {
            ht.put(tst[i].name(),new backend.instructions.TST());


        }
        for(int i=0;i<tst1.length;i++)
        {
            ht1.put(tst1[i].name(),new backend.instructions.TST());


        }
         MRS[] mrs=backend.InstructionSet.MRS.values();
         backend.InstructionSetThumb.MRS[] mrs1=backend.InstructionSetThumb.MRS.values();
         
        for(int i=0;i<mrs.length;i++)
        {
            ht.put(mrs[i].name(),new backend.instructions.MRS());


        }
        for(int i=0;i<mrs1.length;i++)
        {
            ht1.put(mrs1[i].name(),new backend.instructions.MRS());


        }        
         MSR[] msr=backend.InstructionSet.MSR.values();
         backend.InstructionSetThumb.MSR[] msr1=backend.InstructionSetThumb.MSR.values();
         
        for(int i=0;i<msr.length;i++)
        {
            ht.put(msr[i].name(),new backend.instructions.MSR());


        }
        for(int i=0;i<msr1.length;i++)
        {
            ht1.put(msr1[i].name(),new backend.instructions.MSR());


        }
        
         B[] b=backend.InstructionSet.B.values();
         backend.InstructionSetThumb.B[] b1=backend.InstructionSetThumb.B.values();
         
        for(int i=0;i<b.length;i++)
        {
            ht.put(b[i].name(),new backend.instructions.B());


        }
        for(int i=0;i<b1.length;i++)
        {
            ht1.put(b1[i].name(),new backend.instructions.B());


        }        
         BL[] bl=backend.InstructionSet.BL.values();
         backend.InstructionSetThumb.BL[] bl1=backend.InstructionSetThumb.BL.values();
         
        for(int i=0;i<bl.length;i++)
        {
            ht.put(bl[i].name(),new backend.instructions.BL());


        }
        for(int i=0;i<bl1.length;i++)
        {
            ht1.put(bl1[i].name(),new backend.instructions.BL());


        }
         LDR[] ldr=backend.InstructionSet.LDR.values();
         backend.InstructionSetThumb.LDR[] ldr1=backend.InstructionSetThumb.LDR.values();
         
        for(int i=0;i<ldr.length;i++)
        {
            ht.put(ldr[i].name(),new backend.instructions.LDR());


        }
        for(int i=0;i<ldr1.length;i++)
        {
            ht1.put(ldr1[i].name(),new backend.instructions.LDR());


        }        
         STR[] str=backend.InstructionSet.STR.values();
         backend.InstructionSetThumb.STR[] str1=backend.InstructionSetThumb.STR.values();
         
        for(int i=0;i<str.length;i++)
        {
            ht.put(str[i].name(),new backend.instructions.STR());


        }
        for(int i=0;i<str1.length;i++)
        {
            ht1.put(str1[i].name(),new backend.instructions.STR());


        }
        STM[] stm=backend.InstructionSet.STM.values();
         backend.InstructionSetThumb.STM[] stm1=backend.InstructionSetThumb.STM.values();
         
        for(int i=0;i<stm.length;i++)
        {
            ht.put(stm[i].name(),new backend.instructions.STM());


        }
        for(int i=0;i<stm1.length;i++)
        {
            ht1.put(stm1[i].name(),new backend.instructions.STM());


        }
        LDM[] ldm=backend.InstructionSet.LDM.values();
         backend.InstructionSetThumb.LDM[] ldm1=backend.InstructionSetThumb.LDM.values();
         
        for(int i=0;i<ldm.length;i++)
        {
            ht.put(ldm[i].name(),new backend.instructions.LDM());


        }
        for(int i=0;i<ldm1.length;i++)
        {
            ht1.put(ldm1[i].name(),new backend.instructions.LDM());


        }        
        MUL[] mul=backend.InstructionSet.MUL.values();
        backend.InstructionSetThumb.MUL[] mul1=backend.InstructionSetThumb.MUL.values();
        
        for(int i=0;i<mul.length;i++)
        {
            ht.put(mul[i].name(),new backend.instructions.MUL());


        }
        for(int i=0;i<mul1.length;i++)
        {
            ht1.put(mul1[i].name(),new backend.instructions.MUL());


        }
        
        backend.InstructionSetThumb.LSL[] lsl1=backend.InstructionSetThumb.LSL.values();
        for(int i=0;i<lsl1.length;i++)
        {
            ht1.put(lsl1[i].name(),new backend.instructions.LSL());


        }

        backend.InstructionSetThumb.LSR[] lsr1=backend.InstructionSetThumb.LSR.values();
        for(int i=0;i<lsr1.length;i++)
        {
            ht1.put(lsr1[i].name(),new backend.instructions.LSR());


        }

        backend.InstructionSetThumb.ASR[] asr1=backend.InstructionSetThumb.ASR.values();
        for(int i=0;i<asr1.length;i++)
        {
            ht1.put(asr1[i].name(),new backend.instructions.ASR());


        }

        backend.InstructionSetThumb.ROR[] ror1=backend.InstructionSetThumb.ROR.values();
        for(int i=0;i<ror1.length;i++)
        {
            ht1.put(ror1[i].name(),new backend.instructions.ROR());


        }

    }
    public static void execute(StringTokenizer st )
    {
        
        int ct=st.countTokens();
        
        String ins = null;
        try {
            ins = st.nextToken();
            //System.out.println("\n <3 at line"+ins+String.valueOf(backend.ScanFile.curent_line));
        } catch (Exception e) {
        	if(handlers.cmd_var==1){
            	System.out.println("Some problem occured while execution. check syntax.");	
            	}
            	else{
                
            JOptionPane.showMessageDialog(null,"Some problem occured while execution. check syntax.");
            	}   
        }
        InsInterface4 obj;
  String token2_2=null;
  String token2_3=null;
  String token3_3=null;
  String token2=null;
  String token3=null;
  String token4=null;
     if(ScanFile.a_mode==0){
  		switch(ct)
        {
            /*case 1:
                break;*/
            
            case 2:
                 if (ht.get(ins) instanceof InsInterface2) {
                     //System.err.println("got in here");
                    InsInterface2 obj2 = (InsInterface2) ht.get(ins);
                   token2_2 = st.nextToken();
                    obj2.execute(ins, token2_2);
                } else {
                	if(handlers.cmd_var==1){
                    	System.out.println("ERROR in line "+ScanFile.curent_line+token2_2+": Unknown Command"+"\n");	
                    	}
                    	else{
                        
                     frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+token2_2+": Unknown Command"+"\n");
  frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}
                	frontend.FrontEnd.exceptionraised++;return;
                }
                break;
            case 3:
                  
                //System.out.print(ht.get(ins));
                if(ht.get(ins) instanceof InsInterface3)
                {
                 InsInterface3 obj1=(InsInterface3) ht.get(ins);
                 token2_3=st.nextToken();
               token3_3=st.nextToken();
                 obj1.execute(ins,token2_3,token3_3);
                }
                else
                {
                	if(handlers.cmd_var==1){
                    	System.out.println("ERROR in line "+ScanFile.curent_line+token2_3+token3_3+": Unknown Command\n");	
                    	}
                    	else{
                        
                     frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+token2_3+token3_3+": Unknown Command\n");  
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}      frontend.FrontEnd.exceptionraised++;return;
                }
                
                 break;
            case 4:
                //System.out.print(ht.get(ins));
                if(ht.get(ins) instanceof InsInterface4)
                {  
                 obj=(InsInterface4) ht.get(ins);
                 token2=st.nextToken();
                 token3=st.nextToken();
                  token4=st.nextToken();
                 obj.execute(ins,token2,token3,token4);
                 //System.out.print("in emit");
                }
                else
                {if(handlers.cmd_var==1){
                	System.out.println("ERROR in line "+ScanFile.curent_line+token2+token3+token4+": Unknown Command\n");	
                	}
                	else{
                    
                     frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+token2+token3+token4+": Unknown Command\n");
           frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}      frontend.FrontEnd.exceptionraised++;return;
                }
                break;
            default:
            	if(handlers.cmd_var==1){
                	System.out.println("ERROR in line "+ScanFile.curent_line+": Unknown Command\n");	
                	}
                	else{
                    
                     frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Unknown Command\n");
              frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}      frontend.FrontEnd.exceptionraised++;return;
            
        }
    }
     else if(ScanFile.a_mode==1){
    	 switch(ct)
         {
             
             case 2:
                  if (ht1.get(ins) instanceof InsInterface2) {
                    //  System.err.println("got in here");
                     InsInterface2 obj2 = (InsInterface2) ht1.get(ins);
                    token2_2 = st.nextToken();
                     obj2.execute(ins, token2_2);
                 } else {
                	 if(handlers.cmd_var==1){
                     	System.out.println("ERROR in line "+ScanFile.curent_line+token2_2+": Unknown Command"+"\n");	
                     	}
                     	else{
                         
                      frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+token2_2+": Unknown Command"+"\n");
   frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}    frontend.FrontEnd.exceptionraised++;return;
                 }
                 break;
             case 3:
                   //System.out.println("here8");
                 //System.out.print(ht1.get(ins));
                 if(ht1.get(ins) instanceof InsInterface3)
                 {
                  InsInterface3 obj1=(InsInterface3) ht1.get(ins);
                  token2_3=st.nextToken();
                token3_3=st.nextToken();
                //System.out.println("here9");
                obj1.execute(ins,token2_3,token3_3);
                //System.out.println("here10");
                 }
                 else
                 {
                	 if(handlers.cmd_var==1){
                     	System.out.println("ERROR in line "+ScanFile.curent_line+token2_3+token3_3+": Unknown Command\n");	
                     	}
                     	else{
                         
                      frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+token2_3+token3_3+": Unknown Command\n");  
                      frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}      frontend.FrontEnd.exceptionraised++;return;
                 
                 }
                  break;
             case 4:
                 //System.out.print(ht1.get(ins));
                 if(ht1.get(ins) instanceof InsInterface4)
                 {  
                  obj=(InsInterface4) ht1.get(ins);
                  token2=st.nextToken();
                  token3=st.nextToken();
                  token4=st.nextToken();
                  obj.execute(ins,token2,token3,token4);
                  //System.out.print("in emit");
                 }
                 else
                 {
                	 if(handlers.cmd_var==1){
                     	System.out.println("ERROR in line "+ScanFile.curent_line+token2+token3+token4+": Unknown Command\n");	
                     	}
                     	else{
                         
                      frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+token2+token3+token4+": Unknown Command\n");
            frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}      frontend.FrontEnd.exceptionraised++;return;
                 }
                 break;
             default:
            	 if(handlers.cmd_var==1){
                 	System.out.println("ERROR in line "+ScanFile.curent_line+": Unknown Command\n");	
                 	}
                 	else{
                     
                      frontend.FrontEnd.statuswindow.append("ERROR in line "+ScanFile.curent_line+": Unknown Command\n");
               frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());}      frontend.FrontEnd.exceptionraised++;return;
             
         } 
     }


    }

}
