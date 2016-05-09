package com.dagong.util;

import com.gome.architect.idgnrt.IdGenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 * Created by liuchang on 16/1/17.
 */
@Service
public class IdGenerator {
    private static Random random = new Random(System.currentTimeMillis());
    @Resource
    private IdGenUtil idGenUtil;

    public String generateRandom(String type){
        return type+"_"+ UUID.randomUUID().toString();
    }

    public String generate(String type) {
        return idGenUtil.nextAsStr(type);
    }

    public static String generateValidateCode(int length) {
        if (length != 4 && length != 6) {
            return null;
        }
        int range = 10000;
        if (length == 6) {
            range = 1000000;
        }
        int randomNumber = random.nextInt(range);
        if (randomNumber < range / 10) {
            randomNumber += range / 10;
        }
        return Integer.toString(randomNumber);
    }


}
