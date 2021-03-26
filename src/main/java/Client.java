import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*****************************
 * Created by Michael Marolt *
 *****************************/

public class Client {
    private Client() {
        
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Data data = new Data("Michael",21,"Sankt Kanzian");
            DataService stub = (DataService) registry.lookup("Data");
            DataOut response = stub.sendData(data);
            System.out.println("Response: " + response.out);
        } catch (Exception e) {
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
