package models;

public class Request {

    private Long id_request;
    private String firstName;
    private String secondName;
    private String emailRequest;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getId_request() {
        return id_request;
    }

    public void setId_request(Long id_request) {
        this.id_request = id_request;
    }

    public String getEmailRequest() {
        return emailRequest;
    }

    public void setEmailRequest(String emailRequest) {
        this.emailRequest = emailRequest;
    }
}
