package org.exampledana;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BirthdayTest {
    @Test
    public void receivingDataWorks(){
        Persons personsTest=new Persons();
        String inputTestString="Ion, Radu, 2000, 11, 10\n"+"Adela, Radu, 2002, 11, 15\n"+ "Andrei, Bob,1985,06,20\n";
        List<String> inputTest=new ArrayList<>();
        inputTest.addAll(Arrays.asList(inputTestString.split("\n")));

        Main.receiveDataFromFile(inputTest,personsTest);
        Assertions.assertTrue(personsTest.getPersons().size()==3);
    }
    @Test
    public void sortPersonsBornInTheSameMonthWorks(){
        String inputTestString="Ion, Radu, 2000, 11, 10\n"+"Adela, Radu, 2002, 11, 15\n"+ "Andrei, Bob,1985,06,20\n";
        List<String> inputTest=new ArrayList<>();
        inputTest.addAll(Arrays.asList(inputTestString.split("\n")));
        Persons personsTest=new Persons();
        Main.receiveDataFromFile(inputTest,personsTest);
        String expectedOutputString= "ADELA RADU\n" + "ION RADU";
        List<String> expectedOutput=new ArrayList<>();
        expectedOutput.addAll(Arrays.asList(expectedOutputString.split("\n")));
        Assertions.assertEquals(expectedOutput, Main.sortPersonsBornInTheSameMonth(personsTest,11));
    }

}
