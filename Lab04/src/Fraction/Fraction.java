/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fraction;

/**
 *
 * @author TEXR
 */
public class Fraction {

    public int topN, btmN;

    public String toFraction() {
        return topN + "/" + btmN;
    }

    public String toFloat() {
        double cal = (double) topN / (double) btmN;
        return cal + "";
    }

    public void addFraction(Fraction f) {
        if (btmN == f.btmN) {
            topN = f.topN + topN;
        } else {
            topN = f.topN * btmN + topN * f.btmN;
            btmN = f.btmN * btmN;
        }
    }

    public boolean myEquals(Fraction x) {
        if (x.topN == x.btmN) {
            return true;
        }
        return false;
    }

    public void LowestTermFrac() {
        int gcd = findGCD(topN, btmN);
        topN /= gcd;
        btmN /= gcd;
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
