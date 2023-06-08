package com.google.android.gms.measurement.internal;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
public class zzhb {
    public static final String[] zza = {"app_background", "app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "ga_campaign", MediaRouteProviderProtocol.SERVICE_DATA_ERROR, "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter", "session_start_with_rollout", "firebase_campaign"};
    public static final String[] zzb = {"_ab", "_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_ar", "_vs", "_ep", "_ssr", "_cmp"};
    public static final String[] zzc = {FirebaseAnalytics.Event.PURCHASE, FirebaseAnalytics.Event.REFUND, FirebaseAnalytics.Event.ADD_PAYMENT_INFO, FirebaseAnalytics.Event.ADD_SHIPPING_INFO, FirebaseAnalytics.Event.ADD_TO_CART, FirebaseAnalytics.Event.ADD_TO_WISHLIST, FirebaseAnalytics.Event.BEGIN_CHECKOUT, FirebaseAnalytics.Event.REMOVE_FROM_CART, FirebaseAnalytics.Event.SELECT_ITEM, FirebaseAnalytics.Event.SELECT_PROMOTION, FirebaseAnalytics.Event.VIEW_CART, FirebaseAnalytics.Event.VIEW_ITEM, FirebaseAnalytics.Event.VIEW_ITEM_LIST, FirebaseAnalytics.Event.VIEW_PROMOTION, FirebaseAnalytics.Event.ECOMMERCE_PURCHASE, FirebaseAnalytics.Event.PURCHASE_REFUND, FirebaseAnalytics.Event.SET_CHECKOUT_OPTION, FirebaseAnalytics.Event.CHECKOUT_PROGRESS, FirebaseAnalytics.Event.SELECT_CONTENT, FirebaseAnalytics.Event.VIEW_SEARCH_RESULTS};

    protected zzhb() {
    }

    public static String zza(String str) {
        return zzil.zza(str, zzb, zza);
    }

    public static String zzb(String str) {
        return zzil.zza(str, zza, zzb);
    }
}
