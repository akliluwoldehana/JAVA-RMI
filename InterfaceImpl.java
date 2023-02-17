import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.rmi.server.UnicastRemoteObject;

public class InterfaceImpl extends UnicastRemoteObject  implements Remoteinterface{
  
    private Connection connection;

    public InterfaceImpl() throws RemoteException {
    }

    @Override
    public void connectdb() throws RemoteException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/crimemgmt", "root", "root");
          } catch (Exception e) {
            e.printStackTrace();
          }
    }

    @Override
    public Complaint getcomplaint(int cId) throws RemoteException, SQLException {
        connectdb();
        Complaint c = null;
        try {
          PreparedStatement statement = connection.prepareStatement("SELECT * FROM complaint WHERE cId = ?");
          statement.setInt(1, cId);
          ResultSet resultSet = statement.executeQuery();
          if (resultSet.next()) {
            c = new Complaint();
            c.setcId(resultSet.getInt("Cid"));
            c.setEmail(resultSet.getString("email"));
            c.setMessage(resultSet.getString("Message"));
          }
          resultSet.close();
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        connection.close();
        return c;
    }

    @Override
    public boolean addcomplaint(Complaint c) throws RemoteException, SQLException {
       connectdb();
        boolean result = false;
        try {
          PreparedStatement statement = connection.prepareStatement("INSERT INTO complaint (email, Message) VALUES (?, ?)");
          statement.setString(1, c.getEmail());
          statement.setString(2, c.getMessage());
          int rowsAffected = statement.executeUpdate();
          if (rowsAffected > 0) {
            result = true;
          }
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        connection.close();
        return result;
    }

    @Override
    public boolean updatecomplaint(Complaint c) throws RemoteException, SQLException {
      connectdb();
        boolean result = false;
        try {
          PreparedStatement statement = connection.prepareStatement("UPDATE complaint SET email = ?, message = ? WHERE Cid = ?");
          statement.setString(1, c.getEmail());
          statement.setString(2, c.getMessage());
          statement.setString(3, Integer.toString(c.getcId()));
          int rowsAffected = statement.executeUpdate();
          if (rowsAffected > 0) {
            result = true;
          }
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        connection.close();
        return result;
    }

    @Override
    public boolean deletecomplaint(int cId) throws RemoteException, SQLException {
      connectdb();
        boolean result = false;
        try {
          PreparedStatement statement = connection.prepareStatement("DELETE FROM complaint WHERE id = ?");
          statement.setString(1, Integer.toString(cId));
          int rowsAffected = statement.executeUpdate();
          if (rowsAffected > 0) {
            result = true;
          }
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        connection.close();
        return result;
    }


    //courtDeatil Module
    @Override
    public CourtDetail CourtDetail(int coId) throws RemoteException, SQLException {
      connectdb();
      CourtDetail c = null;
      try {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM courtDeatil WHERE coId = ?");
        statement.setInt(1, coId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
          c = new CourtDetail();
        

          c.setHearingDateTime(resultSet.getDate("hearingDateTime"));
          c.setCourtDecision(resultSet.getString("courtDecision"));
          c.setJudgeRuling(resultSet.getString("judgeRuling"));
          c.setEvidence(resultSet.getString("evidence"));
          c.setWitnesses(resultSet.getString("witnesses"));
        }
        resultSet.close();
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      connection.close();
      return c;
    }

    @Override
    public boolean addCourtDetail(CourtDetail co) throws RemoteException, SQLException {
      connectdb();
        boolean result = false;
        try {
          PreparedStatement statement = connection.prepareStatement("INSERT INTO courtDeatil (hearingDateTime, courtDecision,judgeRuling,evidence,witnesses) VALUES (?, ?, ? , ? , ?)");
          statement.setDate(1, co.getHearingDateTime());
          statement.setString(2, co.getCourtDecision());
          statement.setString(3, co.getJudgeRuling());
          statement.setString(4, co.getEvidence());
          statement.setString(5, co.getWitnesses());
          int rowsAffected = statement.executeUpdate();
          if (rowsAffected > 0) {
            result = true;
          }
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        connection.close();
        return result;
    }

    @Override
    public boolean updateCourtDetail(CourtDetail co) throws RemoteException, SQLException {
      connectdb();
      boolean result = false;
      try {
        PreparedStatement statement = connection.prepareStatement("UPDATE courtDeatil SET hearingDate = ?, courtDecision = ?,judgeRuling = ?,evidence = ?,witnesses = ? WHERE coId = ?");
        statement.setDate(1, co.getHearingDateTime());
        statement.setString(2, co.getCourtDecision());
        statement.setString(3, co.getJudgeRuling());
        statement.setString(4, co.getEvidence());
        statement.setString(5, co.getWitnesses());
        statement.setInt(6, co.getCoId());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
          result = true;
        }
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      connection.close();
      return result;
    }

    @Override
    public boolean deleteCourtDetail(int cId) throws RemoteException, SQLException {
      // TODO Auto-generated method stub
      return false;
    }


    // Record module

    @Override
    public Record getRecord(int RId) throws RemoteException, SQLException {
      connectdb();
      Record r = null;
      try {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM record WHERE recordID = ?");
        statement.setInt(1, RId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
          r = new Record();
        

          r.setRecordName(resultSet.getString("recordName"));
          r.setRecordCategory(resultSet.getString("recordCategory"));
          r.setIncidentLocation(resultSet.getString("incidentLocation"));
          r.setIncidentDate(resultSet.getDate("incidentDate"));
          r.setIncidentTIme(resultSet.getTime("incidentTIme"));
          r.setVictimsName(resultSet.getString("victimsName"));
          r.setRecordDec(resultSet.getString("recordDec"));

        }
        resultSet.close();
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      connection.close();
      return r;
    }

    @Override
    public boolean addRecord(Record ro) throws RemoteException, SQLException {
      connectdb();
      boolean result = false;
      try {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO record (recordName,recordCategory,incidentLocation,incidentDate,incidentTIme,victimsName,recordDec) VALUES (?, ?, ? , ? , ?,?,?)");
        statement.setString(1, ro.getRecordName());
        statement.setString(2, ro.getRecordCategory());
        statement.setString(3, ro.getIncidentLocation());
        statement.setDate(4, ro.getIncidentDate());
        statement.setTime(5, ro.getIncidentTIme());
        statement.setString(6, ro.getVictimsName());
        statement.setString(7, ro.getRecordDec());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
          result = true;
        }
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      connection.close();
      return result;
    }

    @Override
    public boolean updateRecord(Record ro) throws RemoteException, SQLException {
      connectdb();
      boolean result = false;
      try {
        PreparedStatement statement = connection.prepareStatement("UPDATE record SET recordName = ?,recordCategory = ?,incidentLocation = ?,incidentDate = ?,incidentTIme = ?,victimsName = ?,recordDec = ? WHERE recordID = ?");
        statement.setString(1, ro.getRecordName());
        statement.setString(2, ro.getRecordCategory());
        statement.setString(3, ro.getIncidentLocation());
        statement.setDate(4, ro.getIncidentDate());
        statement.setTime(5, ro.getIncidentTIme());
        statement.setString(6, ro.getVictimsName());
        statement.setString(7, ro.getRecordDec());
        statement.setInt(8, ro.getRecordID());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
          result = true;
        }
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      connection.close();
      return result;
    }

    @Override
    public boolean deleteRecord(int RId) throws RemoteException, SQLException {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public Criminal getCriminal(int RId) throws RemoteException, SQLException {
      connectdb();
      Criminal cr = null;
      try {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM criminal WHERE recordID = ?");
        statement.setInt(1, RId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
          cr = new Criminal();

          cr.setCriminalName(resultSet.getString("criminalName"));
          cr.setCriminalNickName(resultSet.getString("criminalNickName"));
          cr.setCriminalDOB(resultSet.getDate("criminalDOB"));
          cr.setAge(resultSet.getInt("age"));
          cr.setGender(resultSet.getString("gender"));
          cr.setBirthRegID(resultSet.getString("birthRegID"));
          cr.setCivilStatus(resultSet.getString("civilStatus"));
          cr.setOccupation(resultSet.getString("occupation"));
          cr.setAddress(resultSet.getString("address"));
          cr.setBirthPlace(resultSet.getString("birthPlace"));
          cr.setEthnicity(resultSet.getString("ethnicity"));
          cr.setPoliticalView(resultSet.getString("politicalView"));
          cr.setReligion(resultSet.getString("religion"));
          cr.setHeight(resultSet.getDouble("height"));

        }
        resultSet.close();
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      connection.close();
      return cr;     
    }

    @Override
    public boolean addCriminal(Criminal cr) throws RemoteException, SQLException {
      connectdb();
      boolean result = false;
      try {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO criminal (criminalName ,criminalNickName ,criminalDOB ,age ,gender ,birthRegID ,birthPlace ,civilStatus ,occupation ,address ,ethnicity ,politicalView ,religion ,height) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        statement.setString(1, cr.getCriminalName());
        statement.setString(2, cr.getCriminalNickName());
        statement.setDate(3, cr.getCriminalDOB());
        statement.setInt(4, cr.getAge());
        statement.setString(5, cr.getGender());
        statement.setString(6, cr.getBirthRegID());
        statement.setString(7, cr.getBirthPlace());
        statement.setString(8, cr.getCivilStatus());
        statement.setString(9, cr.getOccupation());
        statement.setString(10, cr.getAddress());
        statement.setString(11, cr.getEthnicity());
        statement.setString(12, cr.getPoliticalView());
        statement.setString(13, cr.getReligion());
        statement.setDouble(14, cr.getHeight());
      
       
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
          result = true;
        }
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      connection.close();
      return result;
    }

    @Override
    public boolean updateCriminal(Criminal cr) throws RemoteException, SQLException {
      connectdb();
      boolean result = false;
      try {
        PreparedStatement statement = connection.prepareStatement("UPDATE criminal SET criminalName = ? ,criminalNickName = ? ,criminalDOB = ?,age = ?,gender = ?,birthRegID = ? ,birthPlace = ? ,civilStatus = ? ,occupation = ? ,address = ? ,ethnicity = ? ,politicalView = ? ,religion = ? ,height = ? where criminalId = ?");
        statement.setString(1, cr.getCriminalName());
        statement.setString(2, cr.getCriminalNickName());
        statement.setDate(3, cr.getCriminalDOB());
        statement.setInt(4, cr.getAge());
        statement.setString(5, cr.getGender());
        statement.setString(6, cr.getBirthRegID());
        statement.setString(7, cr.getBirthPlace());
        statement.setString(8, cr.getCivilStatus());
        statement.setString(9, cr.getOccupation());
        statement.setString(10, cr.getAddress());
        statement.setString(11, cr.getEthnicity());
        statement.setString(12, cr.getPoliticalView());
        statement.setString(13, cr.getReligion());
        statement.setDouble(14, cr.getHeight());
        statement.setInt(15, cr.getCriminalId());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
          result = true;
        }
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      connection.close();
      return result;
    }

    @Override
    public boolean deleteCriminal(int RId) throws RemoteException, SQLException {
      // TODO Auto-generated method stub
      return false;
    }
    

    
}
