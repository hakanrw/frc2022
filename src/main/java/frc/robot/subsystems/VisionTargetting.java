/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
public class VisionTargetting extends PIDSubsystem {
  
  
  public VisionTargetting() {
    // Intert a subsystem name and PID values here
    super("Elevator", -0.25, -0.002, 0);
    
    setAbsoluteTolerance(2);
    setInputRange(-60, 60);
    setOutputRange(-0.2, 0.2);
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    double Visionerror = Robot.visiontable.getEntry("targetYaw").getDouble(0);
 
  return Visionerror;
  }

  @Override
  protected void usePIDOutput(double output) {
    RobotMap.ShooterAngleMotor.set(ControlMode.PercentOutput,output);
  }
}
