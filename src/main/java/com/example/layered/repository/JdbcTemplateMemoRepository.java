package com.example.layered.repository;

import com.example.layered.dto.MemoResponseDto;
import com.example.layered.entrriry.Memo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateMemoRepository implements  MemoRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public MemoResponseDto saveMemo(Memo memo) {
        // INSERT Query 직접 작성하지 않아도 된다.

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("memo").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", memo.getTitle());
        parameters.put("contents", memo.getContents());

        // 저장 후 생성된 key값 Number 타입으로 반환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new MemoResponseDto(key.longValue(), memo.getTitle(), memo.getContents());
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
