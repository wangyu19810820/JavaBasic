package com.database.jdbc.sqlserver;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 表值对象“数据源”
 */
public class ZTypeRecord implements ISQLServerDataRecord {

    private List<ZTableModel> data;
    private int index;

    public ZTypeRecord(List<ZTableModel> list) {
        data = new ArrayList<>(list);
        index = -1;
    }

    @Override
    public SQLServerMetaData getColumnMetaData(int columnIndex) {
        if (1 == columnIndex)
            return new SQLServerMetaData("id", java.sql.Types.INTEGER);
        else
            return new SQLServerMetaData("name", java.sql.Types.VARCHAR);
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object[] getRowData() {
        ZTableModel oneRowData = data.get(index);
        return new Object[]{oneRowData.getId(), oneRowData.getName()};
    }

    @Override
    public boolean next() {
        index++;
        return index < data.size();
    }
}
