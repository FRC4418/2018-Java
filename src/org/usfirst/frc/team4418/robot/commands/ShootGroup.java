package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootGroup extends CommandGroup {

    public ShootGroup() {
    	Robot.shootStop = false;
    	addSequential(new LauncherCommand(600));
    	addParallel(new StopShoot());
    }
}
