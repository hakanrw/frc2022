package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Sleep extends Command {
    long startMillis;
    long endMillis;
    double timeout;

    Sleep(double timeout) {
        this.timeout = timeout;
    }

    @Override
    protected void initialize() {
        startMillis = System.currentTimeMillis();
        endMillis = startMillis + (long) Math.floor(timeout * 1000);
    }

    @Override
    protected boolean isFinished() {
        return System.currentTimeMillis() > endMillis;
    }
}
