package Modelo;
public class EntidadVendedor {
    int id;
    String ci;
    String nom;
    String tel;
    String estado;
    String user;

    public EntidadVendedor() {
    }

    public EntidadVendedor(int id, String ci, String nom, String tel, String estado, String user) {
        this.id = id;
        this.ci = ci;
        this.nom = nom;
        this.tel = tel;
        this.estado = estado;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
