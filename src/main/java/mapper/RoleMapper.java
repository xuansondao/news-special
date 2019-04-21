package mapper;

import model.Role;
import utils.MapperUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs)  {
        return MapperUtil.map(new Role(), rs);
    }
}
