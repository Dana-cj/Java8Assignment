package org.exampledana;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person implements Serializable {
   // private static final long serialVersionUID = 1l;
    private String firstName;
    private String lastName;
    private  GregorianCalendar dateOfBirth;


    public Person(String firstName, String lastName, int year, int month, int day) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = new GregorianCalendar(year, (month-1), day);
    }

    public String getLastName() {
        return lastName.toUpperCase();
    }

    public String getFirstName() {
        return firstName.toUpperCase();
    }

    protected int getMonthOfBirth(){
       return dateOfBirth.get(Calendar.MONTH)+1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth.toZonedDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                '}';
    }
}
