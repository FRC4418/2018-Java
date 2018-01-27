package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.commands.UltrasonicCommand;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSubsystem extends Subsystem {
		Ultrasonic ultra = new Ultrasonic(4,5);
		
		
		public void setAutomaticMode(boolean enabling){
		ultra.setAutomaticMode(enabling);
		
		
	}
	public double getRangeInch() {
		return ultra.getRangeInches();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UltrasonicCommand());
    
    	
    }
}

