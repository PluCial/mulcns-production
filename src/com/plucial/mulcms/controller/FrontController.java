package com.plucial.mulcms.controller;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.jsoup.nodes.Document;
import org.slim3.controller.Navigation;

import com.google.appengine.api.users.User;
import com.plucial.gae.global.exception.NoContentsException;
import com.plucial.gae.global.exception.ObjectNotExistException;
import com.plucial.global.Lang;
import com.plucial.mulcms.enums.AppProperty;
import com.plucial.mulcms.exception.NoLicenseException;
import com.plucial.mulcms.model.assets.Page;
import com.plucial.mulcms.service.AppService;
import com.plucial.mulcms.service.assets.PageService;

public class FrontController extends AppController {

    @Override
    protected Navigation notSigned(Map<String, String> appPropertyMap,
            Lang localeLang) throws Exception {
        
        hasLicense(super.isLocal());
        
        String gcsBucketName = appPropertyMap.get(AppProperty.APP_GCS_BUCKET_NAME.toString());
        
        renderingPageDoc(localeLang, gcsBucketName, false);
        return forward("/front.jsp");
    }

    @Override
    protected Navigation signed(Map<String, String> appPropertyMap, User user,
            Lang userLang, Properties userLocaleProp) throws Exception {
        
        Lang localeLang = super.getLocaleLang();
        String gcsBucketName = appPropertyMap.get(AppProperty.APP_GCS_BUCKET_NAME.toString());
        renderingPageDoc(localeLang, gcsBucketName, true);
        return forward("/front.jsp");
    }
    
    /**
     * ライセンスチェック
     * @param isLocal
     * @throws NoContentsException
     * @throws ObjectNotExistException
     */
    private void hasLicense(boolean isLocal) throws NoContentsException, ObjectNotExistException {
        try {
            AppService.hasLicense(isLocal);

        } catch (NoLicenseException e) {

            int diff = AppService.getFreePeriodDate().compareTo(new Date());
            if(diff < 0) {
                throw new NoContentsException();
            }
        }
    }
    
    /**
     * Page Html のレンダリング
     * @param localeLang
     * @param gcsBucketName
     * @param isSigned
     * @throws NoContentsException
     */
    private void renderingPageDoc(Lang localeLang, String gcsBucketName, boolean isSigned) throws NoContentsException {
        try {
            Page page = (Page)PageService.get(asString("path"));
            if(page.getLangList().indexOf(localeLang) < 0) {
                throw new NoContentsException();
            }
        

        // ----------------------------------------------------
        // Page 生成
        // ----------------------------------------------------
        Document pageDoc = PageService.getRenderedDoc(page, localeLang, gcsBucketName, super.getDomainUrl(), isSigned);
        
        requestScope("pageHtml", pageDoc.outerHtml());
        
        }catch(ObjectNotExistException e) {
            throw new NoContentsException();
        }
    }
}
