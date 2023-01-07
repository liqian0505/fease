package info.nemoworks.fease.repository.mongodb;

import info.nemoworks.fease.model.Contract;
import info.nemoworks.fease.model.Customer;
import info.nemoworks.fease.model.Entity;
import info.nemoworks.fease.repository.EntityRepository;
import info.nemoworks.fease.repository.mongodb.model.DocumentMapper;
import info.nemoworks.fease.repository.mongodb.model.ContractDocument;
import info.nemoworks.fease.repository.mongodb.model.CustomerDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentStorage implements EntityRepository {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Entity get(String id) {
        return null;
    }


    @Override
    public void delete(Entity entity) {

    }

    @Override
    public Entity save(Entity entity) {
        if (entity instanceof Contract) {
            ContractDocument contractDocument = DocumentMapper.INSTANCE.contractToContractDocument((Contract) entity);
            return DocumentMapper.INSTANCE.contractDocumentToContract(contractRepository.save(contractDocument));
        }
        if (entity instanceof Customer) {
            CustomerDocument customerDocument = DocumentMapper.INSTANCE.customerToCustomerDocument((Customer) entity);
            customerDocument = customerRepository.save(customerDocument);
            Customer customer = DocumentMapper.INSTANCE.customerDocumentToCustomer(customerDocument);
            return customer;
        }
        return null;
    }

    @Override
    public List<Entity> findAll() {
        return null;
    }
}