package com.wyett.linuxos;

import java.util.UUID;

/**
 * @author : wyettLei
 * @date : Created in 2021/12/13 10:33
 * @description: TODO
 */

public class UUIDUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString();
    }

    public static String getUuidWithout_() {
        return getUuid().replace("-", "");
    }
}
