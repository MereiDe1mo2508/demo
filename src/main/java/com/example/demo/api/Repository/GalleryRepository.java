package com.example.demo.api.Repository;

import com.example.demo.api.model.GalleryDto;
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
public class GalleryRepository {
    private final DataSource dataSource;
    public GalleryRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<GalleryDto> findAll() throws SQLException {
        String sql = "SELECT id, name, location";
        List<GalleryDto> list = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date d = rs.getDate("gallery_date");
                list.add(new GalleryDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("location")
                ));
            }
        }
        return list;
    }
    public void save(GalleryDto g) throws SQLException{
        String sql = "INSERT INTO gallery(id, name, location) VALUES (?, ?, ?)";
        try (Connection c = dataSource.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, g.getId());
            ps.setString(2, g.getName());
            ps.setString(3, g.getLocation());
            ps.executeUpdate();
        }
    }
    public int updateById(Long id, GalleryDto g) throws SQLException{
        String sql = "UPDATE artwork SET name = ?, location = ? WHERE id = ?";
        try (Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, g.getName());
            ps.setString(2, g.getLocation());
            return ps.executeUpdate();
        }
    }
    public int deleteById(Long id) throws SQLException{
        String sql = "DELETE FROM gallery WHERE id = ?";
        try (Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            return ps.executeUpdate();
        }
    }
}

