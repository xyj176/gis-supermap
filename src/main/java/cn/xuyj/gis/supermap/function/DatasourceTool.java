package cn.xuyj.gis.supermap.function;

import com.supermap.data.Datasource;
import com.supermap.data.DatasourceConnectionInfo;
import com.supermap.data.EngineType;
import com.supermap.data.Workspace;

import java.util.UUID;

/**
 * @author xuyj
 * @since 2024/11/8 11:13
 */
public class DatasourceTool {

    /**
     * 打开shp数据源
     *
     * @param workspace
     * @param shp
     * @return
     */
    public static Datasource openShp(Workspace workspace, String shp) {
        DatasourceConnectionInfo datasourceConnectionInfo = new DatasourceConnectionInfo();
        datasourceConnectionInfo.setServer(shp);
        datasourceConnectionInfo.setEngineType(EngineType.VECTORFILE);
        datasourceConnectionInfo.setAlias(UUID.randomUUID().toString());
        Datasource datasource = workspace.getDatasources().open(datasourceConnectionInfo);
        return datasource;
    }

    public static Datasource openUdbx(Workspace workspace, String udbx) {
        return null;
    }

    public static Datasource openGDB(Workspace workspace, String gdb) {
        return null;
    }

    public static Datasource openMDB(Workspace workspace, String mdb) {
        return null;
    }

    public static Datasource openCAD(Workspace workspace, String cad) {
        return null;
    }

    public static Datasource openJson(Workspace workspace, String json) {
        return null;
    }

    public static Datasource openDatabase(Workspace workspace, String server, String database, String user, String pass, EngineType type) {
        return null;
    }
}
