package com.research.repository;

import com.research.model.TransactionChannel;

public class ChannelRepository extends InMemoryBaseRepository<TransactionChannel> {

    @Override
    protected int getId(TransactionChannel entity) {
        return entity.getId();
    }
}
