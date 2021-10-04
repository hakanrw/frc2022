/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class GyroTurn extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  public GyroTurn() {
    // Intert a subsystem name and PID values here
    super("GyroTurn", 0,02, 0, 0);
    setInputRange(-180, 180);
    setOutputRange(-4, 4);
    setAbsoluteTolerance(4);

    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return RobotMap.gyro.getAngle();
  }

  @Override
  protected void usePIDOutput(double output) {
    RobotMap.left.setVoltage(-output);
    RobotMap.right.setVoltage(output);
  }
}
