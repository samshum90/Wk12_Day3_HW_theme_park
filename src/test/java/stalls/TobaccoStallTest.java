package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor child;
    Visitor parent;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 2);
        parent = new Visitor(29, 195, 20);
        child  = new Visitor (10,50, 5);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void parentIsAllowedTo(){
        assertTrue(tobaccoStall.isAllowedTo( parent ));
    }

    @Test
    public void childIsAllowedTo(){
        assertFalse(tobaccoStall.isAllowedTo( child ));
    }
}
