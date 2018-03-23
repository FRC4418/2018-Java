package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriveDistancePIDSubsystem extends PIDSubsystem {
	
	static double startAngle = 0;
	
    // Initialize your subsystem here
    public DriveDistancePIDSubsystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Drive Distance PID", 1.0, 0.0, 0.0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setStartAngle() {
    	startAngle=Robot.driveTrain.getGyroValue();
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.driveTrain.getLeftEncoder();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	Robot.driveTrain.tankDrive(output+(Robot.driveTrain.getGyroValue()/startAngle), output+(Robot.driveTrain.getGyroValue()/startAngle));
    	
    }
}
