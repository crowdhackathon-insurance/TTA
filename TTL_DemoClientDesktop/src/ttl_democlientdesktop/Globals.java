package ttl_democlientdesktop;

import java.util.Random;
import javax.swing.JFrame;

public class Globals {
    static String glName = "Mich" ;
    static String glSurame = "Gall" ;
    static String glPhone = "6980751345" ;
    static String glContract = "AM 1294837" ;
    static String glCin1 = "23.3234543534" ;
    static String glCin2 = "67.2131231233" ;
    
    static frmStart glStartForm ;
    static frmSettings glSettingsForm ;
    static frmQuestion glQuestionForm ;
    static frmAlarm glAlarmForm ;
    static frmHelp glHelpForm ;
    
    static java.util.Timer timer = new java.util.Timer(); ;
    //static String address = "192.168.177.71";
    static String address = "localhost";
    static ManageSocket ms ;
    
    static String getSocketMessage()
    {
        String tmpMess = "#SOS" ;
        tmpMess+="#" + glName ;
        tmpMess+="#" + glSurame;
        tmpMess+="#" + glPhone ;
        tmpMess+="#" + glContract;
        tmpMess+="#" + glCin1 ;
        tmpMess+="#" + glCin2 +"#";
        
        return tmpMess ;
    }
    
    static String createSocketMessageBIOMetric(String sfigmos,String piesi)
    {
        String tmpMess = "@BIOMetric" ;
        tmpMess+="@" + sfigmos;
        tmpMess+="@" + piesi +"@";
        
        return tmpMess ;
    }
    
    static public JFrame getCurrentFrame()
    {
        if (glStartForm.isVisible())
            return glStartForm ;
        else if (glAlarmForm.isVisible())
            return  glAlarmForm ;
        else if (glQuestionForm.isVisible())
            return  glQuestionForm ;
        else if (glSettingsForm.isVisible())
            return  glSettingsForm ;
        else if (glHelpForm.isVisible())
            return  glSettingsForm ;
        else
            return null ;
    }
    static Random random = new Random() ;
    static public String getSfigmos()
    {
        return String.valueOf(random.nextInt(40)+70) ;
    }
    
    static public String getPiesi()
    {
        return "B: "+String.valueOf(random.nextInt(10)+7)+" S: "+String.valueOf(random.nextInt(10)+10) ;
    }
    
}
