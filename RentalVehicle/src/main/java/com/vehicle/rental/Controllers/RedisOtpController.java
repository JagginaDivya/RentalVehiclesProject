package com.vehicle.rental.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.rental.Util.OtpGenerator;
import com.vehicle.rental.Services.EmailSenderService;
import com.vehicle.rental.models.OtpKeyModel;
import com.vehicle.rental.models.OtpModel;
import com.vehicle.rental.repository.CacheRepository;


@RestController
@RequestMapping("/api/v1/otp")
public class RedisOtpController {
	
	
	private final CacheRepository cacheRepository;
	
	private final OtpGenerator otpGenerator;
    
    @Autowired
    private final EmailSenderService emailSenderService;
 

    @Autowired
    public RedisOtpController(CacheRepository cacheRepository, OtpGenerator otpGenerator,EmailSenderService emailSenderService ) {
        this.cacheRepository = cacheRepository;
        this.otpGenerator = otpGenerator;
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> sendEmailAndAddToCache(@RequestBody OtpKeyModel key) {
    	
    	int value = otpGenerator.generateOtp();
        String body="Hi, your otp is "+value;
        emailSenderService.sendEmail(key.getEmail(), "Testing OTP Feature", body);
        cacheRepository.put(key.getEmail(), value);

        return ResponseEntity.ok("Otp Generated Successfully Otp : " + value);
    }


    @PostMapping("/verify")
    public ResponseEntity<String> removeFromCache(@RequestBody OtpModel otpValidateRequest) {
    	
        Optional<String> s = cacheRepository.get(otpValidateRequest.getKey());

        if (s.isPresent() && s.get().equals(otpValidateRequest.getOtp())) {
            cacheRepository.remove(otpValidateRequest.getKey());
            return ResponseEntity.ok("Key Removed from cache key:  " + otpValidateRequest.getKey());
        }

        return ResponseEntity.badRequest().body("Invalid Otp");
    }


}
