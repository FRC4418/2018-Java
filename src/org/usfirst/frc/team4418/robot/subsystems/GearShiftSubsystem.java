package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearShiftSubsystem extends Subsystem {
	public GearShiftSubsystem() {
		super();
		gearShifterSolenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	public static DoubleSolenoid gearShifterSolenoid = new DoubleSolenoid(RobotMap.gearShiftLowGearSolenoid_PCM_ID,RobotMap.gearShiftHighGearSolenoid_PCM_ID);
	

	public boolean isHighGear() {
    	return DoubleSolenoid.Value.kForward==gearShifterSolenoid.get();
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

