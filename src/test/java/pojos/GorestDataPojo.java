package pojos;

public class GorestDataPojo {
    private String message;

    public GorestDataPojo() {
    }

    public GorestDataPojo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DataPojo{" +
                "message='" + message + '\'' +
                '}';
    }
}
