package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	/*if(FMSCall.gameData.length() > 0) {
    		if(gameData.charAt(0)=='L') {
    			if(driverPos==1) {
    				
    			}else if(driverPos == 2) {
    				
    			}else if(driverPos == 3) {
    				
    			}
    		}else {
	    		if(driverPos==1) {
					
				}else if(driverPos == 2) {
					
				}else if(driverPos == 3) {
					
				}
    		}
    	}*/
    }
}
