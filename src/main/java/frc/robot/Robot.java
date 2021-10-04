/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.HazneManuel;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.GyroTurn;
import frc.robot.subsystems.VisionTargetting;
import frc.robot.subsystems.Hazne;
import frc.robot.subsystems.LEDsubsystem;
import frc.robot.subsystems.ShooterRPM;
import frc.robot.subsystems.TempClimb;
import frc.robot.subsystems.TempIntake;
import frc.robot.subsystems.TempShooter;
import frc.robot.subsystems.TempShooterAngle;
import frc.robot.subsystems.TempWheel;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  public static OI IO;
  public static VisionTargetting visionsystem = new VisionTargetting();
  public static DriveTrain drivetrain = new DriveTrain();
  public static Hazne hazne = new Hazne();
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  public static NetworkTable visiontable;
  public static CameraServer cameraServer;
  public static UsbCamera visionCam;
  public static LEDsubsystem leDsubsystem = new LEDsubsystem();
  public static TempShooterAngle tanglemanuel = new TempShooterAngle();
  public static TempShooter tshooter = new TempShooter();
  public static TempIntake tintake = new TempIntake(); 
  public static TempClimb tclimb = new TempClimb();
  public static TempWheel twheel = new TempWheel();
  public static ShooterRPM SRPM = new ShooterRPM();
  public static GyroTurn Gturn = new GyroTurn();
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    IO = new OI();
    RobotMap.driveSystem = new DifferentialDrive(RobotMap.left,RobotMap.right);
    m_chooser.setDefaultOption("Default Auto", new AutonomousCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    RobotMap.gyro.calibrate();
    cameraServer = CameraServer.getInstance();
    visionCam = cameraServer.startAutomaticCapture();
    visionCam.setResolution(640, 480);
    visiontable = NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("ps3-eye camera");
    RobotMap.leftMotor1.setInverted(true);
    RobotMap.leftMotor2.setInverted(true);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Angle",RobotMap.gyro.getAngle());
    SmartDashboard.putNumber("RPM", RobotMap.ShooterEncoder.getRate()*60 );
    SmartDashboard.putNumber("VisionError",Robot.visiontable.getEntry("targetYaw").getDouble(0));
    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    // Robot.Gturn.enable();
    // RobotMap.gyro.reset();

    // new AutonomousCommand().start();
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    Robot.Gturn.disable();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

}
