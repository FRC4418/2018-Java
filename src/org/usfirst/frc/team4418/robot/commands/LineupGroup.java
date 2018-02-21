package org.usfirst.frc.team4418.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LineupGroup extends CommandGroup {

    public LineupGroup() {
    	addSequential(new PhotoelectricLineup());
    	addSequential(new BackupPID());
    	addSequential(new ShootGroup());
    	addSequential(new FeedShiftCommand());
    	addSequential(new FeedShiftCommand());
    }
}
