package com.company.domains;

/**
 * Created by petenguy1 on 1/9/2017.
 */
public class UserDTO {
    private Integer user_id;
    private Integer version;
    private String username;
    private String password;
    private String email_address;
    private String create_date;
    private String user_type;
    private UserDetailDTO user_detail;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public UserDetailDTO getUser_detail() {
        return user_detail;
    }

    public void setUser_detail(UserDetailDTO user_detail) {
        this.user_detail = user_detail;
    }
}
