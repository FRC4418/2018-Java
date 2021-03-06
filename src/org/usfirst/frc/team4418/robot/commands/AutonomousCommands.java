package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommands extends CommandGroup {

    public AutonomousCommands() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new FMSCall());
   		if(Robot.switchOrScale=="Switch") {
    		if(Robot.gameData.charAt(0)=='L') {
    			if(Robot.driverPos=="Straight") {
    				addSequential(new DistancePID(250.0));
    			}else if(Robot.driverPos == "Position One (left)") {
    				addSequential(new DistancePID(111));
    				addSequential(new ShootGroup());
    			}else if(Robot.driverPos == "Position Two (middle)") {
    				addSequential(new DistancePID(111));
    			}else if(Robot.driverPos=="Position Three (right)") {
    				addSequential(new DistancePID(111));
    			}
    		}else {
    			if(Robot.driverPos=="Straight") {
    				addSequential(new DistancePID(250.0));
    			}else if(Robot.driverPos == "Position One (left)") {
    				addSequential(new DistancePID(111));
    			}else if(Robot.driverPos == "Position Two (middle)") {
    				addSequential(new DistancePID(111));
    			}else if(Robot.driverPos=="Position Three (right)") {
    				addSequential(new DistancePID(111));
    				addSequential(new ShootGroup());
    			}
    		}
   		}else if(Robot.switchOrScale=="Scale") {
   			if(Robot.gameData.charAt(0)=='L') {
    			if(Robot.driverPos=="Straight") {
    				addSequential(new DistancePID(251));
    			}else if(Robot.driverPos == "Position One (left)") {
    				addSequential(new DistancePID(251));
    				addSequential(new LineupGroup());
    			}else if(Robot.driverPos == "Position Two (middle)") {
    				addSequential(new DistancePID(111));
    			}else if(Robot.driverPos=="Position Three (right)") {
    				addSequential(new DistancePID(251));
    			}
    		}else {
    			if(Robot.driverPos=="Straight") {
    				addSequential(new DistancePID(251));
    			}else if(Robot.driverPos == "Position One (left)") {
    				addSequential(new DistancePID(251));
    			}else if(Robot.driverPos == "Position Two (middle)") {
    				addSequential(new DistancePID(111));
    			}else if(Robot.driverPos=="Position Three (right)") {
    				addSequential(new DistancePID(251));
    				addSequential(new LineupGroup());
    			}
    		}
   		}
    }
}
