package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class EncoderShuffleboardCommand extends Command {

    public EncoderShuffleboardCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.encoders);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//double[] encoderValues = {,Robot.encoders.getRightEncoder()}; //Store encoder values to an array
    	SmartDashboard.putNumber("Left Encoder", Robot.encoders.getLeftEncoder()); //Send encoder values array to shuffleboard
    	SmartDashboard.putNumber("Right Encoder", Robot.encoders.getRightEncoder()); //Send encoder values array to shuffleboard
    	System.out.println("running");
    	System.out.println(Robot.encoders.getRightEncoder());
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
