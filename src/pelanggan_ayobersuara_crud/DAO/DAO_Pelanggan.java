package pelanggan_ayobersuara_crud.DAO;

import pelanggan_ayobersuara_crud.koneksi.Koneksi;
import pelanggan_ayobersuara_crud.model.M_Pelanggan;
import pelanggan_ayobersuara_crud.DAOImplement.Implement_Pelanggan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author VEBRI DEVELOPER
 */
public class DAO_Pelanggan implements Implement_Pelanggan {

    Connection connection;
    final String insert = "INSERT INTO tb_pelanggan (nama_pelanggan, telpon_pelanggan,alamat_pelanggan, status_pelanggan, paket_pelanggan) VALUES (?,?,?,?,?);";
    final String update = "UPDATE tb_pelanggan set nama_pelanggan=?, telpon_pelanggan=?, alamat_pelanggan=?, status_pelanggan=?, paket_pelanggan=? where id=? ;";
    final String delete = "DELETE FROM tb_pelanggan where id=? ;";
    final String select = "SELECT * FROM tb_pelanggan;";
    final String carinama = "SELECT * FROM tb_pelanggan where nama_pelanggan like ?";
    
    public DAO_Pelanggan() {
        connection = Koneksi.connection();
    }
    
    @Override
    public void insert(M_Pelanggan b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, b.getNama_pelanggan());
            statement.setString(2, b.getTelp_pelanggan());
            statement.setString(3, b.getAlamat_pelanggan());
            statement.setString(4, b.getStatus_pelanggan());
            statement.setString(5, b.getPaket_pelanggan());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(M_Pelanggan b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNama_pelanggan());
            statement.setString(2, b.getTelp_pelanggan());
            statement.setString(3, b.getAlamat_pelanggan());
            statement.setString(4, b.getStatus_pelanggan());
            statement.setString(5, b.getPaket_pelanggan());
            statement.setInt(6, b.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<M_Pelanggan> getALL() {
        List<M_Pelanggan> lb = null;
        try {
            lb = new ArrayList<M_Pelanggan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                M_Pelanggan b = new M_Pelanggan();
                b.setId(rs.getInt("id"));
                b.setNama_pelanggan(rs.getString("nama_pelanggan"));
                b.setTelp_pelanggan(rs.getString("telpon_pelanggan"));
                b.setAlamat_pelanggan(rs.getString("alamat_pelanggan"));
                b.setStatus_pelanggan(rs.getString("status_pelanggan"));
                b.setPaket_pelanggan(rs.getString("paket_pelanggan"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lb;
    }

    @Override
    public List<M_Pelanggan> getCariNama(String nama) {
        List<M_Pelanggan> lb = null;
        try {
            lb = new ArrayList<M_Pelanggan>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                M_Pelanggan b = new M_Pelanggan();
                b.setId(rs.getInt("id"));
                b.setNama_pelanggan(rs.getString("nama_pelanggan"));
                b.setTelp_pelanggan(rs.getString("telpon_pelanggan"));
                b.setAlamat_pelanggan(rs.getString("alamat_pelanggan"));
                b.setStatus_pelanggan(rs.getString("status_pelanggan"));
                b.setPaket_pelanggan(rs.getString("paket_pelanggan"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    
}
