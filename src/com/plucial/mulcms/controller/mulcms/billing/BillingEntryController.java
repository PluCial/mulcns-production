package com.plucial.mulcms.controller.mulcms.billing;

import java.util.Map;
import java.util.Properties;

import org.slim3.controller.Navigation;

import com.google.appengine.api.users.User;
import com.plucial.global.Currencie;
import com.plucial.mulcms.App;
import com.plucial.mulcms.controller.mulcms.BaseController;
import com.plucial.mulcms.exception.NoLicenseException;
import com.plucial.mulcms.service.AppService;
import com.plucial.paypal.api.SetExpressCheckout;
import com.plucial.paypal.enums.ItemCategory;
import com.plucial.paypal.enums.Locale;
import com.plucial.paypal.model.expressCheckout.Item;
import com.plucial.paypal.model.expressCheckout.SetCheckoutResponse;

public class BillingEntryController extends BaseController {
    
    @Override
    public Navigation execute(Map<String, String> appPropertyMap, User user,
            Properties userLocaleProp) throws Exception {
        
        try {
            AppService.hasLicense(super.isLocal());
            
            return forward("/mulcms/");
            
        }catch(NoLicenseException e) {
            
            String appId = AppService.getAppId(super.isLocal());

            // ---------------------------------------------------------------------------
            // APIの実行
            // ---------------------------------------------------------------------------
            SetExpressCheckout api = new SetExpressCheckout(App.PAYPAL_ENV);
            SetCheckoutResponse setCheckoutResponse = api.setLocaleCode(Locale.ja_JP)
                    .setRetuerUrl(super.getDomainUrl() + "/mulcms/billing/billingComp")
                    .setCancelUrl(super.getDomainUrl() + "/mulcms/billing/")
                    .setNoShipping(1)
                    .setReqconfirmShipping(false)
                    .setCurrencie(Currencie.JPY)
                    .addItem(new Item(
                        App.APP_DISPLAY_NAME + " License (" + appId + ")", 
                        App.AMOUNT * 1.08, 
                        1, 
                        ItemCategory.Digital))
                        .sale();

            return redirect(setCheckoutResponse.getRedirectToPayPalUrl(api.getEndPoint()));
        }
    }
}
