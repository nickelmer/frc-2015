package org.usfirst.frc.team166.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team166.robot.commands.claw.ToggleClaw;
import org.usfirst.frc.team166.robot.commands.drive.CancelDriveCommand;
import org.usfirst.frc.team166.robot.commands.drive.StrafeDirection;
import org.usfirst.frc.team166.robot.commands.wings.LiftWings;
import org.usfirst.frc.team166.robot.commands.wings.LowerWings;
import org.usfirst.frc.team166.robot.subsystems.Drive;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups
 * that allow control of the robot.
 */
public class OI {

	private final Joystick driveJoystick = new Joystick(RobotMap.DriveJoystick);
	private final Joystick toteJoystick = new Joystick(RobotMap.CopilotController);
	private final Joystick rcJoystick = new Joystick(RobotMap.CopilotController);

	public OI() {

		JoystickButton button1 = new JoystickButton(driveJoystick, 1);
		JoystickButton button3 = new JoystickButton(driveJoystick, 3);
		JoystickButton button4 = new JoystickButton(driveJoystick, 4);

		button1.whenPressed(new CancelDriveCommand());
		button3.whileHeld(new StrafeDirection(Drive.StrafeDirection.Left));
		button4.whileHeld(new StrafeDirection(Drive.StrafeDirection.Right));

		SmartDashboard.putData("LiftWings", new LiftWings());
		SmartDashboard.putData("LowerWings", new LowerWings());
		SmartDashboard.putData("Toggle Claw", new ToggleClaw());
	}

	public Joystick getDriveJoystick() {
		return driveJoystick;
	}

	public Joystick getToteJoystick() {
		return toteJoystick;
	}

	public Joystick getRCJoystick() {
		return rcJoystick;
	}

}
