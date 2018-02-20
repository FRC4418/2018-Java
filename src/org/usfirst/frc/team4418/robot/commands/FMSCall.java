package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class FMSCall extends Command {

	
    public FMSCall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driverPos = Robot.autoChooser.getSelected();
    	Robot.gameData = DriverStation.getInstance().getGameSpecificMessage();
    	Robot.switchOrScale = Robot.switchChooser.getSelected();
    	int retries = 100;
        while (Robot.gameData.length() < 2 && retries > 0) {
            DriverStation.reportError("Gamedata is " + Robot.gameData + " retrying " + retries, false);
            try {
                Thread.sleep(5);
                Robot.gameData = DriverStation.getInstance().getGameSpecificMessage();
                if (Robot.gameData==null) { Robot.gameData = ""; }
            } catch (Exception e) {
            }
            retries--;
        }
        DriverStation.reportError("gameData before parse: " + Robot.gameData, false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString("Driver Position: ", Robot.driverPos);
    	SmartDashboard.putString("Game Message: ", Robot.gameData);
    	SmartDashboard.putString("Switch or Scale: ", Robot.switchOrScale);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
