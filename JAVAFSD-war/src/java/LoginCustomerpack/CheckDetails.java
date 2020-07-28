/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginCustomerpack;
import java.util.Calendar;

public class CheckDetails {
    static String globalEDate;
    boolean checkDate(String EDate)
    {
        globalEDate=EDate;
        Calendar Now=Calendar.getInstance();
        int OMonth=Now.get(Calendar.MONTH);
        int ODate=Now.get(Calendar.DATE);
        int OYear=Now.get(Calendar.YEAR);
        if(EDate.length()==0)
            return false;

        boolean check=true;
        if(Integer.parseInt(EDate.substring(0,4))!=OYear)
            check=false;
        if(Integer.parseInt(EDate.substring(5,7))!=OMonth+1)
            check=false;
        if(Integer.parseInt(EDate.substring(8,10))<ODate)
            check=false;
        return check;
    }
    boolean checkTime(String ETime)
    {
        if(ETime.length()==0)
            return false;
        boolean check=true;
        Calendar Now=Calendar.getInstance();
        int OHour=Now.get(Calendar.HOUR_OF_DAY);
        int ODate=Now.get(Calendar.DATE);

        int OMinute=Now.get(Calendar.MINUTE);
        if(Integer.parseInt(globalEDate.substring(8,10))==ODate)
        {
        if(Integer.parseInt(ETime.substring(0,2))<8||Integer.parseInt(ETime.substring(0,2))<OHour)
            check=false;
        if(Integer.parseInt(ETime.substring(0,2))>=20)
            check=false;
        if(Integer.parseInt(ETime.substring(0,2))==OHour)
            if(Integer.parseInt(ETime.substring(3,5))<=OMinute)
            check=false;
        }
        else
        {
            if(Integer.parseInt(ETime.substring(0,2))<8)
            check=false;
            if(Integer.parseInt(ETime.substring(0,2))>=20)
            check=false;
            if(Integer.parseInt(ETime.substring(0,2))==20)
                if(Integer.parseInt(ETime.substring(3,5))==0)
            check=false;
        }
        return check;
    }
}

