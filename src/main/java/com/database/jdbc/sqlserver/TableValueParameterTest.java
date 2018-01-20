package com.database.jdbc.sqlserver;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

// 演示了jdbc如何使用表值参数
// 可以用于普通sql语句，也能用于存储过程
// 表值参数来源可有3种类型：SQLServerDataTable，ResultSet，ISQLServerDataRecord
// 调用存储过程，可以jdbc通用api：setObject。调用普通sql语句，只能用SQLServer专有api：setStructured
public class TableValueParameterTest {

    public static void main(String[] args) throws Exception {
        TableValueParameterTest test = new TableValueParameterTest();
        test.test2();
    }

    // 调用sql语句，传递SQLServerDataTable
    public void test1() throws Exception {
        Connection connection = getJDBCConnection();

        SQLServerDataTable sourceDataTable = new SQLServerDataTable();
        sourceDataTable.addColumnMetadata("id" , Types.INTEGER);
        sourceDataTable.addColumnMetadata("name" , Types.VARCHAR);
        sourceDataTable.addRow(1, "a");
        sourceDataTable.addRow(2, "b");

        SQLServerPreparedStatement pStmt =
                (SQLServerPreparedStatement) connection.prepareStatement("INSERT INTO dbo.z_table SELECT * FROM ?");
        pStmt.setStructured(1, "dbo.z_type", sourceDataTable);
        pStmt.execute();
    }

    // 调用存储过程，传递SQLServerDataTable
    public void test2() throws Exception {
        Connection connection = getJDBCConnection();

        SQLServerDataTable sourceDataTable = new SQLServerDataTable();
        sourceDataTable.addColumnMetadata("id" , Types.INTEGER);
        sourceDataTable.addColumnMetadata("name" , Types.VARCHAR);
        sourceDataTable.addRow(1, "a");
        sourceDataTable.addRow(2, "b");

        SQLServerCallableStatement pStmt =
                (SQLServerCallableStatement) connection.prepareCall("exec z_proc ?");
        pStmt.setObject(1, sourceDataTable);
        pStmt.execute();
    }

    // 调用存储过程，传递ResultSet
    public void test3() throws Exception {
        Connection connection = getJDBCConnection();

        ResultSet rs = connection.createStatement().executeQuery("SELECT has_all_area, c_user_name FROM sys_user WHERE has_all_area is not NULL");

        SQLServerCallableStatement pStmt =
                (SQLServerCallableStatement) connection.prepareCall("exec z_proc ?");
        pStmt.setObject(1, rs);
        pStmt.execute();
    }

    // 调用sql语句，传递ISQLServerDataRecord
    public void test4() throws Exception {
        Connection connection = getJDBCConnection();

        List<ZTableModel> list = new ArrayList<>();
        list.add(new ZTableModel(1, "a"));
        list.add(new ZTableModel(2, "b"));
        ISQLServerDataRecord zTypeRecord = new ZTypeRecord(list);

        SQLServerPreparedStatement pStmt =
                (SQLServerPreparedStatement) connection.prepareStatement("INSERT INTO dbo.z_table SELECT * FROM ?");
        pStmt.setStructured(1, "dbo.z_type", zTypeRecord);
        pStmt.execute();
    }

    private Connection getJDBCConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:sqlserver://192.168.1.2:1433;DatabaseName=ylzc_gsk_1025",
                "ylzcgskdev", "%RDX3efv");
        return connection;
    }

}
