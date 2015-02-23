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
@Table(name = "Persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByNombrePersona", query = "SELECT p FROM Persona p WHERE p.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "Persona.findByApellidoPersona", query = "SELECT p FROM Persona p WHERE p.apellidoPersona = :apellidoPersona"),
    @NamedQuery(name = "Persona.findByFechaNacimientoPersona", query = "SELECT p FROM Persona p WHERE p.fechaNacimientoPersona = :fechaNacimientoPersona"),
    @NamedQuery(name = "Persona.findByDireccionPersona", query = "SELECT p FROM Persona p WHERE p.direccionPersona = :direccionPersona"),
    @NamedQuery(name = "Persona.findByEmailPersona", query = "SELECT p FROM Persona p WHERE p.emailPersona = :emailPersona")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPersona")
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombrePersona")
    private String nombrePersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidoPersona")
    private String apellidoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechaNacimientoPersona")
    private String fechaNacimientoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccionPersona")
    private String direccionPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emailPersona")
    private String emailPersona;
    @JoinColumn(name = "Cargos_idCargos", referencedColumnName = "idCargos")
    @ManyToOne(optional = false)
    private Cargos cargosidCargos;
    @JoinColumn(name = "UsuarioSistema_idUsuarioSistema", referencedColumnName = "idUsuarioSistema")
    @ManyToOne(optional = false)
    private UsuarioSistema usuarioSistemaidUsuarioSistema;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String nombrePersona, String apellidoPersona, String fechaNacimientoPersona, String direccionPersona, String emailPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.fechaNacimientoPersona = fechaNacimientoPersona;
        this.direccionPersona = direccionPersona;
        this.emailPersona = emailPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getFechaNacimientoPersona() {
        return fechaNacimientoPersona;
    }

    public void setFechaNacimientoPersona(String fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public Cargos getCargosidCargos() {
        return cargosidCargos;
    }

    public void setCargosidCargos(Cargos cargosidCargos) {
        this.cargosidCargos = cargosidCargos;
    }

    public UsuarioSistema getUsuarioSistemaidUsuarioSistema() {
        return usuarioSistemaidUsuarioSistema;
    }

    public void setUsuarioSistemaidUsuarioSistema(UsuarioSistema usuarioSistemaidUsuarioSistema) {
        this.usuarioSistemaidUsuarioSistema = usuarioSistemaidUsuarioSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombrePersona() + " " + getApellidoPersona();
    }
    
}
