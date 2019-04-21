package mapper;

import model.News;
import utils.MapperUtil;

import java.sql.ResultSet;

public class NewsMapper implements RowMapper<News> {
    @Override
    public News mapRow(ResultSet rs) {
        return MapperUtil.map(new News(), rs);
    }
}