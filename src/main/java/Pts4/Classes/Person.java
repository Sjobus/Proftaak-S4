package Pts4.Classes;

import Pts4.Database.DatabaseConnection;
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

    public Person(int id, String name, Function function)
    {
        this.ID = id;
        this.Name = name;
        this.function = function;
    }

    public Person(String name)
    {
        this.Name = name;
    }









}
