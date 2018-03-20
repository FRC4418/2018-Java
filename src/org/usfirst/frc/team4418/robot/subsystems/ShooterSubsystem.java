package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {

	// Setup ------------------------------------------------------------------------------------------------------------------------------------------------------
    
	/*private static final WPI_TalonSRX leftTalonA = new WPI_TalonSRX(RobotMap.leftShooterTalonSRXA_CAN_ID), // Shooter talons
    		leftTalonB = new WPI_TalonSRX(RobotMap.leftShooterTalonSRXB_CAN_ID),
 			rightTalonA = new WPI_TalonSRX(RobotMap.rightShooterTalonSRXA_CAN_ID),
 			rightTalonB = new WPI_TalonSRX(RobotMap.rightShooterTalonSRXB_CAN_ID);
    private static final DoubleSolenoid feedSolenoid = new DoubleSolenoid(RobotMap.feedLoadSolenoid_PCM_ID, RobotMap.feedShootSolenoid_PCM_ID); // Feed solenoid
    private static boolean isSetForScale = false; // Wheter the shooter is shooting in the scale (true) or the switch (false)
    
    public ShooterSubsystem() {
    	leftTalonB.follow(leftTalonA); // Setup master-slave relationships for talons
    	rightTalonB.follow(rightTalonA);
    	
    	feedSolenoid.set(DoubleSolenoid.Value.kReverse); // Set the feed solenoid to the loading position
    }
    */
    public void initDefaultCommand() {}
    
    
    // Talons ------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void runShooter() { // Run the shooter
    	/*if(isSetForScale) { // Run the shooter for shooting in the scale
    		leftTalonA.set(0.6);
    		rightTalonA.set(-0.6);
    	} else { // Run the shooter for shooting in the switch
    		leftTalonA.set(0.3);
    		rightTalonA.set(-0.3);
    	}*/
    }
    
    public void stopShooter() { // Stop the shooter
    	/*leftTalonA.set(0);
    	rightTalonA.set(0);*/
    }
    
    
    
    public boolean getMode() { // Get whether the shooter is shooting in the scale (true) or in the switch (false)
    	//return isSetForScale;
    	return true;
    }
    
    public void setMode(boolean setForScale) { // Get whether the shooter is shooting in the scale (true) or in the switch (false)
    	//isSetForScale = setForScale;
    }
    
    public boolean isAtSpeed() { // Get whether the shooter is at speed or not
    	return true;
    }
    
    
    // Feed ------------------------------------------------------------------------------------------------------------------------------------------------------
    public void setFeedPosition(boolean position) { // Set the feed position, true is shooting, false is loading
    	//feedSolenoid.set(position ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }
    
    public boolean getFeedPosition() {
    	//return feedSolenoid.get() == DoubleSolenoid.Value.kForward;
    	return true;
    }
    
}

