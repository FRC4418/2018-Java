package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	public IntakeSubsystem() {
		super();
		intakeSolenoid.set(DoubleSolenoid.Value.kOff);
	}
	public static DoubleSolenoid intakeSolenoid = new DoubleSolenoid(RobotMap.intakeOut,RobotMap.intakeIn);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Value getIntake() {
    	return intakeSolenoid.get();
    }
	
	public boolean isOut() {
		return getIntake()==DoubleSolenoid.Value.kForward;
	}
    
	public boolean isIn() {
		return getIntake()==DoubleSolenoid.Value.kReverse;
	}
	
    public void extendOut() {
    	intakeSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void extendIn() {
    	intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

