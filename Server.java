import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
        public static final int REMOTE_PORT = 8888;
        public static final String REMOTE_ID = "Server";
        public static final String REMOTE_HOST = "localhost";

        public static void main(String[] args) throws RemoteException, java.rmi.AlreadyBoundException {

            InterfaceImpl rmiImplementation = new InterfaceImpl();
            Registry registry = LocateRegistry.createRegistry(REMOTE_PORT);
            registry.bind(REMOTE_ID, rmiImplementation);
            System.out.print("Server started...");
        }

      
             
    }
