import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/****************************
 * Created by Michael Marolt *
 *****************************/

public class Client {
    private Client() {

    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello("Michael Marolt");
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
