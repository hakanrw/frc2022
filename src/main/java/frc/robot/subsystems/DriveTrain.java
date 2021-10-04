package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.JoystickDrive;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotMap;


public class DriveTrain extends Subsystem {
    private final double Kp = 0.02;
    public void initDefaultCommand() {
       
    	setDefaultCommand(new JoystickDrive());
    }
    public void drive(double x,double y) {
        RobotMap.driveSystem.tankDrive(x, y);
    } 
    public void drive(Joystick joy,double mult) {
        drive(joy.getRawAxis(1)*mult, joy.getRawAxis(3)*-mult);
    }
    public void GyroDrive(ADIS16448_IMU gyro,boolean x) {
		GyroDrive(gyro, x, 1);
	}
    public void GyroDrive(ADIS16448_IMU gyro, boolean x, float speed) {
        double angle = gyro.getAngle();
        if(x) {

            RobotMap.left.setVoltage((angle*Kp+0.3)*12 * speed);
            RobotMap.right.setVoltage((0.3+angle*Kp)*12 * speed);
        }
        else {
            RobotMap.left.setVoltage((angle*Kp+0.3)*-12 * speed);
            RobotMap.right.setVoltage((0.5+angle*0.3)*-12 * speed);
        }
        Timer.delay(0.0004);
    }
	public void GyroTurn(ADIS16448_IMU gyro,double turn) {
		double angle = gyro.getAngle();
		double power=(turn-angle)*Kp*1;
		Timer.delay(0.0004);
        RobotMap.left.setVoltage(-power*12);
        RobotMap.right.setVoltage(power*12);
    
    }
	
}

