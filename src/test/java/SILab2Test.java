import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        //TC1
        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "1234567812345678"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        //TC2
        List<Item> items2 = List.of(new Item(null, 1, 100, 0.0));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items2, "1234567812345678"));
        assertEquals("Invalid item!", ex2.getMessage());

        //TC3
        List<Item> items3 = List.of(new Item("Bread", 1, 100, 0.0));
        RuntimeException ex3 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items3, "12345678abcd5678"));
        assertEquals("Invalid character in card number!", ex3.getMessage());

        //TC4
        RuntimeException ex4 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items3, "1234"));
        assertEquals("Invalid card number!", ex4.getMessage());

        //TC5
        List<Item> items5 = List.of(new Item("Phone", 1, 350, 0.2));
        double result5 = SILab2.checkCart(items5, "1234567812345678");
        assertEquals((350 * (1 - 0.2)) * 1 - 30, result5);

        //TC6
        List<Item> items6 = List.of(new Item("Milk", 1, 100, 0.0));
        double result6 = SILab2.checkCart(items6, "1234567812345678");
        assertEquals(100, result6);
    }

    @Test
    public void testMultipleCondition() {
        //TC1
        Item i1 = new Item("Item1", 1, 100, 0.0);
        double r1 = SILab2.checkCart(List.of(i1), "1234567812345678");
        assertEquals(100, r1);

        //TC2
        Item i2 = new Item("Item2", 1, 301, 0.0);
        double r2 = SILab2.checkCart(List.of(i2), "1234567812345678");
        assertEquals(301 - 30, r2);

        //TC3
        Item i3 = new Item("Item3", 1, 100, 0.1);
        double r3 = SILab2.checkCart(List.of(i3), "1234567812345678");
        assertEquals(100 * (1 - 0.1) - 30, r3);

        //TC4
        Item i4 = new Item("Item4", 11, 100, 0.0);
        double r4 = SILab2.checkCart(List.of(i4), "1234567812345678");
        assertEquals(100 * 11 - 30, r4);
    }
}
