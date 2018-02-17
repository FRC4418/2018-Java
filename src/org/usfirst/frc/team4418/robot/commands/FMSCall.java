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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString("Driver Position: ", Robot.driverPos);
    	SmartDashboard.putString("Game Message: ", Robot.gameData);
    	SmartDashboard.putString("Switch or Scale: ", Robot.switchOrScale);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.driverPos!=null&&Robot.gameData!=null&&Robot.switchOrScale!=null) {
        	return true;
        }else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("FMS Finished");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
