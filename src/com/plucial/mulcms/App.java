package com.plucial.mulcms;

import com.plucial.global.Lang;
import com.plucial.paypal.enums.EndPoint;
import com.plucial.paypal.model.Environment;


public class App {
    
    /** アプリケーション名 */
    public static final String APP_DISPLAY_NAME = "MulCMS";
    
    /**
     * 運用会社名
     */
    public static final String MANAGEMENT_COMPANY_NAME = "Plucial,Inc.";
    
    /**
     * 運用会社名
     */
    public static final String MANAGEMENT_COMPANY_URL = "http://inc.plucial.com";
    
    /**
     * 請求額
     */
    public static final double AMOUNT = 298000;
    
    /**
     * サービスのベース言語
     */
    public static final Lang APP_BASE_LANG = Lang.ja;
    
    // ---------------------------------------------------
    // Paypal(本番)
    // ---------------------------------------------------
    public static final String PAYPAL_EXPRESS_CHECKOUT_USER = "info_api1.plucial.com";
    
    public static final String PAYPAL_EXPRESS_CHECKOUT_PWD = "F3KBVPLAUR8UZVKR";
    
    public static final String PAYPAL_EXPRESS_CHECKOUT_SIGNATURE = "AFcWxV21C7fd0v3bYYYRCpSSRl31A5GaIAS0fzV2QEZP.mRbZyCu17AE";
    
    public static final Environment PAYPAL_ENV = new Environment(
        EndPoint.SANDBOX, 
        App.PAYPAL_EXPRESS_CHECKOUT_USER,
        App.PAYPAL_EXPRESS_CHECKOUT_PWD,
        App.PAYPAL_EXPRESS_CHECKOUT_SIGNATURE);
    
    // ---------------------------------------------------
    // Paypal(SandBox)
    // ---------------------------------------------------
    public static final String PAYPAL_EXPRESS_CHECKOUT_SANDBOX_USER = "info_api1.plucial.com";
    
    public static final String PAYPAL_EXPRESS_CHECKOUT_SANDBOX_PWD = "XFYX8HMWPUVQBA8H";
    
    public static final String PAYPAL_EXPRESS_CHECKOUT_SANDBOX_SIGNATURE = "AiPC9BjkCyDFQXbSkoZcgqH3hpacAW563g9VXnaHQqZwH60nhoycdVkv";
    
//    public static final Environment PAYPAL_ENV = new Environment(
//        EndPoint.SANDBOX, 
//        App.PAYPAL_EXPRESS_CHECKOUT_SANDBOX_USER,
//        App.PAYPAL_EXPRESS_CHECKOUT_SANDBOX_PWD,
//        App.PAYPAL_EXPRESS_CHECKOUT_SANDBOX_SIGNATURE);

}
