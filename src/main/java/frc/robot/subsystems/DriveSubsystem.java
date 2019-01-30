/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  // Motor Controller Objects
  public Victor leftMaster = new Victor(RobotMap.leftMasterPort);
  public Victor leftSlave = new Victor(RobotMap.leftSlavePort);
  public SpeedControllerGroup left = new SpeedControllerGroup(leftMaster, leftSlave);

  public Victor rightMaster = new Victor(RobotMap.rightMasterPort);
  public Victor rightSlave = new Victor(RobotMap.rightSlavePort);
  public SpeedControllerGroup right = new SpeedControllerGroup(rightMaster, rightSlave);

  // DifferentialDrive object
  // Motor Controllers assigned to differential drive 
  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  // Constructor

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
