package com.xiaowo.service.impl;

import com.utils.JsonUtils;
import com.utils.OkhttpUtil;
import com.xiaowo.ApplyLog;
import com.xiaowo.dao.ApplyDao;
import com.xiaowo.service.ApplyService;
import com.xiaowo.utils.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;


/**
 * @author answer
 *         2017/11/27
 */
@Service
public class ApplyServiceImpl implements ApplyService {
    @Resource
    private ApplyDao applyDao;

    private final static Logger log = LoggerFactory.getLogger(ApplyServiceImpl.class);

    /**
     * 申请入口
     *
     * @param username
     * @param tel
     * @param city
     * @param channel  渠道
     * @param resource 申请页面来源
     * @return
     */
    @Override
    public synchronized String apply(String username, String tel, String city, String channel, String resource, String source) {
        Properties properties = new Properties(null);
        try {
            properties.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getValue("marketingInputUrl");
        url = url + "?name=" + username + "&tel=" + tel + "&cityName=" + city + "&channel=" + channel;
        String json;
        try {
            json = OkhttpUtil.getRequest(url);
            if (json != null) {
                Map map = JsonUtils.mapFormJSONStr(json);
                String order = String.valueOf(map.get("code"));
                if ("1".equals(order)) {
                    //业务系统添加失败
                    return "业务系统添加失败";
                } else if ("2".equals(order)) {
                    //该手机号已使用
                    return "该手机号已使用";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "系统错误";
        }

        //保存申请日志
        ApplyLog applyLog = new ApplyLog();
        applyLog.setChannel(source + "-" + city);
        applyLog.setTel(tel);
        applyLog.setResource(resource);
        applyLog.setUsername(username);
        applyDao.saveApplyLog(applyLog);

        //查询当前页面是否已经统计过
        Integer count = applyDao.findCountByResource(resource);
        if (count != null) {
            count = count + 1;
            applyDao.updateCount(count, resource);
        } else {
            applyDao.saveCount(resource);
        }

        return "申请成功";
    }

    @Override
    public Integer findVisitorCountByResource(String resource) {
        return applyDao.findVisitorCountByResource(resource);
    }

    @Override
    public void updateVisitorCount(Integer visitorCount, String resource) {
        applyDao.updateVisitorCount(visitorCount, resource);
    }

    @Override
    public void saveVisitorCount(String resource) {
        applyDao.saveVisitorCount(resource);
    }
}
