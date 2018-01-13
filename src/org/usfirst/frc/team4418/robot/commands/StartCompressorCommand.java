package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartCompressorCommand extends Command {

    public StartCompressorCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("StartCompressor");
    	requires(Robot.compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.compressor.enableCompressor();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.compressor.disableCompressor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
