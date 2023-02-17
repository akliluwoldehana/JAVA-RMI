import java.rmi.*;
import java.sql.SQLException;

public interface Remoteinterface extends Remote {

    //Complaint Module
    public Complaint getcomplaint(int cId) throws RemoteException,SQLException;
    public boolean addcomplaint(Complaint c) throws RemoteException,SQLException;
    public boolean updatecomplaint(Complaint c) throws RemoteException,SQLException;
    public boolean deletecomplaint(int cId) throws RemoteException,SQLException;
    public void connectdb()  throws RemoteException,SQLException;

    //Court Detail module
    public CourtDetail CourtDetail(int coId) throws RemoteException,SQLException;
    public boolean addCourtDetail(CourtDetail co) throws RemoteException,SQLException;
    public boolean updateCourtDetail(CourtDetail co) throws RemoteException,SQLException;
    public boolean deleteCourtDetail(int coId) throws RemoteException,SQLException;

    //Crime record module
    public Record getRecord(int RId) throws RemoteException,SQLException;
    public boolean addRecord(Record ro) throws RemoteException,SQLException;
    public boolean updateRecord(Record ro) throws RemoteException,SQLException;
    public boolean deleteRecord(int RId) throws RemoteException,SQLException;

    //criminal module
    public Criminal getCriminal(int RId) throws RemoteException,SQLException;
    public boolean addCriminal(Criminal cr) throws RemoteException,SQLException;
    public boolean updateCriminal(Criminal cr) throws RemoteException,SQLException;
    public boolean deleteCriminal(int RId) throws RemoteException,SQLException;



   

    
}
