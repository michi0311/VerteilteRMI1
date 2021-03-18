import java.rmi.Remote;
import java.rmi.RemoteException;

/****************************
 * Created by Michael Marolt *
 *****************************/

public interface Hello extends Remote {
    String sayHello(String name) throws RemoteException;
}
