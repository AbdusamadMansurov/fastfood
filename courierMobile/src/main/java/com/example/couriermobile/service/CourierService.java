package com.example.couriermobile.service;

import com.example.couriermobile.dto.ApiResponse;
import com.example.couriermobile.entity.CourierActiveTable;
import com.example.couriermobile.entity.Deliver;
import com.example.couriermobile.entity.Order;
import com.example.couriermobile.entity.Worker;
import com.example.couriermobile.repository.CourierActiveTableRepository;
import com.example.couriermobile.repository.DeliverRepository;
import com.example.couriermobile.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourierService {

    final WorkerRepository workerRepository;
    final DeliverRepository deliverRepository;
    final CourierActiveTableRepository activeTableRepository;

    public ApiResponse editStatusCourier(Long id) {
        Optional<Worker> workerOptional = workerRepository.findById(id);
        if (workerOptional.isEmpty())
            ApiResponse.builder().success(false).message("Courier is not found!!!");
        Worker worker = workerOptional.get();
        CourierActiveTable activeTable = new CourierActiveTable();
        activeTable.setWorker(worker);
        activeTable.setActive(!worker.isActive());
        activeTableRepository.save(activeTable);
        return ApiResponse.builder().message("Status edited!!!").success(true).build();
    }

    public ApiResponse attachToCourier(Long workerId, Long deliverId) {
        Optional<Worker> workerOptional = workerRepository.findById(workerId);
        Optional<Deliver> deliverOptional = deliverRepository.findById(deliverId);
        if (deliverOptional.isPresent())
            return ApiResponse.builder().success(false).message("Bu buyurmani boshqa kurier oldi!!!").build();
        Deliver deliver = deliverOptional.get();
        Worker worker = workerOptional.get();
        deliver.setCourier(worker);
        deliverRepository.save(deliver);
        return ApiResponse.builder().success(true).message("Bu buyurma sizga biritirildi!!!").build();
    }


    public List<Deliver> getAllDelivers() {
        return deliverRepository.getDeliversByCourierIsNull();
    }
}
