package api.models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleResponse {
    private String id;
    private String name;
    private String job;

    @JsonProperty("createdAt")
    private String createdAt;

    // getters y setters
    public SampleResponse() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
