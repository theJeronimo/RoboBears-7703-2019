/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevateUp;

/**
 * Add your docs here.
 slide and move elevator. 
 */
public class ArmSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Motor Controller Objects
  public PWMVictorSPX elevator = new PWMVictorSPX(RobotMap.elevatorPort);
  public PWMVictorSPX slide = new PWMVictorSPX(RobotMap.slidePort);

  public void moveElevator(double speed) {
    elevator.set(speed);
  }

  public void slide(double speed)  {
    slide.set(speed);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ElevateUp());
  }
}
