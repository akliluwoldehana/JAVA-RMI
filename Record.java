import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Record implements Serializable {

    private int recordID;
    private String recordName;
    private String recordCategory;
    private String incidentLocation;
    private Date incidentDate;
    private Time incidentTIme;
    private String victimsName;
    private String recordDec;



    public int getRecordID() {
        return this.recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public String getRecordName() {
        return this.recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public String getRecordCategory() {
        return this.recordCategory;
    }

    public void setRecordCategory(String recordCategory) {
        this.recordCategory = recordCategory;
    }

    public String getIncidentLocation() {
        return this.incidentLocation;
    }

    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    public Date getIncidentDate() {
        return this.incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public Time getIncidentTIme() {
        return this.incidentTIme;
    }

    public void setIncidentTIme(Time incidentTIme) {
        this.incidentTIme = incidentTIme;
    }

    public String getVictimsName() {
        return this.victimsName;
    }

    public void setVictimsName(String victimsName) {
        this.victimsName = victimsName;
    }

    public String getRecordDec() {
        return this.recordDec;
    }

    public void setRecordDec(String recordDec) {
        this.recordDec = recordDec;
    }

}
