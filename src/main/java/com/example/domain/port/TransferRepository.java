package com.example.domain.port;
import java.util.List;

import com.example.domain.model.Transfer;

public interface TransferRepository {
    List<Transfer> getTransfersLastMonth();
    void save(Transfer transfer);
}

