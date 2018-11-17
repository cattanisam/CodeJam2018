package ca.mcgill.codejam.controllers;

public class Formula{

    public static float MonthMultiplier(float latitude, float longitude){
        return 0;
    }

    public static int fireOccured(float latitude, float longitude){
        return 0;
    }

    public static float fireStrength(int fireOccured, float brightness, float confidence, float brightT31, float frp){
        return 0;
    }

    public static int numFiresAround(float latitude, float longitude){
        return 0;
    }

    public static int firesLastDays(float latitude, float longitude){
        return 0;
    }

    public static float probDamagingFire(float theta){
        return 0;
    }

    public static float probLargeFire(float theta){
        return 0;
    }

    public static float overallProb(float damagingFire, float largeFire){
        return (damagingFire * largeFire);
    }

}