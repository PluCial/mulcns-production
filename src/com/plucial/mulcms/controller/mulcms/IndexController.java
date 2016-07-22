package com.plucial.mulcms.controller.mulcms;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slim3.controller.Navigation;

import com.google.appengine.api.users.User;
import com.plucial.mulcms.exception.NoLicenseException;
import com.plucial.mulcms.model.assets.Page;
import com.plucial.mulcms.service.AppService;
import com.plucial.mulcms.service.assets.PageService;

public class IndexController extends BaseController {

    @Override
    public Navigation execute(Map<String, String> appPropertyMap, User user,
            Properties userLocaleProp) throws Exception {
        
        List<Page> pageList = PageService.getList();
        requestScope("pageList", pageList);
        
        try {
            AppService.hasLicense(super.isLocal());
            
        } catch (NoLicenseException e) {
            
            Date freePeriodDate = AppService.getFreePeriodDate();

            requestScope("freePeriodDate", freePeriodDate);
        }
        
        return forward("index.jsp");
    }
}
