package pojos;

public class DataPojo {
    private String message;

    public DataPojo() {
    }

    public DataPojo(String message) {
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
