// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

  private SparkMax sparkMax;
  //private SparkMax sparkMax2;

  public ClimberSubsystem() {
    sparkMax = new SparkMax(Constants.MotorConstants.sparkID1, MotorType.kBrushless);
    //SparkMax sparkMax2 = new SparkMax(Constants.MotorConstants.sparkID2,MotorType.kBrushless);
  }

  //Methods
  //Velocity ranging from 1 (100%) to -1 (-100%)
   public void setVelocity(double velocity){
    sparkMax.set(velocity);
    //sparkMax2.set(velocity);
  }

  //Commands
  public Command climbUp() {
    return run(() -> this.setVelocity(0.05));
  }

  public Command climbDown() {
    return run (() -> this.setVelocity(-0.05));
  }

  public Command stop() {
    return run(() -> this.setVelocity(0));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
