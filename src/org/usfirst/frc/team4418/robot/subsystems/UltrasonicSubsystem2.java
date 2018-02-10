package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.UltrasonicCommand2;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSubsystem2 extends Subsystem {
	Ultrasonic ultra2 = new Ultrasonic(RobotMap.us2Ping, RobotMap.us2Echo);
	
		
	public UltrasonicSubsystem2() {
		super();
		ultra2.setEnabled(true);
		ultra2.setAutomaticMode(true);
	}
	
	public void setAutomaticMode(boolean enabling){
		ultra2.setAutomaticMode(enabling);
		
		
	}
	public double getRangeInch() {	
		return ultra2.getRangeInches();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UltrasonicCommand2());
    
    	
    }
}

