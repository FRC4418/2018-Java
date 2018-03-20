package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveDistanceCommand extends Command {

    public DriveDistanceCommand(int distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("Drive Distance");
    	requires(Robot.driveDistancePID);
    	Robot.driveDistancePID.setSetpoint(distance);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveDistancePID.getPIDController().reset();
    	Robot.driveDistancePID.enable();
    	Robot.driveTrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("CurrentPIDError", Robot.driveDistancePID.getPIDController().getError());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveDistancePID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
