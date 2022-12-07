package com.turkcell.TechnicalService.service.abstracts;

import java.util.List;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.dtos.user.responses.ListUserResponse;

public interface UserService {

	public DataResult<List<ListUserResponse>> getAll();
}
