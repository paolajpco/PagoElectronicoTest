package api.models;

public class UserRequest {
    private String name;
    private String job;

    public UserRequest() {}

    public UserRequest(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() { return name; }
    public String getJob() { return job; }
    public void setName(String name) { this.name = name; }
    public void setJob(String job) { this.job = job; }

    // Builder opcional
    public static UserRequestBuilder builder() { return new UserRequestBuilder(); }

    public static class UserRequestBuilder {
        private String name;
        private String job;

        public UserRequestBuilder name(String name) { this.name = name; return this; }
        public UserRequestBuilder job(String job) { this.job = job; return this; }
        public UserRequest build() { return new UserRequest(name, job); }
    }
}
