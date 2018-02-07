package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeMotorsCommand extends Command {

    public IntakeMotorsCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    TalonSRX intakeMotor1 = new TalonSRX(RobotMap.motorPort1);
	TalonSRX intakeMotor2 = new TalonSRX(RobotMap.motorPort2);
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//run motors at specified speed
    	intakeMotor1.set(null, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//stop motors
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//call end
    }
}
