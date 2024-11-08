package cn.xuyj.gis.supermap.license;

import lombok.Data;
import com.supermap.data.bslicense.BSLicense;

/**
 * @author xuyj
 * @since 2024/11/8 10:22
 */
@Data
public class License {
    /**
     * 在线许可服务器地址
     */
    private String ip;

    /**
     * 服务器端口号
     * 默认端口号：9183
     */
    private int port = 9183;

    /**
     * 许可模块
     * 默认是单模块：65400
     */
    private int[] modules = new int[]{65400};

    /**
     * 登录在线许可
     */
    public void login() {
        System.out.println("在线许可验证");
        System.out.println("许可ip:" + ip);
        System.out.println("许可port:" + port);
        System.out.print("许可modules:");
        for (int i = 0; i < modules.length; i++) {
            System.out.println(modules[i]);
        }
        try {
            boolean login = BSLicense.login(ip, port, modules);
            if (login)
                System.out.println("验证成功！");
            else
                System.out.printf("验证失败");
        } catch (Exception e) {
            System.out.println("在线许可验证失败！！！");
            e.printStackTrace();
        }
    }

    /**
     * 登出在线许可
     */
    public void logout() {
        System.out.println("登出在线许可");
        BSLicense.logout();
    }
}
