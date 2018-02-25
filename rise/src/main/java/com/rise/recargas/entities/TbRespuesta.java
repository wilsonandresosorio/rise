/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rise.recargas.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "tb_respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRespuesta.findAll", query = "SELECT t FROM TbRespuesta t")
    , @NamedQuery(name = "TbRespuesta.findById", query = "SELECT t FROM TbRespuesta t WHERE t.id = :id")
    , @NamedQuery(name = "TbRespuesta.findByDetalle", query = "SELECT t FROM TbRespuesta t WHERE t.detalle = :detalle")
    , @NamedQuery(name = "TbRespuesta.findByFecha", query = "SELECT t FROM TbRespuesta t WHERE t.fecha = :fecha")})
public class TbRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_recarga", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbRecarga idRecarga;

    public TbRespuesta() {
    }

    public TbRespuesta(Integer id) {
        this.id = id;
    }

    public TbRespuesta(Integer id, String detalle, Date fecha) {
        this.id = id;
        this.detalle = detalle;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TbRecarga getIdRecarga() {
        return idRecarga;
    }

    public void setIdRecarga(TbRecarga idRecarga) {
        this.idRecarga = idRecarga;
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
        if (!(object instanceof TbRespuesta)) {
            return false;
        }
        TbRespuesta other = (TbRespuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allix.recargas.entities.service.TbRespuesta[ id=" + id + " ]";
    }
    
}
