package com.geraud.ocr_loan_api.services;

import com.geraud.ocr_loan_api.dao.LoanDao;
import com.geraud.ocr_loan_api.domain.Loan;
import com.geraud.ocr_loan_api.exceptions.LoanNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService{
    private final LoanDao loanDao;

    public LoanServiceImpl(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    @Override
    public Loan patchLoan(Long id, Loan loan) {

        // recherche du prêt à aprtir de son id, si non trouvé renvoi erreur
        Optional<Loan> foundLoan = loanDao.findById(id);
        if (!foundLoan.isPresent()){
            throw new LoanNotFoundException("Prêt non trouvé avec l'id : " + id);
        }
        //création du prêt à modifier
        Loan loanToModify = foundLoan.get();

        //vérification des 2 champs modifiable (date de retour et renouvellement période prêt) et attribution nouvelle valeur si nécessaire
        //création date retour sera à implémenter avec microservice des employés pour déclarer le retour du prêt
        if (loan.getBookBackDate() != null){
           loanToModify.setBookBackDate(loan.getBookBackDate());
        }
        //augmenter compteur de demande de prolongation de prêt (compteur plutot que booléen car si décide de permettre prolongation de prêt plusieurs fois par la suite
        if (loan.getRefreshEndingCounter() != 0) {
            loanToModify.setRefreshEndingCounter(loanToModify.getRefreshEndingCounter() + 1 );
        }

        loanDao.save(loanToModify);

        return loanToModify;
    }
}
