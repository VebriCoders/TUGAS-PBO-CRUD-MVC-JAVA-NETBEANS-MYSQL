package pelanggan_ayobersuara_crud.model;

/**
 * @author VEBRI DEVELOPER
 */
public class M_Pelanggan {
    
    private Integer id;
    private String nama_pelanggan;
    private String telpon_pelanggan;
    private String alamat_pelanggan;
    private String status_pelanggan;
    private String paket_pelanggan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getTelp_pelanggan() {
        return telpon_pelanggan;
    }

    public void setTelp_pelanggan(String telpon_pelanggan) {
        this.telpon_pelanggan = telpon_pelanggan;
    }

    public String getAlamat_pelanggan() {
        return alamat_pelanggan;
    }

    public void setAlamat_pelanggan(String alamat_pelanggan) {
        this.alamat_pelanggan = alamat_pelanggan;
    }

    public String getStatus_pelanggan() {
        return status_pelanggan;
    }

    public void setStatus_pelanggan(String status_pelanggan) {
        this.status_pelanggan = status_pelanggan;
    }

    public String getPaket_pelanggan() {
        return paket_pelanggan;
    }

    public void setPaket_pelanggan(String paket_pelanggan) {
        this.paket_pelanggan = paket_pelanggan;
    }
    
}
