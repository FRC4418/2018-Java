package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearShiftSubsystem extends Subsystem {
	public GearShiftSubsystem() {
		super();
		gearShifterSolenoid.set(false);
	}
	
	public static Solenoid gearShifterSolenoid = new Solenoid(RobotMap.gearShift);
	

	public boolean getGear() {
    	return gearShifterSolenoid.get();
    }
	
	public boolean isHighGear() {
		return getGear()==true;
	}
    
	public boolean isLowGear() {
		return getGear()==false;
	}
	
    public void highGear() {
    	gearShifterSolenoid.set(true);
    }
    
    public void lowGear() {
    	gearShifterSolenoid.set(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new GearShiftCommand());
    }
}

