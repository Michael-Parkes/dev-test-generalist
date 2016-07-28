package MainActivity;
import env3d.Env;
import jff5.*;
import Bikes.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Shop Manager has been created to take the strain off the ShopActivity class which is our main class. Within this class i add the textures to the environment. 
 * This will also create the enviroment.
 * 
 * @author Michael Parkes
 * @version 2.0
 */
public class ShopManager
{
    // instance variables:
    // DECLARE a reference to the instance of the Core class, call it '_core':
    private Core _core;
    
    // DECLARE a reference to the instance of the 'Env' (environment) class, call it '_world':
    private Env _world;
    // DECLARE a reference to the instance of the 'ShopManager' class, call it '_shop':
    private ShopManager _shop;
    // DECLARE a reference to the instance of the array list created in the Bike Factory, call it _factory:
    protected ArrayList<IBike> _factory;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;

    /**
     * Constructor for objects of class ShopManager
     *
     * TEST: Before linking to the ShopActivity class i tested the ShopManager as the main class file.
     */
    public ShopManager()
    {
        // INITIALISE instance variables:
        _core = new Core();
        _factory = new ArrayList<IBike>();
    }
    
    public void populate()
    {
        /**
         * I will be using FOREACH loops for spawn all tokens.
         * All positions will be random
         * ADD: Bike is called
         */
        float offset = 1.5f;
        BikeFactory bikeFactory = new BikeFactory();
        for(int i=0; i<1; i++)
        {
            IBike bike1 = bikeFactory.getBike("LIGTHENINGC68");
            addBike(bike1);
        }
    
        for(int i=0; i<1; i++)
        {
            IBike bike2 = bikeFactory.getBike("LIGTHENINGC62");
            addBike(bike2);
        }
        
        for(int i=0; i<1; i++)
        {
            IBike bike3 = bikeFactory.getBike("AGREEC62");
            addBike(bike3);
        }
        
        for(int i=0; i<1; i++)
        {
            IBike bike4 = bikeFactory.getBike("ATTAINGTC");
            addBike(bike4);
        }
        
        for(int i=0; i<1; i++)
        {
            IBike bike5 = bikeFactory.getBike("ATTAINHPA");
            addBike(bike5);
        }
        
        for(int i=0; i<1; i++)
        {
            IBike bike5 = bikeFactory.getBike("CROSSRACE");
            addBike(bike5);
        }
        
        for(int i=0; i<1; i++)
        {
            IBike bike5 = bikeFactory.getBike("SLROAD");
            addBike(bike5);
        }
    }
    
    public void addBike(IBike pBike)
    {
        if (pBike != null)
           _factory.add(pBike); 
    }
    
    /**
     * METHOD: Run the ShopManager loop.  User presses escape to exit.
     *
     */
    
    public void run()
    {
        // CREATE the environment:
        _world = _core.createWorld();
        
        // ADD Tokens to 3D world:
        for(IBike bike : _factory)
            _world.addObject(bike);

        // Start simulation loop:
        while (!endSim)
        {
            // UPDATE STAGE:
            // IF: user has requested simulation loop exit (ie escape pressed):
            if (_world.getKey() == 1)
            {
                // SET: render loop exit condition
                endSim = true;
            }
            double[] pLoc = {0,0,0};
            double[] pRot = {0,0,0};
            // UPDATE: the environment
            _core.updateWorld();
        }
        
        // EXIT: cleanly by closing-down the environment:
        _core.destroyWorld();
    }
}
