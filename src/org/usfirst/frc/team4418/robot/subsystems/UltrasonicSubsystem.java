package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.UltrasonicCommand;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UltrasonicSubsystem extends Subsystem {
	Ultrasonic ultra = new Ultrasonic(RobotMap.ultrasonic1Ping_DIO_ID, RobotMap.ultrasonic1Echo_DIO_ID);
	Ultrasonic ultra2 = new Ultrasonic(RobotMap.ultrasonic2Ping_DIO_ID, RobotMap.ultrasonic2Echo_DIO_ID);
	public static boolean hey = false;
		
	public UltrasonicSubsystem() {
		super();
		ultra.setName("Ultra1");
		ultra2.setName("Ultra2");
		ultra.setEnabled(true);
		ultra2.setEnabled(true);
		ultra.setAutomaticMode(true);
		ultra2.setAutomaticMode(true);
		SmartDashboard.putNumber("A+B", ultra.getRangeInches()+ultra2.getRangeInches());
	}
	
	public void setAutomaticMode(boolean enabling){
		//ultra.setAutomaticMode(enabling);
		
		
	}
	public double getRangeInchUltra1() {
		//SmartDashboard.putNumber("A+B", ultra.getRangeInches()+ultra2.getRangeInches());
		return ultra.getRangeInches();
	}
	
	public double getRangeInchUltra2() {
		return ultra2.getRangeInches();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new UltrasonicCommand());
    
    	
    }
}

