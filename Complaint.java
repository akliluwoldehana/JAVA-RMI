import java.io.Serializable;

public class Complaint implements Serializable {
    String email;
    String message;
    int cId;

    public Complaint() {
    }
    
    public Complaint(String email, String message, int cId) {
        this.email = email;
        this.message = message;
        this.cId = cId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }
   
   
    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
