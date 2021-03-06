package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.EncoderShuffleboardCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Do not require this subsystem! We wish to report values to shuffleboard and link the encoder properties to the gear shifts so that they are always accurate
 */
public class EncoderSubsystem extends Subsystem {

	static Encoder leftEnc = new Encoder(RobotMap.leftEncoderA_DIO_ID,RobotMap.leftEncoderB_DIO_ID);
	static Encoder rightEnc = new Encoder(RobotMap.rightEncoderA_DIO_ID,RobotMap.rightEncoderB_DIO_ID, true);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public EncoderSubsystem() {
		//Actually set the values
		double rpp = ( (1/RobotMap.driveEncoderTicksPerRevolution) / RobotMap.driveEncoderGearRatio ); //Math for revolutions per pulse
		double dpp =  rpp * (Math.PI * RobotMap.driveEncoderWheelDiameter); //Math for distance per pulse
		SmartDashboard.putNumber("distance per pulse", dpp);
		//Set distances per pulse for each encoder
		leftEnc.setDistancePerPulse(dpp);
		rightEnc.setDistancePerPulse(dpp);
		//Set time between pulses before robot is considered stopped
		leftEnc.setMaxPeriod(.1);
		rightEnc.setMaxPeriod(.1);
		
	}
	
	//Helper function to convert units for getters
	//Meant for private use, but why not expose it to the public for other applications?
	public double convertUnitsFromInches(String units,double inches) {
		switch(units.toLowerCase()) {
			case "in":
				return inches;
			case "ft":
				return inches/12;
			case "mm":
				return inches * 25.4;
			case "cm":
				return inches * 2.54;
			case "m":
				return inches * 0.0254;
			default:
				return inches;
		}
	}
	
	//Get the left encoder value in the specified units (optional)
	public double getLeftEncoder(String units) {
		double inches = leftEnc.getDistance();
		return convertUnitsFromInches(units,inches);
	}
	public double getLeftEncoder() {
		return leftEnc.getDistance();
	}
	
	//Get the right encoder value in the specified units (optional)
	public double getRightEncoder(String units) {
		double inches = rightEnc.getDistance();
		return convertUnitsFromInches(units,inches);
	}
	public double getRightEncoder() {
		return rightEnc.getDistance();
	}
	
	//Get the average of the encoder values in the specified units (optional)
	public double getAvgEncoder(String units) {
		double leftInches = leftEnc.getDistance();
		double rightInches = rightEnc.getDistance();
		return convertUnitsFromInches(units,(leftInches + rightInches) / 2);
	}
	public double getAvgEncoder() {
		double leftInches = leftEnc.getDistance();
		double rightInches = rightEnc.getDistance();
		return (leftInches + rightInches) / 2;
	}
	
	//Reset the (optionally specific) encoder distance to zero
	public void reset(String encoder) {
		switch(encoder) {
			case "left":
				leftEnc.reset();
				break;
			case "right":
				rightEnc.reset();
				break;
			default:
				leftEnc.reset();
				rightEnc.reset();
				break;
		}
	}
	public void reset() {
		leftEnc.reset();
		rightEnc.reset();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new EncoderShuffleboardCommand());
    }
}

