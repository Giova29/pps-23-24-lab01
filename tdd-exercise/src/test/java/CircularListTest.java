import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    public void createList(){
        circularList = new CircularListImpl();
    }

    @Test
    public void testIsEmpty(){
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testNext(){
        final int v = 5;
        this.circularList.add(v);
        assertEquals(Optional.of(v), this.circularList.next());
    }

    @Test
    public void testNextWithEmptyList(){
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    public void testPrevious(){
        final int v1 = 15;
        final int v2 = 8;
        this.circularList.add(v1);
        this.circularList.add(v2);
        this.circularList.next();
        this.circularList.next();
        assertEquals(Optional.of(v1), this.circularList.previous());
    }

    @Test
    public void testNextOnLastElement(){
        final int v1 = 15;
        final int v2 = 8;
        this.circularList.add(v1);
        this.circularList.add(v2);
        this.circularList.next();
        this.circularList.next();
        this.circularList.next();
        assertEquals(Optional.of(v1), this.circularList.next());
    }

    @Test
    public void testPreviousOnFirstElement(){
        final int v1 = -3;
        final int v2 = 18;
        this.circularList.add(v1);
        this.circularList.add(v2);
        assertEquals(Optional.of(v2), this.circularList.previous());
    }

}
