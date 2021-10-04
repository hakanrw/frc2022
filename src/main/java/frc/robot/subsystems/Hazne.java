/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.commands.HazneManuel;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
/**
 * An example subsystem. You can replace with me with your own subsystem.
 */
public class Hazne extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  @Override
  protected void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new HazneManuel(0));
  }
  public void move(double power){
    RobotMap.HazneMotor1.set(power);
    RobotMap.HazneMotor2.set(-power);
  }
}
