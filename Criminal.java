import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

public class Criminal implements Serializable{
 
   
     private int criminalId;
     private String criminalName;
     private String criminalNickName;
     private Date criminalDOB;
     private int age;
     private String gender;
     private String birthRegID;
     private String birthPlace;
     private String civilStatus;
     private String occupation;
     private String address;
     private String ethnicity;
     private String politicalView;
     private String religion;
     private double height;


    public int getCriminalId() {
        return this.criminalId;
    }

    public void setCriminalId(int criminalId) {
        this.criminalId = criminalId;
    }

    public String getCriminalName() {
        return this.criminalName;
    }

    public void setCriminalName(String criminalName) {
        this.criminalName = criminalName;
    }

    public String getCriminalNickName() {
        return this.criminalNickName;
    }

    public void setCriminalNickName(String criminalNickName) {
        this.criminalNickName = criminalNickName;
    }

    
    public Date getCriminalDOB() {
        return this.criminalDOB;
    }

    public void setCriminalDOB(Date criminalDOB) {
        this.criminalDOB = criminalDOB;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthRegID() {
        return this.birthRegID;
    }

    public void setBirthRegID(String birthRegID) {
        this.birthRegID = birthRegID;
    }

    public String getBirthPlace() {
        return this.birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getCivilStatus() {
        return this.civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEthnicity() {
        return this.ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getPoliticalView() {
        return this.politicalView;
    }

    public void setPoliticalView(String politicalView) {
        this.politicalView = politicalView;
    }

    public String getReligion() {
        return this.religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getHair() {
        return this.hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getEyes() {
        return this.eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public Blob getPhoto() {
        return this.photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Criminal() {
    }
     private String hair;
     private String eyes;
     private Blob photo;

}
