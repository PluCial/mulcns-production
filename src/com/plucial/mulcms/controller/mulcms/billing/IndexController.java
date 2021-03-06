package com.plucial.mulcms.controller.mulcms.billing;

import java.util.Map;
import java.util.Properties;

import org.slim3.controller.Navigation;

import com.google.appengine.api.users.User;
import com.plucial.mulcms.controller.mulcms.BaseController;
import com.plucial.mulcms.service.AppService;

public class IndexController extends BaseController {

    @Override
    public Navigation execute(Map<String, String> appPropertyMap, User user,
            Properties userLocaleProp) throws Exception {
        
        requestScope("appId", AppService.getAppId(super.isLocal()));
        
        return forward("index.jsp");
    }
}
