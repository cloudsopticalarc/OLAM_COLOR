package com.spring.jwt.Interfaces;

import com.spring.jwt.dto.*;
import com.spring.jwt.entity.User;
import com.spring.jwt.entity.WithdrawTransaction;
import com.spring.jwt.exception.PageNotFoundException;
import com.spring.jwt.exception.UserNotFoundExceptions;
import com.spring.jwt.utils.BaseResponseDTO;

import java.util.List;

public interface UserService {
    BaseResponseDTO registerAccount(RegisterDto registerDto);

    User getByReferenceIdAdminRecharge(String referenceId);

    public String recharge(String postUserId, String getUserId,Float amount);

    String withdraw(String postUserId, String getUserId, Float amount);

    List<WithdrawTransaction> userNotificationList(String getUserId);

    String withdrawApprovalUserSide(Integer withdrawID);

    String cancelWithdraw(Integer withdrawID);

    User getByUserId(Integer userID);

    Boolean getStatusAfterWithdawProcced(String userRId);
}
