package org.usfirst.frc.team4418.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TeleopCommands extends CommandGroup {

    public TeleopCommands() {
        //Drive in teleop
    	addParallel(new TeleopDriveCommand());
    }
}
