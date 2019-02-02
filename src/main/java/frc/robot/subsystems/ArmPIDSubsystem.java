/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

// ArmPIDSubsystem to "Hook and Hatch"

public class ArmPIDSubsystem extends PIDSubsystem {
  
  // init motors
  public PWMVictorSPX elevator = new PWMVictorSPX(RobotMap.elevatorPort);
  public PWMVictorSPX tilt = new PWMVictorSPX(RobotMap.tiltPort);


  // init encoder
  public Encoder encoder = new Encoder(RobotMap.encoderAPort, RobotMap.encoderBPort, false, Encoder.EncodingType.k4X);

  // pid constants. test and tune these
  private static final double kp = 1.0;
  private static final double ki = 1.0;
  private static final double kd = 1.0;
 

  // Hook is release and insert height/value
  // Hatch is grab and attach height/value

  // *** Will have to FIND VALUES FOR ALL ***

    // firstLevel is same for Loading Dock and Hab Cargo Bay
  public static final double firstLevelHook = 1.2;
  public static final double firstLevelHatch = 1.5;

    //first Rocket Level needs to be slightly higher than normal due to tilt of arm
  public static final double firstRocketHook = 1.5;
  public static final double firstRocketHatch = 1.8;

    // second Rocket Level accommodated to tilt
  public static final double secondRocketHook = 3.5;
  public static final double secondRocketHatch = 3.8;

  public ArmPIDSubsystem() {
    // Intert a subsystem name and PID values here
    super("ArmPIDSubsystem", kp, ki, kd);
    
    encoder.reset();
    setSetpoint(firstLevelHook);
    enable();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return encoder.get();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    elevator.set(output);
  }
}
