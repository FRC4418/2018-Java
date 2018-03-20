package org.usfirst.frc.team4418.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CompressorSubsystem extends Subsystem {

	private static final Compressor compressor = new Compressor();
	
	public CompressorSubsystem() { // Setup the compressor
		compressor.setClosedLoopControl(true);
	}
	
	public boolean isCompressorRunning() { // Is the compressor actively running (true), or in standby (false)
		return compressor.getPressureSwitchValue();
	}
	
	public void clearStickyFaultsInPCM() { // Clear errors
		compressor.clearAllPCMStickyFaults();
	}

    public void initDefaultCommand() {
    }
}

