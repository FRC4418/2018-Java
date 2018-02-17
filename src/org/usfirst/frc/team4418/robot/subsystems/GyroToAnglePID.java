package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class GyroToAnglePID extends PIDSubsystem {

    // Initialize your subsystem here
    public GyroToAnglePID() {
    	super("GyroToAnglePID", 2.0, 0.0, 0.0);
    	setAbsoluteTolerance(1);
    	//getPIDController().setInputRange(-180.0f, 180.0f);
    	getPIDController().setOutputRange(-100.0f, 100.0f);
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
    	Robot.driveTrain.left.set(-output/100.0f);
    	Robot.driveTrain.right.set(-output/100.0f);
    	/*SmartDashboard.putBoolean("On Target? ", onTarget());
    	SmartDashboard.putNumber("P: ", getPIDController().getP());
    	SmartDashboard.putNumber("I: ", getPIDController().getI());
    	SmartDashboard.putNumber("D: ", getPIDController().getD());
    	SmartDashboard.putNumber("Setpoint: ", getPIDController().getSetpoint());
    	SmartDashboard.putNumber("Output: ", output/100f);*/
/*    	if(onTarget()) {
    		getPIDController().disable();
    		getPIDController().reset();
    	}
    	*/
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
