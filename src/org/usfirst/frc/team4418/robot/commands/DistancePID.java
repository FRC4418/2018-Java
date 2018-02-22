package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DistancePID extends Command {

	Boolean finished = false;
	
	Double[] xValues = new Double[25];
	Double[] lastX = new Double[25];
	
    public DistancePID(double relSet) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	if(Robot.autoStop) {
    		end();
    	}else {
    		Robot.encoders.reset();
    		Robot.encoderPID.getPIDController().reset();
    		Robot.encoderPID.setSetpoint(relSet);
    		Robot.encoderPID.setAbsoluteTolerance(.5);
    		//Robot.driveTrain.brake();
    		Robot.gyro.clear();
    		Robot.encoderPID.enable();
    		Robot.driveTrain.coast();
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.autoStop) {
    		end();
    	}else {
    		Robot.gyro.clear();
    		Robot.encoders.reset();
    		Robot.encoderPID.getPIDController().reset();
    		Robot.encoderPID.enable();
    		for(int i = 0; i < xValues.length; i++) {
    			xValues[i]=0.0;
    		}
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	for(int i = 0; i < (xValues.length); i++) {
    		lastX[i]=xValues[i];
    	}
    	xValues[0]=Robot.accel.getX();
    	for(int i = 1; i < (xValues.length); i++) {
    		xValues[i]=lastX[i-1];
    	}
    	if(average(xValues) > .4) {
    		Robot.autoStop = true;
    		end();
    		finished=true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;//Robot.encoderPID.getPIDController().onTarget()||finished||Robot.autoStop;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.encoderPID.disable();
    	Robot.encoderPID.getPIDController().reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//end();
    }
    private double average(Double[] arrToAvg) {
		double sum = 0;
		for(int i = 0; i < arrToAvg.length; i++) {
			sum+=arrToAvg[i];
		}
		double avg = sum/(arrToAvg.length);
		return avg;
	}
}