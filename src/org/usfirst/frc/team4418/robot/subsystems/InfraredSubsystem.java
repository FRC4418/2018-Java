package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.InfraRedDisplay;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class InfraredSubsystem extends Subsystem {

	AnalogInput infrared = new AnalogInput(RobotMap.infrared_analog_ID);
	public double getInfraredCM () {
		return (Math.pow((((-26.4525 / (35.9049 * infrared.getVoltage())) + 63.7668) / 110.898), -8.71341) - 124.635);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new InfraRedDisplay());
    }
}

