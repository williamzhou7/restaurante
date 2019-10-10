/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.connection.ConnectionFactory;
import com.model.bean.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class ClienteDAO {
    
    public Cliente save(Cliente cliente) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar" + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return cliente;
    }

    public Cliente update(Cliente cliente) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar" + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return cliente;
    }

    public List<Cliente> FindMesa(String nummesa) {

        EntityManager em = new ConnectionFactory().getConnection();
        List<Cliente> cliente = null;

        try {
            cliente = em.createQuery("from Cliente c where mesa_nome_mesa="+nummesa).getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar" + e);
        } finally {
            em.close();
        }

        return cliente;

    }
    
        public Cliente FindByID(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Cliente cliente = null;

        try {
            cliente = em.find(Cliente.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar" + e);
        } finally {
            em.close();
        }

        return cliente;

    }

    public List<Cliente> FindAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Cliente> cliente = null;

        try {
            cliente = em.createQuery("from Cliente c").getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar" + e);
        } finally {
            em.close();
        }

        return cliente;
    }
    
    public List<Cliente> Findmesa(Integer mesa) {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Cliente> cliente = null;
       
        try {
            cliente = em.createQuery("from Cliente c where mesa_id_mesa =  "+ mesa).getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar" + e);
        } finally {
            em.close();
        }

        return cliente;
    }

    public Cliente remove(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover" + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return cliente;
    }

}


 
