package com.example.layered.repository;

import com.example.layered.dto.MemoResponseDto;
import com.example.layered.entrriry.Memo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcTemplateMemoRepository implements  MemoRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public MemoResponseDto saveMemo(Memo memo) {
        return null;
    }

    @Override
    public List<MemoResponseDto> findAllMemos() {
        return List.of();
    }

    @Override
    public Memo findMemoById(Long id) {
        return null;
    }

    @Override
    public void deleteMemo(Long id) {

    }
}
