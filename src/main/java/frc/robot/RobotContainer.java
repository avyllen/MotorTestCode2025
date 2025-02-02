// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.CoralIntakeSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final CoralIntakeSubsystem intake = new CoralIntakeSubsystem();
  private final ClimberSubsystem climber = new ClimberSubsystem();
  
  CommandXboxController xbox = new CommandXboxController(0);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    configureBindings();

    intake.setDefaultCommand(intake.withDisable());
    climber.setDefaultCommand(climber.stop());
  }


  private void configureBindings() {

    xbox.rightTrigger().whileTrue(intake.midIntake());
    xbox.a().whileTrue(intake.slowIntake());
    xbox.b().whileTrue(intake.slowOuttake());
    xbox.rightBumper().whileTrue(intake.midOuttake());

    xbox.leftTrigger().whileTrue(intake.singleMotorIntake());
    xbox.leftBumper().whileTrue(intake.singleMotorOuttake());
    // xbox.leftTrigger().whileTrue(climber.climbUp());
    // xbox.leftBumper().whileTrue(climber.climbDown());


  }


  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
