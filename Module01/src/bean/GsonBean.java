package bean;

/**
 * @author zhangjun
 * @create 2018/11/15/18:15
 */
public class GsonBean {

    /**
     * firstName : z
     * lastName : Jason
     * email : bbbb@126.com
     * height : 1.67
     */

    private String firstName;
    private String lastName;
    private String email;
    private double height;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
