package a05tcpdemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//服务端，响应客户端需要的数据
public class Server {

    public static void main(String[] args) throws IOException {
        //TCP对象接收数据

        //新建socket对象，来与客户端建立连接
        ServerSocket ss=new ServerSocket(9999);

        //监听来自于客户端的数据，若没有就卡死在这里一直等
        Socket accept = ss.accept();   //接收到了就建立socket对象

        //如果说传递了数据，就使用输入流对象将数据接收
        //这里要用转换流，字节流去接收数据，但是在读取为中文的使用要用字符流这样才能读取中文
        BufferedReader br=new BufferedReader(new InputStreamReader(accept.getInputStream()));

        //循环接收数据
        int b;
        while ((b=br.read())!=-1){
            System.out.println((char) b);
        }

        //释放资源
        br.close();
        accept.close();
        ss.close();
    }
}
