package org.usfirst.frc.team4418.robot.commands;

import org.usfirst.frc.team4418.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ToggleGearShiftCommand extends InstantCommand {

    public ToggleGearShiftCommand() {
        super();
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.driveTrain.setGearShiftSolenoid(!Robot.driveTrain.getGearShiftSolenoidState()); // Set the gear shifting solenoid to the other state
    }

}
