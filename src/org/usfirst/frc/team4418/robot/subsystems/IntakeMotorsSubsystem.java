package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeMotorsSubsystem extends Subsystem {
	public IntakeMotorsSubsystem() {
		super();
	}
	
	public WPI_TalonSRX intakeMotor1 = new WPI_TalonSRX(RobotMap.motorPort1);
	public WPI_TalonSRX intakeMotor2 = new WPI_TalonSRX(RobotMap.motorPort2);
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

