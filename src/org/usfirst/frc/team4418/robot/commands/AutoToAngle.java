package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoToAngle extends Command {

    public AutoToAngle(double setpoint) {
    	if(Robot.autoStop) {
    		end();
    	}else {
    		Robot.gyroPID.setSetpointRelative(setpoint);
    		Robot.gyroPID.enable();
        	// Use requires() here to declare subsystem dependencies
        	// eg. requires(chassis);
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.autoStop) {
    		end();
    	}else {
    		Robot.gyroPID.getPIDController().reset();
    		//Robot.driveTrain.brake();
    		Robot.gyroPID.enable();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gyroPID.getPIDController().onTarget()||Robot.autoStop;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gyroPID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
