package cn.xuyj.gis.supermap.test;

import cn.xuyj.gis.supermap.license.License;
import org.junit.jupiter.api.Test;

/**
 * @author xuyj
 * @since 2024/11/8 13:28
 */
public class LicenseTest {
    @Test
    public void testLicense() {
        License license = new License();
        license.setIp("192.168.200.60");
        license.login();
        license.logout();
    }
}
