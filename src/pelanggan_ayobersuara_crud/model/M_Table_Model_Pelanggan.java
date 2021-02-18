package pelanggan_ayobersuara_crud.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @author VEBRI DEVELOPER
 */

public class M_Table_Model_Pelanggan  extends AbstractTableModel{
    
    List<M_Pelanggan> list_pelanggan;

    public M_Table_Model_Pelanggan(List<M_Pelanggan> list_pelanggan) {
        this.list_pelanggan = list_pelanggan;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }


    public int getRowCount() {
        return list_pelanggan.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID/KODE";
            case 1:
                return "NAMA";
            case 2:
                return "TELEPHONE";
            case 3:
                return "ALAMAT";
            case 4:
                return "STATUS";
            case 5:
                return "PAKET";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list_pelanggan.get(row).getId();
            case 1:
                return list_pelanggan.get(row).getNama_pelanggan();
            case 2:
                return list_pelanggan.get(row).getTelp_pelanggan();
            case 3:
                return list_pelanggan.get(row).getAlamat_pelanggan();
            case 4:
                return list_pelanggan.get(row).getStatus_pelanggan();
            case 5:
                return list_pelanggan.get(row).getPaket_pelanggan();
            default:
                return null;
        }
    }
}
