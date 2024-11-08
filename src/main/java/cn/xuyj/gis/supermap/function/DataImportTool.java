package cn.xuyj.gis.supermap.function;

import cn.hutool.core.util.ObjectUtil;
import com.supermap.data.Charset;
import com.supermap.data.Datasource;
import com.supermap.data.conversion.*;

/**
 * @author xuyj
 * @since 2024/11/8 15:39
 */
public class DataImportTool {
    public static String importShp(String shp, Datasource datasource, String targetName) {
        String result = "";
        ImportSettingSHP importSettingSHP = new ImportSettingSHP();
        importSettingSHP.setSourceFilePath(shp);
        importSettingSHP.setSourceFileCharset(Charset.UTF8);
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
}
