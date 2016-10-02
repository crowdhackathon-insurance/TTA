package ttl_democlientdesktop;

import java.util.Random;

public class Accelerator {
    private float x,y,z ;
    
    public Accelerator(float x,float y, float z) {
        this.x = x ;
        this.y = y ;
        this.z = z ;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public void setY(float y) {
        this.y = y;
    }
    
    public void setZ(float z) {
        this.z = z;
    }
    
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public float getZ() {
        return z;
    }
    static Random random = new Random(80) ;
    static public Accelerator generateValues()
    {
        Accelerator acc = new Accelerator(0, 0, 0) ;
        
        acc.setX((float)(random.nextInt(8000)-4000)/100) ;
        acc.setY((float)(random.nextInt(8000)-4000)/100) ;
        acc.setZ((float)(random.nextInt(8000)-4000)/100) ;
        
        return acc ;
    }
    
    
    
}
