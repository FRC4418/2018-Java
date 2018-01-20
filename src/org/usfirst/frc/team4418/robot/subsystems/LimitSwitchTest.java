package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.LimitSwitchCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LimitSwitchTest extends Subsystem {

	DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitch);
	
	public LimitSwitchTest() {
		super();
	}
	
	public boolean checkIfPushed() {
		return limitSwitch.get();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LimitSwitchCommand());
    }
}

