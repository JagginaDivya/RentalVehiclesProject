package com.vehicle.rental.Exception;

public class OtpServiceException extends RuntimeException {

    /**
     * OtpCache Exception with error message
     *
     * @param errorMessage error message
     */
    public OtpServiceException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * OtpCache Exception with error message and throwable
     *
     * @param errorMessage error message
     * @param throwable    error
     */
    public OtpServiceException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

}
