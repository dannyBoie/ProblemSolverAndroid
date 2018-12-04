
package domains.farmer;

import framework.problem.State;
import java.util.Objects;


public class FarmerState implements State {

    public FarmerState(String farmer, String wolf, String goat, String cabbage)
    {
        this.farmer = farmer;
        this.wolf = wolf;
        this.goat = goat;
        this.cabbage = cabbage;
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        else if (other.getClass() != this.getClass())
        {
            return false;
        }
        else return cabbage.equals(((FarmerState)other).getCabbage())&&
                    ((FarmerState)other).getWolf().equals(wolf)&&
                    ((FarmerState)other).getFarmer().equals(farmer)&&
                    ((FarmerState)other).getGoat().equals(goat);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.farmer);
        hash = 67 * hash + Objects.hashCode(this.wolf);
        hash = 67 * hash + Objects.hashCode(this.goat);
        hash = 67 * hash + Objects.hashCode(this.cabbage);
        return hash;
    }

    @Override
    public String toString()
    {
        String result = "   |  |   \n";
        if (farmer.equals("West"))
        {
            result += " F |  |   \n";
        }
        else
        {
            result+= "   |  | F \n";
        }
        if (wolf.equals("West"))
        {
            result+= " W |  |   \n";
        }
        else
        {
            result+="   |  | W \n";
        }
        if (goat.equals("West"))
        {
            result+= " G |  |   \n";
        }
        else
        {
            result+="   |  | G \n";
        }
        if (cabbage.equals("West"))
        {
            result+= " C |  |   \n";
        }
        else
        {
            result+="   |  | C \n";
        }
        result += "   |  |   ";

        return result;
    }


    public String getFarmer()
    {
        return farmer;
    }

    public void setFarmer(String s)
    {
        this.farmer = s;
    }

    public String getWolf()
    {
        return wolf;
    }

    public void setWolf(String s)
    {
        this.wolf = s;
    }

    public String getGoat()
    {
        return goat;
    }

    public void setGoat(String s)
    {
        this.goat = s;
    }

    public String getCabbage()
    {
        return cabbage;
    }

    public void setCabbage(String s)
    {
        this.cabbage = s;
    }


    private String farmer = "West";
    private String wolf = "West";
    private String goat = "West";
    private String cabbage = "West";
}
