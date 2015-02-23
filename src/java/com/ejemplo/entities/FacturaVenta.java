/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ruber
 */
@Entity
@Table(name = "FacturaVenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaVenta.findAll", query = "SELECT f FROM FacturaVenta f"),
    @NamedQuery(name = "FacturaVenta.findByIdVenta", query = "SELECT f FROM FacturaVenta f WHERE f.idVenta = :idVenta"),
    @NamedQuery(name = "FacturaVenta.findByNumerofacturaVenta", query = "SELECT f FROM FacturaVenta f WHERE f.numerofacturaVenta = :numerofacturaVenta"),
    @NamedQuery(name = "FacturaVenta.findByCantidadProducto", query = "SELECT f FROM FacturaVenta f WHERE f.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "FacturaVenta.findByValorUnitarioProducto", query = "SELECT f FROM FacturaVenta f WHERE f.valorUnitarioProducto = :valorUnitarioProducto"),
    @NamedQuery(name = "FacturaVenta.findByTotalValorProducto", query = "SELECT f FROM FacturaVenta f WHERE f.totalValorProducto = :totalValorProducto"),
    @NamedQuery(name = "FacturaVenta.findBySubtotalVenta", query = "SELECT f FROM FacturaVenta f WHERE f.subtotalVenta = :subtotalVenta"),
    @NamedQuery(name = "FacturaVenta.findByValorIvaProductos", query = "SELECT f FROM FacturaVenta f WHERE f.valorIvaProductos = :valorIvaProductos"),
    @NamedQuery(name = "FacturaVenta.findByTotalFacturaVenta", query = "SELECT f FROM FacturaVenta f WHERE f.totalFacturaVenta = :totalFacturaVenta")})
public class FacturaVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVenta")
    private Integer idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerofacturaVenta")
    private int numerofacturaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadProducto")
    private int cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorUnitarioProducto")
    private double valorUnitarioProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalValorProducto")
    private double totalValorProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotalVenta")
    private double subtotalVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorIvaProductos")
    private double valorIvaProductos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalFacturaVenta")
    private double totalFacturaVenta;
    @JoinTable(name = "Producto_has_FacturaVenta", joinColumns = {
        @JoinColumn(name = "FacturaVenta_idVenta", referencedColumnName = "idVenta")}, inverseJoinColumns = {
        @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto")})
    @ManyToMany
    private List<Producto> productoList;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente clienteidCliente;

    public FacturaVenta() {
    }

    public FacturaVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public FacturaVenta(Integer idVenta, int numerofacturaVenta, int cantidadProducto, double valorUnitarioProducto, double totalValorProducto, double subtotalVenta, double valorIvaProductos, double totalFacturaVenta) {
        this.idVenta = idVenta;
        this.numerofacturaVenta = numerofacturaVenta;
        this.cantidadProducto = cantidadProducto;
        this.valorUnitarioProducto = valorUnitarioProducto;
        this.totalValorProducto = totalValorProducto;
        this.subtotalVenta = subtotalVenta;
        this.valorIvaProductos = valorIvaProductos;
        this.totalFacturaVenta = totalFacturaVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public int getNumerofacturaVenta() {
        return numerofacturaVenta;
    }

    public void setNumerofacturaVenta(int numerofacturaVenta) {
        this.numerofacturaVenta = numerofacturaVenta;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getValorUnitarioProducto() {
        return valorUnitarioProducto;
    }

    public void setValorUnitarioProducto(double valorUnitarioProducto) {
        this.valorUnitarioProducto = valorUnitarioProducto;
    }

    public double getTotalValorProducto() {
        return totalValorProducto;
    }

    public void setTotalValorProducto(double totalValorProducto) {
        this.totalValorProducto = totalValorProducto;
    }

    public double getSubtotalVenta() {
        return subtotalVenta;
    }

    public void setSubtotalVenta(double subtotalVenta) {
        this.subtotalVenta = subtotalVenta;
    }

    public double getValorIvaProductos() {
        return valorIvaProductos;
    }

    public void setValorIvaProductos(double valorIvaProductos) {
        this.valorIvaProductos = valorIvaProductos;
    }

    public double getTotalFacturaVenta() {
        return totalFacturaVenta;
    }

    public void setTotalFacturaVenta(double totalFacturaVenta) {
        this.totalFacturaVenta = totalFacturaVenta;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaVenta)) {
            return false;
        }
        FacturaVenta other = (FacturaVenta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        return "Factura Número " + getNumerofacturaVenta();
    }
    
}
