package a06tcptest.Test05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
//使用多线程来接收文件
public class Server {
    //使用多线程去循环接收来自客户端的文件


    public static void main(String[] args) throws IOException {
        //创建服务器socket对象
        ServerSocket ss=new ServerSocket(9999);


        while (true){

            //与客户端建立通道
            Socket socket = ss.accept();

            //开启多个线程去执行
            new Thread(new MyRunable(socket)).start();
        }


    }
}
