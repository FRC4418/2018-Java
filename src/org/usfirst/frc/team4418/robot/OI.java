/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4418.robot;

import org.usfirst.frc.team4418.robot.commands.ToggleArmPositionCommand;
import org.usfirst.frc.team4418.robot.commands.ToggleDriveDirectionCommand;
import org.usfirst.frc.team4418.robot.commands.ToggleGearShiftCommand;
import org.usfirst.frc.team4418.robot.commands.ToggleIntakeCommand;
import org.usfirst.frc.team4418.robot.commands.ToggleIntakeModeCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Joysticks ------------------------------------------------------------------------------------------------------------------------------------------------------
	public static final Joystick mainDriverJoystickLeft = new Joystick(RobotMap.mainJoystickLeft_ID), // Create the joysticks
			mainDriverJoystickRight = new Joystick(RobotMap.mainJoystickRight_ID),
			secondaryJoystick = new Joystick(RobotMap.secondaryJoystick_ID);
	
	
	// Buttons ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private static final Button toggleGearShift = new JoystickButton(mainDriverJoystickRight, RobotMap.toggleGearShift_button), // Create the buttons
			toggleDriveDirection = new JoystickButton(mainDriverJoystickLeft, RobotMap.toggleDriveDirection_button),
			toggleIntakeMotors = new JoystickButton(secondaryJoystick, RobotMap.toggleIntakeMotors_button),
			toggleIntakeArmPosition = new JoystickButton(secondaryJoystick, RobotMap.toggleIntakeArms_button),
			toggleIntakeMode = new JoystickButton(secondaryJoystick, RobotMap.toggleIntakeMode_button);
	
	
	
	public OI() { // Assign functionality to the buttons
		toggleGearShift.whenPressed(new ToggleGearShiftCommand()); // Toggle the gear shifter in the drive train subsystem
		toggleDriveDirection.whenPressed(new ToggleDriveDirectionCommand()); // Toggle the direction of driving for the drive train subsystem
		toggleIntakeMotors.toggleWhenPressed(new ToggleIntakeCommand()); // Toggle the intake motors on or off
		toggleIntakeArmPosition.whenPressed(new ToggleArmPositionCommand()); // Toggle the intake arm position
		toggleIntakeMode.whenPressed(new ToggleIntakeModeCommand()); // Toggle the intake to an outtake
	}
	
}
