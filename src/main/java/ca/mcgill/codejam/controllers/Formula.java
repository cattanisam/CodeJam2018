package ca.mcgill.codejam.controllers;

import org.hibernate.Hibernate;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import ca.mcgill.codejam.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SQLQuery;
import java.util.ArrayList;
import java.util.List;

import ca.mcgill.codejam.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.*;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.SQLQuery;
import java.util.ArrayList;
import java.util.List;


public class Formula{

    public static double MonthMultiplier(float latitude, float longitude, String date){
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date requested = null;
        
        try{
            requested = format.parse(date);
        }catch(Exception e){
            return 0;
        }

        if(latitude >= 60){
            return 0;
        }else if (latitude <= 20){
            return 2.5;
        }else if (latitude > 20 && latitude <= 40){
            if(requested.getMonth() >= 3 || requested.getMonth() <= 9){
                return 2.5;
            }else{
                return 0.2;
            }
        }else{
            if(requested.getMonth() >= 4 || requested.getMonth() <= 8){
                return 2.5;
            }else{
                return 0.2;
            }
        }

    }

    public static double fireStrength(int fireOccurred, float brightness, float confidence, float brightT31, float frp){
        if(fireOccurred == 1){
            return ((confidence) + (brightness - 300) + (brightT31 - 200) + frp);
        }else{
            return 0;
        }
    }

    public static int numFiresAround(float latitude, float longitude){
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();


        float minLat = latitude - 2;
        float minLong = longitude - 2;
        float maxLat = latitude + 2;
        float maxLong = longitude + 2;

        String queryString = "SELECT CurrentFireID from CurrentFires WHERE Latitude <= :MAXLAT AND Latitude >= :MINLAT AND Longitude <= :MAXLONG AND Longitude >= :MINLONG";

        SQLQuery query1 = session.createSQLQuery(queryString);

        query1.setParameter("MAXLAT", maxLat);
        query1.setParameter("MINLAT", minLat);
        query1.setParameter("MAXLONG", maxLong);
        query1.setParameter("MINLONG", minLong);

        List<Integer> resultList = query1.list();

        session.getTransaction().commit();
        session.close();
        
        return resultList.size();
    }

    public static int firesLastDays(float latitude, float longitude){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String sqlCall = "SELECT YesterdayFireID from YesterdayFires WHERE Latitude = :LATITUDE AND Longitude = :LONGITUDE";
        SQLQuery sqlReturn = session.createSQLQuery(sqlCall);
        sqlReturn.setParameter("LATITUDE", latitude);
        sqlReturn.setParameter("LONGITUDE", longitude);

        List<Integer> resultList = sqlReturn.list();

        session.getTransaction().commit();
        session.close();

        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();

        String sqlCall2 = "SELECT TwoDaysAgoFireID from TwoDaysAgoFires WHERE Latitude = :LATITUDE AND Longitude = :LONGITUDE";
        SQLQuery sqlReturn2 = session2.createSQLQuery(sqlCall2);
        sqlReturn2.setParameter("LATITUDE", latitude);
        sqlReturn2.setParameter("LONGITUDE", longitude);

        List<Integer> resultList2 = sqlReturn2.list();

        session2.getTransaction().commit();
        session2.close();

        return resultList.size() + resultList2.size();
    }

    public static double probDamagingFire(double theta){
        return theta;
    }

    public static float probLargeFire(float theta){
        return 0;
    }

    public static float overallProb(float damagingFire, float largeFire){
        return (damagingFire * largeFire);
    }

}