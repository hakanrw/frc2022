/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import java.sql.Time;

public class AutonomousCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  public AutonomousCommand() {
    /*addSequential(new GyroTurn(10));
    addSequential(new GyroDrive(true, 0.5f),0.8);


    addSequential(new Sleep(1));
    addSequential(new GyroTurn(0));

    //addParallel(new TimedIntake(3, 0.8));
    addSequential(new GyroDrive(false, 0.8f), 2);
    addSequential(new GyroDrive(true, 0.8f),2);

    addSequential(new GyroTurn(-45));

    addSequential(new GyroDrive(false, 0.3f),0.8);

    addSequential(new GyroTurn(0));*/
    addParallel(new TimedIntake(3, 0.8));
    addSequential(new GyroDrive(false, 0.5f),2.6);
    addSequential(new GyroTurn(30));
    addSequential(new GyroDrive(false, 0.4f),0.4);








  }
}
