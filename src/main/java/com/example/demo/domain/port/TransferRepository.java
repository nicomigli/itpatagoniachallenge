package com.example.demo.domain.port;
import java.util.List;

import com.example.demo.domain.model.Transfer;

public interface TransferRepository {
    List<Transfer> getTransfersLastMonth();
    void save(Transfer transfer);
}

