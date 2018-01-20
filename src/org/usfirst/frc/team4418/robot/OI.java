/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4418.robot;

import org.usfirst.frc.team4418.robot.commands.GearShiftCommand;

import edu.wpi.first.wpilibj.Joystick;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
=======
import edu.wpi.first.wpilibj.buttons.*;
>>>>>>> origin/add-gear-shift

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
<<<<<<< HEAD
	// Create the joysticks to be used for controlling the robot
	private static Joystick joystick0 = new Joystick(0);
	
	// Create the methods to get joysticks for other parts of the robot
	public static Joystick getDriverJoystick() {
		return joystick0;
	}
	
	// Create buttons
	
	
	public OI() {
		// Create triggers to run commands from button inputs
	}
=======
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	private static Joystick joystick0 = new Joystick(RobotMap.mainJoystick); //Main Joystick
	public static Joystick getJoystick0() {
		return joystick0;
	}
	
	private static Button gearShiftButton = new JoystickButton(joystick0,RobotMap.gearShift); //GearShift Button
	/*public static Button getGearShiftButton() {
		return gearShiftButton;
	}*/
	
	public OI() {
		gearShiftButton.whenPressed(new GearShiftCommand());
	}
	
>>>>>>> origin/add-gear-shift
}
