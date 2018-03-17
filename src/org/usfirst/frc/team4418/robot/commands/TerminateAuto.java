package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TerminateAuto extends Command {

	int runs = 0;
	
    public TerminateAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	runs+=1;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return runs>100;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.frontLeftPID.disable();
    	Robot.frontLeftPID.getPIDController().reset();
    	
    	Robot.rearLeftPID.disable();
    	Robot.rearLeftPID.getPIDController().reset();
    	
    	Robot.frontRightPID.disable();
    	Robot.frontRightPID.getPIDController().reset();
    	
    	Robot.rearRightPID.disable();
    	Robot.rearRightPID.getPIDController().reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}