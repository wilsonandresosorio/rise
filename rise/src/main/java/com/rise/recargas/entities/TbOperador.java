/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rise.recargas.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "tb_operador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOperador.findAll", query = "SELECT t FROM TbOperador t")
    , @NamedQuery(name = "TbOperador.findById", query = "SELECT t FROM TbOperador t WHERE t.tbOperadorPK.id = :id")
    , @NamedQuery(name = "TbOperador.findByIdDistribuidor", query = "SELECT t FROM TbOperador t WHERE t.tbOperadorPK.idDistribuidor = :idDistribuidor")
    , @NamedQuery(name = "TbOperador.findByNombre", query = "SELECT t FROM TbOperador t WHERE t.nombre = :nombre")})
public class TbOperador implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbOperadorPK tbOperadorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbOperador")
    private Collection<TbRecarga> tbRecargaCollection;
    @JoinColumn(name = "id_distribuidor", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbDistribuidor tbDistribuidor;

    public TbOperador() {
    }

    public TbOperador(TbOperadorPK tbOperadorPK) {
        this.tbOperadorPK = tbOperadorPK;
    }

    public TbOperador(TbOperadorPK tbOperadorPK, String nombre) {
        this.tbOperadorPK = tbOperadorPK;
        this.nombre = nombre;
    }

    public TbOperador(String id, int idDistribuidor) {
        this.tbOperadorPK = new TbOperadorPK(id, idDistribuidor);
    }

    public TbOperadorPK getTbOperadorPK() {
        return tbOperadorPK;
    }

    public void setTbOperadorPK(TbOperadorPK tbOperadorPK) {
        this.tbOperadorPK = tbOperadorPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<TbRecarga> getTbRecargaCollection() {
        return tbRecargaCollection;
    }

    public void setTbRecargaCollection(Collection<TbRecarga> tbRecargaCollection) {
        this.tbRecargaCollection = tbRecargaCollection;
    }

    public TbDistribuidor getTbDistribuidor() {
        return tbDistribuidor;
    }

    public void setTbDistribuidor(TbDistribuidor tbDistribuidor) {
        this.tbDistribuidor = tbDistribuidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbOperadorPK != null ? tbOperadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOperador)) {
            return false;
        }
        TbOperador other = (TbOperador) object;
        if ((this.tbOperadorPK == null && other.tbOperadorPK != null) || (this.tbOperadorPK != null && !this.tbOperadorPK.equals(other.tbOperadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allix.recargas.entities.service.TbOperador[ tbOperadorPK=" + tbOperadorPK + " ]";
    }
    
}
