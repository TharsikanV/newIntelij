package com.finalProject.finalProject.controller;

import com.finalProject.finalProject.comman.APIResponse;
import com.finalProject.finalProject.dto.LoginRequestDTO;
import com.finalProject.finalProject.dto.SignUpRequestDTO;
import com.finalProject.finalProject.service.LoginService;
import com.finalProject.finalProject.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private JwtUtils jwtUtils;
    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO){

        APIResponse apiResponse=loginService.signUp(signUpRequestDTO);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO){

        APIResponse apiResponse=loginService.login(loginRequestDTO);
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }

    @PostMapping("/verifyy")
    public ResponseEntity<APIResponse> verifyUser(@RequestParam String email, @RequestParam String otp){
        APIResponse apiResponse=new APIResponse();
        loginService.verifyy(email, otp);
        apiResponse.setData("User verified successfully");

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @PostMapping("/verify")
    public ResponseEntity<APIResponse> verify(@RequestParam String otp){
//        APIResponse apiResponse=new APIResponse();
        APIResponse apiResponse=loginService.verify(otp);


        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @DeleteMapping("/signOut")
    public ResponseEntity<APIResponse> deleteUserById(){

        APIResponse apiResponse=loginService.deleteUserById();
        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);

    }
    @GetMapping("/privateApi")
    public ResponseEntity <APIResponse> privateApi(@RequestHeader(value ="authorization",defaultValue ="") String auth) throws Exception {
        APIResponse apiResponse=new APIResponse();

        jwtUtils.verify(auth);
        apiResponse.setData("This is private api");
        return  ResponseEntity.
                status(apiResponse.getStatus())
                .body(apiResponse);

    }

}
