
package com.model.dao;

import com.connection.ConnectionFactory;
import com.model.bean.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;


public class ProdutoDAO {
    
    public Produto save(Produto cliente) {
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

    public Produto update(Produto cliente) {
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

    public Produto findByID(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Produto cliente = null;

        try {
            cliente = em.find(Produto.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar" + e);
        } finally {
            em.close();
        }

        return cliente;

    }

    public List<Produto> FindAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Produto> cliente = null;

        try {
            cliente = em.createQuery("from Produto p").getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar" + e);
        } finally {
            em.close();
        }

        return cliente;
    }

    public Produto remove(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Produto cliente = null;
        try {
            cliente = em.find(Produto.class, id);
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

