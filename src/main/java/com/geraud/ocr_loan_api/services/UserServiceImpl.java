package com.geraud.ocr_loan_api.services;

import com.geraud.ocr_loan_api.dao.UserDao;
import com.geraud.ocr_loan_api.domain.User;
import com.geraud.ocr_loan_api.exceptions.NoUserFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User findByEmailAndCardNumber(String email , String cardnumber) {
        Optional<User> user = userDao.findByEmailAndCardnumber(email,cardnumber);
        if (!user.isPresent()){
            throw new NoUserFound("Utilisateur non trouvé");
        }
        return user.get();
    }
}
