package ca.mcgill.codejam.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "CurrentFires")
public class CurrentFire
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CurrentFire Attributes
  @Id
  @Column(name = "CurrentFireID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int fireID;
  @Column(name = "Latitude")
  private float latitude;
  @Column(name = "Longitude")
  private float longitude;
  @Column(name = "Brightness")
  private float brightness;
  @Column(name = "Scan")
  private float scan;
  @Column(name = "Track")
  private float track;
  @Column(name = "ACG_Date")
  private String acgDate;
  @Column(name = "ACG_Time")
  private String argTime;
  @Column(name = "Satellite")
  private String satellite;
  @Column(name = "Confidence")
  private float confidence;
  @Column(name = "Version")
  private String version;
  @Column(name = "Bright_T31")
  private float brightT31;
  @Column(name = "FRP")
  private float frp;
  @Column(name = "DayNight")
  private String dayNight;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CurrentFire(int aFireID, float aLatitude, float aLongitude, float aBrightness, float aScan, float aTrack, String aAcgDate, String aArgTime, String aSatellite, float aConfidence, String aVersion, float aBrightT31, float aFrp, String aDayNight)
  {
    fireID = aFireID;
    latitude = aLatitude;
    longitude = aLongitude;
    brightness = aBrightness;
    scan = aScan;
    track = aTrack;
    acgDate = aAcgDate;
    argTime = aArgTime;
    satellite = aSatellite;
    confidence = aConfidence;
    version = aVersion;
    brightT31 = aBrightT31;
    frp = aFrp;
    dayNight = aDayNight;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFireID(int aFireID)
  {
    boolean wasSet = false;
    fireID = aFireID;
    wasSet = true;
    return wasSet;
  }

  public boolean setLatitude(float aLatitude)
  {
    boolean wasSet = false;
    latitude = aLatitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setLongitude(float aLongitude)
  {
    boolean wasSet = false;
    longitude = aLongitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setBrightness(float aBrightness)
  {
    boolean wasSet = false;
    brightness = aBrightness;
    wasSet = true;
    return wasSet;
  }

  public boolean setScan(float aScan)
  {
    boolean wasSet = false;
    scan = aScan;
    wasSet = true;
    return wasSet;
  }

  public boolean setTrack(float aTrack)
  {
    boolean wasSet = false;
    track = aTrack;
    wasSet = true;
    return wasSet;
  }

  public boolean setAcgDate(String aAcgDate)
  {
    boolean wasSet = false;
    acgDate = aAcgDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setArgTime(String aArgTime)
  {
    boolean wasSet = false;
    argTime = aArgTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setSatellite(String aSatellite)
  {
    boolean wasSet = false;
    satellite = aSatellite;
    wasSet = true;
    return wasSet;
  }

  public boolean setConfidence(float aConfidence)
  {
    boolean wasSet = false;
    confidence = aConfidence;
    wasSet = true;
    return wasSet;
  }

  public boolean setVersion(String aVersion)
  {
    boolean wasSet = false;
    version = aVersion;
    wasSet = true;
    return wasSet;
  }

  public boolean setBrightT31(float aBrightT31)
  {
    boolean wasSet = false;
    brightT31 = aBrightT31;
    wasSet = true;
    return wasSet;
  }

  public boolean setFrp(float aFrp)
  {
    boolean wasSet = false;
    frp = aFrp;
    wasSet = true;
    return wasSet;
  }

  public boolean setDayNight(String aDayNight)
  {
    boolean wasSet = false;
    dayNight = aDayNight;
    wasSet = true;
    return wasSet;
  }

  public int getFireID()
  {
    return fireID;
  }

  public float getLatitude()
  {
    return latitude;
  }

  public float getLongitude()
  {
    return longitude;
  }

  public float getBrightness()
  {
    return brightness;
  }

  public float getScan()
  {
    return scan;
  }

  public float getTrack()
  {
    return track;
  }

  public String getAcgDate()
  {
    return acgDate;
  }

  public String getArgTime()
  {
    return argTime;
  }

  public String getSatellite()
  {
    return satellite;
  }

  public float getConfidence()
  {
    return confidence;
  }

  public String getVersion()
  {
    return version;
  }

  public float getBrightT31()
  {
    return brightT31;
  }

  public float getFrp()
  {
    return frp;
  }

  public String getDayNight()
  {
    return dayNight;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "fireID" + ":" + getFireID()+ "," +
            "latitude" + ":" + getLatitude()+ "," +
            "longitude" + ":" + getLongitude()+ "," +
            "brightness" + ":" + getBrightness()+ "," +
            "scan" + ":" + getScan()+ "," +
            "track" + ":" + getTrack()+ "," +
            "acgDate" + ":" + getAcgDate()+ "," +
            "argTime" + ":" + getArgTime()+ "," +
            "satellite" + ":" + getSatellite()+ "," +
            "confidence" + ":" + getConfidence()+ "," +
            "version" + ":" + getVersion()+ "," +
            "brightT31" + ":" + getBrightT31()+ "," +
            "frp" + ":" + getFrp()+ "," +
            "dayNight" + ":" + getDayNight()+ "]";
  }
}