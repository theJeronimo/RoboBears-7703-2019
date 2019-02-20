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

public class DriveManuallyCommand extends Command {
  public DriveManuallyCommand() {
    requires(Robot.driveSubsystem);
  }

  @Override

  protected void initialize() {
  }

  @Override

  protected void execute() {

    //Limits speed from being too slow,
    //below 0, too high, or above 1
    //This removes alot of issues
    if(RobotMap.moveSpeedMultiplyer < 0.3){
      RobotMap.moveSpeedMultiplyer = 0.3;
    }
    if(RobotMap.moveSpeedMultiplyer > 0.9){
      RobotMap.moveSpeedMultiplyer = 0.9;
    }
    if(RobotMap.turnSpeedMultiplyer < 0.3){
      RobotMap.turnSpeedMultiplyer = 0.3;
    }
    if(RobotMap.turnSpeedMultiplyer > 0.9){
      RobotMap.turnSpeedMultiplyer = 0.9;
    }

    //Gets current stick positions
    double moveSpeed = Robot.oi.stick.getY();
    double turnSpeed = Robot.oi.stick.getX();
    
    // Exponential function to make acceleration smoother
    // (x/|x|)*((10^|x|-1)/9)
    double move = Robot.driveSubsystem.expSpeed(moveSpeed);
    double turn = Robot.driveSubsystem.expSpeed(turnSpeed);

    //Moves robot after going into drive command
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
