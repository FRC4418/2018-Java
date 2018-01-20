package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartCompressorCommand extends Command {

    public StartCompressorCommand() {
        // Initialize the start compressor command
    	super("StartCompressor");
    	
    	// Set required subsystems
    	requires(Robot.compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Enable the compressor
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
    	// Disable the compressor
    	Robot.compressor.disableCompressor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	// Ensure that if the compressor is interrupted it disables
    	end();
    }
}
