package Bikes;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a description of class BikeFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BikeFactory
{
    public static IBike getBike(String bikeType)
    {
        if(bikeType == null)
        {
            return null;
        }
        if(bikeType.equalsIgnoreCase("LIGTHENINGC68"))
        {
            return new LighteningC68("textures/javaFish/JavaFish.png", ThreadLocalRandom.current().nextDouble(1, 9), ThreadLocalRandom.current().nextDouble(1, 7), ThreadLocalRandom.current().nextDouble(1, 1.5));
        }
        else if(bikeType.equalsIgnoreCase("LIGTHENINGC62"))
        {
            return new LighteningC62("textures/javaFish/Urchin.png", ThreadLocalRandom.current().nextDouble(1, 9), ThreadLocalRandom.current().nextDouble(1, 1.1) , ThreadLocalRandom.current().nextDouble(1, 1.5));
        }
        
        else if(bikeType.equalsIgnoreCase("AGREEC62"))
        {
            return new AgreeC62("textures/javaFish/SeaHorse.png", ThreadLocalRandom.current().nextDouble(1, 9), ThreadLocalRandom.current().nextDouble(1, 7) , ThreadLocalRandom.current().nextDouble(1, 1.5));
        }
        else if(bikeType.equalsIgnoreCase("ATTAINGTC"))
        {
            return new AttainGTC("textures/javaFish/Piranha1.png", ThreadLocalRandom.current().nextDouble(1, 9), ThreadLocalRandom.current().nextDouble(1, 7),ThreadLocalRandom.current().nextDouble(1, 1.5));
        }  
        else if(bikeType.equalsIgnoreCase("ATTAINHPA"))
        {
            return new AttainHPA("textures/javaFish/OrangeFish.png", ThreadLocalRandom.current().nextDouble(1, 9), ThreadLocalRandom.current().nextDouble(1, 7),ThreadLocalRandom.current().nextDouble(1, 1.5));
        }
         else if(bikeType.equalsIgnoreCase("CROSSRACE"))
        {
            return new CrossRace("textures/javaFish/OrangeFish.png", ThreadLocalRandom.current().nextDouble(1, 9), ThreadLocalRandom.current().nextDouble(1, 7),ThreadLocalRandom.current().nextDouble(1, 1.5));
        }
         else if(bikeType.equalsIgnoreCase("SLROAD"))
        {
            return new SLRoad("textures/javaFish/OrangeFish.png", ThreadLocalRandom.current().nextDouble(1, 9), ThreadLocalRandom.current().nextDouble(1, 7),ThreadLocalRandom.current().nextDouble(1, 1.5));
        }
        return null;
    }
}
