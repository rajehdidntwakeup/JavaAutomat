package org.fogl.automat;


import org.fogl.reader.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAutomat {



    private final String filepath = "src/test/resources/testfile.txt";
    @Test
    public void testAutomatreadFromFile() {

        Assertions.assertDoesNotThrow(()-> Reader.readFromFile(filepath));

    }

}
