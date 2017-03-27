package Pts4.Classes;

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
}
