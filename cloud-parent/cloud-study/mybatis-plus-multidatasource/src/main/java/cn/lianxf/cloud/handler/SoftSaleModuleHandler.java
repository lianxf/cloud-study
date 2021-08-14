package cn.lianxf.cloud.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import cn.lianxf.cloud.entity.oracle.SoftSaleModule;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * @className SoftSaleModuleHandler
 * @description Handler
 * @date 2021/8/11 下午11:37
 * @author little
 * @version 1.0.0
 */
public class SoftSaleModuleHandler extends BaseTypeHandler<List<SoftSaleModule>> {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<SoftSaleModule> softSaleModule, JdbcType jdbcType) throws SQLException {
        try {
            preparedStatement.setString(i, JSONUtil.toJsonStr(softSaleModule));
        } catch (Exception e) {
            preparedStatement.setString(i, null);
        }
    }

    @Override
    public List<SoftSaleModule> getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String data = rs.getString(columnName);
        if (StrUtil.isNotBlank(data)) {
            try {
                return JSONUtil.toList(data, SoftSaleModule.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<SoftSaleModule> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String data = rs.getString(columnIndex);
        if (StrUtil.isNotBlank(data)) {
            try {
                return JSONUtil.toList(data, SoftSaleModule.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<SoftSaleModule> getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String data = cs.getString(columnIndex);
        if (StrUtil.isNotBlank(data)) {
            try {
                return JSONUtil.toList(data, SoftSaleModule.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

}
