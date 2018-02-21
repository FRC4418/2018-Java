package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RearRightMotor extends Subsystem {
	
	static Encoder rightRearEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	static double launcherRate = rightRearEncoder.getRate();
	public static WPI_TalonSRX rightRearMotor = new WPI_TalonSRX(RobotMap.rightRearMotor);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

