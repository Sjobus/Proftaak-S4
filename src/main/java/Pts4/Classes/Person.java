package Pts4.Classes;

import Pts4.Database.DatabaseConnection;
import Pts4.Database.dbPerson;
import Pts4.Enums.Function;

/**
 * Created by Gebruiker on 20-3-2017.
 */
public class Person {

    private int ID;
    private String Name;
    private Function function;

    public int GetID() {return this.ID; }
    public void SetID(int n) { this.ID = n; }

    public String GetName() {return this.Name; }
    public void SetName(String n) { this.Name = n; }

    public Function GetFunction() {return this.function; }
    public void SetFunction(Function n) { this.function = n; }

    public Person()
    {

    }

    public Person(int id, String name, Function function)
    {
        this.ID = id;
        this.Name = name;
        this.function = function;
    }

    public Person GetPersonData(String prName, String prPassword)
    {
        Person per = dbPerson.GetpersonData(prName, prPassword);
        if(per != null)
        {
            ID = per.GetID();
            Name = per.GetName();
            function = per.GetFunction();
            return per;
        }
        else
        {
            return null;
        }
    }

       public Person GetGooglePersonData(int googleID)
      {
           Person per = dbPerson.GetpersonDataByGoogleID(googleID);

         if(per != null)
         {
              ID = per.GetID();
              Name = per.GetName();
              function = per.GetFunction();
              return per;
         }
         else
         {
              return null;
          }
      }

    public Function Translatefunction(String function)
    {
        Function Func = Function.Werknemer;

        switch (function) {
            case "Beheerder":
                Func = Function.Beheerder;
                break;
            case "Werknemer":
                Func = Function.Werknemer;
                break;

        }
        return Func;
    }

    public Person(String name)
    {
        this.Name = name;
    }









}
