import java.io.Serializable;
import java.sql.Date;

public class CourtDetail implements Serializable {
    
    public CourtDetail() {
    }
    private int coId;

    public int getCoId() {
        return this.coId;
    }

    public void setCoId(int coId) {
        this.coId = coId;
    }
    private Date hearingDateTime;
    private String courtDecision;
    private String judgeRuling;
    private String evidence;
    private String witnesses;
    
    public CourtDetail(Date hearingDateTime, String courtDecision, String judgeRuling, String evidence, String witnesses) {
        this.hearingDateTime = hearingDateTime;
        this.courtDecision = courtDecision;
        this.judgeRuling = judgeRuling;
        this.evidence = evidence;
        this.witnesses = witnesses;
    }
    
    public Date getHearingDateTime() {
        return this.hearingDateTime;
    }
    
    public void setHearingDateTime(Date hearingDateTime) {
        this.hearingDateTime = hearingDateTime;
    }
    
    public String getCourtDecision() {
        return this.courtDecision;
    }
    
    public void setCourtDecision(String courtDecision) {
        this.courtDecision = courtDecision;
    }
    
    public String getJudgeRuling() {
        return this.judgeRuling;
    }
    
    public void setJudgeRuling(String judgeRuling) {
        this.judgeRuling = judgeRuling;
    }
    
    public String getEvidence() {
        return this.evidence;
    }
    
    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }
    
    public String getWitnesses() {
        return this.witnesses;
    }
    
    public void setWitnesses(String witnesses) {
        this.witnesses = witnesses;
    }
}