package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member1 = new Member();
            member1.setName("A");
            Member member2 = new Member();
            member2.setName("B");
            Member member3 = new Member();
            member3.setName("C");
            System.out.println("==============");
            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);
            System.out.println("member1.Id = " + member1.getId());
//            System.out.println("member2.Id = " + member2.getId());
//            System.out.println("member3.Id = " + member3.getId());
            System.out.println("==============");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
