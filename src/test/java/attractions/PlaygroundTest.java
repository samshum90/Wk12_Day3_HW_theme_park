package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;
    Visitor parent;
    Visitor child;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        parent = new Visitor(29, 195, 20);
        child  = new Visitor (10,50, 5);

    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void parentIsAllowedTo(){
        assertFalse(playground.isAllowedTo( parent ));
    }

    @Test
    public void childIsAllowedTo(){
        assertTrue(playground.isAllowedTo( child ));
    }
}
