package com.farvic.codesharingplatform.services;

import java.util.List;

import com.farvic.codesharingplatform.entities.Code;

public interface CodeService {

    Code findById(String id);

    void saveCode(Code code);

    List<Code> getLastTenCodes();
}
