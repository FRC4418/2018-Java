package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.InfraRedDisplay;
import org.usfirst.frc.team4418.robot.commands.PhotoElectricDisplay;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
public class PhotoElectricSubsystem extends Subsystem {
	public PhotoElectricSubsystem() {
		super();
	}
	AnalogInput photoElectric = new AnalogInput(RobotMap.photoElectric);
	public double getPhotoElectric () {
		return (photoElectric.getVoltage());
		}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new PhotoElectricDisplay());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

