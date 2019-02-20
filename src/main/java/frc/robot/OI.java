/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//Imported Joystick Class (Right Click -> Source Action.. -> Import)
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ElevateDown;
import frc.robot.commands.ElevateUp;
import frc.robot.commands.StopElevator;
import frc.robot.commands.SlideBackward;
import frc.robot.commands.SlideForward;
import frc.robot.commands.StopSlide;
import frc.robot.commands.speedMultiplyerDown;
import frc.robot.commands.speedMultiplyerUp;
//import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  public static Joystick stick = new Joystick(RobotMap.joystickPort);
  public static Button buttonA = new JoystickButton(stick, RobotMap.buttonAPort);
  public static Button buttonB = new JoystickButton(stick, RobotMap.buttonBPort);
  public static Button buttonX = new JoystickButton(stick, RobotMap.buttonXPort);
  public static Button buttonY = new JoystickButton(stick, RobotMap.buttonYPort);
  public static Button buttonLB = new JoystickButton(stick, RobotMap.buttonLBPort);
  public static Button buttonRB = new JoystickButton(stick, RobotMap.buttonRBPort);
  public static Button buttonBack = new JoystickButton(stick, RobotMap.buttonBackPort);
  public static Button buttonStart = new JoystickButton(stick, RobotMap.buttonStartPort);
  public static Button buttonLeftStickDown = new JoystickButton(stick, RobotMap.buttonLeftStickDownPort);
  public static Button buttonRightStickDown = new JoystickButton(stick, RobotMap.buttonRightStickDownPort);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.
  public OI() {

    //Elevator movment
    buttonY.whenPressed(new ElevateUp());
    buttonY.whenReleased(new StopElevator());
    buttonX.whenPressed(new ElevateDown());
    buttonX.whenReleased(new StopElevator());
    
    //Slide movment
    buttonB.whenPressed(new SlideForward());
    buttonB.whenReleased(new StopSlide());
    buttonA.whenPressed(new SlideBackward());
    buttonA.whenReleased(new StopSlide());

    //Changing Speed Multiplyers
    buttonLB.whenPressed(new speedMultiplyerDown());
    System.out.println(buttonLB);
    buttonRB.whenPressed(new speedMultiplyerUp());
    System.out.println(buttonRB);
  }
}
