package behaviours;

import people.Visitor;
import attractions.Attraction;

public interface ITicketed {

    public double defaultPrice();
    public double priceFor( Visitor visitor);
}
