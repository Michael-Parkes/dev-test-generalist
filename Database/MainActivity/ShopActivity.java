package MainActivity;

import env3d.Env;
import jff5.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Write a description of class ShopActivity here.
 * 
 * @author Michael Parkes 
 * @version 2.2
 */
public class ShopActivity
{
    // DECLARE a reference to the instance of the Core class, call it '_core':
    private Core _core;
    
    // DECLARE a reference to the instance of the 'Env' (environment) class, call it '_world':
    private Env _world;
    // DECLARE a reference to the instance of the 'ShopManager' class, call it '_shop':
    private ShopManager _shop;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    /**
     * Constructor for objects of class ShopActivity
     */
    public static void main(String[] args)
    {
        ShopActivity shop = new ShopActivity();
        shop.populate();
        shop.run();
    }
    /**
     * The Shop activity class directly links with the ShopManager class. I have done this to reduce the strain
     * on the main executable class
     */
    public ShopActivity()
    {
        _core = new Core();
        _shop = new ShopManager();
    }
    
    public void populate()
    {
        _shop.populate();
    }

    public void run()
    {
        _shop.run();
    }
}
