/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4418.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Declare jostick IDs
	public static final int
			mainJoystick_ID = 0, //Main driver joystick
			secondaryJoystick_ID = 1, //Secondary driver joystick
			
			rightTankDrive_axis = 5, //The axis on the main driver joystick used for driving
			leftTankDrive_axis = 1,
	
			gearShift_button = 1, //Button to shift between high and low gear on the gear boxes
			intake_button = 3,
			feedChange_button = 2;
	
	// Declare Talon SRX IDs
	public static int
			leftTalonSRXA_CAN_ID = 10, //Drive motors
			leftTalonSRXB_CAN_ID = 11,
			rightTalonSRXA_CAN_ID = 20,
			rightTalonSRXB_CAN_ID = 21,
			
			leftShooterTalonSRXA_CAN_ID = 30, //Shooter motors
			leftShooterTalonSRXB_CAN_ID = 31,
			rightShooterTalonSRXA_CAN_ID = 35,
			rightShooterTalonSRXB_CAN_ID = 36,
			
			intakeLeftTslonSRX_CAN_ID = 40, //Intake motors
			intakeRightTalonSRX_CAN_ID =41,
			intakeLiftTalonSRX_CAN_ID = 45,
			
			fanTalonSRX_CAN_ID = 50, //Fan for inflating climber
			
			climberTalonSRX_CAN_ID = 60; //Climber motor

	// Declare drive encoder IDs
	public static final int
			leftEncoderA_DIO_ID = 0,
			leftEncoderB_DIO_ID = 1,
			rightEncoderA_DIO_ID = 2,
			rightEncoderB_DIO_ID = 3;
	public static final double //Declare variable for reading from the encoders
			driveEncoderGearRatio = 5.4, //Drive shaft to encoder (NOT THE OTHER WAY AROUND)
			driveEncoderTicksPerRevolution = 256,
			driveEncoderWheelDiameter = 6; //inches
	
	// Declare ultrasonic IDs
	public static int 
			ultrasonic2Ping_DIO_ID = 8, //The first ultrasonic
			ultrasonic2Echo_DIO_ID = 9,
			
			ultrasonic1Ping_DIO_ID = 6, //The second ultrasonic
			ultrasonic1Echo_DIO_ID = 7;
	
	// Declare the gyro ID
	public static int gyro_analog_ID = 0;

	// Declare the infrared ID
	public static int infrared_analog_ID = 3;
	
	public static int
			intakeInSolenoid_PCM_ID = 4,
			intakeOutSolenoid_PCM_ID = 5;
	public static int 
			feedShootSolenoid_PCM_ID = 2,
			feedLoadSolenoid_PCM_ID = 3;
	
	public static int 
			shootUpwardsSolenoid_PCM_ID = 6,
			shootDownwardsSolenoid_PCM_ID = 7;
	
	public static int
			gearShiftLowGearSolenoid_PCM_ID = 0,
			gearShiftHighGearSolenoid_PCM_ID = 1;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
