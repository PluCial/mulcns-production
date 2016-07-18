package com.plucial.mulcms.enums;

import com.plucial.mulcms.App;

/**
 * 環境
 * @author takahara
 */
public enum Environment {
    /**
     * ステージング環境
     */
    Staging(
        App.PAYPAL_EXPRESS_CHECKOUT_SANDBOX_USER,
        App.PAYPAL_EXPRESS_CHECKOUT_SANDBOX_PWD,
        App.PAYPAL_EXPRESS_CHECKOUT_SANDBOX_SIGNATURE
        ),
    /**
     * 本番環境(プロダクション環境)
     */
    production(
        App.PAYPAL_EXPRESS_CHECKOUT_USER,
        App.PAYPAL_EXPRESS_CHECKOUT_PWD,
        App.PAYPAL_EXPRESS_CHECKOUT_SIGNATURE
        );
    
    // ---------------------------------------------------
    // Paypal
    // ---------------------------------------------------
    private String paypalExpressCheckoutUser;
    
    private String paypalExpressCheckoutPwd;
    
    private String paypalExpressCheckoutSignature;
    
    /**
     * コンストラクター
     * @param paypalExpressCheckoutUser
     * @param paypalExpressCheckoutPwd
     * @param paypalExpressCheckoutSignature
     */
    private Environment(
            String paypalExpressCheckoutUser,
            String paypalExpressCheckoutPwd,
            String paypalExpressCheckoutSignature) {
        
        this.setPaypalExpressCheckoutUser(paypalExpressCheckoutUser);
        this.setPaypalExpressCheckoutPwd(paypalExpressCheckoutPwd);
        this.setPaypalExpressCheckoutSignature(paypalExpressCheckoutSignature);
    }

    public String getPaypalExpressCheckoutUser() {
        return paypalExpressCheckoutUser;
    }

    public void setPaypalExpressCheckoutUser(String paypalExpressCheckoutUser) {
        this.paypalExpressCheckoutUser = paypalExpressCheckoutUser;
    }

    public String getPaypalExpressCheckoutPwd() {
        return paypalExpressCheckoutPwd;
    }

    public void setPaypalExpressCheckoutPwd(String paypalExpressCheckoutPwd) {
        this.paypalExpressCheckoutPwd = paypalExpressCheckoutPwd;
    }

    public String getPaypalExpressCheckoutSignature() {
        return paypalExpressCheckoutSignature;
    }

    public void setPaypalExpressCheckoutSignature(
            String paypalExpressCheckoutSignature) {
        this.paypalExpressCheckoutSignature = paypalExpressCheckoutSignature;
    }
}
