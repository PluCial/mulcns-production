package com.plucial.mulcms.controller.mulcms.billing;

import java.util.Map;
import java.util.Properties;

import org.slim3.controller.Navigation;

import com.google.appengine.api.users.User;
import com.plucial.mulcms.App;
import com.plucial.mulcms.controller.mulcms.BaseController;
import com.plucial.mulcms.service.AppService;
import com.plucial.paypal.api.DoExpressCheckoutPayment;
import com.plucial.paypal.api.GetExpressCheckoutDetails;
import com.plucial.paypal.model.expressCheckout.GetCheckoutDetailsResponse;

public class BillingCompController extends BaseController {
    
    @Override
    public Navigation execute(Map<String, String> appPropertyMap, User user,
            Properties userLocaleProp) throws Exception {
        
        // Token の取得
        String token = asString("token");
        
        // ---------------------------------------------------------------------------
        // APIの実行
        // ---------------------------------------------------------------------------
        GetCheckoutDetailsResponse detailsRespons = 
                new GetExpressCheckoutDetails(App.PAYPAL_ENV).getDetails(token);
        
        
        // ---------------------------------------------------------------------------
        // ライセンスの追加
        // ---------------------------------------------------------------------------
        AppService.addLicense(super.isLocal());
        
        // ---------------------------------------------------------------------------
        // 課金の確定
        // ---------------------------------------------------------------------------
        new DoExpressCheckoutPayment(App.PAYPAL_ENV).sale(detailsRespons);
        
        return redirect("/mulcms/");
    }
}
