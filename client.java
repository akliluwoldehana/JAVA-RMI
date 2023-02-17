import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class client {
    public static void main(String []args){

        String email = "jon@gmail.com";
        String message = "This is a test complaint updated";
    
        try{
        
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",8888);
            
            Remoteinterface obj = (Remoteinterface) registry.lookup("Server");
            System.out.println("Client..");
            // Complaint c = new Complaint();
            // c.cId=2;
            // c.email=email;
            // c.message=message;

            CourtDetail co = new CourtDetail();

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            System.out.println("utilDate:" + utilDate);
            System.out.println("sqlDate:" + sqlDate);

            co.setCoId(2);
            co.setHearingDateTime(sqlDate);
            co.setCourtDecision("message updated");
            co.setJudgeRuling("Judge Mr.x");
            co.setEvidence("Laptop,knife");
            co.setWitnesses("bob,jack,abebe");
            // System.out.println(obj.addcomplaint(c));
            // System.out.println(obj.addCourtDetail(co));
            // System.out.println(obj.updateCourtDetail(co));
            

            //record module

            Record R =new Record();
            R.setRecordName("RECORD-CR-0001");  
            R.setRecordCategory("Type1"); 
            R.setRecordDec("Sample description");   
            R.setIncidentLocation("Addis Ababa");
            R.setIncidentDate(sqlDate);
            R.setRecordID(1);
            LocalTime now = LocalTime.now();

            Time time = Time.valueOf( now );

            R.setIncidentTIme(time);   
            R.setVictimsName("Jon");
            // System.out.println(obj.getRecord(1).getRecordName());

            
        //criminal module
        Criminal cr = new Criminal();
        cr.setCriminalId(123456);
        cr.setCriminalName("John Doe");
        cr.setCriminalNickName("Johnny");
        cr.setCriminalDOB(sqlDate);;
        cr.setAge(36);
        cr.setGender("Male");
        cr.setBirthRegID("7890123");
        cr.setBirthPlace("New York City");
        cr.setCivilStatus("Single");
        cr.setOccupation("Engineer");
        cr.setAddress("123 Main Street, New York City, NY");
        cr.setEthnicity("Caucasian");
        cr.setPoliticalView("Independent");
        cr.setReligion("Chrstian");
        cr.setHeight(1.68);
        System.out.println(obj.addCriminal(cr));



        }catch(Exception e) {
            System.err.println(e.toString());
        }

    
    }
}
