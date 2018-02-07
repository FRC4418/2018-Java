package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroToAnglePID extends PIDSubsystem {

    // Initialize your subsystem here
    public GyroToAnglePID() {
    	super("GyroToAnglePID", 0.1, 0.1, 0.1);
    	Robot.gyroSys.clear();
    	setAbsoluteTolerance(5);
    	getPIDController().setInputRange(-180.0f, 180.0f);
    	getPIDController().setOutputRange(-1, 1);
    	getPIDController().setContinuous(false);
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
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.gyroSys.getAngle();
    }

    protected void usePIDOutput(double output) {
    	Robot.driveTrain.leftTalonSRXA.set(-output);
    	Robot.driveTrain.rightTalonSRXA.set(-output);
    	SmartDashboard.putBoolean("On Target? ", onTarget());
    	SmartDashboard.putNumber("P: ", getPIDController().getP());
    	SmartDashboard.putNumber("I: ", getPIDController().getI());
    	SmartDashboard.putNumber("D: ", getPIDController().getD());
    	SmartDashboard.putNumber("Setpoint: ", getPIDController().getSetpoint());
    	SmartDashboard.putNumber("Output: ", output);
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
