package com.flower.spit.controller;

import com.flower.common.util.NetworkUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class IPController {
    private static final String[] HEADERS_TO_TRY = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR", "PROXY_FORWARDED_FOR", "X-Real-IP"};




    @RequestMapping("getIP")
    public String getIP(HttpServletRequest request, HttpServletResponse response) throws IOException {


        return NetworkUtil.getIpAddress(request);
//        return getClientIpAddress(request);
    }
    /**
     * getClientIpAddress:(获取用户ip，可穿透代理).
     * @author SongYapeng
     * @Date 2018年3月2日下午4:41:47
     * @param request
     * @since JDK 1.8
     */
    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                if (ip != null && ip.indexOf(",") != -1) {
                    String[] ips = ip.split(",");
                    for (int i = 0; i < ips.length; i++) {
                        String ipMulti = (String) ips[i];
                        if (!("unknown".equalsIgnoreCase(ipMulti))) {
                            ip = ipMulti;
                            break;
                        }
                    }
                }
                return ip;
            }
        }
        return request.getRemoteAddr();
    }
}
