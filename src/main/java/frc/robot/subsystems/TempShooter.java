/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterManuel;

/**
 * Add your docs here.
 */
public class TempShooter extends Subsystem {

  private TalonSRX localshooter1 = RobotMap.ShooterMotor1;
  private TalonSRX localshooter2 = RobotMap.ShooterMotor2;
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ShooterManuel(0));
  }
  public void shoot (double power){
    localshooter1.set(ControlMode.PercentOutput, power);
    localshooter2.set(ControlMode.PercentOutput, -power);
  }

}
