package com.Inazuma.learn.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "database")
@Validated
public class Database {

    @NotBlank
    private String url;
    @NotBlank
    private String username;
    private String password;
    @Min(5)
    private int timeout;
    private Pool pool;

    private List<String> servers;

    private Map<String, String> roles;


}
@Data
class Pool {
    private int maxSize;
    private int minSize;
}