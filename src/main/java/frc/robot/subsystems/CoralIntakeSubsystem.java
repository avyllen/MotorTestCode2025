// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.jni.CANSparkJNI;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CoralIntakeSubsystem extends SubsystemBase {
  private TalonFX falcon1;
  private TalonFX falcon2;

private final NeutralOut m_brake = new NeutralOut();

  //To change IDs, go to the Constants folder
  public CoralIntakeSubsystem() {
     falcon1 = new TalonFX(Constants.MotorConstants.falconID1); 
     falcon2 = new TalonFX(Constants.MotorConstants.falconID2);
     }

  //Methods
  private void disable() {
    falcon1.setControl(m_brake);
    falcon2.setControl(m_brake);
  }

  //Velocity ranging from 1 (100%) to -1 (-100%)
  public void setVelocity(double velocity){
    falcon1.set(velocity);
    falcon2.set(-velocity);
  }

  //Commands
  public Command slowOuttake() {
    return run(() -> this.setVelocity(0.1));
  }

  public Command midOuttake() {
    return run(() -> this.setVelocity(0.4));
  }

  public Command slowIntake() {
    return run(() -> this.setVelocity(-0.2));
  }

  public Command singleMotorIntake() {
    return run(() -> falcon1.set(-0.4));
  }
  public Command singleMotorOuttake() {
    return run(() -> falcon1.set(0.4));
  }

  public Command midIntake() {
    return run(() -> this.setVelocity(-0.4));
  }

  public Command withDisable() {
    return run(() -> this.disable());
  }





  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
