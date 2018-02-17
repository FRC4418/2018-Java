package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	Robot.gyroSys.clear();
    	Robot.driveTrain.brake();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.encoders.getLeftEncoder();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output)
    	if(output>1) {
    		output=1;
    	}else if(output <-1) {
    		output=-1;
    	}
    	double anglePct = Robot.gyroSys.getAngle()/90;
    	Robot.driveTrain.leftTalonSRXA.set(-output+anglePct);
    	//Robot.driveTrain.leftTalonSRXB.set(output-anglePct);
    	Robot.driveTrain.rightTalonSRXA.set(output+anglePct);
    	//Robot.driveTrain.rightTalonSRXB.set(-output-anglePct);
    	SmartDashboard.putNumber("Left a PID out", Robot.driveTrain.leftTalonSRXA.get());
    	SmartDashboard.putNumber("left b PID out", Robot.driveTrain.leftTalonSRXB.get());
    	SmartDashboard.putNumber("right a PID out", Robot.driveTrain.rightTalonSRXA.get());
    	SmartDashboard.putNumber("right b PID out", Robot.driveTrain.rightTalonSRXB.get());
    }
}
