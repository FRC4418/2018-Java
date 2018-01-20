package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearShiftSubsystem extends Subsystem {
	public GearShiftSubsystem() {
		super();
		gearShifterSolenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	public static DoubleSolenoid gearShifterSolenoid = new DoubleSolenoid(RobotMap.gearShiftHigh,RobotMap.gearShiftLow);
	

	public Value getGear() {
    	return gearShifterSolenoid.get();
    }
	
	public boolean isHighGear() {
		return getGear()==DoubleSolenoid.Value.kForward;
	}
    
	public boolean isLowGear() {
		return getGear()==DoubleSolenoid.Value.kReverse;
	}
	
    public void highGear() {
    	gearShifterSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void lowGear() {
    	gearShifterSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new GearShiftCommand());
    }
}

