/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rise.recargas.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrés
 */
@Entity
@Table(name = "tb_recarga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRecarga.findAll", query = "SELECT t FROM TbRecarga t")
    , @NamedQuery(name = "TbRecarga.findById", query = "SELECT t FROM TbRecarga t WHERE t.id = :id")
    , @NamedQuery(name = "TbRecarga.findByIdConsecutivo", query = "SELECT t FROM TbRecarga t WHERE t.idConsecutivo = :idConsecutivo")
    , @NamedQuery(name = "TbRecarga.findByValor", query = "SELECT t FROM TbRecarga t WHERE t.valor = :valor")
    , @NamedQuery(name = "TbRecarga.findByNumero", query = "SELECT t FROM TbRecarga t WHERE t.numero = :numero")
    , @NamedQuery(name = "TbRecarga.findByFecha", query = "SELECT t FROM TbRecarga t WHERE t.fecha = :fecha")})
public class TbRecarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_consecutivo")
    private Integer idConsecutivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_estado_recarga", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbEstadoRecarga idEstadoRecarga;
    @JoinColumn(name = "id_cabina", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TbKiosco idCabina;
    @JoinColumns({
        @JoinColumn(name = "id_operador", referencedColumnName = "id")
        , @JoinColumn(name = "id_distribuidor", referencedColumnName = "id_distribuidor")})
    @ManyToOne(optional = false)
    private TbOperador tbOperador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecarga")
    private Collection<TbRespuesta> tbRespuestaCollection;

    public TbRecarga() {
    }

    public TbRecarga(Integer id) {
        this.id = id;
    }

    public TbRecarga(Integer id, int valor, String numero, Date fecha) {
        this.id = id;
        this.valor = valor;
        this.numero = numero;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdConsecutivo() {
        return idConsecutivo;
    }

    public void setIdConsecutivo(Integer idConsecutivo) {
        this.idConsecutivo = idConsecutivo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TbEstadoRecarga getIdEstadoRecarga() {
        return idEstadoRecarga;
    }

    public void setIdEstadoRecarga(TbEstadoRecarga idEstadoRecarga) {
        this.idEstadoRecarga = idEstadoRecarga;
    }

    public TbKiosco getIdCabina() {
        return idCabina;
    }

    public void setIdCabina(TbKiosco idCabina) {
        this.idCabina = idCabina;
    }

    public TbOperador getTbOperador() {
        return tbOperador;
    }

    public void setTbOperador(TbOperador tbOperador) {
        this.tbOperador = tbOperador;
    }

    @XmlTransient
    public Collection<TbRespuesta> getTbRespuestaCollection() {
        return tbRespuestaCollection;
    }

    public void setTbRespuestaCollection(Collection<TbRespuesta> tbRespuestaCollection) {
        this.tbRespuestaCollection = tbRespuestaCollection;
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
        if (!(object instanceof TbRecarga)) {
            return false;
        }
        TbRecarga other = (TbRecarga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.allix.recargas.entities.service.TbRecarga[ id=" + id + " ]";
    }
    
}
