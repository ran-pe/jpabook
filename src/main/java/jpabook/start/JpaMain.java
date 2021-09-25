package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // 엔티티매니저팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        // 엔티티매니저 생성
        EntityManager em = emf.createEntityManager();
        // 트랜잭션 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();  // 트랜잭션 시작
            logic(em);   // 비즈니스 로직 실행
            tx.commit();    // 트랜잭션 커밋
        } catch (Exception e) {
            tx.rollback();  // 트랜잭션 롤백
        } finally {
            em.close(); // 엔티티매니저 종료
        }
        emf.close();    // 엔티티매니저팩토리 종료
    }

    //비즈니스 로직
    private static void logic(EntityManager em) {
        TestMember member1 = new TestMember();
        member1.setUsername("란");
        member1.setAge(20);

        TestMember member2 = new TestMember();
        member2.setUsername("윤");
        member2.setAge(6);

        TestTeam team1 = new TestTeam();
        team1.setName("team1");

        member1.setTeam(team1);
        member2.setTeam(team1);

        em.persist(member1);
        em.persist(member2);

        // 한건 조회
        TestMember findMember = em.find(TestMember.class, member1.getId());
        TestTeam team = findMember.getTeam();
        System.out.println("findMember:" + findMember);

    }
}
