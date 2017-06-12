package Pts4.Classes;

import java.util.HashMap;

/**
 * Created by myron on 12-06-17.
 */
public class ProjectBean
{
    private String projectID;
    private HashMap<String, Integer> PersonHours;

    public String getProjectID()
    {
        return projectID;
    }

    public HashMap<String, Integer> getPersonHours()
    {
        return PersonHours;
    }

    public ProjectBean(String projectID)
    {
        this.projectID = projectID;
    }

    public void addtoPersonHours(String person, Integer hours)
    {
        PersonHours.put(person, hours);
    }


}
