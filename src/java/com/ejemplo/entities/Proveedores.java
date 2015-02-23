/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ruber
 */
@Entity
@Table(name = "Proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p"),
    @NamedQuery(name = "Proveedores.findByIdProveedor", query = "SELECT p FROM Proveedores p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedores.findByNombreProveedor", query = "SELECT p FROM Proveedores p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedores.findByDireccionProveedor", query = "SELECT p FROM Proveedores p WHERE p.direccionProveedor = :direccionProveedor"),
    @NamedQuery(name = "Proveedores.findByDepartamentoProveedor", query = "SELECT p FROM Proveedores p WHERE p.departamentoProveedor = :departamentoProveedor"),
    @NamedQuery(name = "Proveedores.findByCiudadProveedor", query = "SELECT p FROM Proveedores p WHERE p.ciudadProveedor = :ciudadProveedor"),
    @NamedQuery(name = "Proveedores.findByTelefonoProveedor", query = "SELECT p FROM Proveedores p WHERE p.telefonoProveedor = :telefonoProveedor"),
    @NamedQuery(name = "Proveedores.findByEmailProveedor", query = "SELECT p FROM Proveedores p WHERE p.emailProveedor = :emailProveedor")})
public class Proveedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProveedor")
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreProveedor")
    private String nombreProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccionProveedor")
    private String direccionProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "departamentoProveedor")
    private String departamentoProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudadProveedor")
    private String ciudadProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefonoProveedor")
    private String telefonoProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emailProveedor")
    private String emailProveedor;
    @JoinColumn(name = "Ciudad_idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad ciudadidCiudad;

    public Proveedores() {
    }

    public Proveedores(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedores(Integer idProveedor, String nombreProveedor, String direccionProveedor, String departamentoProveedor, String ciudadProveedor, String telefonoProveedor, String emailProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.departamentoProveedor = departamentoProveedor;
        this.ciudadProveedor = ciudadProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.emailProveedor = emailProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getDepartamentoProveedor() {
        return departamentoProveedor;
    }

    public void setDepartamentoProveedor(String departamentoProveedor) {
        this.departamentoProveedor = departamentoProveedor;
    }

    public String getCiudadProveedor() {
        return ciudadProveedor;
    }

    public void setCiudadProveedor(String ciudadProveedor) {
        this.ciudadProveedor = ciudadProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
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
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreProveedor();
    }
    
}
