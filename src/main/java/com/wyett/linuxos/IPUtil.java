package com.wyett.linuxos;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * @author : wyettLei
 * @date : Created in 2021/12/13 9:58
 * @description: get ip
 */

public class IPUtil {

    public static final String LOCALHOST = "127.0.0.1";
    public static final String ANYHOST = "0.0.0.0";
    private static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");
    private static InetAddress LOCAL_ADDRESS;

    public String getLocalhostIp() {
        try {
            return getLocalAddress().getHostAddress();
        } catch (Exception e) {


        }
        return LOCALHOST;
    }

    /**
     * 获取本地IPv4地址
     *
     * @return
     */
    public static InetAddress getLocalAddress() {
        if (LOCAL_ADDRESS != null)
            return LOCAL_ADDRESS;
        InetAddress localAddress = getLocalAddress0();
        LOCAL_ADDRESS = localAddress;
        return localAddress;
    }

    /**
     * 获取本机IP
     *
     * @return 本机IP地址信息
     * @throws SocketException
     */
    private static InetAddress getLocalAddress0() {
        InetAddress localAddress = null;
        String methodName = "IPUtil.getLocalAddress0";
        try {
            localAddress = InetAddress.getLocalHost();
            if (isValidAddress(localAddress)) {
                return localAddress;
            }
        } catch (Exception e) {
            //LOGGER.errorLog(ModuleEnum.UTIL, methodName, "", "", e);
        }
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces != null) {
                while (interfaces.hasMoreElements()) {
                    try {
                        NetworkInterface network = interfaces.nextElement();
                        Enumeration<InetAddress> addresses = network.getInetAddresses();
                        if (addresses != null) {
                            while (addresses.hasMoreElements()) {
                                try {
                                    InetAddress address = addresses.nextElement();
                                    if (isValidAddress(address)) {
                                        return address;
                                    }
                                } catch (Exception e) {

                                    //LOGGER.errorLog(ModuleEnum.UTIL, methodName, "", "", e);
                                }
                            }
                        }
                    } catch (Exception e) {
                        //LOGGER.errorLog(ModuleEnum.UTIL, methodName, "", "", e);
                    }
                }
            }
        } catch (Exception e) {
            //LOGGER.errorLog(ModuleEnum.UTIL, methodName, "", "", e);
        }
        return localAddress;
    }


    private static boolean isValidAddress(InetAddress address) {
        if (address == null || address.isLoopbackAddress())
            return false;
        String name = address.getHostAddress();
        return (name != null
                && !ANYHOST.equals(name)
                && !LOCALHOST.equals(name)
                && IP_PATTERN.matcher(name).matches());
    }


}
