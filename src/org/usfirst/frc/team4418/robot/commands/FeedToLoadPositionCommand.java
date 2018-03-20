package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class FeedToLoadPositionCommand extends InstantCommand {

    public FeedToLoadPositionCommand() {
        super();
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.shooter.setFeedPosition(false);
    }

}
