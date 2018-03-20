package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ToggleShooterModeCommand extends InstantCommand {

    public ToggleShooterModeCommand() {
        super();
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.shooter.setMode(!Robot.shooter.getMode());
    }

}
