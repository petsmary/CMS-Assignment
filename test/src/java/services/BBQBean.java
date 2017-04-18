/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import services.entity.Bbq;

/**
 *
 * @author ofps4
 */
@Named(value = "bBQBean")
@SessionScoped
public class BBQBean implements Serializable {

    private String username;
    private int peopleNum;
    private String time;
    private Date date;
    private String result;

    /**
     * Creates a new instance of BBQBean
     */
    public BBQBean() {
        getuserSession();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = getuserSession();
    }

    public String getuserSession() {
        // HttpSession session = SessionUtils.getSession();
        username = "C0001";

        return "C0001";
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void bookResult() {
        result = bbqBook();
    }

    ArrayList<Bbq> list = new ArrayList<Bbq>();

    public ArrayList<Bbq> getList() {
        return list;
    }

    public void setList(ArrayList<Bbq> list) {
        this.list = list;
    }

    public String bbqBook() {

        EntityManagerFactory emf
                = javax.persistence.Persistence.createEntityManagerFactory("testPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createNamedQuery("Bbq.match").setParameter("peopleNum", peopleNum).setParameter("time", time).setParameter("date", date);

            List<Bbq> bk = q.getResultList();
            /*  ArrayList<Bbq> s = new ArrayList<Bbq>();
            for (int i = 0; i<bk.size();i++){
                s.add(bk.get(i));
            }
        setList(s);*/
            em.createQuery("Update Bbq set username = '" + username + "', taken = 1 where number = " + bk.get(0).getNumber()).executeUpdate();
            em.getTransaction().commit();
            return "Book success! Thank for use our service.";

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return "Sorry! You need to book other time.";

    }
}
