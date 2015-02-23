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
@Table(name = "Cargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c"),
    @NamedQuery(name = "Cargos.findByIdCargos", query = "SELECT c FROM Cargos c WHERE c.idCargos = :idCargos"),
    @NamedQuery(name = "Cargos.findByNombreCargos", query = "SELECT c FROM Cargos c WHERE c.nombreCargos = :nombreCargos")})
public class Cargos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCargos")
    private Integer idCargos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreCargos")
    private String nombreCargos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargosidCargos")
    private List<Persona> personaList;
    @JoinColumn(name = "Dependencias_idDependencias", referencedColumnName = "idDependencias")
    @ManyToOne(optional = false)
    private Dependencias dependenciasidDependencias;

    public Cargos() {
    }

    public Cargos(Integer idCargos) {
        this.idCargos = idCargos;
    }

    public Cargos(Integer idCargos, String nombreCargos) {
        this.idCargos = idCargos;
        this.nombreCargos = nombreCargos;
    }

    public Integer getIdCargos() {
        return idCargos;
    }

    public void setIdCargos(Integer idCargos) {
        this.idCargos = idCargos;
    }

    public String getNombreCargos() {
        return nombreCargos;
    }

    public void setNombreCargos(String nombreCargos) {
        this.nombreCargos = nombreCargos;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Dependencias getDependenciasidDependencias() {
        return dependenciasidDependencias;
    }

    public void setDependenciasidDependencias(Dependencias dependenciasidDependencias) {
        this.dependenciasidDependencias = dependenciasidDependencias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargos != null ? idCargos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.idCargos == null && other.idCargos != null) || (this.idCargos != null && !this.idCargos.equals(other.idCargos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreCargos();
    }
    
}
