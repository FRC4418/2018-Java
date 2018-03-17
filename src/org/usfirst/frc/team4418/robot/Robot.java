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
import org.usfirst.frc.team4418.robot.subsystems.*;

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
	public static final EncoderSubsystem encoders = new EncoderSubsystem(); //Create public encoders
	public static final GyroSubsystem gyro = new GyroSubsystem(); //Create public GyroScope
	public static final IntakeSubsystem intake = new IntakeSubsystem(); //Create public Intake
	public static final GyroToAnglePID gyroPID = new GyroToAnglePID();
	public static final EncoderPID encoderPID = new EncoderPID();
	public static final AccelerometerSubsystem accel = new AccelerometerSubsystem();
	public static final CompressorSubsystem compressor = new CompressorSubsystem(); //Create public Compressor
	public static final GearShiftSubsystem gearShifter = new GearShiftSubsystem(); //Create public GearShifter
	
	public static SendableChooser<String> switchChooser = new SendableChooser<String>();
	public static SendableChooser<String> autoChooser = new SendableChooser<String>();
	
	public static boolean autoStop = false;
	public static boolean shootStop = false;
	
	public static OI m_oi;
	Command teleCommand;
	static Command autoCommand;
	
	public static String driverPos;
	public static String gameData;
	public static String switchOrScale;
	
	//SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		//m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", m_chooser);
		
		// Initialize camera server
		CameraServer.getInstance().startAutomaticCapture();
		gyro.calibrate();
		encoders.reset();
		gyro.clear();
    	
    	autoChooser.addDefault("Straight", "Straight");
    	autoChooser.addObject("Position One (left)", "Position One (left)");
    	autoChooser.addObject("Position Two (middle)", "Position Two (middle)");
    	autoChooser.addObject("Position Three (right)", "Position Three (right)");
    	
    	switchChooser.addDefault("Switch", "Switch");
    	switchChooser.addObject("Scale", "Scale");
    	
    	SmartDashboard.putData("1", autoChooser);
    	SmartDashboard.putData("2", switchChooser);
    	
    	
		autoCommand = new AutonomousCommands();
		teleCommand = new TeleopCommands();
		driveTrain.coast();
		gyroPID.disable();
		encoderPID.disable();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		driveTrain.coast();
		encoders.reset();
		gyro.clear();
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
		encoders.reset();
		gyro.clear();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		// schedule the autonomous command (example)
		if(teleCommand!=null) {
	    	/*Robot.encoderPID.disable();
	    	Robot.gyroPID.disable();
	    	Robot.leftBackPID.disable();
	    	Robot.rightBackPID.disable();*/
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
		SmartDashboard.putNumber("auto periodic motor", driveTrain.getLeftA());
		//System.out.println("Running auto");
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autoCommand != null) {
			autoCommand.cancel();
	    	/*Robot.encoderPID.disable();
	    	Robot.gyroPID.disable();
	    	Robot.leftBackPID.disable();
	    	Robot.rightBackPID.disable();*/
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
		SmartDashboard.putNumber("tele periodic motor", driveTrain.getLeftA());
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
