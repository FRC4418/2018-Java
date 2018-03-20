package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GetFMSDataCommand extends Command {

    public GetFMSDataCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    short retries = 100;
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driverPosition = Robot.driverPositionChooser.getSelected(); // Get which position the robot is in
    	Robot.autonomousTarget = Robot.autonomousTargetChooser.getSelected(); // Get which autonomous mode to run
    	Robot.gameData = DriverStation.getInstance().getGameSpecificMessage(); // Get the field layout information
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriverStation.reportError("Gamedata is " + Robot.gameData + " retrying " + retries, false);
    	try {
        	Thread.sleep(5);
            Robot.gameData = DriverStation.getInstance().getGameSpecificMessage();
            if (Robot.gameData==null) { Robot.gameData = ""; }
    	} catch (Exception e) {}
    	retries--;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.gameData.length() == 3 || retries <= 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putString("Driver Position", Robot.driverPosition);
    	SmartDashboard.putString("Game Message", Robot.gameData);
    	SmartDashboard.putString("Switch or Scale", Robot.autonomousTarget);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
