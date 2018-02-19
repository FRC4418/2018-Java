package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterAngle extends Subsystem {
	
	public static DoubleSolenoid shootAngle = new DoubleSolenoid(RobotMap.shootUpwardsSolenoid_PCM_ID, RobotMap.shootDownwardsSolenoid_PCM_ID);
	
	public ShooterAngle() {
		super();
		shootAngle.set(DoubleSolenoid.Value.kOff);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Value getUp() {
    	return shootAngle.get();
    }
	
	public boolean isUp() {
		return getUp()==DoubleSolenoid.Value.kForward;
	}
    
	public boolean isDown() {
		return getUp()==DoubleSolenoid.Value.kReverse;
	}
	
    public void shootUp() {
    	shootAngle.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shootDown() {
    	shootAngle.set(DoubleSolenoid.Value.kReverse);
    }

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

