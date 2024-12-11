package a05tcpdemo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

//客户端向服务器请求数据
public class Client {
        //客户端和服务端的连接依靠socket对象,然后建立连接后，在连接里用输入输出流进行数据传输
    public static void main(String[] args) throws IOException {

        //首先创建socket对象，建立与服务端的连接
        Socket socket=new Socket("127.0.0.1",9999);   //这里的端口要和服务端的端口保持一致


        //获取客户端输出流对象。向服务端发起数据请求
        //细节:这里只能使用字节流,因为数据在网络上的传递就是1个字节字节的，不能用字符流
        OutputStream outputStream = socket.getOutputStream();

        //使用输出流，输出对象
        outputStream.write("你好你好aaa!".getBytes());

        //释放资源
        //这个输入流是从socket获取的可以关闭也可以不关闭，他会随着socket关闭而关闭
        outputStream.close();
        socket.close();

    }
}
