package com.research.service;

import com.research.exception.NotFoundException;
import com.research.model.ChannelStatus;
import com.research.model.TransactionChannel;
import com.research.repository.ChannelRepository;

import java.util.List;

public class ChannelService {

    private final ChannelRepository repository;

    public ChannelService(ChannelRepository repository) {
        this.repository = repository;
    }

    public void addChannel(TransactionChannel channel) {
        repository.save(channel);
    }

    public List<TransactionChannel> getAllChannels() {
        return repository.findAll();
    }

    public TransactionChannel getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Channel not found"));
    }

    public void openChannel(int id) {
        getById(id).setStatus(ChannelStatus.OPEN);
    }

    public void closeChannel(int id) {
        getById(id).setStatus(ChannelStatus.CLOSED);
    }
}
