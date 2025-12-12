package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
    private String id;
    private String name;
    private String job;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("createdAt")
    private String createdAt;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getJob() { return job; }
    public String getUpdatedAt() { return updatedAt; }
    public String getCreatedAt() { return createdAt; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setJob(String job) { this.job = job; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
