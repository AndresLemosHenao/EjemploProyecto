/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author ruber
 */
@Entity
@Table(name = "Cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByNombreRazonSocial", query = "SELECT c FROM Cliente c WHERE c.nombreRazonSocial = :nombreRazonSocial"),
    @NamedQuery(name = "Cliente.findByDireccionCliente", query = "SELECT c FROM Cliente c WHERE c.direccionCliente = :direccionCliente"),
    @NamedQuery(name = "Cliente.findByDepartamentoCliente", query = "SELECT c FROM Cliente c WHERE c.departamentoCliente = :departamentoCliente"),
    @NamedQuery(name = "Cliente.findByCiudadCliente", query = "SELECT c FROM Cliente c WHERE c.ciudadCliente = :ciudadCliente"),
    @NamedQuery(name = "Cliente.findByTelefonoCliente", query = "SELECT c FROM Cliente c WHERE c.telefonoCliente = :telefonoCliente"),
    @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreRazonSocial")
    private String nombreRazonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccionCliente")
    private String direccionCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "departamentoCliente")
    private String departamentoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudadCliente")
    private String ciudadCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefonoCliente")
    private String telefonoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emailCliente")
    private String emailCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteidCliente")
    private List<FacturaVenta> facturaVentaList;
    @JoinColumn(name = "Ciudad_idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad ciudadidCiudad;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombreRazonSocial, String direccionCliente, String departamentoCliente, String ciudadCliente, String telefonoCliente, String emailCliente) {
        this.idCliente = idCliente;
        this.nombreRazonSocial = nombreRazonSocial;
        this.direccionCliente = direccionCliente;
        this.departamentoCliente = departamentoCliente;
        this.ciudadCliente = ciudadCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDepartamentoCliente() {
        return departamentoCliente;
    }

    public void setDepartamentoCliente(String departamentoCliente) {
        this.departamentoCliente = departamentoCliente;
    }

    public String getCiudadCliente() {
        return ciudadCliente;
    }

    public void setCiudadCliente(String ciudadCliente) {
        this.ciudadCliente = ciudadCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    @XmlTransient
    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    public Ciudad getCiudadidCiudad() {
        return ciudadidCiudad;
    }

    public void setCiudadidCiudad(Ciudad ciudadidCiudad) {
        this.ciudadidCiudad = ciudadidCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreRazonSocial();
    }
    
}
