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
@Table(name = "tb_distribuidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDistribuidor.findAll", query = "SELECT t FROM TbDistribuidor t")
    , @NamedQuery(name = "TbDistribuidor.findById", query = "SELECT t FROM TbDistribuidor t WHERE t.id = :id")
    , @NamedQuery(name = "TbDistribuidor.findByNombre", query = "SELECT t FROM TbDistribuidor t WHERE t.nombre = :nombre")})
public class TbDistribuidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbDistribuidor")
    private Collection<TbOperador> tbOperadorCollection;

    public TbDistribuidor() {
    }

    public TbDistribuidor(Integer id) {
        this.id = id;
    }

    public TbDistribuidor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @XmlTransient
    public Collection<TbOperador> getTbOperadorCollection() {
        return tbOperadorCollection;
    }

    public void setTbOperadorCollection(Collection<TbOperador> tbOperadorCollection) {
        this.tbOperadorCollection = tbOperadorCollection;
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
        if (!(object instanceof TbDistribuidor)) {
            return false;
        }
        TbDistribuidor other = (TbDistribuidor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allix.recargas.entities.service.TbDistribuidor[ id=" + id + " ]";
    }
    
}
