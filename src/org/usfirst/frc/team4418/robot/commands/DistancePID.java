package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DistancePID extends Command {

    public DistancePID() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	Robot.encoderPID.setSetpointRelative(24.0);
    	Robot.encoderPID.getPIDController().reset();
    	//Robot.driveTrain.brake();
    	Robot.encoderPID.enable();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.encoderPID.getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.encoderPID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
