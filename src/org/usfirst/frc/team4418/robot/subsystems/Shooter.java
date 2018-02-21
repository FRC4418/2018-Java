package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	public Shooter() {
		leftShooterTalonSRXA.setNeutralMode(NeutralMode.Coast);
		leftShooterTalonSRXB.setNeutralMode(NeutralMode.Coast);
		rightShooterTalonSRXA.setNeutralMode(NeutralMode.Coast);
		rightShooterTalonSRXB.setNeutralMode(NeutralMode.Coast);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	WPI_TalonSRX leftShooterTalonSRXA = new WPI_TalonSRX(RobotMap.leftShooterTalonSRXA_CAN_ID),
			leftShooterTalonSRXB = new WPI_TalonSRX(RobotMap.leftShooterTalonSRXA_CAN_ID),
			rightShooterTalonSRXA = new WPI_TalonSRX(RobotMap.rightShooterTalonSRXA_CAN_ID),
			rightShooterTalonSRXB = new WPI_TalonSRX(RobotMap.rightShooterTalonSRXB_CAN_ID);
	
	Encoder leftShooterTalonSRXA_encoder = new Encoder(11,12),
			leftShooterTalonSRXB_encoder = new Encoder(13,14),
			rightShooterTalonSRXA_encoder = new Encoder(15,16),
			rightShooterTalonSRXB_encoder = new Encoder(17,18);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot(double speed) {
    	leftShooterTalonSRXA.set(speed);
    	leftShooterTalonSRXB.set(speed);
    	rightShooterTalonSRXA.set(speed);
    	rightShooterTalonSRXB.set(speed);
    }
    
    public void stop() {
    	leftShooterTalonSRXA.set(0);
    	leftShooterTalonSRXB.set(0);
    	rightShooterTalonSRXA.set(0);
    	rightShooterTalonSRXB.set(0);
    }
    
    public int leftAEnc() {
    	return leftShooterTalonSRXA_encoder.get();
    }
    public int leftBEnc() {
    	return leftShooterTalonSRXB_encoder.get();
    }
    public int rightAEnc() {
    	return rightShooterTalonSRXA_encoder.get();
    }
    public int rightBEnc() {
    	return rightShooterTalonSRXB_encoder.get();
    }
    public double leftAEncRate() {
    	return leftShooterTalonSRXA_encoder.getRate();
    }
    public double leftBEncRate() {
    	return leftShooterTalonSRXB_encoder.getRate();
    }
    public double rightAEncRate() {
    	return rightShooterTalonSRXA_encoder.getRate();
    }
    public double rightBEncRate() {
    	return rightShooterTalonSRXB_encoder.getRate();
    }
}

