package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.commands.HoldIntakeElevationCommand;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class IntakeElevationPIDSubsystem extends PIDSubsystem {

    // Initialize your subsystem here
    public IntakeElevationPIDSubsystem() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Intake Elevation", 1.0, 0.0, 0.0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new HoldIntakeElevationCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
