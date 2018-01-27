package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.EncoderShuffleboardCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Do not require this subsystem! We wish to report values to shuffleboard and link the encoder properties to the gear shifts so that they are always accurate
 */
public class EncoderSubsystem extends Subsystem {

	static Encoder leftEnc = new Encoder(RobotMap.leftEncoderA,RobotMap.leftEncoderB);
	static Encoder rightEnc = new Encoder(RobotMap.rightEncoderA,RobotMap.rightEncoderB,true);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public EncoderSubsystem() {
		//Actually set the values
		double rpp = ( (1/RobotMap.ticksPerRevolution) / RobotMap.gearRatio );
		double dpp =  rpp * (Math.PI * RobotMap.wheelDiameter);
		leftEnc.setDistancePerPulse(dpp);
		rightEnc.setDistancePerPulse(dpp);
	}

	public double getLeftEncoder() {
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new EncoderShuffleboardCommand());
    }
}

