package com.xiaowo.utils.message;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

/**
 * 云通讯短信接口SDK
 * Created by WeiHong on 2017/6/23.
 */
public class CCPRestSDK {


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private String TIMESTAMP;

    private String SERVER_IP;
    private String SERVER_PORT;
    private String ACCOUNT_SID;
    private String ACCOUNT_TOKEN;
    public String App_ID;


    /**
     * 初始化服务地址和端口
     *
     * @param serverIP   必选参数 服务器地址
     * @param serverPort 必选参数 服务器端口
     */
    public void init(String serverIP, String serverPort) {
//        if (Strings.isNullOrEmpty(serverIP) || Strings.isNullOrEmpty(serverPort)) {
//            throw new IllegalArgumentException("必选参数:"
//                    + (Strings.isNullOrEmpty(serverIP) ? " 服务器地址 " : "")
//                    + (Strings.isNullOrEmpty(serverPort) ? " 服务器端口 " : "") + "为空");
//        }
        SERVER_IP = serverIP;
        SERVER_PORT = serverPort;
    }

    /**
     * 初始化应用Id
     *
     * @param appId 必选参数 应用Id
     */
    public void setAppId(String appId) {
//        if (Strings.isNullOrEmpty(appId)) {
//            throw new IllegalArgumentException("必选参数: 应用Id 为空");
//        }
        App_ID = appId;
    }

    /**
     * 初始化主帐号信息
     *
     * @param accountSid   必选参数 主帐号
     * @param accountToken 必选参数 主帐号TOKEN
     */
    public void setAccount(String accountSid, String accountToken) {
//        if (Strings.isNullOrEmpty(accountSid) || Strings.isNullOrEmpty(accountToken)) {
//            throw new IllegalArgumentException("必选参数:"
//                    + (Strings.isNullOrEmpty(accountSid) ? " 主帐号" : "")
//                    + (Strings.isNullOrEmpty(accountToken) ? " 主帐号TOKEN " : "") + "为空");
//        }
        ACCOUNT_SID = accountSid;
        ACCOUNT_TOKEN = accountToken;
    }

    /**
     * 发送短信模板请求
     *
     * @param to         必选参数 短信接收端手机号码
     * @param templateId 必选参数 模板Id
     * @param datas      可选参数 内容数据，用于替换模板中{序号}
     * @return
     */
    public HashMap<String, Object> sendTemplateSMS(String to, String templateId, String[] datas) throws Exception {
        HashMap<String, Object> validate = accountValidate();
        if (validate != null) {
            return validate;
        }
        String sig = getSig();
        String url = SERVER_IP + ":" + SERVER_PORT + "/2013-12-26/Accounts/" + ACCOUNT_SID + "/SMS/TemplateSMS?sig=" + sig;
        //请求体
        String requsetbody;
        JsonObject json = new JsonObject();
        json.addProperty("appId", App_ID);
        json.addProperty("to", to);
        json.addProperty("templateId", templateId);
        if (datas != null) {
            StringBuilder sb = new StringBuilder("[");
            for (String s : datas) {
                sb.append("\"" + s + "\"" + ",");
            }
            sb.replace(sb.length() - 1, sb.length(), "]");
            JsonParser parser = new JsonParser();
            JsonArray Jarray = parser.parse(sb.toString())
                    .getAsJsonArray();
            json.add("datas", Jarray);
        }
        requsetbody = json.toString();
        String src = ACCOUNT_SID + ":" + TIMESTAMP;
        String authorization = Base64.getEncoder().encodeToString(src.getBytes());
//        Map<String, String> parameterMap = new HashMap<>();
//        parameterMap.put("appId",App_ID);
//        parameterMap.put("to",to);
//        parameterMap.put("templateId",templateId);
//        parameterMap.put("datas", JSON.toJSONString(datas));
//        String s = HttpClientUtils.doHttpsPost(url, authorization, requsetbody);
        String s = HttpUtil.doPostSSL(url, requsetbody, authorization);
        System.out.println("发送短信接口：" + s);
        System.out.println("sendTemplateSMS() 返回结果:" + s);
        return null;
    }


    /**
     * @return
     */
    private String getSig() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        TIMESTAMP = sdf.format(new Date());
        String sig = ACCOUNT_SID + ACCOUNT_TOKEN + TIMESTAMP;
        return md5Digest(sig).toUpperCase();
    }

    public String md5Digest(String src) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(src.getBytes("utf-8"));
        return byte2HexStr(b);
    }

    private String byte2HexStr(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; ++i) {
            String s = Integer.toHexString(b[i] & 0xFF);
            if (s.length() == 1) {
                sb.append("0");
            }

            sb.append(s.toUpperCase());
        }
        return sb.toString();
    }


    /**
     * 获取错误代码
     *
     * @param code
     * @param msg
     * @return
     */
    private HashMap<String, Object> getMyError(String code, String msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("statusCode", code);
        hashMap.put("statusMsg", msg);
        return hashMap;
    }


    private HashMap<String, Object> accountValidate() {
//        if ((Strings.isNullOrEmpty(SERVER_IP))) {
//            return getMyError("172004", "IP为空");
//        }
//        if ((Strings.isNullOrEmpty(SERVER_PORT))) {
//            return getMyError("172005", "端口错误");
//        }
//        if ((Strings.isNullOrEmpty(ACCOUNT_SID))) {
//            return getMyError("172006", "主帐号为空");
//        }
//        if ((Strings.isNullOrEmpty(ACCOUNT_TOKEN))) {
//            return getMyError("172007", "主帐号TOKEN为空");
//        }
//        if ((Strings.isNullOrEmpty(App_ID))) {
//            return getMyError("172012", "应用ID为空");
//        }
        return null;
    }


}
