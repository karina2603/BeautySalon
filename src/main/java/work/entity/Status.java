package work.entity;

public enum Status {
    Free("FREE"),
    Booked("BOOKED");

    private String status;

    Status(String name) {
        this.status = name;
    }

    public String getStatus() {
        return status;
    }
}
