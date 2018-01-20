package com.database.jdbc.sqlserver;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.List;

/**
 * mybatis的类型处理器，用于java特殊类型（List<ZTableModel>）与SQLServer特殊类型（表值参数z_type）之间的转换
 */
public class ZTypeTypeHandler extends BaseTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if (parameter != null) {
            final SQLServerDataTable sourceDataTable = new SQLServerDataTable();
            sourceDataTable.addColumnMetadata("id" , Types.INTEGER);
            sourceDataTable.addColumnMetadata("name" , Types.VARCHAR);
            List<ZTableModel> dataList = (List<ZTableModel>)parameter;
            for (ZTableModel z : dataList) {
                sourceDataTable.addRow(z.getId(), z.getName());
            }
            ps.setObject(i, sourceDataTable);

            // jdk动态代理，实际类的类名是$Porxy134，动态代理处理类是org.apache.ibatis.logging.jdbc.PreparedStatementLogger
//            SQLServerCallableStatement pStmt = (SQLServerCallableStatement)ps;
//            pStmt.setStructured(1, "dbo.z_type", sourceDataTable);
        }
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
