package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.OI;
import org.usfirst.frc.team4418.robot.Robot;
import org.usfirst.frc.team4418.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TeleopDriveCommand extends Command {

    public TeleopDriveCommand() {
    	super("Teleop Drive");
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(RobotMap.rightTankDrive_axis!=5) { // Print error if right axis is configure for linux
    		SmartDashboard.putString("Teleop Drive Axis Warning", "The main drive stick is currently setup with the right axis on axis "+RobotMap.rightTankDrive_axis+", this was likely done to accomadate Linux, it should be on axis 5");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.teleopTankDrive(OI.mainDriverJoystickLeft.getRawAxis(1), OI.mainDriverJoystickRight.getRawAxis(1)); // Drive the robot in tank drive using two flight sim controllers
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.tankDrive(0, 0); // Set motors to 0 if finished
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
