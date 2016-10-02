package ttl_democlientdesktop;

import java.util.Random;

public class Measurements {
    enum dataProfile{
        high
        ,averageminus
        ,average
        ,averageplus
        ,low
        
    }
    private float accX,accY,accZ, lastX,lastY,lastZ;
    private double lon,lat, lastLon,lastLat ;
    
    public Measurements(float x,float y, float z) {
        accX = x ;
        accY = y ;
        accZ = z ;
        lon = 0 ;
        lat = 0 ;
    }
    public Measurements() {
        setX((float)(random.nextInt(8000)-4000)/100) ;
        setY((float)(random.nextInt(8000)-4000)/100) ;
        setZ((float)(random.nextInt(8000)-4000)/100) ;
        setLat((double)(random.nextInt(100000000)));
        setLon((double)(random.nextInt(100000000)));
    }
    
    
    public void setLat(double lat) {
        this.lat = lat;
    }
    
    public void setLon(double lon) {
        this.lon = lon;
    }
    
    public double getLat() {
        return lat;
    }
    
    public double getLon() {
        return lon;
    }
    
    public void setX(float x) {
        this.accX = x;
    }
    
    public void setY(float y) {
        this.accY = y;
    }
    
    public void setZ(float z) {
        this.accZ = z;
    }
    
    public float getX() {
        return accX;
    }
    
    public float getY() {
        return accY;
    }
    
    public float getZ() {
        return accZ;
    }
    static Random random = new Random(800000000) ;
    
    public void updateValuesFromTextFile(String line)
    {
        String[] array = line.split("|") ;
        //debugPrintValues();
        
        System.out.println(array[1]);
        accX = Float.parseFloat(array[1]) ;
         System.out.println(array[2]);
        accY = Float.parseFloat(array[2]) ;
         System.out.println(line);
        accZ = Float.parseFloat(array[3]) ;
         System.out.println(line);
        lat = Double.parseDouble(array[4]) ;
         System.out.println(line);
        lon = Double.parseDouble(array[5]) ;
         System.out.println(line);
        
    }
    
    public void debugPrintValues()
    {
        System.out.print("Readed: "+getX()+" + "+getY()+" + "+getZ()+" + "+getLat()+" + "+getLon()+"\n") ;
    }
    
    public void updateWithGenerateValues(dataProfile dp,boolean stamatimeno)
    {
        
        if (!stamatimeno)
        {
            setLat((double)(random.nextInt(100000000)));
            setLon((double)(random.nextInt(100000000)));
            lastX = 0 ;
            lastY = 0 ;
            lastZ = 0 ;
            
        }
        else
        {
            lastX = accX ;
            lastY = accY ;
            lastZ = accZ ;
        }
        switch(dp)
        {
            case low:
                setX((float)(random.nextInt(400)-200)/100) ;
                setY((float)(random.nextInt(400)-200)/100) ;
                setZ((float)(random.nextInt(400)-200)/100) ;
                break ;
            case averageminus:
                setX((float)(random.nextInt(800)-400)/100) ;
                setY((float)(random.nextInt(800)-400)/100) ;
                setZ((float)(random.nextInt(800)-400)/100) ;
                break ;
            case average:
                setX((float)(random.nextInt(1800)-900)/100) ;
                setY((float)(random.nextInt(1800)-900)/100) ;
                setZ((float)(random.nextInt(1800)-900)/100) ;
                break ;
            case averageplus:
                setX((float)(random.nextInt(2600)-1300)/100) ;
                setY((float)(random.nextInt(2600)-1300)/100) ;
                setZ((float)(random.nextInt(2600)-1300)/100) ;
                break ;
            case high:
                setX((float)(random.nextInt(40000)-2000)/100) ;
                setY((float)(random.nextInt(40000)-2000)/100) ;
                setZ((float)(random.nextInt(40000)-2000)/100) ;
                break ;
        }
    }
}
