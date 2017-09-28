package org.tlh.springdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.tlh.springdata.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

	@Transactional
	@Modifying
	@Query("update User set userName=?1,password=?2 where id=?3")
	int updateUserInfo(String userName,String password,int id);

	//ͨ��spel-->���������ķ�ʽ
	@Transactional
	@Modifying
	@Query("update User set userName=:#{#user.userName},password=:#{#user.password} where id=:#{#user.id}")
	int updateUserInfo(@Param("user")User user);
	
	//ͨ��spel-->ռλ��
	@Transactional
	@Modifying
	@Query("delete from User where id=?#{[0]}")
	int deleteUserById(int id);
}
