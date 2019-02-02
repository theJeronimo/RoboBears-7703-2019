/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ElevateManually;

// ElevatorPIDSubsystem to "Hook and Hatch"

public class ElevatorPIDSubsystem extends PIDSubsystem {
  
  // init motor
  public PWMVictorSPX elevator = new PWMVictorSPX(RobotMap.elevatorPort);

  // init encoder
  public Encoder encoder = new Encoder(RobotMap.encoderChannelA, RobotMap.encoderChannelB, false, Encoder.EncodingType.k4X);
  

  // pid constants. test and tune these
  private static final double kp = 0.01;
  private static final double ki = 0.0;
  private static final double kd = 0.0;


  // distances measured in inches
  int setMotorDirection = 0;
  
 

  public ElevatorPIDSubsystem() {
    // Intert a subsystem name and PID values here
    super("ElevatorPIDSubsystem", kp, ki, kd);
    setAbsoluteTolerance(0.005);
    getPIDController().setContinuous();

    encoder.reset();
    // Must find exact inches
    encoder.setDistancePerPulse(0.01);
    
    enable();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // Move Elevator Manually
    setDefaultCommand(new ElevateManually());
  }

  public void elevate(double input) {
    double height = encoder.getDistance();
    SmartDashboard.putNumber("height", height);
    elevator.set(input);
    
  }

  public void stop() {
    elevator.set(0);
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return encoder.getDistance();

  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    elevator.set(output);
  }
}
