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
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	//Declare Talon SRX IDs
	public static int leftTalonSRXAID = 10,
			leftTalonSRXBID = 11,
			leftTalonSRXCID = 12,
			rightTalonSRXAID = 20,
			rightTalonSRXBID = 21,
			rightTalonSRXCID = 22;
	
	public static int mainJoystick = 0,
			secondaryJoystick = 1;
	
	public static int gearShift = 1,
			gearShiftHigh = 1,
			gearShiftLow = 0;
	public static int gyroPort = 0;
	
	public static int intakeButton = 3,
			intakeIn = 0,
			intakeOut = 1;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
