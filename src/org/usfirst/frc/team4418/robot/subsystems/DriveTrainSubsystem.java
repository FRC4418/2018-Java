package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.TeleopDriveCommand;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	WPI_TalonSRX leftTalonSRXA = new WPI_TalonSRX(RobotMap.leftTalonSRXAID),
			leftTalonSRXB = new WPI_TalonSRX(RobotMap.leftTalonSRXBID),
			leftTalonSRXC = new WPI_TalonSRX(RobotMap.leftTalonSRXCID),
			rightTalonSRXA = new WPI_TalonSRX(RobotMap.rightTalonSRXAID),
			rightTalonSRXB = new WPI_TalonSRX(RobotMap.rightTalonSRXBID),
			rightTalonSRXC = new WPI_TalonSRX(RobotMap.rightTalonSRXCID);
	DifferentialDrive driveTrain = new DifferentialDrive(leftTalonSRXA, rightTalonSRXA);
	
	private double joystickDeadzone = 0.05;
	
	public void tankDrive(Joystick driverJoystick) {
		double leftValue = driverJoystick.getRawAxis(1);
		double rightValue = driverJoystick.getRawAxis(5);
		
		leftTalonSRXA.setNeutralMode(NeutralMode.Brake);
		rightTalonSRXA.setNeutralMode(NeutralMode.Brake);
		
		driveTrain.tankDrive(leftValue, rightValue, false);
	}
	
	public void stopDrive() {
		driveTrain.curvatureDrive(0, 0, false);
	}
	
	public double inputMap(double value) {
		value = Math.signum(value)*value*value;
		return value >= joystickDeadzone ? value : 0;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleopDriveCommand());
    }
    
    public DriveTrainSubsystem() {
		super();
		leftTalonSRXB.follow(leftTalonSRXA);
		leftTalonSRXC.follow(leftTalonSRXA);
		rightTalonSRXB.follow(rightTalonSRXA);
		rightTalonSRXC.follow(rightTalonSRXA);
	}
}

