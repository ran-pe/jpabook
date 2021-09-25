package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExamMergeMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        TestMember member = createMember("회원1", 20);
        member.setUsername("회원명변경");
        mergeMember(member);
    }

    static TestMember createMember(String username, int age) {
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        TestMember member = new TestMember();
        member.setUsername(username);
        member.setAge(age);

        em1.persist(member);
        tx1.commit();

        em1.close();

        return member;
    }

    static void mergeMember(TestMember member) {
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();

        TestMember mergeMember = em2.merge(member);
        tx2.commit();

        //준영속 상태
        System.out.println("member:" + member);

        //영속 상태
        System.out.println("mergeMember" + mergeMember);

        System.out.println("em2 contains member = " + em2.contains(member));

        System.out.println("em2 contains mergeMember = " + em2.contains(mergeMember));

        em2.close();
    }
}
