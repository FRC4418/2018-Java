package org.usfirst.frc.team4418.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PowerDistributionBoardSubsystem extends Subsystem {

	private static final PowerDistributionPanel pdb = new PowerDistributionPanel();
	
	public PowerDistributionBoardSubsystem() { // Setup the PDB
		pdb.resetTotalEnergy();
	}
	
	public double getTotalEnergy() { // Get the total energery in joules that the PDB has output
		return pdb.getTotalEnergy();
	}
	
	public void clearStickyFaultsInPDB() { // Clear errors
		pdb.clearStickyFaults();
	}

    public void initDefaultCommand() {
    }
}

