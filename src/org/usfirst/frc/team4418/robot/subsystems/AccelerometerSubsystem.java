package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.commands.AccelDisplay;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 *
 */
public class AccelerometerSubsystem extends Subsystem {

	public AccelerometerSubsystem() {
		super();
	}

	BuiltInAccelerometer accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public double getX() {
		double value1 = accel.getX();
		double value2 = value1;
		double value3 = value2;
		double value4 = value3;
		double value5 = value4;
		return (value1+value2+value3+value4+value5)/5;
	}
	
	public double getY() {
		double value1 = accel.getY();
		double value2 = value1;
		double value3 = value2;
		double value4 = value3;
		double value5 = value4;
		return (value1+value2+value3+value4+value5)/5;
	}
	
	public double getZ() {
		double value1 = accel.getZ();
		double value2 = value1;
		double value3 = value2;
		double value4 = value3;
		double value5 = value4;
		return (value1+value2+value3+value4+value5)/5;
	}
	
	public void reset() {
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new AccelDisplay());
    }
}

