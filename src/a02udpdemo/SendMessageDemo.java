package a02udpdemo;

import java.io.IOException;
import java.net.*;

public class SendMessageDemo {
    //发送数据
    /*
    *   流程:1.找快递公司  2.打包快递  3.发送快递  4.付钱走人
    *
    *   udp面向不安全无连接的，所以说这个代码执行后是没有任何数据返回的，要查看是否成功要找到一些网络工具
    *
    *
    * */
    public static void main(String[] args) throws IOException {
        //1.找发送数据的对象
        //细节:可以指定端口，也可以默认端口，默认端口就表示找一个空闲端口即可
        DatagramSocket ds=new DatagramSocket();

        //2.打包数据

        //要发送的数据
        String str="你好你好";
        byte[] bytes = str.getBytes();
        //指定ip对象，这里是给自己发
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        //这里是发到10086这个端口
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length,byName,10086);

        //发送数据
        ds.send(dp);

        //释放资源
        ds.close();


    }
}
