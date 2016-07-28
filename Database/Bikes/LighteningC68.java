package Bikes;


/**
 * Write a description of class LighteningC68 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LighteningC68 extends ABike
{
    // reference to 3D model
    private String model = "models/billboard/billboard.obj";
    //scale factor to be associated to model 
    private double scale = 0.37; 
    // reference to the image to be used as the texture-map
    private String texture;
  
    private boolean transparent = true;
    //position the texture to be place in the 3D world shown as x,y,z coordinates.
    private double x = 1.0, y = 1.0, z = 1.4;
    //ensures the texture is flipped and dispalying in the correct direction on start up.
    public double rotateX = 0.0, rotateY = 90, rotateZ = 0;
    
    private double FacingDirection = 1;
    
    private double speed = super.speed;
    /**
     * Constructor for objects of class Urchin
     */
    public LighteningC68(String pTexture, double xpos, double ypos, double zpos)
    {
        //SET the texture of the token
        texture = pTexture;
         
        this.x = xpos;
        this.y = ypos;
        this.z = zpos;
    }
    public void add()
    {}
     public void Update(double[] pLocation, double[] pRotation)
    {
       /**
        * METHOD: Control urchin basic movement within the aquarium 
        * also keeps the urchin within the aquarium at all times
        * keeps urchin facing the correct direction
        */
       this.x += speed * FacingDirection;
       
       if(x > 9)
       {
           x -= speed;
           FacingDirection = FacingDirection * -1;

       }
       if(x < 1)
       {
           x += speed;
           FacingDirection = FacingDirection * -1;

        }
    }
}
