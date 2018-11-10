package com.kalturaApis.constants;

public final class KalturaApiServices {
    public static final String BASE_URI = "https://rest-eus1.ott.kaltura.com";
    public static final String BASE_PATH = "/restful_v5_0/api_v3";
    public static final String CONTENT_TYPE = "application/json\n";
    public final class OttUser{
        public final class ActionsEndPoints {
            public static final String REGISTER = "/service/ottuser/action/register";
            public static final String LOGIN ="/service/ottuser/action/login";
            public static final String UPDATE = "/service/ottuser/action/update";
        }
        public final class RequestBodysTemplates {
            public final class Actions{
                public final class Register{
                    public static final String BASIC = "requestBodysTemplates/services/ottUser/actions/register/basicBody.json";
                    public static final String BODY_ACCORDING_API_DOCUMENTATION = "requestBodysTemplates/services/ottUser/actions/register/bodyAccordingDocumentation.json";
                }
                public final class Login{
                    public static final String BASIC = "requestBodysTemplates/services/ottUser/actions/login/basicBody.json";
                }
                public final class Update{
                    public static final String BASIC = "requestBodysTemplates/services/ottUser/actions/update/basicBody.json";
                }
            }
        }
    }
}
