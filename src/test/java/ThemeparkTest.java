import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeparkTest {

    ThemePark themePark;
    private TobaccoStall tobaccoStall;
    private IceCreamStall iceCreamStall;
    private Dodgems dodgems;
    private Visitor parent;
    private Visitor child;
    private Park park;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;


    @Before
    public void before() {

        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 6);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 10);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 2);
        parent = new Visitor(29, 210, 20);
        child  = new Visitor (10,50, 5);
        themePark = new ThemePark();
    }

    @Test
    public void addDodgems(){
        themePark.addAttraction(dodgems);
        assertEquals( 1, themePark.getAttractionsCount());
    }

    @Test
    public void addTobaccoStall(){
        themePark.addStall(tobaccoStall);
        assertEquals( 1, themePark.getStallsCount());
    }

    @Test
    public void getAllReviewed(){
        themePark.addAttraction(dodgems);
        themePark.addAttraction(park);
        themePark.addAttraction(playground);
        themePark.addStall(tobaccoStall);
        themePark.addStall(iceCreamStall);
        themePark.addStall(candyflossStall);
        ArrayList<IReviewed> reviewed = themePark.getReviewed();
        assertEquals(6, reviewed.size());
    }

    @Test
    public void canVisit(){
        themePark.visit(parent, dodgems);
        assertEquals(1, parent.getAttractionCount());
        assertEquals( 1, dodgems.getVisitCount());
    }

    @Test
    public void getReviews() {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        themePark.addAttraction(dodgems);
        themePark.addAttraction(park);
        themePark.addAttraction(playground);
        themePark.addAttraction(rollerCoaster);
        result.put("Bumper Cars", 5);
        result.put("Leafy Meadows", 9);
        result.put("Fun Zone", 7);
        result.put("Blue Ridge", 10);
        assertEquals(result, themePark.allReviews());
    }
}
