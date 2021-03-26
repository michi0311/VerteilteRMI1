import java.rmi.Remote;
import java.rmi.RemoteException;

/****************************
 * Created by Michael Marolt *
 *****************************/

public interface Hello extends Remote {
    DataOut sayHello(Data data) throws RemoteException;
}
