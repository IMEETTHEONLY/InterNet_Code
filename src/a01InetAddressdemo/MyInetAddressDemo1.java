package a01InetAddressdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddressDemo1 {
    /*
    *   static InetAddress getByName(String host)   确定主机名称的IP地址。可以是机器名字也可以是IP地址
    *   String getHostName()  //获取次IP地址的主机名
    *   String getHostAddress()  //返回文本显示的IP地址字符串
    *
    *
    * */

    public static void main(String[] args) throws UnknownHostException {
        //获取到IP对象，即主机对象
        InetAddress address = InetAddress.getByName("172.21.144.255");

        //获取主机名
        System.out.println(address.getHostName());


        //获取主机ip
        System.out.println(address.getHostAddress());

    }
}
