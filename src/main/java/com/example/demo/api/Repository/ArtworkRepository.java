package com.example.demo.api.Repository;

import com.example.demo.api.model.ArtworkDto;
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
public class ArtworkRepository {
    private final DataSource dataSource;
    public ArtworkRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<ArtworkDto> findAll() throws SQLException {
        String sql = "SELECT id, title,";
        List<ArtworkDto> list = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date d = rs.getDate("artwork_date");
                list.add(new ArtworkDto(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("artist"),
                        rs.getInt("date"),
                        rs.getBoolean("copyrighted"),
                        rs.getInt("price")
                ));
            }
        }
        return list;
    }
    public void save(ArtworkDto a) throws SQLException{
        String sql = "INSERT INTO artwork(id, title, artist, date, copyrighted, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, a.getId());
            ps.setString(2, a.getTitle());
            ps.setString(3, a.getArtist());
            ps.setInt(4, a.getDate());
            ps.setBoolean(5, a.getCopyrighted());
            ps.setInt(6, a.getPrice());
            ps.executeUpdate();
        }
    }
    public int updateById(Long id, ArtworkDto a) throws SQLException{
        String sql = "UPDATE artwork SET title = ?, artist = ?, date = ?, copyrighted = ?, price = ? WHERE id = ?";
        try (Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, a.getTitle());
            ps.setString(2, a.getArtist());
            ps.setInt(3, a.getDate());
            ps.setBoolean(4, a.getCopyrighted());
            ps.setInt(5, a.getPrice());
            return ps.executeUpdate();
        }
    }
    public int deleteById(Long id) throws SQLException{
        String sql = "DELETE FROM artwork WHERE id = ?";
        try (Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            return ps.executeUpdate();
        }
    }
}
