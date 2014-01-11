package org.TexasTorque.TexasTorque2014.io.dependency;

import org.TexasTorque.TexasTorque2014.io.*;

public class RobotOutputState {

    private int lightState;

    //----- Pneumatics -----
    private boolean compressorEnabled;

    //----- Drive Motors -----
    private double leftFrontMotorSpeed;
    private double leftRearMotorSpeed;
    private double rightFrontMotorSpeed;
    private double rightRearMotorSpeed;

    public RobotOutputState(RobotOutput output) {
        lightState = output.getLightState();
        //----- Pneumatics -----
        compressorEnabled = output.getCompressorEnabled();

        //----- Drive Motors -----
        leftFrontMotorSpeed = output.getLeftFrontMotorSpeed();
        leftRearMotorSpeed = output.getLeftRearMotorSpeed();
        rightFrontMotorSpeed = output.getRightFrontMotorSpeed();
        rightRearMotorSpeed = output.getRightRearMotorSpeed();
    }

    public synchronized void setDriveMotors(double leftFrontSpeed, double leftRearSpeed, double rightFrontSpeed, double rightRearSpeed) {
        leftFrontMotorSpeed = leftFrontSpeed;
        leftRearMotorSpeed = leftRearSpeed;
        rightFrontMotorSpeed = rightRearSpeed;
        rightRearMotorSpeed = rightRearSpeed;
    }

    public synchronized void setLightsState(int state) {
        lightState = state;
    }

    public double getLeftFrontMotorSpeed() {
        return leftFrontMotorSpeed;
    }

    public double getLeftRearMotorSpeed() {
        return leftRearMotorSpeed;
    }

    public double getRightFrontMotorSpeed() {
        return rightFrontMotorSpeed;
    }

    public double getRightRearMotorSpeed() {
        return rightRearMotorSpeed;
    }

    public boolean getCompressorEnabled() {
        return compressorEnabled;
    }

    public int getLightState() {
        return lightState;
    }
}
