package com.niyonsaba.pma.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.niyonsaba.pma.entities.UserAccount;

@Repository
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {

}
