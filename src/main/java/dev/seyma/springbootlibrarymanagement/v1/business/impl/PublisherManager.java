package dev.seyma.springbootlibrarymanagement.v1.business.impl;

import dev.seyma.springbootlibrarymanagement.v1.business.abstracts.IPublisherServices;
import dev.seyma.springbootlibrarymanagement.v1.core.expection.NotFoundException;
import dev.seyma.springbootlibrarymanagement.v1.core.utilities.Message;
import dev.seyma.springbootlibrarymanagement.v1.dao.PublisherRepository;
import dev.seyma.springbootlibrarymanagement.v1.entities.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherManager implements IPublisherServices {
    private final PublisherRepository publisherRepository;
    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        getId(publisher.getId());
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getId(long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND_MESSAGE));
    }

    @Override
    public Page<Publisher> cursor(int page, int pageSize) {
        return publisherRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        publisherRepository.delete(getId(id));
        return true;
    }
}