package com.dagong.util;

import com.dagong.job.vo.JobVO;
import com.dagong.pojo.Job;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by liuchang on 16/5/8.
 */
public class BeanUtil {
    public static <T> T getVO(Object source,Class<T> clazz) {
        if (source == null) {
            return null;
        }
        try {

            T target = clazz.newInstance();
            BeanUtils.copyProperties(target, source);
            return target;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T getVO(Map map,Class<T> clazz) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            T target = clazz.newInstance();
            BeanUtils.populate(target, map);
            return target;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
