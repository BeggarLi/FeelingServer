package com.li.feeling.net;

/**
 * description: 异常
 */
public class FeelingException extends RuntimeException {

    public int mErrorCode;
    public String mErrorMessage;

    public FeelingException(int errorCode, String errorMessage) {
        mErrorCode = errorCode;
        mErrorMessage = errorMessage;
    }
}
