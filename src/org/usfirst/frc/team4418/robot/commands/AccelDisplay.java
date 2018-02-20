package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AccelDisplay extends Command {
	
	Double[] xValues = new Double[25];
	Double[] yValues = new Double[25];
	Double[] zValues = new Double[25];
	Double[] lastX = new Double[25];
	Double[] lastY = new Double[25];
	Double[] lastZ = new Double[25];
	
    public AccelDisplay() {
    	requires(Robot.accel);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	for(int i = 0; i < xValues.length; i++) {
    		xValues[i]=0.0;
    	}
    	for(int i = 0; i < yValues.length; i++) {
    		yValues[i]=0.0;
    	}
    	for(int i = 0; i < zValues.length; i++) {
    		zValues[i]=0.0;
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
    	for(int i = 0; i < (yValues.length); i++) {
    		lastY[i]=yValues[i];
    	}
    	yValues[0]=Robot.accel.getY();
    	for(int i = 1; i < (yValues.length); i++) {
    		yValues[i]=lastY[i-1];
    	}
    	for(int i = 0; i < (zValues.length); i++) {
    		lastZ[i]=zValues[i];
    	}
    	zValues[0]=Robot.accel.getZ();
    	for(int i = 1; i < (zValues.length); i++) {
    		zValues[i]=lastZ[i-1];
    	}
    	SmartDashboard.putNumber("X Acceleration", average(xValues));
    	SmartDashboard.putNumber("Y Acceleration", average(yValues));
    	SmartDashboard.putNumber("Z Acceleration", average(zValues));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
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
