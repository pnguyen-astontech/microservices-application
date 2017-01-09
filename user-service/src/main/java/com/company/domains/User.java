package com.company.domains;

import com.company.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by petenguy1 on 12/21/2016.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    // region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @Version
    private Integer version;

    private String username;
    private String password;
    private String email_address;

    private String create_date;

    @Enumerated(EnumType.STRING)
    private UserType user_type;

    @OneToOne
    private UserDetail user_detail;
    // endregion

    // region CONSTRUCTORS
    public User() {
    }

    public User(String username, String password, String email_address, String create_date, UserType user_type, UserDetail user_detail) {
        this.username = username;
        this.password = password;
        this.email_address = email_address;
        this.create_date = create_date;
        this.user_type = user_type;
        this.user_detail = user_detail;
    }
// endregion

    // region GETTERS / SETTERS
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @NotNull(message = "User name is compulsory")
    @NotBlank(message = "User name is compulsory")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message = "Password is compulsory")
    @NotBlank(message = "Password name is compulsory")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message="Email Address is compulsory")
    @NotBlank(message="Email Address is compulsory")
    @Email(message = "Email Address is not a valid format")
    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
    }

    public UserDetail getUser_detail() {
        return user_detail;
    }

    public void setUser_detail(UserDetail user_detail) {
        this.user_detail = user_detail;
    }
    // endregion
}
