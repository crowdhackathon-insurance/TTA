package ttl_democlientdesktop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestAlgorithm {
    public static void main(String args[]) {
        BufferedReader in;
        try {
            File f = new File(Globals.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            File runFolder = new File(f.getAbsolutePath()+"/ttl_other/dummyDataAccident.txt");
            //System.out.println(runFolder);
            in = new BufferedReader(new FileReader(runFolder));
            //in = new BufferedReader(new FileReader("ttl_other/dummyDataNormal.txt"));
            Measurements meas = new Measurements();
            String line;
            while((line = in.readLine()) != null)
            {
                System.out.println(line);
                meas.updateValuesFromTextFile(line);
                meas.debugPrintValues();
            }
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(TestAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
