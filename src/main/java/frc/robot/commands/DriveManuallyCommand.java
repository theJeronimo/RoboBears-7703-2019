/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveManuallyCommand extends Command {
  public DriveManuallyCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double moveSpeed = Robot.oi.stick.getY();
    double turnSpeed = Robot.oi.stick.getX();
    // double moveSpeed = Robot.oi.xboxController.getY(Hand.kLeft);
    // double turnSpeed = Robot.oi.xboxController.getX(Hand.kRight);
    
    // Exponential function to make acceleration smoother
    // (x/|x|)*((10^|x|-1)/9)
    double move = Robot.driveSubsystem.expSpeed(moveSpeed);
    double turn = Robot.driveSubsystem.expSpeed(turnSpeed);

    Robot.driveSubsystem.manualDrive(move, turn);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
