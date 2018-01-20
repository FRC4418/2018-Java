package org.usfirst.frc.team4418.robot.subsystems;

import org.usfirst.frc.team4418.robot.commands.StartCompressorCommand;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CompressorSubsystem extends Subsystem {

	// Create objects for the compressor subsystem
	Compressor compressor = new Compressor(0);
	
	// Enables the compressor
	public void enableCompressor() {
		compressor.setClosedLoopControl(true);
	}
	
	// Disables the compressor
	public void disableCompressor() {
		compressor.setClosedLoopControl(false);
	}
	
	// Returns if the compressor is enabled
	public boolean isEnabled() {
		return compressor.enabled();
	}
	
	// Returns if the pressure switch is closed
	public boolean isPressureSwitchClosed() {
		return compressor.getPressureSwitchValue();
	}
	
	// Returns the current used by the compressor
	public double getCurrent() {
		return compressor.getCompressorCurrent();
	}

    public void initDefaultCommand() {
        // Set the default command to enable the compressor by default
    	setDefaultCommand(new StartCompressorCommand());
    }
}

