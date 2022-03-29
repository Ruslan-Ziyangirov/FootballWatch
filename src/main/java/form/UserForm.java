package form;

public class UserForm {

    private String first_name;
    private String login;
    private String second_name;
    private String password;
    private String email;

    public UserForm() {

    }

    public UserForm(String first_name, String login, String second_name, String password, String email) {
        this.first_name = first_name;
        this.login = login;
        this.second_name = second_name;
        this.password = password;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "first_name='" + first_name + '\'' +
                ", login='" + login + '\'' +
                ", second_name='" + second_name + '\'' +
                ", passwordHash='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
