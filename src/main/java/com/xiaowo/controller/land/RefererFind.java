package com.xiaowo.controller.land;

import javax.servlet.http.HttpServletRequest;

/**
 * @author answer
 *         2017/12/4
 *         分析来源链接
 */
public class RefererFind {

    public static String findReferer(HttpServletRequest request) {
        String retUrl = request.getHeader("Referer");
        if (retUrl != null) {
            return retUrl;
        }

        return null;
    }
}
