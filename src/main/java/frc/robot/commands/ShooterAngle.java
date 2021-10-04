/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ShooterAngle extends Command {
  public ShooterAngle() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.visionsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    RobotMap.LED.set(1);
    Robot.visionsystem.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.visionsystem.setSetpoint(0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.visionsystem.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.LED.set(0);
    Robot.visionsystem.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
