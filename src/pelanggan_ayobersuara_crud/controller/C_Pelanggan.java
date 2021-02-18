package pelanggan_ayobersuara_crud.controller;

import pelanggan_ayobersuara_crud.DAO.DAO_Pelanggan;
import pelanggan_ayobersuara_crud.DAOImplement.Implement_Pelanggan;
import pelanggan_ayobersuara_crud.model.M_Pelanggan;
import pelanggan_ayobersuara_crud.model.M_Table_Model_Pelanggan;
import pelanggan_ayobersuara_crud.view.V_Pelanggan;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author VEBRI DEVELOPER
 */
public class C_Pelanggan {
    
    V_Pelanggan frame_pelanggan;
    Implement_Pelanggan implement_pelanggan;
    List<M_Pelanggan> list_pelanggan;
    
    public C_Pelanggan(V_Pelanggan frame_pelanggan) {
        this.frame_pelanggan = frame_pelanggan;
        implement_pelanggan = new DAO_Pelanggan();
        list_pelanggan = implement_pelanggan.getALL();
    }
    
    //Reset Kosongkan Field
    public void reset() {
        frame_pelanggan.getTxtID().setText("");
        frame_pelanggan.getTxtNamaPelanggan().setText("");
        frame_pelanggan.getTxtNomorTelpPelanggan().setText("");
        frame_pelanggan.getTxtAlamatPelanggan().setText("");
        frame_pelanggan.getTxtStatusPelanggan().setSelectedItem("Pilih Status");
        frame_pelanggan.getTxtPaketAplikasi().setSelectedItem("Pilih Paket Aplikasi");
    }
    
    //Tampil Data Ke Tabel
    public void isiTable() {
        list_pelanggan = implement_pelanggan.getALL();
        M_Table_Model_Pelanggan tmb = new M_Table_Model_Pelanggan(list_pelanggan);
        frame_pelanggan.getTabelDataPelanggan().setModel(tmb);
    }
    
    //Menampilkan Data Yang Di Pilih Dari Tabel
    public void isiField(int row) {
        frame_pelanggan.getTxtID().setText(list_pelanggan.get(row).getId().toString());
        frame_pelanggan.getTxtNamaPelanggan().setText(list_pelanggan.get(row).getNama_pelanggan());
        frame_pelanggan.getTxtNomorTelpPelanggan().setText(list_pelanggan.get(row).getTelp_pelanggan());
        frame_pelanggan.getTxtAlamatPelanggan().setText(list_pelanggan.get(row).getAlamat_pelanggan());
        frame_pelanggan.getTxtStatusPelanggan().setSelectedItem(list_pelanggan.get(row).getStatus_pelanggan());
        frame_pelanggan.getTxtPaketAplikasi().setSelectedItem(list_pelanggan.get(row).getPaket_pelanggan());
    }
    
    //Insert Data Dari Frame Ke Database
    public void insert() {
        
        if (!frame_pelanggan.getTxtNamaPelanggan().getText().trim().isEmpty()& !frame_pelanggan.getTxtNomorTelpPelanggan().getText().trim().isEmpty()& !frame_pelanggan.getTxtAlamatPelanggan().getText().trim().isEmpty()) {
          
        M_Pelanggan b = new M_Pelanggan();
        b.setNama_pelanggan(frame_pelanggan.getTxtNamaPelanggan().getText());
        b.setTelp_pelanggan(frame_pelanggan.getTxtNomorTelpPelanggan().getText());
        b.setAlamat_pelanggan(frame_pelanggan.getTxtAlamatPelanggan().getText());
        b.setStatus_pelanggan(frame_pelanggan.getTxtStatusPelanggan().getSelectedItem().toString());
        b.setPaket_pelanggan(frame_pelanggan.getTxtPaketAplikasi().getSelectedItem().toString());

        implement_pelanggan.insert(b);
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        
        } else {
            JOptionPane.showMessageDialog(frame_pelanggan, "Data Tidak Boleh Ada Yang Kosong !");
        }
    }
    
    //Update Data Ketika Data Di Ubah Pada Frame Di Ubah Ke Database
    public void update() {
      
        if (!frame_pelanggan.getTxtID().getText().trim().isEmpty()) {
             
        M_Pelanggan b = new M_Pelanggan();
        b.setNama_pelanggan(frame_pelanggan.getTxtNamaPelanggan().getText());
        b.setTelp_pelanggan(frame_pelanggan.getTxtNomorTelpPelanggan().getText());
        b.setAlamat_pelanggan(frame_pelanggan.getTxtAlamatPelanggan().getText());
        b.setStatus_pelanggan(frame_pelanggan.getTxtStatusPelanggan().getSelectedItem().toString());
        b.setPaket_pelanggan(frame_pelanggan.getTxtPaketAplikasi().getSelectedItem().toString());
        b.setId(Integer.parseInt(frame_pelanggan.getTxtID().getText()));
        implement_pelanggan.update(b);
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_pelanggan, "Silahkan Pilih Data Yang Akan Di Ubah !");
        }
    }
    
    //Hapus / Delete Data Pada Database
    public void delete() {
        if (!frame_pelanggan.getTxtID().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame_pelanggan.getTxtID().getText());
            implement_pelanggan.delete(id);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_pelanggan, "Silahkan Pilih Data Yang Akan Di Hapus !");
        }
    }
    
    public void isiTableCariNama() {
        list_pelanggan = implement_pelanggan.getCariNama(frame_pelanggan.getTxtCariNamaPelanggan().getText());
        M_Table_Model_Pelanggan tmb = new M_Table_Model_Pelanggan(list_pelanggan);
        frame_pelanggan.getTabelDataPelanggan().setModel(tmb);
    }
    
    public void carinama() {
        if (!frame_pelanggan.getTxtCariNamaPelanggan().getText().trim().isEmpty()) {
            implement_pelanggan.getCariNama(frame_pelanggan.getTxtCariNamaPelanggan().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_pelanggan, "SILAHKAN PILIH DATA !");
        }
    }
}
