package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetShooterModeCommand extends InstantCommand {

	private static boolean mode;
	
    public SetShooterModeCommand(boolean setForScale) {
        super();
        mode = setForScale;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.shooter.setMode(mode);
    }

}
