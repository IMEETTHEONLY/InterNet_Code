package a06tcptest.Test03;

import java.io.*;
import java.net.Socket;

public class Client {
    //客户端将本地文件上传到服务器当中

    public static void main(String[] args) throws IOException {
        //连接远端服务器
        Socket socket = new Socket("127.0.0.1", 9999);

        //读取本地文件
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("D:\\java_code\\InterNet_Code\\clientdir\\img.png"));
        //获取客户端和服务器的通道
        //只能使用字节流，因为通道只能传输字节数据
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
        //循环读取,然后边读边写
        byte[] bytes = new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){
            //bytes数组读取满了就向服务器传输数据
           bos.write(bytes);
        }
        //由于缓冲流的特点是要数组满了才会一次性写入，所以说这里如果说不刷新的话，他可能没有读取到数组长度，他就没写完，所以说你可以选择刷新或者是关闭流
        bos.flush();//*******

        //写完了就关闭自己输入流
        bis.close();

        //这里还要写出一个结束标志通知服务端，否则服务端会死等
        socket.shutdownOutput();


        //接收来自于服务端的回复消息
        //用转换流将从通道获取的数据打印出来
        InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        int b;
        while ((b=isr.read())!=-1){
            System.out.println((char) b);
        }

        //关闭通道
        socket.close();



    }

}
