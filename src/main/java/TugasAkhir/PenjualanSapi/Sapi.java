/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasAkhir.PenjualanSapi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author GF63-9SC
 */
@Entity
@Table(name = "sapi")
@NamedQueries({
    @NamedQuery(name = "Sapi.findAll", query = "SELECT s FROM Sapi s"),
    @NamedQuery(name = "Sapi.findById", query = "SELECT s FROM Sapi s WHERE s.id = :id"),
    @NamedQuery(name = "Sapi.findByJenis", query = "SELECT s FROM Sapi s WHERE s.jenis = :jenis"),
    @NamedQuery(name = "Sapi.findByHarga", query = "SELECT s FROM Sapi s WHERE s.harga = :harga"),
    @NamedQuery(name = "Sapi.findByJumlah", query = "SELECT s FROM Sapi s WHERE s.jumlah = :jumlah")})
public class Sapi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "jenis")
    private String jenis;
    @Column(name = "harga")
    private String harga;
    @Column(name = "jumlah")
    private String jumlah;

    public Sapi() {
    }

    public Sapi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sapi)) {
            return false;
        }
        Sapi other = (Sapi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TugasAkhir.PenjualanSapi.Sapi[ id=" + id + " ]";
    }
    
}
