package ca.mcgill.codejam.controllers;

import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SQLQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.codejam.HibernateUtil;

@RestController
@RequestMapping("/Calculation")
public class CalculationController{

    @RequestMapping("/mapData")
    public ArrayList<double[]> getMapData(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String sqlCall = "SELECT Latitude, Longitude, Brightness, ACG_Date, Confidence, Bright_T31, FRP FROM CurrentFires";
        SQLQuery sqlReturn = session.createSQLQuery(sqlCall);
        List<Object[]> currentFires = sqlReturn.list();

        session.getTransaction().commit();
        session.close();

        ArrayList<double[]> fireProbs = new ArrayList<double[]>();

        for(Object[] fire : currentFires){
            float latitude = (float) 0.0;
            float longitude = (float) 0.0;
            float brightness = (float) 0.0;
            String date = null;
            float confidence = (float) 0.0;
            float brightT31 = (float) 0.0;
            float frp = (float) 0.0;

            try{
                latitude = Float.parseFloat(fire[0].toString());
                longitude = Float.parseFloat(fire[1].toString());
                brightness = Float.parseFloat(fire[2].toString());
                date = fire[3].toString();
                confidence = Float.parseFloat(fire[4].toString());
                brightT31 = Float.parseFloat(fire[5].toString());
                frp = Float.parseFloat(fire[6].toString());

            }catch(Exception e){

            }

            System.out.println(latitude);

            double fireStrength = Formula.fireStrength(1, brightness, confidence, brightT31, frp);
            double probFireStrength = Formula.probDamagingFire(fireStrength);
            double fireSeason = Formula.MonthMultiplier(latitude, longitude, date);
            int firesAround = Formula.numFiresAround(latitude, longitude);
            double firePast = Formula.firesLastDays(latitude, longitude);
            double prob = Formula.overallProb((float) probFireStrength, (float) (fireSeason * (firesAround + firePast)));

            
            double[] fireData = {(double) latitude, (double) longitude, prob / 500};
            fireProbs.add(fireData);
        }

        return fireProbs;
    }


}