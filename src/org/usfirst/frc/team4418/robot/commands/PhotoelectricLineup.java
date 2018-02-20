package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PhotoelectricLineup extends Command {
    public PhotoelectricLineup() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.photoElectric);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	while(Robot.photoElectric.getVoltage()<3) {
    		Robot.driveTrain.straight(.5);
    	}
    	while(Robot.photoElectric2.getVoltage()<3) {
	    	if(Robot.gameData.charAt(1)=='L') {
	    		Robot.driveTrain.spin(.5);
	    	}else if(Robot.gameData.charAt(1)=='R') {
	    		Robot.driveTrain.spin(-.5);
	    	}
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
