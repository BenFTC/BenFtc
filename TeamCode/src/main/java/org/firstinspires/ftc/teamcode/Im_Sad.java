package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
@Disabled
@TeleOp
public class Im_Sad extends OpMode {

//------------------------------InitSetup?--------------------------------------------------------\\

    public DcMotor LeftFront  = null;
    public DcMotor LeftRear   = null;
    public DcMotor RightFront = null;
    public DcMotor RightRear  = null;
    public DcMotor Intake     = null;
    public DcMotor Shooter1   = null;
    public DcMotor Shooter2   = null;
    public Servo   ShootAngle = null;
    public Servo   loader     = null;
    public Servo   indexer    = null;
    public Servo   wobbleArm    = null;
    public Servo   wobbleClaw     = null;



//------------------------------InitLoop----------------------------------------------------------\\

    @Override
    public void init() {


//------------------------------PhoneHardWareMap--------------------------------------------------\\

        LeftRear    = hardwareMap.dcMotor.get (" backLeftMotor     ");
        LeftFront   = hardwareMap.dcMotor.get (" frontLeftMotor    ");
        RightFront  = hardwareMap.dcMotor.get (" frontRightMotor   ");
        RightRear   = hardwareMap.dcMotor.get (" backRightMotor    ");
        Intake      = hardwareMap.dcMotor.get ( "intake            ");
        Shooter1    = hardwareMap.dcMotor.get ( "shooterone        ");
        Shooter2    = hardwareMap.dcMotor.get ( "shootertwo        ");
        loader      = hardwareMap.servo.get   ( "loader            ");
        ShootAngle  = hardwareMap.servo.get   ( "ShooterAngle      ");
        indexer     = hardwareMap.servo.get   ( "indexer           ");
        wobbleArm     = hardwareMap.servo.get   ( "wobbleArm           ");
        wobbleClaw     = hardwareMap.servo.get   ( "wobbleClaw          ");

//------------------------------Direction---------------------------------------------------------\\

        //Reverse spins motors to the right Forward spins motors to the left
        LeftFront .setDirection (DcMotorSimple.Direction.FORWARD);
        LeftRear  .setDirection (DcMotorSimple.Direction.FORWARD);
        RightFront.setDirection (DcMotorSimple.Direction.REVERSE);
        RightRear .setDirection (DcMotorSimple.Direction.REVERSE);
        Intake    .setDirection (DcMotorSimple.Direction.REVERSE);
        Shooter1   .setDirection (DcMotorSimple.Direction.FORWARD);
        Shooter2   .setDirection (DcMotorSimple.Direction.FORWARD);

        LeftFront .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftRear  .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RightRear .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        LeftFront .setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        LeftRear  .setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RightRear .setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        LeftFront  .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        LeftRear   .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RightFront .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RightRear  .setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


    }

//------------------------------OpMode------------------------------------------------------------\\

    @Override
    public void loop() {

//------------------------------DriverController--------------------------------------------------\\


        double D   = -gamepad1.left_stick_y ;
        double S   = -gamepad1.left_stick_x ;
        double T   = -gamepad1.right_stick_x;
        double Sped  = 1;
        double SpedT = 1;



        LeftFront  .setPower( - D + S * Sped + T * SpedT );
        LeftRear   .setPower( - D - S * Sped + T * SpedT );
        RightFront .setPower( - D - S * Sped - T * SpedT );
        RightRear  .setPower( - D + S * Sped - T * SpedT );


//------------------------------Intake/Belt-------------------------------------------------------\\

        //sketchy intake code idk if work
        if      (gamepad1.right_trigger > .1)
        {
            indexer.setPosition(.65);
            Intake.setPower(1);
        }
        else if (gamepad1.left_trigger  > .1)
        {
            Intake.setPower(-1);
        }
        else
        {
            Intake.setPower(0);
        }

//------------------------------Shooter-----------------------------------------------------------\\

        if (gamepad1.left_bumper)
        {
            Shooter1.setPower(.8);
            Shooter2.setPower(.8);
            indexer.setPosition(1);
        }
        else
        {
            Shooter1.setPower(0);
            Shooter2.setPower(0);
        }

        if (gamepad1.right_bumper)
        {
            //change values
            loader.setPosition(.5);
        }
        else
        {
            //change value
            loader.setPosition(.83);
        }

        if     (gamepad1.y)
        {
        indexer.setPosition(.65);
        }
        else if(gamepad1.b)
        {
        indexer.setPosition(1);
        }

        if      (gamepad1.dpad_up)
        {
            //change values
            ShootAngle.setPosition(.75);
        }
        else if (gamepad1.dpad_down)
        {
            //change values
            ShootAngle.setPosition(1);
        }


//------------------------------Wobble------------------------------------------------------------\\
//non existent just bad



 }
}
