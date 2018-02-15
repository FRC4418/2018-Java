package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.RobotMap;
import org.usfirst.frc.team4418.robot.commands.LauncherCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LauncherSubsystem extends Subsystem {
	
	public LauncherSubsystem() {
		super();
		
		
		
		leftLaunchB.follow(leftLaunchA);
		//leftLaunchC.follow(leftLaunchA);
		rightLaunchB.follow(leftLaunchA);
		//rightLaunchC.follow(leftLaunchA);
		rightLaunchA.follow(leftLaunchA);
	
	}
	
	public static WPI_TalonSRX leftLaunchA = new WPI_TalonSRX(RobotMap.leftLaunchA);
	public static WPI_TalonSRX leftLaunchB = new WPI_TalonSRX(RobotMap.leftLaunchB);
	//public WPI_TalonSRX leftLaunchC = new WPI_TalonSRX(RobotMap.leftLaunchC);
	public static WPI_TalonSRX rightLaunchA = new WPI_TalonSRX(RobotMap.rightLaunchA);
	public static WPI_TalonSRX rightLaunchB = new WPI_TalonSRX(RobotMap.rightLaunchB);
	//public WPI_TalonSRX rightLaunchC = new WPI_TalonSRX(RobotMap.rightLaunchC);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

