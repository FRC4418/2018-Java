package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {

    // Create objects for the drive train subsystem
	WPI_TalonSRX leftTalonSRXA = new WPI_TalonSRX(RobotMap.leftTalonSRXA_CAN_ID), //Create all TalonSRXs
			leftTalonSRXB = new WPI_TalonSRX(RobotMap.leftTalonSRXB_CAN_ID),
			rightTalonSRXA = new WPI_TalonSRX(RobotMap.rightTalonSRXA_CAN_ID),
			rightTalonSRXB = new WPI_TalonSRX(RobotMap.rightTalonSRXB_CAN_ID);
	
	SpeedControllerGroup left = new SpeedControllerGroup(leftTalonSRXA, leftTalonSRXB), //Group the left and right sides together
			right = new SpeedControllerGroup(rightTalonSRXA, rightTalonSRXB);
	
	DifferentialDrive driveTrain = new DifferentialDrive(left, right); //Create the drivetrain
	
	// Create variables for the drive train subsystem
	private double joystickDeadzone = 0.05;
	
	// Tank drive control with added features
	public void tankDrive(Joystick driverJoystick) {
		// Apply a custom curve to the joystick's values and apply a deadzone
		double leftValue = inputMap(driverJoystick.getRawAxis(RobotMap.leftTankDrive_axis));
		double rightValue = inputMap(driverJoystick.getRawAxis(RobotMap.rightTankDrive_axis));
		
		// Enable breaking if the joystick value for a side is within the deadzone
		leftTalonSRXA.setNeutralMode(leftValue == 0 ? NeutralMode.Brake : NeutralMode.Coast);
		leftTalonSRXB.setNeutralMode(leftValue == 0 ? NeutralMode.Brake : NeutralMode.Coast);
		rightTalonSRXA.setNeutralMode(rightValue == 0 ? NeutralMode.Brake : NeutralMode.Coast);
		rightTalonSRXB.setNeutralMode(rightValue == 0 ? NeutralMode.Brake : NeutralMode.Coast);
		
		SmartDashboard.putNumber( "Left Drive Train Value", leftValue);
		SmartDashboard.putNumber( "Right Drive Train Value", rightValue);
		SmartDashboard.putNumber("Left Drive Train Motor A", leftTalonSRXA.get());
		SmartDashboard.putNumber("Left Drive Train Motor B", leftTalonSRXB.get());
		SmartDashboard.putNumber("Right Drive Train Motor A", rightTalonSRXA.get());
		SmartDashboard.putNumber("Right Drive Train Motor B", rightTalonSRXB.get());
				
		// Tank drive using the values previously calculated 
		// and disabling squared inputs since the curve was already applied
		driveTrain.tankDrive(leftValue, rightValue, false);
	}
	
	// Set all motors to break mode
	public void brake() {
		leftTalonSRXA.setNeutralMode(NeutralMode.Brake);
		rightTalonSRXA.setNeutralMode(NeutralMode.Brake);
		leftTalonSRXB.setNeutralMode(NeutralMode.Brake);
		rightTalonSRXB.setNeutralMode(NeutralMode.Brake);
	}
	
	// Set all motors to coast mode
	public void coast() {
		leftTalonSRXA.setNeutralMode(NeutralMode.Coast);
		rightTalonSRXA.setNeutralMode(NeutralMode.Coast);
		leftTalonSRXB.setNeutralMode(NeutralMode.Coast);
		rightTalonSRXB.setNeutralMode(NeutralMode.Coast);
	}
	
	// Stop driving
	public void stopDrive() {
		driveTrain.curvatureDrive(0, 0, false);
	}
	
	//Apply a custom curve to joystick values and apply a deadzone
	public double inputMap(double value) {
		// Apply the custom curves
		value = Math.signum(value)*Math.abs(2.542735043*value*value*value-3.316433566*value*value+1.783139083*value+0.0181118881);
		
		// Apply the deadzone if the value is within 0 +/- the value of joystickDeadzone
		return Math.abs(value) >= joystickDeadzone ? value : 0;
	}
	
    public void initDefaultCommand() {
    }
    
    // Override the default constructor to allow for talons B and C of both sides
    // to be set to slaves of the talon A on their side
    public DriveTrainSubsystem() {
		super();
	}
}

