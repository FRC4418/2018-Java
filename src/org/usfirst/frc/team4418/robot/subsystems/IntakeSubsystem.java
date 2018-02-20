package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	public IntakeSubsystem() {
		super();
		intakeSolenoid.set(DoubleSolenoid.Value.kOff);
		intakeLeftTalonSRX.setNeutralMode(NeutralMode.Brake);
		intakeRightTalonSRX.setNeutralMode(NeutralMode.Brake);
	}
	public static WPI_TalonSRX intakeLeftTalonSRX = new WPI_TalonSRX(RobotMap.intakeLeftTalonSRX_CAN_ID);
	public static WPI_TalonSRX intakeRightTalonSRX = new WPI_TalonSRX(RobotMap.intakeRightTalonSRX_CAN_ID);
	public static DoubleSolenoid intakeSolenoid = new DoubleSolenoid(RobotMap.intakeOutSolenoid_PCM_ID,RobotMap.intakeInSolenoid_PCM_ID);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Value getIntake() {
    	return intakeSolenoid.get();
    }
	
	public boolean isOut() {
		return getIntake()==DoubleSolenoid.Value.kForward;
	}
    
	public boolean isIn() {
		return getIntake()==DoubleSolenoid.Value.kReverse;
	}
	
    public void extendOut() {
    	intakeSolenoid.set(DoubleSolenoid.Value.kForward);
    	intakeLeftTalonSRX.set(.8);
    	intakeRightTalonSRX.set(-.8);
    }
    
    public void extendIn() {
    	intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    	intakeLeftTalonSRX.set(0);
    	intakeRightTalonSRX.set(0);
    }
    public boolean isSpin() {
    	return intakeLeftTalonSRX.get()!=0.0;
    }
    public void stopSpin() {
    	intakeLeftTalonSRX.set(0);
    	intakeRightTalonSRX.set(0);
    }
    public void startSpin() {
    	intakeLeftTalonSRX.set(.7);
    	intakeRightTalonSRX.set(-.7);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

