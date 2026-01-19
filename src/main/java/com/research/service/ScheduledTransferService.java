package com.research.service;

import com.research.exception.BusinessRuleViolationException;
import com.research.model.ScheduledTransfer;
import com.research.repository.ScheduledTransferRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ScheduledTransferService {

    private final ScheduledTransferRepository repository;

    public ScheduledTransferService(ScheduledTransferRepository repository) {
        this.repository = repository;
    }

    public void scheduleTransfer(ScheduledTransfer transfer) {
        repository.save(transfer);
    }

    public List<ScheduledTransfer> getAll() {
        return repository.findAll();
    }

    public void executeDueTransfers() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        for (ScheduledTransfer t : repository.findAll()) {
            if (t.getTransferDate().equals(today)
                    && now.isAfter(t.getTransferTime())) {

                if (t.getFromAccount().getBalance() < t.getAmount()) {
                    throw new BusinessRuleViolationException(
                            "Scheduled transfer failed: insufficient balance"
                    );
                }

                t.getFromAccount().setBalance(
                        t.getFromAccount().getBalance() - t.getAmount()
                );
                t.getToAccount().setBalance(
                        t.getToAccount().getBalance() + t.getAmount()
                );
            }
        }
    }
}
