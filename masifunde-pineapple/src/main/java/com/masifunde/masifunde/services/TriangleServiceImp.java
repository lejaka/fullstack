package com.masifunde.masifunde.services;

import com.masifunde.masifunde.models.Triangle;
import com.masifunde.masifunde.repository.TriangleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.transaction.Transactional;
import java.util.Optional;

@Service("TriangleService")
@Transactional
public class TriangleServiceImp implements TriangleService{
    @Autowired
    private TriangleRepo triangleRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(TriangleServiceImp.class);

    @Override
    public ResponseEntity<Triangle> saveOrUpdate(Triangle triangle){
        System.out.println("Is transaction open saveOrUpdate? "+ TransactionSynchronizationManager.isActualTransactionActive());
        ResponseEntity<Triangle> responseEntity = null;
        Optional<Triangle> optionalTriangle = triangleRepo.findById(triangle.getTriangleId());
        if(!optionalTriangle.isPresent()){
            System.out.println("Triangle with id "+ triangle.getTriangleId() +" was not found");
        }
        try{
            if(optionalTriangle.isPresent()){
                //Update shape details and return data
                responseEntity = triangleRepo.findById(triangle.getTriangleId())
                        .map(record -> {
                                record.setNameOfShape(triangle.getNameOfShape());
                                record.setRowsToPrint(triangle.getRowsToPrint());
                                record.setSymbolToPrint(triangle.getSymbolToPrint());
                                record.setCreatedDate(triangle.getCreatedDate());
                                Triangle updated = triangleRepo.save(record);
                            return ResponseEntity.ok().body(updated);

                        })
                        .orElse(ResponseEntity.notFound().build());
            }
            else{
                responseEntity = ResponseEntity.notFound().build();
            }

        }
        catch(RuntimeException e){
            LOGGER.error("Triangle update exception: ", e.getMessage());
        }
        return responseEntity;

    }

}
