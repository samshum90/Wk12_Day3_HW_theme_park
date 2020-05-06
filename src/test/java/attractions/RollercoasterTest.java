package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest{

    RollerCoaster rollerCoaster;
    Visitor parent;
    Visitor child;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        parent = new Visitor(29, 210, 20);
        child  = new Visitor (10,50, 5);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void parentIsAllowedTo(){
        assertTrue(rollerCoaster.isAllowedTo( parent ));
    }

    @Test
    public void childIsAllowedTo(){
        assertFalse(rollerCoaster.isAllowedTo( child ));
    }

    @Test
    public void testDefaultPrice(){
        assertEquals( 2.80, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void priceForParent(){
        assertEquals(16.80, rollerCoaster.priceFor( parent ), 0.01 );
    }
    @Test
    public void priceForChild(){
        assertEquals(8.40, rollerCoaster.priceFor( child ), 0.01 );
    }
}
