package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.InfraRedDisplay;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class InfraRedSubsystem extends Subsystem {

	AnalogInput infrared = new AnalogInput(RobotMap.irPort);
	public double getInfraredCM () {
		return (Math.pow((((0.282309 / (1.49288 * infrared.getVoltage()))+1.77726)/0.572067), 5.14527) + 1.22275 - 347) / 8.77;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new InfraRedDisplay());
    }
}

