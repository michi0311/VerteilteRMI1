import java.io.Serializable;

/****************************
 * Created by Michael Marolt *
 *****************************/

public class Data implements Serializable {
    String name;
    int age;
    String position;

    public Data(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }
}
