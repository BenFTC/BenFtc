package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
@Disabled
public class ShooterTesting extends OpMode {

    public DcMotor Wheel  = null;

    @Override
    public void init() {

        Wheel = hardwareMap.dcMotor.get ("Motor");

    }

    @Override
    public void loop() {



        if (gamepad1.dpad_down)
        {
           Wheel.setPower(1);
        }
        else
            {
                Wheel.setPower(0);

            }





    }
}
