package ttl_democlientdesktop;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class GenerateDummyData {
    Measurements meas = new Measurements() ;
    BufferedWriter writer = null;
    
    public static void main(String args[]) {
        GenerateDummyData d = new GenerateDummyData() ;        
        //d.prepareWriter("/home/michael/Desktop/dummyDataNormal.txt");
        d.prepareWriter("/home/michael/Desktop/dummyDataAccident.txt");        
        //d.kanonikoSenario();
        d.senarioAtyximatos() ;
    }
    private void kanonikoSenario()
    {
        for(int i=0;i<1500;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.low, false);
            write(meas);
        }       
        for(int i=0;i<2400;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.averageminus, false);
            write(meas);
        }       
        for(int i=0;i<3000;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.average, false);
            write(meas);
        }       
        for(int i=0;i<1000;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.averageminus, false);
            write(meas);
        }       
        for(int i=0;i<2000;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.low, false);
            write(meas);
        }       
    }
     private void senarioAtyximatos()
    {
        for(int i=0;i<1000;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.low, false);
            write(meas);
        }       
        for(int i=0;i<2400;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.averageminus, false);
            write(meas);
        }       
        for(int i=0;i<2000;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.averageplus, false);
            write(meas);
        }       
        for(int i=0;i<4000;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.high, true);
            write(meas);
        }       
        for(int i=0;i<2000;i++)
        {
            meas.updateWithGenerateValues(Measurements.dataProfile.low, true);
            write(meas);
        }       
    }  
    private void prepareWriter(String path)
    {
        
        try {
            writer = new BufferedWriter(new FileWriter(path));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                //writer.close();
            } catch (Exception e) {
            }
        }
    }
    private void write(Measurements meas)
    {
        System.out.print(meas.getX()+"|"+meas.getY()+"|"+meas.getZ()+"|"+meas.getLat()+"|"+meas.getLon()+"\n") ;
        try {
            writer.write(meas.getX()+"|"+meas.getY()+"|"+meas.getZ()+"|"+meas.getLat()+"|"+meas.getLon()+"\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                // writer.close();
            } catch (Exception e) {
            }
        }
    }
}
