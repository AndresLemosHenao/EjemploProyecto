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
@Table(name = "UsuarioSistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioSistema.findAll", query = "SELECT u FROM UsuarioSistema u"),
    @NamedQuery(name = "UsuarioSistema.findByIdUsuarioSistema", query = "SELECT u FROM UsuarioSistema u WHERE u.idUsuarioSistema = :idUsuarioSistema"),
    @NamedQuery(name = "UsuarioSistema.findByNombreUsuario", query = "SELECT u FROM UsuarioSistema u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "UsuarioSistema.findByPasswordUsuario", query = "SELECT u FROM UsuarioSistema u WHERE u.passwordUsuario = :passwordUsuario")})
public class UsuarioSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuarioSistema")
    private Integer idUsuarioSistema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "passwordUsuario")
    private String passwordUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioSistemaidUsuarioSistema")
    private List<Persona> personaList;
    @JoinColumn(name = "Rol_idRol", referencedColumnName = "idRol")
    @ManyToOne(optional = false)
    private Rol rolidRol;

    public UsuarioSistema() {
    }

    public UsuarioSistema(Integer idUsuarioSistema) {
        this.idUsuarioSistema = idUsuarioSistema;
    }

    public UsuarioSistema(Integer idUsuarioSistema, String nombreUsuario, String passwordUsuario) {
        this.idUsuarioSistema = idUsuarioSistema;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
    }

    public Integer getIdUsuarioSistema() {
        return idUsuarioSistema;
    }

    public void setIdUsuarioSistema(Integer idUsuarioSistema) {
        this.idUsuarioSistema = idUsuarioSistema;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Rol getRolidRol() {
        return rolidRol;
    }

    public void setRolidRol(Rol rolidRol) {
        this.rolidRol = rolidRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioSistema != null ? idUsuarioSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioSistema)) {
            return false;
        }
        UsuarioSistema other = (UsuarioSistema) object;
        if ((this.idUsuarioSistema == null && other.idUsuarioSistema != null) || (this.idUsuarioSistema != null && !this.idUsuarioSistema.equals(other.idUsuarioSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreUsuario();
    }
    
}
