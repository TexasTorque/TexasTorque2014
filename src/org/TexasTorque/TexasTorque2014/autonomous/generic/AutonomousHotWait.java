package org.TexasTorque.TexasTorque2014.autonomous.generic;

import edu.wpi.first.wpilibj.Timer;
import java.util.Hashtable;
import org.TexasTorque.TexasTorque2014.autonomous.AutonomousCommand;
import org.TexasTorque.TorqueLib.component.CheesyVisionServer;

public class AutonomousHotWait extends AutonomousCommand {

    boolean firstCycle;
    double startTime;
    double waitTime;
    CheesyVisionServer cheese;

    public AutonomousHotWait() {
        cheese = CheesyVisionServer.getInstance();

        this.reset();
    }

    public void reset() {
        firstCycle = true;
    }

    public boolean run() {

        if (firstCycle) {
            System.err.print("Wait Start: ");
            startTime = Timer.getFPGATimestamp();
            System.err.println("L: "+cheese.getLeftCount() + " R: "+cheese.getRightCount());
            if (cheese.getLeftCount() + cheese.getRightCount() > 15) {
                System.err.println("Wait 3");
                waitTime = 4.0;
            } else {
                System.err.println("Wait 0.5");
                waitTime = 0.5;
            }

            firstCycle = false;
        }
        if (waitTime < (Timer.getFPGATimestamp() - startTime)) {
            System.err.println("Done");
            return true;
        }
        driverInput.updateAutonData(new Hashtable());
        return false;
    }

}
