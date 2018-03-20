package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ToggleDriveDirectionCommand extends InstantCommand {

    public ToggleDriveDirectionCommand() {
        super();
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.driveTrain.setDriveDirection(!Robot.driveTrain.getDriveDirection()); // Set the drive mode to the inverse of what it was
    }

}
