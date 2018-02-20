package org.usfirst.frc.team4418.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class LauncherPIDSubsystem extends PIDSubsystem {

    // Initialize your subsystem here
    public LauncherPIDSubsystem() {
    	super("LauncherPIDSubsystem", 2.0, 0.0, 0.0);
    	setAbsoluteTolerance(0.1);
    	getPIDController().setOutputRange(-1f, 1f);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
    	
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
    	return FrontLeftMotor.leftFrontEncoder.getRate();
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	
    }

    protected void usePIDOutput(double output) {
    	
    	RearLeftMotor.leftRearMotor.set(output);
    	FrontRightMotor.rightFrontMotor.set(-output);
    	RearRightMotor.rightRearMotor.set(-output);
    	
    	
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
