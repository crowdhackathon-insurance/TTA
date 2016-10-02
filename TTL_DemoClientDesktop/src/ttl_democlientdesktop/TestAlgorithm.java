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
    public static float pagkosmiaStatheraEpitaxinsisSigrousis = (float)18.387 ;
    
    public static void main(String args[]) {
        BufferedReader in;
        try {
            Globals.init();
            Globals.glStartForm = new frmStart(false) ;
            File f = new File(Globals.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            File runFolder = new File(f.getAbsolutePath()+"/ttl_other/dummyDataAccident.txt");
            //File runFolder = new File(f.getAbsolutePath()+"/ttl_other/dummyDataNormal.txt");
            
            in = new BufferedReader(new FileReader(runFolder));
            
            Measurements meas = new Measurements();
            String line;
            
            while((line = in.readLine()) != null)
            {
                meas.updateValuesFromTextFile(line);
                meas.debugPrintValues();
                
                if(((meas.getX()>pagkosmiaStatheraEpitaxinsisSigrousis) ||
                        (meas.getY()>pagkosmiaStatheraEpitaxinsisSigrousis) ||
                        (meas.getZ()>pagkosmiaStatheraEpitaxinsisSigrousis) &&
                        (meas.getLat()==meas.getLastLat()) &&
                        (meas.getLastLon()==meas.getLastLon())))
                {
                    Globals.glQuestionForm.setVisible(true);
                    Globals.glQuestionForm.enableProgressBar();
                    break ;
                }
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
