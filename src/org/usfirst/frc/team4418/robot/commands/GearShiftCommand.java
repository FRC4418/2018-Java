package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearShiftCommand extends Command {

    public GearShiftCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("GearShifter");
    	requires(Robot.gearShifter);
    }
    
    public boolean isFinished = false;

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.gearShifter.isHighGear()) {
    		Robot.gearShifter.lowGear();
    	} else {
    		Robot.gearShifter.highGear();
    	}
    	isFinished = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
