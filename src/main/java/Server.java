import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/****************************
 * Created by Michael Marolt *
 *****************************/

public class Server implements Hello {
    static Registry reg;
    public Server() {
        try {
            reg = LocateRegistry.createRegistry(1099);
        } catch (Exception e) {
            System.err.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }

    }

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.println(name);
        return "Hello, " + name;
    }

    public static void main(String[] args) {
        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj,0);

            reg.bind("Hello", stub);

            System.out.println("Server ready!");
        } catch (Exception e) {
            System.err.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
