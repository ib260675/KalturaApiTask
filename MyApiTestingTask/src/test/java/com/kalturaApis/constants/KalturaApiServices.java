package com.kalturaApis.constants;

public final class KalturaApiServices {
    public static final String BASE_URI = "https://rest-eus1.ott.kaltura.com";
    public static final String BASE_PATH = "/restful_v5_0/api_v3";
    public static final String CONTENT_TYPE = "application/json\n";
    public final class OttUser{
        public final class EndPoints{
            public static final String REGISTER = "/service/ottuser/action/register";
            public static final String LOGIN ="/service/ottuser/action/login";
            public static final String UPDATE = "/service/ottuser/action/update";
        }
        public final class RequestBodysTemplates {
            public static final String BASIC = "requestBodysTemplates/basicBody.json";
            public static final String BODY_ACCORDING_API_DOCUMENTATION = "requestBodysTemplates/bodyAccordingDocumentation.json";
        }
    }
}
