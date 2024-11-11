package cn.xuyj.gis.supermap.function;

import cn.hutool.core.util.ObjectUtil;
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
     * @param targetName：导入后的图层名
     * @return：成功导入的图层名
     */
    public static String importShp(String shp, Datasource datasource, String targetName) {
        String result = "";
        ImportSettingSHP importSettingSHP = new ImportSettingSHP();
        importSettingSHP.setSourceFilePath(shp);
        importSettingSHP.setSourceFileCharset(Charset.UTF8);
        //setTargetDatasource() 与 setTargetDatasourceConnectionInfo() 两个方法相互冲突，
        //即对其中一个方法进行设置后，之前另一方法的设置值将被修改为 null
        //setTargetDatasourceConnectionInfo()有一个优点：如果没有对应的数据源，则根据连接信息新建
        importSettingSHP.setTargetDatasource(datasource);
        importSettingSHP.setTargetDatasetName(targetName);
        importSettingSHP.setImportMode(ImportMode.NONE);
        DataImport dataImport = new DataImport();
        dataImport.getImportSettings().add(importSettingSHP);
        ImportResult run = dataImport.run();
        if (ObjectUtil.isNotEmpty(run.getSucceedSettings()))
            result = run.getSucceedDatasetNames(run.getSucceedSettings()[0])[0];
        else
            System.out.println("导入shp数据失败！");
        dataImport.dispose();
        importSettingSHP.dispose();
        return result;
    }

    /**
     * 导入geojson文件
     * @param geoJson：geojson文件路径
     * @param datasource：数据源，udbx或空间库数据源
     * @param targetName：导入后的图层名
     * @return：成功导入的图层名
     */
    public static String importGeoJson(String geoJson, Datasource datasource, String targetName) {
        String result = "";
        ImportSettingGeoJson importSetting = new ImportSettingGeoJson();
        importSetting.setSourceFilePath(geoJson);
        importSetting.setSourceFileCharset(Charset.UTF8);
        importSetting.setTargetDatasetName(targetName);
        importSetting.setImportMode(ImportMode.NONE);
        //setTargetDatasource() 与 setTargetDatasourceConnectionInfo() 两个方法相互冲突，
        //即对其中一个方法进行设置后，之前另一方法的设置值将被修改为 null
        //setTargetDatasourceConnectionInfo()有一个优点：如果没有对应的数据源，则根据连接信息新建
        importSetting.setTargetDatasource(datasource);
        DataImport dataImport = new DataImport();
        dataImport.getImportSettings().add(importSetting);
        ImportResult run = dataImport.run();
        if (ObjectUtil.isNotEmpty(run.getSucceedSettings()))
            result = run.getSucceedDatasetNames(run.getSucceedSettings()[0])[0];
        else
            System.out.println("导入geoJson数据失败！");
        dataImport.dispose();
        importSetting.dispose();
        return result;
    }
}
