package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.IntakeElevationCommand;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	// Setup ------------------------------------------------------------------------------------------------------------------------------------------------------
	private static final WPI_TalonSRX leftTalon = new WPI_TalonSRX(RobotMap.intakeLeftTalonSRX_CAN_ID),
			rightTalon = new WPI_TalonSRX(RobotMap.intakeRightTalonSRX_CAN_ID);
	private static final Talon elevationTalon = new Talon(0);
	private static final DoubleSolenoid armSolenoids = new DoubleSolenoid(RobotMap.intakeOutSolenoid_PCM_ID, RobotMap.intakeInSolenoid_PCM_ID);
	private static boolean intakeMode = false; // When false, act as intake, when true, act as outtake
	
	public IntakeSubsystem() {
		super();
		setArmPosition(false);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new IntakeElevationCommand());
	}
    
	
	// Intake Motors ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void runIntake() {
		leftTalon.set(1 * (intakeMode ? (-1) : 1));
		rightTalon.set(-1 * (intakeMode ? (-1) : 1));
	}
	
	public void stopIntakeMotors() {
		leftTalon.set(0);
		rightTalon.set(0);
	}
	
	public void setIntakeMode(boolean mode) {
		intakeMode = mode;
	}
	
	public boolean getIntakeMode() {
		return intakeMode;
	}
	
	
	// Elevation Motor ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void runElevationMotor(double value) {
		/*if(value == 0) {
			elevationTalon.setNeutralMode(NeutralMode.Brake);
		} else {
			elevationTalon.setNeutralMode(NeutralMode.Coast);
		}*/
		elevationTalon.set(value);
	}
	
	
	// Arm Solenoids ------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void setArmPosition(boolean position) {
		armSolenoids.set(position ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
	}
	
	public boolean getArmPosition() {
		return armSolenoids.get() == DoubleSolenoid.Value.kForward;
	}
}

