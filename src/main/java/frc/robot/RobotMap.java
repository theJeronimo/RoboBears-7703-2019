/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // PWM
    // Drive
  public static int leftMasterPort = 0;
  public static int rightMasterPort = 1; 

    // Arm
  public static int elevatorPort = 2;
  public static int tiltPort = 3;

  // DIO
  public static int encoderChannelA = 0;
  public static int encoderChannelB = 1;

  // CAN
  
  
 
  // USB
  public static int joystickPort = 0;
  public static int buttonAPort = 1;
  public static int buttonBPort = 2;
  public static int buttonXPort = 3;
  public static int buttonYPort = 4;
  public static int buttonLBPort = 5;
  public static int buttonRBPort = 6;
  public static int buttonBackPort = 7;
  public static int buttonStartPort = 8;
  public static int buttonLeftStickDownPort = 9;
  public static int buttonRightStickDownPort = 10;

  public static int xboxControllerPort = 0;
  

  // Other Drive Train Constants

  // EX: 
  public static int wheelDiameter = 6;

  public static double elevatorGearDiameter = 3.0;


}
