package mapper;

import model.Category;
import utils.MapperUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs){
        return MapperUtil.map(new Category(), rs);
    }
}
