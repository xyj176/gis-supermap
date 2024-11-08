package cn.xuyj.gis.supermap.test;

import cn.xuyj.gis.supermap.function.DataImportTool;
import cn.xuyj.gis.supermap.function.DatasourceTool;
import com.supermap.data.Datasource;
import com.supermap.data.Workspace;
import org.junit.jupiter.api.Test;

/**
 * @author xuyj
 * @since 2024/11/8 17:10
 */
public class DataImportToolTest {
    @Test
    public void testImportShp() {
        String shp = "D:\\data\\shp\\XZQ_CQ.shp";
        String udbx = "D:\\data\\udbx\\DataSource.udbx";
        Workspace workspace = new Workspace();
        Datasource datasource = DatasourceTool.openUdbx(workspace, udbx);
        String importShp = DataImportTool.importShp(shp, datasource, "import");
        System.out.println("shp导入成功");
    }
}
