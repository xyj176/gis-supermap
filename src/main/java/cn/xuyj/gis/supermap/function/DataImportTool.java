package cn.xuyj.gis.supermap.function;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.supermap.data.Charset;
import com.supermap.data.Datasource;
import com.supermap.data.conversion.*;

/**
 * @author xuyj
 * @des 数据导入工具类
 * @since 2024/11/8 15:39
 */
public class DataImportTool {

    /**
     * 导入shp
     *
     * @param shp：shp文件路径
     * @param datasource：数据源，udbx或空间库数据源
     * @return：成功导入的图层名
     */
    public static String importShp(String shp, Datasource datasource) {
        String result = importShp(shp, datasource, "");
        return result;
    }

    /**
     * 导入shp
     *
     * @param shp：shp文件路径
     * @param datasource：数据源，udbx或空间库数据源
     * @param targetName：导入后的图层名，为空则默认采用原名称
     * @return：成功导入的图层名
     */
    public static String importShp(String shp, Datasource datasource, String targetName) {
        String result = "";
        ImportSettingSHP importSetting = new ImportSettingSHP();
        importSetting.setSourceFilePath(shp);
        importSetting.setSourceFileCharset(Charset.UTF8);
        //setTargetDatasource() 与 setTargetDatasourceConnectionInfo() 两个方法相互冲突，
        //即对其中一个方法进行设置后，之前另一方法的设置值将被修改为 null
        //setTargetDatasourceConnectionInfo()有一个优点：如果没有对应的数据源，则根据连接信息新建
        importSetting.setTargetDatasource(datasource);
        if (StrUtil.isNotEmpty(targetName))
            importSetting.setTargetDatasetName(targetName);
        importSetting.setImportMode(ImportMode.NONE);
        ImportResult run = runImport(importSetting);
        if (ObjectUtil.isNotEmpty(run.getSucceedSettings()))
            result = run.getSucceedDatasetNames(run.getSucceedSettings()[0])[0];
        else
            System.out.println("导入shp数据失败！");
        importSetting.dispose();
        return result;
    }

    /**
     * 导入geojson文件
     *
     * @param geoJson：geojson文件路径
     * @param datasource：数据源，udbx或空间库数据源
     * @param targetName：导入后的图层名，为空则默认采用原名称
     * @return：成功导入的图层名
     */
    public static String importGeoJson(String geoJson, Datasource datasource, String targetName) {
        String result = "";
        ImportSettingGeoJson importSetting = new ImportSettingGeoJson();
        importSetting.setSourceFilePath(geoJson);
        importSetting.setSourceFileCharset(Charset.UTF8);
        if (StrUtil.isNotEmpty(targetName))
            importSetting.setTargetDatasetName(targetName);
        importSetting.setImportMode(ImportMode.NONE);
        //setTargetDatasource() 与 setTargetDatasourceConnectionInfo() 两个方法相互冲突，
        //即对其中一个方法进行设置后，之前另一方法的设置值将被修改为 null
        //setTargetDatasourceConnectionInfo()有一个优点：如果没有对应的数据源，则根据连接信息新建
        importSetting.setTargetDatasource(datasource);
        ImportResult run = runImport(importSetting);
        if (ObjectUtil.isNotEmpty(run.getSucceedSettings()))
            result = run.getSucceedDatasetNames(run.getSucceedSettings()[0])[0];
        else
            System.out.println("导入geoJson数据失败！");
        importSetting.dispose();
        return result;
    }

    /**
     * 导入DWG
     *
     * @param dwg：dwg文件路径
     * @param datasource：数据源，udbx或空间库数据源
     * @param targetName：导入后的图层名，为空则默认采用原名称
     * @return：成功导入的图层名
     */
    public static String importDWG(String dwg, Datasource datasource, String targetName) {
        String result = "";
        ImportSettingDWG importSetting = new ImportSettingDWG();
        importSetting.setSourceFilePath(dwg);
        importSetting.setSourceFileCharset(Charset.UTF8);
        importSetting.setTargetDatasource(datasource);
        if (StrUtil.isNotEmpty(targetName))
            importSetting.setTargetDatasetName(targetName);
        importSetting.setImportMode(ImportMode.NONE);
        //默认为 true，即导入为 CAD 数据集, 否则为数据对应类型的简单矢量数据集
        //简单矢量数据集包含一个线图层和一个面图层
        importSetting.setImportingAsCAD(true);
        ImportResult run = runImport(importSetting);
        if (ObjectUtil.isNotEmpty(run.getSucceedSettings()))
            result = run.getSucceedDatasetNames(run.getSucceedSettings()[0])[0];
        else
            System.out.println("导入DWG数据失败！");
        importSetting.dispose();
        return result;
    }

    /**
     * 导入DXF
     *
     * @param dxf：dxf文件路径
     * @param datasource：数据源，udbx或空间库数据源
     * @param targetName：导入后的图层名，为空则默认采用原名称
     * @return：成功导入的图层名
     */
    public static String importDXF(String dxf, Datasource datasource, String targetName) {
        String result = "";
        ImportSettingDXF importSetting = new ImportSettingDXF();
        importSetting.setSourceFilePath(dxf);
        importSetting.setSourceFileCharset(Charset.UTF8);
        importSetting.setTargetDatasource(datasource);
        if (StrUtil.isNotEmpty(targetName))
            importSetting.setTargetDatasetName(targetName);
        importSetting.setImportMode(ImportMode.NONE);
        //默认为 true，即导入为 CAD 数据集, 否则为数据对应类型的简单矢量数据集
        //简单矢量数据集包含一个线图层和一个面图层
        importSetting.setImportingAsCAD(true);
        ImportResult run = runImport(importSetting);
        if (ObjectUtil.isNotEmpty(run.getSucceedSettings()))
            result = run.getSucceedDatasetNames(run.getSucceedSettings()[0])[0];
        else
            System.out.println("导入DWG数据失败！");
        importSetting.dispose();
        return result;
    }

    private static ImportResult runImport(ImportSetting importSetting) {
        DataImport dataImport = new DataImport();
        dataImport.getImportSettings().add(importSetting);
        ImportResult run = dataImport.run();
        dataImport.dispose();
        return run;
    }
}
