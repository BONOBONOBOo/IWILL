package com.project.dto;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class User {
    int uid; // uid
    String upw; // passwd
    String email; // email
    String name;  // 이름
    String phone; // phone
    String address; // address
    String createDate; // 생성일
    String sendDate;
    String profile;    //
    int usertype;      // 회원 유형
}