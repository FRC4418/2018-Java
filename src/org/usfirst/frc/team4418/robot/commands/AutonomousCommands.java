package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;
import org.usfirst.frc.team4418.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonomousCommands extends CommandGroup {

    public AutonomousCommands() {
    	addSequential(new GetFMSDataCommand()); // Get data from the FMS and drive station
    	

    	
    	if(Robot.autonomousTarget == "Cross Auto Line" || Robot.driverPosition == "Null" || (Character.toUpperCase(Robot.gameData.charAt(0)) == 'R' && (Robot.driverPosition == "Left 1" || Robot.driverPosition == "Middle 2")) || ((Character.toUpperCase(Robot.gameData.charAt(0)) == 'L' && Robot.driverPosition == "Right 3"))) { // If robot needs to cross the line, or not auto position was set... --------------------------------------------
        	addSequential(new DriveDistanceCommand(140-RobotMap.robotLength_dimension-(int)(RobotMap.bumperWidth_dimension*2))); // Drive across the auto line
        	
        	
        	
        } else if(Robot.autonomousTarget == "Switch") { // If the robot is attempting to score in switch ----------------------------------------------------------------------------------------------------
        	if(Robot.driverPosition == "Middle (2)") {
        		addSequential(new DriveDistanceCommand(140-RobotMap.robotLength_dimension-(int)(RobotMap.bumperWidth_dimension*2))); // Drive across the auto line
        	} else {
        		addSequential(new DriveDistanceCommand((140-RobotMap.robotLength_dimension-(int)(RobotMap.bumperWidth_dimension*2)) + 56/2)); // Drive to halfway across the switch
        		if(Robot.driverPosition == "Left (1)") { // Turn right 90 degrees if on the left
        			//addSequential(new TurnAngleCommand(90)); Not necessary, but optional
        		} else {
        			//addSequential(new TurnAngleCommand(-90)); Not necessary, but optional
        		}
        	}
        	// Dispense cube
        	
        	
        	
        }
    }
}
