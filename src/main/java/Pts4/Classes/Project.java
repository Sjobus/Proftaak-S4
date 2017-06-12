package Pts4.Classes;

import Pts4.Database.dbPerson;
import Pts4.Database.dbProject;

import java.util.ArrayList;

/**
 * Created by Gebruiker on 20-3-2017.
 */
public class Project {

    private String ID;
    private String Description;

    public String GetID() {return this.ID; }
    public void SetID(String n) {this.ID = n; }

    public String GetDescription() {return this.Description; }
    public void SetDescription(String n) {this.Description = n; }

    public Project(String ID, String Description)
    {
        this.ID = ID;
        this.Description = Description;
    }

    public Project(String ID)
    {
        this.ID = ID;
    }


    public ArrayList<Project> GetProject()
    {
        ArrayList<Project> list = dbProject.GetAllProjects();
        return list;
    }

    public static ArrayList<Project> GetAllProjects()
    {
        ArrayList<Project> ProjectList = dbProject.GetAllProjects();
        if(ProjectList != null)
        {
            return ProjectList;
        }
        else
        {
            return null;
        }
    }

    public boolean Getproject()
    {
        Project pro = dbProject.GetprojectID(this);
        if(pro != null)
        {
            this.Description = pro.Description;
            return true;
        }
        else
        {
            return false;
        }
    }

    //Old algorithm
    public static ArrayList<Project> GetTopProjects(Object object)
    {
        Person p = (Person)object;
        ArrayList<Project> toplist = dbProject.GetTop(p.GetID());
        if(toplist != null)
        {
            return toplist;
        }
        else
        {
            return null;
        }
    }

    public static ArrayList<Project> GetBottomProjects(Object object)
    {
        Person p = (Person)object;
        ArrayList<Project> toplist = dbProject.GetTheRest(p.GetID());
        if(toplist != null)
        {
            return toplist;
        }
        else
        {
            return null;
        }
    }


    //New algorithm
    public static ArrayList<Project> GetTopMostLikely(Object object)
    {
        Person p = (Person)object;
        ArrayList<Project> toplist = dbProject.GetTopMostLikely(p);
        if(toplist != null)
        {
            return toplist;
        }
        else
        {
            return null;
        }
    }

    public static ArrayList<Project> GetBottomMostLikely(Object object)
    {
        Person p = (Person)object;
        ArrayList<Project> toplist = dbProject.GetTheRestLikely(p);
        if(toplist != null)
        {
            return toplist;
        }
        else
        {
            return null;
        }
    }

    public static Project GetMostlikely(Object object)
    {
        Person p = (Person)object;
        Project project = dbProject.GetMostLikely(p);
        if(project != null)
        {
            return project;
        }
        else
        {
            return null;
        }
    }

    @Override
    public String toString()
    {
        return ID;
    }
}
