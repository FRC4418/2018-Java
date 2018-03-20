package org.usfirst.frc.team4418.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireShooterCommands extends CommandGroup {

    public FireShooterCommands() {
        addSequential(new FeedToShootPositionCommand()); // Set the feed solenoid to the shooting position and wait for cube to fire or timeout to be reached
        addSequential(new FeedToLoadPositionCommand()); // Return the feed solenoid to the loading position
    }
}
