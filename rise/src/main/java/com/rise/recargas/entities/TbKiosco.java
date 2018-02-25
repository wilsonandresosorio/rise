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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tb_kiosco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbKiosco.findAll", query = "SELECT t FROM TbKiosco t")
    , @NamedQuery(name = "TbKiosco.findById", query = "SELECT t FROM TbKiosco t WHERE t.id = :id")
    , @NamedQuery(name = "TbKiosco.findByNombre", query = "SELECT t FROM TbKiosco t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TbKiosco.findByContrasenia", query = "SELECT t FROM TbKiosco t WHERE t.contrasenia = :contrasenia")})
public class TbKiosco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "contrasenia")
    private String contrasenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCabina")
    private Collection<TbRecarga> tbRecargaCollection;

    public TbKiosco() {
    }

    public TbKiosco(Integer id) {
        this.id = id;
    }

    public TbKiosco(Integer id, String nombre, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public Collection<TbRecarga> getTbRecargaCollection() {
        return tbRecargaCollection;
    }

    public void setTbRecargaCollection(Collection<TbRecarga> tbRecargaCollection) {
        this.tbRecargaCollection = tbRecargaCollection;
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
        if (!(object instanceof TbKiosco)) {
            return false;
        }
        TbKiosco other = (TbKiosco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allix.recargas.entities.service.TbKiosco[ id=" + id + " ]";
    }
    
}
