package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeMotorsSubsystem extends Subsystem {
	public IntakeMotorsSubsystem() {
		super();
	}
	
	TalonSRX intakeMotor1 = new TalonSRX(RobotMap.motorPort1);
	TalonSRX intakeMotor2 = new TalonSRX(RobotMap.motorPort2);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

