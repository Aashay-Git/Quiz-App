package com.example.quiz_app.repository;

import com.example.quiz_app.model.QuizQuestion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class QuizRepository {

    private final JdbcTemplate jdbcTemplate;

    public QuizRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<QuizQuestion> rowMapper = new RowMapper<QuizQuestion>() {
        @Override
        public QuizQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
            QuizQuestion question = new QuizQuestion();
            question.setId(rs.getInt("id"));
            question.setQuestion(rs.getString("question"));
            question.setOptionA(rs.getString("option_a"));
            question.setOptionB(rs.getString("option_b"));
            question.setOptionC(rs.getString("option_c"));
            question.setOptionD(rs.getString("option_d"));
            question.setCorrectOption(rs.getString("correct_option"));
            return question;
        }
    };

    public List<QuizQuestion> findAll() {
        String sql = "SELECT * FROM quiz_question";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void save(QuizQuestion question) {
        String sql = "INSERT INTO quiz_question (question, option_a, option_b, option_c, option_d, correct_option) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, question.getQuestion(), question.getOptionA(), question.getOptionB(),
                question.getOptionC(), question.getOptionD(), question.getCorrectOption());
    }

    public QuizQuestion findById(int id) {
        String sql = "SELECT * FROM quiz_question WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (Exception e) {
            return null;
        }
    }
}
