package Pts4.Classes;

import java.util.Date;

/**
 * Created by Gebruiker on 20-3-2017.
 */
public class Timestamp {

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




}
