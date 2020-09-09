package com.project.controller.user;

import javax.validation.Valid;

import com.project.model.user.UserEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" },maxAge = 6000)
@RestController
public class UserController {

    @PostMapping("/user/register")
    @ApiOperation(value = "회원가입", notes = "회원 가입 입니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "사용자 UID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "upw", value = "사용자 Password", required = true, dataType = "string"),
            @ApiImplicitParam(name = "email", value = "사용자 E-mail", required = true, dataType = "string"),
            @ApiImplicitParam(name = "name", value = "사용자 이름", required = true, dataType = "string"),
            @ApiImplicitParam(name = "phone", value = "연락처", required = true, dataType = "string"),
            @ApiImplicitParam(name = "address", value = "주소", required = true, dataType = "string"),
            @ApiImplicitParam(name = "profile", value = "자기 소개", required = true, dataType = "string"),
            @ApiImplicitParam(name = "usertype", value = "회원 유형", required = true, dataType = "int"),          
    })
    public ResponseEntity<Object> register(@Valid @RequestBody UserEntity user){
        System.out.println(user);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/user/detail")
    @ApiOperation(value = "회원 정보", notes = "회원 정보 조회 입니다.")
    public ResponseEntity<Object> detail(@Valid @RequestParam int uid){

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/user/update")
    @ApiOperation(value = "회원 정보 수정", notes ="회원 정보 수정 입니다.")
    public void update(@Valid @RequestParam int uid){
        ;
    }

    @PostMapping("/user/delete")
    @ApiOperation(value = "회원 탈퇴", notes = "회원 탈퇴 입니다.")
    public void delete(@Valid @RequestParam int uid){
        ;
    }

    // @PostMapping("/user/findPw")
    // @ApiOperation(value = "비밀번호 찾기", notes = "비밀번호 찾기 입니다.")
    // public ResponseEntity<Object>(@Valid @RequestParam String email){
    //     ;
    // }
}