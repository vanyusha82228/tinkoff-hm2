package edu.hw10;

import edu.hw10.task1.MyClass;
import edu.hw10.task1.MyRecord;
import edu.hw10.task1.RandomObjectGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestTask1 {
    @Test
    public void testObjectCreationUsingConstructor() throws Exception {
        RandomObjectGenerator rog = new RandomObjectGenerator();

        MyClass myClass = rog.nextObject(MyClass.class, null);

        assertNotNull(myClass);
    }

    @Test
    public void testObjectCreationUsingFactoryMethod() throws Exception {
        RandomObjectGenerator rog = new RandomObjectGenerator();

        MyClass myClassFromFactory = rog.nextObject(MyClass.class, "create");

        assertNotNull(myClassFromFactory);

    }


    @Test
    public void testObjectCreationForMyRecord() throws Exception {
        RandomObjectGenerator rog = new RandomObjectGenerator();

        MyRecord myRecord = rog.nextObject(MyRecord.class, null);

        assertNotNull(myRecord);

    }
}
