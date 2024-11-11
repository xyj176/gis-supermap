package cn.xuyj.gis.supermap.test;

import cn.xuyj.gis.supermap.function.DataImportTool;
import cn.xuyj.gis.supermap.function.DatasourceTool;
import com.supermap.data.Datasource;
import com.supermap.data.Workspace;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author xuyj
 * @since 2024/11/8 17:10
 */
public class DataImportToolTest {
    @Test
    public void testImportShp() {
        String shp = "D:\\data\\shp\\empty.shp";
        String udbx = "D:\\data\\udbx\\DataSource.udbx";
        Workspace workspace = new Workspace();
        Datasource datasource = DatasourceTool.openUdbx(workspace, udbx);
        String importShp = DataImportTool.importShp(shp, datasource, "");
        System.out.println("成功导入【" + importShp + "】");
        System.out.println("shp导入成功");
    }

    @Test
    public void testImportGeoJson() {
        String json = "D:\\data\\json\\STBHHX.json";
        String udbx = "D:\\data\\udbx\\DataSource.udbx";
        Workspace workspace = new Workspace();
        Datasource datasource = DatasourceTool.openUdbx(workspace, udbx);
        String importGeojson = DataImportTool.importGeoJson(json, datasource, "");
        System.out.println("成功导入【" + importGeojson + "】");
        System.out.println("geoJson导入成功");
    }

    @Test
    public void testImportDWG() {
        String dwg = "D:\\data\\cad\\STBHHX.dwg";
        String udbx = "D:\\data\\udbx\\DataSource.udbx";
        Workspace workspace = new Workspace();
        Datasource datasource = DatasourceTool.openUdbx(workspace, udbx);
        String importDwg = DataImportTool.importDWG(dwg, datasource, null);
        System.out.println("成功导入【" + importDwg + "】");
        System.out.println("dwg导入成功");
    }

    @Test
    public void testImportDXF() {
        String dxf = "D:\\data\\cad\\GHFW.dxf";
        String udbx = "D:\\data\\udbx\\DataSource.udbx";
        Workspace workspace = new Workspace();
        Datasource datasource = DatasourceTool.openUdbx(workspace, udbx);
        String importDxf = DataImportTool.importDXF(dxf, datasource, "import_dxf");
        System.out.println("成功导入【" + importDxf + "】");
        System.out.println("dxf导入成功");
    }

    @Test
    public void testImportMDB() {
        String mdb = "D:\\data\\mdb\\DS.mdb";
        String udbx = "D:\\data\\udbx\\DataSource.udbx";
        Workspace workspace = new Workspace();
        Datasource datasource = DatasourceTool.openUdbx(workspace, udbx);
        List<String> importDxf = DataImportTool.importMDB(mdb, datasource);
        System.out.println("成功导入【" + importDxf.toString() + "】");
        System.out.println("mdb导入成功");
    }
}
