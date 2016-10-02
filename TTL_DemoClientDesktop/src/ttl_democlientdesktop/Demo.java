package ttl_democlientdesktop;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Demo {
    public static void main(String args[]) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("/home/michael/Desktop/dummyData.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                //writer.close();
            } catch (Exception e) {
            }
        }
        while(true)
        {
            Accelerator acc = Accelerator.generateValues() ;
            System.out.println("X = "+acc.getX()+" Y = "+acc.getY()+" Z = "+acc.getZ()) ;
            try {
                writer.write(acc.getX()+" "+acc.getY()+" "+acc.getZ()+"\n");
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
}
