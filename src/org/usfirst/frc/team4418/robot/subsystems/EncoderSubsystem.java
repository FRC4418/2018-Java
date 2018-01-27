package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Do not require this subsystem! We wish to report values to shuffleboard and link the encoder properties to the gear shifts so that they are always accurate
 */
public class EncoderSubsystem extends Subsystem {

	Encoder leftEnc = new Encoder(RobotMap.leftEncoderA,RobotMap.leftEncoderB);
	Encoder rightEnc = new Encoder(RobotMap.rightEncoderA,RobotMap.rightEncoderB,true);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public EncoderSubsystem() {
		
	}
	
	private static void setProps(bool isHighGear) {
		float highGearRatio = 9.07;
		float lowGearRatio = 19.61;
		if(isHighGear) {
			
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

