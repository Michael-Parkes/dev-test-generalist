package Bikes;

import java.util.concurrent.ThreadLocalRandom;
/**
 * Abstract class ABike - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class ABike implements IBike
{
    double speed = ThreadLocalRandom.current().nextDouble(0.005, 0.05);
    //public AFish(){}
    public void add(){}
    public void Update(double[] pLocation, double[] pRotation){}
}
