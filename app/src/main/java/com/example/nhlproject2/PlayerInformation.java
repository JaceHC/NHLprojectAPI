package com.example.nhlproject2;

import java.util.ArrayList;

public class PlayerInformation {

    public String copyright;
    public ArrayList<Person> people;


    public class CurrentTeam{
        public int id;
        public String name;
        public String link;
    }

    public class PrimaryPosition{
        public String code;
        public String name;
        public String type;
        public String abbreviation;
    }

    public class Person{
        public int id;
        public String fullName;
        public String link;
        public String firstName;
        public String lastName;
        public String primaryNumber;
        public String birthDate;
        public int currentAge;
        public String birthCity;
        public String birthStateProvince;
        public String birthCountry;
        public String nationality;
        public String height;
        public int weight;
        public boolean active;
        public boolean alternateCaptain;
        public boolean captain;
        public boolean rookie;
        public String shootsCatches;
        public String rosterStatus;
        public CurrentTeam currentTeam;
        public PrimaryPosition primaryPosition;
    }




}
