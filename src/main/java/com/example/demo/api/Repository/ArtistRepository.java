package com.example.demo.api.Repository;


import com.example.demo.api.model.ArtistDto;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ArtistRepository {
    private final DataSource dataSource;
    public ArtistRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<ArtistDto> findAll() throws SQLException {
        String sql = "SELECT id, name, age, artwork_id";
        List<ArtistDto> list = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date d = rs.getDate("artist_date");
                list.add(new ArtistDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getLong("artwork_id")
                ));
            }
        }
        return list;
    }
    public void save(ArtistDto a) throws SQLException{
        String sql = "INSERT INTO artist(id, name, age, artwork_id) VALUES (?, ?, ?, ?)";
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, a.getId());
            ps.setString(2, a.getName());
            ps.setInt(3, a.getAge());
            ps.setLong(4, a.getArtwork_id());
            ps.executeUpdate();
        }
    }
    public int updateById(Long id, ArtistDto a) throws SQLException{
        String sql = "UPDATE artist SET name = ?, age = ?, artwork_id = ? WHERE id = ?";
        try (Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, a.getName());
            ps.setInt(2, a.getAge());
            ps.setLong(3, a.getArtwork_id());
            return ps.executeUpdate();
        }
    }
    public int deleteById(Long id) throws SQLException{
        String sql = "DELETE FROM artist WHERE id = ?";
        try (Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            return ps.executeUpdate();
        }
    }
}

