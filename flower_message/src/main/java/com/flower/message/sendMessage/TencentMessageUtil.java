package com.flower.message.sendMessage;

import com.flower.message.qcloudsms.*;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsVoicePromptSenderResult;
import com.github.qcloudsms.SmsVoiceVerifyCodeSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.SmsStatusPullCallbackResult;
import com.github.qcloudsms.SmsStatusPullReplyResult;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Component
public class TencentMessageUtil {
    // 短信应用SDK AppID
    private static int appid = 1400242689; // 1400开头
    // 短信应用SDK AppKey
    private static String appkey = "26a139ab7d7b3004406f6fd4d9ac0823";
    // 短信模板ID，需要在短信应用中申请
    // NOTE: 这里的模板ID`7839`只是一个示例，
    // 真实的模板ID需要在短信控制台中申请
    private static int templateId = 392971;
    // 签名
    // NOTE: 这里的签名"腾讯云"只是一个示例，
    // 真实的签名需要在短信控制台中申请，另外
    // 签名参数使用的是`签名内容`，而不是`签名ID`
    private static String smsSign = "QIANSHUO";


    public void getParameter() {
        System.out.println(appid);
        System.out.println(appkey);
        System.out.println(templateId);
        System.out.println(smsSign);
    }


    // 单发短信
    public static String sendSingle(String phoneNumber, String msg) {
        // 需要发送短信的手机号码
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86", phoneNumber, msg, "", "");
            System.out.print(result);
            return "ok";
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return "false";
    }

    public static String sendMulti(String[] phoneNumbers, String[] params) {

        // 指定模板ID单发短信
        try {
//            String[] params = {"5678"};
            SmsMultiSender msender = new SmsMultiSender(appid, appkey);
            SmsMultiSenderResult result = msender.sendWithParam("86", phoneNumbers, templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            System.out.print(result);
            return "1";
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return "0";
    }

    // 发送语音验证码
    public static String sendVoiceVerifyCode(String phoneNumber) {
        try {
            SmsVoiceVerifyCodeSender vvcsender = new SmsVoiceVerifyCodeSender(appid, appkey);
            SmsVoiceVerifyCodeSenderResult result = vvcsender.send("86", phoneNumber, "5678", 2, "");
            System.out.print(result);
            return "0";
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return "-1";
    }

    // 发送语音通知
    public static String sendVoicePrompt(String phoneNumber) {
        try {
            SmsVoicePromptSender vpsender = new SmsVoicePromptSender(appid, appkey);
            SmsVoicePromptSenderResult result = vpsender.send("86", phoneNumber, 2, 2, "5678", "");
            System.out.print(result);
            return "0";
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return "-1";
    }

    // 拉取短信回执以及回复
    public static String sendStatusPullCallback(String phoneNumber) {
        try {
            // Note: 短信拉取功能需要联系腾讯云短信技术支持(QQ:3012203387)开通权限
            int maxNum = 10;  // 单次拉取最大量
            SmsStatusPuller spuller = new SmsStatusPuller(appid, appkey);
            // 拉取短信回执
            SmsStatusPullCallbackResult callbackResult = spuller.pullCallback(maxNum);
            System.out.println(callbackResult);
            // 拉取回复
            SmsStatusPullReplyResult replyResult = spuller.pullReply(maxNum);
            System.out.println(replyResult);
            return "0";
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return "-1";
    }


    // 拉取单个手机短信状态
    public static String sendMobileStatus(String phoneNumber) {
        try {
            int beginTime = 1511125600;  // 开始时间(unix timestamp)
            int endTime = 1511841600;    // 结束时间(unix timestamp)
            int maxNum = 10;             // 单次拉取最大量
            SmsMobileStatusPuller mspuller = new SmsMobileStatusPuller(appid , appkey);
            // 拉取短信回执
            SmsStatusPullCallbackResult callbackResult = mspuller.pullCallback("86", phoneNumber, beginTime, endTime, maxNum);
            System.out.println(callbackResult);
            // 拉取回复
            SmsStatusPullReplyResult replyResult = mspuller.pullReply("86", phoneNumber, beginTime, endTime, maxNum);
            System.out.println(replyResult);
            return "0";
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return "-1";
    }


    public int getAppid() {
        return appid;
    }

    @Value("${tencent.sms.appid}")
    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getAppkey() {
        return appkey;
    }

    @Value("${tencent.sms.appkey}")
    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public int getTemplateId() {
        return templateId;
    }

    @Value("${tencent.sms.templateId}")
    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public String getSmsSign() {
        return smsSign;
    }

    @Value("${tencent.sms.smsSign}")
    public void setSmsSign(String smsSign) {
        this.smsSign = smsSign;
    }

    public TencentMessageUtil() {
    }

}
