package cn.xuyj.gis.supermap.test;

import cn.xuyj.gis.supermap.function.DatasourceTool;
import com.supermap.data.Datasource;
import com.supermap.data.Workspace;
import org.junit.jupiter.api.Test;

/**
 * @author xuyj
 * @since 2024/11/8 13:19
 */
public class DatasourceToolTest {
    @Test
    public void testOpenShp() {
        Workspace workspace = new Workspace();
        String shp = "D:\\data\\shp\\XZQ_CQ.shp";
        Datasource datasource = DatasourceTool.openShp(workspace, shp);
        String server = datasource.getConnectionInfo().getServer();
        System.out.println(server);
    }

    @Test
    public void testOpenUdbx() {
        Workspace workspace = new Workspace();
        String udbx = "D:\\data\\udbx\\Datasource.udbx";
        Datasource datasource = DatasourceTool.openUdbx(workspace, udbx);
        String server = datasource.getConnectionInfo().getServer();
        System.out.println(server);
    }

    @Test
    public void testOpenMdb() {
        Workspace workspace = new Workspace();
        String mdb = "D:\\data\\mdb\\DS.mdb";
        Datasource datasource = DatasourceTool.openMDB(workspace, mdb);
        String server = datasource.getConnectionInfo().getServer();
        System.out.println(server);
    }

    @Test
    public void testOpenGdb() {
        Workspace workspace = new Workspace();
        String gdb = "D:\\data\\gdb\\test.gdb";
        Datasource datasource = DatasourceTool.openGDB(workspace, gdb);
        String server = datasource.getConnectionInfo().getServer();
        System.out.println(server);
    }

    @Test
    public void testOpenCAD() {
        Workspace workspace = new Workspace();
//        String cad = "D:\\data\\cad\\STBHHX.dwg";
        String cad = "D:\\data\\cad\\GHFW.dxf";
        Datasource datasource = DatasourceTool.openCAD(workspace, cad);
        String server = datasource.getConnectionInfo().getServer();
        System.out.println(server);
    }

    @Test
    public void testOpenJson() {
        Workspace workspace = new Workspace();
        String json = "D:\\data\\json\\STBHHX.json";
        Datasource datasource = DatasourceTool.openJson(workspace, json);
        String server = datasource.getConnectionInfo().getServer();
        System.out.println(server);
    }
}
