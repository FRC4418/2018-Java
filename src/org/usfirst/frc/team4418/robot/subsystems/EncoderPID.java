package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class EncoderPID extends PIDSubsystem {

    // Initialize your subsystem here
    public EncoderPID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("EncoderPID", 2.0, 0.0, 0.0);
    	setAbsoluteTolerance(1);
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
        return Robot.encoders.getAvgEncoder();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	Robot.driveTrain.leftTalonSRXA.set(output);
    	Robot.driveTrain.leftTalonSRXB.set(output);
    	Robot.driveTrain.rightTalonSRXA.set(-output);
    	Robot.driveTrain.rightTalonSRXB.set(-output);
    }
}
