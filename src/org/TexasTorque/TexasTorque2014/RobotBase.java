package org.TexasTorque.TexasTorque2014;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Watchdog;
import org.TexasTorque.TexasTorque2014.io.*;
import org.TexasTorque.TexasTorque2014.subsystem.drivebase.Drivebase;
import org.TexasTorque.TexasTorque2014.subsystem.manipulator.Manipulator;
import org.TexasTorque.TorqueLib.util.DashboardManager;
import org.TexasTorque.TorqueLib.util.Parameters;
import org.TexasTorque.TorqueLib.util.TorqueLogging;

public class RobotBase extends IterativeRobot implements Runnable {

    Thread continuousThread;
    Watchdog watchdog;
    Parameters params;
    TorqueLogging logging;
    DashboardManager dashboardManager;
    DriverInput driverInput;
    SensorInput sensorInput;
    RobotOutput robotOutput;
    Drivebase drivebase;
    Manipulator manipulator;
    Timer robotTime;
    boolean logData;
    int logCycles;
    double numCycles;
    double previousTime;

    public void robotInit() {
        watchdog = getWatchdog();
        watchdog.setEnabled(true);
        watchdog.setExpiration(0.5);
        
        dashboardManager = DashboardManager.getInstance();
        robotOutput = RobotOutput.getInstance();
        driverInput = DriverInput.getInstance();
        drivebase = Drivebase.getInstance();
        
        driverInput.pullJoystickTypes();
        
        robotTime = new Timer();
        
        numCycles = 0.0;

        continuousThread = new Thread(this);
        continuousThread.start();
    }

    public void autonomousInit() {
    }

    public void teleopInit() {
        driverInput.pullJoystickTypes();
        robotTime.reset();
        robotTime.start();
    }

    public void disabledInit() {
    }

    public void run() {

        previousTime = Timer.getFPGATimestamp();

        while (true) {
            watchdog.feed();
            if (isAutonomous() && isEnabled()) {
                autonomousContinuous();
                Timer.delay(0.004);
            } else if (isOperatorControl() && isEnabled()) {
                teleopContinuous();
                Timer.delay(0.004);
            } else if (isDisabled()) {
                disabledContinuous();
                Timer.delay(0.05);
            }

            //sensorInput.calcEncoders();
            numCycles++;
        }
    }

    public void autonomousPeriodic() {
    }

    public void autonomousContinuous() {
    }

    public void teleopPeriodic() {
    }

    public void teleopContinuous() {
        drivebase.run();
        
        driverInput.updateState();
        robotOutput.updateState();
        
        drivebase.run();
        
        //drivebase.pushToDashboard();
        robotOutput.pullFromState();
    }

    public void disabledPeriodic() {
    }

    public void disabledContinuous() {
    }
}
