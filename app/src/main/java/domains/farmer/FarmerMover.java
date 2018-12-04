
package domains.farmer;

import framework.problem.State;
import framework.problem.Mover;

public class FarmerMover extends Mover{

    public static final String FARMER = "Farmer is going alone";
    public static final String WOLF = "Farmer is taking the Wolf";
    public static final String GOAT = "Farmer is taking the Goat";
    public static final String CABBAGE = "Farmer is taking the Cabbage";

    public FarmerMover()
    {
        super.addMove(FARMER, s -> goAlone(s));
        super.addMove(WOLF, s -> tryWolf(s));
        super.addMove(GOAT, s -> tryGoat(s));
        super.addMove(CABBAGE, s -> tryCabbage(s));
    }

    private State goAlone(State state)
    {
        FarmerState a = new FarmerState(((FarmerState)state).getFarmer(), ((FarmerState)state).getWolf(),
                ((FarmerState)state).getGoat(), ((FarmerState)state).getCabbage());
        if(a.getGoat().equals("West") && a.getWolf().equals("West"))
            return null;
        if(a.getGoat().equals("West")&& a.getCabbage().equals("West"))
            return null;
        if(a.getGoat().equals("East") && a.getWolf().equals("East"))
            return null;
        if(a.getGoat().equals("East")&& a.getCabbage().equals("East"))
            return null;
        //If it gets this far it changes the farmer's position
        if(a.getFarmer().equals("West"))
        {
            a.setFarmer("East");
            return a;
        }
        else
        {
            a.setFarmer("West");
            return a;
        }


    }

    private State tryWolf(State state)
    {
        FarmerState a = new FarmerState(((FarmerState)state).getFarmer(), ((FarmerState)state).getWolf(),
                ((FarmerState)state).getGoat(), ((FarmerState)state).getCabbage());
        if(a.getFarmer().equals("West") && a.getWolf().equals("East"))
            return null;
        if(a.getWolf().equals("West")&& a.getFarmer().equals("East"))
            return null;
        if(a.getGoat().equals("West") && a.getCabbage().equals("West"))
            return null;
        if(a.getGoat().equals("East")&& a.getCabbage().equals("East"))
            return null;

        if(a.getFarmer().equals("West"))
        {
            a.setFarmer("East");
        }
        else
        {
            a.setFarmer("West");
        }


        if(a.getWolf().equals("West"))
        {
            a.setWolf("East");
            return a;
        }
        else
        {
            a.setWolf("West");
            return a;
        }
    }

    private State tryGoat(State state)
    {
        FarmerState a = new FarmerState(((FarmerState)state).getFarmer(), ((FarmerState)state).getWolf(),
                ((FarmerState)state).getGoat(), ((FarmerState)state).getCabbage());
        if(a.getFarmer().equals("West") && a.getGoat().equals("East"))
            return null;
        if(a.getGoat().equals("West")&& a.getFarmer().equals("East"))
            return null;


        if(a.getFarmer().equals("West"))
        {
            a.setFarmer("East");
        }
        else
        {
            a.setFarmer("West");
        }


        if(a.getGoat().equals("West"))
        {
            a.setGoat("East");
            return a;
        }
        else
        {
            a.setGoat("West");
            return a;
        }
    }

    private State tryCabbage(State state)
    {
        FarmerState a = new FarmerState(((FarmerState)state).getFarmer(), ((FarmerState)state).getWolf(),
                ((FarmerState)state).getGoat(), ((FarmerState)state).getCabbage());
        if(a.getFarmer().equals("West") && a.getCabbage().equals("East"))
            return null;
        if(a.getCabbage().equals("West")&& a.getFarmer().equals("East"))
            return null;
        if(a.getGoat().equals("West") && a.getWolf().equals("West"))
            return null;
        if(a.getGoat().equals("East")&& a.getWolf().equals("East"))
            return null;
        //If it gets this far it changes the farmer's position
        if(a.getFarmer().equals("West"))
        {
            a.setFarmer("East");
        }
        else
        {
            a.setFarmer("West");
        }


        if(a.getCabbage().equals("West"))
        {
            a.setCabbage("East");
            return a;
        }
        else
        {
            a.setCabbage("West");
            return a;
        }
    }

    private State illegalMove(State state) {
        FarmerState s = new FarmerState(((FarmerState)state).getFarmer(), ((FarmerState)state).getWolf(),
                ((FarmerState)state).getGoat(), ((FarmerState)state).getCabbage());
        return null;

    }
}
