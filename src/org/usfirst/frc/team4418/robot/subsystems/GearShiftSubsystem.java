package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.GearShiftCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearShiftSubsystem extends Subsystem {
	public static DoubleSolenoid gearShifterSolenoid = new DoubleSolenoid(RobotMap.gearShiftHigh,RobotMap.gearShiftLow);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GearShiftCommand());
    }
    
    public static int lowGear = 0,
    		highGear = 1;
    
    public void getGear() {
    	
    }
    
}

