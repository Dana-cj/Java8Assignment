package org.exampledana;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persons implements Serializable {
   // private static final long serialVersionUID = 1l;
    private List<Person> persons;

    public Persons(){
        this.persons= new ArrayList<>();
    }

    public void addPerson(Person person){
        persons.add(person);
    }
    public void addListOfPersons(List<Person> newPersons){
        this.persons.addAll(newPersons);

    }

    public void addPerson(String firstName, String lastName, int year, int month, int day){
        persons.add(new Person(firstName,lastName,year, month, day));
    }
    public List<Person> getPersons() {
        List<Person> copy= new ArrayList<>();
        copy.addAll(persons);
        return copy;
    }
    public void printPersons(){
        persons.forEach(System.out::println);
    }
}
