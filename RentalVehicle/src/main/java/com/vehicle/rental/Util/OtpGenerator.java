package com.vehicle.rental.Util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.vehicle.rental.Exception.OtpServiceException;

/**
 * Otp Generator
 */
@Component
public class OtpGenerator {

    private static final String DEFAULT_ALGORITHM = "SHA1PRNG";
    private static final int LOWER_BOUND = 100000;
    private static final int UPPER_BOUND = 900000;

    /**
     * Generate the Otp
     *
     * @return 6 digits otp
     */
    public int generateOtp() {
        try {
            Random random = SecureRandom.getInstance(DEFAULT_ALGORITHM);
            return LOWER_BOUND + random.nextInt(UPPER_BOUND);
        } catch (NoSuchAlgorithmException e) {
            throw new OtpServiceException("Invalid algorithm for generating otp", e);
        }
    }

}
