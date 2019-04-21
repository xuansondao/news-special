package dao;

import mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    List<T> query(String sql, RowMapper<T> rowMapper, Object...parameters);

    void insertOrUpdate(String sql, Object...parameters);
}
