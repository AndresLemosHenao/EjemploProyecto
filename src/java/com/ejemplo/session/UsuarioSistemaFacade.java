/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.session;

import com.ejemplo.entities.UsuarioSistema;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruber
 */
@Stateless
public class UsuarioSistemaFacade extends AbstractFacade<UsuarioSistema> {
    @PersistenceContext(unitName = "ProyectoAdsiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioSistemaFacade() {
        super(UsuarioSistema.class);
    }
    
}
