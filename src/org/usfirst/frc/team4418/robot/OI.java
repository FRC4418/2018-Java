/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4418.robot;

import org.usfirst.frc.team4418.robot.commands.FeedShiftCommand;
import org.usfirst.frc.team4418.robot.commands.GearShiftCommand;
import org.usfirst.frc.team4418.robot.commands.IntakeCommand;
import org.usfirst.frc.team4418.robot.commands.IntakeMotorCommand1;
import org.usfirst.frc.team4418.robot.commands.IntakeMotorCommand2;
import org.usfirst.frc.team4418.robot.commands.LineupGroup;
import org.usfirst.frc.team4418.robot.commands.ShootGroup;
import org.usfirst.frc.team4418.robot.commands.SpinIntake;
import org.usfirst.frc.team4418.robot.commands.shootAngleCommand;

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
	private static Button gearShiftButton = new JoystickButton(joystick0,RobotMap.gearShift_button); //GearShift Button
	private static Button triggerIntakeButton = new JoystickButton(joystick0,RobotMap.triggerIntake_button);
	private static Button intakeButton = new JoystickButton(joystick0,RobotMap.intake_button);
	public static Button shootButton = new JoystickButton(joystick0,RobotMap.shoot_button);
	private static Button lineupButton = new JoystickButton(joystick0,RobotMap.lineup_button);
	private static Button angleShootButton = new JoystickButton(joystick0,RobotMap.angleShoot_button);
	private static Button feedButton = new JoystickButton(joystick0,RobotMap.feed_button);
	private static Button intakeButton1 = new JoystickButton(joystick0,RobotMap.intakeButton1);
	private static Button intakeButton2 = new JoystickButton(joystick0,RobotMap.intakeButton2);
	/*public static Button getGearShiftButton() {
		return gearShiftButton;
	}*/
	
	public OI() {
		gearShiftButton.whenPressed(new GearShiftCommand());
		triggerIntakeButton.whenPressed(new IntakeCommand());
		intakeButton.whenPressed(new SpinIntake());
		shootButton.whenPressed(new ShootGroup());
		feedButton.whenPressed(new FeedShiftCommand());
		lineupButton.whenPressed(new LineupGroup());
		angleShootButton.whenPressed(new shootAngleCommand());
		intakeButton1.whileHeld(new IntakeMotorCommand1());
		intakeButton2.whileHeld(new IntakeMotorCommand2());
	}
}
