package a06tcptest.Test04;

import java.util.UUID;

public class UUIDTest {
    //测试获取UUID
    public static void main(String[] args) {
        //获取替换为""的格式
        String str = UUID.randomUUID().toString().replace("-","");
        System.out.println(str);
    }

}
