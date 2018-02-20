/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4418.robot;

import org.usfirst.frc.team4418.robot.commands.GearShiftCommand;
import org.usfirst.frc.team4418.robot.commands.LauncherCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Create the joysticks to be used for controlling the robot
	private static Joystick joystick0 = new Joystick(0);
	
	// Create the methods to get joysticks for other parts of the robot
	public static Joystick getDriverJoystick() {
		return joystick0;
	}
	
	public static Joystick joystick1 = new Joystick(1);
	// Create buttons
	
	private static Button gearShiftButton = new JoystickButton(joystick0,RobotMap.gearShift);//GearShift Button
	public static Button launcherButton = new JoystickButton(joystick0,RobotMap.launcherButton);
	/*public static Button getGearShiftButton() {
		return gearShiftButton;
	}*/
	
	
	public OI() {
		gearShiftButton.whenPressed(new GearShiftCommand());
		launcherButton.whenPressed(new LauncherCommand(600));
	}
}
