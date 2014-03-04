package org.TexasTorque.TexasTorque2014.autonomous.catapult;

import java.util.Hashtable;
import org.TexasTorque.TexasTorque2014.autonomous.AutonomousCommand;
import org.TexasTorque.TexasTorque2014.constants.Constants;

public class AutonomousFire extends AutonomousCommand {

    
    
    public void reset() {
        manipulator.resetFired();
    }

    public boolean run() {
        
        Hashtable autonOutputs = new Hashtable();
        
        autonOutputs.put("shoot", Boolean.TRUE);
        autonOutputs.put("shootTrigger", Boolean.TRUE);
        
        driverInput.updateAutonData(autonOutputs);
        
        drivebase.run();
        manipulator.run();
        
        if(manipulator.isFired())
        {
            return true;
        }
        return false;
    }
    
}
