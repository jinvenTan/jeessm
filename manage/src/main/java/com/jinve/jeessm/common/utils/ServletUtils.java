package com.jinve.jeessm.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinven
 * @create 2017-12-15 14:26
 **/
public class ServletUtils {
    /**
     * 是否是Ajax异步请求
     * @param request
     */
    public static boolean isAjaxRequest(HttpServletRequest request){

        String accept = request.getHeader("accept");
        String xRequestedWith = request.getHeader("X-Requested-With");

        // 如果是异步请求，则直接返回信息
        return ((accept != null && accept.indexOf("application/json") != -1
                || (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1)
                ));
    }
}
