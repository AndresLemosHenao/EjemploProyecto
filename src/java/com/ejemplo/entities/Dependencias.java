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
@Table(name = "Dependencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencias.findAll", query = "SELECT d FROM Dependencias d"),
    @NamedQuery(name = "Dependencias.findByIdDependencias", query = "SELECT d FROM Dependencias d WHERE d.idDependencias = :idDependencias"),
    @NamedQuery(name = "Dependencias.findByNombreDependencias", query = "SELECT d FROM Dependencias d WHERE d.nombreDependencias = :nombreDependencias")})
public class Dependencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDependencias")
    private Integer idDependencias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreDependencias")
    private String nombreDependencias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependenciasidDependencias")
    private List<Cargos> cargosList;

    public Dependencias() {
    }

    public Dependencias(Integer idDependencias) {
        this.idDependencias = idDependencias;
    }

    public Dependencias(Integer idDependencias, String nombreDependencias) {
        this.idDependencias = idDependencias;
        this.nombreDependencias = nombreDependencias;
    }

    public Integer getIdDependencias() {
        return idDependencias;
    }

    public void setIdDependencias(Integer idDependencias) {
        this.idDependencias = idDependencias;
    }

    public String getNombreDependencias() {
        return nombreDependencias;
    }

    public void setNombreDependencias(String nombreDependencias) {
        this.nombreDependencias = nombreDependencias;
    }

    @XmlTransient
    public List<Cargos> getCargosList() {
        return cargosList;
    }

    public void setCargosList(List<Cargos> cargosList) {
        this.cargosList = cargosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDependencias != null ? idDependencias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependencias)) {
            return false;
        }
        Dependencias other = (Dependencias) object;
        if ((this.idDependencias == null && other.idDependencias != null) || (this.idDependencias != null && !this.idDependencias.equals(other.idDependencias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreDependencias();
    }
    
}
