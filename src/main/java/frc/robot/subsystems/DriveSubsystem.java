/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManuallyCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  // Motor Controller Objects
  public PWMVictorSPX leftMaster = new PWMVictorSPX(RobotMap.leftMasterPort);
  
  public PWMVictorSPX rightMaster = new PWMVictorSPX(RobotMap.rightMasterPort);
 

  // DifferentialDrive object
  // Motor Controllers assigned to differential drive 
  public DifferentialDrive drive = new DifferentialDrive(rightMaster, leftMaster);
  public void manualDrive(double move, double turn) {
    
    // double speed = 1.0;
    if (Math.abs(move) < 0.10) {
      move = 0;
    }

    if (Math.abs(turn) < 0.10) {
      turn = 0;
    }
    move *= RobotMap.moveSpeedMultiplyer;
    turn *= RobotMap.turnSpeedMultiplyer;

    drive.arcadeDrive(move, turn);
  }

  public void lowerSpeedMultiplier(double move, double turn) {
    if (RobotMap.moveSpeedMultiplyer > 0 && RobotMap.turnSpeedMultiplyer > 0) { 
      RobotMap.moveSpeedMultiplyer = RobotMap.moveSpeedMultiplyer - move;
      System.out.println("Move " + RobotMap.moveSpeedMultiplyer);
      RobotMap.turnSpeedMultiplyer = RobotMap.turnSpeedMultiplyer - turn;
      System.out.println("Turn " + RobotMap.turnSpeedMultiplyer);
    }
  }

  public void increaseSpeedMultiplier(double move, double turn) {
    if (RobotMap.moveSpeedMultiplyer > 0 && RobotMap.turnSpeedMultiplyer > 0) {
      RobotMap.moveSpeedMultiplyer = RobotMap.moveSpeedMultiplyer + move;
     System.out.println("Move " + RobotMap.moveSpeedMultiplyer);
      RobotMap.turnSpeedMultiplyer = RobotMap.turnSpeedMultiplyer + turn;
    System.out.println("Turn " + RobotMap.turnSpeedMultiplyer);
    }
  }

  public double expSpeed(double speed) {
    return (speed/Math.abs(speed)) * (Math.pow(10, Math.abs(speed)) - 1)/9;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManuallyCommand());
  }
}
