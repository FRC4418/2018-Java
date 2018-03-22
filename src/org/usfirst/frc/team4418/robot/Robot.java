/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4418.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4418.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.DriveDistancePIDSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.PowerDistributionBoardSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.ShooterSubsystem;
import org.usfirst.frc.team4418.robot.subsystems.TurnAnglePIDSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
	public static final DriveDistancePIDSubsystem driveDistancePID = new DriveDistancePIDSubsystem();
	public static final TurnAnglePIDSubsystem turnAnglePID = new TurnAnglePIDSubsystem();
	public static final CompressorSubsystem compressor = new CompressorSubsystem();
	public static final PowerDistributionBoardSubsystem pdb = new PowerDistributionBoardSubsystem();
	public static final ShooterSubsystem shooter = new ShooterSubsystem();
	public static final IntakeSubsystem intake = new IntakeSubsystem();
	public static OI m_oi;
	
	public static String driverPosition,
		gameData,
		autonomousTarget;
	public static SendableChooser<String> driverPositionChooser = new SendableChooser<String>(),
			autonomousTargetChooser = new SendableChooser<String>();
	
	

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		//m_chooser.addDefault("Drive Distance Auto", new AutoCommandGroup());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		POST();
		
		driverPositionChooser.addDefault("Null", "Null"); // Have the driver select where the robot, is defaulting to a safe option
		driverPositionChooser.addObject("Right (3)", "Right (3)");
		driverPositionChooser.addObject("Middle (2)", "Middle (2)");
		driverPositionChooser.addObject("Left (1)", "Left (1)");
		
		autonomousTargetChooser.addDefault("Cross Auto Line", "Cross Auto Line"); // Have the driver select what action the robot is doing, defaulting to a safe option
		autonomousTargetChooser.addObject("Switch", "Switch");
		autonomousTargetChooser.addObject("Scale", "Scale");
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		printSensorData();
		Scheduler.getInstance().run();
		if(DriverStation.getInstance().isFMSAttached()) { // If FMS is connected, display some data to help drive team
			SmartDashboard.putBoolean("FMS Connection", true);
			SmartDashboard.putString("FMS Reported Alliance", DriverStation.getInstance().getAlliance().toString());
			SmartDashboard.putNumber("FMS Reported Position", DriverStation.getInstance().getLocation());
		} else {
			SmartDashboard.putBoolean("FMS Connection", false);
		}
		SmartDashboard.putString("Driver Position", "Not yet"); // Set a placeholder value for the reported values of what is to occur in autonomous
    	SmartDashboard.putString("Game Message", "Not yet");
    	SmartDashboard.putString("Switch or Scale", "Not yet");
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		printSensorData();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		printSensorData();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		printSensorData();
	}

	public void printSensorData() { // Send sensor values back to the dashboard
		//System.out.println("Hello World");
		SmartDashboard.putNumber("Left Drive Encoder", driveTrain.getLeftEncoder());
		SmartDashboard.putNumber("Right Drive Encoder", driveTrain.getRightEncoder());
		SmartDashboard.putNumber("Acceleration X", driveTrain.getAccelerometeXValue());
		SmartDashboard.putNumber("Acceleration Y", driveTrain.getAccelerometeYValue());
		SmartDashboard.putNumber("Acceleration Z", driveTrain.getAccelerometeZValue());
		SmartDashboard.putBoolean("Compressor Running", compressor.isCompressorRunning());
		//SmartDashboard.putNumber("Power Used", pdb.getTotalEnergy());
		SmartDashboard.putBoolean("Is Driving Forward?", driveTrain.getDriveDirection());
		SmartDashboard.putNumber("FMS Reported Match Time", DriverStation.getInstance().getMatchTime());
	}

	public void POST() { // Check for errors in boot up conditions and respond appropriately
		// Clear sticky fauls on boot
		compressor.clearStickyFaultsInPCM();
		pdb.clearStickyFaultsInPDB();
	}
}
