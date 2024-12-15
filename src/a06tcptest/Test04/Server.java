package a06tcptest.Test04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
//获取UUID，作为文件名,这样下载的文件名就不会重复了
public class Server {
    //服务器接收客户端的文件，保存到本地文件,并且回写数据

    public static void main(String[] args) throws IOException {
        //创建服务器socket对象
        ServerSocket ss=new ServerSocket(9999);

        //与客户端建立通道
        Socket socket = ss.accept();

        //接收来自客户端的文件
        //接收图片的化就只有字节
        BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
        //获取UUID，作为文件名,这样下载的文件名就不会重复了
        String name = UUID.randomUUID().toString().replace("-","");
        //与本地文件建立连接
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("D:\\java_code\\InterNet_Code\\serverdir\\"+name+".png"));

        //边读边写
        byte[] bytes=new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){
            //向文件当中写入
            bos.write(bytes);
        }

        //这里要关闭文件流   这里关闭了流相当于就刷新了缓冲数组了，那么数据就都写进文件了
        bos.close();


        //向客户端发送文件已接受的信号
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("上传文件成功".getBytes());

        //释放资源
        ss.close();
        socket.close();


    }
}
