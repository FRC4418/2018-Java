package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class UltrasonicPIDLeft extends PIDSubsystem {

    // Initialize your subsystem here
    public UltrasonicPIDLeft() {
    	super("UltrasonicPIDLeft", 2, 0, 0);
    	setAbsoluteTolerance(.5);
    	getPIDController().setOutputRange(-100.0f, 100.0f);
    	getPIDController().setContinuous(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.ultrasonic2.getRangeInch();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	Robot.driveTrain.left.set(output);
    	Robot.driveTrain.left.set(output);
    }
}
