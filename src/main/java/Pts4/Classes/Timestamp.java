package Pts4.Classes;

import Pts4.Database.dbTimestamp;

import java.util.*;

/**
 * Created by Gebruiker on 20-3-2017.
 */
public class Timestamp implements Comparable<Timestamp>, Comparator<Timestamp> {

    private int ID;
    private int Hour;
    private Date date;

    private Project project;
    private Person person;

    public int GetID() {return this.ID; }
    public void SetID(int n) {this.ID = n; }

    public int GetHour() {return this.Hour; }
    public void SetHour(int n) {this.Hour = n; }

    public Date GetDate() {return this.date; }
    public void SetDate(Date n) {this.date = n; }

    public Project Getproject() {return this.project; }
    public void Setproject(Project n) {this.project = n; }

    public Person Getperson() {return this.person; }
    public void Setperson(Person n) {this.person = n; }

    public Timestamp(int ID, int Hour, Date date)
    {
        this.ID = ID;
        this.Hour = Hour;
        this.date = date;
    }

    public Timestamp(int ID, int Hour, Date date, Project project, Person person)
    {
        this.ID = ID;
        this.Hour = Hour;
        this.date = date;
        this.project = project;
        this.person = person;
    }

    public Timestamp(int Hour, Date date, Project project, Person person)
    {
        this.Hour = Hour;
        this.date = date;
        this.project = project;
        this.person = person;
    }

    public Timestamp(int ID, int Hour, Date date, Project project)
    {
        this.ID = ID;
        this.Hour = Hour;
        this.date = date;
        this.project = project;
    }

    public Timestamp(int Hour, Person person)
    {
        this.Hour = Hour;
        this.person = person;
    }


    public boolean InsertTimestamp()
    {
        return dbTimestamp.InsertTimestamp(this);
    }

    public static HashMap<String, Integer> GetProjectsHours()
    {
        return dbTimestamp.GetTotalHoursProjects();
    }

    public static ArrayList<Timestamp> GetAllTimestampsByProject(Project PrProject)
    {
        ArrayList<Timestamp> TimeStampList;
        TimeStampList = dbTimestamp.GetTimeStampForManager(PrProject);
        if(TimeStampList != null)
        {
            return TimeStampList;
        }
        else
        {
            return null;
        }
    }
/*
    public static int GetTotalHoursFromProject(Project PrProject)
    {
        return dbTimestamp.GetTotalHoursProject(PrProject);
    }*/

    public static ArrayList<Timestamp> GetTimestampsByPerson(Person person)
    {
        ArrayList<Timestamp> TimeStampList;
        TimeStampList = dbTimestamp.GetTimeStampForPerson(person);
        if(TimeStampList != null)
        {
            Collections.sort(TimeStampList);
            return TimeStampList;
        }
        else
        {
            return null;
        }
    }

    public static ArrayList<WeekBean> getWeekBeansByPerson(Person person)
    {
        ArrayList<Timestamp> timestamps = GetTimestampsByPerson(person);
        ArrayList<WeekBean> weekBeans = new ArrayList<>();
        int week = 0;
        int woy = -1;
        WeekBean newWeek = new WeekBean(woy);
        if(timestamps == null)
            return null;
        Collections.sort(timestamps, new WeekComparator());
        for (Timestamp timestamp : timestamps) {
            if (woy != getWeekOfYear(timestamp) || !CheckSameYear(timestamp.GetDate(), newWeek.getDay())) {
                woy = getWeekOfYear(timestamp);
                week++;
                newWeek = new WeekBean(woy);
                weekBeans.add(newWeek);
                System.out.println("Week " + week + ":" + woy);
            }
            newWeek.addTimestamp(timestamp);
            System.out.println(timestamp);
        }
        return weekBeans;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(date);
        sb.append(" Project: ");
        sb.append(project);
        sb.append(" Hours: ");
        sb.append(Hour);
        return sb.toString();
    }

    @Override
    public int compareTo(Timestamp item)
    {
        if (this.date.before(item.date))
        {
            return -1;
        }
        else if(this.date.after(item.date))
        {
            return 1;
        }
        return 0;
    }

    @Override
    public int compare(Timestamp o1, Timestamp o2)
    {
        if (o1.GetDate() == null || o2.GetDate() == null)
            return 0;
        return o1.GetDate().compareTo(o2.GetDate());
    }

    static int getWeekOfYear(Timestamp timestamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestamp.GetDate());
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    static boolean CheckSameYear(Date d1, Date d2)
    {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }
}

class WeekComparator implements Comparator<Timestamp> {

    @Override
    public int compare(Timestamp o1, Timestamp o2)
    {
        if (o1.GetDate() == null || o2.GetDate() == null)
            return 0;
        return o1.GetDate().compareTo(o2.GetDate());
    }
}