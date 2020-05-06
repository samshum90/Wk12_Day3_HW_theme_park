package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor parent;
    Visitor child;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        parent = new Visitor(29, 210, 20);
        child  = new Visitor (10,50, 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void priceForParent(){
        assertEquals(4.50, dodgems.priceFor( parent ), 0.01 );
    }
    @Test
    public void priceForChild(){
        assertEquals(2.25, dodgems.priceFor( child ), 0.01 );
    }
}
