/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rise.recargas.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andrés
 */
@Embeddable
public class TbOperadorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_distribuidor")
    private int idDistribuidor;

    public TbOperadorPK() {
    }

    public TbOperadorPK(String id, int idDistribuidor) {
        this.id = id;
        this.idDistribuidor = idDistribuidor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (int) idDistribuidor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOperadorPK)) {
            return false;
        }
        TbOperadorPK other = (TbOperadorPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if (this.idDistribuidor != other.idDistribuidor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allix.recargas.entities.service.TbOperadorPK[ id=" + id + ", idDistribuidor=" + idDistribuidor + " ]";
    }
    
}
