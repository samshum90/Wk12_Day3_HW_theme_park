import attractions.Attraction;
import attractions.Dodgems;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark() {
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
    }

    public int getAttractionsCount() {
        return this.attractions.size();
    }

    public int getStallsCount() {
        return this.stalls.size();
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

    public void addStall(Stall stall) {
        this.stalls.add(stall);
    }

    public ArrayList<IReviewed> getReviewed() {
        ArrayList<IReviewed> reviews= new ArrayList<IReviewed>();
        reviews.addAll(this.attractions);
        reviews.addAll(this.stalls);
        return reviews;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        attraction.addOneVisitCount();
        visitor.addVisitedAttraction(attraction);
    }

    public HashMap<String, Integer> allReviews(){
        HashMap<String, Integer> reviews = new HashMap<String, Integer>();;

        for (IReviewed reviewed: getReviewed() ){
            reviews.put(reviewed.getName(), reviewed.getRating());
        }

        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
        ArrayList<IReviewed> allowed= new ArrayList<IReviewed>();
        for (Attraction attraction : this.attractions){
            if (attraction.isAllowedTo(visitor)){

            }
        }

        return allowed;
    }
}
