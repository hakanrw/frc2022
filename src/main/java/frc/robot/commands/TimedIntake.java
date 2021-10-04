package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

public class TimedIntake extends TimedCommand {
    private double power;
    public TimedIntake(double time, double p) {
        // Use requires() here to declare subsystem dependencies
        super(time);
        requires(Robot.tintake);
        power = p;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.tintake.Intake(power);
    }

    @Override
    protected void end() {
        Robot.tintake.Intake(0);
    }

    @Override
    protected void interrupted() {
        Robot.tintake.Intake(0);
    }
}
