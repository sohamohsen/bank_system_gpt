package com.research.repository;

import com.research.model.ScheduledTransfer;

public class ScheduledTransferRepository extends InMemoryBaseRepository<ScheduledTransfer> {

    @Override
    protected int getId(ScheduledTransfer entity) {
        return entity.getId();
    }
}
