package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.OI;
import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDriveCommand extends Command {
	
	

    public ArcadeDriveCommand() {
    	super("ArcadeDrive");
    	
    	// Set required subsystems
    	requires(Robot.arcadeDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.arcadeDrive(OI.joystick1);
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
}