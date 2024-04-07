package com.example.track3.repository;


import com.example.track3.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RepositoryImpl implements Repository {
    private JdbcTemplate jdbcTemplate;

    public RepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save(User student) {
        String sql = "INSERT INTO students(name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge());
    }

    @Override
    public void update(User student) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
