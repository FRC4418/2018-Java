package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.OI;
import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LauncherCommand extends Command {
    
	int runs = 0;
	
    public LauncherCommand(double RPMSetpoint) {
    	requires(Robot.frontLeftPID);
    	requires(Robot.rearLeftPID);
    	requires(Robot.frontRightPID);
    	requires(Robot.rearRightPID);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	Robot.frontLeftPID.getPIDController().reset();
    	Robot.frontLeftPID.setPercentTolerance(0.025);
    	Robot.frontLeftPID.setSetpoint(RPMSetpoint);
    	Robot.frontLeftPID.enable();
    	
    	Robot.rearLeftPID.getPIDController().reset();
    	Robot.rearLeftPID.setPercentTolerance(0.025);
    	Robot.rearLeftPID.setSetpoint(RPMSetpoint);
    	Robot.rearLeftPID.enable();
    	
    	Robot.frontRightPID.getPIDController().reset();
    	Robot.frontRightPID.setPercentTolerance(0.025);
    	Robot.frontRightPID.setSetpoint(RPMSetpoint);
    	Robot.frontRightPID.enable();
    	
    	Robot.rearRightPID.getPIDController().reset();
    	Robot.rearRightPID.setPercentTolerance(0.025);
    	Robot.rearRightPID.setSetpoint(RPMSetpoint);
    	Robot.rearRightPID.enable();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.frontLeftPID.getPIDController().reset();
    	Robot.frontLeftPID.setPercentTolerance(0.025);
    	Robot.frontLeftPID.enable();
    	
    	Robot.rearLeftPID.getPIDController().reset();
    	Robot.rearLeftPID.setPercentTolerance(0.025);
    	Robot.rearLeftPID.enable();
    	
    	Robot.frontRightPID.getPIDController().reset();
    	Robot.frontRightPID.setPercentTolerance(0.025);
    	Robot.frontRightPID.enable();
    	
    	Robot.rearRightPID.getPIDController().reset();
    	Robot.rearRightPID.setPercentTolerance(0.025);
    	Robot.rearRightPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	runs+=1;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return runs>50;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.frontLeftPID.disable();
    	Robot.frontLeftPID.getPIDController().reset();
    	
    	Robot.rearLeftPID.disable();
    	Robot.rearLeftPID.getPIDController().reset();
    	
    	Robot.frontRightPID.disable();
    	Robot.frontRightPID.getPIDController().reset();
    	
    	Robot.rearRightPID.disable();
    	Robot.rearRightPID.getPIDController().reset();
    }
}
