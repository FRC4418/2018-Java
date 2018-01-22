package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.OI;
import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopDriveCommand extends Command {

    public TeleopDriveCommand() {
        // Initialize the teleop drive command
    	super("TeleopDrive");
    	
    	// Set required subsystems
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Drive the robot using tank drive with a joystick
    	Robot.driveTrain.tankDrive(OI.getDriverJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stop the robot from driving
    	Robot.driveTrain.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	// Ensure the robot stops receiving inputs during the interrupt
    	end();
    }
}
