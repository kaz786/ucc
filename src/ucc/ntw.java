/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucc;

import javax.swing.JOptionPane;

/**
 *
 * @author Ritik
 */
public class ntw {
    public String oth(int n)
    {
        String str="";
        while(n!=0)
        {
            if(n==1)
            {
                str=str+"ONE ";
                n=0;
            }
            else if(n==2)
            {
                str=str+"TWO ";
                n=0;
            }
            else if(n==3)
            {
                str=str+"THREE ";
                n=0;
            }else if(n==4)
            {
                str=str+"FOUR ";
                n=0;
            }else if(n==5)
            {
                str=str+"FIVE ";
                n=0;
            }else if(n==6)
            {
                str=str+"SIX ";
                n=0;
            }else if(n==7  )
            {
                str=str+"SEVEN ";
                n=0;
            }else if(n==8)
            {
                str=str+"EIGHT ";
                n=0;
            }else if(n==9)
            {
                str=str+"NINE ";
                n=0;
            }else if(n==10)
            {
                str=str+"TEN ";
                n=0;
            }else if(n==11)
            {
                str=str+"ELEVEN ";
                n=0;
            }else if(n==12)
            {
                str=str+"TWELVE ";
                n=0;
            }else if(n==13)
            {
                str=str+"THIRTEEN ";
                n=0;
            }else if(n==14)
            {
                str=str+"FOURTEEN ";
                n=0;
            }else if(n==15)
            {
                str=str+"FIFTEEN ";
                n=0;
            }else if(n==16)
            {
                str=str+"SIXTEEN ";
                n=0;
            }else if(n==17)
            {
                str=str+"SEVENTEEN ";
                n=0;
            }else if(n==18)
            {
                str=str+"EIGHTEEN ";
                n=0;
            }else if(n==19)
            {
                str=str+"NINETEEN ";
                n=0;
            }
            else if(n>=20 && n<30)
            {
                str=str+"TWENTY ";
                n=n-20;
            }
            else if(n>=30 && n<40)
            {
                str=str+"THIRTY ";
                n=n-30;
            }
            else if(n>=40 && n<50)
            {
                str=str+"FOURTY ";
                n=n-40;
            }
            else if(n>=50 && n<60)
            {
                str=str+"FIFTY ";
                n=n-50;
            }
            else if(n>=60 && n<70)
            {
                str=str+"SIXTY ";
                n=n-60;
            }
            else if(n>=70 && n<80)
            {
                str=str+"SEVENTY ";
                n=n-70;
            }else if(n>=80 && n<90)
            {
                str=str+"EIGHTY ";
                n=n-80;
            }else if(n>=90 && n<100)
            {
                str=str+"NINETY ";
                n=n-90;
            }
            
            
            
            
            
            
        }
        return str;
    }
    public String convert(int m)
    {
        String str="";
        while(m!=0)
        {
            if(m>=1 && m<100)
            {
                str=str+oth(m);
                m=0;
            }
            else if (m>=100 && m<1000)
            {
                str=str+oth(m/100);
                str=str+"HUNDRED ";
                m=m%100;
            }
            else if (m>=100 && m<1000)
            {
                str=str+oth(m/100);
                str=str+"HUNDRED ";
                m=m%100;
            }
            else if (m>=1000 && m<100000)
            {
                str=str+oth(m/1000);
                str=str+"THOUSAND ";
                m=m%1000;
            }
            else if (m>=100000 && m<10000000)
            {
                str=str+oth(m/100000);
                str=str+"LAKH ";
                m=m%100000;
            }
            else if (m>=10000000 && m<100000000)
            {
                str=str+oth(m/10000000);
                str=str+"CRORE ";
                m=m%10000000;
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Out of Range");
                
            }
        }
       return str;         
    }
    
}
