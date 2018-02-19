package org.usfirst.frc.team4418.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltrasonicSubsystem2 extends Subsystem {
	//Ultrasonic ultra2 = new Ultrasonic(RobotMap.ultrasonic2Ping_DIO_ID, RobotMap.ultrasonic2Echo_DIO_ID);
	
		
	public UltrasonicSubsystem2() {
		super();
		//ultra2.setEnabled(true);
		//ultra2.setAutomaticMode(false);
	}
	
	public void setAutomaticMode(boolean enabling){
		//ultra2.setAutomaticMode(enabling);
		
		
	}
	/*public double getRangeInch() {	
		return 0;//ultra2.getRangeInches();
	}*/
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new UltrasonicCommand2());
    
    	
    }
}

