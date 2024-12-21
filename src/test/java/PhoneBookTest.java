import org.example.PhoneBook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
    @RepeatedTest(2)
    public void testAdd_result() {
        final String name = "TestName";
        final long number = 999999999L;
        final int original = 1;
        final int result = PhoneBook.add(name, number);
        assertEquals(original, result);
    }
    @Test
    public void testFindByNumber() {
        final String original = "TestName";
        final long number = 999999999L;
        PhoneBook.phoneBook.put("TestName", 999999999L);
        final String result = PhoneBook.findByNumber(number);
        assertEquals(original, result);
    }
    @Test
    public void testFindByName() {
        final String name = "TestName";
        final long original = 999999999L;
        final long result = PhoneBook.findByName(name);
        assertEquals(original, result);
    }

    private final PrintStream standartOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testPrintAllNames() {
        PhoneBook.printAllNames();
        assertEquals("TestName", outputStreamCaptor.toString().trim());
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standartOut);
    }

}
