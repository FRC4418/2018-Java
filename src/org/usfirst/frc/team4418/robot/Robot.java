/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4418.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4418.robot.commands.AutonomousCommands;
import org.usfirst.frc.team4418.robot.commands.TeleopCommands;
import org.usfirst.frc.team4418.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.EncoderSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.FeedCylinderSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.GearShiftSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.UltrasonicSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.UltrasonicSubsystem2;
import org.usfirst.frc.team4418.robot.subsystems.InfraRedSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.PhotoElectricSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.ShooterAngle;
import org.usfirst.frc.team4418.robot.subsystems.GyroToAnglePID;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

public class Robot extends TimedRobot {
	// Create objects for each subsystem
	public static final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem(); //Create public DriveTrain
	public static final CompressorSubsystem compressor = new CompressorSubsystem(); //Create public Compressor
	public static final GearShiftSubsystem gearShifter = new GearShiftSubsystem(); //Create public GearShifter
	public static final UltrasonicSubsystem ultrasonic = new UltrasonicSubsystem(); //Create public Ultrasonic
	public static final EncoderSubsystem encoders = new EncoderSubsystem(); //Create public encoders
	public static final InfraRedSubsystem infraRed = new InfraRedSubsystem(); //Create public InfraRed
	public static final GyroSubsystem gyroSys = new GyroSubsystem(); //Create public GyroScope
	public static final FeedCylinderSubsystem feedCylinder = new FeedCylinderSubsystem(); //Create public FeedCylinder
	public static final IntakeSubsystem intake = new IntakeSubsystem(); //Create public Intake
	public static final GyroToAnglePID gyroPID = new GyroToAnglePID();
	public static final ShooterAngle shootAngle = new ShooterAngle();
	public static final UltrasonicSubsystem2 ultrasonic2 = new UltrasonicSubsystem2();
	public static final PhotoElectricSubsystem photoElectric = new PhotoElectricSubsystem();
	
	public static OI m_oi;
	Command teleCommand;
	Command autoCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		//m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		// Initialize camera server
		CameraServer.getInstance().startAutomaticCapture();
		gyroSys.calibrate();
		autoCommand = new AutonomousCommands();
		teleCommand = new TeleopCommands();
		//driveTrain.coast();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if(teleCommand!=null) {
			teleCommand.cancel();
		}
		if(autoCommand!=null) {
			autoCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		if(teleCommand != null) {
			teleCommand.start();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
