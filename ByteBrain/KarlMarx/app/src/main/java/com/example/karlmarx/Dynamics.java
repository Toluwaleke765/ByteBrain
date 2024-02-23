package com.example.karlmarx;

import java.lang.Math;

public class Dynamics extends Unit {

    Dynamics() {
        super("Dynamics");
    }

    public String[] generateQ(int type) {
        String[] QA = new String[2];
        // [0] = theta(degrees), [1] = coefficient of friction, [2] = accelerration
        double[] values = new double[4];

        // GENERATE VALUES
        values[0] = getRandFloat(0.001, 1.56);
        values[1] = getRandFloat(0.001, 0.999);
        values[2] = (9.81) * (Math.sin(values[0])) - (9.81) * (Math.cos(values[0])) * (values[1]);

        if (type == 0) {
            int index = getRandInt(0, 2);
            String temp = "There is a box on an inclined plane to the horizontal. You are given: ";
            // solve for theta
            if (index == 0) {
                temp = temp + "Acceleration = " + round(values[2]) + " Coefficient of kinetic friction = " + round(values[1])
                        + ". Solve for Angle of incline.";
                QA[0] = temp;
                QA[1] = round(values[0]) + "";
            }
            // solve for uk
            else if (index == 1) {
                temp = temp + "Angle of incline = " + round(values[0]) + " Acceleration = " + round(values[2])
                        + ". Solve for the coefficient of friction.";
                QA[0] = temp;
                QA[1] = round(values[1]) + "";
            }
            // solve for acceleration
            else if (index == 2) {
                temp = temp + "Coefficient of friction = " + round(values[1]) + " Angle of incline = " + round(values[0])
                        + ". Solve for acceleration.";
                QA[0] = temp;
                QA[1] = round(values[2]) + "";
            }
        }
        return QA;
    }
}

