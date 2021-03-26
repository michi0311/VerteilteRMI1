import java.rmi.Remote;
import java.rmi.RemoteException;

/*****************************
 * Created by Michael Marolt *
 *****************************/

public interface DataService extends Remote {
    DataOut sendData(Data data) throws RemoteException;
}
