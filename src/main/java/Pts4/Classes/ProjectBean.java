package Pts4.Classes;

import java.util.HashMap;

/**
 * Created by myron on 12-06-17.
 */
public class ProjectBean
{
    private String projectID;
    private HashMap<String, Integer> PersonHours = new HashMap<>();
    private int totalHours = 0;

    public String getProjectID()
    {
        return projectID;
    }

    public HashMap<String, Integer> getPersonHours()
    {
        return PersonHours;
    }

    public int getTotalHours()
    {
        return totalHours;
    }

    public ProjectBean(String projectID)
    {
        this.projectID = projectID;
    }

    public void addtoProjectHours(String person, Integer hours)
    {
        PersonHours.put(person, hours);
        totalHours += hours;
    }


}
