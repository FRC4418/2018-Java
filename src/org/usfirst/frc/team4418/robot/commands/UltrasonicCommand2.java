package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UltrasonicCommand2 extends Command {

	public double u_value = 0;
	
    public UltrasonicCommand2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("ultrasonic2");
    	//requires(Robot.ultrasonic2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.ultrasonic.getRangeInchUltra2() != 0) {
    		u_value = Robot.ultrasonic.getRangeInchUltra2();
    
    		
    	}
    	SmartDashboard.putNumber("Range2: ", u_value);    	
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
