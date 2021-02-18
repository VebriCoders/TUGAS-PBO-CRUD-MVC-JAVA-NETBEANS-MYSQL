package pelanggan_ayobersuara_crud.DAOImplement;

import java.util.List;
import pelanggan_ayobersuara_crud.model.*;

/**
 * @author VEBRI DEVELOPER
 */

public interface Implement_Pelanggan {
    public void insert(M_Pelanggan b);

    public void update(M_Pelanggan b);

    public void delete(int id);

    public List<M_Pelanggan> getALL();

    public List<M_Pelanggan> getCariNama(String nama);
}
