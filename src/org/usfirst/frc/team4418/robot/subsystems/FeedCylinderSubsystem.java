package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FeedCylinderSubsystem extends Subsystem {
	public FeedCylinderSubsystem() {
		super();
		feedCylinder.set(DoubleSolenoid.Value.kOff);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static DoubleSolenoid feedCylinder = new DoubleSolenoid(RobotMap.feedShoot,RobotMap.feedDefault);
	public Value getPosition() {
    	return feedCylinder.get();
    }
	
	public boolean isShoot() {
		return getPosition()==DoubleSolenoid.Value.kForward;
	}
    
	public boolean isDefault() {
		return getPosition()==DoubleSolenoid.Value.kReverse;
	}
	
    public void Shoot() {
    	feedCylinder.set(DoubleSolenoid.Value.kForward);
    }
    
    public void Default() {
    	feedCylinder.set(DoubleSolenoid.Value.kReverse);
    }
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

