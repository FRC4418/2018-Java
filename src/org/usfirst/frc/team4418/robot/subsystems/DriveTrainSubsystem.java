package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {

    // Create objects for the drive train subsystem
	WPI_TalonSRX leftTalonSRXA = new WPI_TalonSRX(RobotMap.leftTalonSRXAID),
			leftTalonSRXB = new WPI_TalonSRX(RobotMap.leftTalonSRXBID),
			leftTalonSRXC = new WPI_TalonSRX(RobotMap.leftTalonSRXCID),
			rightTalonSRXA = new WPI_TalonSRX(RobotMap.rightTalonSRXAID),
			rightTalonSRXB = new WPI_TalonSRX(RobotMap.rightTalonSRXBID),
			rightTalonSRXC = new WPI_TalonSRX(RobotMap.rightTalonSRXCID);
	DifferentialDrive driveTrain = new DifferentialDrive(leftTalonSRXA, rightTalonSRXA);
	
	// Create variables for the drive train subsystem
	private double joystickDeadzone = 0.05;
	
	// Tank drive control with added features
	public void tankDrive(Joystick driverJoystick) {
		// Apply a custom curve to the joystick's values and apply a deadzone
		double leftValue = inputMap(driverJoystick.getRawAxis(1));
		double rightValue = inputMap(driverJoystick.getRawAxis(5));
		SmartDashboard.putNumber( "Left Motor out: ", leftValue);
		SmartDashboard.putNumber( "Right Motor out: ", rightValue);
		
		// Enable breaking if the joystick value for a side is within the deadzone
		leftTalonSRXA.setNeutralMode(leftValue==0 ? NeutralMode.Brake : NeutralMode.Coast);
		rightTalonSRXA.setNeutralMode(rightValue==0 ? NeutralMode.Brake : NeutralMode.Coast);
		leftTalonSRXB.setNeutralMode(leftValue==0 ? NeutralMode.Brake : NeutralMode.Coast);
		rightTalonSRXB.setNeutralMode(rightValue==0 ? NeutralMode.Brake : NeutralMode.Coast);
		leftTalonSRXC.setNeutralMode(leftValue==0 ? NeutralMode.Brake : NeutralMode.Coast);
		rightTalonSRXC.setNeutralMode(rightValue==0 ? NeutralMode.Brake : NeutralMode.Coast);
		
		// Tank drive using the values previously calculated 
		// and disabling squared inputs since the curve was already applied
		driveTrain.tankDrive(leftValue, rightValue, false);
	}
	
	public void brake() {
		leftTalonSRXA.setNeutralMode(NeutralMode.Brake);
		rightTalonSRXA.setNeutralMode(NeutralMode.Brake);
		leftTalonSRXB.setNeutralMode(NeutralMode.Brake);
		rightTalonSRXB.setNeutralMode(NeutralMode.Brake);
		leftTalonSRXC.setNeutralMode(NeutralMode.Brake);
		rightTalonSRXC.setNeutralMode(NeutralMode.Brake);
	}
	
	public void coast() {
		leftTalonSRXA.setNeutralMode(NeutralMode.Coast);
		rightTalonSRXA.setNeutralMode(NeutralMode.Coast);
		leftTalonSRXB.setNeutralMode(NeutralMode.Coast);
		rightTalonSRXB.setNeutralMode(NeutralMode.Coast);
		leftTalonSRXC.setNeutralMode(NeutralMode.Coast);
		rightTalonSRXC.setNeutralMode(NeutralMode.Coast);
	}
	
	public void arcadeDrive(Joystick driverJoystick) {
		// Apply a custom curve to the joystick's values and apply a deadzone
		double speed = inputMap(driverJoystick.getRawAxis(1));
		double rotation = inputMap(driverJoystick.getRawAxis(0));
		
		// Enable breaking if the joystick value for a side is within the deadzone
		leftTalonSRXA.setNeutralMode(NeutralMode.Brake);
		rightTalonSRXA.setNeutralMode(NeutralMode.Brake);
		
		// Arcade drive using the values previously calculated 
		// and disabling squared inputs since the curve was already applied
		driveTrain.arcadeDrive(speed, -rotation);
	}
	
	
	// Stop the drive train from receiving input
	public void stopDrive() {
		driveTrain.curvatureDrive(0, 0, false);
	}
	
	//Apply a custom curve to joystick values and apply a deadzone
	public double inputMap(double value) {
		// Apply the custom curve
		// Square the inputs
		//value = Math.signum(value)*value*value;
		
		// Apply the deadzone if the value is within 0 +/- the value of joystickDeadzone
		return Math.abs(value) >= joystickDeadzone ? value : 0;
	}
	
    public void initDefaultCommand() {
        // Set the default command to teleop driving
    }
    
    // Override the default constructor to allow for talons B and C of both sides
    // to be set to slaves of the talon A on their side
    public DriveTrainSubsystem() {
		super();
		leftTalonSRXB.follow(leftTalonSRXA);
		leftTalonSRXC.follow(leftTalonSRXA);
		rightTalonSRXB.follow(rightTalonSRXA);
		rightTalonSRXC.follow(rightTalonSRXA);
	}
}

