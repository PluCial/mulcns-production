package com.plucial.mulcms.exception;

/**
 * データ重複エラー
 * @author takahara
 *
 */
public class NoLicenseException extends Exception {

    private static final long serialVersionUID = 1L;
    
    private static final String message = "ライセンスありません。";
    
    /**
     * コンストラクタ
     */
    public NoLicenseException() {
        super(message);
    }
    
    /**
     * コンストラクタ
     */
    public NoLicenseException(String message) {
        super(message);
    }

}
