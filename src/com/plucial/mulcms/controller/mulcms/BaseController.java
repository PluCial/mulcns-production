package com.plucial.mulcms.controller.mulcms;

import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slim3.controller.Navigation;

import com.google.appengine.api.users.User;
import com.plucial.gae.global.exception.NoContentsException;
import com.plucial.global.Lang;
import com.plucial.mulcms.controller.AppController;
import com.plucial.mulcms.enums.AppProperty;
import com.plucial.mulcms.service.AppService;

public abstract class BaseController extends AppController {
    
    /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger(BaseController.class.getName());

    @Override
    protected Navigation notSigned(Map<String, String> appPropertyMap,
            Lang localeLang) throws Exception {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    protected Navigation signed(Map<String, String> appPropertyMap, User user,
            Lang localeLang, Properties userLocaleProp) throws Exception {
        
        if(!appPropertyMap.containsKey(AppProperty.APP_ID.toString())) {
            String value = AppService.getAppId(isLocal());
            AppService.put(AppProperty.APP_ID, value);
            appPropertyMap.put(AppProperty.APP_ID.toString(), value);
        }
        
        if(!appPropertyMap.containsKey(AppProperty.APP_ADMIN_EMAIL.toString())) {
            String value = user.getEmail();
            AppService.put(AppProperty.APP_ADMIN_EMAIL, value);
            appPropertyMap.put(AppProperty.APP_ADMIN_EMAIL.toString(), value);
        }
        
        if(!appPropertyMap.containsKey(AppProperty.APP_BASE_LANG.toString())) {
            AppService.put(AppProperty.APP_BASE_LANG, com.plucial.mulcms.App.APP_BASE_LANG.toString());
            appPropertyMap.put(AppProperty.APP_BASE_LANG.toString(), com.plucial.mulcms.App.APP_BASE_LANG.toString());
        }

        if(!appPropertyMap.containsKey(AppProperty.APP_DEFAULT_HOST_NAME.toString())) {
            String value = AppService.getAppDefaultHostName(isLocal());
            AppService.put(AppProperty.APP_DEFAULT_HOST_NAME, value);
            appPropertyMap.put(AppProperty.APP_DEFAULT_HOST_NAME.toString(), value);
        }

        if(!appPropertyMap.containsKey(AppProperty.APP_GCS_BUCKET_NAME.toString())) {
            String value = AppService.getAppDefaultHostName(isLocal());
            AppService.put(AppProperty.APP_GCS_BUCKET_NAME, value);
            appPropertyMap.put(AppProperty.APP_GCS_BUCKET_NAME.toString(), value);
        }
        
        
        return execute(appPropertyMap, user, userLocaleProp);
    }
    
    /**
     * エラーハンドリング
     */
    @Override
    public Navigation handleError(Throwable error) throws Throwable {
        
        // 404エラー
        if(error instanceof NoContentsException) {
            return forward("/mulcms/error404.jsp");
        }
        
        // 開発環境ではなく、404ではないエラーが発生した場合エラーログを出力
        logger.log(Level.WARNING, error.getMessage(), error);
        
        
        // 500エラー画面に遷移する
        return redirect("/mulcms/error500.jsp");
    }

    /**
     * リクエスト処理
     * @param appPropertyMap
     * @param user
     * @param userLocaleProp
     * @return
     * @throws Exception
     */
    public abstract Navigation execute(Map<String, String> appPropertyMap, User user, Properties userLocaleProp) throws Exception;

}
