package csci205finalproject;

/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Stephanie Garboski
 * Date: Nov 9, 2015
 * Time: 10:17:26 AM
 *
 * Project: csci205
 * Package:
 * File: Chips
 * Description:
 *
 * **/
/**
 *
 * @author sag033
 */
public enum Chips {
    WHITE(1.00),
    RED(5.00),
    BLUE(10.00),
    GREEN(25.00),
    BLACK(100.00);

    private double value;

    Chips(double value) {
        this.value = value;
    }

    double getValue() {
        return this.value;
    }
}
