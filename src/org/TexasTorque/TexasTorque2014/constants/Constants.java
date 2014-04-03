package org.TexasTorque.TexasTorque2014.constants;

public class Constants
{
    //----- Controller -----
    public final static double X_AXIS_DEADBAND = 0.22;
    public final static double Y_AXIS_DEADBAND = 0.16;
    public final static double ROTATION_DEADBAND = 0.18;
    public final static double OVERRIDE_AXIS_DEADBAND = 0.35;
    
    public static final boolean CONTROLLER_IS_XBOX = false;
    public static final boolean CONTROLLER_IS_LOGITECH = true;
    public final static boolean DEFAULT_FIRST_CONTROLLER_TYPE = CONTROLLER_IS_XBOX;
    public final static boolean DEFAULT_SECOND_CONTROLLER_TYPE = CONTROLLER_IS_XBOX;
    
    //----- Drivebase -----
    public final static double DEFAULT_HIGH_SENSITIVITY = 0.7;
    public final static double STRAFE_COEFFICIENT = 1;
    public final static double FORWARD_REVERSE_COEFFICIENT = 1;
    public final static double ROTATION_COEFFICIENT = 1;
    public final static boolean TRACTION_MODE = true;
    public final static boolean OMNI_MODE = false;
    public final static boolean STRAFE_ON = true;
    public final static boolean STRAFE_OFF = false;
    public final static double CLICKS_PER_METER = 783.242830177;
    public final static double METERS_PER_CLICK = 0.00127674325;
    
    //----- Manipulator -----
    public final static boolean HIGH_SHOT = true;
    public final static boolean FAR_SHOT = false;
    public final static double CHOO_CHOO_CLICKS_PER_REV = 617.6471;
    
    //----- Autonomous -----
    public final static int DO_NOTHING_AUTO = 0;
    public final static int ONE_BALL_AUTO = 1;
    public final static int TWO_BALL_AUTO = 6;
    public final static int THREE_BALL_AUTO = 3;
    public final static int JUST_DRIVE_AUTO = 4;
    public final static int DEAD_DRIVE_AUTO = 5;
    public final static int DRIVE_TWO_BALL_AUTO = 2;
    public final static int DRIVE_DISTANCE_TWO_BALL_AUTO = 8;
    public final static int DRIVE_ONE_BALL_AUTO = 7;
    public final static int TEST_AUTO = 100;
    
    //----- Gyro -----
    public static double GYRO_SENSITIVITY = 0.014;
    
    //----- Misc -----
    public final static int CYCLES_PER_LOG = 10;
    public final static double MOTOR_STOPPED = 0.0;
    public final static double PRESSURE_THRESHOLD = 2.0;
    public final static int RED_ALLIANCE = 0;
    public final static int BLUE_ALLIANCE = 1;
    
    //----- Potentiometer -----
    public final static double FRONT_INTAKE_POTENTIOMETER_LOW = 4.57;
    public final static double FRONT_INTAKE_POTENTIOMETER_HIGH = 2.29;
    public final static double REAR_INTAKE_POTENTIOMETER_LOW = 4.52;
    public final static double REAR_INTAKE_POTENTIOMETER_HIGH = 2.12;
    
    // ----- lights -----
    public final static int LIGHTS_DISABLED = 0;
    public final static int LIGHTS_BLUE = 4;
    public final static int LIGHTS_RED = 3;
    public final static int LIGHTS_BLUE_GREEN = 2;
    public final static int LIGHTS_RED_GREEN = 1;
    public final static int LIGHTS_BLUE_YELLOW = 6;
    public final static int LIGHTS_RED_YELLOW = 5;
}
