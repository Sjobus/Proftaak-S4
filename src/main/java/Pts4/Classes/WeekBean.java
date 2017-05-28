package Pts4.Classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by myron on 22-05-17.
 */
public class WeekBean
{
    private int week;
    private Date day;
    private ArrayList<Timestamp> timestamps;
    private int hours = 0;

    public WeekBean (int week)
    {
        this.week = week;
        timestamps = new ArrayList<Timestamp>();
    }

    public int getWeek()
    {
        return this.week;
    }

    public ArrayList<Timestamp> getTimestamps()
    {
        return this.timestamps;
    }

    void addTimestamp(Timestamp ts)
    {
        this.timestamps.add(ts);
        this.day = ts.GetDate();
        this.hours = this.hours + ts.GetHour();
    }

    public Date getFirstday()
    {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //Last day of the week
        return cal.getTime();
    }

    public Date getLastday()
    {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); //Last day of the week
        return cal.getTime();
    }

    public int getHours()
    {
        return hours;
    }
}
