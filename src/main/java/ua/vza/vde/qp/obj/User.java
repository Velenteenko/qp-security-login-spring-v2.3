package ua.vza.vde.qp.obj;

/**
 * Created by velenteenko on 25.06.15.
 */
public class User {

    public User(){}

    private String fio;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return new StringBuffer("fio: ").append(this.fio).toString();
    }
}
