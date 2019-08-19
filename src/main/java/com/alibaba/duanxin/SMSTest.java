package com.alibaba.duanxin;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.Test;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.alibaba.duanxin
 * @ClassName: SMSTest
 * @author: zhangxiao
 * @Description: ${description}
 */
public class SMSTest {

    @Test
    public void test(){
        DefaultProfile profile = DefaultProfile.getProfile("wuhan", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "wuhan");
        request.putQueryParameter("PhoneNumbers", "15307134431");
        request.putQueryParameter("SignName", "[123]");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
