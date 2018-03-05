package com.ben.webservicerequest;

/**
 * Created by benparker on 04/07/17.
 * All view names held on the system to provide the app with download data
 */

public interface I_WebServiceConstants {
    static final String TODAYS_ACTIONS = "SMA_TodaysActions_v";
    static final String ALL_ACTIONS = "SMA_AllActions_v";
    static final String TODAYS_ROUTE_PLAN = "SMA_TodaysRoutePlan_v";
    static final String ALL_ORDERS_FOR_BP = "SMA_AllOrdersForBP_v";
    static final String ALL_INVOICES_FOR_BP = "SMA_AllInvoicesForBP_v";
    static final String ALL_REQUESTS_FOR_BP = "SMA_AllRequestForBP_v";
    static final String ALL_DAILY_NOTIFICATIONS_FORUSER = "SMA_DailyNotifications_v";

    /** All web-service-security methods to be called **/
    static final String SMA_GetUserDetails = "SMA_GetUserDetails";
}
