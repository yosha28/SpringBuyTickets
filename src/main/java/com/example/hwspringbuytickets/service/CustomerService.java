package com.example.hwspringbuytickets.service;

import com.example.hwspringbuytickets.dto.CustomerDto;
import com.example.hwspringbuytickets.dto.EventDto;
import com.example.hwspringbuytickets.model.Customer;
import com.example.hwspringbuytickets.model.Event;
import com.example.hwspringbuytickets.model.Place;
import com.example.hwspringbuytickets.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerService {
    private final ModelMapper mapper;
    private final CustomerRepository customerRepository;


    @Transactional
    public void saveCustomer(CustomerDto dto) {
        Customer customer = mapper.map(dto, Customer.class);
        customerRepository.save(customer);
    }

    public CustomerDto create(CustomerDto customerDto) {
        Customer entity = mapper.map(customerDto, Customer.class);
        customerRepository.save(entity);
        return mapper.map(entity, CustomerDto.class);
    }

    public CustomerDto findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(entity -> mapper.map(entity, CustomerDto.class)).orElse(null);
    }

    public CustomerDto getCustomerForEmail(String email) {
        Customer customer = customerRepository.getCustomerForEmail(email);
        return customer != null ? mapper.map(customer, CustomerDto.class) : null;
    }

}
