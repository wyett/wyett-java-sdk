package com.wyett.linuxos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author : wyettLei
 * @date : Created in 2021/12/13 11:20
 * @description: TODO
 */

public class LocalCmd {

    public LocalCmd() {
    }

    public static String execCmd(String cmd) throws IOException {

        String result = null;
        Process process = Runtime.getRuntime().exec(cmd);

        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while (inputStream.read() != -1) {
            result = bufferedReader.readLine();
        }
        bufferedReader.close();
        inputStream.close();
        process.destroy();

        return result;
    }
}
