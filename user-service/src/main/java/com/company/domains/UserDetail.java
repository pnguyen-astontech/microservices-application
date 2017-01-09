package com.company.domains;

import com.company.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by petenguy1 on 1/3/2017.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetail {

    // region PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_detail_id;

    @Version
    private Integer version;

    private String first_name;
    private String last_name;

    private String birth_date;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    // endregion

    // region CONSTRUCTORS
    public UserDetail() {
    }

    public UserDetail(String first_name, String last_name, String birth_date, Gender gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.gender = gender;
    }
    // endregion

    // region GETTERS / SETTERS
//    public Long getUser_detail_id() {
//        return user_detail_id;
//    }
//
//    public void setUser_detail_id(Long user_detail_id) {
//        this.user_detail_id = user_detail_id;
//    }
//
//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }

    @NotNull(message = "First name is compulsory")
    @NotBlank(message = "First name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @NotNull(message = "Last name is compulsory")
    @NotBlank(message = "Last name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    @NotNull(message = "Gender is compulsory")
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    // endregion
}
