package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.TeleopDriveCommand;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Drive train code
 * FRC 4418
 * 2018
 * William Hepperlen
 */
public class DriveTrainSubsystem extends Subsystem {

	
	// Setup ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private static final WPI_TalonSRX leftTalonA = new WPI_TalonSRX(RobotMap.leftTalonSRXA_CAN_ID), // Create the TalonSRXs
			leftTalonB = new WPI_TalonSRX(RobotMap.leftTalonSRXB_CAN_ID),
			rightTalonA = new WPI_TalonSRX(RobotMap.rightTalonSRXA_CAN_ID),
			rightTalonB = new WPI_TalonSRX(RobotMap.rightTalonSRXB_CAN_ID);
	private static boolean driveDirection = true; // Set the default direction the robot is driving, true is forward, false is backwards
	private static double controllerDeadzone = 0.05; // Set the deadzone for the controller in tank drive
	
	private static final DoubleSolenoid gearShiftSolenoid = new DoubleSolenoid(RobotMap.gearShiftLowGearSolenoid_PCM_ID,RobotMap.gearShiftHighGearSolenoid_PCM_ID); // Create the double solenoids
	
	private static final Encoder leftEncoder = new Encoder(RobotMap.leftEncoderA_DIO_ID,RobotMap.leftEncoderB_DIO_ID), // Create the encoders
			rightEncoder = new Encoder(RobotMap.rightEncoderA_DIO_ID,RobotMap.rightEncoderB_DIO_ID);
	
	private static final AnalogGyro gyro = new AnalogGyro(RobotMap.gyro_analog_ID); // Create the gyro
	
	private static final BuiltInAccelerometer accelerometer = new BuiltInAccelerometer(Accelerometer.Range.k4G);
	
	
	
	public DriveTrainSubsystem() { // Use the default constructor to setup initial valeus
		// Setup TalonSRX's
		leftTalonB.follow(leftTalonA); // Set the second left TalonSRX as a slave to the first
		rightTalonB.follow(rightTalonA); // Set the second right TalonSRX as a slave to the first
		setCoastMode(); // Set the default neutral mode as coast
		
		setGearShiftSolenoid(false); // Set the gear boxes to start in torque mode
		
		resetEncoders(); // Reset the encoders
		double rpp = ( (1/RobotMap.driveEncoderTicksPerRevolution) / RobotMap.driveEncoderGearRatio ); // Math for revolutions per pulse
		double dpp =  rpp * (Math.PI * RobotMap.wheelDiameter_dimension); // Math for distance per pulse
		if (RobotMap.wheelDiameter_dimension!=6) { // Print a warning if the wheel diameter is not setup for the competition robot
			SmartDashboard.putString("Wheel Diameter Warning", "The wheel diameter is currently not set to 6 inches, instead it is: "+RobotMap.wheelDiameter_dimension);
		}
		leftEncoder.setDistancePerPulse(dpp); // Set the distance per pulse for the left side, make the encoders output actual distance
		rightEncoder.setDistancePerPulse(dpp); // Set the distance per pulse for the right side, make the encoders output actual distance
		
		resetGyro(); // Reset the Gyro
		gyro.calibrate(); // Calibrate the Gyro
	}
	
	public void initDefaultCommand() { // Set the default command to be teleop drive
        setDefaultCommand(new TeleopDriveCommand());
    }
	
	
	// Motor Controllers ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void tankDrive(double leftValue, double rightValue) { // Tank drive control
		leftTalonA.set(leftValue);
		rightTalonA.set(rightValue);
	}
	
	public void teleopTankDrive(double leftValue, double rightValue) { // Tank drive + additional enhancements for teleop
		leftValue = applyDeadzone(inputMap(leftValue)); // Apply the custom curve to the input values and then apply the deadzones
		rightValue = applyDeadzone(inputMap(rightValue));
		
		if(!driveDirection) { // If the driveDirection is backwards (false), drive in the other direction
			double tmpVal = leftValue;
			leftValue = -rightValue;
			rightValue = -tmpVal;
		}
		
		tankDrive(leftValue, rightValue); // Pass the teleop enhanced values to the regular tank drive method
	}
	
	public void setBreakMode() { // Set the TalonSRXs to break when no value is given
		leftTalonA.setNeutralMode(NeutralMode.Brake);
		leftTalonB.setNeutralMode(NeutralMode.Brake);
		rightTalonA.setNeutralMode(NeutralMode.Brake);
		rightTalonB.setNeutralMode(NeutralMode.Brake);
	}
	
	public void setCoastMode() { // Set the TalonSRXs to coast when no value is given
		leftTalonA.setNeutralMode(NeutralMode.Coast);
		leftTalonB.setNeutralMode(NeutralMode.Coast);
		rightTalonA.setNeutralMode(NeutralMode.Coast);
		rightTalonB.setNeutralMode(NeutralMode.Coast);
	}
	
	private double inputMap(double value) { // Apply a custom curve function to the drive inputs
		return Math.signum(value)*Math.abs(2.542735043*value*value*value-3.316433566*value*value+1.783139083*value+0.0181118881);
	}
	
	private double applyDeadzone(double value) { // Return the value if it is outside of the deadzone, or 0 if it is within the deadzone
		return Math.abs(value)>controllerDeadzone ? value : 0; 
	}
	
	public boolean getDriveDirection() { // Get the current drive direction, true is forward, false is backwards
		return driveDirection;
	}
	
	public void setDriveDirection(boolean newDriveDirection) { // Get the current drive direction, true is forward, false is backwards
		driveDirection = newDriveDirection;
	}
	
	
	// Gear Shifter ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public boolean getGearShiftSolenoidState() { // Get the current state of the gear shifter, false is low gear, true is high gear
		return gearShiftSolenoid.get()==DoubleSolenoid.Value.kForward;
	}
	
	public void setGearShiftSolenoid(boolean state) { // Set the current state of the gear shifter, false is low gear, true is high gear
		gearShiftSolenoid.set(state ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
	}
	
	
	// Encoders ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void resetEncoders() { // Reset the encoders
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public double getLeftEncoder() { // Get the distance from the left encoder
		return leftEncoder.getDistance();
	}
	
	public double getRightEncoder() { // Get the distance from the right encoder
		return rightEncoder.getDistance();
	}
	
	
	// Gyro ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void resetGyro() { // Reset the gyro
		gyro.reset();
	}
	
	public double getGyroValue() { // Get the gyro's angle
		return gyro.getAngle();
	}
	
	public double getAccelerometeXValue() { // Get the accelerometer's X acceleration
		return accelerometer.getX();
	}
	
	public double getAccelerometeYValue() { // Get the accelerometer's X acceleration
		return accelerometer.getY();
	}
	
	public double getAccelerometeZValue() { // Get the accelerometer's X acceleration
		return accelerometer.getZ();
	}
}

