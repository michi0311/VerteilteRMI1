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
    public DataOut sayHello(Data data) throws RemoteException {
        return new DataOut("Hello, " + data.name + ". You are " + data.age + " years old and based in " + data.position);
    }

    public static void main(String[] args) {
        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj,0);

            reg.bind("Data", stub);

            System.out.println("Server ready!");
        } catch (Exception e) {
            System.err.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
