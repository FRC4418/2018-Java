package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.GyroDisplay;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class GyroSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//AnalogInput gyro = new AnalogInput(RobotMap.gyroPort);
	
	private Gyro gyro = new AnalogGyro(RobotMap.gyro_analog_ID);
	
	public double getAngle() {
		double angle = gyro.getAngle();
		return angle;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new GyroDisplay());
    }

	public void clear() {
		// TODO Auto-generated method stub
		gyro.reset();
	}

	public void calibrate() {
		// TODO Auto-generated method stub
		gyro.calibrate();
	}
}

