package com.spring.jwt.repository;

import com.spring.jwt.entity.WithdrawTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WithdrawRepo extends JpaRepository<WithdrawTransaction,Integer> {

//    @Query(value = "SELECT * FROM color_app.withdraw_transaction where withdraw_receiver_id = :getUserId AND withdraw_transactions_status = :withdrawStatus",nativeQuery = true)
//    List<WithdrawTransaction> findbyWithdrawStatus(@Param("withdrawStatus") String withdrawStatus,@Param("getUserId") String getUserId);
////      List<WithdrawTransaction> findbyWithdrawStatus(String withdrawStatus, String getUserId);



    @Query("SELECT wt FROM WithdrawTransaction wt WHERE wt.withdrawReceiverId = :withdrawReceiverId AND wt.withdrowStatus = :withdrowStatus")
    List<WithdrawTransaction> findbyWithdrawStatus(@Param("withdrowStatus") String withdrowStatus, @Param("withdrawReceiverId") String withdrawReceiverId);

    }