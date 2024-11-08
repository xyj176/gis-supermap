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
     * 打开shp数据源。
     * 只读，不可写！
     *
     * @param workspace
     * @param shp
     * @return
     */
    public static Datasource openShp(Workspace workspace, String shp) {
        Datasource datasource = openDatasource(workspace, shp, EngineType.VECTORFILE);
        return datasource;
    }

    /**
     * 打开udbx数据源。
     * 可读可写！
     *
     * @param workspace
     * @param udbx
     * @return
     */
    public static Datasource openUdbx(Workspace workspace, String udbx) {
        Datasource datasource = openDatasource(workspace, udbx, EngineType.UDBX);
        return datasource;
    }

    /**
     * 打开gdb数据源。方式等同于打开shp数据。
     * 11.2以后支持直接打开。
     * 只读，不可写
     * @param workspace
     * @param gdb
     * @return
     */
    public static Datasource openGDB(Workspace workspace, String gdb) {
        Datasource datasource = openShp(workspace, gdb);
        return datasource;
    }

    /**
     * 打开mdb数据。方式等同于打开shp数据。
     * 只读，不可写！
     *
     * @param workspace
     * @param mdb
     * @return
     */
    public static Datasource openMDB(Workspace workspace, String mdb) {
        Datasource datasource = openShp(workspace, mdb);
        return datasource;
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

    private static Datasource openDatasource(Workspace workspace, String datasourcePath, EngineType engineType) {
        DatasourceConnectionInfo datasourceConnectionInfo = new DatasourceConnectionInfo();
        datasourceConnectionInfo.setServer(datasourcePath);
        datasourceConnectionInfo.setEngineType(engineType);
        datasourceConnectionInfo.setAlias(UUID.randomUUID().toString());
        Datasource datasource = workspace.getDatasources().open(datasourceConnectionInfo);
        return datasource;
    }
}
