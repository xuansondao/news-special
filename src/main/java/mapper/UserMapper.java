package mapper;

import model.User;
import utils.MapperUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs){
        return MapperUtil.map(new User(), rs);
    }
}
