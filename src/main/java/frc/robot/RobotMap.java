/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
  // PWM
    // Drive
  public static int leftMasterPort = 0;
  public static int rightMasterPort = 1; 

    // Arm
  public static int elevatorPort = 9;
  public static int slidePort = 8;

  // DIO
  // CAN
  // USB
    //Joysticks
  public static int joystickPort = 0;
    //Buttons and inputs
  public static int rightStickX = 4;
  public static int leftStickY = 1;
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

  // Other Drive Train Constants

  public static int wheelDiameter = 6;
  public static double moveSpeedMultiplyer = 0.4;
  public static double turnSpeedMultiplyer = 0.4;
}
