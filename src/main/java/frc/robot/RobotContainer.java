// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.Subsystems.Swerve.SwerveDriveTrain;

public class RobotContainer {
  public static CommandPS4Controller driverController = new CommandPS4Controller(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    driverController.triangle().whileTrue(new InstantCommand(() -> SwerveDriveTrain.getInstance().updateOffset()));

    driverController.R1().whileTrue(
      new InstantCommand(() -> SwerveDriveTrain.getInstance().setVelocityFactor(0.5)))
    .whileFalse(new InstantCommand(() -> SwerveDriveTrain.getInstance().setVelocityFactor(1)));  
  
  
    driverController.L1().whileTrue(
     new InstantCommand(() -> SwerveDriveTrain.getInstance().setVelocityFactor(0.25)))
    .whileFalse(new InstantCommand(() -> SwerveDriveTrain.getInstance().setVelocityFactor(1)));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
