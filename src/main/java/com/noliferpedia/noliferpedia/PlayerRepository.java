package com.noliferpedia.noliferpedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlayerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> findAll() {
        return jdbcTemplate.query(
                "SELECT nickname, name, age, discipline, role, winnings FROM players",
                (rs, rowNum) -> new Player(
                        rs.getString("nickname"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("discipline"),
                        rs.getString("role"),
                        rs.getInt("winnings")
                )
        );
    }
}
