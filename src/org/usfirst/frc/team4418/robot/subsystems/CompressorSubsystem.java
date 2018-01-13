package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.commands.StartCompressorCommand;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CompressorSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Compressor compressor = new Compressor(0);
	
	public void enableCompressor() {
		compressor.setClosedLoopControl(true);
	}
	
	public void disableCompressor() {
		compressor.setClosedLoopControl(false);
	}
	
	public boolean isEnabled() {
		return compressor.enabled();
	}
	
	public boolean isPressureSwitchClosed() {
		return compressor.getPressureSwitchValue();
	}
	
	public double getCurrent() {
		return compressor.getCompressorCurrent();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StartCompressorCommand());
    }
}

