package org.usfirst.frc.team4418.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootGroup extends CommandGroup {

    public ShootGroup() {
    	//start shooter
    	addSequential(new FeedShiftCommand());
    	//stop shooter
    }
}
