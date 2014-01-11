package org.TexasTorque.TexasTorque2014.io;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.TexasTorque.TexasTorque2014.constants.Constants;
import org.TexasTorque.TexasTorque2014.constants.Ports;
import org.TexasTorque.TexasTorque2014.io.dependency.DriverInputState;
import org.TexasTorque.TorqueLib.util.GenericController;
import org.TexasTorque.TorqueLib.util.Parameters;

public class DriverInput {

    private static DriverInput instance;
    private static DriverInputState state;
    private Parameters params;
    public GenericController driveController;
    private GenericController operatorController;

    private boolean inOverrideState;

    public DriverInput() {
        params = Parameters.getTeleopInstance();
        driveController = new GenericController(Ports.DRIVE_CONTROLLER_PORT, Constants.DEFAULT_FIRST_CONTROLLER_TYPE);
        operatorController = new GenericController(Ports.OPERATOR_CONTROLLER_PORT, Constants.DEFAULT_SECOND_CONTROLLER_TYPE);

        inOverrideState = false;
    }

    public synchronized void updateState() {
        state = new DriverInputState(getInstance());
    }

    public synchronized static DriverInput getInstance() {
        return (instance == null) ? instance = new DriverInput() : instance;
    }

    public synchronized static DriverInputState getState() {
        return state;
    }

    public synchronized void pullJoystickTypes() {
        boolean firstControllerType = SmartDashboard.getBoolean("firstControllerIsLogitech", Constants.DEFAULT_FIRST_CONTROLLER_TYPE);
        boolean secondControllerType = SmartDashboard.getBoolean("secondControllerIsLogitech", Constants.DEFAULT_SECOND_CONTROLLER_TYPE);

        if (firstControllerType) {
            driveController.setAsLogitech();
        } else {
            driveController.setAsXBox();
        }

        if (secondControllerType) {
            operatorController.setAsLogitech();
        } else {
            operatorController.setAsXBox();
        }
    }

    public synchronized double getAutonomousDelay() {
        return SmartDashboard.getNumber("Autonomous Delay", 0.0);
    }

    public synchronized int getAutonomousMode() {
        return (int) SmartDashboard.getNumber("AutonomousMode", Constants.DO_NOTHING_AUTO);
    }

    public synchronized boolean resetSensors() {
        return operatorController.getBottomActionButton();
    }

//---------- Drivebase ----------
    public synchronized double getXAxis() {
        return driveController.getLeftYAxis();
    }

    public synchronized double getYAxis() {
        return driveController.getLeftXAxis();
    }

    public synchronized double getRotation() {
        return operatorController.getRightXAxis();
    }

    public synchronized boolean hasInput() {
        return (Math.abs(getXAxis()) > Constants.X_AXIS_DEADBAND || Math.abs(getYAxis()) > Constants.Y_AXIS_DEADBAND || Math.abs(getRotation()) > Constants.ROTATION_DEADBAND);
    }

//---------- Manipulator ----------    
    public synchronized boolean restoreToDefault() {
        return operatorController.getBottomLeftBumper();
    }

//---------- Overrides ----------
    public synchronized boolean overrideState() {
        if (operatorController.getLeftCenterButton()) {
            inOverrideState = true;
        } else if (operatorController.getRightCenterButton()) {
            inOverrideState = false;
        }

        return inOverrideState;
    }

    public synchronized GenericController getDriverController() {
        return driveController;
    }

    public synchronized GenericController getOperatorController() {
        return operatorController;
    }
}
