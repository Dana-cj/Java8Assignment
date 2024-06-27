package org.exampledana;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Persons persons = new Persons();
        List<String> input=new ArrayList<>();
        try {
             input.addAll(Files.readAllLines(Paths.get("src/main/input.txt")));
             receiveDataFromFile(input, persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scan = new Scanner(System.in);
        int month = 0;
        boolean inputIsCorrect = false;
        do {
            System.out.println("Chose target month in which the persons are born: ");
            try {
                month = Integer.parseInt(scan.nextLine());
                if (month < 1 || month > 12) {
                    throw new IllegalArgumentException("Invalid month!");
                }
                inputIsCorrect = true;
            } catch (IllegalArgumentException exception) {
                System.out.println("Month must be a number between 1 and 12! Try again!");
            }
        } while (!inputIsCorrect);
        int finalMonth = month;

        List<String> sortedPersons = sortPersonsBornInTheSameMonth(persons, finalMonth);
        System.out.println(sortedPersons);
        sentListOfSortedPersons(sortedPersons);
    }

    public static void receiveDataFromFile(List<String> input, Persons persons) {
        for (String line: input) {
        // System.out.println(line);
        String[] lineArr= line.replace(" ","").split(",");
        String firstName= lineArr[0];
        String lastName= lineArr[1];
        int year= Integer.parseInt(lineArr[2]);
        int month= Integer.parseInt(lineArr[3]);
        int day= Integer.parseInt(lineArr[4]);
        persons.addPerson(firstName,lastName,year,month,day);
         }
    }

    public static List<String> sortPersonsBornInTheSameMonth(Persons persons, int finalMonth) {
        List<String> sortedPersons = persons.getPersons()
                .stream()
                .filter(person -> person.getMonthOfBirth() == finalMonth)
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.toList());
        return sortedPersons;
    }

    public static void sentListOfSortedPersons(List<String> sortedPersons) {
        try {
            Files.write(Path.of("src/main/output.txt"), sortedPersons);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
